package Roma.worldgen;

import Roma.roma;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {


    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    public static final ResourceKey<PlacedFeature> COPPER = registerKey("copper_ore_placed");
    public static final ResourceKey<PlacedFeature> ALUMINUM = registerKey("aluminum_ore_placed");
    public static final ResourceKey<PlacedFeature> IRON = registerKey("iron_ore_placed");
    public static final ResourceKey<PlacedFeature> COBALT = registerKey("cobalt_ore_placed");
    public static final ResourceKey<PlacedFeature> CHROMIUM = registerKey("chromium_ore_placed");
    public static final ResourceKey<PlacedFeature> PLATINUM = registerKey("platinum_ore_placed");
    public static final ResourceKey<PlacedFeature> GOLD = registerKey("gold_ore_placed");
    public static final ResourceKey<PlacedFeature> TIN = registerKey("tin_ore_placed");
    public static final ResourceKey<PlacedFeature> SILVER = registerKey("silver_ore_placed");
    public static final ResourceKey<PlacedFeature> ZINC = registerKey("zinc_ore_placed");
    public static final ResourceKey<PlacedFeature> NICKEL = registerKey("nickel_ore_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configured = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, COPPER, configured.getOrThrow(ModConfiguredFeatures.COPPER),
                ModOrePlacement.commonOrePlacement(17, HeightRangePlacement.triangle(VerticalAnchor.absolute(-192), VerticalAnchor.absolute(150))));
        register(context, ALUMINUM, configured.getOrThrow(ModConfiguredFeatures.ALUMINUM),
                ModOrePlacement.commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(-60), VerticalAnchor.absolute(128))));
        register(context, IRON, configured.getOrThrow(ModConfiguredFeatures.IRON),
                ModOrePlacement.commonOrePlacement(12, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, COBALT, configured.getOrThrow(ModConfiguredFeatures.COBALT),
                ModOrePlacement.commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.absolute(-48), VerticalAnchor.absolute(40))));
        register(context, CHROMIUM, configured.getOrThrow(ModConfiguredFeatures.CHROMIUM),
                ModOrePlacement.commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.absolute(-48), VerticalAnchor.absolute(40))));
        register(context, PLATINUM, configured.getOrThrow(ModConfiguredFeatures.PLATINUM),
                ModOrePlacement.commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(16))));
        register(context, GOLD, configured.getOrThrow(ModConfiguredFeatures.GOLD),
                ModOrePlacement.commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32))));
        register(context, TIN, configured.getOrThrow(ModConfiguredFeatures.TIN),
                ModOrePlacement.commonOrePlacement(12, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(96))));
        register(context, SILVER, configured.getOrThrow(ModConfiguredFeatures.SILVER),
                ModOrePlacement.commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(60))));
        register(context, ZINC, configured.getOrThrow(ModConfiguredFeatures.ZINC),
                ModOrePlacement.commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(70))));
        register(context, NICKEL, configured.getOrThrow(ModConfiguredFeatures.NICKEL),
                ModOrePlacement.commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(64))));
    }
    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(name,roma.MOD_ID));
    }
}