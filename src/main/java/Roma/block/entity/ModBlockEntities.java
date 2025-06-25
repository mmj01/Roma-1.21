package Roma.block.entity;

import Roma.block.ModBlocks;
import Roma.block.entity.custom.FourCraftingBlockEntity;
import Roma.roma;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, roma.MOD_ID);


    public static final RegistryObject<BlockEntityType<FourCraftingBlockEntity>> fourcraftingbe =
            BLOCK_ENTITIES.register("fourcraftingbe", () -> BlockEntityType.Builder.of(
                    FourCraftingBlockEntity::new, ModBlocks.FOURCRAFTING.get()).build(null));

    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }

}
