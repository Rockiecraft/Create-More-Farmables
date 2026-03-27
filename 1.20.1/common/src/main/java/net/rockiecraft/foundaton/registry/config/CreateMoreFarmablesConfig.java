package net.rockiecraft.foundaton.registry.config;


import com.teamresourceful.resourcefulconfig.common.annotations.Category;
import com.teamresourceful.resourcefulconfig.common.annotations.Comment;
import com.teamresourceful.resourcefulconfig.common.annotations.Config;
import com.teamresourceful.resourcefulconfig.common.annotations.ConfigEntry;
import com.teamresourceful.resourcefulconfig.common.config.EntryType;

@Config("create_more_farmables")
public final class CreateMoreFarmablesConfig {

    @Category(id = "Create More Farmables items", translation = "config.create_more_farmables.cmf_items")
    public static final class CreateMoreFarmables {
        @ConfigEntry(id = "CMFItemMasterToggleOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.cmf_item_master_toggle")
        @Comment("If false, Turns off all Create More Farmable item recipes")
        public static boolean CMFItemMasterToggleOn = true;

        @ConfigEntry(id = "echoShardDustOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.echo_shard_dust_toggle")
        public static boolean echoShardDustOn = true;

        @ConfigEntry(id = "EnderpearlDustOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.enderpearl_dust_toggle")
        public static boolean EnderpearlDustOn = true;

        @ConfigEntry(id = "netheriteDustOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.netherite_dust_toggle")
        public static boolean netheriteDustOn = true;

        @ConfigEntry(id = "shulkerShellFragmentOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.shulker_shell_fragment_toggle")
        public static boolean shulkerShellFragmentOn = true;

        @ConfigEntry(id = "shulkerCompoundOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.shulker_compound_toggle")
        public static boolean shulkerCompoundOn = true;

        @ConfigEntry(id = "heartOfTheSeaFragmentOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.heart_of_the_sea_fragment_toggle")
        public static boolean heartOfTheSeaFragmentOn = true;

        @ConfigEntry(id = "nautilusShellFragmentOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.heart_of_the_sea_fragment_toggle")
        public static boolean nautilusShellFragmentOn = true;

        @ConfigEntry(id = "dyeTemplateOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.dye_template_toggle")
        public static boolean dyeTemplateOn = true;

        @ConfigEntry(id = "woodStringWoolOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.wood_string_wool_toggle")
        public static boolean woodStringWoolOn= true;

        @ConfigEntry(id = "woodStringOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.wood_string_toggle")
        public static boolean woodStringOn = true;
    }


