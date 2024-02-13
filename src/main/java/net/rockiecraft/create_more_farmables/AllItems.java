package net.rockiecraft.create_more_farmables;



import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.world.item.Item;

import net.rockiecraft.create_more_farmables.item.*;

public class AllItems {
   public static final DeferredRegister<Item> ITEMS =
           DeferredRegister.create(ForgeRegistries.ITEMS, CreateMoreFarmables.ID);
   /**
    * replace "MOLTEN_ENDSTONE_" with the name of the custom liquid you wish to put in a bucket.
    * keep in mind that the name is case-sensitive.
    */
   public static final RegistryObject<Item> MOLTEN_ENDSTONE_BUCKET = ITEMS.register("molten_endstone_bucket", () -> new MoltenEndstoneBucketItem());
   public static final RegistryObject<Item> WHITE_DYED_WATER_BUCKET = ITEMS.register("white_dyed_water_bucket", () -> new WhiteDyedWaterBucketItem());
   public static final RegistryObject<Item> BLACK_DYED_WATER_BUCKET = ITEMS.register("black_dyed_water_bucket", () -> new BlackDyedWaterBucketItem());
   public static final RegistryObject<Item> GRAY_DYED_WATER_BUCKET = ITEMS.register("gray_dyed_water_bucket", () -> new GrayDyedWaterBucketItem());
   public static final RegistryObject<Item> BLUE_DYED_WATER_BUCKET = ITEMS.register("blue_dyed_water_bucket", () -> new BlueDyedWaterBucketItem());
   public static final RegistryObject<Item> RED_DYED_WATER_BUCKET = ITEMS.register("red_dyed_water_bucket", () -> new RedDyedWaterBucketItem());
   public static final RegistryObject<Item> PURPLE_DYED_WATER_BUCKET = ITEMS.register("purple_dyed_water_bucket", () -> new PurpleDyedWaterBucketItem());
   public static final RegistryObject<Item> PINK_DYED_WATER_BUCKET = ITEMS.register("pink_dyed_water_bucket", () -> new PinkDyedWaterBucketItem());
   public static final RegistryObject<Item> MAGENTA_DYED_WATER_BUCKET = ITEMS.register("magenta_dyed_water_bucket", () -> new MagentaDyedWaterBucketItem());
   public static final RegistryObject<Item> LIGHT_GRAY_DYED_WATER_BUCKET = ITEMS.register("light_gray_dyed_water_bucket", () -> new LightGrayDyedWaterBucketItem());
   public static final RegistryObject<Item> GREEN_DYED_WATER_BUCKET = ITEMS.register("green_dyed_water_bucket", () -> new GreenDyedWaterBucketItem());
   public static final RegistryObject<Item> LIME_DYED_WATER_BUCKET = ITEMS.register("lime_dyed_water_bucket", () -> new LimeDyedWaterBucketItem());
   public static final RegistryObject<Item> CYAN_DYED_WATER_BUCKET = ITEMS.register("cyan_dyed_water_bucket", () -> new CyanDyedWaterBucketItem());
   public static final RegistryObject<Item> LIGHT_BLUE_DYED_WATER_BUCKET = ITEMS.register("light_blue_dyed_water_bucket", () -> new LightBlueDyedWaterBucketItem());
   public static final RegistryObject<Item> BROWN_DYED_WATER_BUCKET = ITEMS.register("brown_dyed_water_bucket", () -> new BrownDyedWaterBucketItem());
   public static final RegistryObject<Item> ORANGE_DYED_WATER_BUCKET = ITEMS.register("orange_dyed_water_bucket", () -> new OrangeDyedWaterBucketItem());
   public static final RegistryObject<Item> YELLOW_DYED_WATER_BUCKET = ITEMS.register("yellow_dyed_water_bucket", () -> new YellowDyedWaterBucketItem());

   public static final RegistryObject<Item> SHULKER_COMPOUND = ITEMS.register("shulker_compound",
           () -> new Item(new Item.Properties()));
   public static final RegistryObject<Item> SHULKER_SHELL_FRAGMENT = ITEMS.register("shulker_shell_fragment",
           () -> new Item(new Item.Properties()));

   public static final RegistryObject<Item> DYE_TEMPLATE = ITEMS.register("dye_template",
           () -> new Item(new Item.Properties()));

   public static void register(IEventBus eventbus) {
      ITEMS.register(eventbus);
   }

}

