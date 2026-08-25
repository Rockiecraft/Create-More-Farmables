package net.rockiecraft.v1_19_2.common.forge.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.rockiecraft.v1_19_2.CreateMoreFarmables;
import net.rockiecraft.v1_19_2.common.forge.datagen.providers.CMFBlockStateProvider;
import net.rockiecraft.v1_19_2.common.forge.datagen.providers.CMFItemModelProvider;

@Mod.EventBusSubscriber(modid = CreateMoreFarmables.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CMFForgeDatagen {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        if (event.includeClient()) {

        generator.addProvider(event.includeClient(), new CMFBlockStateProvider(generator, existingFileHelper));
        generator.addProvider(event.includeClient(), new CMFItemModelProvider(generator, existingFileHelper));
        }

    }
}
