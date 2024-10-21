package net.rockiecraft.create_more_farmables;


import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import static net.rockiecraft.create_more_farmables.CreativeModeTabs.addToTab;

public class AllItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "create_more_farmables");

 //-----------------------------------------------------------------------------

    public static final RegistryObject<Item> NETHERITE_DUST = addToTab(ITEMS.register("netherite_dust",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.COMMON)
            )));


    public static final RegistryObject<Item> UNPROCESSED_NETHERITE_DUST = addToTab(ITEMS.register("unprocessed_netherite_dust",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.COMMON)
            )));

    public static final RegistryObject<Item> UNPROCESSED_BLAZE_ROD = addToTab(ITEMS.register("unprocessed_blaze_rod",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.COMMON)
            )));

    public static final RegistryObject<Item> SHULKER_COMPOUND = addToTab(ITEMS.register("shulker_compound",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.COMMON)
            )));

    public static final RegistryObject<Item> SHULKER_SHELL_FRAGMENT = addToTab(ITEMS.register("shulker_shell_fragment",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.COMMON)
            )));

    public static final RegistryObject<Item> DYE_TEMPLATE = addToTab(ITEMS.register("dye_template",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.COMMON)
            )));

    public static final RegistryObject<Item>  WOOD_STRING = addToTab(ITEMS.register("wood_string",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.COMMON)
            )));

    public static final RegistryObject<BlockItem> WOOD_STRING_WOOL_BLOCK = addToTab(ITEMS.register("wood_string_wool_block",
            () -> new BlockItem(AllBlocks.WOOD_STRING_WOOL_BLOCK.get(),
                    new Item.Properties()
                            .rarity(Rarity.UNCOMMON)
            )));

    //-----------------------------------------------------------------------------

    public static final RegistryObject<BucketItem> LIQUID_REDSTONE_BUCKET = addToTab(ITEMS.register("liquid_redstone_bucket",
            () -> new BucketItem(AllFluids.LIQUID_REDSTONE, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .rarity(Rarity.COMMON))
    ));

    public static final RegistryObject<BucketItem> MOLTEN_ENDSTONE_BUCKET = addToTab(ITEMS.register("molten_endstone_bucket",
            () -> new BucketItem(AllFluids.MOLTEN_ENDSTONE, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .rarity(Rarity.COMMON))
            ));

    public static final RegistryObject<BucketItem> WHITE_DYED_WATER_BUCKET = addToTab(ITEMS.register("white_dyed_water_bucket",
            () -> new BucketItem(AllFluids.WHITE_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .rarity(Rarity.COMMON))
    ));

    public static final RegistryObject<BucketItem> LIGHT_GRAY_DYED_WATER_BUCKET = addToTab(ITEMS.register("light_gray_dyed_water_bucket",
            () -> new BucketItem(AllFluids.LIGHT_GRAY_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .rarity(Rarity.COMMON))
    ));

    public static final RegistryObject<BucketItem> GRAY_DYED_WATER_BUCKET = addToTab(ITEMS.register("gray_dyed_water_bucket",
            () -> new BucketItem(AllFluids.GRAY_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .rarity(Rarity.COMMON))
    ));

    public static final RegistryObject<BucketItem> BLACK_DYED_WATER_BUCKET = addToTab(ITEMS.register("black_dyed_water_bucket",
            () -> new BucketItem(AllFluids.BLACK_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .rarity(Rarity.COMMON))
    ));

    public static final RegistryObject<BucketItem> BROWN_DYED_WATER_BUCKET = addToTab(ITEMS.register("brown_dyed_water_bucket",
            () -> new BucketItem(AllFluids.BROWN_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .rarity(Rarity.COMMON))
    ));

    public static final RegistryObject<BucketItem> RED_DYED_WATER_BUCKET = addToTab(ITEMS.register("red_dyed_water_bucket",
            () -> new BucketItem(AllFluids.RED_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .rarity(Rarity.COMMON))
    ));

    public static final RegistryObject<BucketItem> ORANGE_DYED_WATER_BUCKET = addToTab(ITEMS.register("orange_dyed_water_bucket",
            () -> new BucketItem(AllFluids.ORANGE_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .rarity(Rarity.COMMON))
    ));

    public static final RegistryObject<BucketItem> YELLOW_DYED_WATER_BUCKET = addToTab(ITEMS.register("yellow_dyed_water_bucket",
            () -> new BucketItem(AllFluids.YELLOW_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .rarity(Rarity.COMMON))
    ));

    public static final RegistryObject<BucketItem> GREEN_DYED_WATER_BUCKET = addToTab(ITEMS.register("green_dyed_water_bucket",
            () -> new BucketItem(AllFluids.GREEN_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .rarity(Rarity.COMMON))
    ));

    public static final RegistryObject<BucketItem> LIME_DYED_WATER_BUCKET = addToTab(ITEMS.register("lime_dyed_water_bucket",
            () -> new BucketItem(AllFluids.LIME_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .rarity(Rarity.COMMON))
    ));

    public static final RegistryObject<BucketItem> CYAN_DYED_WATER_BUCKET = addToTab(ITEMS.register("cyan_dyed_water_bucket",
            () -> new BucketItem(AllFluids.CYAN_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .rarity(Rarity.COMMON))
    ));

    public static final RegistryObject<BucketItem> LIGHT_BLUE_DYED_WATER_BUCKET = addToTab(ITEMS.register("light_blue_dyed_water_bucket",
            () -> new BucketItem(AllFluids.LIGHT_BLUE_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .rarity(Rarity.COMMON))
    ));

    public static final RegistryObject<BucketItem> BLUE_DYED_WATER_BUCKET = addToTab(ITEMS.register("blue_dyed_water_bucket",
            () -> new BucketItem(AllFluids.BLUE_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .rarity(Rarity.COMMON))
    ));

    public static final RegistryObject<BucketItem> PURPLE_DYED_WATER_BUCKET = addToTab(ITEMS.register("purple_dyed_water_bucket",
            () -> new BucketItem(AllFluids.PURPLE_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .rarity(Rarity.COMMON))
    ));

    public static final RegistryObject<BucketItem> MAGENTA_DYED_WATER_BUCKET = addToTab(ITEMS.register("magenta_dyed_water_bucket",
            () -> new BucketItem(AllFluids.MAGENTA_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .rarity(Rarity.COMMON))
    ));

    public static final RegistryObject<BucketItem> PINK_DYED_WATER_BUCKET = addToTab(ITEMS.register("pink_dyed_water_bucket",
            () -> new BucketItem(AllFluids.PINK_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .rarity(Rarity.COMMON))
    ));

   public static void register(IEventBus eventbus) {
      ITEMS.register(eventbus);
   }

}

