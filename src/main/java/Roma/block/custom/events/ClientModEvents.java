package Roma.block.custom.events;

import Roma.roma;
import Roma.screen.ModMenuTypes;
import Roma.block.entity.custom.FourCraftingScreen;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = roma.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {


            MenuScreens.register(ModMenuTypes.FOURCRAFTINGMENU.get(), FourCraftingScreen::new);
        });
    }
}
