package net.rockiecraft.foundaton;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import dev.architectury.registry.CreativeTabRegistry;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.rockiecraft.CreateMoreFarmables;
import net.rockiecraft.foundaton.registry.config.CreateMoreFarmablesConfig;
import net.rockiecraft.foundaton.registry.fluids.AllFluidProperties;
import net.minecraft.resources.ResourceLocation;
import earth.terrarium.botarium.api.registry.fluid.FluidBucketItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.function.Supplier;


public class AllItems {


    public static final ResourcefulRegistry<Item> ITEMS = ResourcefulRegistries.create(Registry.ITEM, CreateMoreFarmables.MOD_ID);
    public static final ResourcefulRegistry<Item> BASIC_ITEMS = ResourcefulRegistries.create(ITEMS);
//
//    public static final CreativeModeTab MAIN_TAB = CreativeTabRegistry.create(
//            new ResourceLocation(CreateMoreFarmables.MOD_ID, "main_tab"),
//            () -> new ItemStack(AllItems.SHULKER_SHELL_FRAGMENT.get())
//    );

    public static final CreativeModeTab MAIN_TAB = new CreativeModeTab(2, CreateMoreFarmables.MOD_ID + ".main_tab") {
        @Override
        public ItemStack makeIcon() {
            // Use your preferred icon item here
            return new ItemStack(AllItems.SHULKER_SHELL_FRAGMENT.get());
        }

        @Override
        public void fillItemList(NonNullList<ItemStack> items) {
            // Fragments & Dusts
            items.add(new ItemStack(AllItems.ECHO_SHARD_DUST.get()));
            items.add(new ItemStack(AllItems.ENDER_PEARL_DUST.get()));
            items.add(new ItemStack(AllItems.NETHERITE_DUST.get()));
            items.add(new ItemStack(AllItems.UNPROCESSED_NETHERITE_DUST.get()));
            items.add(new ItemStack(AllItems.SHULKER_SHELL_FRAGMENT.get()));
            items.add(new ItemStack(AllItems.HEART_OF_THE_SEA_FRAGMENT.get()));
            items.add(new ItemStack(AllItems.NAUTILUS_SHELL_FRAGMENT.get()));

            //
            items.add(new ItemStack(AllItems.UNPROCESSED_BLAZE_ROD.get()));
            items.add(new ItemStack(AllItems.SHULKER_COMPOUND.get()));
            items.add(new ItemStack(AllItems.DYE_TEMPLATE.get()));
            items.add(new ItemStack(AllItems.WOOD_STRING.get()));
            items.add(new ItemStack(AllItems.WOOD_STRING_WOOL_BLOCK.get()));
            //
            items.add(new ItemStack(AllItems.LIQUID_QUARTZ_BUCKET.get()));
            items.add(new ItemStack(AllItems.LIQUID_REDSTONE_BUCKET.get()));
            items.add(new ItemStack(AllItems.MOLTEN_ENDSTONE_BUCKET.get()));

            //
            items.add(new ItemStack(AllItems.WHITE_DYED_WATER_BUCKET.get()));
            items.add(new ItemStack(AllItems.LIGHT_GRAY_DYED_WATER_BUCKET.get()));
            items.add(new ItemStack(AllItems.GRAY_DYED_WATER_BUCKET.get()));
            items.add(new ItemStack(AllItems.BLACK_DYED_WATER_BUCKET.get()));
            items.add(new ItemStack(AllItems.BROWN_DYED_WATER_BUCKET.get()));
            items.add(new ItemStack(AllItems.RED_DYED_WATER_BUCKET.get()));
            items.add(new ItemStack(AllItems.ORANGE_DYED_WATER_BUCKET.get()));
            items.add(new ItemStack(AllItems.YELLOW_DYED_WATER_BUCKET.get()));
            items.add(new ItemStack(AllItems.GREEN_DYED_WATER_BUCKET.get()));
            items.add(new ItemStack(AllItems.LIME_DYED_WATER_BUCKET.get()));
            items.add(new ItemStack(AllItems.CYAN_DYED_WATER_BUCKET.get()));
            items.add(new ItemStack(AllItems.LIGHT_BLUE_DYED_WATER_BUCKET.get()));
            items.add(new ItemStack(AllItems.BLUE_DYED_WATER_BUCKET.get()));
            items.add(new ItemStack(AllItems.PURPLE_DYED_WATER_BUCKET.get()));
            items.add(new ItemStack(AllItems.MAGENTA_DYED_WATER_BUCKET.get()));
            items.add(new ItemStack(AllItems.PINK_DYED_WATER_BUCKET.get()));
        }
        private void add(NonNullList<ItemStack> items, Supplier<? extends ItemLike> item) {
            items.add(new ItemStack(item.get()));
        }
    };

//    public static final RegistryEntry<Item> __BUCKET = BASIC_ITEMS.register("_bucket", () -> new FluidBucketItem(
//            AllFluidProperties.FLUIDHERE,
//            new Item.Properties()
//            .craftRemainder(Items.BUCKET)
//            .stacksTo(1))
//    );

//    public static final RegistryEntry<Item> _BLOCK  = BASIC_ITEMS.register("_block", () -> new BlockItem(
//            AllBlocks._BLOCK.get(),
//            new Item.Properties()
//            .rarity(Rarity.UNCOMMON)
//                    .stacksTo(64)
//    ));




//    public static final RegistryEntry<Item>  = BASIC_ITEMS.register("", () -> new Item(new Item.Properties()));

