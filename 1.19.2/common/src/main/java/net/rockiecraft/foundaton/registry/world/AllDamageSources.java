package net.rockiecraft.foundaton.registry.world;

import net.minecraft.world.damagesource.DamageSource;

public final class AllDamageSources extends DamageSource {

  //  public static final ResourceKey<DamageType> MOLTEN_ENDSTONE = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(CreateMoreFarmables.MOD_ID, "molten_endstone"));
  //  public static final ResourceKey<DamageType> LIQUID_REDSTONE = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(CreateMoreFarmables.MOD_ID, "liquid_redstone"));
   // public static final ResourceKey<DamageType> LIQUID_QUARTZ = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(CreateMoreFarmables.MOD_ID, "liquid_quartz"));

    public static final DamageSource MOLTEN_ENDSTONE = new AllDamageSources("molten_endstone");

    public AllDamageSources(String name) {
        super(name);
    }
}
