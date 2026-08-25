package com.rockiecraft.create_more_farmables.v1_21_1.infrastructure.config;

import com.teamresourceful.resourcefulconfig.api.annotations.*;

@Config(
        value = "create_more_farmables",
        categories = {
                CreateMoreFarmablesConfig.CreateMoreFarmablesItems.class,
                CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.class,
                CreateMoreFarmablesConfig.CreateMoreFarmables_fluid_interactions.class,
                CreateMoreFarmablesConfig.Dye_Template_Filling.class,
                CreateMoreFarmablesConfig.Dyed_Water_Making.class,
                CreateMoreFarmablesConfig.Banner_Splashing.class,
                CreateMoreFarmablesConfig.Bed_Splashing.class,
                CreateMoreFarmablesConfig.Glass_Splashing.class,
                CreateMoreFarmablesConfig.Wool_Splashing.class,
                CreateMoreFarmablesConfig.CreateRecipes.class,
                CreateMoreFarmablesConfig.CreateSiftingRecipes.class,
                CreateMoreFarmablesConfig.CarpetDyeSplashing.class,
                CreateMoreFarmablesConfig.StainedGlassPaneDyeSplashing.class,
                CreateMoreFarmablesConfig.ConcretePowderDyeSplashing.class,
                CreateMoreFarmablesConfig.ConcreteDyeSplashing.class,
                CreateMoreFarmablesConfig.TerracottaDyeSplashing.class
        }
)
@ConfigInfo.Color("#7BB252")
public final class CreateMoreFarmablesConfig {

    @ConfigEntry(id = "CMFItemMasterToggleOn",
            translation = "config.create_more_farmables.cmf_item_master_toggle")
    @Comment("If false, Turns off all Create More Farmable item recipes")
    public static boolean CMFItemMasterToggleOn = true;

    @Category(value = "Create More Farmables items")
    public static final class CreateMoreFarmablesItems {
        @ConfigEntry(id = "CMFItemMasterToggleOn",
                translation = "config.create_more_farmables.cmf_item_master_toggle")
        @Comment("If false, Turns off all Create More Farmable item recipes")
        public static boolean CMFItemMasterToggleOn = true;

        @ConfigEntry(id = "echoShardDustOn",
                translation = "config.create_more_farmables.echo_shard_dust_toggle")
        public static boolean echoShardDustOn = true;

        @ConfigEntry(id = "echoShardDustCrushingOn",
                translation = "config.create_more_farmables.echo_shard_dust_crushing_toggle")
        public static boolean echoShardDustCrushingOn = true;

        @ConfigEntry(id = "EnderpearlDustOn",
                translation = "config.create_more_farmables.enderpearl_dust_toggle")
        public static boolean EnderpearlDustOn = true;

        @ConfigEntry(id = "netheriteDustOn",
                translation = "config.create_more_farmables.netherite_dust_toggle")
        public static boolean netheriteDustOn = true;

        @ConfigEntry(id = "shulkerShellFragmentOn",
                translation = "config.create_more_farmables.shulker_shell_fragment_toggle")
        public static boolean shulkerShellFragmentOn = true;

        @ConfigEntry(id = "shulkerCompoundOn",
                translation = "config.create_more_farmables.shulker_compound_toggle")
        public static boolean shulkerCompoundOn = true;

        @ConfigEntry(id = "heartOfTheSeaFragmentOn",
                translation = "config.create_more_farmables.heart_of_the_sea_fragment_toggle")
        public static boolean heartOfTheSeaFragmentOn = true;

        @ConfigEntry(id = "nautilusShellFragmentOn",
                translation = "config.create_more_farmables.heart_of_the_sea_fragment_toggle")
        public static boolean nautilusShellFragmentOn = true;

        @ConfigEntry(id = "dyeTemplateOn",
                translation = "config.create_more_farmables.dye_template_toggle")
        public static boolean dyeTemplateOn = true;

        @ConfigEntry(id = "woodStringWoolOn",
                translation = "config.create_more_farmables.wood_string_wool_toggle")
        public static boolean woodStringWoolOn= true;

        @ConfigEntry(id = "woodStringOn",
                translation = "config.create_more_farmables.wood_string_toggle")
        public static boolean woodStringOn = true;
    }

    @Category(value = "Create More Farmables recipes")
    public static final class CreateMoreFarmables_recipes {
        @ConfigEntry(id = "CMF_RecipesToggle",
                translation = "config.create_more_farmables.cmf_recipes_toggle")
        @Comment("If false, Turns off ALL recipes added by CMF for making items easier to make or for full automation\nThis doesn't include dyes since there are already config options for those recipes")
        public static boolean CMF_RecipesToggle = true;

        @ConfigEntry(id = "dirtMakingOn",
                translation = "config.create_more_farmables.dirt_making_on")
        public static boolean dirtMakingOn = true;

        @ConfigEntry(id = "endstoneMakingOn",
                translation = "config.create_more_farmables.endstone_making_on")
        public static boolean endstoneMakingOn = true;

        @ConfigEntry(id = "magmablockMakingOn",
                translation = "config.create_more_farmables.magmablock_making_on")
        public static boolean magmablockMakingOn = true;

        @ConfigEntry(id = "certusquartzDupeMakingOn",
                translation = "config.create_more_farmables.certusquartz_dupe_making_on")
        public static boolean certusquartzDupeMakingOn = true;

        @ConfigEntry(id = "asurineMakingOn",
                translation = "config.create_more_farmables.asurine_making_on")
        public static boolean asurineMakingOn = true;

        @ConfigEntry(id = "calciteMakingOn",
                translation = "config.create_more_farmables.calcite_making_on")
        public static boolean calciteMakingOn = true;

        @ConfigEntry(id = "crimsiteMakingOn",
                translation = "config.create_more_farmables.crimsite_making_on")
        public static boolean crimsiteMakingOn = true;

        @ConfigEntry(id = "dioriteMakingOn",
                translation = "config.create_more_farmables.diorite_making_on")
        public static boolean dioriteMakingOn = true;

        @ConfigEntry(id = "ochrumMakingOn",

                translation = "config.create_more_farmables.ochrum_making_on")
        public static boolean ochrumMakingOn = true;

        @ConfigEntry(id = "redsandMakingOn",

                translation = "config.create_more_farmables.redsand_making_on")
        public static boolean redsandMakingOn = true;

        @ConfigEntry(id = "veridiumMakingOn",

                translation = "config.create_more_farmables.veridium_making_on")
        public static boolean veridiumMakingOn = true;

