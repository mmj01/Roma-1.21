package Roma.block.entity.custom;

import Roma.block.custom.recipe.FourCraftingRecipe;
import Roma.block.custom.recipe.FourCraftingrecipeinput;
import Roma.block.custom.recipe.ModRecipes;
import Roma.block.entity.ModBlockEntities;
import Roma.screen.custom.FourCraftingmenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
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
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class FourCraftingBlockEntity extends BlockEntity implements MenuProvider {
    public static final int INPUT_SLOT_COUNT = 16;
    public static final int OUTPUT_SLOT = 16;
    public final ItemStackHandler itemHandler = new ItemStackHandler(17) {
        @Override
        protected void onContentsChanged(int slot) {
            //add somehow to match recipe?

            setChanged();
            //what does it do?
            if(!level.isClientSide()) {
                //updates gui
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };



    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 72;

    public FourCraftingBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.fourcraftingbe.get(), pPos, pBlockState);
        data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i) {
                    case 0 -> FourCraftingBlockEntity.this.progress;
                    case 1 -> FourCraftingBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int value) {
                switch (i) {
                    case 0: FourCraftingBlockEntity.this.progress = value;
                    case 1: FourCraftingBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
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
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        pTag.put("inventory", itemHandler.serializeNBT(pRegistries));
        pTag.putInt("four_crafting.progress", progress);
        pTag.putInt("four_crafting.max_progress", maxProgress);

        super.saveAdditional(pTag, pRegistries);
    }

    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);

        itemHandler.deserializeNBT(pRegistries, pTag.getCompound("inventory"));
        progress = pTag.getInt("four_crafting.progress");
        maxProgress = pTag.getInt("four_crafting.max_progress");
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.rma.fourcrafting");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new FourCraftingmenu(pContainerId, pPlayerInventory, this, this.data);
    }

    public void tick(Level level, BlockPos blockPos, BlockState blockState) {
        //make sure it can find the recipes using matches()
        if(hasRecipe()) {
            increaseCraftingProgress();
            setChanged(level, blockPos, blockState);

            if (hasCraftingFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private void resetProgress() {
        this.progress = 0;
        this.maxProgress = 72;
    }

    private void craftItem() {
        Optional<RecipeHolder<FourCraftingRecipe>> recipe = getCurrentRecipe();
        ItemStack output = recipe.get().value().output();

        for (int i = 0; i < INPUT_SLOT_COUNT; i++) {
            itemHandler.extractItem(i, 1, false);
        }

        itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(output.getItem(),
                itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + output.getCount()));
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }

    private boolean hasRecipe() {
        Optional<RecipeHolder<FourCraftingRecipe>> recipe = getCurrentRecipe();
        if(recipe.isEmpty()) {
            return false;
        }
        ItemStack output = recipe.get().value().output();
        return canInsertItemIntoOutputSlot(output) && canInsertAmountIntoOutputSlot(output.getCount());
    }

    private Optional<RecipeHolder<FourCraftingRecipe>> getCurrentRecipe() {
        NonNullList<ItemStack> inputItems = NonNullList.withSize(16, ItemStack.EMPTY);
        for (int i = 0; i < 16; i++) {
            inputItems.set(i, itemHandler.getStackInSlot(i));
        }
        return this.level.getRecipeManager()
                .getRecipeFor(ModRecipes.FOURCRAFTING_TYPE.get(), new FourCraftingrecipeinput(inputItems), level);
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        ItemStack current = itemHandler.getStackInSlot(OUTPUT_SLOT);
        return current.isEmpty() || current.getItem().equals(output.getItem());
    }

    private boolean canInsertAmountIntoOutputSlot(int amount) {
        ItemStack current = itemHandler.getStackInSlot(OUTPUT_SLOT);
        return current.getCount() + amount <= current.getMaxStackSize();
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        return saveWithoutMetadata(pRegistries);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public IItemHandler getItemHandler() {
        return itemHandler;
    }


}