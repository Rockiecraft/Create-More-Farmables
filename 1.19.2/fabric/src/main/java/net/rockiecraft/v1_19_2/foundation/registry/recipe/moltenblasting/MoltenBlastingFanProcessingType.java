package net.rockiecraft.v1_20_1.foundation.registry.recipe.moltenblasting;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.jetbrains.annotations.Nullable;

import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessingTypeRegistry;
import com.simibubi.create.foundation.recipe.RecipeApplier;
import com.simibubi.create.foundation.utility.Color;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.Vec3;
import net.rockiecraft.v1_19_2.CreateMoreFarmables;
import net.rockiecraft.v1_20_1.foundation.AllFluids;

public class MoltenBlastingFanProcessingType implements FanProcessingType {

    /** Create's own types use -1000000/100/200/300/400, DyeSplashing claims 450-465 - this claims 500+. */
    private static final int BASE_PRIORITY = 500;

    private static final DamageSource DAMAGE_SOURCE =
            new DamageSource("create_more_farmables.fan_molten").setScalesWithDifficulty().setIsFire();

    private static final Map<String, MoltenBlastingFanProcessingType> ALL = new LinkedHashMap<>();

    static {
        int priority = BASE_PRIORITY;
        for (Map.Entry<String, AllFluids.Registered> entry : AllFluids.MOLTEN_FLUIDS.entrySet())
            ALL.put(entry.getKey(), new MoltenBlastingFanProcessingType(entry.getKey(), entry.getValue(), priority++));
    }

    public static MoltenBlastingFanProcessingType forId(String id) {
        return ALL.get(id);
    }

    private final String id;
    private final ResourceLocation fluidId;
    private final int priority;
    private final AllFluids.Registered fluid;
    // One wrapper per fluid/instance (not static/shared) so simultaneous fan processing across
    // different molten fluids can't stomp on each other's in-flight recipe search.
    private final MoltenBlastingRecipe.MoltenBlastingWrapper wrapper = new MoltenBlastingRecipe.MoltenBlastingWrapper();

    private MoltenBlastingFanProcessingType(String id, AllFluids.Registered fluid, int priority) {
        this.id = id;
        this.fluidId = new ResourceLocation(CreateMoreFarmables.MOD_ID, id);
        this.fluid = fluid;
        this.priority = priority;
    }

    public ResourceLocation getFluidId() {
        return fluidId;
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
        wrapper.fluid = fluidId;
        return MoltenBlastingRecipeType.MOLTEN_BLASTING.find(wrapper, level)
            .isPresent();
    }

    @Override
    @Nullable
    public List<ItemStack> process(ItemStack stack, Level level) {
        wrapper.setItem(0, stack);
        wrapper.fluid = fluidId;
        Optional<MoltenBlastingRecipe> recipe = MoltenBlastingRecipeType.MOLTEN_BLASTING.find(wrapper, level);
        if (recipe.isPresent())
            return RecipeApplier.applyRecipeOn(stack, recipe.get());
        return null;
    }

    @Override
    public void spawnProcessingParticles(Level level, Vec3 pos) {
        if (level.random.nextInt(8) != 0)
            return;
        level.addParticle(ParticleTypes.LARGE_SMOKE, pos.x + (level.random.nextFloat() - .5f) * .5f, pos.y + .25f,
            pos.z + (level.random.nextFloat() - .5f) * .5f, 0, 1 / 16f, 0);
    }

    @Override
    public void morphAirFlow(AirFlowParticleAccess particleAccess, RandomSource random) {
        particleAccess.setColor(Color.mixColors(0xFF4400, 0xFFAA33, random.nextFloat()));
        particleAccess.setAlpha(.6f);
        if (random.nextFloat() < 1 / 32f)
            particleAccess.spawnExtraParticle(ParticleTypes.FLAME, .25f);
    }

    @Override
    public void affectEntity(Entity entity, Level level) {
        if (level.isClientSide)
            return;
        if (!entity.fireImmune()) {
            entity.setSecondsOnFire(6);
            entity.hurt(DAMAGE_SOURCE, 3);
            level.playSound(null, entity.blockPosition(), SoundEvents.FIRE_AMBIENT, SoundSource.NEUTRAL, 0.5F, 1.0F);
        }
    }

    public static void register() {
        for (MoltenBlastingFanProcessingType type : ALL.values())
            FanProcessingTypeRegistry.register(
                new ResourceLocation(CreateMoreFarmables.MOD_ID, "molten_blasting_" + type.id), type);
    }

}
