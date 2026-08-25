package net.rockiecraft.v1_19_2;
import com.teamresourceful.resourcefulconfig.common.config.Configurator;
import net.rockiecraft.v1_20_1.foundation.AllBlocks;
import net.rockiecraft.v1_20_1.foundation.AllFluids;
import net.rockiecraft.v1_20_1.foundation.AllItems;
import net.rockiecraft.v1_20_1.infrastructure.config.AllRecipeConditionSerializers;
import net.rockiecraft.v1_20_1.infrastructure.config.CreateMoreFarmablesConfig;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

public final class CreateMoreFarmables {
    public static final String MOD_ID = "create_more_farmables";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final Configurator CONFIGURATOR = new Configurator(true);

    public static void init() {
        LOGGER.info("Initializing CreateMoreFarmables");
        CreateMoreFarmablesConfig.init();
        AllFluids.FLUIDS.init();
        AllBlocks.BLOCKS.init();

        AllItems.BASIC_ITEMS.init();
        // Dye splashing recipe/processing types are registered per-platform since they need Create on the classpath.
        CONFIGURATOR.registerConfig(CreateMoreFarmablesConfig.class);
        AllRecipeConditionSerializers.init();
        CONFIGURATOR.saveConfig(CreateMoreFarmablesConfig.class);
        LOGGER.info("CreateMoreFarmables Initialized");
    }
}
