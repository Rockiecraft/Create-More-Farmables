package net.rockiecraft.foundaton.registry.config;


import com.teamresourceful.resourcefulconfig.common.annotations.Category;
import com.teamresourceful.resourcefulconfig.common.annotations.Comment;
import com.teamresourceful.resourcefulconfig.common.annotations.Config;
import com.teamresourceful.resourcefulconfig.common.annotations.ConfigEntry;
import com.teamresourceful.resourcefulconfig.common.config.EntryType;
import net.rockiecraft.foundaton.AllItems;

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
    @Category(id = "Create More Farmables recipes", translation = "config.create_more_farmables.cmf_recipes_toggle")
    public static final class CreateMoreFarmables_recipes {
        @ConfigEntry(id = "CMF_RecipesToggle",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.cmf_recipes_toggle")
        @Comment("If false, Turns off ALL recipes added by CMF for making items easier to make or for full automation\nThis doesn't include dyes since there are already config options for those recipes")
        public static boolean CMF_RecipesToggle = true;

    }

    @Category(id = "Create More Farmables fluid interactions", translation = "config.create_more_farmables.fluid_interactions")
    public static final class CreateMoreFarmables_fluid_interactions {

        @ConfigEntry(id = "ToggleAllInteractions",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.toggle_all_interactions")
        @Comment("If false, Turns off ALL custom fluid world interactions across the entire mod.")
        public static boolean ToggleAllInteractions = true;

        @ConfigEntry(id = "MoltenEndstoneInteraction",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.molten_endstone_interaction")
        @Comment("If false, Molten Endstone will no longer turn Water into Endstone upon contact.")
        public static boolean MoltenEndstoneInteraction = true;

        @ConfigEntry(id = "LiquidQuartzInteraction",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.liquid_quartz_interaction")
        @Comment("If false, Liquid Quartz will no longer turn Water into Diorite upon contact.")
        public static boolean LiquidQuartzInteraction = true;

        @ConfigEntry(id = "LiquidRedstoneInteraction",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.liquid_redstone_interaction")
        @Comment("If false, Liquid Redstone will no longer turn Water into Granite upon contact.")
        public static boolean LiquidRedstoneInteraction = true;
    }




    @Category(id = "Dyed Water Making", translation = "config.create_more_farmables.dyed_water_making")
    public static final class Dyed_Water_Making {
        @ConfigEntry(id = "allDyedWaterMixingEnabled",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.all_dyed_water_mixing_enabled")
        @Comment("If false, disables all Dyed Water mixing recipes.")
        public static boolean allDyedWaterMixingEnabled = true;

        @ConfigEntry(id = "whiteDyedWaterMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.white_dyed_water_making")
        public static boolean whiteDyedWaterMaking = true;

        @ConfigEntry(id = "lightGrayDyedWaterMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.light_gray_dyed_water_making")
        public static boolean lightGrayDyedWaterMaking = true;

        @ConfigEntry(id = "grayDyedWaterMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.gray_dyed_water_making")
        public static boolean grayDyedWaterMaking = true;

        @ConfigEntry(id = "blackDyedWaterMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.black_dyed_water_making")
        public static boolean blackDyedWaterMaking = true;

        @ConfigEntry(id = "brownDyedWaterMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.brown_dyed_water_making")
        public static boolean brownDyedWaterMaking = true;

        @ConfigEntry(id = "redDyedWaterMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.red_dyed_water_making")
        public static boolean redDyedWaterMaking = true;

        @ConfigEntry(id = "orangeDyedWaterMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.orange_dyed_water_making")
        public static boolean orangeDyedWaterMaking = true;

        @ConfigEntry(id = "yellowDyedWaterMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.yellow_dyed_water_making")
        public static boolean yellowDyedWaterMaking = true;

        @ConfigEntry(id = "greenDyedWaterMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.green_dyed_water_making")
        public static boolean greenDyedWaterMaking = true;

        @ConfigEntry(id = "limeDyedWaterMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.lime_dyed_water_making")
        public static boolean limeDyedWaterMaking = true;

        @ConfigEntry(id = "cyanDyedWaterMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.cyan_dyed_water_making")
        public static boolean cyanDyedWaterMaking = true;

        @ConfigEntry(id = "lightBlueDyedWaterMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.light_blue_dyed_water_making")
        public static boolean lightBlueDyedWaterMaking = true;

        @ConfigEntry(id = "blueDyedWaterMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.blue_dyed_water_making")
        public static boolean blueDyedWaterMaking = true;

        @ConfigEntry(id = "purpleDyedWaterMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.purple_dyed_water_making")
        public static boolean purpleDyedWaterMaking = true;

        @ConfigEntry(id = "magentaDyedWaterMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.magenta_dyed_water_making")
        public static boolean magentaDyedWaterMaking = true;

        @ConfigEntry(id = "pinkDyedWaterMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.pink_dyed_water_making")
        public static boolean pinkDyedWaterMaking = true;
    }


    @Category(id = "Dye Template Filling", translation = "config.create_more_farmables.dye_template_filling")
    public static final class Dye_Template_Filling {
        @ConfigEntry(id = "allDyeFillingEnabled",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.all_dye_filling_enabled")
        @Comment("If false, disables all Dye Template filling recipes.")
        public static boolean allDyeFillingEnabled = true;

        @ConfigEntry(id = "whiteDyeFillingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.white_dye_filling")
        public static boolean whiteDyeFilling = true;

        @ConfigEntry(id = "lightGrayDyeFillingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.light_gray_dye_filling")
        public static boolean lightGrayDyeFilling = true;

        @ConfigEntry(id = "grayDyeFillingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.gray_dye_filling")
        public static boolean grayDyeFilling = true;

        @ConfigEntry(id = "blackDyeFillingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.black_dye_filling")
        public static boolean blackDyeFilling = true;

        @ConfigEntry(id = "brownDyeFillingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.brown_dye_filling")
        public static boolean brownDyeFilling = true;

        @ConfigEntry(id = "redDyeFillingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.red_dye_filling")
        public static boolean redDyeFilling = true;

        @ConfigEntry(id = "orangeDyeFillingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.orange_dye_filling")
        public static boolean orangeDyeFilling = true;

        @ConfigEntry(id = "yellowDyeFillingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.yellow_dye_filling")
        public static boolean yellowDyeFilling = true;

        @ConfigEntry(id = "greenDyeFillingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.green_dye_filling")
        public static boolean greenDyeFilling = true;

        @ConfigEntry(id = "limeDyeFillingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.lime_dye_filling")
        public static boolean limeDyeFilling = true;

        @ConfigEntry(id = "cyanDyeFillingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.cyan_dye_filling")
        public static boolean cyanDyeFilling = true;

        @ConfigEntry(id = "lightBlueDyeFillingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.light_blue_dye_filling")
        public static boolean lightBlueDyeFilling = true;

        @ConfigEntry(id = "blueDyeFillingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.blue_dye_filling")
        public static boolean blueDyeFilling = true;

        @ConfigEntry(id = "purpleDyeFillingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.purple_dye_filling")
        public static boolean purpleDyeFilling = true;

        @ConfigEntry(id = "magentaDyeFillingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.magenta_dye_filling")
        public static boolean magentaDyeFilling = true;

        @ConfigEntry(id = "pinkDyeFillingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.pink_dye_filling")
        public static boolean pinkDyeFilling = true;
    }
    public static void init() {
    }
}

