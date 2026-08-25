package com.rockiecraft.create_more_farmables.v1_21_1.mixin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.advancedassembly.AdvancedAssemblyRecipe;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.advancedassembly.AdvancedAssemblyStep;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.kinetics.saw.CuttingRecipe;
import com.simibubi.create.content.kinetics.saw.SawBlockEntity;
import com.simibubi.create.content.processing.recipe.ProcessingInventory;
import com.simibubi.create.foundation.item.ItemHelper;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;

@Mixin(SawBlockEntity.class)
public abstract class SawBlockEntityMixin {

    @Shadow public ProcessingInventory inventory;

    @Inject(method = "getRecipes", at = @At("HEAD"), cancellable = true)
    private void cmf$getAdvancedAssemblyRecipe(CallbackInfoReturnable<List<RecipeHolder<? extends Recipe<?>>>> cir) {
        find(cmf$level(), inventory.getStackInSlot(0)).ifPresent(match ->
            cir.setReturnValue(List.of(new RecipeHolder<>(match.id(), match.step()))));
    }

    @Inject(method = "applyRecipe", at = @At("HEAD"), cancellable = true)
    private void cmf$advanceAdvancedAssembly(CallbackInfo ci) {
        ItemStack input = inventory.getStackInSlot(0);
        find(cmf$level(), input).ifPresent(match -> {
            ci.cancel();
            List<ItemStack> results = new ArrayList<>();
            int rolls = input.getCount();
            inventory.clear();
            for (int i = 0; i < rolls; i++)
                ItemHelper.addToList(match.recipe().advance(match.id(), input.copyWithCount(1), cmf$level().random), results);
            for (int slot = 0; slot < results.size() && slot + 1 < inventory.getSlots(); slot++)
                inventory.setStackInSlot(slot + 1, results.get(slot));
        });
    }

    private static Optional<Match> find(Level level, ItemStack input) {
        return AdvancedAssemblyRecipe.findForStep(level, input, SawBlockEntityMixin::isCutting)
            .flatMap(holder -> {
                AdvancedAssemblyStep step = holder.value().getNextStep(input);
                if (!(step.getRecipe() instanceof CuttingRecipe cutting)
                    || cutting.getIngredients().isEmpty()
                    || !cutting.getIngredients().getFirst().test(input))
                    return Optional.empty();
                return Optional.of(new Match(holder.id(), holder.value(), cutting));
            });
    }

    private static boolean isCutting(AdvancedAssemblyStep step) {
        return step.getStepType() == AllRecipeTypes.CUTTING.getType();
    }

    private Level cmf$level() {
        return ((SawBlockEntity) (Object) this).getLevel();
    }

    private record Match(ResourceLocation id, AdvancedAssemblyRecipe recipe, CuttingRecipe step) {}
}
