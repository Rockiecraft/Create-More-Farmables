package com.rockiecraft.create_more_farmables.v1_21_1.foundation.fluids.blocks.fluids;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.function.Supplier;

import com.rockiecraft.create_more_farmables.v1_21_1.foundation.damagetypes.AllDamageSources;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

public abstract class AbstractMoltenLiquidBlock extends LiquidBlock {

    private static final Map<Entity, Long> LAST_TICK_PROCESSED = new WeakHashMap<>();

    private final ResourceKey<DamageType> damageType;

    protected AbstractMoltenLiquidBlock(Supplier<? extends FlowingFluid> fluid, Properties properties,
        ResourceKey<DamageType> damageType) {
        super(fluid.get(), properties);
        this.damageType = damageType;
    }

    protected abstract boolean isInteractionEnabled();

    protected abstract String getConversionBlockId();

    protected abstract BlockState getFallbackConversion();

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        long gameTime = level.getGameTime();
        Long lastTick = LAST_TICK_PROCESSED.get(entity);
        if (lastTick != null && lastTick == gameTime) {
            return;
        }
        LAST_TICK_PROCESSED.put(entity, gameTime);

        handleMoltenInteractions(state, level, pos, entity);
    }

    private void handleMoltenInteractions(BlockState state, Level level, BlockPos pos, Entity entity) {
        FluidState fluid = state.getFluidState();

        double fluidHeight = (double) pos.getY() + fluid.getHeight(level, pos);

        if (entity.getY() > fluidHeight + 0.05D) {
            return;
        }

        entity.fallDistance *= 0.5F;

        if (entity instanceof LivingEntity) {
            if (!level.isClientSide()) {
                DamageSource source = AllDamageSources.create(level, damageType);
                boolean fireImmune = entity.fireImmune();

                if (!fireImmune) {
                    entity.igniteForSeconds(15);
                }

                float damage = 4.0f * (fireImmune ? 2.0f : 1.0f);
                if (entity.hurt(source, damage)) {
                    entity.playSound(SoundEvents.GENERIC_BURN, 0.4F, 2.0F + level.random.nextFloat() * 0.4F);
                }
            }
        }

        else if (entity instanceof ItemEntity item && !item.fireImmune()) {
            item.igniteForSeconds(3);
            if (!level.isClientSide()) {
                item.hurt(level.damageSources()
                    .lava(), 10.0F);
                level.levelEvent(LevelEvent.LAVA_FIZZ, pos, 0);
            }
        }
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {

        if (random.nextInt(100) == 0) {
            level.playLocalSound(
                (double) pos.getX() + 0.5, (double) pos.getY() + 0.5, (double) pos.getZ() + 0.5,
                SoundEvents.LAVA_POP, SoundSource.BLOCKS,
                0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false
            );

            level.addParticle(ParticleTypes.LAVA,
                (double) pos.getX() + random.nextDouble(),
                (double) pos.getY() + 1.0,
                (double) pos.getZ() + random.nextDouble(),
                0.0, 0.0, 0.0
            );
        }

        if (random.nextInt(200) == 0) {
            level.playLocalSound(
                (double) pos.getX() + 0.5, (double) pos.getY() + 0.5, (double) pos.getZ() + 0.5,
                SoundEvents.LAVA_AMBIENT, SoundSource.BLOCKS,
                0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false
            );
        }
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        handleFluidTick(level, pos, state);
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        handleFluidTick(level, pos, state);
    }

    private void handleFluidTick(Level level, BlockPos pos, BlockState state) {

        if (this.checkForInteractions(level, pos, state)) {
            level.scheduleTick(pos, state.getFluidState()
                .getType(), state.getFluidState()
                .getType()
                .getTickDelay(level));
        }
    }

    private boolean checkForInteractions(Level level, BlockPos pos, BlockState state) {
        if (!isInteractionEnabled())
            return true;

        for (Direction dir : Direction.values()) {
            if (dir == Direction.UP)
                continue;
            BlockPos nPos = pos.relative(dir);
            FluidState nFluid = level.getFluidState(nPos);

            if (nFluid.is(Fluids.WATER) || nFluid.is(Fluids.FLOWING_WATER)) {
                String id = getConversionBlockId();
                if (id == null || id.isEmpty())
                    return true;

                Block res = BuiltInRegistries.BLOCK.get(ResourceLocation.parse(id));
                BlockState rs = (res != Blocks.AIR) ? res.defaultBlockState() : getFallbackConversion();

                if (level.getBlockState(nPos)
                    .is(rs.getBlock()))
                    return true;

                level.setBlockAndUpdate(nPos, rs);
                level.levelEvent(LevelEvent.LAVA_FIZZ, nPos, 0);
                return false;
            }
        }
        return true;
    }
}
