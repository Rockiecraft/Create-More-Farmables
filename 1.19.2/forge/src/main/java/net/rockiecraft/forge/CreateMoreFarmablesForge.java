package net.rockiecraft.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import net.rockiecraft.CreateMoreFarmables;

@SuppressWarnings("removal")
@Mod(CreateMoreFarmables.MOD_ID)
public final class CreateMoreFarmablesForge {
    public CreateMoreFarmablesForge() {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(CreateMoreFarmables.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        // Run our common setup.
        CreateMoreFarmables.init();
    }
}
