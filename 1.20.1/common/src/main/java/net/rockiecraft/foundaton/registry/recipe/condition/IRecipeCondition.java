package net.rockiecraft.foundaton.registry.recipe.condition;

public interface IRecipeCondition {

    IRecipeConditionSerializer<?> getSerializer();

    boolean test();
}
