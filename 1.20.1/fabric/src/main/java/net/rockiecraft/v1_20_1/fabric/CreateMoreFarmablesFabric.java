package net.rockiecraft.v1_20_1.fabric;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.rockiecraft.v1_20_1.CreateMoreFarmables;
import net.rockiecraft.v1_20_1.infrastructure.config.AllRecipeConditionSerializers;
import net.rockiecraft.v1_20_1.foundation.recipe.condition.IRecipeCondition;
import net.rockiecraft.v1_20_1.foundation.recipe.condition.IRecipeConditionSerializer;
import net.rockiecraft.v1_20_1.foundation.recipe.dyesplashing.DyeSplashingFanProcessingType;
import net.rockiecraft.v1_20_1.foundation.recipe.dyesplashing.DyeSplashingRecipeType;
import net.rockiecraft.v1_20_1.foundation.recipe.moltenblasting.MoltenBlastingFanProcessingType;
import net.rockiecraft.v1_20_1.foundation.recipe.moltenblasting.MoltenBlastingRecipeType;

public final class CreateMoreFarmablesFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // Config registration/saving now lives in common CreateMoreFarmables.init() (which also
        // forces AllRecipeConditionSerializers's static block to run) - unlike 1.19.2, this
        // loader no longer needs its own separate Configurator instance.
        CreateMoreFarmables.init();

        for (IRecipeConditionSerializer<? extends IRecipeCondition> serializer : AllRecipeConditionSerializers.getSerializers()) {
            ResourceConditions.register(serializer.getId(), (jsonObject) -> serializer.readJson(jsonObject).test());
        }

        // Needs Create on the classpath, which only forge/ and fabric/ depend on - see
        // common/build.gradle and CreateMoreFarmables.init() for why this isn't there anymore.
        DyeSplashingRecipeType.init();
        DyeSplashingFanProcessingType.register();
        MoltenBlastingRecipeType.init();
        MoltenBlastingFanProcessingType.register();
    }
}
