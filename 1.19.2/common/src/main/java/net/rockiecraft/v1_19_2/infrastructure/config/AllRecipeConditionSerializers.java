package net.rockiecraft.v1_20_1.infrastructure.config;

import net.minecraft.resources.ResourceLocation;
import net.rockiecraft.v1_20_1.foundation.recipe.condition.ConfigRecipeCondition;
import net.rockiecraft.v1_20_1.foundation.recipe.condition.IRecipeConditionSerializer;

import java.util.*;
import java.util.function.Supplier;

public class AllRecipeConditionSerializers {

    private static final List<IRecipeConditionSerializer<?>> SERIALIZERS = new ArrayList<>();
    public static final Map<String, Supplier<Boolean>> DYED_WATER_MAP = new HashMap<>();
    public static final Map<String, Supplier<Boolean>> DYE_TEMPLATE_FILLING_MAP = new HashMap<>();
    public static final Map<String, Supplier<Boolean>> CREATEMOREFARMABLES_ITEMS_MAP = new HashMap<>();
    public static final Map<String, Supplier<Boolean>> CREATEMOREFARMABLES_RECIPES_MAP  = new HashMap<>();
    public static final Map<String, Supplier<Boolean>> CREATE_RECIPES_MAP  = new HashMap<>();
    public static final Map<String, Supplier<Boolean>> CREATE_SIFTING_RECIPES_MAP  = new HashMap<>();
    public static final Map<String, Supplier<Boolean>> CARPET_DYE_SPLASHING_MAP = new HashMap<>();
    public static final Map<String, Supplier<Boolean>> BED_DYE_SPLASHING_MAP = new HashMap<>();
    public static final Map<String, Supplier<Boolean>> STAINED_GLASS_PANE_DYE_SPLASHING_MAP = new HashMap<>();
    public static final Map<String, Supplier<Boolean>> CONCRETE_POWDER_DYE_SPLASHING_MAP = new HashMap<>();
    public static final Map<String, Supplier<Boolean>> STAINED_GLASS_DYE_SPLASHING_MAP = new HashMap<>();
    public static final Map<String, Supplier<Boolean>> CONCRETE_DYE_SPLASHING_MAP = new HashMap<>();
    public static final Map<String, Supplier<Boolean>> TERRACOTTA_DYE_SPLASHING_MAP = new HashMap<>();
    public static final Map<String, Supplier<Boolean>> WOOL_DYE_SPLASHING_MAP = new HashMap<>();

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> DYED_WATER_MIXING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "dyed_water_mixing"),
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.allDyedWaterMixingEnabled,
                    DYED_WATER_MAP));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> DYE_TEMPLATE_FILLING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "dye_template_filling"),
                    () -> CreateMoreFarmablesConfig.Dye_Template_Filling.allDyeFillingEnabled,
                    DYE_TEMPLATE_FILLING_MAP));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> CREATE_MORE_FARMABLES_ITEMS = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "item_recipes"),
                    () -> CreateMoreFarmablesConfig.CreateMoreFarmables.cmfItemMasterToggleOn,
                    CREATEMOREFARMABLES_ITEMS_MAP));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> CREATE_MORE_FARMABLES_RECIPES = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "automation_easier_recipes"),
                    () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.cmfRecipesToggle,
                    CREATEMOREFARMABLES_RECIPES_MAP));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> CREATE_RECIPES_TOGGLES = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "create_replacement_recipes"),
                    () -> CreateMoreFarmablesConfig.CreateRecipes.createRecipesMasterToggle,
                    CREATE_RECIPES_MAP));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> CREATE_SIFTING_RECIPES_TOGGLES = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "create_sifting_recipes"),
                    () -> CreateMoreFarmablesConfig.CreateSiftingRecipes.createSiftingRecipesMasterToggle,
                    CREATE_SIFTING_RECIPES_MAP));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> CARPET_DYE_SPLASHING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "carpet_dye_splashing"),
                    () -> CreateMoreFarmablesConfig.CarpetDyeSplashing.allCarpetDyeSplashingEnabled,
                    CARPET_DYE_SPLASHING_MAP));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> BED_DYE_SPLASHING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "bed_dye_splashing"),
                    () -> CreateMoreFarmablesConfig.BedDyeSplashing.allBedDyeSplashingEnabled,
                    BED_DYE_SPLASHING_MAP));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> STAINED_GLASS_PANE_DYE_SPLASHING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "stained_glass_pane_dye_splashing"),
                    () -> CreateMoreFarmablesConfig.StainedGlassPaneDyeSplashing.allStainedGlassPaneDyeSplashingEnabled,
                    STAINED_GLASS_PANE_DYE_SPLASHING_MAP));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> CONCRETE_POWDER_DYE_SPLASHING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "concrete_powder_dye_splashing"),
                    () -> CreateMoreFarmablesConfig.ConcretePowderDyeSplashing.allConcretePowderDyeSplashingEnabled,
                    CONCRETE_POWDER_DYE_SPLASHING_MAP));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> STAINED_GLASS_DYE_SPLASHING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "stained_glass_dye_splashing"),
                    () -> CreateMoreFarmablesConfig.StainedGlassDyeSplashing.allStainedGlassDyeSplashingEnabled,
                    STAINED_GLASS_DYE_SPLASHING_MAP));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> CONCRETE_DYE_SPLASHING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "concrete_dye_splashing"),
                    () -> CreateMoreFarmablesConfig.ConcreteDyeSplashing.allConcreteDyeSplashingEnabled,
                    CONCRETE_DYE_SPLASHING_MAP));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> TERRACOTTA_DYE_SPLASHING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "terracotta_dye_splashing"),
                    () -> CreateMoreFarmablesConfig.TerracottaDyeSplashing.allTerracottaDyeSplashingEnabled,
                    TERRACOTTA_DYE_SPLASHING_MAP));

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> WOOL_DYE_SPLASHING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "wool_dye_splashing"),
                    () -> CreateMoreFarmablesConfig.WoolDyeSplashing.allWoolDyeSplashingEnabled,
                    WOOL_DYE_SPLASHING_MAP));

    static {
        // config condition {"type": "create_more_farmables:create_sifting_recipes", "config": ""}
        // Moved here from CREATE_RECIPES_MAP - was silently disabling all advanced sifting recipes.
        CREATE_SIFTING_RECIPES_MAP.put("advancedGravelSiftingOn", () -> CreateMoreFarmablesConfig.CreateSiftingRecipes.advancedGravelSiftingOn);
        CREATE_SIFTING_RECIPES_MAP.put("advancedRedsandSiftingOn", () -> CreateMoreFarmablesConfig.CreateSiftingRecipes.advancedRedsandSiftingOn);
        CREATE_SIFTING_RECIPES_MAP.put("advancedSandSiftingOn", () -> CreateMoreFarmablesConfig.CreateSiftingRecipes.advancedSandSiftingOn);
        CREATE_SIFTING_RECIPES_MAP.put("advancedSpongeSiftingOn", () -> CreateMoreFarmablesConfig.CreateSiftingRecipes.advancedSpongeSiftingOn);

        // config condition {"type": "create_more_farmables:create_replacement_recipes", "config": ""}
        CREATE_RECIPES_MAP.put("asurineCrushing", () -> CreateMoreFarmablesConfig.CreateRecipes.asurineCrushing);
        CREATE_RECIPES_MAP.put("asurineRecycling", () -> CreateMoreFarmablesConfig.CreateRecipes.asurineRecycling);
        CREATE_RECIPES_MAP.put("crimsiteCrushing", () -> CreateMoreFarmablesConfig.CreateRecipes.crimsiteCrushing);
        CREATE_RECIPES_MAP.put("crimsiteRecycling", () -> CreateMoreFarmablesConfig.CreateRecipes.crimsiteRecycling);
        CREATE_RECIPES_MAP.put("ochrumCrushing", () -> CreateMoreFarmablesConfig.CreateRecipes.ochrumCrushing);
        CREATE_RECIPES_MAP.put("ochrumRecycling", () -> CreateMoreFarmablesConfig.CreateRecipes.ochrumRecycling);
        CREATE_RECIPES_MAP.put("scoriaToLapisLazuli", () -> CreateMoreFarmablesConfig.CreateRecipes.scoriaToLapisLazuli);

        // config condition {"type": "create_more_farmables:automation_easier_recipes", "config": ""}
        // compacting
        CREATEMOREFARMABLES_RECIPES_MAP.put("shulkerShellMakingOn",
                () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.shulkerShellMakingOn);

        // crushing

        // cutting

        // haunting
        CREATEMOREFARMABLES_RECIPES_MAP.put("netherrackMakingOn",
                () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.netherrackMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("andesiteNetherrackMakingOn",
                () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.andesiteNetherrackMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("redstoneToGlowstoneMakingOn",
                () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.redstoneToGlowstoneMakingOn);

        // mixing
        CREATEMOREFARMABLES_RECIPES_MAP.put("echoShardMakingOn",
                () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.echoShardMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("nautilusShellMakingOn",
                () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.nautilusShellMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("heartOfTheSeaMakingOn",
                () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.heartOfTheSeaMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("redstoneMakingOn",
                () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.redstoneMakingOn);

        // compacting
        CREATEMOREFARMABLES_RECIPES_MAP.put("dirtMakingOn",
                () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.dirtMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("endstoneMakingOn",
                () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.endstoneMakingOn);

        // filling
        CREATEMOREFARMABLES_RECIPES_MAP.put("magmablockMakingOn",
                () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.magmablockMakingOn);

        // mixing/create minerals
        CREATEMOREFARMABLES_RECIPES_MAP.put("asurineMakingOn",
                () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.asurineMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("crimsiteMakingOn",
                () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.crimsiteMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("ochrumMakingOn",
                () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.ochrumMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("veridiumMakingOn",
                () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.veridiumMakingOn);

        CREATEMOREFARMABLES_RECIPES_MAP.put("ae2CertusQuartzMakingOn",
                () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.ae2CertusQuartzMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("calciteMakingOn",
                () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.calciteMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("dioriteMakingOn",
                () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.dioriteMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("redsandMakingOn",
                () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.redsandMakingOn);

        CREATEMOREFARMABLES_RECIPES_MAP.put("moltenEndstoneMakingOn",
                () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.moltenEndstoneMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("liquidQuartzMakingOn",
                () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.liquidQuartzMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("liquidRedstoneMakingOn",
                () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.liquidRedstoneMakingOn);

        CREATEMOREFARMABLES_RECIPES_MAP.put("stringMakingOn",
                () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.stringMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("whiteWoolMakingOn",
                () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.whiteWoolMakingOn);

        // sequenced assembly
        CREATEMOREFARMABLES_RECIPES_MAP.put("blazerodMakingOn",
                () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.blazerodMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("dioriteAssemblyMakingOn",
                () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.dioriteAssemblyMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("netheriteScrapMakingOn",
                () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.netheriteScrapMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("netheriteScrapV2MakingOn",
                () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.netheriteScrapV2MakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("heartOfTheSeaFragmentMakingOn",
                () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.heartOfTheSeaFragmentMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("roseQuartzAssemblyMakingOn",
                () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.roseQuartzAssemblyMakingOn);

        // config condition {"type": "create_more_farmables:automation_easier_recipes", "config": ""}

        // config condition {"type": "create_more_farmables:item_recipes", "config": ""}
        CREATEMOREFARMABLES_ITEMS_MAP.put("echoShardDustOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables.echoShardDustOn);
        CREATEMOREFARMABLES_ITEMS_MAP.put("echoShardDustCrushingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables.echoShardDustCrushingOn);
        CREATEMOREFARMABLES_ITEMS_MAP.put("enderpearlDustOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables.enderpearlDustOn);
        CREATEMOREFARMABLES_ITEMS_MAP.put("netheriteDustOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables.netheriteDustOn);
        CREATEMOREFARMABLES_ITEMS_MAP.put("shulkerShellFragmentOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables.shulkerShellFragmentOn);
        CREATEMOREFARMABLES_ITEMS_MAP.put("shulkerCompoundOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables.shulkerCompoundOn);
        CREATEMOREFARMABLES_ITEMS_MAP.put("heartOfTheSeaFragmentOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables.heartOfTheSeaFragmentOn);
        CREATEMOREFARMABLES_ITEMS_MAP.put("nautilusShellFragmentOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables.nautilusShellFragmentOn);
        CREATEMOREFARMABLES_ITEMS_MAP.put("dyeTemplateOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables.dyeTemplateOn);
        CREATEMOREFARMABLES_ITEMS_MAP.put("woodStringWoolOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables.woodStringWoolOn);
        CREATEMOREFARMABLES_ITEMS_MAP.put("woodStringOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables.woodStringOn);

        // config condition {"type": "create_more_farmables:dyed_water_mixing", "config": ""}
        DYED_WATER_MAP.put("white", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.whiteDyedWaterMaking);
        DYED_WATER_MAP.put("light_gray", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.lightGrayDyedWaterMaking);
        DYED_WATER_MAP.put("gray", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.grayDyedWaterMaking);
        DYED_WATER_MAP.put("black", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.blackDyedWaterMaking);
        DYED_WATER_MAP.put("brown", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.brownDyedWaterMaking);
        DYED_WATER_MAP.put("red", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.redDyedWaterMaking);
        DYED_WATER_MAP.put("orange", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.orangeDyedWaterMaking);
        DYED_WATER_MAP.put("yellow", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.yellowDyedWaterMaking);
        DYED_WATER_MAP.put("lime", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.limeDyedWaterMaking);
        DYED_WATER_MAP.put("green", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.greenDyedWaterMaking);
        DYED_WATER_MAP.put("cyan", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.cyanDyedWaterMaking);
        DYED_WATER_MAP.put("light_blue", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.lightBlueDyedWaterMaking);
        DYED_WATER_MAP.put("blue", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.blueDyedWaterMaking);
        DYED_WATER_MAP.put("purple", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.purpleDyedWaterMaking);
        DYED_WATER_MAP.put("magenta", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.magentaDyedWaterMaking);
        DYED_WATER_MAP.put("pink", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.pinkDyedWaterMaking);

        // config condition {"type": "create_more_farmables:dye_template_filling", "config": ""}
        DYE_TEMPLATE_FILLING_MAP.put("white", () -> CreateMoreFarmablesConfig.Dye_Template_Filling.whiteDyeFilling);
        DYE_TEMPLATE_FILLING_MAP.put("light_gray", () -> CreateMoreFarmablesConfig.Dye_Template_Filling.lightGrayDyeFilling);
        DYE_TEMPLATE_FILLING_MAP.put("gray", () -> CreateMoreFarmablesConfig.Dye_Template_Filling.grayDyeFilling);
        DYE_TEMPLATE_FILLING_MAP.put("black", () -> CreateMoreFarmablesConfig.Dye_Template_Filling.blackDyeFilling);
        DYE_TEMPLATE_FILLING_MAP.put("brown", () -> CreateMoreFarmablesConfig.Dye_Template_Filling.brownDyeFilling);
        DYE_TEMPLATE_FILLING_MAP.put("red", () -> CreateMoreFarmablesConfig.Dye_Template_Filling.redDyeFilling);
        DYE_TEMPLATE_FILLING_MAP.put("orange", () -> CreateMoreFarmablesConfig.Dye_Template_Filling.orangeDyeFilling);
        DYE_TEMPLATE_FILLING_MAP.put("yellow", () -> CreateMoreFarmablesConfig.Dye_Template_Filling.yellowDyeFilling);
        DYE_TEMPLATE_FILLING_MAP.put("lime", () -> CreateMoreFarmablesConfig.Dye_Template_Filling.limeDyeFilling);
        DYE_TEMPLATE_FILLING_MAP.put("green", () -> CreateMoreFarmablesConfig.Dye_Template_Filling.greenDyeFilling);
        DYE_TEMPLATE_FILLING_MAP.put("cyan", () -> CreateMoreFarmablesConfig.Dye_Template_Filling.cyanDyeFilling);
        DYE_TEMPLATE_FILLING_MAP.put("light_blue", () -> CreateMoreFarmablesConfig.Dye_Template_Filling.lightBlueDyeFilling);
        DYE_TEMPLATE_FILLING_MAP.put("blue", () -> CreateMoreFarmablesConfig.Dye_Template_Filling.blueDyeFilling);
        DYE_TEMPLATE_FILLING_MAP.put("purple", () -> CreateMoreFarmablesConfig.Dye_Template_Filling.purpleDyeFilling);
        DYE_TEMPLATE_FILLING_MAP.put("magenta", () -> CreateMoreFarmablesConfig.Dye_Template_Filling.magentaDyeFilling);
        DYE_TEMPLATE_FILLING_MAP.put("pink", () -> CreateMoreFarmablesConfig.Dye_Template_Filling.pinkDyeFilling);

        // config condition {"type": "create_more_farmables:carpet_dye_splashing", "config": ""}
        CARPET_DYE_SPLASHING_MAP.put("white", () -> CreateMoreFarmablesConfig.CarpetDyeSplashing.whiteCarpetDyeSplashing);
        CARPET_DYE_SPLASHING_MAP.put("light_gray", () -> CreateMoreFarmablesConfig.CarpetDyeSplashing.lightGrayCarpetDyeSplashing);
        CARPET_DYE_SPLASHING_MAP.put("gray", () -> CreateMoreFarmablesConfig.CarpetDyeSplashing.grayCarpetDyeSplashing);
        CARPET_DYE_SPLASHING_MAP.put("black", () -> CreateMoreFarmablesConfig.CarpetDyeSplashing.blackCarpetDyeSplashing);
        CARPET_DYE_SPLASHING_MAP.put("brown", () -> CreateMoreFarmablesConfig.CarpetDyeSplashing.brownCarpetDyeSplashing);
        CARPET_DYE_SPLASHING_MAP.put("red", () -> CreateMoreFarmablesConfig.CarpetDyeSplashing.redCarpetDyeSplashing);
        CARPET_DYE_SPLASHING_MAP.put("orange", () -> CreateMoreFarmablesConfig.CarpetDyeSplashing.orangeCarpetDyeSplashing);
        CARPET_DYE_SPLASHING_MAP.put("yellow", () -> CreateMoreFarmablesConfig.CarpetDyeSplashing.yellowCarpetDyeSplashing);
        CARPET_DYE_SPLASHING_MAP.put("lime", () -> CreateMoreFarmablesConfig.CarpetDyeSplashing.limeCarpetDyeSplashing);
        CARPET_DYE_SPLASHING_MAP.put("green", () -> CreateMoreFarmablesConfig.CarpetDyeSplashing.greenCarpetDyeSplashing);
        CARPET_DYE_SPLASHING_MAP.put("cyan", () -> CreateMoreFarmablesConfig.CarpetDyeSplashing.cyanCarpetDyeSplashing);
        CARPET_DYE_SPLASHING_MAP.put("light_blue", () -> CreateMoreFarmablesConfig.CarpetDyeSplashing.lightBlueCarpetDyeSplashing);
        CARPET_DYE_SPLASHING_MAP.put("blue", () -> CreateMoreFarmablesConfig.CarpetDyeSplashing.blueCarpetDyeSplashing);
        CARPET_DYE_SPLASHING_MAP.put("purple", () -> CreateMoreFarmablesConfig.CarpetDyeSplashing.purpleCarpetDyeSplashing);
        CARPET_DYE_SPLASHING_MAP.put("magenta", () -> CreateMoreFarmablesConfig.CarpetDyeSplashing.magentaCarpetDyeSplashing);
        CARPET_DYE_SPLASHING_MAP.put("pink", () -> CreateMoreFarmablesConfig.CarpetDyeSplashing.pinkCarpetDyeSplashing);

        // config condition {"type": "create_more_farmables:bed_dye_splashing", "config": ""}
        BED_DYE_SPLASHING_MAP.put("white", () -> CreateMoreFarmablesConfig.BedDyeSplashing.whiteBedDyeSplashing);
        BED_DYE_SPLASHING_MAP.put("light_gray", () -> CreateMoreFarmablesConfig.BedDyeSplashing.lightGrayBedDyeSplashing);
        BED_DYE_SPLASHING_MAP.put("gray", () -> CreateMoreFarmablesConfig.BedDyeSplashing.grayBedDyeSplashing);
        BED_DYE_SPLASHING_MAP.put("black", () -> CreateMoreFarmablesConfig.BedDyeSplashing.blackBedDyeSplashing);
        BED_DYE_SPLASHING_MAP.put("brown", () -> CreateMoreFarmablesConfig.BedDyeSplashing.brownBedDyeSplashing);
        BED_DYE_SPLASHING_MAP.put("red", () -> CreateMoreFarmablesConfig.BedDyeSplashing.redBedDyeSplashing);
        BED_DYE_SPLASHING_MAP.put("orange", () -> CreateMoreFarmablesConfig.BedDyeSplashing.orangeBedDyeSplashing);
        BED_DYE_SPLASHING_MAP.put("yellow", () -> CreateMoreFarmablesConfig.BedDyeSplashing.yellowBedDyeSplashing);
        BED_DYE_SPLASHING_MAP.put("lime", () -> CreateMoreFarmablesConfig.BedDyeSplashing.limeBedDyeSplashing);
        BED_DYE_SPLASHING_MAP.put("green", () -> CreateMoreFarmablesConfig.BedDyeSplashing.greenBedDyeSplashing);
        BED_DYE_SPLASHING_MAP.put("cyan", () -> CreateMoreFarmablesConfig.BedDyeSplashing.cyanBedDyeSplashing);
        BED_DYE_SPLASHING_MAP.put("light_blue", () -> CreateMoreFarmablesConfig.BedDyeSplashing.lightBlueBedDyeSplashing);
        BED_DYE_SPLASHING_MAP.put("blue", () -> CreateMoreFarmablesConfig.BedDyeSplashing.blueBedDyeSplashing);
        BED_DYE_SPLASHING_MAP.put("purple", () -> CreateMoreFarmablesConfig.BedDyeSplashing.purpleBedDyeSplashing);
        BED_DYE_SPLASHING_MAP.put("magenta", () -> CreateMoreFarmablesConfig.BedDyeSplashing.magentaBedDyeSplashing);
        BED_DYE_SPLASHING_MAP.put("pink", () -> CreateMoreFarmablesConfig.BedDyeSplashing.pinkBedDyeSplashing);

        // config condition {"type": "create_more_farmables:stained_glass_pane_dye_splashing", "config": ""}
        STAINED_GLASS_PANE_DYE_SPLASHING_MAP.put("white", () -> CreateMoreFarmablesConfig.StainedGlassPaneDyeSplashing.whiteStainedGlassPaneDyeSplashing);
        STAINED_GLASS_PANE_DYE_SPLASHING_MAP.put("light_gray", () -> CreateMoreFarmablesConfig.StainedGlassPaneDyeSplashing.lightGrayStainedGlassPaneDyeSplashing);
        STAINED_GLASS_PANE_DYE_SPLASHING_MAP.put("gray", () -> CreateMoreFarmablesConfig.StainedGlassPaneDyeSplashing.grayStainedGlassPaneDyeSplashing);
        STAINED_GLASS_PANE_DYE_SPLASHING_MAP.put("black", () -> CreateMoreFarmablesConfig.StainedGlassPaneDyeSplashing.blackStainedGlassPaneDyeSplashing);
        STAINED_GLASS_PANE_DYE_SPLASHING_MAP.put("brown", () -> CreateMoreFarmablesConfig.StainedGlassPaneDyeSplashing.brownStainedGlassPaneDyeSplashing);
        STAINED_GLASS_PANE_DYE_SPLASHING_MAP.put("red", () -> CreateMoreFarmablesConfig.StainedGlassPaneDyeSplashing.redStainedGlassPaneDyeSplashing);
        STAINED_GLASS_PANE_DYE_SPLASHING_MAP.put("orange", () -> CreateMoreFarmablesConfig.StainedGlassPaneDyeSplashing.orangeStainedGlassPaneDyeSplashing);
        STAINED_GLASS_PANE_DYE_SPLASHING_MAP.put("yellow", () -> CreateMoreFarmablesConfig.StainedGlassPaneDyeSplashing.yellowStainedGlassPaneDyeSplashing);
        STAINED_GLASS_PANE_DYE_SPLASHING_MAP.put("lime", () -> CreateMoreFarmablesConfig.StainedGlassPaneDyeSplashing.limeStainedGlassPaneDyeSplashing);
        STAINED_GLASS_PANE_DYE_SPLASHING_MAP.put("green", () -> CreateMoreFarmablesConfig.StainedGlassPaneDyeSplashing.greenStainedGlassPaneDyeSplashing);
        STAINED_GLASS_PANE_DYE_SPLASHING_MAP.put("cyan", () -> CreateMoreFarmablesConfig.StainedGlassPaneDyeSplashing.cyanStainedGlassPaneDyeSplashing);
        STAINED_GLASS_PANE_DYE_SPLASHING_MAP.put("light_blue", () -> CreateMoreFarmablesConfig.StainedGlassPaneDyeSplashing.lightBlueStainedGlassPaneDyeSplashing);
        STAINED_GLASS_PANE_DYE_SPLASHING_MAP.put("blue", () -> CreateMoreFarmablesConfig.StainedGlassPaneDyeSplashing.blueStainedGlassPaneDyeSplashing);
        STAINED_GLASS_PANE_DYE_SPLASHING_MAP.put("purple", () -> CreateMoreFarmablesConfig.StainedGlassPaneDyeSplashing.purpleStainedGlassPaneDyeSplashing);
        STAINED_GLASS_PANE_DYE_SPLASHING_MAP.put("magenta", () -> CreateMoreFarmablesConfig.StainedGlassPaneDyeSplashing.magentaStainedGlassPaneDyeSplashing);
        STAINED_GLASS_PANE_DYE_SPLASHING_MAP.put("pink", () -> CreateMoreFarmablesConfig.StainedGlassPaneDyeSplashing.pinkStainedGlassPaneDyeSplashing);

        // config condition {"type": "create_more_farmables:concrete_powder_dye_splashing", "config": ""}
        CONCRETE_POWDER_DYE_SPLASHING_MAP.put("white", () -> CreateMoreFarmablesConfig.ConcretePowderDyeSplashing.whiteConcretePowderDyeSplashing);
        CONCRETE_POWDER_DYE_SPLASHING_MAP.put("light_gray", () -> CreateMoreFarmablesConfig.ConcretePowderDyeSplashing.lightGrayConcretePowderDyeSplashing);
        CONCRETE_POWDER_DYE_SPLASHING_MAP.put("gray", () -> CreateMoreFarmablesConfig.ConcretePowderDyeSplashing.grayConcretePowderDyeSplashing);
        CONCRETE_POWDER_DYE_SPLASHING_MAP.put("black", () -> CreateMoreFarmablesConfig.ConcretePowderDyeSplashing.blackConcretePowderDyeSplashing);
        CONCRETE_POWDER_DYE_SPLASHING_MAP.put("brown", () -> CreateMoreFarmablesConfig.ConcretePowderDyeSplashing.brownConcretePowderDyeSplashing);
        CONCRETE_POWDER_DYE_SPLASHING_MAP.put("red", () -> CreateMoreFarmablesConfig.ConcretePowderDyeSplashing.redConcretePowderDyeSplashing);
        CONCRETE_POWDER_DYE_SPLASHING_MAP.put("orange", () -> CreateMoreFarmablesConfig.ConcretePowderDyeSplashing.orangeConcretePowderDyeSplashing);
        CONCRETE_POWDER_DYE_SPLASHING_MAP.put("yellow", () -> CreateMoreFarmablesConfig.ConcretePowderDyeSplashing.yellowConcretePowderDyeSplashing);
        CONCRETE_POWDER_DYE_SPLASHING_MAP.put("lime", () -> CreateMoreFarmablesConfig.ConcretePowderDyeSplashing.limeConcretePowderDyeSplashing);
        CONCRETE_POWDER_DYE_SPLASHING_MAP.put("green", () -> CreateMoreFarmablesConfig.ConcretePowderDyeSplashing.greenConcretePowderDyeSplashing);
        CONCRETE_POWDER_DYE_SPLASHING_MAP.put("cyan", () -> CreateMoreFarmablesConfig.ConcretePowderDyeSplashing.cyanConcretePowderDyeSplashing);
        CONCRETE_POWDER_DYE_SPLASHING_MAP.put("light_blue", () -> CreateMoreFarmablesConfig.ConcretePowderDyeSplashing.lightBlueConcretePowderDyeSplashing);
        CONCRETE_POWDER_DYE_SPLASHING_MAP.put("blue", () -> CreateMoreFarmablesConfig.ConcretePowderDyeSplashing.blueConcretePowderDyeSplashing);
        CONCRETE_POWDER_DYE_SPLASHING_MAP.put("purple", () -> CreateMoreFarmablesConfig.ConcretePowderDyeSplashing.purpleConcretePowderDyeSplashing);
        CONCRETE_POWDER_DYE_SPLASHING_MAP.put("magenta", () -> CreateMoreFarmablesConfig.ConcretePowderDyeSplashing.magentaConcretePowderDyeSplashing);
        CONCRETE_POWDER_DYE_SPLASHING_MAP.put("pink", () -> CreateMoreFarmablesConfig.ConcretePowderDyeSplashing.pinkConcretePowderDyeSplashing);

        // config condition {"type": "create_more_farmables:stained_glass_dye_splashing", "config": ""}
        STAINED_GLASS_DYE_SPLASHING_MAP.put("white", () -> CreateMoreFarmablesConfig.StainedGlassDyeSplashing.whiteStainedGlassDyeSplashing);
        STAINED_GLASS_DYE_SPLASHING_MAP.put("light_gray", () -> CreateMoreFarmablesConfig.StainedGlassDyeSplashing.lightGrayStainedGlassDyeSplashing);
        STAINED_GLASS_DYE_SPLASHING_MAP.put("gray", () -> CreateMoreFarmablesConfig.StainedGlassDyeSplashing.grayStainedGlassDyeSplashing);
        STAINED_GLASS_DYE_SPLASHING_MAP.put("black", () -> CreateMoreFarmablesConfig.StainedGlassDyeSplashing.blackStainedGlassDyeSplashing);
        STAINED_GLASS_DYE_SPLASHING_MAP.put("brown", () -> CreateMoreFarmablesConfig.StainedGlassDyeSplashing.brownStainedGlassDyeSplashing);
        STAINED_GLASS_DYE_SPLASHING_MAP.put("red", () -> CreateMoreFarmablesConfig.StainedGlassDyeSplashing.redStainedGlassDyeSplashing);
        STAINED_GLASS_DYE_SPLASHING_MAP.put("orange", () -> CreateMoreFarmablesConfig.StainedGlassDyeSplashing.orangeStainedGlassDyeSplashing);
        STAINED_GLASS_DYE_SPLASHING_MAP.put("yellow", () -> CreateMoreFarmablesConfig.StainedGlassDyeSplashing.yellowStainedGlassDyeSplashing);
        STAINED_GLASS_DYE_SPLASHING_MAP.put("lime", () -> CreateMoreFarmablesConfig.StainedGlassDyeSplashing.limeStainedGlassDyeSplashing);
        STAINED_GLASS_DYE_SPLASHING_MAP.put("green", () -> CreateMoreFarmablesConfig.StainedGlassDyeSplashing.greenStainedGlassDyeSplashing);
        STAINED_GLASS_DYE_SPLASHING_MAP.put("cyan", () -> CreateMoreFarmablesConfig.StainedGlassDyeSplashing.cyanStainedGlassDyeSplashing);
        STAINED_GLASS_DYE_SPLASHING_MAP.put("light_blue", () -> CreateMoreFarmablesConfig.StainedGlassDyeSplashing.lightBlueStainedGlassDyeSplashing);
        STAINED_GLASS_DYE_SPLASHING_MAP.put("blue", () -> CreateMoreFarmablesConfig.StainedGlassDyeSplashing.blueStainedGlassDyeSplashing);
        STAINED_GLASS_DYE_SPLASHING_MAP.put("purple", () -> CreateMoreFarmablesConfig.StainedGlassDyeSplashing.purpleStainedGlassDyeSplashing);
        STAINED_GLASS_DYE_SPLASHING_MAP.put("magenta", () -> CreateMoreFarmablesConfig.StainedGlassDyeSplashing.magentaStainedGlassDyeSplashing);
        STAINED_GLASS_DYE_SPLASHING_MAP.put("pink", () -> CreateMoreFarmablesConfig.StainedGlassDyeSplashing.pinkStainedGlassDyeSplashing);

        // config condition {"type": "create_more_farmables:concrete_dye_splashing", "config": ""}
        CONCRETE_DYE_SPLASHING_MAP.put("white", () -> CreateMoreFarmablesConfig.ConcreteDyeSplashing.whiteConcreteDyeSplashing);
        CONCRETE_DYE_SPLASHING_MAP.put("light_gray", () -> CreateMoreFarmablesConfig.ConcreteDyeSplashing.lightGrayConcreteDyeSplashing);
        CONCRETE_DYE_SPLASHING_MAP.put("gray", () -> CreateMoreFarmablesConfig.ConcreteDyeSplashing.grayConcreteDyeSplashing);
        CONCRETE_DYE_SPLASHING_MAP.put("black", () -> CreateMoreFarmablesConfig.ConcreteDyeSplashing.blackConcreteDyeSplashing);
        CONCRETE_DYE_SPLASHING_MAP.put("brown", () -> CreateMoreFarmablesConfig.ConcreteDyeSplashing.brownConcreteDyeSplashing);
        CONCRETE_DYE_SPLASHING_MAP.put("red", () -> CreateMoreFarmablesConfig.ConcreteDyeSplashing.redConcreteDyeSplashing);
        CONCRETE_DYE_SPLASHING_MAP.put("orange", () -> CreateMoreFarmablesConfig.ConcreteDyeSplashing.orangeConcreteDyeSplashing);
        CONCRETE_DYE_SPLASHING_MAP.put("yellow", () -> CreateMoreFarmablesConfig.ConcreteDyeSplashing.yellowConcreteDyeSplashing);
        CONCRETE_DYE_SPLASHING_MAP.put("lime", () -> CreateMoreFarmablesConfig.ConcreteDyeSplashing.limeConcreteDyeSplashing);
        CONCRETE_DYE_SPLASHING_MAP.put("green", () -> CreateMoreFarmablesConfig.ConcreteDyeSplashing.greenConcreteDyeSplashing);
        CONCRETE_DYE_SPLASHING_MAP.put("cyan", () -> CreateMoreFarmablesConfig.ConcreteDyeSplashing.cyanConcreteDyeSplashing);
        CONCRETE_DYE_SPLASHING_MAP.put("light_blue", () -> CreateMoreFarmablesConfig.ConcreteDyeSplashing.lightBlueConcreteDyeSplashing);
        CONCRETE_DYE_SPLASHING_MAP.put("blue", () -> CreateMoreFarmablesConfig.ConcreteDyeSplashing.blueConcreteDyeSplashing);
        CONCRETE_DYE_SPLASHING_MAP.put("purple", () -> CreateMoreFarmablesConfig.ConcreteDyeSplashing.purpleConcreteDyeSplashing);
        CONCRETE_DYE_SPLASHING_MAP.put("magenta", () -> CreateMoreFarmablesConfig.ConcreteDyeSplashing.magentaConcreteDyeSplashing);
        CONCRETE_DYE_SPLASHING_MAP.put("pink", () -> CreateMoreFarmablesConfig.ConcreteDyeSplashing.pinkConcreteDyeSplashing);

        // config condition {"type": "create_more_farmables:terracotta_dye_splashing", "config": ""}
        TERRACOTTA_DYE_SPLASHING_MAP.put("white", () -> CreateMoreFarmablesConfig.TerracottaDyeSplashing.whiteTerracottaDyeSplashing);
        TERRACOTTA_DYE_SPLASHING_MAP.put("light_gray", () -> CreateMoreFarmablesConfig.TerracottaDyeSplashing.lightGrayTerracottaDyeSplashing);
        TERRACOTTA_DYE_SPLASHING_MAP.put("gray", () -> CreateMoreFarmablesConfig.TerracottaDyeSplashing.grayTerracottaDyeSplashing);
        TERRACOTTA_DYE_SPLASHING_MAP.put("black", () -> CreateMoreFarmablesConfig.TerracottaDyeSplashing.blackTerracottaDyeSplashing);
        TERRACOTTA_DYE_SPLASHING_MAP.put("brown", () -> CreateMoreFarmablesConfig.TerracottaDyeSplashing.brownTerracottaDyeSplashing);
        TERRACOTTA_DYE_SPLASHING_MAP.put("red", () -> CreateMoreFarmablesConfig.TerracottaDyeSplashing.redTerracottaDyeSplashing);
        TERRACOTTA_DYE_SPLASHING_MAP.put("orange", () -> CreateMoreFarmablesConfig.TerracottaDyeSplashing.orangeTerracottaDyeSplashing);
        TERRACOTTA_DYE_SPLASHING_MAP.put("yellow", () -> CreateMoreFarmablesConfig.TerracottaDyeSplashing.yellowTerracottaDyeSplashing);
        TERRACOTTA_DYE_SPLASHING_MAP.put("lime", () -> CreateMoreFarmablesConfig.TerracottaDyeSplashing.limeTerracottaDyeSplashing);
        TERRACOTTA_DYE_SPLASHING_MAP.put("green", () -> CreateMoreFarmablesConfig.TerracottaDyeSplashing.greenTerracottaDyeSplashing);
        TERRACOTTA_DYE_SPLASHING_MAP.put("cyan", () -> CreateMoreFarmablesConfig.TerracottaDyeSplashing.cyanTerracottaDyeSplashing);
        TERRACOTTA_DYE_SPLASHING_MAP.put("light_blue", () -> CreateMoreFarmablesConfig.TerracottaDyeSplashing.lightBlueTerracottaDyeSplashing);
        TERRACOTTA_DYE_SPLASHING_MAP.put("blue", () -> CreateMoreFarmablesConfig.TerracottaDyeSplashing.blueTerracottaDyeSplashing);
        TERRACOTTA_DYE_SPLASHING_MAP.put("purple", () -> CreateMoreFarmablesConfig.TerracottaDyeSplashing.purpleTerracottaDyeSplashing);
        TERRACOTTA_DYE_SPLASHING_MAP.put("magenta", () -> CreateMoreFarmablesConfig.TerracottaDyeSplashing.magentaTerracottaDyeSplashing);
        TERRACOTTA_DYE_SPLASHING_MAP.put("pink", () -> CreateMoreFarmablesConfig.TerracottaDyeSplashing.pinkTerracottaDyeSplashing);

        // config condition {"type": "create_more_farmables:wool_dye_splashing", "config": ""}
        WOOL_DYE_SPLASHING_MAP.put("white", () -> CreateMoreFarmablesConfig.WoolDyeSplashing.whiteWoolDyeSplashing);
        WOOL_DYE_SPLASHING_MAP.put("light_gray", () -> CreateMoreFarmablesConfig.WoolDyeSplashing.lightGrayWoolDyeSplashing);
        WOOL_DYE_SPLASHING_MAP.put("gray", () -> CreateMoreFarmablesConfig.WoolDyeSplashing.grayWoolDyeSplashing);
        WOOL_DYE_SPLASHING_MAP.put("black", () -> CreateMoreFarmablesConfig.WoolDyeSplashing.blackWoolDyeSplashing);
        WOOL_DYE_SPLASHING_MAP.put("brown", () -> CreateMoreFarmablesConfig.WoolDyeSplashing.brownWoolDyeSplashing);
        WOOL_DYE_SPLASHING_MAP.put("red", () -> CreateMoreFarmablesConfig.WoolDyeSplashing.redWoolDyeSplashing);
        WOOL_DYE_SPLASHING_MAP.put("orange", () -> CreateMoreFarmablesConfig.WoolDyeSplashing.orangeWoolDyeSplashing);
        WOOL_DYE_SPLASHING_MAP.put("yellow", () -> CreateMoreFarmablesConfig.WoolDyeSplashing.yellowWoolDyeSplashing);
        WOOL_DYE_SPLASHING_MAP.put("lime", () -> CreateMoreFarmablesConfig.WoolDyeSplashing.limeWoolDyeSplashing);
        WOOL_DYE_SPLASHING_MAP.put("green", () -> CreateMoreFarmablesConfig.WoolDyeSplashing.greenWoolDyeSplashing);
        WOOL_DYE_SPLASHING_MAP.put("cyan", () -> CreateMoreFarmablesConfig.WoolDyeSplashing.cyanWoolDyeSplashing);
        WOOL_DYE_SPLASHING_MAP.put("light_blue", () -> CreateMoreFarmablesConfig.WoolDyeSplashing.lightBlueWoolDyeSplashing);
        WOOL_DYE_SPLASHING_MAP.put("blue", () -> CreateMoreFarmablesConfig.WoolDyeSplashing.blueWoolDyeSplashing);
        WOOL_DYE_SPLASHING_MAP.put("purple", () -> CreateMoreFarmablesConfig.WoolDyeSplashing.purpleWoolDyeSplashing);
        WOOL_DYE_SPLASHING_MAP.put("magenta", () -> CreateMoreFarmablesConfig.WoolDyeSplashing.magentaWoolDyeSplashing);
        WOOL_DYE_SPLASHING_MAP.put("pink", () -> CreateMoreFarmablesConfig.WoolDyeSplashing.pinkWoolDyeSplashing);

    }

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