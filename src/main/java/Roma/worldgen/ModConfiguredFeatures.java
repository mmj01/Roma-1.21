package Roma.worldgen;

import Roma.block.ModBlocks;
import Roma.roma;
import Roma.util.ModTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    private static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(name,roma.MOD_ID));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    public static final ResourceKey<ConfiguredFeature<?, ?>> ALUMINUM = registerKey("aluminum_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> IRON = registerKey("iron_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> COBALT = registerKey("cobalt_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHROMIUM = registerKey("chromium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PLATINUM = registerKey("platinum_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GOLD = registerKey("gold_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TIN = registerKey("tin_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER = registerKey("silver_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ZINC = registerKey("zinc_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NICKEL = registerKey("nickel_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> COPPER = registerKey("copper_ore");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(ModTags.Blocks.STONE_ORE_REPLACEABLES);

        register(context, COPPER, Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(stoneReplaceables, ModBlocks.COPPERORE.get().defaultBlockState())), 16));
        register(context, ALUMINUM, Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(stoneReplaceables, ModBlocks.ALUMINUMORE.get().defaultBlockState())), 8));
        register(context, IRON, Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(stoneReplaceables, ModBlocks.IRONORE.get().defaultBlockState())), 9));
        register(context, COBALT, Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(stoneReplaceables, ModBlocks.COBALTORE.get().defaultBlockState())), 7));
        register(context, CHROMIUM, Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(stoneReplaceables, ModBlocks.CHROMIUMORE.get().defaultBlockState())), 7));
        register(context, PLATINUM, Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(stoneReplaceables, ModBlocks.PLATINUMORE.get().defaultBlockState())), 6));
        register(context, GOLD, Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(stoneReplaceables, ModBlocks.GOLDORE.get().defaultBlockState())), 8));
        register(context, TIN, Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(stoneReplaceables, ModBlocks.TINORE.get().defaultBlockState())), 10));
        register(context, SILVER, Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(stoneReplaceables, ModBlocks.SILVERORE.get().defaultBlockState())), 8));
        register(context, ZINC, Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(stoneReplaceables, ModBlocks.ZINCORE.get().defaultBlockState())), 9));
        register(context, NICKEL, Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(stoneReplaceables, ModBlocks.NICKELORE.get().defaultBlockState())), 7));
    }
}
