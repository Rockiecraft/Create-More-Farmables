package net.rockiecraft.v1_20_1.foundation;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.rockiecraft.v1_20_1.CreateMoreFarmables;

public class AllBlocks {

    public static final ResourcefulRegistry<Block> BLOCKS = ResourcefulRegistries.create(BuiltInRegistries.BLOCK, CreateMoreFarmables.MOD_ID);

    // Fluid blocks are registered here too, but declared in AllFluids.java - see FluidTypeBuilder.

    public static final RegistryEntry<Block> WOOD_STRING_WOOL_BLOCK = BLOCKS.register("wood_string_wool_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));

    public static void init() {
        BLOCKS.init();
    }

}
