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

                
                //BLOCKS ->
                
                
                output.accept(ModBlocks.MARBLE.get());
                output.accept(ModBlocks.ROCK.get());
                output.accept(ModBlocks.BASALT.get());
                output.accept(ModBlocks.ALABASTER.get());
                output.accept(ModBlocks.LIMESTONE.get());
                output.accept(ModBlocks.GRANITE.get());

            }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
