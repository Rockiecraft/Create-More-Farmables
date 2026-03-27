package net.rockiecraft.foundaton.registry.config;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.rockiecraft.foundaton.registry.recipe.condition.IRecipeCondition;
import net.rockiecraft.foundaton.registry.recipe.condition.IRecipeConditionSerializer;

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
        return this.serializer;
    }

    public static class Serializer implements IRecipeConditionSerializer<ConfigRecipeCondition> {
        private final ResourceLocation id;
        private final Supplier<Boolean> master;
        private final Supplier<Boolean> item;

        public Serializer(ResourceLocation id, Supplier<Boolean> master, Supplier<Boolean> item) {
            this.id = id;
            this.master = master;
            this.item = item;
        }

        @Override
        public ConfigRecipeCondition readJson(JsonObject json) {
            // Pass the logic (master && item) and 'this' (the serializer)
            return new ConfigRecipeCondition(() -> master.get() && item.get(), this);
        }

        @Override
        public ResourceLocation getId() {
            return this.id;
        }

        @Override
        public void writeJson(JsonObject json, ConfigRecipeCondition condition) {}
    }
}

