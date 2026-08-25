package net.rockiecraft.v1_20_1.foundation.fluids.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.rockiecraft.v1_20_1.infrastructure.config.CreateMoreFarmablesConfig;
import dev.architectury.core.block.ArchitecturyLiquidBlock;

import java.util.function.Supplier;

// Liquid block for dyed water: splash/bubble effects, buoyancy, and dyeing items that touch it.
public class DyedWaterLiquidBlock extends ArchitecturyLiquidBlock {
    public DyedWaterLiquidBlock(Supplier<? extends FlowingFluid> fluid, Properties properties) {
        super(fluid, properties);
    }

    private static final java.util.Map<Entity, Long> LAST_TOUCH_TICK = new java.util.WeakHashMap<>();

    private static final java.util.Map<Entity, Long> LAST_BUBBLE_TICK = new java.util.WeakHashMap<>();

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        FluidState fluid = state.getFluidState();
        double surfaceY = (double) pos.getY() + fluid.getHeight(level, pos);

        applyBuoyancyAndDrag(entity);
        handleDyeing(state, level, pos, entity);

        long gameTime = level.getGameTime();
        Long lastTouchTick = LAST_TOUCH_TICK.get(entity);
        if (lastTouchTick != null && lastTouchTick == gameTime) {
            return; // already processed this entity this tick from another overlapping column
        }

        boolean justEntered = lastTouchTick == null || gameTime - lastTouchTick > 1;
        LAST_TOUCH_TICK.put(entity, gameTime);

