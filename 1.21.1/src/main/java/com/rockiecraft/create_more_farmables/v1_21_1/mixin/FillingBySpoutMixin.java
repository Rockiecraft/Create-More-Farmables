package com.rockiecraft.create_more_farmables.v1_21_1.mixin;

import java.util.Optional;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.advancedassembly.AdvancedAssemblyRecipe;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.advancedassembly.AdvancedAssemblyStep;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.fluids.spout.FillingBySpout;
import com.simibubi.create.content.fluids.transfer.FillingRecipe;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.fluids.FluidStack;

@Mixin(FillingBySpout.class)
public class FillingBySpoutMixin {

    @Inject(method = "canItemBeFilled", at = @At("HEAD"), cancellable = true)
    private static void cmf$canFillAdvancedAssembly(Level level, ItemStack stack,
                                                     CallbackInfoReturnable<Boolean> cir) {
        if (find(level, stack, FluidStack.EMPTY).isPresent())
            cir.setReturnValue(true);
    }

    @Inject(method = "getRequiredAmountForItem", at = @At("HEAD"), cancellable = true)
    private static void cmf$getAdvancedAssemblyFluid(Level level, ItemStack stack, FluidStack available,
                                                      CallbackInfoReturnable<Integer> cir) {
        find(level, stack, available).ifPresent(match ->
            cir.setReturnValue(match.step().getRequiredFluid().amount()));
    }

    @Inject(method = "fillItem", at = @At("HEAD"), cancellable = true)
    private static void cmf$fillAdvancedAssembly(Level level, int amount, ItemStack stack, FluidStack available,
                                                  CallbackInfoReturnable<ItemStack> cir) {
        find(level, stack, available).ifPresent(match -> {
            if (amount != match.step().getRequiredFluid().amount())
                return;

            ItemStack sequenceInput = stack.copyWithCount(1);
            available.shrink(amount);
            stack.shrink(1);
            cir.setReturnValue(match.recipe().advance(match.id(), sequenceInput, level.random));
        });
    }

    private static Optional<Match> find(Level level, ItemStack stack, FluidStack fluid) {
        return AdvancedAssemblyRecipe.findForStep(level, stack, FillingBySpoutMixin::isFilling)
            .flatMap(holder -> {
                AdvancedAssemblyStep step = holder.value().getNextStep(stack);
                if (!(step.getRecipe() instanceof FillingRecipe filling)
                    || !filling.matches(new SingleRecipeInput(stack), level)
                    || (!fluid.isEmpty() && !filling.getRequiredFluid().ingredient().test(fluid)))
                    return Optional.empty();
                return Optional.of(new Match(holder.id(), holder.value(), filling));
            });
    }

    private static boolean isFilling(AdvancedAssemblyStep step) {
        return step.getStepType() == AllRecipeTypes.FILLING.getType();
    }

    private record Match(ResourceLocation id, AdvancedAssemblyRecipe recipe, FillingRecipe step) {}
}
