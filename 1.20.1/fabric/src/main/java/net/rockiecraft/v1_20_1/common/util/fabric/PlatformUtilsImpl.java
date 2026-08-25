package net.rockiecraft.v1_20_1.common.util.fabric;

import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.rockiecraft.v1_20_1.foundation.recipe.condition.IRecipeConditionSerializer;

public class PlatformUtilsImpl {

    public static void registerRecipeConditionSerializer(IRecipeConditionSerializer<?> recipeConditionSerializer) {
        ResourceConditions.register(recipeConditionSerializer.getId(), json -> recipeConditionSerializer.readJson(json).test());
    }
}
