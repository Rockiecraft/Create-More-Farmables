package net.rockiecraft.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.rockiecraft.CreateMoreFarmables;

import static net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext.get;

@Mod(CreateMoreFarmables.MOD_ID)
public final class CreateMoreFarmablesForge {
    @SuppressWarnings("removal")
    public CreateMoreFarmablesForge() {
        EventBuses.registerModEventBus(CreateMoreFarmables.MOD_ID,
                get().getModEventBus());
        CreateMoreFarmables.init();
    }
}
