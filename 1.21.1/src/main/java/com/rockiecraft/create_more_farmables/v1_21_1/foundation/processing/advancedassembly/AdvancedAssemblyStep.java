package com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.advancedassembly;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.simibubi.create.AllRecipeTypes;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.dyesplashing.DyeSplashingFanProcessingType;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.dyesplashing.DyeSplashingRecipeType;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.moltenblasting.MoltenBlastingFanProcessingType;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.moltenblasting.MoltenBlastingRecipeType;
import com.simibubi.create.content.kinetics.fan.processing.AllFanProcessingTypes;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import com.simibubi.create.content.kinetics.mixer.MixingRecipe;

import io.netty.handler.codec.DecoderException;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

public class AdvancedAssemblyStep {

    public static final Codec<AdvancedAssemblyStep> CODEC = Recipe.CODEC.comapFlatMap(
        recipe -> isAllowed(recipe)
            ? DataResult.success(new AdvancedAssemblyStep(recipe))
            : DataResult.error(() -> recipe.getClass()
                .getSimpleName() + " is not supported in Advanced Assembly"),
        AdvancedAssemblyStep::getRecipe
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, AdvancedAssemblyStep> STREAM_CODEC = Recipe.STREAM_CODEC.map(
        recipe -> {
            if (isAllowed(recipe))
                return new AdvancedAssemblyStep(recipe);
            throw new DecoderException("Unexpected " + recipe.getClass()
                .getSimpleName() + " not supported in Advanced Assembly");
        },
        AdvancedAssemblyStep::getRecipe
    );

    private final Recipe<?> wrapped;

    public AdvancedAssemblyStep(Recipe<?> wrapped) {
        this.wrapped = wrapped;
    }

    public Recipe<?> getRecipe() {
        return wrapped;
    }

    public RecipeType<?> getStepType() {
        return wrapped.getType();
    }

    public boolean matchesFanType(FanProcessingType type) {
        RecipeType<?> stepType = getStepType();
        if (stepType == RecipeType.SMELTING || stepType == RecipeType.BLASTING)
            return type == AllFanProcessingTypes.BLASTING;
        if (stepType == AllRecipeTypes.SPLASHING.getType())
            return type == AllFanProcessingTypes.SPLASHING;
        if (stepType == AllRecipeTypes.HAUNTING.getType())
            return type == AllFanProcessingTypes.HAUNTING;
        if (stepType == MoltenBlastingRecipeType.MOLTEN_BLASTING.getType())
            return type instanceof MoltenBlastingFanProcessingType;
        if (stepType == DyeSplashingRecipeType.DYE_SPLASHING.getType())
            return type instanceof DyeSplashingFanProcessingType;
        return false;
    }

    public boolean isCrushingStep() {
        return getStepType() == AllRecipeTypes.CRUSHING.getType();
    }

    private static boolean isAllowed(Recipe<?> recipe) {
        RecipeType<?> type = recipe.getType();
        RecipeType<?> crushing = AllRecipeTypes.CRUSHING.getType();
        RecipeType<?> deploying = AllRecipeTypes.DEPLOYING.getType();
        RecipeType<?> pressing = AllRecipeTypes.PRESSING.getType();
        RecipeType<?> cutting = AllRecipeTypes.CUTTING.getType();
        RecipeType<?> filling = AllRecipeTypes.FILLING.getType();
        RecipeType<?> mixing = AllRecipeTypes.MIXING.getType();
        RecipeType<?> splashing = AllRecipeTypes.SPLASHING.getType();
        RecipeType<?> haunting = AllRecipeTypes.HAUNTING.getType();
        RecipeType<?> moltenBlasting = MoltenBlastingRecipeType.MOLTEN_BLASTING.getType();
        RecipeType<?> dyeSplashing = DyeSplashingRecipeType.DYE_SPLASHING.getType();

        if (type == mixing && recipe instanceof MixingRecipe mixingRecipe && !mixingRecipe.getFluidResults().isEmpty())
            return false;
        return type == crushing
            || type == deploying
            || type == pressing
            || type == cutting
            || type == filling
            || type == mixing
            || type == splashing
            || type == haunting
            || type == RecipeType.SMELTING
            || type == RecipeType.BLASTING
            || type == moltenBlasting
            || type == dyeSplashing;
    }
}
