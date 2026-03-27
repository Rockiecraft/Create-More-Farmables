package net.rockiecraft.fabric;

import com.teamresourceful.resourcefulconfig.common.config.Configurator;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.rockiecraft.CreateMoreFarmables;
import net.rockiecraft.foundaton.registry.recipe.condition.AllRecipeConditionSerializers;
import net.rockiecraft.foundaton.registry.config.CreateMoreFarmablesConfig;
import net.rockiecraft.foundaton.registry.recipe.condition.IRecipeCondition;
import net.rockiecraft.foundaton.registry.recipe.condition.IRecipeConditionSerializer;

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
    }
}
