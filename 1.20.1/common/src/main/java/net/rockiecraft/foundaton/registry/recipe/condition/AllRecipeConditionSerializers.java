package net.rockiecraft.foundaton.registry.recipe.condition;

import net.minecraft.resources.ResourceLocation;
import net.rockiecraft.foundaton.registry.config.ConfigRecipeCondition;
import net.rockiecraft.foundaton.registry.config.CreateMoreFarmablesConfig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllRecipeConditionSerializers {
    private static final List<IRecipeConditionSerializer<?>> SERIALIZERS = new ArrayList<>();

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> WHITE_DYED_WATER_MIXING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "white_dyed_water_making"),
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.allDyedWaterMixingEnabled,
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.whiteDyedWaterMaking));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> LIGHT_GRAY_DYED_WATER_MIXING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "light_gray_dyed_water_making"),
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.allDyedWaterMixingEnabled,
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.lightGrayDyedWaterMaking));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> GRAY_DYED_WATER_MIXING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "gray_dyed_water_making"),
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.allDyedWaterMixingEnabled,
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.grayDyedWaterMaking));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> BLACK_DYED_WATER_MIXING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "black_dyed_water_making"),
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.allDyedWaterMixingEnabled,
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.blackDyedWaterMaking));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> BROWN_DYED_WATER_MIXING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "brown_dyed_water_making"),
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.allDyedWaterMixingEnabled,
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.brownDyedWaterMaking));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> RED_DYED_WATER_MIXING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "red_dyed_water_making"),
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.allDyedWaterMixingEnabled,
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.redDyedWaterMaking));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> ORANGE_DYED_WATER_MIXING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "orange_dyed_water_making"),
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.allDyedWaterMixingEnabled,
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.orangeDyedWaterMaking));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> YELLOW_DYED_WATER_MIXING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "yellow_dyed_water_making"),
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.allDyedWaterMixingEnabled,
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.yellowDyedWaterMaking));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> GREEN_DYED_WATER_MIXING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "green_dyed_water_making"),
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.allDyedWaterMixingEnabled,
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.greenDyedWaterMaking));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> LIME_DYED_WATER_MIXING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "lime_dyed_water_making"),
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.allDyedWaterMixingEnabled,
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.limeDyedWaterMaking));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> CYAN_DYED_WATER_MIXING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "cyan_dyed_water_making"),
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.allDyedWaterMixingEnabled,
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.cyanDyedWaterMaking));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> LIGHT_BLUE_DYED_WATER_MIXING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "light_blue_dyed_water_making"),
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.allDyedWaterMixingEnabled,
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.lightBlueDyedWaterMaking));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> BLUE_DYED_WATER_MIXING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "blue_dyed_water_making"),
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.allDyedWaterMixingEnabled,
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.blueDyedWaterMaking));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> PURPLE_DYED_WATER_MIXING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "purple_dyed_water_making"),
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.allDyedWaterMixingEnabled,
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.purpleDyedWaterMaking));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> MAGENTA_DYED_WATER_MIXING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "magenta_dyed_water_making"),
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.allDyedWaterMixingEnabled,
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.magentaDyedWaterMaking));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> PINK_DYED_WATER_MIXING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "pink_dyed_water_making"),
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.allDyedWaterMixingEnabled,
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.pinkDyedWaterMaking));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> WHITE_DYE_FILLING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "white_dye_filling"),
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.allDyeFillingEnabled,
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.whiteDyeFilling));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> LIGHT_GRAY_DYE_FILLING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "light_gray_dye_filling"),
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.allDyeFillingEnabled,
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.lightGrayDyeFilling));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> GRAY_DYE_FILLING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "gray_dye_filling"),
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.allDyeFillingEnabled,
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.grayDyeFilling));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> BLACK_DYE_FILLING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "black_dye_filling"),
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.allDyeFillingEnabled,
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.blackDyeFilling));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> BROWN_DYE_FILLING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "brown_dye_filling"),
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.allDyeFillingEnabled,
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.brownDyeFilling));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> RED_DYE_FILLING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "red_dye_filling"),
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.allDyeFillingEnabled,
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.redDyeFilling));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> ORANGE_DYE_FILLING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "orange_dye_filling"),
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.allDyeFillingEnabled,
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.orangeDyeFilling));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> YELLOW_DYE_FILLING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "yellow_dye_filling"),
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.allDyeFillingEnabled,
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.yellowDyeFilling));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> GREEN_DYE_FILLING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "green_dye_filling"),
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.allDyeFillingEnabled,
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.greenDyeFilling));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> LIME_DYE_FILLING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "lime_dye_filling"),
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.allDyeFillingEnabled,
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.limeDyeFilling));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> CYAN_DYE_FILLING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "cyan_dye_filling"),
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.allDyeFillingEnabled,
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.cyanDyeFilling));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> LIGHT_BLUE_DYE_FILLING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "light_blue_dye_filling"),
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.allDyeFillingEnabled,
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.lightBlueDyeFilling));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> BLUE_DYE_FILLING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "blue_dye_filling"),
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.allDyeFillingEnabled,
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.blueDyeFilling));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> PURPLE_DYE_FILLING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "purple_dye_filling"),
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.allDyeFillingEnabled,
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.purpleDyeFilling));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> MAGENTA_DYE_FILLING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "magenta_dye_filling"),
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.allDyeFillingEnabled,
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.magentaDyeFilling));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> PINK_DYE_FILLING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "pink_dye_filling"),
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.allDyeFillingEnabled,
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.pinkDyeFilling));


    /*
     * Bed Dyeing
     *  */

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> WHITE_BED_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "white_bed_splashing"),
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.allBedSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.whiteBedSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> LIGHT_GRAY_BED_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "light_gray_bed_splashing"),
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.allBedSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.lightGrayBedSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> GRAY_BED_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "gray_bed_splashing"),
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.allBedSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.grayBedSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> BLACK_BED_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "black_bed_splashing"),
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.allBedSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.blackBedSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> BROWN_BED_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "brown_bed_splashing"),
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.allBedSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.brownBedSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> RED_BED_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "red_bed_splashing"),
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.allBedSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.redBedSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> ORANGE_BED_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "orange_bed_splashing"),
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.allBedSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.orangeBedSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> YELLOW_BED_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "yellow_bed_splashing"),
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.allBedSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.yellowBedSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> GREEN_BED_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "green_bed_splashing"),
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.allBedSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.greenBedSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> LIME_BED_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "lime_bed_splashing"),
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.allBedSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.limeBedSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> CYAN_BED_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "cyan_bed_splashing"),
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.allBedSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.cyanBedSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> LIGHT_BLUE_BED_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "light_blue_bed_splashing"),
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.allBedSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.lightBlueBedSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> BLUE_BED_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "blue_bed_splashing"),
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.allBedSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.blueBedSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> PURPLE_BED_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "purple_bed_splashing"),
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.allBedSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.purpleBedSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> MAGENTA_BED_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "magenta_bed_splashing"),
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.allBedSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.magentaBedSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> PINK_BED_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "pink_bed_splashing"),
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.allBedSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Bed_Splashing.pinkBedSplashing));

    /**
     * Glass Dyeing
     */

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> WHITE_GLASS_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "white_glass_splashing"),
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.allGlassSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.whiteGlassSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> LIGHT_GRAY_GLASS_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "light_gray_glass_splashing"),
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.allGlassSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.lightGrayGlassSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> GRAY_GLASS_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "gray_glass_splashing"),
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.allGlassSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.grayGlassSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> BLACK_GLASS_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "black_glass_splashing"),
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.allGlassSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.blackGlassSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> BROWN_GLASS_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "brown_glass_splashing"),
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.allGlassSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.brownGlassSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> RED_GLASS_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "red_glass_splashing"),
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.allGlassSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.redGlassSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> ORANGE_GLASS_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "orange_glass_splashing"),
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.allGlassSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.orangeGlassSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> YELLOW_GLASS_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "yellow_glass_splashing"),
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.allGlassSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.yellowGlassSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> GREEN_GLASS_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "green_glass_splashing"),
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.allGlassSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.greenGlassSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> LIME_GLASS_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "lime_glass_splashing"),
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.allGlassSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.limeGlassSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> CYAN_GLASS_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "cyan_glass_splashing"),
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.allGlassSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.cyanGlassSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> LIGHT_BLUE_GLASS_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "light_blue_glass_splashing"),
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.allGlassSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.lightBlueGlassSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> BLUE_GLASS_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "blue_glass_splashing"),
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.allGlassSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.blueGlassSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> PURPLE_GLASS_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "purple_glass_splashing"),
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.allGlassSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.purpleGlassSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> MAGENTA_GLASS_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "magenta_glass_splashing"),
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.allGlassSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.magentaGlassSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> PINK_GLASS_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "pink_glass_splashing"),
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.allGlassSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Glass_Splashing.pinkGlassSplashing));

    /*
     * Wool Dyeing
     * */

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> WHITE_WOOL_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "white_wool_splashing"),
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.allWoolSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.whiteWoolSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> LIGHT_GRAY_WOOL_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "light_gray_wool_splashing"),
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.allWoolSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.lightGrayWoolSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> GRAY_WOOL_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "gray_wool_splashing"),
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.allWoolSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.grayWoolSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> BLACK_WOOL_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "black_wool_splashing"),
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.allWoolSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.blackWoolSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> BROWN_WOOL_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "brown_wool_splashing"),
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.allWoolSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.brownWoolSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> RED_WOOL_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "red_wool_splashing"),
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.allWoolSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.redWoolSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> ORANGE_WOOL_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "orange_wool_splashing"),
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.allWoolSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.orangeWoolSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> YELLOW_WOOL_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "yellow_wool_splashing"),
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.allWoolSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.yellowWoolSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> GREEN_WOOL_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "green_wool_splashing"),
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.allWoolSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.greenWoolSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> LIME_WOOL_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "lime_wool_splashing"),
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.allWoolSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.limeWoolSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> CYAN_WOOL_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "cyan_wool_splashing"),
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.allWoolSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.cyanWoolSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> LIGHT_BLUE_WOOL_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "light_blue_wool_splashing"),
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.allWoolSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.lightBlueWoolSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> BLUE_WOOL_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "blue_wool_splashing"),
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.allWoolSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.blueWoolSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> PURPLE_WOOL_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "purple_wool_splashing"),
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.allWoolSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.purpleWoolSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> MAGENTA_WOOL_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "magenta_wool_splashing"),
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.allWoolSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.magentaWoolSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> PINK_WOOL_DYEING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "pink_wool_splashing"),
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.allWoolSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Wool_Splashing.pinkWoolSplashing));

    /*
     *  Banner Dyeing
     * */

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> WHITE_BANNER_SPLASHING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "white_banner_splashing"),
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.allBannerSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.whiteBannerSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> LIGHT_GRAY_BANNER_SPLASHING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "light_gray_banner_splashing"),
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.allBannerSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.lightGrayBannerSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> GRAY_BANNER_SPLASHING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "gray_banner_splashing"),
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.allBannerSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.grayBannerSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> BLACK_BANNER_SPLASHING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "black_banner_splashing"),
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.allBannerSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.blackBannerSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> BROWN_BANNER_SPLASHING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "brown_banner_splashing"),
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.allBannerSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.brownBannerSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> RED_BANNER_SPLASHING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "red_banner_splashing"),
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.allBannerSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.redBannerSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> ORANGE_BANNER_SPLASHING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "orange_banner_splashing"),
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.allBannerSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.orangeBannerSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> YELLOW_BANNER_SPLASHING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "yellow_banner_splashing"),
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.allBannerSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.yellowBannerSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> GREEN_BANNER_SPLASHING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "green_banner_splashing"),
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.allBannerSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.greenBannerSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> LIME_BANNER_SPLASHING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "lime_banner_splashing"),
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.allBannerSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.limeBannerSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> CYAN_BANNER_SPLASHING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "cyan_banner_splashing"),
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.allBannerSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.cyanBannerSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> LIGHT_BLUE_BANNER_SPLASHING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "light_blue_banner_splashing"),
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.allBannerSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.lightBlueBannerSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> BLUE_BANNER_SPLASHING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "blue_banner_splashing"),
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.allBannerSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.blueBannerSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> PURPLE_BANNER_SPLASHING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "purple_banner_splashing"),
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.allBannerSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.purpleBannerSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> MAGENTA_BANNER_SPLASHING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "magenta_banner_splashing"),
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.allBannerSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.magentaBannerSplashing));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> PINK_BANNER_SPLASHING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "pink_banner_splashing"),
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.allBannerSplashingEnabled,
                    () -> CreateMoreFarmablesConfig.Banner_Splashing.pinkBannerSplashing));

    public static <T extends IRecipeConditionSerializer<?>> T register(T condition) {
        SERIALIZERS.add(condition);
        return condition;
    }

    public static List<IRecipeConditionSerializer<?>> getSerializers() {
        return Collections.unmodifiableList(SERIALIZERS);
    }

    public static void init() {

    }
}
