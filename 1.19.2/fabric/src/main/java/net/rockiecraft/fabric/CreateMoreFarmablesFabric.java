package net.rockiecraft.fabric;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.resources.ResourceLocation;
import net.rockiecraft.CreateMoreFarmables;
import net.rockiecraft.foundaton.registry.MyConfig;

public final class CreateMoreFarmablesFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        ResourceConditions.register(new ResourceLocation("create_more_farmables",
                "config_toggle"), (jsonObject) -> {
            return MyConfig.enableSpecialRecipe;
        });
        // Run our common setup.
        CreateMoreFarmables.init();
    }
}
