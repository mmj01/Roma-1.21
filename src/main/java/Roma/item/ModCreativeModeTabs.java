package Roma.item;

import Roma.block.ModBlocks;
import Roma.roma;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, roma.MOD_ID);

public static final RegistryObject<CreativeModeTab> ROMA = CREATIVE_MODE_TABS.register("roma",
    () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModBlocks.MARBLE.get()))
            .title(Component.translatable("ROMA"))
            .displayItems((itemDisplayParameters, output) ->{
                output.accept(Moditems.IRONINGOT.get());
                output.accept(Moditems.COBALTINGOT.get());
                output.accept(Moditems.ALUMINUMINGOT.get());
                output.accept(Moditems.CHROMIUMINGOT.get());
                output.accept(Moditems.COPPERNGOT.get());
                output.accept(Moditems.BRONZEINGOT.get());
                output.accept(Moditems.STEELINGOT.get());
                output.accept(Moditems.TININGOT.get());
                output.accept(Moditems.ZINCINGOT.get());
                output.accept(Moditems.GOLDINGOT.get());
                output.accept(Moditems.MARBLEVENEER.get());
                output.accept(Moditems.SUPERALLOYINGOT.get());
                output.accept(Moditems.SILVERINGOT.get());
                output.accept(Moditems.NICKELINGOT.get());
                output.accept(Moditems.PLATINUMINGOT.get());
                output.accept(Moditems.RAWALUMINUM.get());
                output.accept(Moditems.RAWCHROMIUM.get());
                output.accept(Moditems.RAWCOBALT.get());
                output.accept(Moditems.RAWGOLD.get());
                output.accept(Moditems.RAWIRON.get());
                output.accept(Moditems.RAWNICKEL.get());
                output.accept(Moditems.RAWCOPPER.get());
                output.accept(Moditems.RAWZINC.get());
                output.accept(Moditems.RAWTIN.get());
                output.accept(Moditems.RAWPLATINUM.get());
                output.accept(Moditems.RAWSILVER.get());

                
                //BLOCKS ->
                
                
                output.accept(ModBlocks.MARBLE.get());
                output.accept(ModBlocks.ROCK.get());
                output.accept(ModBlocks.BASALT.get());
                output.accept(ModBlocks.ALABASTER.get());
                output.accept(ModBlocks.LIMESTONE.get());
                output.accept(ModBlocks.GRANITE.get());
                output.accept(ModBlocks.IRONORE.get());
                output.accept(ModBlocks.TINORE.get());
                output.accept(ModBlocks.COBALTORE.get());
                output.accept(ModBlocks.ALUMINUMORE.get());
                output.accept(ModBlocks.CHROMIUMORE.get());
                output.accept(ModBlocks.NICKELORE.get());
                output.accept(ModBlocks.PLATINUMORE.get());
                output.accept(ModBlocks.SILVERORE.get());
                output.accept(ModBlocks.ZINCORE.get());
                output.accept(ModBlocks.GOLDORE.get());
                output.accept(ModBlocks.COPPERORE.get());
                output.accept(ModBlocks.COBALTORE.get());

            }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
