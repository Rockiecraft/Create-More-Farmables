package net.rockiecraft.create_more_farmables;


import net.fabricmc.api.ModInitializer;
import net.rockiecraft.create_more_farmables.fluids.AllFluids;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.rockiecraft.create_more_farmables.fluids.AllFluids.register;


public class CreateMoreFarmables implements ModInitializer {

	public static final String ID = "create_more_farmables";
    public static final Logger LOGGER = LoggerFactory.getLogger(ID);


	@Override
	public void onInitialize() {
		AllItems.registerModItems();
		AllBlocks.registerModBlocks();
		AllFluids.register();
	}
}