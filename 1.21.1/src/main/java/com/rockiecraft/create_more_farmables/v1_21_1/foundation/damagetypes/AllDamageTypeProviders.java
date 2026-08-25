package com.rockiecraft.create_more_farmables.v1_21_1.foundation.damagetypes;

import com.rockiecraft.create_more_farmables.v1_21_1.CreateMoreFarmables;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class AllDamageTypeProviders {

    public static void bootstrap(BootstrapContext<DamageType> context) {
        context.register(AllDamageSources.MOLTEN_ENDSTONE,
                new DamageType(
                        "molten_endstone",
                        DamageScaling.ALWAYS,
                        0.1f,
                        DamageEffects.BURNING
                )
        );
    }

    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        RegistrySetBuilder builder = new RegistrySetBuilder()
                .add(Registries.DAMAGE_TYPE, AllDamageTypeProviders::bootstrap);

        generator.addProvider(event.includeServer(),
                new DatapackBuiltinEntriesProvider(output, lookupProvider, builder, Set.of(CreateMoreFarmables.MODID)));
    }
}
