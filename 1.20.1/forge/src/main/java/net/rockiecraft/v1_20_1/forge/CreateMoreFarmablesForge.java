package net.rockiecraft.v1_20_1.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.rockiecraft.v1_20_1.CreateMoreFarmables;
import net.rockiecraft.v1_20_1.common.forge.config.forge.ForgeMenuConfig;
import net.rockiecraft.v1_20_1.common.forge.recipe.forge.RecipeConditionImpl;
import net.rockiecraft.v1_20_1.forge.client.CreateMoreFarmablesForgeClient;
import net.rockiecraft.v1_20_1.infrastructure.config.AllRecipeConditionSerializers;
import net.rockiecraft.v1_20_1.foundation.fluids.platform.forge.FluidPlatformHelperImpl;
import net.rockiecraft.v1_20_1.foundation.recipe.dyesplashing.DyeSplashingFanProcessingType;
import net.rockiecraft.v1_20_1.foundation.recipe.dyesplashing.DyeSplashingRecipeType;
import net.rockiecraft.v1_20_1.foundation.recipe.moltenblasting.MoltenBlastingFanProcessingType;
import net.rockiecraft.v1_20_1.foundation.recipe.moltenblasting.MoltenBlastingRecipeType;

import static net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext.get;

@Mod(CreateMoreFarmables.MOD_ID)
public final class CreateMoreFarmablesForge {
    @SuppressWarnings("removal")
    public CreateMoreFarmablesForge() {
        EventBuses.registerModEventBus(CreateMoreFarmables.MOD_ID, get().getModEventBus());
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(CreateMoreFarmablesForgeClient::clientSetup);
        ForgeMenuConfig.register();
        CreateMoreFarmables.init();
        // Must run AFTER CreateMoreFarmables.init() - FLUID_TYPES only gets populated once
        // AllFluids's static fields have actually run (see FluidPlatformHelperImpl's javadoc).
        FluidPlatformHelperImpl.bindEventBus(modEventBus);
        // Needs Create on the classpath, which only forge/ and fabric/ depend on - see
        // common/build.gradle and CreateMoreFarmables.init() for why this isn't there anymore.
        DyeSplashingRecipeType.init();
        DyeSplashingFanProcessingType.register();
        MoltenBlastingRecipeType.init();
        MoltenBlastingFanProcessingType.register();
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            for (var serializer : AllRecipeConditionSerializers.getSerializers()) {
                CraftingHelper.register(new RecipeConditionImpl.Serializer(serializer));
            }

        });

    }
}
