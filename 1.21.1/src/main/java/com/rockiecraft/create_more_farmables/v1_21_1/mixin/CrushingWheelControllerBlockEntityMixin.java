package com.rockiecraft.create_more_farmables.v1_21_1.mixin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.rockiecraft.create_more_farmables.v1_21_1.foundation.CmfDataComponents;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.CmfDataComponents.AdvancedAssembly;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.advancedassembly.AdvancedAssemblyRecipe;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.advancedassembly.AdvancedAssemblyStep;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.kinetics.crusher.CrushingWheelControllerBlockEntity;
import com.simibubi.create.content.processing.recipe.ProcessingInventory;
import com.simibubi.create.content.processing.recipe.ProcessingRecipe;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.item.ItemHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(CrushingWheelControllerBlockEntity.class)
public abstract class CrushingWheelControllerBlockEntityMixin extends SmartBlockEntity {

    @Shadow
    public ProcessingInventory inventory;

    protected CrushingWheelControllerBlockEntityMixin(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Inject(method = "itemInserted", at = @At("HEAD"), cancellable = true)
    private void cmf$timeAdvancedAssemblyStep(ItemStack stack, CallbackInfo ci) {
        if (stack.has(CmfDataComponents.ADVANCED_ASSEMBLY)) {
            AdvancedAssembly data = stack.get(CmfDataComponents.ADVANCED_ASSEMBLY);
            Optional<AdvancedAssemblyRecipe> recipe = AdvancedAssemblyRecipe.byId(level, data.id());
            if (recipe.isEmpty())
                return;

            ci.cancel();
            int duration = 100;
            if (recipe.get()
                    .appliesTo(data.id(), stack)) {
                AdvancedAssemblyStep step = recipe.get()
                        .getNextStep(stack);
                if (isCrushingStep(step) && step.getRecipe() instanceof ProcessingRecipe<?, ?> processingRecipe)
                    duration = processingRecipe.getProcessingDuration();
            }
            inventory.remainingTime = duration;
            inventory.appliedRecipe = false;
            return;
        }

        Optional<RecipeHolder<AdvancedAssemblyRecipe>> starting =
                AdvancedAssemblyRecipe.findStartingRecipe(level, stack, CrushingWheelControllerBlockEntityMixin::isCrushingStep);
        if (starting.isEmpty())
            return;

        ci.cancel();
        AdvancedAssemblyStep firstStep = starting.get()
                .value()
                .getSequence()
                .get(0);
        int duration = firstStep.getRecipe() instanceof ProcessingRecipe<?, ?> processingRecipe
                ? processingRecipe.getProcessingDuration()
                : 100;
        inventory.remainingTime = duration;
        inventory.appliedRecipe = false;
    }

    @Inject(method = "applyRecipe", at = @At("HEAD"), cancellable = true)
    private void cmf$applyAdvancedAssemblyStep(CallbackInfo ci) {
        ItemStack input = inventory.getStackInSlot(0);

        ResourceLocation recipeId;
        AdvancedAssemblyRecipe recipe;

        if (input.has(CmfDataComponents.ADVANCED_ASSEMBLY)) {
            AdvancedAssembly data = input.get(CmfDataComponents.ADVANCED_ASSEMBLY);
            Optional<AdvancedAssemblyRecipe> recipeHolder = AdvancedAssemblyRecipe.byId(level, data.id());

            if (recipeHolder.isEmpty())
                return;

            recipeId = data.id();
            recipe = recipeHolder.get();
        } else {

            Optional<RecipeHolder<AdvancedAssemblyRecipe>> starting =
                    AdvancedAssemblyRecipe.findStartingRecipe(level, input, CrushingWheelControllerBlockEntityMixin::isCrushingStep);
            if (starting.isEmpty())
                return;

            recipeId = starting.get()
                    .id();
            recipe = starting.get()
                    .value();
        }

        ci.cancel();
        inventory.clear();

        if (!recipe.appliesTo(recipeId, input) || !isCrushingStep(recipe.getNextStep(input))) {

            inventory.setStackInSlot(1, input.copy());
            return;
        }

        List<ItemStack> results = new ArrayList<>();
        int rolls = input.getCount();
        for (int roll = 0; roll < rolls; roll++)
            ItemHelper.addToList(recipe.advance(recipeId, input.copyWithCount(1), level.random), results);
        for (int slot = 0; slot < results.size() && slot + 1 < inventory.getSlots(); slot++)
            inventory.setStackInSlot(slot + 1, results.get(slot));
    }

    private static boolean isCrushingStep(AdvancedAssemblyStep step) {
        return step.getStepType() == AllRecipeTypes.CRUSHING.getType();
    }
}
