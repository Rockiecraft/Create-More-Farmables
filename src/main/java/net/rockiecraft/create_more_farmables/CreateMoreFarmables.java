package net.rockiecraft.create_more_farmables;


import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;



@Mod(CreateMoreFarmables.ID)
public class CreateMoreFarmables
{
    public static final String ID = "create_more_farmables";

    public CreateMoreFarmables() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        CreativeModeTabs.TABS.register(bus);

        //AllItems.CREATIVE_MODE_TABS.register(modEventBus);

        AllFluids.REGISTRY.register(modEventBus);
        AllBlocks.register(modEventBus);
        AllItems.register(modEventBus);

        AllFluids.BLOCKS.register(modEventBus);
        AllFluids.FLUIDS.register(modEventBus);
        AllFluids.FLUID_TYPES.register(modEventBus);
    }


}
