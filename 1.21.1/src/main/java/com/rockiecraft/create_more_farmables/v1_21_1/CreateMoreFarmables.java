package com.rockiecraft.create_more_farmables.v1_21_1;

import com.rockiecraft.create_more_farmables.v1_21_1.foundation.AllBlocks;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.AllFluids;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.AllItems;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.CmfDataComponents;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.ModCreativeTabs;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.advancedassembly.AdvancedAssemblyRecipeType;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.dyesplashing.DyeSplashingFanProcessingType;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.dyesplashing.DyeSplashingRecipeType;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.moltenblasting.MoltenBlastingFanProcessingType;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.moltenblasting.MoltenBlastingRecipeType;
import com.rockiecraft.create_more_farmables.v1_21_1.infrastructure.config.AllRecipeConditionSerializers;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.damagetypes.AllDamageTypeProviders;
import com.rockiecraft.create_more_farmables.v1_21_1.infrastructure.config.CreateMoreFarmablesConfig;
import com.simibubi.create.api.registry.CreateBuiltInRegistries;
import com.teamresourceful.resourcefulconfig.api.loader.Configurator;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.ModContainer;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(CreateMoreFarmables.MODID)
public class CreateMoreFarmables {

    public static final String MODID = "create_more_farmables";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final Configurator CONFIGURATOR = new Configurator("create_more_farmables");

    public CreateMoreFarmables(IEventBus modEventBus, ModContainer modContainer) {
        AllRecipeConditionSerializers.init(modEventBus);
        CONFIGURATOR.register(CreateMoreFarmablesConfig.class);

        AllFluids.init(modEventBus);
        AllBlocks.BLOCKS.init();
        AllItems.BASIC_ITEMS.init();
        ModCreativeTabs.CREATIVE_TABS.init();
        modEventBus.addListener(AllDamageTypeProviders::onGatherData);
        CmfDataComponents.init(modEventBus);

        DyeSplashingRecipeType.init(modEventBus);
        MoltenBlastingRecipeType.init(modEventBus);

        AdvancedAssemblyRecipeType.init(modEventBus);

        modEventBus.addListener(CreateMoreFarmables::onRegister);
    }

    private static void onRegister(final RegisterEvent event) {
        if (event.getRegistry() == CreateBuiltInRegistries.FAN_PROCESSING_TYPE) {
            DyeSplashingFanProcessingType.register();
            MoltenBlastingFanProcessingType.register();
        }
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
}
