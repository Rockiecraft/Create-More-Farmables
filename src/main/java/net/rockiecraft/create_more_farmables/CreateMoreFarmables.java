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
import net.rockiecraft.create_more_farmables.item.ModCreativeModTabs;
import org.slf4j.Logger;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CreateMoreFarmables.ID)
public class CreateMoreFarmables
{
    // Define mod id in a common place for everything to reference
    public static final String ID = "create_more_farmables";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public CreateMoreFarmables() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        AllFluids.REGISTRY.register(modEventBus);
        AllBlocks.REGISTRY.register(modEventBus);
        AllFluidTypes.REGISTRY.register(modEventBus);
        AllItems.register(modEventBus);
        ModCreativeModTabs.register(modEventBus);
    }
    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = ID, bus = Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }


}
