package Roma.worldgen.tree;

import Roma.roma;
import Roma.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrower {
    public static final TreeGrower CYPRESS = new TreeGrower(roma.MOD_ID + ":cypress",
            Optional.empty(), Optional.of(ModConfiguredFeatures.CYPRESS), Optional.empty());
}

