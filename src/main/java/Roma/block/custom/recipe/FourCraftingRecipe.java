package Roma.block.custom.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.List;

public record FourCraftingRecipe(int width, int height, NonNullList<Ingredient> ingredients, ItemStack output)
        implements Recipe<FourCraftingrecipeinput> {

    // Helper to construct from a List<Ingredient>
    public static FourCraftingRecipe fromValues(int width, int height, List<Ingredient> ingredients, ItemStack output) {
        return new FourCraftingRecipe(width, height, (NonNullList<Ingredient>) List.copyOf(ingredients), output);
    }

    @Override
    public boolean matches(FourCraftingrecipeinput input, net.minecraft.world.level.Level level) {
        if (level.isClientSide()) return false;
        for (int y = 0; y <= input.getHeight() - height; y++) {
            for (int x = 0; x <= input.getWidth() - width; x++) {
                if (matchesAt(input, x, y)) return true;
            }
        }
        return false;
    }

    private boolean matchesAt(FourCraftingrecipeinput input, int offsetX, int offsetY) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int recipeIndex = x + y * width;
                int inputIndex = (x + offsetX) + (y + offsetY) * input.getWidth();
                Ingredient expected = ingredients.get(recipeIndex);
                ItemStack actual = input.getItem(inputIndex);
                if (!expected.test(actual)) return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack assemble(FourCraftingrecipeinput input, HolderLookup.Provider registries) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int w, int h) {
        return w >= width && h >= height;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return output;
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
        // MapCodec for JSON: includes width, height, ingredients list, and result
        public static final MapCodec<FourCraftingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Codec.INT.fieldOf("width").forGetter(FourCraftingRecipe::width),
                Codec.INT.fieldOf("height").forGetter(FourCraftingRecipe::height),
                Ingredient.CODEC_NONEMPTY.listOf().fieldOf("ingredients").forGetter(FourCraftingRecipe::ingredients),
                ItemStack.CODEC.fieldOf("result").forGetter(FourCraftingRecipe::output)
        ).apply(inst, FourCraftingRecipe::fromValues));

        // StreamCodec for network: writes width, height, list of ingredients, then result
        public static final StreamCodec<RegistryFriendlyByteBuf, FourCraftingRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        ByteBufCodecs.VAR_INT, FourCraftingRecipe::width,
                        ByteBufCodecs.VAR_INT, FourCraftingRecipe::height,
                        // Stream the list of ingredients
                        Ingredient.CONTENTS_STREAM_CODEC.apply(ByteBufCodecs.list(16)), FourCraftingRecipe::ingredients,
                        ItemStack.STREAM_CODEC, FourCraftingRecipe::output,
                        FourCraftingRecipe::fromValues
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
