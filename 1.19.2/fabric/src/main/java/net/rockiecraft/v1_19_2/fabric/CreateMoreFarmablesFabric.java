package net.rockiecraft.v1_19_2.fabric;

import com.teamresourceful.resourcefulconfig.common.config.Configurator;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.rockiecraft.v1_19_2.CreateMoreFarmables;
import net.rockiecraft.v1_20_1.infrastructure.config.AllRecipeConditionSerializers;
import net.rockiecraft.v1_20_1.infrastructure.config.CreateMoreFarmablesConfig;
import net.rockiecraft.v1_20_1.foundation.recipe.condition.IRecipeCondition;
import net.rockiecraft.v1_20_1.foundation.recipe.condition.IRecipeConditionSerializer;
import net.rockiecraft.v1_20_1.foundation.registry.recipe.dyesplashing.DyeSplashingFanProcessingType;
import net.rockiecraft.v1_20_1.foundation.registry.recipe.dyesplashing.DyeSplashingRecipeType;
import net.rockiecraft.v1_20_1.foundation.registry.recipe.moltenblasting.MoltenBlastingFanProcessingType;
import net.rockiecraft.v1_20_1.foundation.registry.recipe.moltenblasting.MoltenBlastingRecipeType;

public final class CreateMoreFarmablesFabric implements ModInitializer {
    public static final Configurator CONFIGURATOR = new Configurator(true);
    @Override
    public void onInitialize() {

        CONFIGURATOR.registerConfig(CreateMoreFarmablesConfig.class);
        for (IRecipeConditionSerializer<? extends IRecipeCondition> serializer : AllRecipeConditionSerializers.getSerializers()) {
            ResourceConditions.register(serializer.getId(), (jsonObject) -> {
                return serializer.readJson(jsonObject).test();
            });
        }
        CreateMoreFarmables.init();
        // Needs Create on the classpath, which only forge/ and fabric/ depend on - see
        // common/build.gradle and CreateMoreFarmables.init() for why this isn't there anymore
        DyeSplashingRecipeType.init();
        DyeSplashingFanProcessingType.register();
        MoltenBlastingRecipeType.init();
        MoltenBlastingFanProcessingType.register();
    }
}
