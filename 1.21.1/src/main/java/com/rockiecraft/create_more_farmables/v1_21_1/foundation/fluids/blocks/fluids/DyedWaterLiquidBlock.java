package com.rockiecraft.create_more_farmables.v1_21_1.foundation.fluids.blocks.fluids;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.function.Supplier;

import com.rockiecraft.create_more_farmables.v1_21_1.infrastructure.config.CreateMoreFarmablesConfig;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;

public class DyedWaterLiquidBlock extends LiquidBlock {

    public DyedWaterLiquidBlock(Supplier<? extends FlowingFluid> fluid, Properties properties) {
        super(fluid.get(), properties);
    }

    private static final Map<Entity, Long> LAST_TOUCH_TICK = new WeakHashMap<>();
    private static final Map<Entity, Long> LAST_BUBBLE_TICK = new WeakHashMap<>();

    private static final double MAX_SINK_SPEED = -0.8D;

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        FluidState fluid = state.getFluidState();
        double surfaceY = (double) pos.getY() + fluid.getHeight(level, pos);

        applyBuoyancyAndDrag(entity);
        handleDyeing(state, level, pos, entity);

        long gameTime = level.getGameTime();
        Long lastTouchTick = LAST_TOUCH_TICK.get(entity);
        if (lastTouchTick != null && lastTouchTick == gameTime) {
            return;
        }

        boolean justEntered = lastTouchTick == null || gameTime - lastTouchTick > 1;
        LAST_TOUCH_TICK.put(entity, gameTime);

        if (justEntered) {
            spawnSplash(level, pos, entity, surfaceY);
        } else {
            maybeSpawnBubbleTrail(level, entity, gameTime);
        }
    }

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

        float intensity = Math.min(1.0f, (float) Math.sqrt(
            velocity.x * velocity.x * 0.2D + velocity.y * velocity.y + velocity.z * velocity.z * 0.2D) * 0.2f);
        float pitch = 1.0f + (level.random.nextFloat() - level.random.nextFloat()) * 0.4f;
        level.playSound(null, pos, SoundEvents.GENERIC_SPLASH, SoundSource.BLOCKS, intensity, pitch);

        if (!level.isClientSide)
            return;

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
        if (!level.isClientSide)
            return;

        Vec3 delta = entity.getDeltaMovement();
        boolean isMoving = delta.horizontalDistanceSqr() > 0.0025D || Math.abs(delta.y) > 0.02D;
        if (!isMoving)
            return;

        Long lastBubble = LAST_BUBBLE_TICK.get(entity);
        if (lastBubble != null && gameTime - lastBubble < 4) {
            return;
        }
        LAST_BUBBLE_TICK.put(entity, gameTime);

        level.addParticle(ParticleTypes.BUBBLE,
            entity.getX() + (level.random.nextDouble() - 0.5D) * entity.getBbWidth(),
            entity.getY() + entity.getBbHeight() * level.random.nextDouble(),
            entity.getZ() + (level.random.nextDouble() - 0.5D) * entity.getBbWidth(),
            0.0D, 0.04D, 0.0D);
    }

    private void handleDyeing(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!(entity instanceof ItemEntity item))
            return;
        if (level.isClientSide)
            return;
        if (!CreateMoreFarmablesConfig.CreateMoreFarmables_fluid_interactions.AllowFluidDyeing)
            return;

        FluidState fluid = state.getFluidState();
        String path = BuiltInRegistries.FLUID.getKey(fluid.getType())
            .getPath();

        DyeColor color = getColorFromPath(path);
        if (color == null)
            return;

        ItemStack stack = item.getItem();

        if (stack.has(DataComponents.DYED_COLOR)) {
            int val = color.getFireworkColor();
            DyedItemColor current = stack.get(DataComponents.DYED_COLOR);
            if (current == null || current.rgb() != val) {
                stack.set(DataComponents.DYED_COLOR, new DyedItemColor(val, true));
                level.levelEvent(LevelEvent.PARTICLES_WATER_EVAPORATING, pos, 0);
            }
        }

        else if (CreateMoreFarmablesConfig.CreateMoreFarmables_fluid_interactions.AllowBlockDyeing) {
            Block variant = getDyedVariant(stack.getItem(), color);
            if (variant != null && !stack.is(variant.asItem())) {
                item.setItem(new ItemStack(variant, stack.getCount()));
                level.levelEvent(LevelEvent.PARTICLES_WATER_EVAPORATING, pos, 0);
            }
        }
    }

    private DyeColor getColorFromPath(String path) {
        for (DyeColor c : DyeColor.values()) {
            if (path.contains(c.getName()))
                return c;
        }
        return null;
    }

    private Block getDyedVariant(Item item, DyeColor color) {
        ResourceLocation id = BuiltInRegistries.ITEM.getKey(item);
        String[] types = { "carpet", "bed", "stained_glass_pane", "concrete_powder", "stained_glass", "concrete", "terracotta", "wool" };

        for (String t : types) {
            if (id.getPath()
                .contains(t)) {
                Block res = BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(id.getNamespace(), color.getName() + "_" + t));
                if (res != Blocks.AIR)
                    return res;
            }
        }
        return null;
    }
}
