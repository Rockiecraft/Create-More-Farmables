package com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.moltenblasting;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.jetbrains.annotations.Nullable;

import com.rockiecraft.create_more_farmables.v1_21_1.CreateMoreFarmables;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.AllFluids;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.damagetypes.AllDamageSources;
import com.simibubi.create.api.registry.CreateBuiltInRegistries;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import com.simibubi.create.foundation.recipe.RecipeApplier;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.Vec3;

public class MoltenBlastingFanProcessingType implements FanProcessingType {

    private static final int BASE_PRIORITY = 500;

    private static final Map<String, ResourceKey<DamageType>> DAMAGE_TYPES = Map.of(
        "molten_endstone", AllDamageSources.MOLTEN_ENDSTONE,
        "liquid_redstone", AllDamageSources.LIQUID_REDSTONE,
        "liquid_quartz", AllDamageSources.LIQUID_QUARTZ
    );

    private static final Map<String, MoltenBlastingFanProcessingType> ALL = new LinkedHashMap<>();

    static {
        int priority = BASE_PRIORITY;
        for (Map.Entry<String, AllFluids.FluidData> entry : AllFluids.MOLTEN_FLUIDS.entrySet())
            ALL.put(entry.getKey(), new MoltenBlastingFanProcessingType(entry.getKey(), entry.getValue(), priority++));
    }

    public static MoltenBlastingFanProcessingType forId(String id) {
        return ALL.get(id);
    }

    private final String id;
    private final ResourceLocation fluidId;
    private final int priority;
    private final AllFluids.FluidData fluid;

    private MoltenBlastingFanProcessingType(String id, AllFluids.FluidData fluid, int priority) {
        this.id = id;
        this.fluidId = CreateMoreFarmables.id(id);
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
        MoltenBlastingRecipeInput input = new MoltenBlastingRecipeInput(stack, fluidId);
        return MoltenBlastingRecipeType.MOLTEN_BLASTING.find(input, level)
            .isPresent();
    }

    @Override
    @Nullable
    public List<ItemStack> process(ItemStack stack, Level level) {
        MoltenBlastingRecipeInput input = new MoltenBlastingRecipeInput(stack, fluidId);
        Optional<RecipeHolder<MoltenBlastingRecipe>> recipe = MoltenBlastingRecipeType.MOLTEN_BLASTING.find(input, level);
        if (recipe.isPresent())
            return RecipeApplier.applyRecipeOn(level, stack, recipe.get()
                .value(), true);
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
        particleAccess.setColor(mixColors(0xFF4400, 0xFFAA33, random.nextFloat()));
        particleAccess.setAlpha(.6f);
        if (random.nextFloat() < 1 / 32f)
            particleAccess.spawnExtraParticle(ParticleTypes.FLAME, .25f);
    }

    @Override
    public void affectEntity(Entity entity, Level level) {
        if (level.isClientSide)
            return;
        if (entity.fireImmune())
            return;

        ResourceKey<DamageType> damageTypeKey = DAMAGE_TYPES.get(id);
        DamageSource source = damageTypeKey != null
            ? AllDamageSources.create(level, damageTypeKey)
            : level.damageSources().hotFloor();

        if (entity.isInvulnerableTo(source))
            return;

        boolean justIgnited = !entity.isOnFire();
        entity.igniteForSeconds(6);
        entity.hurt(source, 4);
        if (justIgnited)
            level.playSound(null, entity.blockPosition(), SoundEvents.FIRE_AMBIENT, SoundSource.NEUTRAL, 0.5F, 1.0F);
    }

    private static int mixColors(int colorA, int colorB, float t) {
        int ra = (colorA >> 16) & 0xFF, ga = (colorA >> 8) & 0xFF, ba = colorA & 0xFF;
        int rb = (colorB >> 16) & 0xFF, gb = (colorB >> 8) & 0xFF, bb = colorB & 0xFF;
        int r = (int) (ra + (rb - ra) * t);
        int g = (int) (ga + (gb - ga) * t);
        int b = (int) (ba + (bb - ba) * t);
        return (r << 16) | (g << 8) | b;
    }

    public static void register() {
        for (MoltenBlastingFanProcessingType type : ALL.values())
            Registry.register(CreateBuiltInRegistries.FAN_PROCESSING_TYPE,
                CreateMoreFarmables.id("molten_blasting_" + type.id), type);
    }
}
