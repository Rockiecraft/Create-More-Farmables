package com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.dyesplashing;

import javax.annotation.ParametersAreNonnullByDefault;

import org.jetbrains.annotations.Nullable;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;

@ParametersAreNonnullByDefault
public class DyeSplashingRecipe extends StandardProcessingRecipe<DyeSplashingRecipeInput> {

    @Nullable
    private final DyeColor color;

    public DyeSplashingRecipe(ProcessingRecipeParams params, @Nullable DyeColor color) {
        super(DyeSplashingRecipeType.DYE_SPLASHING, params);
        this.color = color;
    }

    @Override
    public boolean matches(DyeSplashingRecipeInput input, Level level) {
        if (input.isEmpty())
            return false;
        if (color != null && color != input.color())
            return false;
        return ingredients.get(0)
            .test(input.getItem(0));
    }

    @Nullable
    public DyeColor getColor() {
        return color;
    }

    @Override
    protected int getMaxInputCount() {
        return 1;
    }

    @Override
    protected int getMaxOutputCount() {
        return 12;
    }
}
