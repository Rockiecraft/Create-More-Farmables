package net.rockiecraft.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.IModBusEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import net.rockiecraft.CreateMoreFarmables;

@SuppressWarnings("removal")
@Mod(CreateMoreFarmables.MOD_ID)
public final class CreateMoreFarmablesForge {
    public CreateMoreFarmablesForge() {
        // Submit our event bus to let Architectury API register our content on the right time.
        net.minecraftforge.eventbus.api.IEventBus eventBus = net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(CreateMoreFarmables.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        eventBus.addListener(this::commonSetup);
        // Run our common setup.
        CreateMoreFarmables.init();
    }

    public void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            CraftingHelper.register(ConfigRecipeCondition.Serializer.INSTANCE);
        });
    }
}
