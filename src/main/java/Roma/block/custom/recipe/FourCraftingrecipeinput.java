package Roma.block.custom.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.core.NonNullList;

public class FourCraftingrecipeinput implements RecipeInput {
    private final NonNullList<ItemStack> items; // 16-slot 4x4 grid

    public FourCraftingrecipeinput(NonNullList<ItemStack> items) {
        if (items.size() != 16)
            throw new IllegalArgumentException("Expected 16 items for 4x4 grid");
        this.items = items;
    }

    @Override
    public ItemStack getItem(int index) {
        return items.get(index);
    }

    @Override
    public int size() {
        return 16;
    }

    public int getWidth() {
        return 4;
    }

    public int getHeight() {
        return 4;
    }

    public NonNullList<ItemStack> getItems() {
        return items;
    }
}
