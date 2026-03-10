package net.rockiecraft;

import dev.architectury.registry.client.rendering.ColorHandlerRegistry;
import net.rockiecraft.fluids.AllFluidProperties;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

public final class CreateMoreFarmables {
    public static final String MOD_ID = "create_more_farmables";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        // Write common init code here.
        LOGGER.info("Initializing CreateMoreFarmables");
        AllFluidProperties.FLUID_PROPERTIES.initialize();
        AllFluids.FLUIDS.init();
        AllBlocks.FLUIDS.init();
        AllBlocks.BLOCKS.init();

        AllItems.ITEMS.init();

        CreativeModeTabs.init();

    }
}
