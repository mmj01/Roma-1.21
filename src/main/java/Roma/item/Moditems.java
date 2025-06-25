package Roma.item;

import Roma.item.custom.FuelItem;
import Roma.item.custom.ReachItem;
import Roma.item.custom.chisel;
import Roma.roma;
import net.minecraft.world.item.*;
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
    public static final RegistryObject<Item> COPPERINGOT = ITEMS.register("copperingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRONZEINGOT = ITEMS.register("bronzeingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRASSINGOT = ITEMS.register("brassingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HSTEELINGOT = ITEMS.register("hsteelingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LSTEELINGOT = ITEMS.register("lsteelingot",
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
    public static final RegistryObject<Item> COAL = ITEMS.register("coal",
            () -> new FuelItem(new Item.Properties(), 1200));
    public static final RegistryObject<Item> WHEATSEEDS = ITEMS.register("wheatseeds",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WHEAT = ITEMS.register("wheat",
            () -> new Item(new Item.Properties().food(ModFoodProperties.WHEAT)));




    public static final RegistryObject<Item> IRONAXE = ITEMS.register("ironaxe",
            () -> new AxeItem(ModToolTiers.IRON,new Item.Properties()));
    public static final RegistryObject<Item> STONEAXE = ITEMS.register("stoneaxe",
            () -> new AxeItem(ModToolTiers.STONE,new Item.Properties()));
    public static final RegistryObject<Item> WOODAXE = ITEMS.register("woodaxe",
            () -> new AxeItem(ModToolTiers.WOOD,new Item.Properties()));
    public static final RegistryObject<Item> BRASSAXE = ITEMS.register("brassaxe",
            () -> new AxeItem(ModToolTiers.BRASS,new Item.Properties()));
    public static final RegistryObject<Item> HSTEELAXE = ITEMS.register("hsteelaxe",
            () -> new AxeItem(ModToolTiers.HSTEEL,new Item.Properties()));
    public static final RegistryObject<Item> SUPERALLOYAXE = ITEMS.register("superalloyaxe",
            () -> new AxeItem(ModToolTiers.SUPERALLOY,new Item.Properties()));

    public static final RegistryObject<Item> IRONSHOVEL = ITEMS.register("ironshovel",
            () -> new ShovelItem(ModToolTiers.IRON,new Item.Properties()));
    public static final RegistryObject<Item> STONESHOVEL = ITEMS.register("stoneshovel",
            () -> new ShovelItem(ModToolTiers.STONE,new Item.Properties()));
    public static final RegistryObject<Item> WOODSHOVEL = ITEMS.register("woodshovel",
            () -> new ShovelItem(ModToolTiers.WOOD,new Item.Properties()));
    public static final RegistryObject<Item> BRASSSHOVEL = ITEMS.register("brassshovel",
            () -> new ShovelItem(ModToolTiers.BRASS,new Item.Properties()));
    public static final RegistryObject<Item> HSTEELSHOVEL = ITEMS.register("hsteelshovel",
            () -> new ShovelItem(ModToolTiers.HSTEEL,new Item.Properties()));
    public static final RegistryObject<Item> SUPERALLOYSHOVEL = ITEMS.register("superalloyshovel",
            () -> new ShovelItem(ModToolTiers.SUPERALLOY,new Item.Properties()));

    public static final RegistryObject<Item> IRONPICKAXE = ITEMS.register("ironpickaxe",
            () -> new PickaxeItem(ModToolTiers.IRON,new Item.Properties()));
    public static final RegistryObject<Item> COPPERPICKAXE = ITEMS.register("copperpickaxe",
            () -> new PickaxeItem(ModToolTiers.COPPER,new Item.Properties()));
    public static final RegistryObject<Item> STONEPICKAXE = ITEMS.register("stonepickaxe",
            () -> new PickaxeItem(ModToolTiers.STONE,new Item.Properties()));
    public static final RegistryObject<Item> WOODPICKAXE = ITEMS.register("woodpickaxe",
            () -> new PickaxeItem(ModToolTiers.WOOD,new Item.Properties()));
    public static final RegistryObject<Item> BRASSPICKAXE = ITEMS.register("brasspickaxe",
            () -> new PickaxeItem(ModToolTiers.BRASS,new Item.Properties()));
    public static final RegistryObject<Item> BRONZEPICKAXE = ITEMS.register("bronzepickaxe",
            () -> new PickaxeItem(ModToolTiers.BRONZE,new Item.Properties()));
    public static final RegistryObject<Item> HSTEELPICKAXE = ITEMS.register("hsteelpickaxe",
            () -> new PickaxeItem(ModToolTiers.HSTEEL,new Item.Properties()));
    public static final RegistryObject<Item> LSTEELPICKAXE = ITEMS.register("lsteelpickaxe",
            () -> new PickaxeItem(ModToolTiers.LSTEEL,new Item.Properties()));
    public static final RegistryObject<Item> SUPERALLOYPICKAXE = ITEMS.register("superalloypickaxe",
            () -> new PickaxeItem(ModToolTiers.SUPERALLOY,new Item.Properties()));





    public static final RegistryObject<Item> IRONGREATSWORD = ITEMS.register("irongreatsword",
            () -> new ReachItem(ModToolTiers.IRON,4,-3,5.5,2.2,new Item.Properties()));

    public static final RegistryObject<Item> COPPERGREATSWORD = ITEMS.register("coppergreatsword",
            () -> new ReachItem(ModToolTiers.COPPER, 3,-3, 5.5, 2.2, new Item.Properties()));

    public static final RegistryObject<Item> STONEGREATSWORD = ITEMS.register("stonegreatsword",
            () -> new ReachItem(ModToolTiers.STONE,2,-3,5.5,2.4,new Item.Properties()));

    public static final RegistryObject<Item> WOODGREATSWORD = ITEMS.register("woodgreatsword",
            () -> new ReachItem(ModToolTiers.WOOD, 1,-2, 5.5, 2.0, new Item.Properties()));

    public static final RegistryObject<Item> BRONZEGREATSWORD = ITEMS.register("bronzegreatsword",
            () -> new ReachItem(ModToolTiers.BRONZE,6,-3,5.5,2.4,new Item.Properties()));

    public static final RegistryObject<Item> BRASSGREATSWORD = ITEMS.register("brassgreatsword",
            () -> new ReachItem(ModToolTiers.BRASS, 5,-3, 5.5, 2.4, new Item.Properties()));

    public static final RegistryObject<Item> LSTEELEGREATSWORD = ITEMS.register("lsteelgreatsword",
            () -> new ReachItem(ModToolTiers.LSTEEL,7,-3,5.5,2.6,new Item.Properties()));

    public static final RegistryObject<Item> HSTEELGREATSWORD = ITEMS.register("hsteelgreatsword",
            () -> new ReachItem(ModToolTiers.HSTEEL, 8,-3, 5.5, 2.6, new Item.Properties()));

    public static final RegistryObject<Item> SUPERALLOYGREATSWORD = ITEMS.register("superalloygreatsword",
            () -> new ReachItem(ModToolTiers.SUPERALLOY, 10,-3, 6, 3, new Item.Properties()));


    public static final RegistryObject<Item> IRONBATTLEAXE = ITEMS.register("ironbattleaxe",
            () -> new ReachItem(ModToolTiers.IRON,0,-2,4.5,2.2,new Item.Properties()));

    public static final RegistryObject<Item> COPPERBATTLEAXE = ITEMS.register("copperbattleaxe",
            () -> new ReachItem(ModToolTiers.COPPER, 0,-2, 4.5, 2.2, new Item.Properties()));

    public static final RegistryObject<Item> STONEBATTLEAXE = ITEMS.register("stonebattleaxe",
            () -> new ReachItem(ModToolTiers.STONE,0,-2,4.5,2.4,new Item.Properties()));

    public static final RegistryObject<Item> WOODBATTLEAXE = ITEMS.register("woodbattleaxe",
            () -> new ReachItem(ModToolTiers.WOOD, 0,-1, 4.5, 2.0, new Item.Properties()));

    public static final RegistryObject<Item> BRONZEBATTLEAXE = ITEMS.register("bronzebattleaxe",
            () -> new ReachItem(ModToolTiers.BRONZE,2,-2,4.5,2.4,new Item.Properties()));

    public static final RegistryObject<Item> BRASSBATTLEAXE = ITEMS.register("brassbattleaxe",
            () -> new ReachItem(ModToolTiers.BRASS, 1,-2, 4.5, 2.4, new Item.Properties()));

    public static final RegistryObject<Item> LSTEELEBATTLEAXE = ITEMS.register("lsteelbattleaxe",
            () -> new ReachItem(ModToolTiers.LSTEEL,3,-2,4.5,2.6,new Item.Properties()));

    public static final RegistryObject<Item> HSTEELBATTLEAXE = ITEMS.register("hsteelbattleaxe",
            () -> new ReachItem(ModToolTiers.HSTEEL, 4,-2, 4.5, 2.6, new Item.Properties()));

    public static final RegistryObject<Item> SUPERALLOYBATTLEAXE = ITEMS.register("superalloybattleaxe",
            () -> new ReachItem(ModToolTiers.SUPERALLOY, 6,-2, 5, 3, new Item.Properties()));







    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
