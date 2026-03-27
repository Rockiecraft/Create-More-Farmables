package net.rockiecraft.common.forge.util.forge;

import net.minecraftforge.common.crafting.CraftingHelper;
import net.rockiecraft.common.forge.recipe.forge.RecipeConditionImpl;
import net.rockiecraft.foundaton.registry.recipe.condition.IRecipeConditionSerializer;

public class PlatformUtilsImpl {

    public static void registerRecipeConditionSerializer(IRecipeConditionSerializer<?> recipeConditionSerializer) {
        CraftingHelper.register(new RecipeConditionImpl.Serializer(recipeConditionSerializer));
    }
}
