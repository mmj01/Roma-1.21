package Roma.util;

import Roma.roma;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static final TagKey<Block> WOOD = createTag("wood") ;
    public static final TagKey<Block> STONE = createTag("stone") ;
    public static final TagKey<Block> HOLDER = createTag("holder") ;


    public static final TagKey<Block> NEEDS_WOOD_TOOL = createTag("needswoodtool");
    public static final TagKey<Block> NEEDS_STONE_TOOL = createTag("needsstonetool");
    public static final TagKey<Block> NEEDS_IRON_TOOL = createTag("needsirontool");
    public static final TagKey<Block> NEEDS_BRASS_TOOL = createTag("needsbrasstool");
    public static final TagKey<Block> NEEDS_BRONZE_TOOL = createTag("needsbronzetool");
    public static final TagKey<Block> NEEDS_LSTEEL_TOOL = createTag("needslsteeltool");
    public static final TagKey<Block> NEEDS_HSTEEL_TOOL = createTag("needshsteeltool");
    public static final TagKey<Block> NEEDS_SUPERALLOY_TOOL = createTag("needssuperalloytool");
    public static final TagKey<Block> NEEDS_COPPER_TOOL = createTag("needscoppertool");








    private static TagKey<Block> createTag(String name) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath(roma.MOD_ID, name));
    }



}
