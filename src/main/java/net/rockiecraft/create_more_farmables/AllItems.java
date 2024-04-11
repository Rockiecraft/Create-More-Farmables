package net.rockiecraft.create_more_farmables;


import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

public class AllItems {

   public static final DeferredRegister<Item> ITEMS;

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateMoreFarmables.ID);
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

   public static final RegistryObject<Item> WOOD_STRING;

   // -----------------------------------------------------------------------------


    public static final RegistryObject<CreativeModeTab> CREATE_MORE_FARMABLES_TAB = CREATIVE_MODE_TABS.register("create_more_farmables",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(AllItems.SHULKER_SHELL_FRAGMENT.get()))
                    .title(Component.translatable("Create: More Farmables"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(AllItems.SHULKER_COMPOUND.get());
                        pOutput.accept(AllItems.SHULKER_SHELL_FRAGMENT.get());
                        pOutput.accept(AllItems.DYE_TEMPLATE.get());
                        pOutput.accept(AllItems.WOOD_STRING.get());


                        pOutput.accept(AllBlocks.WOOD_STRING_WOOL_BLOCK.get());

                        pOutput.accept(AllItems.MOLTEN_ENDSTONE_BUCKET.get());
                        pOutput.accept(AllItems.WHITE_DYED_WATER_BUCKET.get());
                        pOutput.accept(AllItems.LIGHT_GRAY_DYED_WATER_BUCKET.get());
                        pOutput.accept(AllItems.GRAY_DYED_WATER_BUCKET.get());
                        pOutput.accept(AllItems.BLACK_DYED_WATER_BUCKET.get());
                        pOutput.accept(AllItems.BROWN_DYED_WATER_BUCKET.get());
                        pOutput.accept(AllItems.RED_DYED_WATER_BUCKET.get());
                        pOutput.accept(AllItems.ORANGE_DYED_WATER_BUCKET.get());
                        pOutput.accept(AllItems.YELLOW_DYED_WATER_BUCKET.get());
                        pOutput.accept(AllItems.GREEN_DYED_WATER_BUCKET.get());
                        pOutput.accept(AllItems.LIME_DYED_WATER_BUCKET.get());
                        pOutput.accept(AllItems.CYAN_DYED_WATER_BUCKET.get());
                        pOutput.accept(AllItems.LIGHT_BLUE_DYED_WATER_BUCKET.get());
                        pOutput.accept(AllItems.BLUE_DYED_WATER_BUCKET.get());
                        pOutput.accept(AllItems.PURPLE_DYED_WATER_BUCKET.get());
                        pOutput.accept(AllItems.MAGENTA_DYED_WATER_BUCKET.get());
                        pOutput.accept(AllItems.PINK_DYED_WATER_BUCKET.get());

                    })
                    .build());
   // -----------------------------------------------------------------------------

   static {
      ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "create_more_farmables");

      SHULKER_COMPOUND = ITEMS.register("shulker_compound", () -> new Item(new Item.Properties()));

      SHULKER_SHELL_FRAGMENT = ITEMS.register("shulker_shell_fragment", () -> new Item(new Item.Properties()));

      DYE_TEMPLATE = ITEMS.register("dye_template", () -> new Item(new Item.Properties()));

      WOOD_STRING = ITEMS.register("wood_string", () -> new Item(new Item.Properties()));



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

