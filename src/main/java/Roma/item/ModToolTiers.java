package Roma.item;

import Roma.block.ModBlocks;
import Roma.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;


public class ModToolTiers {
    public static final Tier STONE = new ForgeTier(
            300,3,3f,15,ModTags.Blocks.NEEDSSTONETOOL,()-> Ingredient.of(ModBlocks.ROCK.get(),ModBlocks.LIMESTONE.get(),ModBlocks.BASALT.get()),ModTags.Blocks.INCORRECTFORSTONETOOL);
    public static final Tier WOOD = new ForgeTier(
            120,2,2f,10,ModTags.Blocks.NEEDSWOODENTOOL,()-> Ingredient.EMPTY,ModTags.Blocks.INCORRECTFORWOODENTOOL);

    public static final Tier COPPER = new ForgeTier(
            400,4,4f,20,ModTags.Blocks.NEEDSCOPPERTOOL,()-> Ingredient.of(Moditems.COPPERINGOT.get()),ModTags.Blocks.INCORRECTFORCOPPERTOOL);
    public static final Tier IRON = new ForgeTier(
            600,5,5f,25,ModTags.Blocks.NEEDSIRONTOOL,()-> Ingredient.of(Moditems.IRONINGOT.get()),ModTags.Blocks.INCORRECTFORIRONTOOL);

    public static final Tier BRASS = new ForgeTier(
            900,6,5f,30,ModTags.Blocks.NEEDSBRASSTOOL,()-> Ingredient.of(Moditems.BRASSINGOT.get()),ModTags.Blocks.INCORRECTFORBRASSTOOL);
    public static final Tier BRONZE = new ForgeTier(
            1200,7,5f,35,ModTags.Blocks.NEEDSBRONZETOOL,()-> Ingredient.of(Moditems.BRONZEINGOT.get()),ModTags.Blocks.INCORRECTFORBRONZETOOL);

    public static final Tier LSTEEL = new ForgeTier(
            1500,8,6f,40,ModTags.Blocks.NEEDSLSTEELTOOL,()-> Ingredient.EMPTY,ModTags.Blocks.INCORRECTFORLSTEELTOOL);
    public static final Tier HSTEEL = new ForgeTier(
            2000,9,7f,45,ModTags.Blocks.NEEDSHSTEELTOOL,()-> Ingredient.EMPTY,ModTags.Blocks.INCORRECTFORHSTEELTOOL);

    public static final Tier SUPERALLOY = new ForgeTier(
            30000,12,10f,80,ModTags.Blocks.NEEDSSUPERALLOYTOOL,()-> Ingredient.of(Moditems.SUPERALLOYINGOT.get()),ModTags.Blocks.INCORRECTFORSUPERALLOYTOOL);



}
