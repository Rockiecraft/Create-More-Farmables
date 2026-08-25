package com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.moltenblasting;

import javax.annotation.ParametersAreNonnullByDefault;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import com.simibubi.create.content.processing.recipe.StandardProcessingRecipe;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

@ParametersAreNonnullByDefault
public class MoltenBlastingRecipe extends StandardProcessingRecipe<MoltenBlastingRecipeInput> {

    private final ResourceLocation fluid;

    public MoltenBlastingRecipe(ProcessingRecipeParams params, ResourceLocation fluid) {
        super(MoltenBlastingRecipeType.MOLTEN_BLASTING, params);
        this.fluid = fluid;
    }

    @Override
    public boolean matches(MoltenBlastingRecipeInput input, Level level) {
        if (input.isEmpty())
            return false;
        if (!fluid.equals(input.fluid()))
            return false;
        return ingredients.get(0)
            .test(input.getItem(0));
    }

    public ResourceLocation getFluid() {
        return fluid;
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