        @ConfigEntry(id = "blazeRodMakingOn",

                translation = "config.create_more_farmables.blazerod_making_on")
        public static boolean blazeRodMakingOn = true;

        @ConfigEntry(id = "cobblestonetodioriteMakingOn",

                translation = "config.create_more_farmables.cobblestoneto_diorite_making_on")
        public static boolean cobblestonetodioriteMakingOn = true;

        @ConfigEntry(id = "netheritescrapMakingOn",

                translation = "config.create_more_farmables.netheritescrap_making_on")
        public static boolean netheritescrapMakingOn = true;

        @ConfigEntry(id = "netheritescrapXPNuggetsMakingOn",

                translation = "config.create_more_farmables.netheritescrap_xpnuggets_making_on")
        public static boolean netheritescrapXPNuggetsMakingOn = true;

        @ConfigEntry(id = "roseQuartzMakingOn",

                translation = "config.create_more_farmables.rosequartz_making_on")
        public static boolean roseQuartzMakingOn = true;

        @ConfigEntry(id = "nautilusShellMakingOn",
                translation = "config.create_more_farmables.nautilus_shell_making_on")
        public static boolean nautilusShellMakingOn = true;

        @ConfigEntry(id = "shulkerShellMakingOn",
                translation = "config.create_more_farmables.shulker_shell_making_on")
        public static boolean shulkerShellMakingOn = true;

        @ConfigEntry(id = "netherrackMakingOn",
                translation = "config.create_more_farmables.netherrack_making_on")
        public static boolean netherrackMakingOn = true;

        @ConfigEntry(id = "andesiteNetherrackMakingOn",
                translation = "config.create_more_farmables.andesite_netherrack_making_on")
        public static boolean andesiteNetherrackMakingOn = true;

        @ConfigEntry(id = "redstoneToGlowstoneMakingOn",
                translation = "config.create_more_farmables.redstone_to_glowstone_making_on")
        public static boolean redstoneToGlowstoneMakingOn = true;

        @ConfigEntry(id = "echoShardMakingOn",
                translation = "config.create_more_farmables.echo_shard_making_on")
        public static boolean echoShardMakingOn = true;

        @ConfigEntry(id = "heartOfTheSeaMakingOn",
                translation = "config.create_more_farmables.heart_of_the_sea_making_on")
        public static boolean heartOfTheSeaMakingOn = true;

        @ConfigEntry(id = "redstoneMakingOn",
                translation = "config.create_more_farmables.redstone_making_on")
        public static boolean redstoneMakingOn = true;

        @ConfigEntry(id = "moltenEndstoneMakingOn",
                translation = "config.create_more_farmables.molten_endstone_making_on")
        public static boolean moltenEndstoneMakingOn = true;

        @ConfigEntry(id = "liquidQuartzMakingOn",
                translation = "config.create_more_farmables.liquid_quartz_making_on")
        public static boolean liquidQuartzMakingOn = true;

        @ConfigEntry(id = "liquidRedstoneMakingOn",
                translation = "config.create_more_farmables.liquid_redstone_making_on")
        public static boolean liquidRedstoneMakingOn = true;

        @ConfigEntry(id = "stringMakingOn",
                translation = "config.create_more_farmables.string_making_on")
        public static boolean stringMakingOn = true;

        @ConfigEntry(id = "whiteWoolMakingOn",
                translation = "config.create_more_farmables.white_wool_making_on")
        public static boolean whiteWoolMakingOn = true;

        @ConfigEntry(id = "heartOfTheSeaFragmentMakingOn",
                translation = "config.create_more_farmables.heart_of_the_sea_fragment_making_on")
        public static boolean heartOfTheSeaFragmentMakingOn = true;

    }
    @ConfigObject
    @Category(value = "Create More Farmables fluid interactions")
    public static final class CreateMoreFarmables_fluid_interactions {
        @ConfigEntry(
                id = "ToggleAllInteractions",

                translation = "config.create_more_farmables.toggle_all_interactions"
        )
        @Comment("Master switch for all custom fluid-to-water block conversions.")
        public static boolean ToggleAllInteractions = true;

        @ConfigEntry(
                id = "LiquidQuartzInteraction",

                translation = "config.create_more_farmables.liquid_quartz_interaction"
        )
        @Comment("Should Liquid Quartz turn water into a specific block?")
        public static boolean LiquidQuartzInteraction = true;

        @ConfigEntry(
                id = "LiquidQuartzConversionBlock",
                translation = "config.create_more_farmables.liquid_quartz_conversion_block"
        )
        @Comment("The ID of the block created when Liquid Quartz touches water. Default: minecraft:diorite")
        public static String LiquidQuartzConversionBlock = "minecraft:diorite";

        @ConfigEntry(
                id = "LiquidRedstoneInteraction",

                translation = "config.create_more_farmables.liquid_redstone_interaction"
        )
        @Comment("Should Liquid Redstone turn water into a specific block?")
        public static boolean LiquidRedstoneInteraction = true;

        @ConfigEntry(
                id = "LiquidRedstoneConversionBlock",
                translation = "config.create_more_farmables.liquid_redstone_conversion_block"
        )
        @Comment("The ID of the block created when Liquid Redstone touches water. Default: minecraft:granite")
        public static String LiquidRedstoneConversionBlock = "minecraft:granite";

        @ConfigEntry(
                id = "MoltenEndstoneInteraction",

                translation = "config.create_more_farmables.molten_endstone_interaction"
        )
        @Comment("Should Molten Endstone turn water into a specific block?")
        public static boolean MoltenEndstoneInteraction = true;

        @ConfigEntry(
                id = "MoltenEndstoneConversionBlock",
                translation = "config.create_more_farmables.molten_endstone_conversion_block"
        )
        @Comment("The ID of the block created when Molten Endstone touches water. Default: minecraft:end_stone")
        public static String MoltenEndstoneConversionBlock = "minecraft:end_stone";

        @ConfigEntry(
                id = "AllowFluidDyeing",
                translation = "config.create_more_farmables.allow_fluid_dyeing"
        )
        @Comment("Should dyed water dye leather/wolf armor and other dyeable items that touch it?")
        public static boolean AllowFluidDyeing = true;

        @ConfigEntry(
                id = "AllowBlockDyeing",
                translation = "config.create_more_farmables.allow_block_dyeing"
        )
        @Comment("Should dyed water dye dropped item blocks (wool, carpet, terracotta, etc.) that touch it?")
        public static boolean AllowBlockDyeing = true;
    }

