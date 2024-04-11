package net.rockiecraft.create_more_farmables;

import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;


@Mod(CreateMoreFarmables.ID)
public class CreateMoreFarmables
{

    public static final String ID = "create_more_farmables";

    private static final Logger LOGGER = LogUtils.getLogger();
    public CreateMoreFarmables() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        AllItems.CREATIVE_MODE_TABS.register(modEventBus);

        AllFluids.REGISTRY.register(modEventBus);
        AllBlocks.register(modEventBus);
        AllItems.register(modEventBus);

        AllFluids.BLOCKS.register(modEventBus);
        AllFluids.FLUIDS.register(modEventBus);
        AllFluids.FLUID_TYPES.register(modEventBus);
    }
    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }


    @EventBusSubscriber(modid = ID, bus = Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }


}
