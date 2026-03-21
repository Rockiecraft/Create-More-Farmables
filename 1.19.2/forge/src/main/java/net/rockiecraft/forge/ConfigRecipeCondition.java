package net.rockiecraft.forge;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.rockiecraft.foundaton.registry.MyConfig;

public class ConfigRecipeCondition implements ICondition {
    @SuppressWarnings("deprecation")
    public static final ResourceLocation ID = new ResourceLocation("create_more_farmables", "config_toggle");

    @Override public ResourceLocation getID() { return ID; }

    @Override
    public boolean test(IContext context) {
        return MyConfig.enableSpecialRecipe; // Accesses your common config
    }

    public static class Serializer implements IConditionSerializer<ConfigRecipeCondition> {
        public static final Serializer INSTANCE = new Serializer();
        @Override public void write(JsonObject json, ConfigRecipeCondition value) {}
        @Override public ConfigRecipeCondition read(JsonObject json) { return new ConfigRecipeCondition(); }
        @Override public ResourceLocation getID() { return ConfigRecipeCondition.ID; }
    }
}
