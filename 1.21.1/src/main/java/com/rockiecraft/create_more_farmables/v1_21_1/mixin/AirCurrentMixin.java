package com.rockiecraft.create_more_farmables.v1_21_1.mixin;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.tuple.Pair;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.rockiecraft.create_more_farmables.v1_21_1.foundation.CmfDataComponents;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.advancedassembly.AdvancedAssemblyChainLookahead;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.advancedassembly.AdvancedAssemblyRecipe;
import com.simibubi.create.content.kinetics.belt.BeltBlockEntity;
import com.simibubi.create.content.kinetics.belt.behaviour.TransportedItemStackHandlerBehaviour;
import com.simibubi.create.content.kinetics.belt.behaviour.TransportedItemStackHandlerBehaviour.TransportedResult;
import com.simibubi.create.content.kinetics.belt.transport.TransportedItemStack;
import com.simibubi.create.content.kinetics.fan.AirCurrent;
import com.simibubi.create.content.kinetics.fan.IAirCurrentSource;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessing;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import com.simibubi.create.infrastructure.config.AllConfigs;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;

@Mixin(AirCurrent.class)
public abstract class AirCurrentMixin {

    @Shadow
    public IAirCurrentSource source;

    @Shadow
    public Direction direction;

    @Shadow
    protected List<Pair<TransportedItemStackHandlerBehaviour, FanProcessingType>> affectedItemHandlers;

    @Redirect(
            method = "tickAffectedEntities",
            at = @At(value = "INVOKE", target = "Lcom/simibubi/create/content/kinetics/fan/processing/FanProcessing;canProcess(Lnet/minecraft/world/entity/item/ItemEntity;Lcom/simibubi/create/content/kinetics/fan/processing/FanProcessingType;)Z"))
    private boolean cmf$redirectCanProcess(ItemEntity entity, FanProcessingType type) {
        ItemStack stack = entity.getItem();
        Level level = entity.level();
        if (stack.has(CmfDataComponents.ADVANCED_ASSEMBLY))
            return FanProcessing.canProcess(entity, type);

        if (cmf$findViableGenesis(level, stack, type).isPresent())
            return true;

        return FanProcessing.canProcess(entity, type);
    }

    @Redirect(
            method = "tickAffectedEntities",
            at = @At(value = "INVOKE", target = "Lcom/simibubi/create/content/kinetics/fan/processing/FanProcessing;applyProcessing(Lnet/minecraft/world/entity/item/ItemEntity;Lcom/simibubi/create/content/kinetics/fan/processing/FanProcessingType;)Z"))
    private boolean cmf$redirectApplyToEntity(ItemEntity entity, FanProcessingType type) {
        ItemStack stack = entity.getItem();
        Level level = entity.level();
        if (stack.has(CmfDataComponents.ADVANCED_ASSEMBLY))
            return FanProcessing.applyProcessing(entity, type);

        Optional<RecipeHolder<AdvancedAssemblyRecipe>> starting = cmf$findViableGenesis(level, stack, type);
        if (starting.isEmpty())
            return FanProcessing.applyProcessing(entity, type);

        ResourceLocation recipeId = starting.get()
                .id();
        AdvancedAssemblyRecipe recipe = starting.get()
                .value();

        int remaining = cmf$decrementEntityTimer(entity, recipeId, 0);
        if (remaining != 0)
            return false;

        ItemStack advanced = recipe.advance(recipeId, stack, level.random);
        entity.setItem(advanced);
        return true;
    }

