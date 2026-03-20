package net.rockiecraft.foundaton.registry.blocks;

import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageEffects;
import net.rockiecraft.foundaton.registry.AllDamageSources;

public class AllDamageTypeProviders {

    public static void bootstrap(BootstapContext<DamageType> context) {
        context.register(AllDamageSources.MOLTEN_ENDSTONE, new DamageType("molten_endstone", 0.1f, DamageEffects.BURNING));
    }
}
