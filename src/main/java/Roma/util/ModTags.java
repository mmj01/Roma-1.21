package Roma.util;

import Roma.roma;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {


        public static final TagKey<Block> WOOD = createTag("wood");
        public static final TagKey<Block> STONE = createTag("stone");
        public static final TagKey<Block> STONE_ORE_REPLACEABLES = createTag("stone_ore_replaceables");


        public static final TagKey<Block> NEEDSWOODENTOOL = createTag("needswoodentool");
        public static final TagKey<Block> NEEDSSTONETOOL = createTag("needsstonetool");
        public static final TagKey<Block> NEEDSCOPPERTOOL = createTag("needscoppertool");
        public static final TagKey<Block> NEEDSIRONTOOL = createTag("needsirontool");
        public static final TagKey<Block> NEEDSBRASSTOOL = createTag("needsbrasstool");
        public static final TagKey<Block> NEEDSBRONZETOOL = createTag("needsbronzetool");
        public static final TagKey<Block> NEEDSLSTEELTOOL = createTag("needslsteeltool");
        public static final TagKey<Block> NEEDSHSTEELTOOL = createTag("needshsteeltool");
        public static final TagKey<Block> NEEDSSUPERALLOYTOOL = createTag("needssuperalloytool");

        public static final TagKey<Block> INCORRECTFORWOODENTOOL = createTag("incorrectforwoodentool");
        public static final TagKey<Block> INCORRECTFORSTONETOOL = createTag("incorrectforstonetool");
        public static final TagKey<Block> INCORRECTFORCOPPERTOOL = createTag("incorrectforcoppertool");
        public static final TagKey<Block> INCORRECTFORIRONTOOL = createTag("incorrectforirontool");
        public static final TagKey<Block> INCORRECTFORBRASSTOOL = createTag("incorrectforbrasstool");
        public static final TagKey<Block> INCORRECTFORBRONZETOOL = createTag("incorrectforbronzetool");
        public static final TagKey<Block> INCORRECTFORLSTEELTOOL = createTag("incorrectforlsteeltool");
        public static final TagKey<Block> INCORRECTFORHSTEELTOOL = createTag("incorrectforhsteeltool");
        public static final TagKey<Block> INCORRECTFORSUPERALLOYTOOL = createTag("incorrectforsuperalloytool");

    }

    private static TagKey<Block> createTag(String name) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath(roma.MOD_ID, name));
    }



}