    @Category(id = "dyed_water_making", translation = "config.create_more_farmables.dyed_water_making")
    public static final class Dyed_Water_Making {
        @ConfigEntry(id = "allDyedWaterMixingEnabled",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.all_dyed_water_mixing_enabled")
        @Comment("If false, disables all Dyed Water mixing recipes.")
        public static boolean allDyedWaterMixingEnabled = true;

        @ConfigEntry(id = "whiteDyedWaterMaking",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.white_dyed_water_making")
        public static boolean whiteDyedWaterMaking = true;

        @ConfigEntry(id = "lightGrayDyedWaterMaking",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.light_gray_dyed_water_making")
        public static boolean lightGrayDyedWaterMaking = true;

        @ConfigEntry(id = "grayDyedWaterMaking",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.gray_dyed_water_making")
        public static boolean grayDyedWaterMaking = true;

        @ConfigEntry(id = "blackDyedWaterMaking",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.black_dyed_water_making")
        public static boolean blackDyedWaterMaking = true;

        @ConfigEntry(id = "brownDyedWaterMaking",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.brown_dyed_water_making")
        public static boolean brownDyedWaterMaking = true;

        @ConfigEntry(id = "redDyedWaterMaking",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.red_dyed_water_making")
        public static boolean redDyedWaterMaking = true;

        @ConfigEntry(id = "orangeDyedWaterMaking",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.orange_dyed_water_making")
        public static boolean orangeDyedWaterMaking = true;

        @ConfigEntry(id = "yellowDyedWaterMaking",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.yellow_dyed_water_making")
        public static boolean yellowDyedWaterMaking = true;

        @ConfigEntry(id = "greenDyedWaterMaking",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.green_dyed_water_making")
        public static boolean greenDyedWaterMaking = true;

        @ConfigEntry(id = "limeDyedWaterMaking",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.lime_dyed_water_making")
        public static boolean limeDyedWaterMaking = true;

        @ConfigEntry(id = "cyanDyedWaterMaking",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.cyan_dyed_water_making")
        public static boolean cyanDyedWaterMaking = true;

        @ConfigEntry(id = "lightBlueDyedWaterMaking",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.light_blue_dyed_water_making")
        public static boolean lightBlueDyedWaterMaking = true;

        @ConfigEntry(id = "blueDyedWaterMaking",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.blue_dyed_water_making")
        public static boolean blueDyedWaterMaking = true;

        @ConfigEntry(id = "purpleDyedWaterMaking",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.purple_dyed_water_making")
        public static boolean purpleDyedWaterMaking = true;

        @ConfigEntry(id = "magentaDyedWaterMaking",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.magenta_dyed_water_making")
        public static boolean magentaDyedWaterMaking = true;

        @ConfigEntry(id = "pinkDyedWaterMaking",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.pink_dyed_water_making")
        public static boolean pinkDyedWaterMaking = true;
    }


    @Category(id = "dye_template_filling", translation = "config.create_more_farmables.dye_template_filling")
    public static final class Dye_Template_Filling {
        @ConfigEntry(id = "allDyeFillingEnabled",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.all_dye_filling_enabled")
        @Comment("If false, disables all Dye Template filling recipes.")
        public static boolean allDyeFillingEnabled = true;

        @ConfigEntry(id = "whiteDyeFilling",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.white_dye_filling")
        public static boolean whiteDyeFilling = true;

        @ConfigEntry(id = "lightGrayDyeFilling",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.light_gray_dye_filling")
        public static boolean lightGrayDyeFilling = true;

        @ConfigEntry(id = "grayDyeFilling",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.gray_dye_filling")
        public static boolean grayDyeFilling = true;

        @ConfigEntry(id = "blackDyeFilling",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.black_dye_filling")
        public static boolean blackDyeFilling = true;

        @ConfigEntry(id = "brownDyeFilling",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.brown_dye_filling")
        public static boolean brownDyeFilling = true;

        @ConfigEntry(id = "redDyeFilling",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.red_dye_filling")
        public static boolean redDyeFilling = true;

        @ConfigEntry(id = "orangeDyeFilling",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.orange_dye_filling")
        public static boolean orangeDyeFilling = true;

        @ConfigEntry(id = "yellowDyeFilling",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.yellow_dye_filling")
        public static boolean yellowDyeFilling = true;

        @ConfigEntry(id = "greenDyeFilling",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.green_dye_filling")
        public static boolean greenDyeFilling = true;

        @ConfigEntry(id = "limeDyeFilling",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.lime_dye_filling")
        public static boolean limeDyeFilling = true;

        @ConfigEntry(id = "cyanDyeFilling",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.cyan_dye_filling")
        public static boolean cyanDyeFilling = true;

        @ConfigEntry(id = "lightBlueDyeFilling",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.light_blue_dye_filling")
        public static boolean lightBlueDyeFilling = true;

        @ConfigEntry(id = "blueDyeFilling",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.blue_dye_filling")
        public static boolean blueDyeFilling = true;

        @ConfigEntry(id = "purpleDyeFilling",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.purple_dye_filling")
        public static boolean purpleDyeFilling = true;

        @ConfigEntry(id = "magentaDyeFilling",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.magenta_dye_filling")
        public static boolean magentaDyeFilling = true;

        @ConfigEntry(id = "pinkDyeFilling",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.pink_dye_filling")
        public static boolean pinkDyeFilling = true;
    }


    @Category(id = "banner_splashing", translation = "config.create_more_farmables.banner_splashing")
    public static final class Banner_Splashing {
        @ConfigEntry(id = "allBannerSplashingEnabled",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.all_banner_splashing_enabled")
        @Comment("If false, disables all Banner Splashing recipes.")
        public static boolean allBannerSplashingEnabled = true;

        @ConfigEntry(id = "whiteBannerSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.white_banner_splashing")
        public static boolean whiteBannerSplashing = true;

        @ConfigEntry(id = "lightGrayBannerSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.light_gray_banner_splashing")
        public static boolean lightGrayBannerSplashing = true;

        @ConfigEntry(id = "grayBannerSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.gray_banner_splashing")
        public static boolean grayBannerSplashing = true;

        @ConfigEntry(id = "blackBannerSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.black_banner_splashing")
        public static boolean blackBannerSplashing = true;

        @ConfigEntry(id = "brownBannerSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.brown_banner_splashing")
        public static boolean brownBannerSplashing = true;

        @ConfigEntry(id = "redBannerSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.red_banner_splashing")
        public static boolean redBannerSplashing = true;

        @ConfigEntry(id = "orangeBannerSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.orange_banner_splashing")
        public static boolean orangeBannerSplashing = true;

        @ConfigEntry(id = "yellowBannerSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.yellow_banner_splashing")
        public static boolean yellowBannerSplashing = true;

        @ConfigEntry(id = "greenBannerSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.green_banner_splashing")
        public static boolean greenBannerSplashing = true;

        @ConfigEntry(id = "limeBannerSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.lime_banner_splashing")
        public static boolean limeBannerSplashing = true;

        @ConfigEntry(id = "cyanBannerSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.cyan_banner_splashing")
        public static boolean cyanBannerSplashing = true;

        @ConfigEntry(id = "lightBlueBannerSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.light_blue_banner_splashing")
        public static boolean lightBlueBannerSplashing = true;

        @ConfigEntry(id = "blueBannerSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.blue_banner_splashing")
        public static boolean blueBannerSplashing = true;

        @ConfigEntry(id = "purpleBannerSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.purple_banner_splashing")
        public static boolean purpleBannerSplashing = true;

        @ConfigEntry(id = "magentaBannerSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.magenta_banner_splashing")
        public static boolean magentaBannerSplashing = true;

        @ConfigEntry(id = "pinkBannerSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.pink_banner_splashing")
        public static boolean pinkBannerSplashing = true;
    }

    @Category(id = "bed_splashing", translation = "config.create_more_farmables.bed_splashing")
    public static final class Bed_Splashing {
        @ConfigEntry(id = "allBedSplashingEnabled",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.all_bed_splashing_enabled")
        @Comment("If false, disables all Bed Splashing (cleaning) recipes.")
        public static boolean allBedSplashingEnabled = true;

        @ConfigEntry(id = "whiteBedSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.white_bed_splashing")
        public static boolean whiteBedSplashing = true;

        @ConfigEntry(id = "lightGrayBedSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.light_gray_bed_splashing")
        public static boolean lightGrayBedSplashing = true;

        @ConfigEntry(id = "grayBedSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.gray_bed_splashing")
        public static boolean grayBedSplashing = true;

        @ConfigEntry(id = "blackBedSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.black_bed_splashing")
        public static boolean blackBedSplashing = true;

        @ConfigEntry(id = "brownBedSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.brown_bed_splashing")
        public static boolean brownBedSplashing = true;

        @ConfigEntry(id = "redBedSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.red_bed_splashing")
        public static boolean redBedSplashing = true;

        @ConfigEntry(id = "orangeBedSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.orange_bed_splashing")
        public static boolean orangeBedSplashing = true;

        @ConfigEntry(id = "yellowBedSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.yellow_bed_splashing")
        public static boolean yellowBedSplashing = true;

        @ConfigEntry(id = "greenBedSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.green_bed_splashing")
        public static boolean greenBedSplashing = true;

        @ConfigEntry(id = "limeBedSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.lime_bed_splashing")
        public static boolean limeBedSplashing = true;

        @ConfigEntry(id = "cyanBedSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.cyan_bed_splashing")
        public static boolean cyanBedSplashing = true;

        @ConfigEntry(id = "lightBlueBedSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.light_blue_bed_splashing")
        public static boolean lightBlueBedSplashing = true;

        @ConfigEntry(id = "blueBedSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.blue_bed_splashing")
        public static boolean blueBedSplashing = true;

        @ConfigEntry(id = "purpleBedSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.purple_bed_splashing")
        public static boolean purpleBedSplashing = true;

        @ConfigEntry(id = "magentaBedSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.magenta_bed_splashing")
        public static boolean magentaBedSplashing = true;

        @ConfigEntry(id = "pinkBedSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.pink_bed_splashing")
        public static boolean pinkBedSplashing = true;
    }

    @Category(id = "glass_splashing", translation = "config.create_more_farmables.glass_splashing")
    public static final class Glass_Splashing {
        @ConfigEntry(id = "allGlassSplashingEnabled",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.all_glass_splashing_enabled")
        @Comment("If false, disables all Stained Glass splashing (dyeing) recipes.")
        public static boolean allGlassSplashingEnabled = true;

        @ConfigEntry(id = "whiteGlassSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.white_glass_splashing")
        public static boolean whiteGlassSplashing = true;

        @ConfigEntry(id = "lightGrayGlassSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.light_gray_glass_splashing")
        public static boolean lightGrayGlassSplashing = true;

        @ConfigEntry(id = "grayGlassSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.gray_glass_splashing")
        public static boolean grayGlassSplashing = true;

        @ConfigEntry(id = "blackGlassSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.black_glass_splashing")
        public static boolean blackGlassSplashing = true;

        @ConfigEntry(id = "brownGlassSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.brown_glass_splashing")
        public static boolean brownGlassSplashing = true;

        @ConfigEntry(id = "redGlassSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.red_glass_splashing")
        public static boolean redGlassSplashing = true;

        @ConfigEntry(id = "orangeGlassSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.orange_glass_splashing")
        public static boolean orangeGlassSplashing = true;

        @ConfigEntry(id = "yellowGlassSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.yellow_glass_splashing")
        public static boolean yellowGlassSplashing = true;

        @ConfigEntry(id = "greenGlassSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.green_glass_splashing")
        public static boolean greenGlassSplashing = true;

        @ConfigEntry(id = "limeGlassSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.lime_glass_splashing")
        public static boolean limeGlassSplashing = true;

        @ConfigEntry(id = "cyanGlassSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.cyan_glass_splashing")
        public static boolean cyanGlassSplashing = true;

        @ConfigEntry(id = "lightBlueGlassSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.light_blue_glass_splashing")
        public static boolean lightBlueGlassSplashing = true;

        @ConfigEntry(id = "blueGlassSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.blue_glass_splashing")
        public static boolean blueGlassSplashing = true;

        @ConfigEntry(id = "purpleGlassSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.purple_glass_splashing")
        public static boolean purpleGlassSplashing = true;

        @ConfigEntry(id = "magentaGlassSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.magenta_glass_splashing")
        public static boolean magentaGlassSplashing = true;

        @ConfigEntry(id = "pinkGlassSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.pink_glass_splashing")
        public static boolean pinkGlassSplashing = true;
    }

    @Category(id = "wool_splashing", translation = "config.create_more_farmables.wool_splashing")
    public static final class Wool_Splashing {
        @ConfigEntry(id = "allWoolSplashingEnabled",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.all_wool_splashing_enabled")
        @Comment("If false, disables all Wool splashing (dyeing) recipes.")
        public static boolean allWoolSplashingEnabled = true;

        @ConfigEntry(id = "whiteWoolSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.white_wool_splashing")
        public static boolean whiteWoolSplashing = true;

        @ConfigEntry(id = "lightGrayWoolSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.light_gray_wool_splashing")
        public static boolean lightGrayWoolSplashing = true;

        @ConfigEntry(id = "grayWoolSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.gray_wool_splashing")
        public static boolean grayWoolSplashing = true;

        @ConfigEntry(id = "blackWoolSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.black_wool_splashing")
        public static boolean blackWoolSplashing = true;

        @ConfigEntry(id = "brownWoolSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.brown_wool_splashing")
        public static boolean brownWoolSplashing = true;

        @ConfigEntry(id = "redWoolSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.red_wool_splashing")
        public static boolean redWoolSplashing = true;

        @ConfigEntry(id = "orangeWoolSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.orange_wool_splashing")
        public static boolean orangeWoolSplashing = true;

        @ConfigEntry(id = "yellowWoolSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.yellow_wool_splashing")
        public static boolean yellowWoolSplashing = true;

        @ConfigEntry(id = "greenWoolSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.green_wool_splashing")
        public static boolean greenWoolSplashing = true;

        @ConfigEntry(id = "limeWoolSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.lime_wool_splashing")
        public static boolean limeWoolSplashing = true;

        @ConfigEntry(id = "cyanWoolSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.cyan_wool_splashing")
        public static boolean cyanWoolSplashing = true;

        @ConfigEntry(id = "lightBlueWoolSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.light_blue_wool_splashing")
        public static boolean lightBlueWoolSplashing = true;

        @ConfigEntry(id = "blueWoolSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.blue_wool_splashing")
        public static boolean blueWoolSplashing = true;

        @ConfigEntry(id = "purpleWoolSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.purple_wool_splashing")
        public static boolean purpleWoolSplashing = true;

        @ConfigEntry(id = "magentaWoolSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.magenta_wool_splashing")
        public static boolean magentaWoolSplashing = true;

        @ConfigEntry(id = "pinkWoolSplashing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.pink_wool_splashing")
        public static boolean pinkWoolSplashing = true;
    }


}

