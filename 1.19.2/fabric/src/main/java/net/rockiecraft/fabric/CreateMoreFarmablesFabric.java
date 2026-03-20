package net.rockiecraft.fabric;

import net.fabricmc.api.ModInitializer;

import net.rockiecraft.CreateMoreFarmables;

public final class CreateMoreFarmablesFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        CreateMoreFarmables.init();
    }
}
