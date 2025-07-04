package Roma.block;

import Roma.block.custom.ModGrass;
import Roma.block.custom.ModSaplingBlock;
import Roma.item.Moditems;
import Roma.block.custom.ModFlammableRotatedPillarBlock;
import Roma.roma;
import Roma.worldgen.tree.ModTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, roma.MOD_ID);


    public static final RegistryObject<Block> MARBLE = registerBlock("marble",
            ()-> new DropExperienceBlock(UniformInt.of(50,60), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(75f).explosionResistance(16f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CYPRESSSAPLING = registerBlock("cypresssapling",
            () -> new SaplingBlock(ModTreeGrower.CYPRESS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));



    public static final RegistryObject<Block> CYPRESSLOG = registerBlock("cypresslog",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).strength(3f)));
    public static final RegistryObject<Block> CYPRESSWOOD = registerBlock("cypresswood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(3f)));
    public static final RegistryObject<Block> STRIPPEDCYPRESSLOG = registerBlock("strippedcypresslog",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).strength(3f)));
    public static final RegistryObject<Block> STRIPPEDCYPRESSWOOD = registerBlock("strippedcypresswood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).strength(3f)));



    public static final RegistryObject<Block> CYPRESSPLANKS = registerBlock("cypressplanks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> CYPRESSLEAVES = registerBlock("cypressleaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final RegistryObject<Block> GRASS = BLOCKS.register("grass",
            () -> new ModGrass(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)));
    public static final RegistryObject<Block> SAND = registerBlock("sand",
            ()-> new DropExperienceBlock(UniformInt.of(1,1), BlockBehaviour.Properties.ofFullCopy(Blocks.SAND)
                    .strength(2f).explosionResistance(1f)));
    public static final RegistryObject<Block> DIRT = registerBlock("dirt",
            ()-> new DropExperienceBlock(UniformInt.of(1,1), BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)
                    .strength(2f).explosionResistance(1f)));

    public static final RegistryObject<Block> ROCK = registerBlock("rock",
            ()-> new DropExperienceBlock(UniformInt.of(1,2), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(15f).explosionResistance(8f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> GRANITE = registerBlock("granite",
            ()-> new DropExperienceBlock(UniformInt.of(5,10),BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(60f).explosionResistance(15f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ALABASTER = registerBlock("alabaster",
            ()-> new DropExperienceBlock(UniformInt.of(20,30), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(45f).explosionResistance(10f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LIMESTONE = registerBlock("limestone",
            ()-> new DropExperienceBlock(UniformInt.of(3,4), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(30f).explosionResistance(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BASALT = registerBlock("basalt",
            ()-> new DropExperienceBlock(UniformInt.of(3,4), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(45f).explosionResistance(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> IRONORE = registerBlock("ironore",
            ()-> new DropExperienceBlock(UniformInt.of(3,4), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(45f).explosionResistance(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> GOLDORE = registerBlock("goldore",
            ()-> new DropExperienceBlock(UniformInt.of(3,4), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(45f).explosionResistance(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ALUMINUMORE = registerBlock("aluminumore",
            ()-> new DropExperienceBlock(UniformInt.of(3,4), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(30f).explosionResistance(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> COBALTORE = registerBlock("cobaltore",
            ()-> new DropExperienceBlock(UniformInt.of(3,4), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(60f).explosionResistance(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CHROMIUMORE = registerBlock("chromiumore",
            ()-> new DropExperienceBlock(UniformInt.of(3,4), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(90f).explosionResistance(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TINORE = registerBlock("tinore",
            ()-> new DropExperienceBlock(UniformInt.of(3,4), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(45f).explosionResistance(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ZINCORE = registerBlock("zincore",
            ()-> new DropExperienceBlock(UniformInt.of(3,4), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(45f).explosionResistance(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> COPPERORE = registerBlock("copperore",
            ()-> new DropExperienceBlock(UniformInt.of(3,4), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(30f).explosionResistance(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SILVERORE = registerBlock("silverore",
            ()-> new DropExperienceBlock(UniformInt.of(3,4), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(45f).explosionResistance(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PLATINUMORE = registerBlock("platinumore",
            ()-> new DropExperienceBlock(UniformInt.of(3,4), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(90f).explosionResistance(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> NICKELORE = registerBlock("nickelore",
            ()-> new DropExperienceBlock(UniformInt.of(3,4), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(75f).explosionResistance(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SUPERMARBLE = registerBlock("supermarble",
            ()-> new DropExperienceBlock(UniformInt.of(3,4), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(75f).explosionResistance(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SUPERMARBLETYONE = registerBlock("supermarbletyone",
            ()-> new DropExperienceBlock(UniformInt.of(3,4), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(75f).explosionResistance(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SUPERMARBLETYTWO = registerBlock("supermarbletytwo",
            ()-> new DropExperienceBlock(UniformInt.of(3,4), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(75f).explosionResistance(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SUPERMARBLETYTHREE = registerBlock("supermarbletythree",
            ()-> new DropExperienceBlock(UniformInt.of(3,4), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(75f).explosionResistance(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SUPERMARBLETYFOUR = registerBlock("supermarbletyfour",
            ()-> new DropExperienceBlock(UniformInt.of(3,4), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(75f).explosionResistance(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SUPERMARBLETYFIVE = registerBlock("supermarbletyfive",
            ()-> new DropExperienceBlock(UniformInt.of(3,4), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(75f).explosionResistance(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> COALORE = registerBlock("coalore",
            ()-> new DropExperienceBlock(UniformInt.of(3,4),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(20f)
                            .explosionResistance(5f)
                            .requiresCorrectToolForDrops()));






    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        Moditems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
