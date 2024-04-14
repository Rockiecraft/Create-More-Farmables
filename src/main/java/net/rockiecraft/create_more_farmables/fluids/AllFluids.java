package net.rockiecraft.create_more_farmables.fluids;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rockiecraft.create_more_farmables.CreateMoreFarmables;

public class AllFluids {

    public static FlowableFluid STILL_MOLTEN_ENDSTONE;
    public static FlowableFluid FLOWING_MOLTEN_ENDSTONE;
    public static Block MOLTEN_ENDSTONE_BLOCK;
    public static Item MOLTEN_ENDSTONE_BUCKET;

    public static FlowableFluid STILL_WHITE_DYED_WATER;
    public static FlowableFluid FLOWING_WHITE_DYED_WATER;
    public static Block WHITE_DYED_WATER_BLOCK;
    public static Item WHITE_DYED_WATER_BUCKET;

    public static FlowableFluid STILL_LIGHT_GRAY_DYED_WATER;
    public static FlowableFluid FLOWING_LIGHT_GRAY_DYED_WATER;
    public static Block LIGHT_GRAY_DYED_WATER_BLOCK;
    public static Item LIGHT_GRAY_DYED_WATER_BUCKET;

    public static FlowableFluid STILL_GRAY_DYED_WATER;
    public static FlowableFluid FLOWING_GRAY_DYED_WATER;
    public static Block GRAY_DYED_WATER_BLOCK;
    public static Item GRAY_DYED_WATER_BUCKET;

    public static FlowableFluid STILL_BLACK_DYED_WATER;
    public static FlowableFluid FLOWING_BLACK_DYED_WATER;
    public static Block BLACK_DYED_WATER_BLOCK;
    public static Item BLACK_DYED_WATER_BUCKET;

    public static FlowableFluid STILL_BROWN_DYED_WATER;
    public static FlowableFluid FLOWING_BROWN_DYED_WATER;
    public static Block BROWN_DYED_WATER_BLOCK;
    public static Item BROWN_DYED_WATER_BUCKET;

    public static FlowableFluid STILL_RED_DYED_WATER;
    public static FlowableFluid FLOWING_RED_DYED_WATER;
    public static Block RED_DYED_WATER_BLOCK;
    public static Item RED_DYED_WATER_BUCKET;

    public static FlowableFluid STILL_ORANGE_DYED_WATER;
    public static FlowableFluid FLOWING_ORANGE_DYED_WATER;
    public static Block ORANGE_DYED_WATER_BLOCK;
    public static Item ORANGE_DYED_WATER_BUCKET;

    public static FlowableFluid STILL_YELLOW_DYED_WATER;
    public static FlowableFluid FLOWING_YELLOW_DYED_WATER;
    public static Block YELLOW_DYED_WATER_BLOCK;
    public static Item YELLOW_DYED_WATER_BUCKET;

    public static FlowableFluid STILL_GREEN_DYED_WATER;
    public static FlowableFluid FLOWING_GREEN_DYED_WATER;
    public static Block GREEN_DYED_WATER_BLOCK;
    public static Item GREEN_DYED_WATER_BUCKET;

    public static FlowableFluid STILL_LIME_DYED_WATER;
    public static FlowableFluid FLOWING_LIME_DYED_WATER;
    public static Block LIME_DYED_WATER_BLOCK;
    public static Item LIME_DYED_WATER_BUCKET;

    public static FlowableFluid STILL_CYAN_DYED_WATER;
    public static FlowableFluid FLOWING_CYAN_DYED_WATER;
    public static Block CYAN_DYED_WATER_BLOCK;
    public static Item CYAN_DYED_WATER_BUCKET;

    public static FlowableFluid STILL_LIGHT_BLUE_DYED_WATER;
    public static FlowableFluid FLOWING_LIGHT_BLUE_DYED_WATER;
    public static Block LIGHT_BLUE_DYED_WATER_BLOCK;
    public static Item LIGHT_BLUE_DYED_WATER_BUCKET;

    public static FlowableFluid STILL_BLUE_DYED_WATER;
    public static FlowableFluid FLOWING_BLUE_DYED_WATER;
    public static Block BLUE_DYED_WATER_BLOCK;
    public static Item BLUE_DYED_WATER_BUCKET;

    public static FlowableFluid STILL_PURPLE_DYED_WATER;
    public static FlowableFluid FLOWING_PURPLE_DYED_WATER;
    public static Block PURPLE_DYED_WATER_BLOCK;
    public static Item PURPLE_DYED_WATER_BUCKET;