    public static final RegistryEntry<Item> ECHO_SHARD_DUST  = BASIC_ITEMS.register("echo_shard_dust",
            () -> new Item(new Item.Properties()
                    .tab(MAIN_TAB)
            ));

    public static final RegistryEntry<Item> ENDER_PEARL_DUST  = BASIC_ITEMS.register("ender_pearl_dust",
            () -> new Item(new Item.Properties()
                    .tab(MAIN_TAB)
            ));

    public static final RegistryEntry<Item> NETHERITE_DUST = BASIC_ITEMS.register("netherite_dust",
            () -> new Item(new Item.Properties()
                    .tab(MAIN_TAB)
            ));

    public static final RegistryEntry<Item> UNPROCESSED_NETHERITE_DUST = BASIC_ITEMS.register("unprocessed_netherite_dust",
            () -> new Item(new Item.Properties()
                    .tab(MAIN_TAB)
            ));

    public static final RegistryEntry<Item> NAUTILUS_SHELL_FRAGMENT = BASIC_ITEMS.register("nautilus_shell_fragment",
            () -> new Item(new Item.Properties()
                    .tab(MAIN_TAB)
            ));

    public static final RegistryEntry<Item> HEART_OF_THE_SEA_FRAGMENT  = BASIC_ITEMS.register("heart_of_the_sea_fragment",
            () -> new Item(new Item.Properties()
                    .tab(MAIN_TAB)
            ));

    public static final RegistryEntry<Item> SHULKER_SHELL_FRAGMENT  = BASIC_ITEMS.register("shulker_shell_fragment",
            () -> new Item(new Item.Properties()
                    .tab(MAIN_TAB)
            ));

    public static final RegistryEntry<Item> SHULKER_COMPOUND = BASIC_ITEMS.register("shulker_compound",
            () -> new Item(new Item.Properties()
                    .tab(MAIN_TAB)
            ));

    public static final RegistryEntry<Item> UNPROCESSED_BLAZE_ROD = BASIC_ITEMS.register("unprocessed_blaze_rod",
            () -> new Item(new Item.Properties()
                    .tab(MAIN_TAB)
            ));

    public static final RegistryEntry<Item> DYE_TEMPLATE = BASIC_ITEMS.register("dye_template",
            () -> new Item(new Item.Properties()
                    .tab(MAIN_TAB)
            ));

    public static final RegistryEntry<Item> WOOD_STRING = BASIC_ITEMS.register("wood_string",
            () -> new Item(new Item.Properties()
                    .tab(MAIN_TAB)
            ));



    public static final RegistryEntry<Item> WOOD_STRING_WOOL_BLOCK  = BASIC_ITEMS.register("wood_string_wool_block",
            () -> new BlockItem(AllBlocks.WOOD_STRING_WOOL_BLOCK.get(), new Item.Properties()
                    .rarity(Rarity.UNCOMMON)
                    .stacksTo(64)
                    .tab(MAIN_TAB)
            ));


    public static final RegistryEntry<Item> LIQUID_QUARTZ_BUCKET = BASIC_ITEMS.register("liquid_quartz_bucket",
            () -> new FluidBucketItem(AllFluidProperties.LIQUID_QUARTZ, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .tab(MAIN_TAB)
            ));

    public static final RegistryEntry<Item> LIQUID_REDSTONE_BUCKET = BASIC_ITEMS.register("liquid_redstone_bucket",
            () -> new FluidBucketItem(AllFluidProperties.LIQUID_REDSTONE, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .tab(MAIN_TAB)
            ));
    public static final RegistryEntry<Item> MOLTEN_ENDSTONE_BUCKET = BASIC_ITEMS.register("molten_endstone_bucket",
            () -> new FluidBucketItem(AllFluidProperties.MOLTEN_ENDSTONE, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .tab(MAIN_TAB)
            ));


