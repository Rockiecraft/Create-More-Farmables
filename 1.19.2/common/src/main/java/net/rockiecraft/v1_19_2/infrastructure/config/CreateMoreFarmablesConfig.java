package net.rockiecraft.v1_20_1.infrastructure.config;

import com.teamresourceful.resourcefulconfig.common.annotations.Category;
import com.teamresourceful.resourcefulconfig.common.annotations.Comment;
import com.teamresourceful.resourcefulconfig.common.annotations.Config;
import com.teamresourceful.resourcefulconfig.common.annotations.ConfigEntry;
import com.teamresourceful.resourcefulconfig.common.config.EntryType;

@Config("create_more_farmables")
public final class CreateMoreFarmablesConfig {

    @Category(id = "Create More Farmables items", translation = "config.create_more_farmables.cmf_items")
    public static final class CreateMoreFarmables {
        @ConfigEntry(id = "cmfItemMasterToggleOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.cmf_item_master_toggle")
        @Comment("If false, Turns off all Create More Farmable item recipes")
        public static boolean cmfItemMasterToggleOn = true;

        @ConfigEntry(id = "echoShardDustCrushingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.echo_shard_dust_crushing_toggle")
        public static boolean echoShardDustCrushingOn = true;

        @ConfigEntry(id = "echoShardDustOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.echo_shard_dust_toggle")
        public static boolean echoShardDustOn = true;

        @ConfigEntry(id = "enderpearlDustOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.enderpearl_dust_toggle")
        public static boolean enderpearlDustOn = true;

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
                translation = "config.create_more_farmables.nautilus_shell_fragment_toggle")
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
        @ConfigEntry(id = "cmfRecipesToggle",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.cmf_recipes_toggle")
        @Comment("If false, Turns off ALL recipes added by CMF for making items easier to make or for full automation\nThis doesn't include dyes since there are already config options for those recipes")
        public static boolean cmfRecipesToggle = true;

        @ConfigEntry(id = "dirtMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.dirt_making_on")
        public static boolean dirtMakingOn = true;

        @ConfigEntry(id = "endstoneMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.endstone_making_on")
        public static boolean endstoneMakingOn = true;

        @ConfigEntry(id = "magmablockMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.magmablock_making_on")
        public static boolean magmablockMakingOn = true;

        @ConfigEntry(id = "asurineMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.asurine_making_on")
        public static boolean asurineMakingOn = true;

        @ConfigEntry(id = "calciteMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.calcite_making_on")
        public static boolean calciteMakingOn = true;

        @ConfigEntry(id = "crimsiteMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.crimsite_making_on")
        public static boolean crimsiteMakingOn = true;

        @ConfigEntry(id = "dioriteMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.diorite_making_on")
        public static boolean dioriteMakingOn = true;

        @ConfigEntry(id = "ochrumMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.ochrum_making_on")
        public static boolean ochrumMakingOn = true;

        @ConfigEntry(id = "redsandMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.redsand_making_on")
        public static boolean redsandMakingOn = true;

        @ConfigEntry(id = "veridiumMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.veridium_making_on")
        public static boolean veridiumMakingOn = true;

        @ConfigEntry(id = "nautilusShellMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.nautilus_shell_making_on")
        public static boolean nautilusShellMakingOn = true;

        @ConfigEntry(id = "shulkerShellMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.shulker_shell_making_on")
        public static boolean shulkerShellMakingOn = true;

        @ConfigEntry(id = "netherrackMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.netherrack_making_on")
        public static boolean netherrackMakingOn = true;

        @ConfigEntry(id = "andesiteNetherrackMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.andesite_netherrack_making_on")
        public static boolean andesiteNetherrackMakingOn = true;

        @ConfigEntry(id = "redstoneToGlowstoneMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.redstone_to_glowstone_making_on")
        public static boolean redstoneToGlowstoneMakingOn = true;

        @ConfigEntry(id = "echoShardMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.echo_shard_making_on")
        public static boolean echoShardMakingOn = true;

        @ConfigEntry(id = "heartOfTheSeaMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.heart_of_the_sea_making_on")
        public static boolean heartOfTheSeaMakingOn = true;

        @ConfigEntry(id = "redstoneMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.redstone_making_on")
        public static boolean redstoneMakingOn = true;

        @ConfigEntry(id = "ae2CertusQuartzMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.ae2_certus_quartz_making_on")
        public static boolean ae2CertusQuartzMakingOn = true;

        @ConfigEntry(id = "moltenEndstoneMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.molten_endstone_making_on")
        public static boolean moltenEndstoneMakingOn = true;

        @ConfigEntry(id = "liquidQuartzMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.liquid_quartz_making_on")
        public static boolean liquidQuartzMakingOn = true;

        @ConfigEntry(id = "liquidRedstoneMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.liquid_redstone_making_on")
        public static boolean liquidRedstoneMakingOn = true;

        @ConfigEntry(id = "stringMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.string_making_on")
        public static boolean stringMakingOn = true;

        @ConfigEntry(id = "whiteWoolMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.white_wool_making_on")
        public static boolean whiteWoolMakingOn = true;

        @ConfigEntry(id = "blazerodMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.blazerod_making_on")
        public static boolean blazerodMakingOn = true;

        @ConfigEntry(id = "dioriteAssemblyMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.diorite_assembly_making_on")
        public static boolean dioriteAssemblyMakingOn = true;

        @ConfigEntry(id = "netheriteScrapMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.netherite_scrap_making_on")
        public static boolean netheriteScrapMakingOn = true;

        @ConfigEntry(id = "netheriteScrapV2MakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.netherite_scrap_v2_making_on")
        public static boolean netheriteScrapV2MakingOn = true;

        @ConfigEntry(id = "roseQuartzAssemblyMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.rosequartz_making_on")
        public static boolean roseQuartzAssemblyMakingOn = true;

        @ConfigEntry(id = "heartOfTheSeaFragmentMakingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.heart_of_the_sea_fragment_making_on")
        public static boolean heartOfTheSeaFragmentMakingOn = true;

    }

