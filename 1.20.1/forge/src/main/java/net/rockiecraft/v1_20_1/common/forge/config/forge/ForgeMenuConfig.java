package net.rockiecraft.v1_20_1.common.forge.config.forge;

import com.teamresourceful.resourcefulconfig.client.ConfigScreen;
import com.teamresourceful.resourcefulconfig.common.config.ResourcefulConfig;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.fml.ModLoadingContext;
import net.rockiecraft.v1_20_1.CreateMoreFarmables;
import net.rockiecraft.v1_20_1.infrastructure.config.CreateMoreFarmablesConfig;

@SuppressWarnings("removal")
public class ForgeMenuConfig {
    public static void register() {
        ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class,
                () -> new ConfigScreenHandler.ConfigScreenFactory((client, parent) -> {
                    ResourcefulConfig config = CreateMoreFarmables.CONFIGURATOR.getConfig(CreateMoreFarmablesConfig.class);
                    if (config == null) {
                        return null;
                    }
                    return new ConfigScreen(null, config);
                })
        );
    }
}