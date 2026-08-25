package com.rockiecraft.create_more_farmables.v1_21_1.foundation.damagetypes;

import com.rockiecraft.create_more_farmables.v1_21_1.CreateMoreFarmables;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;

public final class AllDamageSources {

    public static final ResourceKey<DamageType> MOLTEN_ENDSTONE = ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(CreateMoreFarmables.MODID, "molten_endstone"));
    public static final ResourceKey<DamageType> LIQUID_REDSTONE = ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(CreateMoreFarmables.MODID, "liquid_redstone"));
    public static final ResourceKey<DamageType> LIQUID_QUARTZ = ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(CreateMoreFarmables.MODID, "liquid_quartz"));

    public static DamageSource create(Level level, ResourceKey<DamageType> key) {
        return new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(key));
    }
}
