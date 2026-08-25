package net.rockiecraft.v1_20_1.common.forge.recipe.forge;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.rockiecraft.v1_20_1.foundation.recipe.condition.IRecipeCondition;
import net.rockiecraft.v1_20_1.foundation.recipe.condition.IRecipeConditionSerializer;

public class RecipeConditionImpl implements ICondition {
    private final IRecipeCondition condition;

    public RecipeConditionImpl(IRecipeCondition condition) {
        this.condition = condition;
    }

    @Override
    public ResourceLocation getID() {
        return this.condition.getSerializer().getId();
    }

    @Override
    public boolean test(IContext context) {
        return this.condition.test();
    }

    public static class Serializer implements IConditionSerializer<RecipeConditionImpl> {

        private IRecipeConditionSerializer<IRecipeCondition> serializer;

        @SuppressWarnings("unchecked")
        public Serializer(IRecipeConditionSerializer<? extends IRecipeCondition> serializer) {
            this.serializer = (IRecipeConditionSerializer<IRecipeCondition>) serializer;
        }

        @Override
        public void write(JsonObject json, RecipeConditionImpl value) {
            this.serializer.writeJson(json, value.condition);
        }

        @Override
        public RecipeConditionImpl read(JsonObject json) {
            return new RecipeConditionImpl(this.serializer.readJson(json));
        }

        @Override
        public ResourceLocation getID() {
            return this.serializer.getId();
        }
    }
}
