package net.rockiecraft.common.config.fabric;

import com.teamresourceful.resourcefulconfig.client.ConfigScreen;
import com.teamresourceful.resourcefulconfig.common.config.ResourcefulConfig;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.rockiecraft.CreateMoreFarmables;
import net.rockiecraft.foundaton.registry.CreateMoreFarmablesConfig;

@Environment(EnvType.CLIENT)
public class ModMenuConfig implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> {
            ResourcefulConfig config = CreateMoreFarmables.CONFIGURATOR.getConfig(CreateMoreFarmablesConfig.class);
            if (config == null) {
                return null;
            }
            return new ConfigScreen(null, config);
        };
    }
}
