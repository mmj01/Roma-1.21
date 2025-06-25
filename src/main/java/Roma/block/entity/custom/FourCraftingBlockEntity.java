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

import java.util.List;
import java.util.Optional;

public class FourCraftingBlockEntity extends BlockEntity implements MenuProvider {
    public final ItemStackHandler itemHandler = new ItemStackHandler(17) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }

        @Override
        public boolean isItemValid(int slot, @org.jetbrains.annotations.NotNull ItemStack stack) {
            // Prevent inserting into output slot (slot 0)
            return slot != 0;
        }
    };

    private static final int INPUT_SLOT = 1;
    private static final int OUTPUT_SLOT = 0;
    private static final int INPUT_SLOT2 = 2;
    private static final int INPUT_SLOT3 = 3;
    private static final int INPUT_SLOT4 = 4;
    private static final int INPUT_SLOT5 = 5;
    private static final int INPUT_SLOT6 = 6;
    private static final int INPUT_SLOT7 = 7;
    private static final int INPUT_SLOT8 = 8;
    private static final int INPUT_SLOT9 = 9;
    private static final int INPUT_SLOT10 = 10;
    private static final int INPUT_SLOT11 = 11;
    private static final int INPUT_SLOT12 = 12;
    private static final int INPUT_SLOT13 = 13;
    private static final int INPUT_SLOT14 = 14;
    private static final int INPUT_SLOT15 = 15;
    private static final int INPUT_SLOT16 = 16;



    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();




    public FourCraftingBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.fourcraftingbe.get(), pPos, pBlockState);


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


        super.saveAdditional(pTag, pRegistries);
    }

    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);

        itemHandler.deserializeNBT(pRegistries, pTag.getCompound("inventory"));

    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.rma.FourCrafting");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new FourCraftingmenu(pContainerId, pPlayerInventory,this);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, FourCraftingBlockEntity entity) {
        System.out.println("📋 All registered fourcrafter recipes:");
        level.getRecipeManager().getAllRecipesFor(ModRecipes.FOURCRAFTING_TYPE.get()).forEach(r -> {
            System.out.println(" - " + r.id());
        });
        if (level.isClientSide) return;

        if (entity.hasRecipe()) {
            entity.craftItem();
        }
    }



    private void craftItem() {
        Optional<RecipeHolder<FourCraftingRecipe>> recipe = getCurrentRecipe();
        ItemStack output = recipe.get().value().output();

        for (int i = 1; i <= 16; i++) {
            itemHandler.extractItem(i, 1, false);
        }
        itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(output.getItem(),
                itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + output.getCount()));
    }



    private boolean hasRecipe() {
        System.out.println("🧱 Current input stacks:");
        for (int i = 1; i <= 16; i++) {
            System.out.println("Slot " + i + ": " + itemHandler.getStackInSlot(i));
        }
        Optional<RecipeHolder<FourCraftingRecipe>> recipe = getCurrentRecipe();
        if(recipe.isEmpty()) {
            return false;
        }

        ItemStack output = recipe.get().value().output();
        return canInsertItemIntoOutputSlot(output) && canInsertAmountIntoOutputSlot(output.getCount());
    }

    private Optional<RecipeHolder<FourCraftingRecipe>> getCurrentRecipe() {
        List<ItemStack> inputStacks = List.of(
                itemHandler.getStackInSlot(1), itemHandler.getStackInSlot(2),
                itemHandler.getStackInSlot(3), itemHandler.getStackInSlot(4),
                itemHandler.getStackInSlot(5), itemHandler.getStackInSlot(6),
                itemHandler.getStackInSlot(7), itemHandler.getStackInSlot(8),
                itemHandler.getStackInSlot(9), itemHandler.getStackInSlot(10),
                itemHandler.getStackInSlot(11), itemHandler.getStackInSlot(12),
                itemHandler.getStackInSlot(13), itemHandler.getStackInSlot(14),
                itemHandler.getStackInSlot(15), itemHandler.getStackInSlot(16)
        );

        FourCraftingrecipeinput input = new FourCraftingrecipeinput(inputStacks);

        Optional<RecipeHolder<FourCraftingRecipe>> recipe = this.level.getRecipeManager()
                .getRecipeFor(ModRecipes.FOURCRAFTING_TYPE.get(), input, level);

        if (recipe.isPresent()) {
            System.out.println("✅ FourCrafting recipe matched: " + recipe.get().id());
        } else {
            System.out.println("❌ No matching FourCrafting recipe.");
        }

        return recipe;
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(OUTPUT_SLOT).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        int maxCount = itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() ? 64 : itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
        int currentCount = itemHandler.getStackInSlot(OUTPUT_SLOT).getCount();

        return maxCount >= currentCount + count;
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
}