package net.rockiecraft.forge;

import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.rockiecraft.CreateMoreFarmables;
import net.rockiecraft.common.forge.config.forge.ForgeMenuConfig;
import net.rockiecraft.common.forge.recipe.forge.RecipeConditionImpl;
import net.rockiecraft.foundaton.registry.AllRecipeConditionSerializers;
import net.rockiecraft.foundaton.registry.CreateMoreFarmablesConfig;

@SuppressWarnings("removal")
@Mod(CreateMoreFarmables.MOD_ID)
public final class CreateMoreFarmablesForge {
    public CreateMoreFarmablesForge() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        CreateMoreFarmables.CONFIGURATOR.registerConfig(CreateMoreFarmablesConfig.class);
        ForgeMenuConfig.register();
        CreateMoreFarmables.init();
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            for (var serializer : AllRecipeConditionSerializers.getSerializers()) {
                CraftingHelper.register(new RecipeConditionImpl.Serializer(serializer));
            }
        });

    }
}
