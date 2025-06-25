package Roma.block.entity.custom;

import Roma.block.custom.recipe.FourCraftingRecipe;
import Roma.block.custom.recipe.FourCraftingrecipeinput;
import Roma.block.custom.recipe.ModRecipes;
import Roma.block.entity.ModBlockEntities;
import Roma.screen.custom.FourCraftingmenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FourCraftingBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(17) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }

        @Override
        public boolean isItemValid(int slot, ItemStack stack) {
            return slot != 0;
        }
    };

    public ItemStackHandler getItemHandler() {
        return this.itemHandler;
    }

    private final LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.of(() -> itemHandler);

    public FourCraftingBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.fourcraftingbe.get(), pos, state);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler.invalidate();
        lazyItemHandler.cast();
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        tag.put("inventory", itemHandler.serializeNBT(registries));
        super.saveAdditional(tag, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        itemHandler.deserializeNBT(registries, tag.getCompound("inventory"));
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.roma.four_crafting");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory playerInventory, Player player) {
        return new FourCraftingmenu(containerId, playerInventory, this);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, FourCraftingBlockEntity entity) {
        if (level.isClientSide()) return;
        if (entity.hasRecipe()) {
            entity.craftItem();
        }
    }

    private void craftItem() {
        Optional<RecipeHolder<FourCraftingRecipe>> recipe = getCurrentRecipe();
        if (recipe.isEmpty()) return;

        ItemStack output = recipe.get().value().assemble(getRecipeInput(), level.registryAccess());
        for (int i = 1; i <= 16; i++) {
            itemHandler.extractItem(i, 1, false);
        }
        itemHandler.setStackInSlot(0, new ItemStack(output.getItem(),
                itemHandler.getStackInSlot(0).getCount() + output.getCount()));
    }

    private boolean hasRecipe() {
        Optional<RecipeHolder<FourCraftingRecipe>> recipe = getCurrentRecipe();
        if (recipe.isEmpty()) return false;

        ItemStack output = recipe.get().value().assemble(getRecipeInput(), level.registryAccess());
        return canInsertItemIntoOutputSlot(output) && canInsertAmountIntoOutputSlot(output.getCount());
    }

    private Optional<RecipeHolder<FourCraftingRecipe>> getCurrentRecipe() {
        List<ItemStack> inputs = new ArrayList<>();
        for (int i = 1; i <= 16; i++) {
            inputs.add(itemHandler.getStackInSlot(i));
        }
        FourCraftingrecipeinput input = FourCraftingrecipeinput.of(inputs);

        return level.getRecipeManager().getRecipeFor(ModRecipes.FOURCRAFTING_TYPE.get(), input, level);
    }

    private FourCraftingrecipeinput getRecipeInput() {
        List<ItemStack> inputs = new ArrayList<>();
        for (int i = 1; i <= 16; i++) {
            inputs.add(itemHandler.getStackInSlot(i));
        }
        return FourCraftingrecipeinput.of(inputs);
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return itemHandler.getStackInSlot(0).isEmpty() || itemHandler.getStackInSlot(0).is(output.getItem());
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        ItemStack outputSlot = itemHandler.getStackInSlot(0);
        return outputSlot.getCount() + count <= outputSlot.getMaxStackSize();
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return saveWithoutMetadata(registries);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}