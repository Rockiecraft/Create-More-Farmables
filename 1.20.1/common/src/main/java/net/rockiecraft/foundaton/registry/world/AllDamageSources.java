package net.rockiecraft.foundaton.registry.world;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;
import net.rockiecraft.CreateMoreFarmables;

public final class AllDamageSources {

    public static final ResourceKey<DamageType> MOLTEN_ENDSTONE = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(CreateMoreFarmables.MOD_ID, "molten_endstone"));
    public static final ResourceKey<DamageType> LIQUID_REDSTONE = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(CreateMoreFarmables.MOD_ID, "liquid_redstone"));
    public static final ResourceKey<DamageType> LIQUID_QUARTZ = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(CreateMoreFarmables.MOD_ID, "liquid_quartz"));

    public static DamageSource create(Level level, ResourceKey<DamageType> key) {
        return new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(key));
    }
}
