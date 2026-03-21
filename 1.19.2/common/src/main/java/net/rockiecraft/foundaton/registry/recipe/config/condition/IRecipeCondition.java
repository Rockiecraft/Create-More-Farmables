package net.rockiecraft.foundaton.registry.recipe.config.condition;

public interface IRecipeCondition {

    IRecipeConditionSerializer<?> getSerializer();

    boolean test();
}
