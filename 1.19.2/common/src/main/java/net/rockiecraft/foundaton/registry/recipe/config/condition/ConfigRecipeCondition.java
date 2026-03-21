package net.rockiecraft.foundaton.registry.recipe.config.condition;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.rockiecraft.foundaton.registry.AllRecipeConditionSerializers;
import net.rockiecraft.foundaton.registry.CreateMoreFarmablesConfig;


public record ConfigRecipeCondition() implements IRecipeCondition {

    @Override
    public boolean test() {
        // This links directly to your Resourceful Config field!
        return CreateMoreFarmablesConfig.Recipes.enableSpecialRecipe;
    }

    @Override
    public IRecipeConditionSerializer<? extends IRecipeCondition> getSerializer() {
        return AllRecipeConditionSerializers.CONFIG_CONDITION;
    }

    public static class Serializer implements IRecipeConditionSerializer<ConfigRecipeCondition> {
        // This is the ID you will use in your recipe JSONs
        private static final ResourceLocation ID = new ResourceLocation("create_more_farmables", "config_toggle");

        @Override
        public ConfigRecipeCondition readJson(JsonObject json) {
            return new ConfigRecipeCondition();
        }

        @Override
        public void writeJson(JsonObject json, ConfigRecipeCondition condition) {
            // No extra data needed in JSON for a simple toggle
        }

        @Override
        public ResourceLocation getId() {
            return ID;
        }
    }
}

