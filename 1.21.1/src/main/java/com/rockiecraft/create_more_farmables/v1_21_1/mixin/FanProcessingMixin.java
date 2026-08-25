package com.rockiecraft.create_more_farmables.v1_21_1.mixin;

import java.util.List;
import java.util.Optional;

import com.rockiecraft.create_more_farmables.v1_21_1.CreateMoreFarmables;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.rockiecraft.create_more_farmables.v1_21_1.foundation.CmfDataComponents;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.CmfDataComponents.AdvancedAssembly;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.advancedassembly.AdvancedAssemblyRecipe;
import com.simibubi.create.content.kinetics.belt.behaviour.TransportedItemStackHandlerBehaviour.TransportedResult;
import com.simibubi.create.content.kinetics.belt.transport.TransportedItemStack;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessing;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import com.simibubi.create.infrastructure.config.AllConfigs;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;

@Mixin(FanProcessing.class)
public abstract class FanProcessingMixin {

    @Inject(
            method = "canProcess(Lnet/minecraft/world/entity/item/ItemEntity;Lcom/simibubi/create/content/kinetics/fan/processing/FanProcessingType;)Z",
            at = @At("HEAD"), cancellable = true)
    private static void cmf$gateCanProcess(ItemEntity entity, FanProcessingType type,
                                           CallbackInfoReturnable<Boolean> cir) {
        ItemStack stack = entity.getItem();
        if (stack.has(CmfDataComponents.ADVANCED_ASSEMBLY)) {
            cir.setReturnValue(cmf$isExpectedStep(stack, entity.level(), type));
            cir.cancel();
            return;
        }

    }

    @Inject(
            method = "applyProcessing(Lnet/minecraft/world/entity/item/ItemEntity;Lcom/simibubi/create/content/kinetics/fan/processing/FanProcessingType;)Z",
            at = @At("HEAD"), cancellable = true)
    private static void cmf$applyToEntity(ItemEntity entity, FanProcessingType type,
                                          CallbackInfoReturnable<Boolean> cir) {
        ItemStack stack = entity.getItem();

        if (!stack.has(CmfDataComponents.ADVANCED_ASSEMBLY))
            return;

        AdvancedAssembly data = stack.get(CmfDataComponents.ADVANCED_ASSEMBLY);
        Optional<AdvancedAssemblyRecipe> found = AdvancedAssemblyRecipe.byId(entity.level(), data.id());
        if (found.isEmpty() || !found.get()
                .appliesTo(data.id(), stack) || !found.get()
                .getNextStep(stack)
                .matchesFanType(type)) {
            cir.setReturnValue(false);
            cir.cancel();
            return;
        }
        ResourceLocation recipeId = data.id();
        AdvancedAssemblyRecipe recipe = found.get();
        int step = data.step();

        cir.cancel();
        int remaining = cmf$decrementEntityTimer(entity, recipeId, step);
        if (remaining != 0) {
            cir.setReturnValue(false);
            return;
        }
        ItemStack advanced = recipe.advance(recipeId, stack, entity.level().random);
        entity.setItem(advanced);
        cir.setReturnValue(true);
    }

