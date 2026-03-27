package net.rockiecraft;
import com.teamresourceful.resourcefulconfig.common.config.Configurator;
import net.rockiecraft.foundaton.AllBlocks;
import net.rockiecraft.foundaton.AllFluids;
import net.rockiecraft.foundaton.AllItems;
import net.rockiecraft.foundaton.registry.recipe.condition.AllRecipeConditionSerializers;
import net.rockiecraft.foundaton.registry.config.CreateMoreFarmablesConfig;
import net.rockiecraft.foundaton.registry.fluids.AllFluidProperties;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

public final class CreateMoreFarmables {
    public static final String MOD_ID = "create_more_farmables";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final Configurator CONFIGURATOR = new Configurator(true);

    public static void init() {
        // Write common init code here.
        LOGGER.info("Initializing CreateMoreFarmables");
        CreateMoreFarmablesConfig.init();
        AllFluidProperties.FLUID_PROPERTIES.initialize();
        AllFluids.FLUIDS.init();
        AllBlocks.FLUIDS.init();
        AllBlocks.BLOCKS.init();

        AllItems.ITEMS.init();
        CONFIGURATOR.registerConfig(CreateMoreFarmablesConfig.class);
        CONFIGURATOR.saveConfig(CreateMoreFarmablesConfig.class);
        AllRecipeConditionSerializers.init();
    }
}