    public static FlowableFluid STILL_MAGENTA_DYED_WATER;
    public static FlowableFluid FLOWING_MAGENTA_DYED_WATER;
    public static Block MAGENTA_DYED_WATER_BLOCK;
    public static Item MAGENTA_DYED_WATER_BUCKET;

    public static FlowableFluid STILL_PINK_DYED_WATER;
    public static FlowableFluid FLOWING_PINK_DYED_WATER;
    public static Block PINK_DYED_WATER_BLOCK;
    public static Item PINK_DYED_WATER_BUCKET;



         public static void register() {

             STILL_MOLTEN_ENDSTONE = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "molten_endstone"), new MoltenEndstoneFluid.Still());
             FLOWING_MOLTEN_ENDSTONE = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "flowing_molten_endstone"), new MoltenEndstoneFluid.Flowing());
             MOLTEN_ENDSTONE_BLOCK = Registry.register(Registries.BLOCK, new Identifier(CreateMoreFarmables.ID, "molten_endstone_block"), new FluidBlock(AllFluids.STILL_MOLTEN_ENDSTONE, FabricBlockSettings.copyOf(Blocks.WATER)) {});
             MOLTEN_ENDSTONE_BUCKET = Registry.register(Registries.ITEM, new Identifier(CreateMoreFarmables.ID, "molten_endstone_bucket"), new BucketItem(AllFluids.STILL_MOLTEN_ENDSTONE, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));

             STILL_WHITE_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "white_dyed_water"), new WhiteDyedWaterFluid.Still());
             FLOWING_WHITE_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "flowing_white_dyed_water"), new WhiteDyedWaterFluid.Flowing());
             WHITE_DYED_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(CreateMoreFarmables.ID, "white_dyed_water_block"), new FluidBlock(AllFluids.STILL_WHITE_DYED_WATER, FabricBlockSettings.copyOf(Blocks.WATER)) {});
             WHITE_DYED_WATER_BUCKET = Registry.register(Registries.ITEM, new Identifier(CreateMoreFarmables.ID, "white_dyed_water_bucket"), new BucketItem(AllFluids.STILL_WHITE_DYED_WATER, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));

             STILL_LIGHT_GRAY_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "light_gray_dyed_water"), new LightGrayDyedWaterFluid.Still());
             FLOWING_LIGHT_GRAY_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "flowing_light_gray_dyed_water"), new LightGrayDyedWaterFluid.Flowing());
             LIGHT_GRAY_DYED_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(CreateMoreFarmables.ID, "light_gray_dyed_water_block"), new FluidBlock(AllFluids.STILL_LIGHT_GRAY_DYED_WATER, FabricBlockSettings.copyOf(Blocks.WATER)) {});
             LIGHT_GRAY_DYED_WATER_BUCKET = Registry.register(Registries.ITEM, new Identifier(CreateMoreFarmables.ID, "light_gray_dyed_water_bucket"), new BucketItem(AllFluids.STILL_LIGHT_GRAY_DYED_WATER, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));

             STILL_GRAY_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "gray_dyed_water"), new GrayDyedWaterFluid.Still());
             FLOWING_GRAY_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "flowing_gray_dyed_water"), new GrayDyedWaterFluid.Flowing());
             GRAY_DYED_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(CreateMoreFarmables.ID, "gray_dyed_water_block"), new FluidBlock(AllFluids.STILL_GRAY_DYED_WATER, FabricBlockSettings.copyOf(Blocks.WATER)) {});
             GRAY_DYED_WATER_BUCKET = Registry.register(Registries.ITEM, new Identifier(CreateMoreFarmables.ID, "gray_dyed_water_bucket"), new BucketItem(AllFluids.STILL_GRAY_DYED_WATER, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));

             STILL_BLACK_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "black_dyed_water"), new BlackDyedWaterFluid.Still());
             FLOWING_BLACK_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "flowing_black_dyed_water"), new BlackDyedWaterFluid.Flowing());
             BLACK_DYED_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(CreateMoreFarmables.ID, "black_dyed_water_block"), new FluidBlock(AllFluids.STILL_BLACK_DYED_WATER, FabricBlockSettings.copyOf(Blocks.WATER)) {});
             BLACK_DYED_WATER_BUCKET = Registry.register(Registries.ITEM, new Identifier(CreateMoreFarmables.ID, "black_dyed_water_bucket"), new BucketItem(AllFluids.STILL_BLACK_DYED_WATER, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));

             STILL_BROWN_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "brown_dyed_water"), new BrownDyedWaterFluid.Still());
             FLOWING_BROWN_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "flowing_brown_dyed_water"), new BrownDyedWaterFluid.Flowing());
             BROWN_DYED_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(CreateMoreFarmables.ID, "brown_dyed_water_block"), new FluidBlock(AllFluids.STILL_BROWN_DYED_WATER, FabricBlockSettings.copyOf(Blocks.WATER)) {});
             BROWN_DYED_WATER_BUCKET = Registry.register(Registries.ITEM, new Identifier(CreateMoreFarmables.ID, "brown_dyed_water_bucket"), new BucketItem(AllFluids.STILL_BROWN_DYED_WATER, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));

             STILL_RED_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "red_dyed_water"), new RedDyedWaterFluid.Still());
             FLOWING_RED_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "flowing_red_dyed_water"), new RedDyedWaterFluid.Flowing());
             RED_DYED_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(CreateMoreFarmables.ID, "red_dyed_water_block"), new FluidBlock(AllFluids.STILL_RED_DYED_WATER, FabricBlockSettings.copyOf(Blocks.WATER)) {});
             RED_DYED_WATER_BUCKET = Registry.register(Registries.ITEM, new Identifier(CreateMoreFarmables.ID, "red_dyed_water_bucket"), new BucketItem(AllFluids.STILL_RED_DYED_WATER, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));

             STILL_ORANGE_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "orange_dyed_water"), new OrangeDyedWaterFluid.Still());
             FLOWING_ORANGE_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "flowing_orange_dyed_water"), new OrangeDyedWaterFluid.Flowing());
             ORANGE_DYED_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(CreateMoreFarmables.ID, "orange_dyed_water_block"), new FluidBlock(AllFluids.STILL_ORANGE_DYED_WATER, FabricBlockSettings.copyOf(Blocks.WATER)) {});
             ORANGE_DYED_WATER_BUCKET = Registry.register(Registries.ITEM, new Identifier(CreateMoreFarmables.ID, "orange_dyed_water_bucket"), new BucketItem(AllFluids.STILL_ORANGE_DYED_WATER, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));

             STILL_YELLOW_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "yellow_dyed_water"), new YellowDyedWaterFluid.Still());
             FLOWING_YELLOW_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "flowing_yellow_dyed_water"), new YellowDyedWaterFluid.Flowing());
             YELLOW_DYED_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(CreateMoreFarmables.ID, "yellow_dyed_water_block"), new FluidBlock(AllFluids.STILL_YELLOW_DYED_WATER, FabricBlockSettings.copyOf(Blocks.WATER)) {});
             YELLOW_DYED_WATER_BUCKET = Registry.register(Registries.ITEM, new Identifier(CreateMoreFarmables.ID, "yellow_dyed_water_bucket"), new BucketItem(AllFluids.STILL_YELLOW_DYED_WATER, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));

             STILL_GREEN_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "green_dyed_water"), new GreenDyedWaterFluid.Still());
             FLOWING_GREEN_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "flowing_green_dyed_water"), new GreenDyedWaterFluid.Flowing());
             GREEN_DYED_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(CreateMoreFarmables.ID, "green_dyed_water_block"), new FluidBlock(AllFluids.STILL_GREEN_DYED_WATER, FabricBlockSettings.copyOf(Blocks.WATER)) {});
             GREEN_DYED_WATER_BUCKET = Registry.register(Registries.ITEM, new Identifier(CreateMoreFarmables.ID, "green_dyed_water_bucket"), new BucketItem(AllFluids.STILL_GREEN_DYED_WATER, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));

             STILL_LIME_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "lime_dyed_water"), new LimeDyedWaterFluid.Still());
             FLOWING_LIME_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "flowing_lime_dyed_water"), new LimeDyedWaterFluid.Flowing());
             LIME_DYED_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(CreateMoreFarmables.ID, "lime_dyed_water_block"), new FluidBlock(AllFluids.STILL_LIME_DYED_WATER, FabricBlockSettings.copyOf(Blocks.WATER)) {});
             LIME_DYED_WATER_BUCKET = Registry.register(Registries.ITEM, new Identifier(CreateMoreFarmables.ID, "lime_dyed_water_bucket"), new BucketItem(AllFluids.STILL_LIME_DYED_WATER, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));

             STILL_LIGHT_BLUE_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "light_blue_dyed_water"), new LightBlueDyedWaterFluid.Still());
             FLOWING_LIGHT_BLUE_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "flowing_light_blue_dyed_water"), new LightBlueDyedWaterFluid.Flowing());
             LIGHT_BLUE_DYED_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(CreateMoreFarmables.ID, "light_blue_dyed_water_block"), new FluidBlock(AllFluids.STILL_LIGHT_BLUE_DYED_WATER, FabricBlockSettings.copyOf(Blocks.WATER)) {});
             LIGHT_BLUE_DYED_WATER_BUCKET = Registry.register(Registries.ITEM, new Identifier(CreateMoreFarmables.ID, "light_blue_dyed_water_bucket"), new BucketItem(AllFluids.STILL_LIGHT_BLUE_DYED_WATER, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));

             STILL_BLUE_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "blue_dyed_water"), new BlueDyedWaterFluid.Still());
             FLOWING_BLUE_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "flowing_blue_dyed_water"), new BlueDyedWaterFluid.Flowing());
             BLUE_DYED_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(CreateMoreFarmables.ID, "blue_dyed_water_block"), new FluidBlock(AllFluids.STILL_BLUE_DYED_WATER, FabricBlockSettings.copyOf(Blocks.WATER)) {});
             BLUE_DYED_WATER_BUCKET = Registry.register(Registries.ITEM, new Identifier(CreateMoreFarmables.ID, "blue_dyed_water_bucket"), new BucketItem(AllFluids.STILL_BLUE_DYED_WATER, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));

             STILL_CYAN_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "cyan_dyed_water"), new CyanDyedWaterFluid.Still());
             FLOWING_CYAN_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "flowing_cyan_dyed_water"), new CyanDyedWaterFluid.Flowing());
             CYAN_DYED_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(CreateMoreFarmables.ID, "cyan_dyed_water_block"), new FluidBlock(AllFluids.STILL_CYAN_DYED_WATER, FabricBlockSettings.copyOf(Blocks.WATER)) {});
             CYAN_DYED_WATER_BUCKET = Registry.register(Registries.ITEM, new Identifier(CreateMoreFarmables.ID, "cyan_dyed_water_bucket"), new BucketItem(AllFluids.STILL_CYAN_DYED_WATER, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));

             STILL_MAGENTA_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "magenta_dyed_water"), new MagentaDyedWaterFluid.Still());
             FLOWING_MAGENTA_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "flowing_magenta_dyed_water"), new MagentaDyedWaterFluid.Flowing());
             MAGENTA_DYED_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(CreateMoreFarmables.ID, "magenta_dyed_water_block"), new FluidBlock(AllFluids.STILL_MAGENTA_DYED_WATER, FabricBlockSettings.copyOf(Blocks.WATER)) {});
             MAGENTA_DYED_WATER_BUCKET = Registry.register(Registries.ITEM, new Identifier(CreateMoreFarmables.ID, "magenta_dyed_water_bucket"), new BucketItem(AllFluids.STILL_MAGENTA_DYED_WATER, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));


             STILL_PURPLE_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "purple_dyed_water"), new PurpleDyedWaterFluid.Still());
             FLOWING_PURPLE_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "flowing_purple_dyed_water"), new PurpleDyedWaterFluid.Flowing());
             PURPLE_DYED_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(CreateMoreFarmables.ID, "purple_dyed_water_block"), new FluidBlock(AllFluids.STILL_PURPLE_DYED_WATER, FabricBlockSettings.copyOf(Blocks.WATER)) {});
             PURPLE_DYED_WATER_BUCKET = Registry.register(Registries.ITEM, new Identifier(CreateMoreFarmables.ID, "purple_dyed_water_bucket"), new BucketItem(AllFluids.STILL_PURPLE_DYED_WATER, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));

             STILL_PINK_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "pink_dyed_water"), new PinkDyedWaterFluid.Still());
             FLOWING_PINK_DYED_WATER = Registry.register(Registries.FLUID, new Identifier(CreateMoreFarmables.ID, "flowing_pink_dyed_water"), new PinkDyedWaterFluid.Flowing());
             PINK_DYED_WATER_BLOCK = Registry.register(Registries.BLOCK, new Identifier(CreateMoreFarmables.ID, "pink_dyed_water_block"), new FluidBlock(AllFluids.STILL_PINK_DYED_WATER, FabricBlockSettings.copyOf(Blocks.WATER)) {});
             PINK_DYED_WATER_BUCKET = Registry.register(Registries.ITEM, new Identifier(CreateMoreFarmables.ID, "pink_dyed_water_bucket"), new BucketItem(AllFluids.STILL_PINK_DYED_WATER, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));


         }

}