    public static final RegistryEntry<Item> WHITE_DYED_WATER_BUCKET = BASIC_ITEMS.register("white_dyed_water_bucket",
            () -> new FluidBucketItem(AllFluidProperties.WHITE_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .tab(MAIN_TAB)
            ));
    public static final RegistryEntry<Item> LIGHT_GRAY_DYED_WATER_BUCKET = BASIC_ITEMS.register("light_gray_dyed_water_bucket",
            () -> new FluidBucketItem(AllFluidProperties.LIGHT_GRAY_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .tab(MAIN_TAB)
            ));
    public static final RegistryEntry<Item> GRAY_DYED_WATER_BUCKET = BASIC_ITEMS.register("gray_dyed_water_bucket",
            () -> new FluidBucketItem(AllFluidProperties.GRAY_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .tab(MAIN_TAB)
            ));
    public static final RegistryEntry<Item> BLACK_DYED_WATER_BUCKET = BASIC_ITEMS.register("black_dyed_water_bucket",
            () -> new FluidBucketItem(AllFluidProperties.BLACK_DYED_WATER,
            new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .tab(MAIN_TAB)
            ));
    public static final RegistryEntry<Item> BROWN_DYED_WATER_BUCKET = BASIC_ITEMS.register("brown_dyed_water_bucket",
            () -> new FluidBucketItem(AllFluidProperties.BROWN_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .tab(MAIN_TAB)
            ));
    public static final RegistryEntry<Item> RED_DYED_WATER_BUCKET = BASIC_ITEMS.register("red_dyed_water_bucket",
            () -> new FluidBucketItem(AllFluidProperties.RED_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .tab(MAIN_TAB)
            ));
    public static final RegistryEntry<Item> ORANGE_DYED_WATER_BUCKET = BASIC_ITEMS.register("orange_dyed_water_bucket",
            () -> new FluidBucketItem(AllFluidProperties.ORANGE_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .tab(MAIN_TAB)
            ));
    public static final RegistryEntry<Item> YELLOW_DYED_WATER_BUCKET = BASIC_ITEMS.register("yellow_dyed_water_bucket",
            () -> new FluidBucketItem(AllFluidProperties.YELLOW_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .tab(MAIN_TAB)
            ));
    public static final RegistryEntry<Item> GREEN_DYED_WATER_BUCKET = BASIC_ITEMS.register("green_dyed_water_bucket",
            () -> new FluidBucketItem(AllFluidProperties.GREEN_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .tab(MAIN_TAB)
            ));
    public static final RegistryEntry<Item> LIME_DYED_WATER_BUCKET = BASIC_ITEMS.register("lime_dyed_water_bucket",
            () -> new FluidBucketItem(AllFluidProperties.LIME_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .tab(MAIN_TAB)
            ));
    public static final RegistryEntry<Item> CYAN_DYED_WATER_BUCKET = BASIC_ITEMS.register("cyan_dyed_water_bucket",
            () -> new FluidBucketItem(AllFluidProperties.CYAN_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .tab(MAIN_TAB)
            ));
    public static final RegistryEntry<Item> LIGHT_BLUE_DYED_WATER_BUCKET = BASIC_ITEMS.register("light_blue_dyed_water_bucket",
            () -> new FluidBucketItem(AllFluidProperties.LIGHT_BLUE_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .tab(MAIN_TAB)
            ));
    public static final RegistryEntry<Item> BLUE_DYED_WATER_BUCKET = BASIC_ITEMS.register("blue_dyed_water_bucket",
            () -> new FluidBucketItem(AllFluidProperties.BLUE_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .tab(MAIN_TAB)
            ));
    public static final RegistryEntry<Item> PURPLE_DYED_WATER_BUCKET = BASIC_ITEMS.register("purple_dyed_water_bucket",
            () -> new FluidBucketItem(AllFluidProperties.PURPLE_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .tab(MAIN_TAB)
            ));
    public static final RegistryEntry<Item> MAGENTA_DYED_WATER_BUCKET = BASIC_ITEMS.register("magenta_dyed_water_bucket",
            () -> new FluidBucketItem(AllFluidProperties.MAGENTA_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .tab(MAIN_TAB)
            ));
    public static final RegistryEntry<Item> PINK_DYED_WATER_BUCKET = BASIC_ITEMS.register("pink_dyed_water_bucket",
            () -> new FluidBucketItem(AllFluidProperties.PINK_DYED_WATER, new Item.Properties()
                    .craftRemainder(Items.BUCKET)
                    .stacksTo(1)
                    .tab(MAIN_TAB)
            ));

    public static void init() {
        AllItems.ITEMS.init();
        AllItems.BASIC_ITEMS.init();
    }
}
