package Roma.block.custom.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class FourCraftingRecipe implements Recipe<FourCraftingrecipeinput> {
    public static final int GRID_WIDTH = 4;
    public static final int GRID_HEIGHT = 4;

    private final NonNullList<Ingredient> ingredients;
    private final ItemStack result;

    public FourCraftingRecipe(NonNullList<Ingredient> ingredients, ItemStack result) {
        if (ingredients.size() != 16)
            throw new IllegalArgumentException("Expected 16 ingredients for a 4x4 recipe, got: " + ingredients.size());
        this.ingredients = ingredients;
        this.result = result;
    }

    @Override
    public boolean matches(FourCraftingrecipeinput container, Level level) {
        if (level.isClientSide()) return false;

        for (int y = 0; y < GRID_HEIGHT; y++) {
            for (int x = 0; x < GRID_WIDTH; x++) {
                int index = x + y * GRID_WIDTH;
                Ingredient expected = ingredients.get(index);
                ItemStack actual = container.getItem(index);
                if (!expected.test(actual)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public ItemStack assemble(FourCraftingrecipeinput container, HolderLookup.Provider registries) {
        return result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width >= GRID_WIDTH && height >= GRID_HEIGHT;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return result.copy();
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.FOURCRAFTING_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.FOURCRAFTING_TYPE.get();
    }

    // Serializer
    public static class Serializer implements RecipeSerializer<FourCraftingRecipe> {
        public static final MapCodec<FourCraftingRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.CODEC.listOf().fieldOf("ingredients").forGetter(FourCraftingRecipe::getIngredients),
                ItemStack.CODEC.fieldOf("result").forGetter(FourCraftingRecipe::getResultItemForCodec)
        ).apply(instance, (ingredientsList, result) -> {
            NonNullList<Ingredient> ingredients = NonNullList.create();
            ingredients.addAll(ingredientsList);
            return new FourCraftingRecipe(ingredients, result);
        }));

        private static final StreamCodec<RegistryFriendlyByteBuf, FourCraftingRecipe> STREAM_CODEC = StreamCodec.of(
                (buf, recipe) -> {
                    for (Ingredient ing : recipe.ingredients) {
                        Ingredient.CONTENTS_STREAM_CODEC.encode(buf, ing);
                    }
                    ItemStack.STREAM_CODEC.encode(buf, recipe.result);
                },
                buf -> {
                    NonNullList<Ingredient> ingredients = NonNullList.withSize(16, Ingredient.EMPTY);
                    for (int i = 0; i < 16; i++) {
                        ingredients.set(i, Ingredient.CONTENTS_STREAM_CODEC.decode(buf));
                    }
                    ItemStack result = ItemStack.STREAM_CODEC.decode(buf);
                    return new FourCraftingRecipe(ingredients, result);
                }
        );

        @Override
        public MapCodec<FourCraftingRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, FourCraftingRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }

    // Helper for Codec compatibility
    private ItemStack getResultItemForCodec() {
        return result;
    }
}
