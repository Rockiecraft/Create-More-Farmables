package net.rockiecraft.v1_20_1;

import com.teamresourceful.resourcefulconfig.common.config.Configurator;
import net.rockiecraft.v1_20_1.foundation.AllBlocks;
import net.rockiecraft.v1_20_1.foundation.AllFluids;
import net.rockiecraft.v1_20_1.foundation.AllItems;
import net.rockiecraft.v1_20_1.foundation.CreativeModeTabs;

import net.rockiecraft.v1_20_1.infrastructure.config.AllRecipeConditionSerializers;
import net.rockiecraft.v1_20_1.infrastructure.config.CreateMoreFarmablesConfig;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

public final class CreateMoreFarmables {
    public static final String MOD_ID = "create_more_farmables";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final Configurator CONFIGURATOR = new Configurator();

    public static void init() {
        // Write common init code here.
        LOGGER.info("Initializing CreateMoreFarmables");
        AllFluids.FLUIDS.init();
        AllBlocks.BLOCKS.init();

        AllItems.ITEMS.init();
        CONFIGURATOR.registerConfig(CreateMoreFarmablesConfig.class);
        CONFIGURATOR.saveConfig(CreateMoreFarmablesConfig.class);
        AllRecipeConditionSerializers.getSerializers();
        CreativeModeTabs.init();
    }
}
