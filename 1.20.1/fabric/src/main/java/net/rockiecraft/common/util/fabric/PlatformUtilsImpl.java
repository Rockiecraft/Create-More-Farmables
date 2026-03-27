package net.rockiecraft.common.util.fabric;

import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.rockiecraft.foundaton.registry.recipe.condition.IRecipeConditionSerializer;

public class PlatformUtilsImpl {

    public static void registerRecipeConditionSerializer(IRecipeConditionSerializer<?> recipeConditionSerializer) {
        ResourceConditions.register(recipeConditionSerializer.getId(), json -> recipeConditionSerializer.readJson(json).test());
    }
}