    @Category(id= "Create More Farmables fluid interactions", translation = "config.create_more_farmables.cmf_fluid_interactions")
    public static final class CreateMoreFarmables_fluid_interactions {
        @ConfigEntry(
                id = "toggleAllInteractions",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.toggle_all_interactions"
        )
        @Comment("Master switch for all custom fluid-to-water block conversions.")
        public static boolean toggleAllInteractions = true;

        // --- LIQUID QUARTZ ---
        @ConfigEntry(
                id = "liquidQuartzInteraction",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.liquid_quartz_interaction"
        )
        @Comment("Should Liquid Quartz turn water into a specific block?")
        public static boolean liquidQuartzInteraction = true;

        @ConfigEntry(
                id = "liquidQuartzConversionBlock",
                type = EntryType.STRING,
                translation = "config.create_more_farmables.liquid_quartz_conversion_block"
        )
        @Comment("The ID of the block created when Liquid Quartz touches water. Default: minecraft:diorite")
        public static String liquidQuartzConversionBlock = "minecraft:diorite";

        // --- LIQUID REDSTONE ---
        @ConfigEntry(
                id = "liquidRedstoneInteraction",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.liquid_redstone_interaction"
        )
        @Comment("Should Liquid Redstone turn water into a specific block?")
        public static boolean liquidRedstoneInteraction = true;

        @ConfigEntry(
                id = "liquidRedstoneConversionBlock",
                type = EntryType.STRING,
                translation = "config.create_more_farmables.liquid_redstone_conversion_block")
        @Comment("The ID of the block created when Liquid Redstone touches water. Default: minecraft:granite")
        public static String liquidRedstoneConversionBlock = "minecraft:granite";

        // --- MOLTEN ENDSTONE ---
        @ConfigEntry(
                id = "moltenEndstoneInteraction",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.molten_endstone_interaction"
        )
        @Comment("Should Molten Endstone turn water into a specific block?")
        public static boolean moltenEndstoneInteraction = true;

        @ConfigEntry(
                id = "moltenEndstoneConversionBlock",
                type = EntryType.STRING,
                translation = "config.create_more_farmables.molten_endstone_conversion_block"
        )
        @Comment("The ID of the block created when Molten Endstone touches water. Default: minecraft:end_stone")
        public static String moltenEndstoneConversionBlock = "minecraft:end_stone";

        @ConfigEntry(
                id = "allowFluidDyeing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.allow_fluid_dyeing"
        )
        @Comment("Should Dyed Waters dye items?")
        public static boolean allowFluidDyeing = true;

