package net.rockiecraft.v1_19_2.common.forge.datagen.providers;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.rockiecraft.v1_19_2.CreateMoreFarmables;
import net.rockiecraft.v1_20_1.foundation.AllItems;

public class CMFItemModelProvider extends ItemModelProvider {
    public CMFItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, CreateMoreFarmables.MOD_ID, existingFileHelper);
    }

    @SuppressWarnings("removal")
    @Override
    protected void registerModels() {
        basicItem(AllItems.ECHO_SHARD_DUST.get());
        basicItem(AllItems.ENDER_PEARL_DUST.get());
        basicItem(AllItems.NETHERITE_DUST.get());
        basicItem(AllItems.UNPROCESSED_NETHERITE_DUST.get());
        basicItem(AllItems.SHULKER_SHELL_FRAGMENT.get());
        basicItem(AllItems.HEART_OF_THE_SEA_FRAGMENT.get());
        basicItem(AllItems.NAUTILUS_SHELL_FRAGMENT.get());

        basicItem(AllItems.UNPROCESSED_BLAZE_ROD.get());
        basicItem(AllItems.SHULKER_COMPOUND.get());
        basicItem(AllItems.DYE_TEMPLATE.get());
        basicItem(AllItems.WOOD_STRING.get());

        basicItem(AllItems.REDSTONE_LINK_FREQ_TAG_1.get());

//        basicItem(AllItems.LIQUID_QUARTZ_BUCKET.get());
//        basicItem(AllItems.LIQUID_REDSTONE_BUCKET.get());
//        basicItem(AllItems.MOLTEN_ENDSTONE_BUCKET.get());
//
//        basicItem(AllItems.WHITE_DYED_WATER_BUCKET.get());
//        basicItem(AllItems.LIGHT_GRAY_DYED_WATER_BUCKET.get());
//        basicItem(AllItems.GRAY_DYED_WATER_BUCKET.get());
//        basicItem(AllItems.BLACK_DYED_WATER_BUCKET.get());
//        basicItem(AllItems.BROWN_DYED_WATER_BUCKET.get());
//        basicItem(AllItems.RED_DYED_WATER_BUCKET.get());
//        basicItem(AllItems.ORANGE_DYED_WATER_BUCKET.get());
//        basicItem(AllItems.YELLOW_DYED_WATER_BUCKET.get());
//        basicItem(AllItems.GREEN_DYED_WATER_BUCKET.get());
//        basicItem(AllItems.LIME_DYED_WATER_BUCKET.get());
//        basicItem(AllItems.CYAN_DYED_WATER_BUCKET.get());
//        basicItem(AllItems.LIGHT_BLUE_DYED_WATER_BUCKET.get());
//        basicItem(AllItems.BLUE_DYED_WATER_BUCKET.get());
//        basicItem(AllItems.PURPLE_DYED_WATER_BUCKET.get());
//        basicItem(AllItems.MAGENTA_DYED_WATER_BUCKET.get());
//        basicItem(AllItems.PINK_DYED_WATER_BUCKET.get());
    }
}
