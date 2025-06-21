package Roma.item;

import Roma.block.ModBlocks;
import Roma.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier STONE = new ForgeTier(
            300,3,3f,15,ModTags.HARDNESSB,()-> Ingredient.of(ModBlocks.ROCK.get()),ModTags.NHARDNESSB);
    public static final Tier WOOD = new ForgeTier(
            120,2,2f,10,ModTags.HardnessA,()-> Ingredient.EMPTY,ModTags.NHardnessA);

    public static final Tier COPPER = new ForgeTier(
            400,4,4f,20,ModTags.HARDNESSC,()-> Ingredient.of(ModBlocks.ROCK.get()),ModTags.NHARDNESSC);
    public static final Tier IRON = new ForgeTier(
            600,5,5f,25,ModTags.HARDNESSD,()-> Ingredient.of(ModBlocks.ROCK.get()),ModTags.NHARDNESSD);

    public static final Tier BRONZE = new ForgeTier(
            900,6,5f,30,ModTags.NHARDNESSD,()-> Ingredient.of(ModBlocks.ROCK.get()),ModTags.NHARDNESSD);
    public static final Tier BRASS = new ForgeTier(
            1200,7,5f,35,ModTags.HARDNESSE,()-> Ingredient.of(ModBlocks.ROCK.get()),ModTags.NHARDNESSE);

    public static final Tier LSTEEL = new ForgeTier(
            1500,8,6f,40,ModTags.HARDNESSF,()-> Ingredient.of(ModBlocks.ROCK.get()),ModTags.NHARDNESSF);
    public static final Tier HSTEEL = new ForgeTier(
            2000,8,7f,45,ModTags.HARDNESSG,()-> Ingredient.of(ModBlocks.ROCK.get()),ModTags.NHARDNESSG);

    public static final Tier SUPERALLOY = new ForgeTier(
            30000,12,10f,80,ModTags.HARDNESSG,()-> Ingredient.of(ModBlocks.ROCK.get()),ModTags.NHARDNESSG);



}
