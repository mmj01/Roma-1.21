package Roma.dimension;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;

public class ModDimension {
    public static final ResourceKey<LevelStem> MY_DIMENSION =
            ResourceKey.create(Registries.LEVEL_STEM,
                    ResourceLocation.fromNamespaceAndPath("rma", "roma_dim"));

    public static final ResourceKey<DimensionType> MY_DIM_TYPE =
            ResourceKey.create(Registries.DIMENSION_TYPE,
                    ResourceLocation.fromNamespaceAndPath("rma", "roma_dim_type"));

    public static void register() {
        // No registration needed—JSON handles it.
    }
}
