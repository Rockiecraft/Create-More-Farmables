package com.rockiecraft.create_more_farmables.v1_21_1.mixin;

import java.util.Optional;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.advancedassembly.AdvancedAssemblyRecipe;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.advancedassembly.AdvancedAssemblyStep;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.kinetics.deployer.DeployerBlockEntity;
import com.simibubi.create.content.kinetics.deployer.DeployerFakePlayer;
import com.simibubi.create.content.kinetics.deployer.DeployerApplicationRecipe;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.wrapper.RecipeWrapper;

@Mixin(DeployerBlockEntity.class)
public abstract class DeployerBlockEntityMixin {

    @Shadow protected DeployerFakePlayer player;
    @Shadow ItemStackHandler recipeInv;

    @Inject(method = "getRecipe", at = @At("HEAD"), cancellable = true)
    private void cmf$getAdvancedAssemblyRecipe(ItemStack input,
                                                CallbackInfoReturnable<RecipeHolder<? extends Recipe<?>>> cir) {
        Level level = ((DeployerBlockEntity) (Object) this).getLevel();
        if (player == null || level == null)
            return;
        recipeInv.setStackInSlot(0, input);
        recipeInv.setStackInSlot(1, player.getMainHandItem());
        find(level, input, new RecipeWrapper(recipeInv)).ifPresent(match ->
            cir.setReturnValue(new RecipeHolder<>(match.id(), match.step())));
    }

    private static Optional<Match> find(Level level, ItemStack input, RecipeWrapper inventory) {
        return AdvancedAssemblyRecipe.findForStep(level, input, DeployerBlockEntityMixin::isDeploying)
            .flatMap(holder -> {
                AdvancedAssemblyStep step = holder.value().getNextStep(input);
                if (!(step.getRecipe() instanceof DeployerApplicationRecipe deploying)
                    || !deploying.matches(inventory, level))
                    return Optional.empty();
                return Optional.of(new Match(holder.id(), holder.value(), deploying));
            });
    }

    private static boolean isDeploying(AdvancedAssemblyStep step) {
        return step.getStepType() == AllRecipeTypes.DEPLOYING.getType();
    }

    private record Match(ResourceLocation id, AdvancedAssemblyRecipe recipe, DeployerApplicationRecipe step) {}
}
