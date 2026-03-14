package net.rockiecraft.foundaton.registry.blocks.fluids;

import earth.terrarium.botarium.common.registry.fluid.BotariumLiquidBlock;
import earth.terrarium.botarium.common.registry.fluid.FluidData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.rockiecraft.foundaton.AllFluids;
import net.rockiecraft.foundaton.registry.AllDamageSources;

@SuppressWarnings("deprecation")
public class LiquidRedstoneLiquidBlock extends BotariumLiquidBlock {
    public LiquidRedstoneLiquidBlock(FluidData data, Properties properties) {
        super(data, properties);
    }

    @Override // Makes the liquid damage players and can make an overlay appear on the players screen
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity) {
           // entity.isInLava();
            entity.lavaHurt();
            if (!level.isClientSide()) {
                entity.setSharedFlagOnFire(false);
                entity.hurt(AllDamageSources.create(level, AllDamageSources.MOLTEN_ENDSTONE), 4 * (entity.fireImmune() ? 2 : 1));
            }
        }
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (this.shouldSpreadLiquid(level, pos, state)) {
            level.scheduleTick(pos, state.getFluidState().getType(), AllFluids.MOLTEN_ENDSTONE.get().getTickDelay(level));
        }
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if (this.shouldSpreadLiquid(level, pos, state)) {
            level.scheduleTick(pos, state.getFluidState().getType(), AllFluids.MOLTEN_ENDSTONE.get().getTickDelay(level));
        }
    }

    // Turn water fluids into Granite upon contact with liquid redstone
    private boolean shouldSpreadLiquid(Level level, BlockPos pos, BlockState state) {
        for (Direction direction : new Direction[]{Direction.DOWN, Direction.SOUTH, Direction.NORTH, Direction.EAST, Direction.WEST}) {
            BlockPos blockPos = pos.relative(direction.getOpposite());
            FluidState fluidState = level.getFluidState(blockPos);
            if (fluidState.is(Fluids.WATER) || fluidState.is(Fluids.FLOWING_WATER)) {
                level.setBlockAndUpdate(blockPos, Blocks.GRANITE .defaultBlockState());
                level.levelEvent(LevelEvent.LAVA_FIZZ, pos, 0);
                return false;
            }
        }
        return true;
    }
}
