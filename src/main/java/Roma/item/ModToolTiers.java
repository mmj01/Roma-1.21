package Roma.item;

import Roma.block.ModBlocks;
import Roma.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;


public class ModToolTiers {
    public static final Tier STONE = new ForgeTier(
            300,3,3f,15,ModTags.NEEDS_STONE_TOOL,()-> Ingredient.of(ModBlocks.ROCK.get()),ModTags.HOLDER);
    public static final Tier WOOD = new ForgeTier(
            120,2,2f,10,ModTags.NEEDS_WOOD_TOOL,()-> Ingredient.EMPTY,ModTags.HOLDER);

    public static final Tier COPPER = new ForgeTier(
            400,4,4f,20,ModTags.NEEDS_COPPER_TOOL,()-> Ingredient.of(ModBlocks.ROCK.get()),ModTags.HOLDER);
    public static final Tier IRON = new ForgeTier(
            600,5,5f,25,ModTags.NEEDS_IRON_TOOL,()-> Ingredient.of(Moditems.IRONINGOT.get()),ModTags.HOLDER);

    public static final Tier BRASS = new ForgeTier(
            900,6,5f,30,ModTags.NEEDS_BRASS_TOOL,()-> Ingredient.of(Moditems.BRASSINGOT.get()),ModTags.HOLDER);
    public static final Tier BRONZE = new ForgeTier(
            1200,7,5f,35,ModTags.NEEDS_BRONZE_TOOL,()-> Ingredient.of(Moditems.BRONZEINGOT.get()),ModTags.HOLDER);

    public static final Tier LSTEEL = new ForgeTier(
            1500,8,6f,40,ModTags.NEEDS_LSTEEL_TOOL,()-> Ingredient.EMPTY,ModTags.HOLDER);
    public static final Tier HSTEEL = new ForgeTier(
            2000,9,7f,45,ModTags.NEEDS_HSTEEL_TOOL,()-> Ingredient.EMPTY,ModTags.HOLDER);

    public static final Tier SUPERALLOY = new ForgeTier(
            30000,12,10f,80,ModTags.NEEDS_SUPERALLOY_TOOL,()-> Ingredient.of(Moditems.SUPERALLOYINGOT.get()),ModTags.HOLDER);



}
