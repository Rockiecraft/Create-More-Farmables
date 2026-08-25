package net.rockiecraft.v1_20_1.foundation.damagetypes;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.level.Level;

public final class AllDamageSources extends DamageSource {

    public static final DamageSource MOLTEN_ENDSTONE = new AllDamageSources("molten_endstone");
    public static final DamageSource LIQUID_QUARTZ = new AllDamageSources("liquid_quartz");
    public static final DamageSource LIQUID_REDSTONE = new AllDamageSources("liquid_redstone");

    public AllDamageSources(String name) {
        super(name);
    }

}
