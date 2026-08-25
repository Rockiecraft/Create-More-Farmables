package net.rockiecraft.v1_20_1.foundation.recipe.condition;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

public record ConfigRecipeCondition(Supplier<Boolean> testSupplier, IRecipeConditionSerializer<ConfigRecipeCondition> serializer)
        implements IRecipeCondition {

    @Override
    public boolean test() {
        // This is what "calls" your config fields!
        return testSupplier.get();
    }

    @Override
    public IRecipeConditionSerializer<? extends IRecipeCondition> getSerializer() {
        return serializer;
    }

    public static class Serializer implements IRecipeConditionSerializer<ConfigRecipeCondition> {
        private final ResourceLocation id;
        private final Supplier<Boolean> master;
        // This Map stores all your color/item configs
        private final java.util.Map<String, Supplier<Boolean>> configMap;

        public Serializer(ResourceLocation id, Supplier<Boolean> master, java.util.Map<String, Supplier<Boolean>> configMap) {
            this.id = id;
            this.master = master;
            this.configMap = configMap;
        }

        @Override
        public ConfigRecipeCondition readJson(JsonObject json) {
            // Look for the "config" key in your recipe JSON
            String configKey = json.get("config").getAsString();
            Supplier<Boolean> itemConfig = configMap.getOrDefault(configKey, () -> false);

            return new ConfigRecipeCondition(() -> master.get() && itemConfig.get(), this);
        }

        @Override
        public ResourceLocation getId() { return this.id; }

        @Override
        public void writeJson(JsonObject json, ConfigRecipeCondition condition) {}
    }
}
