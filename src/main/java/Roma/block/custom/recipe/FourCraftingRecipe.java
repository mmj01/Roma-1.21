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

    private final NonNullList<Ingredient> ingredients;
    private final ItemStack result;

    public static final int GRID_WIDTH = 4;
    public static final int GRID_HEIGHT = 4;

    public FourCraftingRecipe(NonNullList<Ingredient> ingredients, ItemStack result) {
        this.ingredients = ingredients;
        this.result = result;

    }


    @Override
    public boolean matches(FourCraftingrecipeinput container, Level level) {
        System.out.println("🧪 FourCraftingRecipe.matches called");

        for (int y = 0; y < GRID_HEIGHT; y++) {
            for (int x = 0; x < GRID_WIDTH; x++) {
                int index = x + y * GRID_WIDTH;
                Ingredient expected = ingredients.get(index);
                ItemStack actual = container.getItem(index);

                boolean result = expected.test(actual);
                System.out.println("🔍 Slot " + index + ": expected=" + expected + ", actual=" + actual + " -> " + result);

                if (!result) return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack assemble(FourCraftingrecipeinput container, HolderLookup.Provider provider) {
        return result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width >= GRID_WIDTH && height >= GRID_HEIGHT;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
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

    public static class Serializer implements RecipeSerializer<FourCraftingRecipe> {

        public static final MapCodec<FourCraftingRecipe> CODEC = RecordCodecBuilder.mapCodec(builder -> builder.group(

                Ingredient.CODEC_NONEMPTY.listOf().fieldOf("ingredients").forGetter(r -> r.ingredients),
                ItemStack.CODEC.fieldOf("result").forGetter(r -> r.result)
        ).apply(builder, (ingredients, result) -> {
            if (ingredients.size() != GRID_WIDTH * GRID_HEIGHT) {
                throw new IllegalStateException("Expected 16 ingredients, got " + ingredients.size());

            }System.out.println("📦 FourCraftingRecipe codec deserializing recipe!");
            System.out.println("📦 FourCraftingRecipe codec deserializing recipe!");
            NonNullList<Ingredient> list = NonNullList.create();
            list.addAll(ingredients);
            return new FourCraftingRecipe(list, result);

        }));

        public static final StreamCodec<RegistryFriendlyByteBuf, FourCraftingRecipe> STREAM_CODEC = StreamCodec.of(
                (buf, recipe) -> {
                    for (int i = 0; i < GRID_WIDTH * GRID_HEIGHT; i++) {
                        Ingredient.CONTENTS_STREAM_CODEC.encode(buf, recipe.ingredients.get(i));
                    }
                    ItemStack.STREAM_CODEC.encode(buf, recipe.result);
                },
                buf -> {
                    NonNullList<Ingredient> ingredients = NonNullList.withSize(GRID_WIDTH * GRID_HEIGHT, Ingredient.EMPTY);
                    for (int i = 0; i < GRID_WIDTH * GRID_HEIGHT; i++) {
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
}
