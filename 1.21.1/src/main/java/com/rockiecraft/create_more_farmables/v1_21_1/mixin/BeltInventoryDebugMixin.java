package com.rockiecraft.create_more_farmables.v1_21_1.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.rockiecraft.create_more_farmables.v1_21_1.CreateMoreFarmables;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.CmfDataComponents;
import com.simibubi.create.content.kinetics.belt.transport.BeltInventory;
import com.simibubi.create.content.kinetics.belt.transport.TransportedItemStack;

@Mixin(BeltInventory.class)
public abstract class BeltInventoryDebugMixin {

    @Redirect(
            method = "tick",
            at = @At(value = "FIELD",
                    target = "Lcom/simibubi/create/content/kinetics/belt/transport/TransportedItemStack;locked:Z",
                    opcode = org.objectweb.asm.Opcodes.GETFIELD))
    private boolean cmf$logLockedRead(TransportedItemStack transported) {
        boolean locked = transported.locked;
        if (transported.stack.has(CmfDataComponents.ADVANCED_ASSEMBLY)) {
            CreateMoreFarmables.LOGGER.info(
                    "[AA CLIENT] BeltInventory read locked={} lockedExternally={} beltPosition={} transportedId={}",
                    locked, transported.lockedExternally, transported.beltPosition,
                    System.identityHashCode(transported));
        }
        return locked;
    }
}
