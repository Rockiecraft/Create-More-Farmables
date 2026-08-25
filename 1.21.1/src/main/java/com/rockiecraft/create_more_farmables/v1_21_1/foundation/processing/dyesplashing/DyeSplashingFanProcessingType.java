package com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.dyesplashing;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.jetbrains.annotations.Nullable;

import com.rockiecraft.create_more_farmables.v1_21_1.CreateMoreFarmables;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.AllFluids;
import com.simibubi.create.api.registry.CreateBuiltInRegistries;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import com.simibubi.create.foundation.recipe.RecipeApplier;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.Vec3;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;

public class DyeSplashingFanProcessingType implements FanProcessingType {

    private static final int BASE_PRIORITY = 450;

    private static final Map<DyeColor, DyeSplashingFanProcessingType> ALL = new EnumMap<>(DyeColor.class);

    static {
        int priority = BASE_PRIORITY;
        for (DyeColor color : DyeColor.values())
            ALL.put(color, new DyeSplashingFanProcessingType(color, priority++));
    }

    public static DyeSplashingFanProcessingType forColor(DyeColor color) {
        return ALL.get(color);
    }

    private final DyeColor color;
    private final int priority;
    private final AllFluids.FluidData fluid;

    private DyeSplashingFanProcessingType(DyeColor color, int priority) {
        this.color = color;
        this.priority = priority;
        this.fluid = AllFluids.DYED_WATER_BY_COLOR.get(color);
    }

    public DyeColor getColor() {
        return color;
    }

    @Override
    public boolean isValidAt(Level level, BlockPos pos) {
        Fluid here = level.getFluidState(pos)
            .getType();
        return here == fluid.source()
            .get() || here == fluid.flowing()
            .get();
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public boolean canProcess(ItemStack stack, Level level) {
        DyeSplashingRecipeInput input = new DyeSplashingRecipeInput(stack, color);
        return DyeSplashingRecipeType.DYE_SPLASHING.find(input, level)
            .isPresent();
    }

    @Override
    @Nullable
    public List<ItemStack> process(ItemStack stack, Level level) {
        DyeSplashingRecipeInput input = new DyeSplashingRecipeInput(stack, color);
        Optional<RecipeHolder<DyeSplashingRecipe>> recipe = DyeSplashingRecipeType.DYE_SPLASHING.find(input, level);
        if (recipe.isPresent())
            return RecipeApplier.applyRecipeOn(level, stack, recipe.get()
                .value(), true);
        return null;
    }

    @Override
    public void spawnProcessingParticles(Level level, Vec3 pos) {
        if (level.random.nextInt(8) != 0)
            return;
        level.addParticle(ParticleTypes.SPIT, pos.x + (level.random.nextFloat() - .5f) * .5f, pos.y + .5f,
            pos.z + (level.random.nextFloat() - .5f) * .5f, 0, 1 / 8f, 0);
    }

    @Override
    public void morphAirFlow(AirFlowParticleAccess particleAccess, RandomSource random) {

        particleAccess.setColor(color.getFireworkColor());
        particleAccess.setAlpha(1f);
        if (random.nextFloat() < 1 / 32f)
            particleAccess.spawnExtraParticle(ParticleTypes.BUBBLE, .125f);
    }

    @Override
    public void affectEntity(Entity entity, Level level) {
        if (level.isClientSide)
            return;
        if (entity.isOnFire()) {
            entity.clearFire();
            level.playSound(null, entity.blockPosition(), SoundEvents.GENERIC_EXTINGUISH_FIRE, SoundSource.NEUTRAL,
                0.7F, 1.6F + (level.random.nextFloat() - level.random.nextFloat()) * 0.4F);
        }
    }

    public static void register() {
        for (DyeSplashingFanProcessingType type : ALL.values())
            Registry.register(CreateBuiltInRegistries.FAN_PROCESSING_TYPE,
                CreateMoreFarmables.id("dye_splashing_" + type.color.getName()), type);
    }
}
