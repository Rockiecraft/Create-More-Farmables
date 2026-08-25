package com.rockiecraft.create_more_farmables.v1_21_1.mixin;

import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.simibubi.create.content.kinetics.deployer.BeltDeployerCallbacks;
import com.simibubi.create.AllRecipeTypes;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.advancedassembly.AdvancedAssemblyRecipe;
import com.simibubi.create.content.kinetics.deployer.DeployerApplicationRecipe;
import com.simibubi.create.foundation.recipe.RecipeApplier;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;

@Mixin(BeltDeployerCallbacks.class)
public class BeltDeployerCallbacksMixin {

    @Redirect(method = "activate", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/foundation/recipe/RecipeApplier;applyRecipeOn(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/crafting/Recipe;Z)Ljava/util/List;"))
    private static List<ItemStack> cmf$advanceAdvancedAssembly(Level level, ItemStack input, Recipe<?> recipe,
                                                                 boolean rollResults) {
        return AdvancedAssemblyRecipe.findForStep(level, input,
                step -> step.getStepType() == AllRecipeTypes.DEPLOYING.getType())
            .filter(holder -> holder.value().getNextStep(input).getRecipe() instanceof DeployerApplicationRecipe)
            .filter(holder -> holder.value().getNextStep(input).getRecipe() == recipe)
            .map(holder -> List.of(holder.value().advance(holder.id(), input, level.random)))
            .orElseGet(() -> RecipeApplier.applyRecipeOn(level, input, recipe, rollResults));
    }
}