        @ConfigEntry(
                id = "allowBlockDyeing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.allow_block_dyeing"
        )
        @Comment("Should Dyed Waters dye Blocks?")
        public static boolean allowBlockDyeing = true;
    }

    @Category(id = "Dyed Water Making", translation = "config.create_more_farmables.dyed_water_making")
    public static final class Dyed_Water_Making {
        @ConfigEntry(id = "allDyedWaterMixingEnabled",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.all_dyed_water_mixing_enabled")
        @Comment("If false, disables all Dyed Water mixing recipes.\nDefault for all is true")
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
        @Comment("If false, disables all Dye Template filling recipes.\nDefault for all is true")
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
    @Category(id = "Create Recipes Toggles", translation = "config.create_more_farmables.create_recipes_toggles")
    public static final class CreateRecipes {
        @ConfigEntry(id = "createRecipesMasterToggle",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.create_recipes_master_toggles")
        @Comment("If False, Disable all recipes CMF adds to replace Create recipes\nDefault for all is true")
        public static boolean createRecipesMasterToggle= true;

        @ConfigEntry(id = "asurineCrushing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.asurine_crushing")
        public static boolean asurineCrushing = true;

        @ConfigEntry(id = "asurineRecycling",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.asurine_recycling")
        public static boolean asurineRecycling = true;

        @ConfigEntry(id = "crimsiteCrushing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.crimsite_crushing")
        public static boolean crimsiteCrushing = true;

        @ConfigEntry(id = "crimsiteRecycling",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.crimsite_recycling")
        public static boolean crimsiteRecycling = true;

        @ConfigEntry(id = "ochrumCrushing",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.ochrum_crushing")
        public static boolean ochrumCrushing = true;

        @ConfigEntry(id = "ochrumRecycling",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.ochrum_recycling")
        public static boolean ochrumRecycling = true;

        @ConfigEntry(id = "scoriaToLapisLazuli",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.scoria_to_lapis_lazuli")
        public static boolean scoriaToLapisLazuli = true;
    }

    @Category(id = "Create Sifting Recipe Toggles", translation = "config.create_more_farmables.create_sifting_recipe_toggles")
    public static final class CreateSiftingRecipes {
        @ConfigEntry(id = "createSiftingRecipesMasterToggle",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.create_sifting_recipes_master_toggles")
        @Comment("If False, Disable all recipes Create Sifting recipes CMF adds\nDefault for all is true")
        public static boolean createSiftingRecipesMasterToggle= true;

        @ConfigEntry(id = "advancedGravelSiftingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.advanced_gravel_sifting_on")
        public static boolean advancedGravelSiftingOn = true;

        @ConfigEntry(id = "advancedRedsandSiftingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.advanced_redsand_sifting_on")
        public static boolean advancedRedsandSiftingOn = true;

        @ConfigEntry(id = "advancedSandSiftingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.advanced_sand_sifting_on")
        public static boolean advancedSandSiftingOn = true;

        @ConfigEntry(id = "advancedSpongeSiftingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.advanced_sponge_sifting_on")
        public static boolean advancedSpongeSiftingOn = true;

    }

    @Category(id = "Carpet Dye Splashing", translation = "config.create_more_farmables.carpet_dye_splashing")
    public static final class CarpetDyeSplashing {
        @ConfigEntry(id = "allCarpetDyeSplashingEnabled",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.carpet_dye_splashing.all_enabled")
        @Comment("If false, disables all Carpet dye splashing recipes.\nDefault for all is true")
        public static boolean allCarpetDyeSplashingEnabled = true;

        @ConfigEntry(id = "whiteCarpetDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.carpet_dye_splashing.white")
        public static boolean whiteCarpetDyeSplashing = true;

        @ConfigEntry(id = "lightGrayCarpetDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.carpet_dye_splashing.light_gray")
        public static boolean lightGrayCarpetDyeSplashing = true;

        @ConfigEntry(id = "grayCarpetDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.carpet_dye_splashing.gray")
        public static boolean grayCarpetDyeSplashing = true;

        @ConfigEntry(id = "blackCarpetDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.carpet_dye_splashing.black")
        public static boolean blackCarpetDyeSplashing = true;

        @ConfigEntry(id = "brownCarpetDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.carpet_dye_splashing.brown")
        public static boolean brownCarpetDyeSplashing = true;

        @ConfigEntry(id = "redCarpetDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.carpet_dye_splashing.red")
        public static boolean redCarpetDyeSplashing = true;

        @ConfigEntry(id = "orangeCarpetDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.carpet_dye_splashing.orange")
        public static boolean orangeCarpetDyeSplashing = true;

        @ConfigEntry(id = "yellowCarpetDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.carpet_dye_splashing.yellow")
        public static boolean yellowCarpetDyeSplashing = true;

        @ConfigEntry(id = "limeCarpetDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.carpet_dye_splashing.lime")
        public static boolean limeCarpetDyeSplashing = true;

        @ConfigEntry(id = "greenCarpetDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.carpet_dye_splashing.green")
        public static boolean greenCarpetDyeSplashing = true;

        @ConfigEntry(id = "cyanCarpetDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.carpet_dye_splashing.cyan")
        public static boolean cyanCarpetDyeSplashing = true;

        @ConfigEntry(id = "lightBlueCarpetDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.carpet_dye_splashing.light_blue")
        public static boolean lightBlueCarpetDyeSplashing = true;

        @ConfigEntry(id = "blueCarpetDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.carpet_dye_splashing.blue")
        public static boolean blueCarpetDyeSplashing = true;

        @ConfigEntry(id = "purpleCarpetDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.carpet_dye_splashing.purple")
        public static boolean purpleCarpetDyeSplashing = true;

        @ConfigEntry(id = "magentaCarpetDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.carpet_dye_splashing.magenta")
        public static boolean magentaCarpetDyeSplashing = true;

        @ConfigEntry(id = "pinkCarpetDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.carpet_dye_splashing.pink")
        public static boolean pinkCarpetDyeSplashing = true;
    }

    @Category(id = "Bed Dye Splashing", translation = "config.create_more_farmables.bed_dye_splashing")
    public static final class BedDyeSplashing {
        @ConfigEntry(id = "allBedDyeSplashingEnabled",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.bed_dye_splashing.all_enabled")
        @Comment("If false, disables all Bed dye splashing recipes.\nDefault for all is true")
        public static boolean allBedDyeSplashingEnabled = true;

        @ConfigEntry(id = "whiteBedDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.bed_dye_splashing.white")
        public static boolean whiteBedDyeSplashing = true;

        @ConfigEntry(id = "lightGrayBedDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.bed_dye_splashing.light_gray")
        public static boolean lightGrayBedDyeSplashing = true;

        @ConfigEntry(id = "grayBedDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.bed_dye_splashing.gray")
        public static boolean grayBedDyeSplashing = true;

        @ConfigEntry(id = "blackBedDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.bed_dye_splashing.black")
        public static boolean blackBedDyeSplashing = true;

        @ConfigEntry(id = "brownBedDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.bed_dye_splashing.brown")
        public static boolean brownBedDyeSplashing = true;

        @ConfigEntry(id = "redBedDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.bed_dye_splashing.red")
        public static boolean redBedDyeSplashing = true;

        @ConfigEntry(id = "orangeBedDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.bed_dye_splashing.orange")
        public static boolean orangeBedDyeSplashing = true;

        @ConfigEntry(id = "yellowBedDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.bed_dye_splashing.yellow")
        public static boolean yellowBedDyeSplashing = true;

        @ConfigEntry(id = "limeBedDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.bed_dye_splashing.lime")
        public static boolean limeBedDyeSplashing = true;

        @ConfigEntry(id = "greenBedDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.bed_dye_splashing.green")
        public static boolean greenBedDyeSplashing = true;

        @ConfigEntry(id = "cyanBedDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.bed_dye_splashing.cyan")
        public static boolean cyanBedDyeSplashing = true;

        @ConfigEntry(id = "lightBlueBedDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.bed_dye_splashing.light_blue")
        public static boolean lightBlueBedDyeSplashing = true;

        @ConfigEntry(id = "blueBedDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.bed_dye_splashing.blue")
        public static boolean blueBedDyeSplashing = true;

        @ConfigEntry(id = "purpleBedDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.bed_dye_splashing.purple")
        public static boolean purpleBedDyeSplashing = true;

        @ConfigEntry(id = "magentaBedDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.bed_dye_splashing.magenta")
        public static boolean magentaBedDyeSplashing = true;

        @ConfigEntry(id = "pinkBedDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.bed_dye_splashing.pink")
        public static boolean pinkBedDyeSplashing = true;
    }

    @Category(id = "StainedGlassPane Dye Splashing", translation = "config.create_more_farmables.stained_glass_pane_dye_splashing")
    public static final class StainedGlassPaneDyeSplashing {
        @ConfigEntry(id = "allStainedGlassPaneDyeSplashingEnabled",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.all_enabled")
        @Comment("If false, disables all StainedGlassPane dye splashing recipes.\nDefault for all is true")
        public static boolean allStainedGlassPaneDyeSplashingEnabled = true;

        @ConfigEntry(id = "whiteStainedGlassPaneDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.white")
        public static boolean whiteStainedGlassPaneDyeSplashing = true;

        @ConfigEntry(id = "lightGrayStainedGlassPaneDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.light_gray")
        public static boolean lightGrayStainedGlassPaneDyeSplashing = true;

        @ConfigEntry(id = "grayStainedGlassPaneDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.gray")
        public static boolean grayStainedGlassPaneDyeSplashing = true;

        @ConfigEntry(id = "blackStainedGlassPaneDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.black")
        public static boolean blackStainedGlassPaneDyeSplashing = true;

        @ConfigEntry(id = "brownStainedGlassPaneDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.brown")
        public static boolean brownStainedGlassPaneDyeSplashing = true;

        @ConfigEntry(id = "redStainedGlassPaneDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.red")
        public static boolean redStainedGlassPaneDyeSplashing = true;

        @ConfigEntry(id = "orangeStainedGlassPaneDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.orange")
        public static boolean orangeStainedGlassPaneDyeSplashing = true;

        @ConfigEntry(id = "yellowStainedGlassPaneDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.yellow")
        public static boolean yellowStainedGlassPaneDyeSplashing = true;

        @ConfigEntry(id = "limeStainedGlassPaneDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.lime")
        public static boolean limeStainedGlassPaneDyeSplashing = true;

        @ConfigEntry(id = "greenStainedGlassPaneDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.green")
        public static boolean greenStainedGlassPaneDyeSplashing = true;

        @ConfigEntry(id = "cyanStainedGlassPaneDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.cyan")
        public static boolean cyanStainedGlassPaneDyeSplashing = true;

        @ConfigEntry(id = "lightBlueStainedGlassPaneDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.light_blue")
        public static boolean lightBlueStainedGlassPaneDyeSplashing = true;

        @ConfigEntry(id = "blueStainedGlassPaneDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.blue")
        public static boolean blueStainedGlassPaneDyeSplashing = true;

        @ConfigEntry(id = "purpleStainedGlassPaneDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.purple")
        public static boolean purpleStainedGlassPaneDyeSplashing = true;

        @ConfigEntry(id = "magentaStainedGlassPaneDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.magenta")
        public static boolean magentaStainedGlassPaneDyeSplashing = true;

        @ConfigEntry(id = "pinkStainedGlassPaneDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_pane_dye_splashing.pink")
        public static boolean pinkStainedGlassPaneDyeSplashing = true;
    }

    @Category(id = "ConcretePowder Dye Splashing", translation = "config.create_more_farmables.concrete_powder_dye_splashing")
    public static final class ConcretePowderDyeSplashing {
        @ConfigEntry(id = "allConcretePowderDyeSplashingEnabled",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.all_enabled")
        @Comment("If false, disables all ConcretePowder dye splashing recipes.\nDefault for all is true")
        public static boolean allConcretePowderDyeSplashingEnabled = true;

        @ConfigEntry(id = "whiteConcretePowderDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.white")
        public static boolean whiteConcretePowderDyeSplashing = true;

        @ConfigEntry(id = "lightGrayConcretePowderDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.light_gray")
        public static boolean lightGrayConcretePowderDyeSplashing = true;

        @ConfigEntry(id = "grayConcretePowderDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.gray")
        public static boolean grayConcretePowderDyeSplashing = true;

        @ConfigEntry(id = "blackConcretePowderDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.black")
        public static boolean blackConcretePowderDyeSplashing = true;

        @ConfigEntry(id = "brownConcretePowderDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.brown")
        public static boolean brownConcretePowderDyeSplashing = true;

        @ConfigEntry(id = "redConcretePowderDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.red")
        public static boolean redConcretePowderDyeSplashing = true;

        @ConfigEntry(id = "orangeConcretePowderDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.orange")
        public static boolean orangeConcretePowderDyeSplashing = true;

        @ConfigEntry(id = "yellowConcretePowderDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.yellow")
        public static boolean yellowConcretePowderDyeSplashing = true;

        @ConfigEntry(id = "limeConcretePowderDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.lime")
        public static boolean limeConcretePowderDyeSplashing = true;

        @ConfigEntry(id = "greenConcretePowderDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.green")
        public static boolean greenConcretePowderDyeSplashing = true;

        @ConfigEntry(id = "cyanConcretePowderDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.cyan")
        public static boolean cyanConcretePowderDyeSplashing = true;

        @ConfigEntry(id = "lightBlueConcretePowderDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.light_blue")
        public static boolean lightBlueConcretePowderDyeSplashing = true;

        @ConfigEntry(id = "blueConcretePowderDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.blue")
        public static boolean blueConcretePowderDyeSplashing = true;

        @ConfigEntry(id = "purpleConcretePowderDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.purple")
        public static boolean purpleConcretePowderDyeSplashing = true;

        @ConfigEntry(id = "magentaConcretePowderDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.magenta")
        public static boolean magentaConcretePowderDyeSplashing = true;

        @ConfigEntry(id = "pinkConcretePowderDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_powder_dye_splashing.pink")
        public static boolean pinkConcretePowderDyeSplashing = true;
    }

    @Category(id = "StainedGlass Dye Splashing", translation = "config.create_more_farmables.stained_glass_dye_splashing")
    public static final class StainedGlassDyeSplashing {
        @ConfigEntry(id = "allStainedGlassDyeSplashingEnabled",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_dye_splashing.all_enabled")
        @Comment("If false, disables all StainedGlass dye splashing recipes.\nDefault for all is true")
        public static boolean allStainedGlassDyeSplashingEnabled = true;

        @ConfigEntry(id = "whiteStainedGlassDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_dye_splashing.white")
        public static boolean whiteStainedGlassDyeSplashing = true;

        @ConfigEntry(id = "lightGrayStainedGlassDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_dye_splashing.light_gray")
        public static boolean lightGrayStainedGlassDyeSplashing = true;

        @ConfigEntry(id = "grayStainedGlassDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_dye_splashing.gray")
        public static boolean grayStainedGlassDyeSplashing = true;

        @ConfigEntry(id = "blackStainedGlassDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_dye_splashing.black")
        public static boolean blackStainedGlassDyeSplashing = true;

        @ConfigEntry(id = "brownStainedGlassDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_dye_splashing.brown")
        public static boolean brownStainedGlassDyeSplashing = true;

        @ConfigEntry(id = "redStainedGlassDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_dye_splashing.red")
        public static boolean redStainedGlassDyeSplashing = true;

        @ConfigEntry(id = "orangeStainedGlassDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_dye_splashing.orange")
        public static boolean orangeStainedGlassDyeSplashing = true;

        @ConfigEntry(id = "yellowStainedGlassDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_dye_splashing.yellow")
        public static boolean yellowStainedGlassDyeSplashing = true;

        @ConfigEntry(id = "limeStainedGlassDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_dye_splashing.lime")
        public static boolean limeStainedGlassDyeSplashing = true;

        @ConfigEntry(id = "greenStainedGlassDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_dye_splashing.green")
        public static boolean greenStainedGlassDyeSplashing = true;

        @ConfigEntry(id = "cyanStainedGlassDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_dye_splashing.cyan")
        public static boolean cyanStainedGlassDyeSplashing = true;

        @ConfigEntry(id = "lightBlueStainedGlassDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_dye_splashing.light_blue")
        public static boolean lightBlueStainedGlassDyeSplashing = true;

        @ConfigEntry(id = "blueStainedGlassDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_dye_splashing.blue")
        public static boolean blueStainedGlassDyeSplashing = true;

        @ConfigEntry(id = "purpleStainedGlassDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_dye_splashing.purple")
        public static boolean purpleStainedGlassDyeSplashing = true;

        @ConfigEntry(id = "magentaStainedGlassDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_dye_splashing.magenta")
        public static boolean magentaStainedGlassDyeSplashing = true;

        @ConfigEntry(id = "pinkStainedGlassDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.stained_glass_dye_splashing.pink")
        public static boolean pinkStainedGlassDyeSplashing = true;
    }

    @Category(id = "Concrete Dye Splashing", translation = "config.create_more_farmables.concrete_dye_splashing")
    public static final class ConcreteDyeSplashing {
        @ConfigEntry(id = "allConcreteDyeSplashingEnabled",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_dye_splashing.all_enabled")
        @Comment("If false, disables all Concrete dye splashing recipes.\nDefault for all is true")
        public static boolean allConcreteDyeSplashingEnabled = true;

        @ConfigEntry(id = "whiteConcreteDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_dye_splashing.white")
        public static boolean whiteConcreteDyeSplashing = true;

        @ConfigEntry(id = "lightGrayConcreteDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_dye_splashing.light_gray")
        public static boolean lightGrayConcreteDyeSplashing = true;

        @ConfigEntry(id = "grayConcreteDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_dye_splashing.gray")
        public static boolean grayConcreteDyeSplashing = true;

        @ConfigEntry(id = "blackConcreteDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_dye_splashing.black")
        public static boolean blackConcreteDyeSplashing = true;

        @ConfigEntry(id = "brownConcreteDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_dye_splashing.brown")
        public static boolean brownConcreteDyeSplashing = true;

        @ConfigEntry(id = "redConcreteDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_dye_splashing.red")
        public static boolean redConcreteDyeSplashing = true;

        @ConfigEntry(id = "orangeConcreteDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_dye_splashing.orange")
        public static boolean orangeConcreteDyeSplashing = true;

        @ConfigEntry(id = "yellowConcreteDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_dye_splashing.yellow")
        public static boolean yellowConcreteDyeSplashing = true;

        @ConfigEntry(id = "limeConcreteDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_dye_splashing.lime")
        public static boolean limeConcreteDyeSplashing = true;

        @ConfigEntry(id = "greenConcreteDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_dye_splashing.green")
        public static boolean greenConcreteDyeSplashing = true;

        @ConfigEntry(id = "cyanConcreteDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_dye_splashing.cyan")
        public static boolean cyanConcreteDyeSplashing = true;

        @ConfigEntry(id = "lightBlueConcreteDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_dye_splashing.light_blue")
        public static boolean lightBlueConcreteDyeSplashing = true;

        @ConfigEntry(id = "blueConcreteDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_dye_splashing.blue")
        public static boolean blueConcreteDyeSplashing = true;

        @ConfigEntry(id = "purpleConcreteDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_dye_splashing.purple")
        public static boolean purpleConcreteDyeSplashing = true;

        @ConfigEntry(id = "magentaConcreteDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_dye_splashing.magenta")
        public static boolean magentaConcreteDyeSplashing = true;

        @ConfigEntry(id = "pinkConcreteDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.concrete_dye_splashing.pink")
        public static boolean pinkConcreteDyeSplashing = true;
    }

    @Category(id = "Terracotta Dye Splashing", translation = "config.create_more_farmables.terracotta_dye_splashing")
    public static final class TerracottaDyeSplashing {
        @ConfigEntry(id = "allTerracottaDyeSplashingEnabled",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.terracotta_dye_splashing.all_enabled")
        @Comment("If false, disables all Terracotta dye splashing recipes.\nDefault for all is true")
        public static boolean allTerracottaDyeSplashingEnabled = true;

        @ConfigEntry(id = "whiteTerracottaDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.terracotta_dye_splashing.white")
        public static boolean whiteTerracottaDyeSplashing = true;

        @ConfigEntry(id = "lightGrayTerracottaDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.terracotta_dye_splashing.light_gray")
        public static boolean lightGrayTerracottaDyeSplashing = true;

        @ConfigEntry(id = "grayTerracottaDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.terracotta_dye_splashing.gray")
        public static boolean grayTerracottaDyeSplashing = true;

        @ConfigEntry(id = "blackTerracottaDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.terracotta_dye_splashing.black")
        public static boolean blackTerracottaDyeSplashing = true;

        @ConfigEntry(id = "brownTerracottaDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.terracotta_dye_splashing.brown")
        public static boolean brownTerracottaDyeSplashing = true;

        @ConfigEntry(id = "redTerracottaDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.terracotta_dye_splashing.red")
        public static boolean redTerracottaDyeSplashing = true;

        @ConfigEntry(id = "orangeTerracottaDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.terracotta_dye_splashing.orange")
        public static boolean orangeTerracottaDyeSplashing = true;

        @ConfigEntry(id = "yellowTerracottaDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.terracotta_dye_splashing.yellow")
        public static boolean yellowTerracottaDyeSplashing = true;

        @ConfigEntry(id = "limeTerracottaDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.terracotta_dye_splashing.lime")
        public static boolean limeTerracottaDyeSplashing = true;

        @ConfigEntry(id = "greenTerracottaDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.terracotta_dye_splashing.green")
        public static boolean greenTerracottaDyeSplashing = true;

        @ConfigEntry(id = "cyanTerracottaDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.terracotta_dye_splashing.cyan")
        public static boolean cyanTerracottaDyeSplashing = true;

        @ConfigEntry(id = "lightBlueTerracottaDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.terracotta_dye_splashing.light_blue")
        public static boolean lightBlueTerracottaDyeSplashing = true;

        @ConfigEntry(id = "blueTerracottaDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.terracotta_dye_splashing.blue")
        public static boolean blueTerracottaDyeSplashing = true;

        @ConfigEntry(id = "purpleTerracottaDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.terracotta_dye_splashing.purple")
        public static boolean purpleTerracottaDyeSplashing = true;

        @ConfigEntry(id = "magentaTerracottaDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.terracotta_dye_splashing.magenta")
        public static boolean magentaTerracottaDyeSplashing = true;

        @ConfigEntry(id = "pinkTerracottaDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.terracotta_dye_splashing.pink")
        public static boolean pinkTerracottaDyeSplashing = true;
    }

    @Category(id = "Wool Dye Splashing", translation = "config.create_more_farmables.wool_dye_splashing")
    public static final class WoolDyeSplashing {
        @ConfigEntry(id = "allWoolDyeSplashingEnabled",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.wool_dye_splashing.all_enabled")
        @Comment("If false, disables all Wool dye splashing recipes.\nDefault for all is true")
        public static boolean allWoolDyeSplashingEnabled = true;

        @ConfigEntry(id = "whiteWoolDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.wool_dye_splashing.white")
        public static boolean whiteWoolDyeSplashing = true;

        @ConfigEntry(id = "lightGrayWoolDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.wool_dye_splashing.light_gray")
        public static boolean lightGrayWoolDyeSplashing = true;

        @ConfigEntry(id = "grayWoolDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.wool_dye_splashing.gray")
        public static boolean grayWoolDyeSplashing = true;

        @ConfigEntry(id = "blackWoolDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.wool_dye_splashing.black")
        public static boolean blackWoolDyeSplashing = true;

        @ConfigEntry(id = "brownWoolDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.wool_dye_splashing.brown")
        public static boolean brownWoolDyeSplashing = true;

        @ConfigEntry(id = "redWoolDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.wool_dye_splashing.red")
        public static boolean redWoolDyeSplashing = true;

        @ConfigEntry(id = "orangeWoolDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.wool_dye_splashing.orange")
        public static boolean orangeWoolDyeSplashing = true;

        @ConfigEntry(id = "yellowWoolDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.wool_dye_splashing.yellow")
        public static boolean yellowWoolDyeSplashing = true;

        @ConfigEntry(id = "limeWoolDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.wool_dye_splashing.lime")
        public static boolean limeWoolDyeSplashing = true;

        @ConfigEntry(id = "greenWoolDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.wool_dye_splashing.green")
        public static boolean greenWoolDyeSplashing = true;

        @ConfigEntry(id = "cyanWoolDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.wool_dye_splashing.cyan")
        public static boolean cyanWoolDyeSplashing = true;

        @ConfigEntry(id = "lightBlueWoolDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.wool_dye_splashing.light_blue")
        public static boolean lightBlueWoolDyeSplashing = true;

        @ConfigEntry(id = "blueWoolDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.wool_dye_splashing.blue")
        public static boolean blueWoolDyeSplashing = true;

        @ConfigEntry(id = "purpleWoolDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.wool_dye_splashing.purple")
        public static boolean purpleWoolDyeSplashing = true;

        @ConfigEntry(id = "magentaWoolDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.wool_dye_splashing.magenta")
        public static boolean magentaWoolDyeSplashing = true;

        @ConfigEntry(id = "pinkWoolDyeSplashingOn",
                type = EntryType.BOOLEAN,
                translation = "config.create_more_farmables.wool_dye_splashing.pink")
        public static boolean pinkWoolDyeSplashing = true;
    }

    public static void init() {
    }
}