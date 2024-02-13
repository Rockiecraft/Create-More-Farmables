package net.rockiecraft.create_more_farmables.procedures;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class MoltenEndstoneEntityCollides {
    public static void execute(LevelAccessor world, Entity entity) {
        if(entity == null)
            return;
        entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.LAVA)), 1);
    }
}
