package com.rockiecraft.create_more_farmables.v1_21_1.mixin;

import java.util.List;
import java.util.Optional;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.advancedassembly.AdvancedAssemblyRecipe;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.advancedassembly.AdvancedAssemblyStep;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.kinetics.mixer.MechanicalMixerBlockEntity;
import com.simibubi.create.content.kinetics.mixer.MixingRecipe;
import com.simibubi.create.content.processing.basin.BasinBlockEntity;
import com.simibubi.create.content.processing.basin.BasinOperatingBlockEntity;
import com.simibubi.create.content.processing.basin.BasinRecipe;
import com.simibubi.create.foundation.item.SmartInventory;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(MechanicalMixerBlockEntity.class)
public abstract class MechanicalMixerBlockEntityMixin extends BasinOperatingBlockEntity {

    protected MechanicalMixerBlockEntityMixin(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Inject(method = "getMatchingRecipes", at = @At("RETURN"))
    private void cmf$addAdvancedAssemblyMixingRecipe(CallbackInfoReturnable<List<Recipe<?>>> cir) {
        Optional<BasinBlockEntity> basin = getBasin();
        if (basin.isEmpty())
            return;
        SmartInventory inputs = basin.get().getInputInventory();
        for (int slot = 0; slot < inputs.getSlots(); slot++) {
            ItemStack stack = inputs.getItem(slot);
            find(((MechanicalMixerBlockEntity) (Object) this).getLevel(), stack, basin.get()).ifPresent(match -> {
                if (!cir.getReturnValue().contains(match.step())) {

                    cir.getReturnValue().add(0, match.step());

                    match.step().enforceNextResult(() -> match.recipe().advance(match.id(), match.input().copy(), ((MechanicalMixerBlockEntity) (Object) this).getLevel().random));
                }
            });
        }
    }

    private static Optional<Match> find(Level level, ItemStack input, BasinBlockEntity basin) {
        return AdvancedAssemblyRecipe.findForStep(level, input, MechanicalMixerBlockEntityMixin::isMixing)
            .flatMap(holder -> {
                AdvancedAssemblyStep step = holder.value().getNextStep(input);
                if (!(step.getRecipe() instanceof MixingRecipe mixing)
                    || !mixing.getFluidResults().isEmpty()
                    || !BasinRecipe.match(basin, mixing))
                    return Optional.empty();
                return Optional.of(new Match(holder.id(), holder.value(), mixing, input.copyWithCount(1)));
            });
    }

    private static boolean isMixing(AdvancedAssemblyStep step) {
        return step.getStepType() == AllRecipeTypes.MIXING.getType();
    }

    record Match(ResourceLocation id, AdvancedAssemblyRecipe recipe, MixingRecipe step, ItemStack input) {}
}
