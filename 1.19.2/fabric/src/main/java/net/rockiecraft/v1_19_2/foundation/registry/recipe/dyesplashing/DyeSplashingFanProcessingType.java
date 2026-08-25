package net.rockiecraft.v1_20_1.foundation.registry.recipe.dyesplashing;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import net.rockiecraft.v1_19_2.CreateMoreFarmables;
import net.rockiecraft.v1_20_1.foundation.AllFluids;
import org.jetbrains.annotations.Nullable;

import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessingTypeRegistry;
import com.simibubi.create.foundation.recipe.RecipeApplier;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.Vec3;

public class DyeSplashingFanProcessingType implements FanProcessingType {

    /** Create's own types already use -1000000 (none), 100/200/300/400 - this claims 450-465. */
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
    private final AllFluids.Registered fluid;
    // One wrapper per color/instance (not static/shared) so simultaneous fan processing across
    // different colors can't stomp on each other's in-flight recipe search.
    private final DyeSplashingRecipe.DyeSplashingWrapper wrapper = new DyeSplashingRecipe.DyeSplashingWrapper();

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
        wrapper.setItem(0, stack);
        wrapper.color = color;
        return DyeSplashingRecipeType.DYE_SPLASHING.find(wrapper, level)
            .isPresent();
    }

    @Override
    @Nullable
    public List<ItemStack> process(ItemStack stack, Level level) {
        wrapper.setItem(0, stack);
        wrapper.color = color;
        Optional<DyeSplashingRecipe> recipe = DyeSplashingRecipeType.DYE_SPLASHING.find(wrapper, level);
        if (recipe.isPresent())
            return RecipeApplier.applyRecipeOn(stack, recipe.get());
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
        // getFireworkColor() is vanilla's own "what does this dye actually look like" RGB value
        // (used for firework star colors) - a closer match here than the placeholder hue array
        // the old single-instance version used, now that each instance IS one specific color.
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
            FanProcessingTypeRegistry.register(
                new ResourceLocation(CreateMoreFarmables.MOD_ID, "dye_splashing_" + type.color.getName()), type);
    }

}
