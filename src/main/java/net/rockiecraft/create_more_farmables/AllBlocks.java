package net.rockiecraft.create_more_farmables;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class AllBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CreateMoreFarmables.ID);


    public static final RegistryObject<Block> WOOD_STRING_WOOL_BLOCK = BLOCKS.register("wood_string_wool_block",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.WHITE_WOOL)
                    .sound(SoundType.WOOL)
                    .mapColor(MapColor.COLOR_BROWN)
                    .ignitedByLava()
            ));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        return toReturn;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
