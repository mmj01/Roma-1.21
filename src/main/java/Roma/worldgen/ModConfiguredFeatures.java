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

        List<OreConfiguration.TargetBlockState> copperTargets = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.COPPERORE.get().defaultBlockState())
        );
        register(context, COPPER, Feature.ORE, new OreConfiguration(copperTargets, 16));

        List<OreConfiguration.TargetBlockState> aluminumTargets = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.ALUMINUMORE.get().defaultBlockState())
        );
        register(context, ALUMINUM, Feature.ORE, new OreConfiguration(aluminumTargets, 8));

        List<OreConfiguration.TargetBlockState> ironTargets = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.IRONORE.get().defaultBlockState())
        );
        register(context, IRON, Feature.ORE, new OreConfiguration(ironTargets, 9));

        List<OreConfiguration.TargetBlockState> cobaltTargets = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.COBALTORE.get().defaultBlockState())
        );
        register(context, COBALT, Feature.ORE, new OreConfiguration(cobaltTargets, 7));

        List<OreConfiguration.TargetBlockState> chromiumTargets = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.CHROMIUMORE.get().defaultBlockState())
        );
        register(context, CHROMIUM, Feature.ORE, new OreConfiguration(chromiumTargets, 7));

        List<OreConfiguration.TargetBlockState> platinumTargets = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.PLATINUMORE.get().defaultBlockState())
        );
        register(context, PLATINUM, Feature.ORE, new OreConfiguration(platinumTargets, 6));

        List<OreConfiguration.TargetBlockState> goldTargets = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.GOLDORE.get().defaultBlockState())
        );
        register(context, GOLD, Feature.ORE, new OreConfiguration(goldTargets, 8));

        List<OreConfiguration.TargetBlockState> tinTargets = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.TINORE.get().defaultBlockState())
        );
        register(context, TIN, Feature.ORE, new OreConfiguration(tinTargets, 10));

        List<OreConfiguration.TargetBlockState> silverTargets = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.SILVERORE.get().defaultBlockState())
        );
        register(context, SILVER, Feature.ORE, new OreConfiguration(silverTargets, 8));

        List<OreConfiguration.TargetBlockState> zincTargets = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.ZINCORE.get().defaultBlockState())
        );
        register(context, ZINC, Feature.ORE, new OreConfiguration(zincTargets, 9));

        List<OreConfiguration.TargetBlockState> nickelTargets = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.NICKELORE.get().defaultBlockState())
        );
        register(context, NICKEL, Feature.ORE, new OreConfiguration(nickelTargets, 7));
    }

}