        if (justEntered) {
            spawnSplash(level, pos, entity, surfaceY);
        } else {
            maybeSpawnBubbleTrail(level, entity, gameTime);
        }
    }

    // Roughly vanilla's steady-state sink rate in water, used as a clamp on downward velocity.
    private static final double MAX_SINK_SPEED = -0.8D;

    private void applyBuoyancyAndDrag(Entity entity) {
        if (entity instanceof ItemEntity) {
            applyItemBuoyancy(entity);
        } else {
            applyLivingWaterResistance(entity);
        }
    }

    private void applyItemBuoyancy(Entity entity) {
        Vec3 delta = entity.getDeltaMovement();
        double newY = delta.y + (delta.y < 0.06D ? 5.0E-4D : 0.0D);
        entity.setDeltaMovement(delta.x * 0.99D, newY, delta.z * 0.99D);
    }

    private void applyLivingWaterResistance(Entity entity) {
        Vec3 delta = entity.getDeltaMovement();
        double dragX = delta.x * 1.0D;
        double dragZ = delta.z * 1.0D;
        double dragY = Math.max(delta.y * 0.96D, MAX_SINK_SPEED);

        entity.setDeltaMovement(dragX, dragY, dragZ);
    }

    private void spawnSplash(Level level, BlockPos pos, Entity entity, double surfaceY) {
        Vec3 velocity = entity.getDeltaMovement();

        // Scales splash intensity by velocity magnitude, matching vanilla
        float intensity = Math.min(1.0f, (float) Math.sqrt(
                velocity.x * velocity.x * 0.2D + velocity.y * velocity.y + velocity.z * velocity.z * 0.2D) * 0.2f);
        float pitch = 1.0f + (level.random.nextFloat() - level.random.nextFloat()) * 0.4f;
        level.playSound(null, pos, SoundEvents.GENERIC_SPLASH, SoundSource.BLOCKS, intensity, pitch);

        if (!level.isClientSide) return;

        int particleCount = (int) (1.0f + entity.getBbWidth() * 20.0f);

        for (int i = 0; i < particleCount; i++) {
            double ox = (level.random.nextDouble() * 2.0D - 1.0D) * entity.getBbWidth();
            double oz = (level.random.nextDouble() * 2.0D - 1.0D) * entity.getBbWidth();
            level.addParticle(ParticleTypes.BUBBLE,
                    entity.getX() + ox, surfaceY, entity.getZ() + oz,
                    velocity.x, velocity.y - level.random.nextDouble() * 0.2D, velocity.z);
        }

        for (int i = 0; i < particleCount; i++) {
            double ox = (level.random.nextDouble() * 2.0D - 1.0D) * entity.getBbWidth();
            double oz = (level.random.nextDouble() * 2.0D - 1.0D) * entity.getBbWidth();
            level.addParticle(ParticleTypes.SPLASH,
                    entity.getX() + ox, surfaceY, entity.getZ() + oz,
                    velocity.x, velocity.y, velocity.z);
        }
    }
    private void maybeSpawnBubbleTrail(Level level, Entity entity, long gameTime) {
        if (!level.isClientSide) return;

        Vec3 delta = entity.getDeltaMovement();
        boolean isMoving = delta.horizontalDistanceSqr() > 0.0025D || Math.abs(delta.y) > 0.02D;
        if (!isMoving) return;

        Long lastBubble = LAST_BUBBLE_TICK.get(entity);
        if (lastBubble != null && gameTime - lastBubble < 4) {
            return; // throttle to roughly once every 4 ticks per entity
        }
        LAST_BUBBLE_TICK.put(entity, gameTime);

        level.addParticle(ParticleTypes.BUBBLE,
                entity.getX() + (level.random.nextDouble() - 0.5D) * entity.getBbWidth(),
                entity.getY() + entity.getBbHeight() * level.random.nextDouble(),
                entity.getZ() + (level.random.nextDouble() - 0.5D) * entity.getBbWidth(),
                0.0D, 0.04D, 0.0D);
    }

    private void handleDyeing(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!(entity instanceof ItemEntity item)) return;
        if (level.isClientSide) return;
        if (!CreateMoreFarmablesConfig.CreateMoreFarmables_fluid_interactions.allowFluidDyeing) return;

        FluidState fluid = state.getFluidState();
        String path = BuiltInRegistries.FLUID.getKey(fluid.getType()).getPath(); // e.g., "red_dyed_water"

        DyeColor color = getColorFromPath(path);
        if (color == null) return;

        ItemStack stack = item.getItem();
        // Leather armor uses the standard vanilla dyeable interface
        if (stack.getItem() instanceof DyeableLeatherItem dyeable) {
            int val = color.getFireworkColor();
            if (dyeable.getColor(stack) != val) {
                dyeable.setColor(stack, val);
                level.levelEvent(LevelEvent.PARTICLES_WATER_EVAPORATING, pos, 0);
            }
        }
        // Blocks (wool, glass, concrete, etc.) are dyed by swapping registry names
        else if (CreateMoreFarmablesConfig.CreateMoreFarmables_fluid_interactions.allowBlockDyeing) {
            Block variant = getDyedVariant(stack.getItem(), color);
            if (variant != null && !stack.is(variant.asItem())) {
                item.setItem(new ItemStack(variant, stack.getCount()));
                level.levelEvent(LevelEvent.PARTICLES_WATER_EVAPORATING, pos, 0);
            }
        }
    }

    // Extracts the DyeColor from the fluid's registry path.
    private DyeColor getColorFromPath(String path) {
        for (DyeColor c : DyeColor.values()) {
            if (path.contains(c.getName())) return c;
        }
        return null;
    }

    // Finds a colored variant of a block by swapping its color prefix, e.g. "white_wool" + RED -> "red_wool".
    private Block getDyedVariant(net.minecraft.world.item.Item item, DyeColor color) {
        ResourceLocation id = BuiltInRegistries.ITEM.getKey(item);
        String[] types = {"carpet", "bed", "stained_glass_pane", "concrete_powder", "stained_glass", "concrete", "terracotta", "wool"};

        for (String t : types) {
            if (id.getPath().contains(t)) {
                Block res = BuiltInRegistries.BLOCK.get(new ResourceLocation(id.getNamespace(), color.getName() + "_" + t));
                if (res != Blocks.AIR) return res;
            }
        }
        return null;
    }
}
