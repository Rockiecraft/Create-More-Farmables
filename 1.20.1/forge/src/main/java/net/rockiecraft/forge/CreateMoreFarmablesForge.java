package net.rockiecraft.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.rockiecraft.CreateMoreFarmables;
import net.rockiecraft.common.forge.config.forge.ForgeMenuConfig;
import net.rockiecraft.common.forge.recipe.forge.RecipeConditionImpl;
import net.rockiecraft.foundaton.registry.recipe.condition.AllRecipeConditionSerializers;

import static net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext.get;

@Mod(CreateMoreFarmables.MOD_ID)
public final class CreateMoreFarmablesForge {
    @SuppressWarnings("removal")
    public CreateMoreFarmablesForge() {
        EventBuses.registerModEventBus(CreateMoreFarmables.MOD_ID, get().getModEventBus());
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
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
