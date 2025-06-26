package Roma.worldgen.Biome;


import Roma.roma;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes() {
    Regions.register(new ModOverworldRegion( ResourceLocation.fromNamespaceAndPath("overworld", roma.MOD_ID), 50));
    }
}