    @ConfigObject
    @Category(value = "Dyed Water Making")
    public static final class Dyed_Water_Making {
        @ConfigEntry(id = "allDyedWaterMixingEnabled",

                translation = "config.create_more_farmables.all_dyed_water_mixing_enabled")
        @Comment("If false, disables all Dyed Water mixing recipes.")
        public static boolean allDyedWaterMixingEnabled = true;

        @ConfigEntry(id = "whiteDyedWaterMakingOn",

                translation = "config.create_more_farmables.white_dyed_water_making")
        public static boolean whiteDyedWaterMaking = true;

        @ConfigEntry(id = "lightGrayDyedWaterMakingOn",

                translation = "config.create_more_farmables.light_gray_dyed_water_making")
        public static boolean lightGrayDyedWaterMaking = true;

        @ConfigEntry(id = "grayDyedWaterMakingOn",

                translation = "config.create_more_farmables.gray_dyed_water_making")
        public static boolean grayDyedWaterMaking = true;

        @ConfigEntry(id = "blackDyedWaterMakingOn",

                translation = "config.create_more_farmables.black_dyed_water_making")
        public static boolean blackDyedWaterMaking = true;

        @ConfigEntry(id = "brownDyedWaterMakingOn",

                translation = "config.create_more_farmables.brown_dyed_water_making")
        public static boolean brownDyedWaterMaking = true;

        @ConfigEntry(id = "redDyedWaterMakingOn",

                translation = "config.create_more_farmables.red_dyed_water_making")
        public static boolean redDyedWaterMaking = true;

        @ConfigEntry(id = "orangeDyedWaterMakingOn",

                translation = "config.create_more_farmables.orange_dyed_water_making")
        public static boolean orangeDyedWaterMaking = true;

        @ConfigEntry(id = "yellowDyedWaterMakingOn",

                translation = "config.create_more_farmables.yellow_dyed_water_making")
        public static boolean yellowDyedWaterMaking = true;

        @ConfigEntry(id = "greenDyedWaterMakingOn",

                translation = "config.create_more_farmables.green_dyed_water_making")
        public static boolean greenDyedWaterMaking = true;

        @ConfigEntry(id = "limeDyedWaterMakingOn",

                translation = "config.create_more_farmables.lime_dyed_water_making")
        public static boolean limeDyedWaterMaking = true;

        @ConfigEntry(id = "cyanDyedWaterMakingOn",

                translation = "config.create_more_farmables.cyan_dyed_water_making")
        public static boolean cyanDyedWaterMaking = true;

        @ConfigEntry(id = "lightBlueDyedWaterMakingOn",

                translation = "config.create_more_farmables.light_blue_dyed_water_making")
        public static boolean lightBlueDyedWaterMaking = true;

        @ConfigEntry(id = "blueDyedWaterMakingOn",

                translation = "config.create_more_farmables.blue_dyed_water_making")
        public static boolean blueDyedWaterMaking = true;

        @ConfigEntry(id = "purpleDyedWaterMakingOn",

                translation = "config.create_more_farmables.purple_dyed_water_making")
        public static boolean purpleDyedWaterMaking = true;

        @ConfigEntry(id = "magentaDyedWaterMakingOn",

                translation = "config.create_more_farmables.magenta_dyed_water_making")
        public static boolean magentaDyedWaterMaking = true;

        @ConfigEntry(id = "pinkDyedWaterMakingOn",

                translation = "config.create_more_farmables.pink_dyed_water_making")
        public static boolean pinkDyedWaterMaking = true;
    }

    @ConfigObject
    @Category(value = "Dye Template Filling")
    public static final class Dye_Template_Filling {
        @ConfigEntry(id = "allDyeFillingEnabled",

                translation = "config.create_more_farmables.all_dye_filling_enabled")
        @Comment("If false, disables all Dye Template filling recipes.")
        public static boolean allDyeFillingEnabled = true;

        @ConfigEntry(id = "whiteDyeFillingOn",

                translation = "config.create_more_farmables.white_dye_filling")
        public static boolean whiteDyeFilling = true;

        @ConfigEntry(id = "lightGrayDyeFillingOn",

                translation = "config.create_more_farmables.light_gray_dye_filling")
        public static boolean lightGrayDyeFilling = true;

        @ConfigEntry(id = "grayDyeFillingOn",

                translation = "config.create_more_farmables.gray_dye_filling")
        public static boolean grayDyeFilling = true;

        @ConfigEntry(id = "blackDyeFillingOn",

                translation = "config.create_more_farmables.black_dye_filling")
        public static boolean blackDyeFilling = true;

        @ConfigEntry(id = "brownDyeFillingOn",

                translation = "config.create_more_farmables.brown_dye_filling")
        public static boolean brownDyeFilling = true;

        @ConfigEntry(id = "redDyeFillingOn",

                translation = "config.create_more_farmables.red_dye_filling")
        public static boolean redDyeFilling = true;

        @ConfigEntry(id = "orangeDyeFillingOn",

                translation = "config.create_more_farmables.orange_dye_filling")
        public static boolean orangeDyeFilling = true;

        @ConfigEntry(id = "yellowDyeFillingOn",

                translation = "config.create_more_farmables.yellow_dye_filling")
        public static boolean yellowDyeFilling = true;

        @ConfigEntry(id = "greenDyeFillingOn",

                translation = "config.create_more_farmables.green_dye_filling")
        public static boolean greenDyeFilling = true;

        @ConfigEntry(id = "limeDyeFillingOn",

                translation = "config.create_more_farmables.lime_dye_filling")
        public static boolean limeDyeFilling = true;

        @ConfigEntry(id = "cyanDyeFillingOn",

                translation = "config.create_more_farmables.cyan_dye_filling")
        public static boolean cyanDyeFilling = true;

        @ConfigEntry(id = "lightBlueDyeFillingOn",

                translation = "config.create_more_farmables.light_blue_dye_filling")
        public static boolean lightBlueDyeFilling = true;

        @ConfigEntry(id = "blueDyeFillingOn",

                translation = "config.create_more_farmables.blue_dye_filling")
        public static boolean blueDyeFilling = true;

        @ConfigEntry(id = "purpleDyeFillingOn",

                translation = "config.create_more_farmables.purple_dye_filling")
        public static boolean purpleDyeFilling = true;

