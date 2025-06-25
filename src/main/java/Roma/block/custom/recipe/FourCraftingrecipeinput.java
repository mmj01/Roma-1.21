package Roma.block.custom.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

import java.util.ArrayList;
import java.util.List;

public record FourCraftingrecipeinput(List<ItemStack> items) implements RecipeInput {


    public static FourCraftingrecipeinput of(List<ItemStack> rawItems) {
        return new FourCraftingrecipeinput(padTo16(rawItems));
    }

    private static List<ItemStack> padTo16(List<ItemStack> items) {
        if (items.size() > 16)
            throw new IllegalArgumentException("Cannot have more than 16 items for 4x4 crafting input");

        List<ItemStack> padded = new ArrayList<>(items);
        while (padded.size() < 16) {
            padded.add(ItemStack.EMPTY);
        }

        return padded;
    }

    @Override
    public ItemStack getItem(int index) {
        return items.get(index);
    }

    @Override
    public int size() {
        return 16;
    }
}