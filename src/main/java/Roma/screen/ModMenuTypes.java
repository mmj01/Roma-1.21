package Roma.screen;


import Roma.roma;
import Roma.screen.custom.FourCraftingmenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, roma.MOD_ID);



    public static final RegistryObject<MenuType<FourCraftingmenu>> FOURCRAFTINGMENU =
            MENUS.register("fourcraftingmenu", () -> IForgeMenuType.create(FourCraftingmenu::new));


    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}