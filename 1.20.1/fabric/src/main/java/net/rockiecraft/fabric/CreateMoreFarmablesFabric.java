package net.rockiecraft.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.rockiecraft.CreateMoreFarmables;
import net.rockiecraft.foundaton.registry.recipe.condition.AllRecipeConditionSerializers;
import net.rockiecraft.foundaton.registry.recipe.condition.IRecipeCondition;
import net.rockiecraft.foundaton.registry.recipe.condition.IRecipeConditionSerializer;

public final class CreateMoreFarmablesFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        for (IRecipeConditionSerializer<? extends IRecipeCondition> serializer : AllRecipeConditionSerializers.getSerializers()) {
            ResourceConditions.register(serializer.getId(), (jsonObject) -> {
                return serializer.readJson(jsonObject).test();
            });
        }
        // Run our common setup.
        CreateMoreFarmables.init();
    }
}