        @ConfigEntry(id = "magentaDyeFillingOn",

                translation = "config.create_more_farmables.magenta_dye_filling")
        public static boolean magentaDyeFilling = true;

        @ConfigEntry(id = "pinkDyeFillingOn",

                translation = "config.create_more_farmables.pink_dye_filling")
        public static boolean pinkDyeFilling = true;
    }

    @ConfigObject
    @Category(value = "banner_splashing")
    public static final class Banner_Splashing {
        @ConfigEntry(id = "allBannerSplashingEnabled",

                translation = "config.create_more_farmables.all_banner_splashing_enabled")
        @Comment("If false, disables all Banner Splashing recipes.")
        public static boolean allBannerSplashingEnabled = true;

        @ConfigEntry(id = "whiteBannerSplashing",

                translation = "config.create_more_farmables.white_banner_splashing")
        public static boolean whiteBannerSplashing = true;

        @ConfigEntry(id = "lightGrayBannerSplashing",

                translation = "config.create_more_farmables.light_gray_banner_splashing")
        public static boolean lightGrayBannerSplashing = true;

        @ConfigEntry(id = "grayBannerSplashing",

                translation = "config.create_more_farmables.gray_banner_splashing")
        public static boolean grayBannerSplashing = true;

        @ConfigEntry(id = "blackBannerSplashing",

                translation = "config.create_more_farmables.black_banner_splashing")
        public static boolean blackBannerSplashing = true;

        @ConfigEntry(id = "brownBannerSplashing",

                translation = "config.create_more_farmables.brown_banner_splashing")
        public static boolean brownBannerSplashing = true;

        @ConfigEntry(id = "redBannerSplashing",

                translation = "config.create_more_farmables.red_banner_splashing")
        public static boolean redBannerSplashing = true;

        @ConfigEntry(id = "orangeBannerSplashing",

                translation = "config.create_more_farmables.orange_banner_splashing")
        public static boolean orangeBannerSplashing = true;

        @ConfigEntry(id = "yellowBannerSplashing",

                translation = "config.create_more_farmables.yellow_banner_splashing")
        public static boolean yellowBannerSplashing = true;

        @ConfigEntry(id = "greenBannerSplashing",

                translation = "config.create_more_farmables.green_banner_splashing")
        public static boolean greenBannerSplashing = true;

        @ConfigEntry(id = "limeBannerSplashing",

                translation = "config.create_more_farmables.lime_banner_splashing")
        public static boolean limeBannerSplashing = true;

        @ConfigEntry(id = "cyanBannerSplashing",

                translation = "config.create_more_farmables.cyan_banner_splashing")
        public static boolean cyanBannerSplashing = true;

        @ConfigEntry(id = "lightBlueBannerSplashing",

                translation = "config.create_more_farmables.light_blue_banner_splashing")
        public static boolean lightBlueBannerSplashing = true;

        @ConfigEntry(id = "blueBannerSplashing",

                translation = "config.create_more_farmables.blue_banner_splashing")
        public static boolean blueBannerSplashing = true;

        @ConfigEntry(id = "purpleBannerSplashing",

                translation = "config.create_more_farmables.purple_banner_splashing")
        public static boolean purpleBannerSplashing = true;

        @ConfigEntry(id = "magentaBannerSplashing",

                translation = "config.create_more_farmables.magenta_banner_splashing")
        public static boolean magentaBannerSplashing = true;

        @ConfigEntry(id = "pinkBannerSplashing",

                translation = "config.create_more_farmables.pink_banner_splashing")
        public static boolean pinkBannerSplashing = true;
    }
    @ConfigObject
    @Category(value = "bed_splashing")
    public static final class Bed_Splashing {
        @ConfigEntry(id = "allBedSplashingEnabled",

                translation = "config.create_more_farmables.all_bed_splashing_enabled")
        @Comment("If false, disables all Bed Splashing (cleaning) recipes.")
        public static boolean allBedSplashingEnabled = true;

        @ConfigEntry(id = "whiteBedSplashing",

                translation = "config.create_more_farmables.white_bed_splashing")
        public static boolean whiteBedSplashing = true;

        @ConfigEntry(id = "lightGrayBedSplashing",

                translation = "config.create_more_farmables.light_gray_bed_splashing")
        public static boolean lightGrayBedSplashing = true;

        @ConfigEntry(id = "grayBedSplashing",

                translation = "config.create_more_farmables.gray_bed_splashing")
        public static boolean grayBedSplashing = true;

        @ConfigEntry(id = "blackBedSplashing",

                translation = "config.create_more_farmables.black_bed_splashing")
        public static boolean blackBedSplashing = true;

        @ConfigEntry(id = "brownBedSplashing",

                translation = "config.create_more_farmables.brown_bed_splashing")
        public static boolean brownBedSplashing = true;

        @ConfigEntry(id = "redBedSplashing",

                translation = "config.create_more_farmables.red_bed_splashing")
        public static boolean redBedSplashing = true;

        @ConfigEntry(id = "orangeBedSplashing",

                translation = "config.create_more_farmables.orange_bed_splashing")
        public static boolean orangeBedSplashing = true;

        @ConfigEntry(id = "yellowBedSplashing",

                translation = "config.create_more_farmables.yellow_bed_splashing")
        public static boolean yellowBedSplashing = true;

        @ConfigEntry(id = "greenBedSplashing",

                translation = "config.create_more_farmables.green_bed_splashing")
        public static boolean greenBedSplashing = true;

        @ConfigEntry(id = "limeBedSplashing",

                translation = "config.create_more_farmables.lime_bed_splashing")
        public static boolean limeBedSplashing = true;

        @ConfigEntry(id = "cyanBedSplashing",

                translation = "config.create_more_farmables.cyan_bed_splashing")
        public static boolean cyanBedSplashing = true;

        @ConfigEntry(id = "lightBlueBedSplashing",

                translation = "config.create_more_farmables.light_blue_bed_splashing")
        public static boolean lightBlueBedSplashing = true;

        @ConfigEntry(id = "blueBedSplashing",

                translation = "config.create_more_farmables.blue_bed_splashing")
        public static boolean blueBedSplashing = true;

        @ConfigEntry(id = "purpleBedSplashing",

                translation = "config.create_more_farmables.purple_bed_splashing")
        public static boolean purpleBedSplashing = true;

        @ConfigEntry(id = "magentaBedSplashing",

                translation = "config.create_more_farmables.magenta_bed_splashing")
        public static boolean magentaBedSplashing = true;