    @Inject(
            method = "applyProcessing(Lcom/simibubi/create/content/kinetics/belt/transport/TransportedItemStack;Lnet/minecraft/world/level/Level;Lcom/simibubi/create/content/kinetics/fan/processing/FanProcessingType;)Lcom/simibubi/create/content/kinetics/belt/behaviour/TransportedItemStackHandlerBehaviour$TransportedResult;",
            at = @At("HEAD"), cancellable = true)
    private static void cmf$applyToTransported(TransportedItemStack transported, Level world, FanProcessingType type,
                                               CallbackInfoReturnable<TransportedResult> cir) {
        ItemStack stack = transported.stack;
        TransportedResult ignore = TransportedResult.doNothing();

        CreateMoreFarmables.LOGGER.info(
                "[AA BELT] applyProcessing called: type={} hasAAData={} itemCount={}",
                type, stack.has(CmfDataComponents.ADVANCED_ASSEMBLY), stack.getCount());

        if (!stack.has(CmfDataComponents.ADVANCED_ASSEMBLY)) {
            Optional<RecipeHolder<AdvancedAssemblyRecipe>> starting = AdvancedAssemblyRecipe.findStartingRecipe(
                    world, stack, step -> step.matchesFanType(type));
            if (starting.isPresent()) {
                ResourceLocation recipeId = starting.get().id();
                AdvancedAssemblyRecipe recipe = starting.get().value();

                if (transported.processedBy != type) {
                    transported.processedBy = type;
                    int timeModifierForStackSize = ((stack.getCount() - 1) / 16) + 1;
                    transported.processingTime =
                            (int) (AllConfigs.server().kinetics.fanProcessingTime.get() * timeModifierForStackSize) + 1;

                    transported.lockedExternally = true;
                    transported.locked = true;
                    cir.cancel();
                    cir.setReturnValue(ignore);
                    return;
                }

                if (transported.processingTime > 0) {
                    transported.processingTime--;
                    transported.lockedExternally = true;
                    transported.locked = true;
                    cir.cancel();
                    cir.setReturnValue(ignore);
                    return;
                }

                ItemStack advancedStack = recipe.advance(recipeId, stack, world.random);
                TransportedItemStack newTransported = transported.copy();
                newTransported.stack = advancedStack;
                newTransported.clearFanProcessingData();
                cir.cancel();
                cir.setReturnValue(TransportedResult.convertTo(List.of(newTransported)));
                return;
            } else {

                return;
            }
        }

        if (transported.processedBy == type && transported.processingTime > 0) {
            cir.cancel();
            transported.processingTime--;
            transported.lockedExternally = true;
            transported.locked = true;
            cir.setReturnValue(ignore);
            return;
        }

        AdvancedAssembly data = stack.get(CmfDataComponents.ADVANCED_ASSEMBLY);

        Optional<AdvancedAssemblyRecipe> found = AdvancedAssemblyRecipe.byId(world, data.id());

        if (found.isEmpty() || !found.get()
                .appliesTo(data.id(), stack) || !found.get()
                .getNextStep(stack)
                .matchesFanType(type)) {
            cir.setReturnValue(ignore);
            cir.cancel();
            return;
        }
        ResourceLocation recipeId = data.id();
        AdvancedAssemblyRecipe recipe = found.get();

        cir.cancel();


        if (transported.processedBy != type) {
            transported.prevBeltPosition = transported.beltPosition;
            transported.processedBy = type;
            int timeModifierForStackSize = ((stack.getCount() - 1) / 16) + 1;
            transported.processingTime =
                    (int) (AllConfigs.server().kinetics.fanProcessingTime.get() * timeModifierForStackSize) + 1;
            transported.lockedExternally = true;
            transported.locked = true;
            cir.setReturnValue(ignore);
            return;
        }

        ItemStack advancedStack = recipe.advance(recipeId, stack, world.random);
        TransportedItemStack newTransported = transported.copy();
        newTransported.stack = advancedStack;

        newTransported.clearFanProcessingData();
        cir.setReturnValue(TransportedResult.convertTo(List.of(newTransported)));
    }

    private static boolean cmf$isExpectedStep(ItemStack stack, Level level, FanProcessingType type) {
        AdvancedAssembly data = stack.get(CmfDataComponents.ADVANCED_ASSEMBLY);
        Optional<AdvancedAssemblyRecipe> recipe = AdvancedAssemblyRecipe.byId(level, data.id());
        if (recipe.isEmpty() || !recipe.get()
                .appliesTo(data.id(), stack))
            return false;
        return recipe.get()
                .getNextStep(stack)
                .matchesFanType(type);
    }

    private static void cmf$syncBeltRenderPosition(TransportedItemStack transported) {
        transported.prevBeltPosition = transported.beltPosition;
    }

    private static int cmf$decrementEntityTimer(ItemEntity entity, ResourceLocation recipeId, int step) {
        CompoundTag nbt = entity.getPersistentData();
        CompoundTag cmfData = nbt.getCompound("CmfAdvancedAssembly");

        boolean sameStep = cmfData.contains("Step") && cmfData.getInt("Step") == step && cmfData
                .getString("Recipe")
                .equals(recipeId.toString());

        if (!sameStep) {
            cmfData = new CompoundTag();
            cmfData.putString("Recipe", recipeId.toString());
            cmfData.putInt("Step", step);
            int timeModifierForStackSize = ((entity.getItem()
                    .getCount() - 1) / 16) + 1;
            cmfData.putInt("Time",
                    (int) (AllConfigs.server().kinetics.fanProcessingTime.get() * timeModifierForStackSize) + 1);
        }

        int value = cmfData.getInt("Time") - 1;
        cmfData.putInt("Time", value);
        nbt.put("CmfAdvancedAssembly", cmfData);
        return value;
    }
}
