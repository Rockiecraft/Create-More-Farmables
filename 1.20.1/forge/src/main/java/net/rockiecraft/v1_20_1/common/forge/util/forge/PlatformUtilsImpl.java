package net.rockiecraft.v1_20_1.common.forge.util.forge;

import net.minecraftforge.common.crafting.CraftingHelper;
import net.rockiecraft.v1_20_1.common.forge.recipe.forge.RecipeConditionImpl;
import net.rockiecraft.v1_20_1.foundation.recipe.condition.IRecipeConditionSerializer;

public class PlatformUtilsImpl {

    public static void registerRecipeConditionSerializer(IRecipeConditionSerializer<?> recipeConditionSerializer) {
        CraftingHelper.register(new RecipeConditionImpl.Serializer(recipeConditionSerializer));
    }
}