        @ConfigEntry(id = "pinkBedSplashing",

                translation = "config.create_more_farmables.pink_bed_splashing")
        public static boolean pinkBedSplashing = true;
    }
    @ConfigObject
    @Category(value = "glass_splashing")
    public static final class Glass_Splashing {
        @ConfigEntry(id = "allGlassSplashingEnabled",

                translation = "config.create_more_farmables.all_glass_splashing_enabled")
        @Comment("If false, disables all Stained Glass splashing (dyeing) recipes.")
        public static boolean allGlassSplashingEnabled = true;

        @ConfigEntry(id = "whiteGlassSplashing",

                translation = "config.create_more_farmables.white_glass_splashing")
        public static boolean whiteGlassSplashing = true;

        @ConfigEntry(id = "lightGrayGlassSplashing",

                translation = "config.create_more_farmables.light_gray_glass_splashing")
        public static boolean lightGrayGlassSplashing = true;

        @ConfigEntry(id = "grayGlassSplashing",

                translation = "config.create_more_farmables.gray_glass_splashing")
        public static boolean grayGlassSplashing = true;

        @ConfigEntry(id = "blackGlassSplashing",

                translation = "config.create_more_farmables.black_glass_splashing")
        public static boolean blackGlassSplashing = true;

        @ConfigEntry(id = "brownGlassSplashing",

                translation = "config.create_more_farmables.brown_glass_splashing")
        public static boolean brownGlassSplashing = true;

        @ConfigEntry(id = "redGlassSplashing",

                translation = "config.create_more_farmables.red_glass_splashing")
        public static boolean redGlassSplashing = true;

        @ConfigEntry(id = "orangeGlassSplashing",

                translation = "config.create_more_farmables.orange_glass_splashing")
        public static boolean orangeGlassSplashing = true;

        @ConfigEntry(id = "yellowGlassSplashing",

                translation = "config.create_more_farmables.yellow_glass_splashing")
        public static boolean yellowGlassSplashing = true;

        @ConfigEntry(id = "greenGlassSplashing",

                translation = "config.create_more_farmables.green_glass_splashing")
        public static boolean greenGlassSplashing = true;

        @ConfigEntry(id = "limeGlassSplashing",

                translation = "config.create_more_farmables.lime_glass_splashing")
        public static boolean limeGlassSplashing = true;

        @ConfigEntry(id = "cyanGlassSplashing",

                translation = "config.create_more_farmables.cyan_glass_splashing")
        public static boolean cyanGlassSplashing = true;

        @ConfigEntry(id = "lightBlueGlassSplashing",

                translation = "config.create_more_farmables.light_blue_glass_splashing")
        public static boolean lightBlueGlassSplashing = true;

        @ConfigEntry(id = "blueGlassSplashing",

                translation = "config.create_more_farmables.blue_glass_splashing")
        public static boolean blueGlassSplashing = true;

        @ConfigEntry(id = "purpleGlassSplashing",
                translation = "config.create_more_farmables.purple_glass_splashing")
        public static boolean purpleGlassSplashing = true;

        @ConfigEntry(id = "magentaGlassSplashing",
                translation = "config.create_more_farmables.magenta_glass_splashing")
        public static boolean magentaGlassSplashing = true;

        @ConfigEntry(id = "pinkGlassSplashing",
                translation = "config.create_more_farmables.pink_glass_splashing")
        public static boolean pinkGlassSplashing = true;
    }
    @ConfigObject
    @Category(value = "wool_splashing")
    public static final class Wool_Splashing {
        @ConfigEntry(id = "allWoolSplashingEnabled",
                translation = "config.create_more_farmables.all_wool_splashing_enabled")
        @Comment("If false, disables all Wool splashing (dyeing) recipes.")
        public static boolean allWoolSplashingEnabled = true;

        @ConfigEntry(id = "whiteWoolSplashing",
                translation = "config.create_more_farmables.white_wool_splashing")
        public static boolean whiteWoolSplashing = true;

        @ConfigEntry(id = "lightGrayWoolSplashing",
                translation = "config.create_more_farmables.light_gray_wool_splashing")
        public static boolean lightGrayWoolSplashing = true;

        @ConfigEntry(id = "grayWoolSplashing",
                translation = "config.create_more_farmables.gray_wool_splashing")
        public static boolean grayWoolSplashing = true;

        @ConfigEntry(id = "blackWoolSplashing",
                translation = "config.create_more_farmables.black_wool_splashing")
        public static boolean blackWoolSplashing = true;

        @ConfigEntry(id = "brownWoolSplashing",
                translation = "config.create_more_farmables.brown_wool_splashing")
        public static boolean brownWoolSplashing = true;

        @ConfigEntry(id = "redWoolSplashing",
                translation = "config.create_more_farmables.red_wool_splashing")
        public static boolean redWoolSplashing = true;

        @ConfigEntry(id = "orangeWoolSplashing",
                translation = "config.create_more_farmables.orange_wool_splashing")
        public static boolean orangeWoolSplashing = true;

        @ConfigEntry(id = "yellowWoolSplashing",
                translation = "config.create_more_farmables.yellow_wool_splashing")
        public static boolean yellowWoolSplashing = true;

        @ConfigEntry(id = "greenWoolSplashing",
                translation = "config.create_more_farmables.green_wool_splashing")
        public static boolean greenWoolSplashing = true;

        @ConfigEntry(id = "limeWoolSplashing",
                translation = "config.create_more_farmables.lime_wool_splashing")
        public static boolean limeWoolSplashing = true;

        @ConfigEntry(id = "cyanWoolSplashing",
                translation = "config.create_more_farmables.cyan_wool_splashing")
        public static boolean cyanWoolSplashing = true;

        @ConfigEntry(id = "lightBlueWoolSplashing",
                translation = "config.create_more_farmables.light_blue_wool_splashing")
        public static boolean lightBlueWoolSplashing = true;

        @ConfigEntry(id = "blueWoolSplashing",
                translation = "config.create_more_farmables.blue_wool_splashing")
        public static boolean blueWoolSplashing = true;

        @ConfigEntry(id = "purpleWoolSplashing",
                translation = "config.create_more_farmables.purple_wool_splashing")
        public static boolean purpleWoolSplashing = true;

        @ConfigEntry(id = "magentaWoolSplashing",
                translation = "config.create_more_farmables.magenta_wool_splashing")
        public static boolean magentaWoolSplashing = true;

