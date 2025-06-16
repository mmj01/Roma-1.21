package Roma.item;

import Roma.item.custom.chisel;
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
    public static final RegistryObject<Item> SILVERINGOT = ITEMS.register("silveringot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SUPERALLOYINGOT = ITEMS.register("superalloyingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NICKELINGOT = ITEMS.register("nickelingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATINUMINGOT = ITEMS.register("platinumingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAWPLATINUM = ITEMS.register("rawplatinum",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAWIRON = ITEMS.register("rawiron",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAWCOPPER = ITEMS.register("rawcopper",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAWZINC = ITEMS.register("rawzinc",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAWGOLD = ITEMS.register("rawgold",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAWNICKEL = ITEMS.register("rawnickel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAWSILVER = ITEMS.register("rawsilver",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAWTIN = ITEMS.register("rawtin",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAWCHROMIUM = ITEMS.register("rawchromium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAWCOBALT = ITEMS.register("rawcobalt",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAWALUMINUM = ITEMS.register("rawaluminum",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel",
            () -> new chisel(new Item.Properties().durability(400)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
