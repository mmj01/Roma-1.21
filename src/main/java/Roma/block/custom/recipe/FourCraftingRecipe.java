package Roma.block.custom.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public record FourCraftingRecipe(NonNullList<Ingredient> ingredients, ItemStack output)
        implements Recipe<FourCraftingrecipeinput> {

    @Override
    public boolean matches(FourCraftingrecipeinput container, Level level) {
        if (level.isClientSide()) {
            return false;
        }

        for (int i = 0; i < ingredients.size(); i++) {
            if (!ingredients.get(i).test(container.getItem(i))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public ItemStack assemble(FourCraftingrecipeinput container, HolderLookup.Provider registries) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width >= 4 && height >= 4;
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
        public static final MapCodec<FourCraftingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC.listOf().fieldOf("ingredients").forGetter(FourCraftingRecipe::ingredients),
                ItemStack.CODEC.fieldOf("result").forGetter(FourCraftingRecipe::output)
        ).apply(inst, (list, result) -> {
            if (list.size() != 16) {
                throw new IllegalArgumentException("FourCraftingRecipe requires exactly 16 ingredients, got " + list.size());
            }
            NonNullList<Ingredient> ingredients = NonNullList.create();
            ingredients.addAll(list);
            return new FourCraftingRecipe(ingredients, result);
        }));

        public static final StreamCodec<RegistryFriendlyByteBuf, FourCraftingRecipe> STREAM_CODEC =
                StreamCodec.of(
                        (buf, recipe) -> {
                            for (int i = 0; i < 16; i++) {
                                Ingredient.CONTENTS_STREAM_CODEC.encode(buf, recipe.ingredients.get(i));
                            }
                            ItemStack.STREAM_CODEC.encode(buf, recipe.output);
                        },
                        (buf) -> {
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
}