        @ConfigEntry(id = "pinkWoolSplashing",
                translation = "config.create_more_farmables.pink_wool_splashing")
        public static boolean pinkWoolSplashing = true;
    }

    @ConfigObject
    @Category(value = "Create Recipes Toggles")
    public static final class CreateRecipes {
        @ConfigEntry(id = "createRecipesMasterToggle",
                translation = "config.create_more_farmables.create_recipes_master_toggles")
        @Comment("If False, Disable all recipes CMF adds to replace Create recipes")
        public static boolean createRecipesMasterToggle = true;

        @ConfigEntry(id = "asurineCrushing",
                translation = "config.create_more_farmables.asurine_crushing")
        public static boolean asurineCrushing = true;

        @ConfigEntry(id = "asurineRecycling",
                translation = "config.create_more_farmables.asurine_recycling")
        public static boolean asurineRecycling = true;

        @ConfigEntry(id = "crimsiteCrushing",
                translation = "config.create_more_farmables.crimsite_crushing")
        public static boolean crimsiteCrushing = true;

        @ConfigEntry(id = "crimsiteRecycling",
                translation = "config.create_more_farmables.crimsite_recycling")
        public static boolean crimsiteRecycling = true;

        @ConfigEntry(id = "ochrumCrushing",
                translation = "config.create_more_farmables.ochrum_crushing")
        public static boolean ochrumCrushing = true;

        @ConfigEntry(id = "ochrumRecycling",
                translation = "config.create_more_farmables.ochrum_recycling")
        public static boolean ochrumRecycling = true;

        @ConfigEntry(id = "scoriaToLapisLazuli",
                translation = "config.create_more_farmables.scoria_to_lapis_lazuli")
        public static boolean scoriaToLapisLazuli = true;
    }

    @ConfigObject
    @Category(value = "Create Sifting Recipe Toggles")
    public static final class CreateSiftingRecipes {
        @ConfigEntry(id = "createSiftingRecipesMasterToggle",
                translation = "config.create_more_farmables.create_sifting_recipes_master_toggles")
        @Comment("If False, Disable all recipes Create Sifting recipes CMF adds")
        public static boolean createSiftingRecipesMasterToggle = true;

        @ConfigEntry(id = "advancedGravelSiftingOn",
                translation = "config.create_more_farmables.advanced_gravel_sifting_on")
        public static boolean advancedGravelSiftingOn = true;

        @ConfigEntry(id = "advancedRedsandSiftingOn",
                translation = "config.create_more_farmables.advanced_redsand_sifting_on")
        public static boolean advancedRedsandSiftingOn = true;

        @ConfigEntry(id = "advancedSandSiftingOn",
                translation = "config.create_more_farmables.advanced_sand_sifting_on")
        public static boolean advancedSandSiftingOn = true;

        @ConfigEntry(id = "advancedSpongeSiftingOn",
                translation = "config.create_more_farmables.advanced_sponge_sifting_on")
        public static boolean advancedSpongeSiftingOn = true;
    }

    @ConfigObject
    @Category(value = "Carpet Dye Splashing")
    public static final class CarpetDyeSplashing {
        @ConfigEntry(id = "allCarpetDyeSplashingEnabled",
                translation = "config.create_more_farmables.carpet_dye_splashing.all_enabled")
        @Comment("If false, disables all Carpet dye splashing recipes.")
        public static boolean allCarpetDyeSplashingEnabled = true;

        @ConfigEntry(id = "whiteCarpetDyeSplashingOn",
                translation = "config.create_more_farmables.carpet_dye_splashing.white")
        public static boolean whiteCarpetDyeSplashing = true;

        @ConfigEntry(id = "lightGrayCarpetDyeSplashingOn",
                translation = "config.create_more_farmables.carpet_dye_splashing.light_gray")
        public static boolean lightGrayCarpetDyeSplashing = true;

        @ConfigEntry(id = "grayCarpetDyeSplashingOn",
                translation = "config.create_more_farmables.carpet_dye_splashing.gray")
        public static boolean grayCarpetDyeSplashing = true;

        @ConfigEntry(id = "blackCarpetDyeSplashingOn",
                translation = "config.create_more_farmables.carpet_dye_splashing.black")
        public static boolean blackCarpetDyeSplashing = true;

        @ConfigEntry(id = "brownCarpetDyeSplashingOn",
                translation = "config.create_more_farmables.carpet_dye_splashing.brown")
        public static boolean brownCarpetDyeSplashing = true;

        @ConfigEntry(id = "redCarpetDyeSplashingOn",
                translation = "config.create_more_farmables.carpet_dye_splashing.red")
        public static boolean redCarpetDyeSplashing = true;

        @ConfigEntry(id = "orangeCarpetDyeSplashingOn",
                translation = "config.create_more_farmables.carpet_dye_splashing.orange")
        public static boolean orangeCarpetDyeSplashing = true;

        @ConfigEntry(id = "yellowCarpetDyeSplashingOn",
                translation = "config.create_more_farmables.carpet_dye_splashing.yellow")
        public static boolean yellowCarpetDyeSplashing = true;

        @ConfigEntry(id = "limeCarpetDyeSplashingOn",
                translation = "config.create_more_farmables.carpet_dye_splashing.lime")
        public static boolean limeCarpetDyeSplashing = true;

        @ConfigEntry(id = "greenCarpetDyeSplashingOn",
                translation = "config.create_more_farmables.carpet_dye_splashing.green")
        public static boolean greenCarpetDyeSplashing = true;

        @ConfigEntry(id = "cyanCarpetDyeSplashingOn",
                translation = "config.create_more_farmables.carpet_dye_splashing.cyan")
        public static boolean cyanCarpetDyeSplashing = true;

        @ConfigEntry(id = "lightBlueCarpetDyeSplashingOn",
                translation = "config.create_more_farmables.carpet_dye_splashing.light_blue")
        public static boolean lightBlueCarpetDyeSplashing = true;

        @ConfigEntry(id = "blueCarpetDyeSplashingOn",
                translation = "config.create_more_farmables.carpet_dye_splashing.blue")
        public static boolean blueCarpetDyeSplashing = true;

        @ConfigEntry(id = "purpleCarpetDyeSplashingOn",
                translation = "config.create_more_farmables.carpet_dye_splashing.purple")
        public static boolean purpleCarpetDyeSplashing = true;

        @ConfigEntry(id = "magentaCarpetDyeSplashingOn",
                translation = "config.create_more_farmables.carpet_dye_splashing.magenta")
        public static boolean magentaCarpetDyeSplashing = true;

