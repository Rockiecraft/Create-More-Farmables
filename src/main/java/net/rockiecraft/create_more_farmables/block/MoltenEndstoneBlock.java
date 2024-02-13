package net.rockiecraft.create_more_farmables.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.rockiecraft.create_more_farmables.AllFluids;
import net.rockiecraft.create_more_farmables.procedures.MoltenEndstoneEntityCollides;


public class MoltenEndstoneBlock extends LiquidBlock {
    public MoltenEndstoneBlock() {
        super(AllFluids.MOLTEN_ENDSTONE, BlockBehaviour.Properties.of().mapColor(MapColor.FIRE).strength(100f).lightLevel(s -> 13).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
    }
    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 3;
    }
    @Override
    public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
        super.entityInside(blockstate, world, pos, entity);
        MoltenEndstoneEntityCollides.execute(world, entity);
    }

}