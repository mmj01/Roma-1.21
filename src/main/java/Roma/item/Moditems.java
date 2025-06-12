package Roma.item;

import Roma.roma;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Moditems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, roma.MOD_ID);

    public static final RegistryObject<Item> IRONINGOT = ITEMS.register("ironingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COBALTINGOT = ITEMS.register("cobaltingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ALUMINUMINGOT = ITEMS.register("aluminumingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHROMIUMINGOT = ITEMS.register("chromiumingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPERNGOT = ITEMS.register("copperingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRONZEINGOT = ITEMS.register("bronzeingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STEELINGOT = ITEMS.register("steelingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TININGOT = ITEMS.register("tiningot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ZINCINGOT = ITEMS.register("zincingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLDINGOT = ITEMS.register("goldingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MARBLEVENEER = ITEMS.register("marbleveneer",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
