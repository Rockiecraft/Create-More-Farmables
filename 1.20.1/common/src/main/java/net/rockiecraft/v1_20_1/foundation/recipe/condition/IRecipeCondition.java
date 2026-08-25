package net.rockiecraft.v1_20_1.foundation.recipe.condition;

public interface IRecipeCondition {

    IRecipeConditionSerializer<?> getSerializer();

    boolean test();
}
