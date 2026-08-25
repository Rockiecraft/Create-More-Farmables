package com.rockiecraft.create_more_farmables.v1_21_1.foundation.events;

import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.advancedassembly.AdvancedAssemblyRecipe;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

@EventBusSubscriber(Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void addToItemTooltip(ItemTooltipEvent event) {
        AdvancedAssemblyRecipe.addToTooltip(event);
    }
}