    @Inject(method = "tickAffectedHandlers", at = @At("HEAD"), cancellable = true)
    private void cmf$tickAffectedHandlersWithLookahead(CallbackInfo ci) {
        ci.cancel();
        for (Pair<TransportedItemStackHandlerBehaviour, FanProcessingType> pair : affectedItemHandlers) {
            TransportedItemStackHandlerBehaviour handler = pair.getKey();
            Level world = handler.getWorld(); FanProcessingType type = pair.getRight();
            if (type == null) continue;
            handler.handleProcessingOnAllItems(transported -> {
                if (world.isClientSide) {
                    type.spawnProcessingParticles(world, handler.getWorldPositionOf(transported));

                    if (cmf$isExpectedOrStartingStep(transported.stack, world, type)
                            && cmf$hasReachedHandlerCenter(transported, handler)) {

                        if (!transported.locked)
                            cmf$centerOnHandlerSegment(transported, handler);

                        transported.lockedExternally = true;
                        transported.locked = true;
                    }
                    return TransportedResult.doNothing();
                }
                if (transported.processedBy != type && !cmf$hasReachedHandlerCenter(transported, handler))
                    return TransportedResult.doNothing();
                boolean isNewClaim = transported.processedBy != type;
                TransportedResult result = FanProcessing.applyProcessing(transported, world, type);
                if (isNewClaim && transported.processedBy == type && transported.processingTime > 0) {
                    cmf$centerOnHandlerSegment(transported, handler);
                    cmf$notifyBeltUpdate(handler);
                }
                return result;
            });
        }
    }

    private void cmf$centerOnHandlerSegment(TransportedItemStack transported,
                                            TransportedItemStackHandlerBehaviour handler) {
        if (!(handler.blockEntity instanceof BeltBlockEntity belt))
            return;
        transported.beltPosition = belt.index + .5f
                + Math.signum(belt.getDirectionAwareBeltMovementSpeed()) / 512f;
    }

    private boolean cmf$hasReachedHandlerCenter(TransportedItemStack transported,
                                                 TransportedItemStackHandlerBehaviour handler) {
        if (!(handler.blockEntity instanceof BeltBlockEntity belt))
            return true;
        float center = belt.index + .5f;
        float oneBeltTick = Math.abs(belt.getDirectionAwareBeltMovementSpeed());
        return Math.abs(transported.beltPosition - center) <= Math.max(oneBeltTick, 1 / 512f);
    }

    private void cmf$notifyBeltUpdate(TransportedItemStackHandlerBehaviour handler) {
        if (handler.blockEntity instanceof BeltBlockEntity belt && belt.getControllerBE() != null) { belt.getControllerBE().notifyUpdate(); return; }
        handler.blockEntity.notifyUpdate();
    }

    private boolean cmf$isExpectedOrStartingStep(ItemStack stack, Level level, FanProcessingType type) {
        if (!stack.has(CmfDataComponents.ADVANCED_ASSEMBLY))
            return cmf$findViableGenesis(level, stack, type).isPresent();
        CmfDataComponents.AdvancedAssembly data = stack.get(CmfDataComponents.ADVANCED_ASSEMBLY);
        Optional<AdvancedAssemblyRecipe> recipe = AdvancedAssemblyRecipe.byId(level, data.id());
        if (recipe.isEmpty() || !recipe.get().appliesTo(data.id(), stack))
            return false;
        return recipe.get().getNextStep(stack).matchesFanType(type);
    }

    private Optional<RecipeHolder<AdvancedAssemblyRecipe>> cmf$findViableGenesis(Level level, ItemStack stack,
                                                                                 FanProcessingType type) {
        Optional<RecipeHolder<AdvancedAssemblyRecipe>> starting = AdvancedAssemblyRecipe.findStartingRecipe(
                level, stack, step -> step.matchesFanType(type));
        if (starting.isEmpty())
            return Optional.empty();

        AdvancedAssemblyRecipe recipe = starting.get()
                .value();

        if (!AdvancedAssemblyChainLookahead.verifyRemainingSteps(level, source.getAirCurrentPos(), direction,
                recipe.getSequence(), 1)) {

            return Optional.empty();
        }
        return starting;
    }

    private int cmf$decrementEntityTimer(ItemEntity entity, ResourceLocation recipeId, int step) {
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
