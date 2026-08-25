package net.rockiecraft.v1_20_1.foundation.alldamagetypes;

import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageEffects;

public class AllDamageTypeProviders {

    public static void bootstrap(BootstapContext<DamageType> context) {
        context.register(AllDamageSources.MOLTEN_ENDSTONE, new DamageType("molten_endstone", 0.1f, DamageEffects.BURNING));
        context.register(AllDamageSources.LIQUID_QUARTZ, new DamageType("liquid_quartz", 0.1f, DamageEffects.BURNING));
        context.register(AllDamageSources.LIQUID_REDSTONE, new DamageType("liquid_redstone", 0.1f, DamageEffects.BURNING));
        context.register(AllDamageSources.FAN_MOLTEN, new DamageType("fan_molten", 0.1f, DamageEffects.BURNING));
    }
}
