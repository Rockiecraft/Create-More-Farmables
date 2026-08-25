package net.rockiecraft.v1_20_1.foundation.fluids.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.rockiecraft.v1_20_1.foundation.AllFluids;
import net.rockiecraft.v1_20_1.infrastructure.config.CreateMoreFarmablesConfig;
import net.rockiecraft.v1_20_1.foundation.alldamagetypes.AllDamageSources;
import dev.architectury.core.block.ArchitecturyLiquidBlock;

import java.util.function.Supplier;

// Liquid block for molten fluids (Quartz, Redstone, Endstone): handles entity damage, item incineration, and water contact transformations.
public class MoltenLiquidBlock extends ArchitecturyLiquidBlock {
    public MoltenLiquidBlock(Supplier<? extends FlowingFluid> fluid, Properties properties) {
        super(fluid, properties);
    }

    // Guards damage logic to run at most once per entity per tick, since entityInside() fires once per overlapped column.
    private static final java.util.Map<Entity, Long> LAST_TICK_PROCESSED = new java.util.WeakHashMap<>();

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
        // Actual fluid height, so entities floating above it don't take damage
        double fluidHeight = (double)pos.getY() + fluid.getHeight(level, pos);

        // Only trigger once the entity is actually touching the fluid
        if (entity.getY() <= fluidHeight + 0.05D) {
            // Same as vanilla lava: halve fall distance so there's no fall damage on top of the burn
            entity.fallDistance *= 0.5F;

            if (entity instanceof LivingEntity) {
                if (!level.isClientSide()) {
                    DamageSource source = getDamageSourceFor(level, fluid);
                    boolean fireImmune = entity.fireImmune();

                    // Same 15s ignition as vanilla lava; refreshed every tick while submerged
                    if (!fireImmune) {
                        entity.setSecondsOnFire(15);
                    }

                    // Double damage if fire-immune (chemical heat bypasses fire immunity)
                    float damage = 4.0f * (fireImmune ? 2.0f : 1.0f);
                    if (entity.hurt(source, damage)) {
                        entity.playSound(SoundEvents.GENERIC_BURN, 0.4F, 2.0F + level.random.nextFloat() * 0.4F);
                    }
                }
            }
            // Incinerate dropped items
            else if (entity instanceof ItemEntity item && !item.fireImmune()) {
                item.setSecondsOnFire(3);
                if (!level.isClientSide()) {
                    item.hurt(level.damageSources().lava(), 10.0F);
                    level.levelEvent(LevelEvent.LAVA_FIZZ, pos, 0);
                }
            }
        }
    }

    // Picks the damage source for the specific molten fluid touched, so death messages attribute correctly.
    private DamageSource getDamageSourceFor(Level level, FluidState fluid) {
        if (fluid.is(AllFluids.LIQUID_QUARTZ.source().get()) || fluid.is(AllFluids.LIQUID_QUARTZ.flowing().get())) {
            return AllDamageSources.create(level, AllDamageSources.LIQUID_QUARTZ);
        }
        if (fluid.is(AllFluids.LIQUID_REDSTONE.source().get()) || fluid.is(AllFluids.LIQUID_REDSTONE.flowing().get())) {
            return AllDamageSources.create(level, AllDamageSources.LIQUID_REDSTONE);
        }
        return AllDamageSources.create(level, AllDamageSources.MOLTEN_ENDSTONE);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        // Popping sounds & ember particles
        if (random.nextInt(100) == 0) {
            level.playLocalSound(
                    (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5,
                    SoundEvents.LAVA_POP, SoundSource.BLOCKS,
                    0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false
            );

            level.addParticle(ParticleTypes.LAVA,
                    (double)pos.getX() + random.nextDouble(),
                    (double)pos.getY() + 1.0,
                    (double)pos.getZ() + random.nextDouble(),
                    0.0, 0.0, 0.0
            );
        }

        // Ambient hiss loop
        if (random.nextInt(200) == 0) {
            level.playLocalSound(
                    (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5,
                    SoundEvents.LAVA_AMBIENT, SoundSource.BLOCKS,
                    0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false
            );
        }
    }

    // --- Block transformation on water contact ---

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        handleFluidTick(level, pos, state);
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        handleFluidTick(level, pos, state);
    }

    private void handleFluidTick(Level level, BlockPos pos, BlockState state) {
        // Schedule a fluid tick if no immediate interaction happened
        if (this.checkForInteractions(level, pos, state)) {
            level.scheduleTick(pos, state.getFluidState().getType(), state.getFluidState().getType().getTickDelay(level));
        }
    }

    private boolean checkForInteractions(Level level, BlockPos pos, BlockState state) {
        if (!CreateMoreFarmablesConfig.CreateMoreFarmables_fluid_interactions.toggleAllInteractions) return true;
        FluidState current = state.getFluidState();

        // Check all directions except up for water contact
        for (Direction dir : Direction.values()) {
            if (dir == Direction.UP) continue;
            BlockPos nPos = pos.relative(dir);
            FluidState nFluid = level.getFluidState(nPos);

            if (nFluid.is(Fluids.WATER) || nFluid.is(Fluids.FLOWING_WATER)) {
                String id = "";
                boolean en = false;

                if (current.is(AllFluids.LIQUID_QUARTZ.source().get()) || current.is(AllFluids.LIQUID_QUARTZ.flowing().get())) {
                    en = CreateMoreFarmablesConfig.CreateMoreFarmables_fluid_interactions.liquidQuartzInteraction;
                    id = CreateMoreFarmablesConfig.CreateMoreFarmables_fluid_interactions.liquidQuartzConversionBlock;
                }
                else if (current.is(AllFluids.MOLTEN_ENDSTONE.source().get()) || current.is(AllFluids.MOLTEN_ENDSTONE.flowing().get())) {
                    en = CreateMoreFarmablesConfig.CreateMoreFarmables_fluid_interactions.moltenEndstoneInteraction;
                    id = CreateMoreFarmablesConfig.CreateMoreFarmables_fluid_interactions.moltenEndstoneConversionBlock;
                }
                else if (current.is(AllFluids.LIQUID_REDSTONE.source().get()) || current.is(AllFluids.LIQUID_REDSTONE.flowing().get())) {
                    en = CreateMoreFarmablesConfig.CreateMoreFarmables_fluid_interactions.liquidRedstoneInteraction;
                    id = CreateMoreFarmablesConfig.CreateMoreFarmables_fluid_interactions.liquidRedstoneConversionBlock;
                }

                if (en && !id.isEmpty()) {
                    Block res = BuiltInRegistries.BLOCK.get(new ResourceLocation(id));
                    BlockState rs = (res != Blocks.AIR) ? res.defaultBlockState() : getFallback(current);

                    // Prevent infinite block-setting loops
                    if (level.getBlockState(nPos).is(rs.getBlock())) return true;

                    level.setBlockAndUpdate(nPos, rs);
                    level.levelEvent(LevelEvent.LAVA_FIZZ, nPos, 0);
                    return false;
                }
            }
        }
        return true;
    }

    private BlockState getFallback(FluidState f) {
        if (f.is(AllFluids.LIQUID_QUARTZ.source().get()) || f.is(AllFluids.LIQUID_QUARTZ.flowing().get()))
            return Blocks.DIORITE.defaultBlockState();

        if (f.is(AllFluids.LIQUID_REDSTONE.source().get()) || f.is(AllFluids.LIQUID_REDSTONE.flowing().get()))
            return Blocks.REDSTONE_BLOCK.defaultBlockState();

        if (f.is(AllFluids.MOLTEN_ENDSTONE.source().get()) || f.is(AllFluids.MOLTEN_ENDSTONE.flowing().get()))
            return Blocks.END_STONE.defaultBlockState();

        return Blocks.COBBLESTONE.defaultBlockState();
    }
}
