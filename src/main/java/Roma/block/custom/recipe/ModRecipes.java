package Roma.block.custom.recipe;


import Roma.roma;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, roma.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, roma.MOD_ID);

    public static final RegistryObject<RecipeSerializer<FourCraftingRecipe>> FOURCRAFTING_SERIALIZER =
            SERIALIZERS.register("fourcrafter", FourCraftingRecipe.Serializer::new);
    public static final RegistryObject<RecipeType<FourCraftingRecipe>> FOURCRAFTING_TYPE =
            TYPES.register("fourcrafter", () -> new RecipeType<FourCraftingRecipe>() {
                @Override
                public String toString() {
                    return "fourcrafter";
                }
            });


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
        eventBus.addListener((FMLCommonSetupEvent e) -> {
            e.enqueueWork(() -> {
                System.out.println("🍞 Registered FOURCRAFTING_TYPE: " + FOURCRAFTING_TYPE.get());
                System.out.println("🧾 Registered FOURCRAFTING_SERIALIZER: " + FOURCRAFTING_SERIALIZER.get());
            });
        });
    }
}