        @ConfigEntry(id = "pinkCarpetDyeSplashingOn",
                translation = "config.create_more_farmables.carpet_dye_splashing.pink")
        public static boolean pinkCarpetDyeSplashing = true;
    }

    @ConfigObject
    @Category(value = "StainedGlassPane Dye Splashing")
    public static final class StainedGlassPaneDyeSplashing {
        @ConfigEntry(id = "allStainedGlassPaneDyeSplashingEnabled",
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.all_enabled")
        @Comment("If false, disables all StainedGlassPane dye splashing recipes.")
        public static boolean allStainedGlassPaneDyeSplashingEnabled = true;

        @ConfigEntry(id = "whiteStainedGlassPaneDyeSplashingOn",
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.white")
        public static boolean whiteStainedGlassPaneDyeSplashing = true;

        @ConfigEntry(id = "lightGrayStainedGlassPaneDyeSplashingOn",
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.light_gray")
        public static boolean lightGrayStainedGlassPaneDyeSplashing = true;

        @ConfigEntry(id = "grayStainedGlassPaneDyeSplashingOn",
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.gray")
        public static boolean grayStainedGlassPaneDyeSplashing = true;

        @ConfigEntry(id = "blackStainedGlassPaneDyeSplashingOn",
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.black")
        public static boolean blackStainedGlassPaneDyeSplashing = true;

        @ConfigEntry(id = "brownStainedGlassPaneDyeSplashingOn",
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.brown")
        public static boolean brownStainedGlassPaneDyeSplashing = true;

        @ConfigEntry(id = "redStainedGlassPaneDyeSplashingOn",
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.red")
        public static boolean redStainedGlassPaneDyeSplashing = true;

        @ConfigEntry(id = "orangeStainedGlassPaneDyeSplashingOn",
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.orange")
        public static boolean orangeStainedGlassPaneDyeSplashing = true;

        @ConfigEntry(id = "yellowStainedGlassPaneDyeSplashingOn",
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.yellow")
        public static boolean yellowStainedGlassPaneDyeSplashing = true;

        @ConfigEntry(id = "limeStainedGlassPaneDyeSplashingOn",
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.lime")
        public static boolean limeStainedGlassPaneDyeSplashing = true;

        @ConfigEntry(id = "greenStainedGlassPaneDyeSplashingOn",
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.green")
        public static boolean greenStainedGlassPaneDyeSplashing = true;

        @ConfigEntry(id = "cyanStainedGlassPaneDyeSplashingOn",
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.cyan")
        public static boolean cyanStainedGlassPaneDyeSplashing = true;

        @ConfigEntry(id = "lightBlueStainedGlassPaneDyeSplashingOn",
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.light_blue")
        public static boolean lightBlueStainedGlassPaneDyeSplashing = true;

        @ConfigEntry(id = "blueStainedGlassPaneDyeSplashingOn",
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.blue")
        public static boolean blueStainedGlassPaneDyeSplashing = true;

        @ConfigEntry(id = "purpleStainedGlassPaneDyeSplashingOn",
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.purple")
        public static boolean purpleStainedGlassPaneDyeSplashing = true;

        @ConfigEntry(id = "magentaStainedGlassPaneDyeSplashingOn",
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.magenta")
        public static boolean magentaStainedGlassPaneDyeSplashing = true;

        @ConfigEntry(id = "pinkStainedGlassPaneDyeSplashingOn",
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.pink")
        public static boolean pinkStainedGlassPaneDyeSplashing = true;
    }

    @ConfigObject
    @Category(value = "ConcretePowder Dye Splashing")
    public static final class ConcretePowderDyeSplashing {
        @ConfigEntry(id = "allConcretePowderDyeSplashingEnabled",
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.all_enabled")
        @Comment("If false, disables all ConcretePowder dye splashing recipes.")
        public static boolean allConcretePowderDyeSplashingEnabled = true;

        @ConfigEntry(id = "whiteConcretePowderDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.white")
        public static boolean whiteConcretePowderDyeSplashing = true;

        @ConfigEntry(id = "lightGrayConcretePowderDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.light_gray")
        public static boolean lightGrayConcretePowderDyeSplashing = true;

        @ConfigEntry(id = "grayConcretePowderDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.gray")
        public static boolean grayConcretePowderDyeSplashing = true;

        @ConfigEntry(id = "blackConcretePowderDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.black")
        public static boolean blackConcretePowderDyeSplashing = true;

        @ConfigEntry(id = "brownConcretePowderDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.brown")
        public static boolean brownConcretePowderDyeSplashing = true;

        @ConfigEntry(id = "redConcretePowderDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.red")
        public static boolean redConcretePowderDyeSplashing = true;

        @ConfigEntry(id = "orangeConcretePowderDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.orange")
        public static boolean orangeConcretePowderDyeSplashing = true;

        @ConfigEntry(id = "yellowConcretePowderDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.yellow")
        public static boolean yellowConcretePowderDyeSplashing = true;

        @ConfigEntry(id = "limeConcretePowderDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.lime")
        public static boolean limeConcretePowderDyeSplashing = true;

        @ConfigEntry(id = "greenConcretePowderDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.green")
        public static boolean greenConcretePowderDyeSplashing = true;

        @ConfigEntry(id = "cyanConcretePowderDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.cyan")
        public static boolean cyanConcretePowderDyeSplashing = true;

        @ConfigEntry(id = "lightBlueConcretePowderDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.light_blue")
        public static boolean lightBlueConcretePowderDyeSplashing = true;

        @ConfigEntry(id = "blueConcretePowderDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.blue")
        public static boolean blueConcretePowderDyeSplashing = true;

        @ConfigEntry(id = "purpleConcretePowderDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.purple")
        public static boolean purpleConcretePowderDyeSplashing = true;

        @ConfigEntry(id = "magentaConcretePowderDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.magenta")
        public static boolean magentaConcretePowderDyeSplashing = true;

        @ConfigEntry(id = "pinkConcretePowderDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.pink")
        public static boolean pinkConcretePowderDyeSplashing = true;
    }

    @ConfigObject
    @Category(value = "Concrete Dye Splashing")
    public static final class ConcreteDyeSplashing {
        @ConfigEntry(id = "allConcreteDyeSplashingEnabled",
                translation = "config.create_more_farmables.concrete_dye_splashing.all_enabled")
        @Comment("If false, disables all Concrete dye splashing recipes.")
        public static boolean allConcreteDyeSplashingEnabled = true;

        @ConfigEntry(id = "whiteConcreteDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_dye_splashing.white")
        public static boolean whiteConcreteDyeSplashing = true;

        @ConfigEntry(id = "lightGrayConcreteDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_dye_splashing.light_gray")
        public static boolean lightGrayConcreteDyeSplashing = true;

        @ConfigEntry(id = "grayConcreteDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_dye_splashing.gray")
        public static boolean grayConcreteDyeSplashing = true;

        @ConfigEntry(id = "blackConcreteDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_dye_splashing.black")
        public static boolean blackConcreteDyeSplashing = true;

        @ConfigEntry(id = "brownConcreteDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_dye_splashing.brown")
        public static boolean brownConcreteDyeSplashing = true;

        @ConfigEntry(id = "redConcreteDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_dye_splashing.red")
        public static boolean redConcreteDyeSplashing = true;

        @ConfigEntry(id = "orangeConcreteDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_dye_splashing.orange")
        public static boolean orangeConcreteDyeSplashing = true;

        @ConfigEntry(id = "yellowConcreteDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_dye_splashing.yellow")
        public static boolean yellowConcreteDyeSplashing = true;

        @ConfigEntry(id = "limeConcreteDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_dye_splashing.lime")
        public static boolean limeConcreteDyeSplashing = true;

        @ConfigEntry(id = "greenConcreteDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_dye_splashing.green")
        public static boolean greenConcreteDyeSplashing = true;

        @ConfigEntry(id = "cyanConcreteDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_dye_splashing.cyan")
        public static boolean cyanConcreteDyeSplashing = true;

        @ConfigEntry(id = "lightBlueConcreteDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_dye_splashing.light_blue")
        public static boolean lightBlueConcreteDyeSplashing = true;

        @ConfigEntry(id = "blueConcreteDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_dye_splashing.blue")
        public static boolean blueConcreteDyeSplashing = true;

        @ConfigEntry(id = "purpleConcreteDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_dye_splashing.purple")
        public static boolean purpleConcreteDyeSplashing = true;

        @ConfigEntry(id = "magentaConcreteDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_dye_splashing.magenta")
        public static boolean magentaConcreteDyeSplashing = true;

        @ConfigEntry(id = "pinkConcreteDyeSplashingOn",
                translation = "config.create_more_farmables.concrete_dye_splashing.pink")
        public static boolean pinkConcreteDyeSplashing = true;
    }

    @ConfigObject
    @Category(value = "Terracotta Dye Splashing")
    public static final class TerracottaDyeSplashing {
        @ConfigEntry(id = "allTerracottaDyeSplashingEnabled",
                translation = "config.create_more_farmables.terracotta_dye_splashing.all_enabled")
        @Comment("If false, disables all Terracotta dye splashing recipes.")
        public static boolean allTerracottaDyeSplashingEnabled = true;

        @ConfigEntry(id = "whiteTerracottaDyeSplashingOn",
                translation = "config.create_more_farmables.terracotta_dye_splashing.white")
        public static boolean whiteTerracottaDyeSplashing = true;

        @ConfigEntry(id = "lightGrayTerracottaDyeSplashingOn",
                translation = "config.create_more_farmables.terracotta_dye_splashing.light_gray")
        public static boolean lightGrayTerracottaDyeSplashing = true;

        @ConfigEntry(id = "grayTerracottaDyeSplashingOn",
                translation = "config.create_more_farmables.terracotta_dye_splashing.gray")
        public static boolean grayTerracottaDyeSplashing = true;

        @ConfigEntry(id = "blackTerracottaDyeSplashingOn",
                translation = "config.create_more_farmables.terracotta_dye_splashing.black")
        public static boolean blackTerracottaDyeSplashing = true;

        @ConfigEntry(id = "brownTerracottaDyeSplashingOn",
                translation = "config.create_more_farmables.terracotta_dye_splashing.brown")
        public static boolean brownTerracottaDyeSplashing = true;

        @ConfigEntry(id = "redTerracottaDyeSplashingOn",
                translation = "config.create_more_farmables.terracotta_dye_splashing.red")
        public static boolean redTerracottaDyeSplashing = true;

        @ConfigEntry(id = "orangeTerracottaDyeSplashingOn",
                translation = "config.create_more_farmables.terracotta_dye_splashing.orange")
        public static boolean orangeTerracottaDyeSplashing = true;

        @ConfigEntry(id = "yellowTerracottaDyeSplashingOn",
                translation = "config.create_more_farmables.terracotta_dye_splashing.yellow")
        public static boolean yellowTerracottaDyeSplashing = true;

        @ConfigEntry(id = "limeTerracottaDyeSplashingOn",
                translation = "config.create_more_farmables.terracotta_dye_splashing.lime")
        public static boolean limeTerracottaDyeSplashing = true;

        @ConfigEntry(id = "greenTerracottaDyeSplashingOn",
                translation = "config.create_more_farmables.terracotta_dye_splashing.green")
        public static boolean greenTerracottaDyeSplashing = true;

        @ConfigEntry(id = "cyanTerracottaDyeSplashingOn",
                translation = "config.create_more_farmables.terracotta_dye_splashing.cyan")
        public static boolean cyanTerracottaDyeSplashing = true;

        @ConfigEntry(id = "lightBlueTerracottaDyeSplashingOn",
                translation = "config.create_more_farmables.terracotta_dye_splashing.light_blue")
        public static boolean lightBlueTerracottaDyeSplashing = true;

        @ConfigEntry(id = "blueTerracottaDyeSplashingOn",
                translation = "config.create_more_farmables.terracotta_dye_splashing.blue")
        public static boolean blueTerracottaDyeSplashing = true;

        @ConfigEntry(id = "purpleTerracottaDyeSplashingOn",
                translation = "config.create_more_farmables.terracotta_dye_splashing.purple")
        public static boolean purpleTerracottaDyeSplashing = true;

        @ConfigEntry(id = "magentaTerracottaDyeSplashingOn",
                translation = "config.create_more_farmables.terracotta_dye_splashing.magenta")
        public static boolean magentaTerracottaDyeSplashing = true;

        @ConfigEntry(id = "pinkTerracottaDyeSplashingOn",
                translation = "config.create_more_farmables.terracotta_dye_splashing.pink")
        public static boolean pinkTerracottaDyeSplashing = true;
    }

    public static void init() {
    }

}