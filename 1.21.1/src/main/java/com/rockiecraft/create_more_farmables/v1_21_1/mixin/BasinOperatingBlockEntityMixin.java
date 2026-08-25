package com.rockiecraft.create_more_farmables.v1_21_1.mixin;

import java.util.Optional;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.simibubi.create.content.kinetics.mixer.MixingRecipe;
import com.simibubi.create.content.processing.basin.BasinBlockEntity;
import com.simibubi.create.content.processing.basin.BasinOperatingBlockEntity;
import com.simibubi.create.content.processing.basin.BasinRecipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;

import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.advancedassembly.AdvancedAssemblyRecipe;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.advancedassembly.AdvancedAssemblyStep;
import com.simibubi.create.AllRecipeTypes;
import net.minecraft.resources.ResourceLocation;

@Mixin(BasinOperatingBlockEntity.class)
public abstract class BasinOperatingBlockEntityMixin {

    @Shadow protected Recipe<?> currentRecipe;
    @Shadow protected abstract Optional<BasinBlockEntity> getBasin();

    @Inject(method = "applyBasinRecipe", at = @At("HEAD"))
    private void cmf$advanceAdvancedAssemblyMixing(CallbackInfo ci) {

    }

    private static Optional<Match> cmf$find(Level level, ItemStack input, BasinBlockEntity basin) {
        return AdvancedAssemblyRecipe.findForStep(level, input,
                step -> step.getStepType() == AllRecipeTypes.MIXING.getType())
            .flatMap(holder -> {
                AdvancedAssemblyStep step = holder.value().getNextStep(input);
                if (!(step.getRecipe() instanceof MixingRecipe mixing)
                    || !mixing.getFluidResults().isEmpty()
                    || !BasinRecipe.match(basin, mixing))
                    return Optional.empty();
                return Optional.of(new Match(holder.id(), holder.value(), mixing, input.copyWithCount(1)));
            });
    }

    private record Match(ResourceLocation id, AdvancedAssemblyRecipe recipe, MixingRecipe step, ItemStack input) {}
}
