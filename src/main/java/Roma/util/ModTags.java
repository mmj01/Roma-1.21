package Roma.util;

import Roma.roma;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static final TagKey<Block> WOOD = createTag("wood") ;
    public static final TagKey<Block> STONE = createTag("stone") ;


    public static final TagKey<Block> HardnessA = createTag("hardnessa") ;
    public static final TagKey<Block> NHardnessA = createTag("nhardnessa");
    public static final TagKey<Block> HARDNESSB = createTag("hardnessb");
    public static final TagKey<Block> HARDNESSC = createTag("hardnessc");
    public static final TagKey<Block> HARDNESSD = createTag("hardnessd");
    public static final TagKey<Block> HARDNESSE = createTag("hardnesse");
    public static final TagKey<Block> HARDNESSF = createTag("hardnessf");
    public static final TagKey<Block> HARDNESSG = createTag("hardnessg");
    public static final TagKey<Block> NHARDNESSB = createTag("nhardnessb");
    public static final TagKey<Block> NHARDNESSC = createTag("nhardnessc");
    public static final TagKey<Block> NHARDNESSD = createTag("nhardnessd");
    public static final TagKey<Block> NHARDNESSE = createTag("nhardnesse");
    public static final TagKey<Block> NHARDNESSF = createTag("nhardnessf");
    public static final TagKey<Block> NHARDNESSG = createTag("nhardnessg");





    private static TagKey<Block> createTag(String name) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath(roma.MOD_ID, name));
    }



}
