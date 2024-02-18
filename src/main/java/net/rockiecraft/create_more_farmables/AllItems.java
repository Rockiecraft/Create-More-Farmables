package net.rockiecraft.create_more_farmables;



import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.world.item.Item;

import net.rockiecraft.create_more_farmables.item.*;

public class AllItems {

   public static final DeferredRegister<Item> ITEMS;

   /**
    * replace "MOLTEN_ENDSTONE_" with the name of the custom liquid you wish to put in a bucket.
    * keep in mind that the name is case-sensitive.
    */
// -----------------------------------------------------------------------------
// BucketItems
   public static final RegistryObject<BucketItem> MOLTEN_ENDSTONE_BUCKET;
   public static final RegistryObject<BucketItem> WHITE_DYED_WATER_BUCKET;
   public static final RegistryObject<BucketItem> LIGHT_GRAY_DYED_WATER_BUCKET;
   public static final RegistryObject<BucketItem> GRAY_DYED_WATER_BUCKET;
   public static final RegistryObject<BucketItem> BLACK_DYED_WATER_BUCKET;
   public static final RegistryObject<BucketItem> BROWN_DYED_WATER_BUCKET;
   public static final RegistryObject<BucketItem> RED_DYED_WATER_BUCKET;
   public static final RegistryObject<BucketItem> ORANGE_DYED_WATER_BUCKET;
   public static final RegistryObject<BucketItem> YELLOW_DYED_WATER_BUCKET;
   public static final RegistryObject<BucketItem> GREEN_DYED_WATER_BUCKET;
   public static final RegistryObject<BucketItem> LIME_DYED_WATER_BUCKET;
   public static final RegistryObject<BucketItem> CYAN_DYED_WATER_BUCKET;
   public static final RegistryObject<BucketItem> LIGHT_BLUE_DYED_WATER_BUCKET;
   public static final RegistryObject<BucketItem> BLUE_DYED_WATER_BUCKET;
   public static final RegistryObject<BucketItem> PURPLE_DYED_WATER_BUCKET;
   public static final RegistryObject<BucketItem> MAGENTA_DYED_WATER_BUCKET;
   public static final RegistryObject<BucketItem> PINK_DYED_WATER_BUCKET;
   // -----------------------------------------------------------------------------
   // Items
   public static final RegistryObject<Item> SHULKER_COMPOUND;
   public static final RegistryObject<Item> SHULKER_SHELL_FRAGMENT;
   public static final RegistryObject<Item> DYE_TEMPLATE;

   static {
      ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "create_more_farmables");

      SHULKER_COMPOUND = ITEMS.register("shulker_compound", () -> new Item(new Item.Properties()));

      SHULKER_SHELL_FRAGMENT = ITEMS.register("shulker_shell_fragment", () -> new Item(new Item.Properties()));

      DYE_TEMPLATE = ITEMS.register("dye_template", () -> new Item(new Item.Properties()));



      MOLTEN_ENDSTONE_BUCKET = ITEMS.register("molten_endstone_bucket", () -> {
         return new  BucketItem(AllFluids.MOLTEN_ENDSTONE, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
      });
      WHITE_DYED_WATER_BUCKET = ITEMS.register("white_dyed_water_bucket", () -> {
         return new  BucketItem(AllFluids.WHITE_DYED_WATER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
      });
      LIGHT_GRAY_DYED_WATER_BUCKET = ITEMS.register("light_gray_dyed_water_bucket", () -> {
         return new  BucketItem(AllFluids.LIGHT_GRAY_DYED_WATER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
      });
      GRAY_DYED_WATER_BUCKET = ITEMS.register("gray_dyed_water_bucket", () -> {
         return new  BucketItem(AllFluids.GRAY_DYED_WATER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
      });
      BLACK_DYED_WATER_BUCKET = ITEMS.register("black_dyed_water_bucket", () -> {
         return new  BucketItem(AllFluids.BLACK_DYED_WATER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
      });
      BROWN_DYED_WATER_BUCKET = ITEMS.register("brown_dyed_water_bucket", () -> {
         return new  BucketItem(AllFluids.BROWN_DYED_WATER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
      });
      RED_DYED_WATER_BUCKET = ITEMS.register("red_dyed_water_bucket", () -> {
         return new  BucketItem(AllFluids.RED_DYED_WATER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
      });
      ORANGE_DYED_WATER_BUCKET = ITEMS.register("orange_dyed_water_bucket", () -> {
         return new  BucketItem(AllFluids.ORANGE_DYED_WATER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
      });
      YELLOW_DYED_WATER_BUCKET = ITEMS.register("yellow_dyed_water_bucket", () -> {
         return new  BucketItem(AllFluids.YELLOW_DYED_WATER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
      });
      GREEN_DYED_WATER_BUCKET = ITEMS.register("green_dyed_water_bucket", () -> {
         return new  BucketItem(AllFluids.GREEN_DYED_WATER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
      });
      LIME_DYED_WATER_BUCKET = ITEMS.register("lime_dyed_water_bucket", () -> {
         return new  BucketItem(AllFluids.LIME_DYED_WATER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
      });
      CYAN_DYED_WATER_BUCKET = ITEMS.register("cyan_dyed_water_bucket", () -> {
         return new  BucketItem(AllFluids.CYAN_DYED_WATER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
      });
      LIGHT_BLUE_DYED_WATER_BUCKET = ITEMS.register("light_blue_dyed_water_bucket", () -> {
         return new  BucketItem(AllFluids.LIGHT_BLUE_DYED_WATER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
      });
      BLUE_DYED_WATER_BUCKET = ITEMS.register("blue_dyed_water_bucket", () -> {
         return new  BucketItem(AllFluids.BLUE_DYED_WATER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
      });
      PURPLE_DYED_WATER_BUCKET = ITEMS.register("purple_dyed_water_bucket", () -> {
         return new  BucketItem(AllFluids.PURPLE_DYED_WATER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
      });
      MAGENTA_DYED_WATER_BUCKET = ITEMS.register("magenta_dyed_water_bucket", () -> {
         return new  BucketItem(AllFluids.MAGENTA_DYED_WATER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
      });
      PINK_DYED_WATER_BUCKET = ITEMS.register("pink_dyed_water_bucket", () -> {
         return new  BucketItem(AllFluids.PINK_DYED_WATER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
      });


   }

   public static void register(IEventBus eventbus) {
      ITEMS.register(eventbus);
   }

}

