package Roma.item;

import Roma.roma;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import Roma.item.Moditems;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;



public class ModArmorMaterials{

    public static final Holder<ArmorMaterial> IRONARMORMATERIAL = register( "ironarmormaterial", Util.make(new EnumMap<>(ArmorItem.Type.class),
    attribute -> {
        attribute.put(ArmorItem.Type.BOOTS, 5);
        attribute.put(ArmorItem.Type.LEGGINGS, 7);
        attribute.put(ArmorItem.Type.CHESTPLATE, 9);
        attribute.put(ArmorItem.Type.HELMET, 5);
        attribute.put(ArmorItem.Type.BODY, 11);
    }), 5,  5,  0.1f, () -> Moditems.IRONINGOT.get());


    public static final Holder<ArmorMaterial> BRASSARMORMATERIAL = register("brassarmormaterial", Util.make(new EnumMap<>(ArmorItem.Type.class),
            attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 6);
                attribute.put(ArmorItem.Type.LEGGINGS, 8);
                attribute.put(ArmorItem.Type.CHESTPLATE, 10);
                attribute.put(ArmorItem.Type.HELMET, 6);
                attribute.put(ArmorItem.Type.BODY, 12);
            }), 15, 4, 0.1f, () -> Moditems.BRASSINGOT.get());


    public static final Holder<ArmorMaterial>COPPERARMORMATERIAL = register( "copperarmormaterial", Util.make(new EnumMap<>(ArmorItem.Type.class),
attribute -> {
                    attribute.put(ArmorItem.Type.BOOTS, 4);
                    attribute.put(ArmorItem.Type.LEGGINGS, 6);
                    attribute.put(ArmorItem.Type.CHESTPLATE, 8);
                    attribute.put(ArmorItem.Type.HELMET, 4);
                    attribute.put(ArmorItem.Type.BODY, 10);
                }), 15, 3f, 0.0f, () -> Moditems.COPPERINGOT.get());

    public static final Holder<ArmorMaterial> BRONZEARMORMATERIAL = register( "bronzearmormaterial", Util.make(new EnumMap<>(ArmorItem.Type.class),
            attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 7);
                attribute.put(ArmorItem.Type.LEGGINGS, 10);
                attribute.put(ArmorItem.Type.CHESTPLATE, 12);
                attribute.put(ArmorItem.Type.HELMET, 7);
                attribute.put(ArmorItem.Type.BODY, 13);
            }), 5,  6,  0.2f, () -> Moditems.BRONZEINGOT.get());


    public static final Holder<ArmorMaterial> LSTEELARMORMATERIAL = register("lsteelarmormaterial", Util.make(new EnumMap<>(ArmorItem.Type.class),
            attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 9);
                attribute.put(ArmorItem.Type.LEGGINGS, 12);
                attribute.put(ArmorItem.Type.CHESTPLATE, 14);
                attribute.put(ArmorItem.Type.HELMET, 9);
                attribute.put(ArmorItem.Type.BODY, 16);
            }), 15, 8f, 0.4f, () -> Moditems.LSTEELINGOT.get());


    public static final Holder<ArmorMaterial>HSTEELARMORMATERIAL = register( "hsteelarmormaterial", Util.make(new EnumMap<>(ArmorItem.Type.class),
            attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 10);
                attribute.put(ArmorItem.Type.LEGGINGS, 14);
                attribute.put(ArmorItem.Type.CHESTPLATE, 17);
                attribute.put(ArmorItem.Type.HELMET, 10);
                attribute.put(ArmorItem.Type.BODY, 18);
            }), 15, 9f, 0.5f, () -> Moditems.HSTEELINGOT.get());

    public static final Holder<ArmorMaterial>SUPERALLOYARMORMATIERAL = register( "superalloymaterial", Util.make(new EnumMap<>(ArmorItem.Type.class),
            attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 18);
                attribute.put(ArmorItem.Type.LEGGINGS, 23);
                attribute.put(ArmorItem.Type.CHESTPLATE, 26);
                attribute.put(ArmorItem.Type.HELMET, 18);
                attribute.put(ArmorItem.Type.BODY, 22);
            }), 15, 13f, 0.7f, () -> Moditems.SUPERALLOYINGOT.get());



    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> typeProtection, int enchantability, float toughness, float knockbackResistance,
                                                  Supplier<Item> ingredientItem) {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(roma.MOD_ID, name);
        Holder<SoundEvent> equipSound = SoundEvents.ARMOR_EQUIP_NETHERITE;
        Supplier<Ingredient> ingredient = () -> Ingredient.of(ingredientItem.get());
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));

        EnumMap<ArmorItem.Type, Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            typeMap.put(type, typeProtection.get(type));
        }


        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location,
                new ArmorMaterial(typeProtection, enchantability, equipSound, ingredient, layers, toughness, knockbackResistance));
    }

}