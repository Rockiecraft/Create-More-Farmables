package com.rockiecraft.create_more_farmables.v1_21_1.mixin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.advancedassembly.AdvancedAssemblyRecipe;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.advancedassembly.AdvancedAssemblyStep;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.kinetics.belt.transport.TransportedItemStack;
import com.simibubi.create.content.kinetics.press.MechanicalPressBlockEntity;
import com.simibubi.create.content.kinetics.press.PressingRecipe;
import com.simibubi.create.foundation.item.ItemHelper;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;

@Mixin(MechanicalPressBlockEntity.class)
public abstract class MechanicalPressBlockEntityMixin {

    @Inject(method = "getRecipe", at = @At("HEAD"), cancellable = true)
    private void cmf$findAdvancedAssemblyRecipe(ItemStack input,
                                                 CallbackInfoReturnable<Optional<RecipeHolder<PressingRecipe>>> cir) {
        MechanicalPressBlockEntity self = (MechanicalPressBlockEntity) (Object) this;
        find(self.getLevel(), input).ifPresent(match ->
            cir.setReturnValue(Optional.of(new RecipeHolder<>(match.id(), match.step()))));
    }

    @Inject(method = "tryProcessOnBelt", at = @At("HEAD"), cancellable = true)
    private void cmf$advanceAdvancedAssemblyOnBelt(TransportedItemStack input, List<ItemStack> outputs,
                                                     boolean simulate, CallbackInfoReturnable<Boolean> cir) {
        MechanicalPressBlockEntity self = (MechanicalPressBlockEntity) (Object) this;
        find(self.getLevel(), input.stack).ifPresent(match -> {
            if (simulate) {
                cir.setReturnValue(true);
                return;
            }
            int rolls = self.canProcessInBulk() ? input.stack.getCount() : 1;
            List<ItemStack> advanced = new ArrayList<>();
            for (int i = 0; i < rolls; i++)
                ItemHelper.addToList(match.recipe().advance(match.id(), input.stack.copyWithCount(1),
                    self.getLevel().random), advanced);
            for (ItemStack stack : advanced) {
                if (!stack.isEmpty()) {
                    self.onItemPressed(stack);
                    break;
                }
            }
            outputs.addAll(advanced);
            cir.setReturnValue(true);
        });
    }

    private static Optional<Match> find(Level level, ItemStack input) {
        return AdvancedAssemblyRecipe.findForStep(level, input, MechanicalPressBlockEntityMixin::isPressing)
            .flatMap(holder -> {
                AdvancedAssemblyStep step = holder.value().getNextStep(input);
                if (!(step.getRecipe() instanceof PressingRecipe pressing)
                    || !pressing.matches(new SingleRecipeInput(input), level))
                    return Optional.empty();
                return Optional.of(new Match(holder.id(), holder.value(), pressing));
            });
    }

    private static boolean isPressing(AdvancedAssemblyStep step) {
        return step.getStepType() == AllRecipeTypes.PRESSING.getType();
    }

    private record Match(ResourceLocation id, AdvancedAssemblyRecipe recipe, PressingRecipe step) {}
}
