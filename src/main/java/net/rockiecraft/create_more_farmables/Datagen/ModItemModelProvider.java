package net.rockiecraft.create_more_farmables.Datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.rockiecraft.create_more_farmables.AllItems;
import net.rockiecraft.create_more_farmables.CreateMoreFarmables;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CreateMoreFarmables.ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(AllItems.DYE_TEMPLATE);
        simpleItem(AllItems.WOOD_STRING);
        simpleItem(AllItems.SHULKER_COMPOUND);
        simpleItem(AllItems.SHULKER_SHELL_FRAGMENT);
        simpleItem(AllItems.NETHERITE_DUST);
        simpleItem(AllItems.UNPROCESSED_NETHERITE_DUST);
        simpleItem(AllItems.UNPROCESSED_BLAZE_ROD);
        simpleBucketItem(AllItems.WHITE_DYED_WATER_BUCKET);
        simpleBucketItem(AllItems.LIGHT_GRAY_DYED_WATER_BUCKET);
        simpleBucketItem(AllItems.GRAY_DYED_WATER_BUCKET);
        simpleBucketItem(AllItems.BLACK_DYED_WATER_BUCKET);
        simpleBucketItem(AllItems.BROWN_DYED_WATER_BUCKET);
        simpleBucketItem(AllItems.RED_DYED_WATER_BUCKET);
        simpleBucketItem(AllItems.ORANGE_DYED_WATER_BUCKET);
        simpleBucketItem(AllItems.YELLOW_DYED_WATER_BUCKET);
        simpleBucketItem(AllItems.GREEN_DYED_WATER_BUCKET);
        simpleBucketItem(AllItems.LIME_DYED_WATER_BUCKET);
        simpleBucketItem(AllItems.CYAN_DYED_WATER_BUCKET);
        simpleBucketItem(AllItems.LIGHT_BLUE_DYED_WATER_BUCKET);
        simpleBucketItem(AllItems.BLUE_DYED_WATER_BUCKET);
        simpleBucketItem(AllItems.PURPLE_DYED_WATER_BUCKET);
        simpleBucketItem(AllItems.MAGENTA_DYED_WATER_BUCKET);
        simpleBucketItem(AllItems.PINK_DYED_WATER_BUCKET);
    }
    private void simpleItem(RegistryObject<Item> item) {
        withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CreateMoreFarmables.ID, "item/" + item.getId().getPath()));
    }
    private void simpleBucketItem(RegistryObject<BucketItem> bucketItem) {
        withExistingParent(bucketItem.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CreateMoreFarmables.ID, "item/" + bucketItem.getId().getPath()));
    }
}
