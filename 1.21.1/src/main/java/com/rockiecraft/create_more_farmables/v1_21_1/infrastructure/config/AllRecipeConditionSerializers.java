package com.rockiecraft.create_more_farmables.v1_21_1.infrastructure.config;

import com.mojang.serialization.MapCodec;
import com.rockiecraft.create_more_farmables.v1_21_1.CreateMoreFarmables;
import com.rockiecraft.create_more_farmables.v1_21_1.infrastructure.config.condition.ConfigRecipeCondition;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.*;
import java.util.function.Supplier;

public class AllRecipeConditionSerializers {

    public static final DeferredRegister<MapCodec<? extends ICondition>> CONDITION_SERIALIZERS =
            DeferredRegister.create(NeoForgeRegistries.CONDITION_SERIALIZERS, CreateMoreFarmables.MODID);

    public static final Map<String, Supplier<Boolean>> DYED_WATER_MAP = new HashMap<>();
    public static final Map<String, Supplier<Boolean>> DYE_TEMPLATE_FILLING_MAP = new HashMap<>();
    public static final Map<String, Supplier<Boolean>> CREATEMOREFARMABLES_ITEMS_MAP = new HashMap<>();
    public static final Map<String, Supplier<Boolean>> CREATEMOREFARMABLES_RECIPES_MAP = new HashMap<>();
    public static final Map<String, Supplier<Boolean>> CREATE_RECIPES_MAP = new HashMap<>();
    public static final Map<String, Supplier<Boolean>> CREATE_SIFTING_RECIPES_MAP = new HashMap<>();
    public static final Map<String, Supplier<Boolean>> CARPET_DYE_SPLASHING_MAP = new HashMap<>();
    public static final Map<String, Supplier<Boolean>> STAINED_GLASS_PANE_DYE_SPLASHING_MAP = new HashMap<>();
    public static final Map<String, Supplier<Boolean>> CONCRETE_POWDER_DYE_SPLASHING_MAP = new HashMap<>();
    public static final Map<String, Supplier<Boolean>> CONCRETE_DYE_SPLASHING_MAP = new HashMap<>();
    public static final Map<String, Supplier<Boolean>> TERRACOTTA_DYE_SPLASHING_MAP = new HashMap<>();
    public static final Map<String, Supplier<Boolean>> BED_DYE_SPLASHING_MAP = new HashMap<>();
    public static final Map<String, Supplier<Boolean>> STAINED_GLASS_DYE_SPLASHING_MAP = new HashMap<>();
    public static final Map<String, Supplier<Boolean>> WOOL_DYE_SPLASHING_MAP = new HashMap<>();

    public static final DeferredHolder<MapCodec<? extends ICondition>, MapCodec<ConfigRecipeCondition>> DYED_WATER_MIXING =
            CONDITION_SERIALIZERS.register("dyed_water_mixing",
                    () -> ConfigRecipeCondition.createCodec(
                            () -> CreateMoreFarmablesConfig.Dyed_Water_Making.allDyedWaterMixingEnabled,
                            DYED_WATER_MAP
                    ));

    public static final DeferredHolder<MapCodec<? extends ICondition>, MapCodec<ConfigRecipeCondition>> DYE_TEMPLATE_FILLING =
            CONDITION_SERIALIZERS.register("dye_template_filling",
                    () -> ConfigRecipeCondition.createCodec(
                            () -> CreateMoreFarmablesConfig.Dye_Template_Filling.allDyeFillingEnabled,
                            DYE_TEMPLATE_FILLING_MAP
                    ));

    public static final DeferredHolder<MapCodec<? extends ICondition>, MapCodec<ConfigRecipeCondition>> CREATE_MORE_FARMABLES_ITEMS =
            CONDITION_SERIALIZERS.register("item_recipes",
                    () -> ConfigRecipeCondition.createCodec(
                            () -> CreateMoreFarmablesConfig.CreateMoreFarmablesItems.CMFItemMasterToggleOn,
                            CREATEMOREFARMABLES_ITEMS_MAP
                    ));

    public static final DeferredHolder<MapCodec<? extends ICondition>, MapCodec<ConfigRecipeCondition>> CREATE_MORE_FARMABLES_RECIPES =
            CONDITION_SERIALIZERS.register("automation_easier_recipes",
                    () -> ConfigRecipeCondition.createCodec(
                            () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.CMF_RecipesToggle,
                            CREATEMOREFARMABLES_RECIPES_MAP
                    ));

    public static final DeferredHolder<MapCodec<? extends ICondition>, MapCodec<ConfigRecipeCondition>> CREATE_RECIPES_TOGGLES =
            CONDITION_SERIALIZERS.register("create_replacement_recipes",
                    () -> ConfigRecipeCondition.createCodec(
                            () -> CreateMoreFarmablesConfig.CreateRecipes.createRecipesMasterToggle,
                            CREATE_RECIPES_MAP
                    ));

    public static final DeferredHolder<MapCodec<? extends ICondition>, MapCodec<ConfigRecipeCondition>> CREATE_SIFTING_RECIPES_TOGGLES =
            CONDITION_SERIALIZERS.register("create_sifting_recipes",
                    () -> ConfigRecipeCondition.createCodec(
                            () -> CreateMoreFarmablesConfig.CreateSiftingRecipes.createSiftingRecipesMasterToggle,
                            CREATE_SIFTING_RECIPES_MAP
                    ));

    public static final DeferredHolder<MapCodec<? extends ICondition>, MapCodec<ConfigRecipeCondition>> CARPET_DYE_SPLASHING =
            CONDITION_SERIALIZERS.register("carpet_dye_splashing",
                    () -> ConfigRecipeCondition.createCodec(
                            () -> CreateMoreFarmablesConfig.CarpetDyeSplashing.allCarpetDyeSplashingEnabled,
                            CARPET_DYE_SPLASHING_MAP
                    ));

    public static final DeferredHolder<MapCodec<? extends ICondition>, MapCodec<ConfigRecipeCondition>> STAINED_GLASS_PANE_DYE_SPLASHING =
            CONDITION_SERIALIZERS.register("stained_glass_pane_dye_splashing",
                    () -> ConfigRecipeCondition.createCodec(
                            () -> CreateMoreFarmablesConfig.StainedGlassPaneDyeSplashing.allStainedGlassPaneDyeSplashingEnabled,
                            STAINED_GLASS_PANE_DYE_SPLASHING_MAP
                    ));

    public static final DeferredHolder<MapCodec<? extends ICondition>, MapCodec<ConfigRecipeCondition>> CONCRETE_POWDER_DYE_SPLASHING =
            CONDITION_SERIALIZERS.register("concrete_powder_dye_splashing",
                    () -> ConfigRecipeCondition.createCodec(
                            () -> CreateMoreFarmablesConfig.ConcretePowderDyeSplashing.allConcretePowderDyeSplashingEnabled,
                            CONCRETE_POWDER_DYE_SPLASHING_MAP
                    ));

    public static final DeferredHolder<MapCodec<? extends ICondition>, MapCodec<ConfigRecipeCondition>> CONCRETE_DYE_SPLASHING =
            CONDITION_SERIALIZERS.register("concrete_dye_splashing",
                    () -> ConfigRecipeCondition.createCodec(
                            () -> CreateMoreFarmablesConfig.ConcreteDyeSplashing.allConcreteDyeSplashingEnabled,
                            CONCRETE_DYE_SPLASHING_MAP
                    ));

    public static final DeferredHolder<MapCodec<? extends ICondition>, MapCodec<ConfigRecipeCondition>> TERRACOTTA_DYE_SPLASHING =
            CONDITION_SERIALIZERS.register("terracotta_dye_splashing",
                    () -> ConfigRecipeCondition.createCodec(
                            () -> CreateMoreFarmablesConfig.TerracottaDyeSplashing.allTerracottaDyeSplashingEnabled,
                            TERRACOTTA_DYE_SPLASHING_MAP
                    ));

    public static final DeferredHolder<MapCodec<? extends ICondition>, MapCodec<ConfigRecipeCondition>> BED_DYE_SPLASHING =
            CONDITION_SERIALIZERS.register("bed_dye_splashing",
                    () -> ConfigRecipeCondition.createCodec(
                            () -> CreateMoreFarmablesConfig.Bed_Splashing.allBedSplashingEnabled,
                            BED_DYE_SPLASHING_MAP
                    ));

    public static final DeferredHolder<MapCodec<? extends ICondition>, MapCodec<ConfigRecipeCondition>> STAINED_GLASS_DYE_SPLASHING =
            CONDITION_SERIALIZERS.register("stained_glass_dye_splashing",
                    () -> ConfigRecipeCondition.createCodec(
                            () -> CreateMoreFarmablesConfig.Glass_Splashing.allGlassSplashingEnabled,
                            STAINED_GLASS_DYE_SPLASHING_MAP
                    ));

    public static final DeferredHolder<MapCodec<? extends ICondition>, MapCodec<ConfigRecipeCondition>> WOOL_DYE_SPLASHING =
            CONDITION_SERIALIZERS.register("wool_dye_splashing",
                    () -> ConfigRecipeCondition.createCodec(
                            () -> CreateMoreFarmablesConfig.Wool_Splashing.allWoolSplashingEnabled,
                            WOOL_DYE_SPLASHING_MAP
                    ));

    static {
        CREATEMOREFARMABLES_ITEMS_MAP.put("echoShardDustOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmablesItems.echoShardDustOn);
        CREATEMOREFARMABLES_ITEMS_MAP.put("enderpearlDustOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmablesItems.EnderpearlDustOn);
        CREATEMOREFARMABLES_ITEMS_MAP.put("netheriteDustOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmablesItems.netheriteDustOn);
        CREATEMOREFARMABLES_ITEMS_MAP.put("shulkerShellFragmentOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmablesItems.shulkerShellFragmentOn);
        CREATEMOREFARMABLES_ITEMS_MAP.put("shulkerCompoundOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmablesItems.shulkerCompoundOn);
        CREATEMOREFARMABLES_ITEMS_MAP.put("heartOfTheSeaFragmentOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmablesItems.heartOfTheSeaFragmentOn);
        CREATEMOREFARMABLES_ITEMS_MAP.put("nautilusShellFragmentOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmablesItems.nautilusShellFragmentOn);
        CREATEMOREFARMABLES_ITEMS_MAP.put("dyeTemplateOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmablesItems.dyeTemplateOn);
        CREATEMOREFARMABLES_ITEMS_MAP.put("woodStringWoolOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmablesItems.woodStringWoolOn);
        CREATEMOREFARMABLES_ITEMS_MAP.put("woodStringOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmablesItems.woodStringOn);
        CREATEMOREFARMABLES_ITEMS_MAP.put("echoShardDustCrushingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmablesItems.echoShardDustCrushingOn);

        CREATEMOREFARMABLES_RECIPES_MAP.put("dirtMakingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.dirtMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("endstoneMakingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.endstoneMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("magmablockMakingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.magmablockMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("ae2CertusQuartzMakingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.certusquartzDupeMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("asurineMakingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.asurineMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("calciteMakingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.calciteMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("crimsiteMakingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.crimsiteMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("dioriteMakingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.dioriteMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("ochrumMakingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.ochrumMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("redsandMakingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.redsandMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("veridiumMakingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.veridiumMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("blazerodMakingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.blazeRodMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("dioriteAssemblyMakingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.cobblestonetodioriteMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("netheriteScrapMakingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.netheritescrapMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("netheriteScrapV2MakingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.netheritescrapXPNuggetsMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("roseQuartzAssemblyMakingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.roseQuartzMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("nautilusShellMakingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.nautilusShellMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("shulkerShellMakingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.shulkerShellMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("netherrackMakingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.netherrackMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("andesiteNetherrackMakingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.andesiteNetherrackMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("redstoneToGlowstoneMakingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.redstoneToGlowstoneMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("echoShardMakingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.echoShardMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("heartOfTheSeaMakingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.heartOfTheSeaMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("redstoneMakingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.redstoneMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("moltenEndstoneMakingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.moltenEndstoneMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("liquidQuartzMakingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.liquidQuartzMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("liquidRedstoneMakingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.liquidRedstoneMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("stringMakingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.stringMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("whiteWoolMakingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.whiteWoolMakingOn);
        CREATEMOREFARMABLES_RECIPES_MAP.put("heartOfTheSeaFragmentMakingOn", () -> CreateMoreFarmablesConfig.CreateMoreFarmables_recipes.heartOfTheSeaFragmentMakingOn);

        CREATE_RECIPES_MAP.put("asurineCrushing", () -> CreateMoreFarmablesConfig.CreateRecipes.asurineCrushing);
        CREATE_RECIPES_MAP.put("asurineRecycling", () -> CreateMoreFarmablesConfig.CreateRecipes.asurineRecycling);
        CREATE_RECIPES_MAP.put("crimsiteCrushing", () -> CreateMoreFarmablesConfig.CreateRecipes.crimsiteCrushing);
        CREATE_RECIPES_MAP.put("crimsiteRecycling", () -> CreateMoreFarmablesConfig.CreateRecipes.crimsiteRecycling);
        CREATE_RECIPES_MAP.put("ochrumCrushing", () -> CreateMoreFarmablesConfig.CreateRecipes.ochrumCrushing);
        CREATE_RECIPES_MAP.put("ochrumRecycling", () -> CreateMoreFarmablesConfig.CreateRecipes.ochrumRecycling);
        CREATE_RECIPES_MAP.put("scoriaToLapisLazuli", () -> CreateMoreFarmablesConfig.CreateRecipes.scoriaToLapisLazuli);

        CREATE_SIFTING_RECIPES_MAP.put("advancedGravelSiftingOn", () -> CreateMoreFarmablesConfig.CreateSiftingRecipes.advancedGravelSiftingOn);
        CREATE_SIFTING_RECIPES_MAP.put("advancedRedsandSiftingOn", () -> CreateMoreFarmablesConfig.CreateSiftingRecipes.advancedRedsandSiftingOn);
        CREATE_SIFTING_RECIPES_MAP.put("advancedSandSiftingOn", () -> CreateMoreFarmablesConfig.CreateSiftingRecipes.advancedSandSiftingOn);
        CREATE_SIFTING_RECIPES_MAP.put("advancedSpongeSiftingOn", () -> CreateMoreFarmablesConfig.CreateSiftingRecipes.advancedSpongeSiftingOn);

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

        BED_DYE_SPLASHING_MAP.put("white", () -> CreateMoreFarmablesConfig.Bed_Splashing.whiteBedSplashing);
        BED_DYE_SPLASHING_MAP.put("light_gray", () -> CreateMoreFarmablesConfig.Bed_Splashing.lightGrayBedSplashing);
        BED_DYE_SPLASHING_MAP.put("gray", () -> CreateMoreFarmablesConfig.Bed_Splashing.grayBedSplashing);
        BED_DYE_SPLASHING_MAP.put("black", () -> CreateMoreFarmablesConfig.Bed_Splashing.blackBedSplashing);
        BED_DYE_SPLASHING_MAP.put("brown", () -> CreateMoreFarmablesConfig.Bed_Splashing.brownBedSplashing);
        BED_DYE_SPLASHING_MAP.put("red", () -> CreateMoreFarmablesConfig.Bed_Splashing.redBedSplashing);
        BED_DYE_SPLASHING_MAP.put("orange", () -> CreateMoreFarmablesConfig.Bed_Splashing.orangeBedSplashing);
        BED_DYE_SPLASHING_MAP.put("yellow", () -> CreateMoreFarmablesConfig.Bed_Splashing.yellowBedSplashing);
        BED_DYE_SPLASHING_MAP.put("lime", () -> CreateMoreFarmablesConfig.Bed_Splashing.limeBedSplashing);
        BED_DYE_SPLASHING_MAP.put("green", () -> CreateMoreFarmablesConfig.Bed_Splashing.greenBedSplashing);
        BED_DYE_SPLASHING_MAP.put("cyan", () -> CreateMoreFarmablesConfig.Bed_Splashing.cyanBedSplashing);
        BED_DYE_SPLASHING_MAP.put("light_blue", () -> CreateMoreFarmablesConfig.Bed_Splashing.lightBlueBedSplashing);
        BED_DYE_SPLASHING_MAP.put("blue", () -> CreateMoreFarmablesConfig.Bed_Splashing.blueBedSplashing);
        BED_DYE_SPLASHING_MAP.put("purple", () -> CreateMoreFarmablesConfig.Bed_Splashing.purpleBedSplashing);
        BED_DYE_SPLASHING_MAP.put("magenta", () -> CreateMoreFarmablesConfig.Bed_Splashing.magentaBedSplashing);
        BED_DYE_SPLASHING_MAP.put("pink", () -> CreateMoreFarmablesConfig.Bed_Splashing.pinkBedSplashing);

        STAINED_GLASS_DYE_SPLASHING_MAP.put("white", () -> CreateMoreFarmablesConfig.Glass_Splashing.whiteGlassSplashing);
        STAINED_GLASS_DYE_SPLASHING_MAP.put("light_gray", () -> CreateMoreFarmablesConfig.Glass_Splashing.lightGrayGlassSplashing);
        STAINED_GLASS_DYE_SPLASHING_MAP.put("gray", () -> CreateMoreFarmablesConfig.Glass_Splashing.grayGlassSplashing);
        STAINED_GLASS_DYE_SPLASHING_MAP.put("black", () -> CreateMoreFarmablesConfig.Glass_Splashing.blackGlassSplashing);
        STAINED_GLASS_DYE_SPLASHING_MAP.put("brown", () -> CreateMoreFarmablesConfig.Glass_Splashing.brownGlassSplashing);
        STAINED_GLASS_DYE_SPLASHING_MAP.put("red", () -> CreateMoreFarmablesConfig.Glass_Splashing.redGlassSplashing);
        STAINED_GLASS_DYE_SPLASHING_MAP.put("orange", () -> CreateMoreFarmablesConfig.Glass_Splashing.orangeGlassSplashing);
        STAINED_GLASS_DYE_SPLASHING_MAP.put("yellow", () -> CreateMoreFarmablesConfig.Glass_Splashing.yellowGlassSplashing);
        STAINED_GLASS_DYE_SPLASHING_MAP.put("lime", () -> CreateMoreFarmablesConfig.Glass_Splashing.limeGlassSplashing);
        STAINED_GLASS_DYE_SPLASHING_MAP.put("green", () -> CreateMoreFarmablesConfig.Glass_Splashing.greenGlassSplashing);
        STAINED_GLASS_DYE_SPLASHING_MAP.put("cyan", () -> CreateMoreFarmablesConfig.Glass_Splashing.cyanGlassSplashing);
        STAINED_GLASS_DYE_SPLASHING_MAP.put("light_blue", () -> CreateMoreFarmablesConfig.Glass_Splashing.lightBlueGlassSplashing);
        STAINED_GLASS_DYE_SPLASHING_MAP.put("blue", () -> CreateMoreFarmablesConfig.Glass_Splashing.blueGlassSplashing);
        STAINED_GLASS_DYE_SPLASHING_MAP.put("purple", () -> CreateMoreFarmablesConfig.Glass_Splashing.purpleGlassSplashing);
        STAINED_GLASS_DYE_SPLASHING_MAP.put("magenta", () -> CreateMoreFarmablesConfig.Glass_Splashing.magentaGlassSplashing);
        STAINED_GLASS_DYE_SPLASHING_MAP.put("pink", () -> CreateMoreFarmablesConfig.Glass_Splashing.pinkGlassSplashing);

        WOOL_DYE_SPLASHING_MAP.put("white", () -> CreateMoreFarmablesConfig.Wool_Splashing.whiteWoolSplashing);
        WOOL_DYE_SPLASHING_MAP.put("light_gray", () -> CreateMoreFarmablesConfig.Wool_Splashing.lightGrayWoolSplashing);
        WOOL_DYE_SPLASHING_MAP.put("gray", () -> CreateMoreFarmablesConfig.Wool_Splashing.grayWoolSplashing);
        WOOL_DYE_SPLASHING_MAP.put("black", () -> CreateMoreFarmablesConfig.Wool_Splashing.blackWoolSplashing);
        WOOL_DYE_SPLASHING_MAP.put("brown", () -> CreateMoreFarmablesConfig.Wool_Splashing.brownWoolSplashing);
        WOOL_DYE_SPLASHING_MAP.put("red", () -> CreateMoreFarmablesConfig.Wool_Splashing.redWoolSplashing);
        WOOL_DYE_SPLASHING_MAP.put("orange", () -> CreateMoreFarmablesConfig.Wool_Splashing.orangeWoolSplashing);
        WOOL_DYE_SPLASHING_MAP.put("yellow", () -> CreateMoreFarmablesConfig.Wool_Splashing.yellowWoolSplashing);
        WOOL_DYE_SPLASHING_MAP.put("lime", () -> CreateMoreFarmablesConfig.Wool_Splashing.limeWoolSplashing);
        WOOL_DYE_SPLASHING_MAP.put("green", () -> CreateMoreFarmablesConfig.Wool_Splashing.greenWoolSplashing);
        WOOL_DYE_SPLASHING_MAP.put("cyan", () -> CreateMoreFarmablesConfig.Wool_Splashing.cyanWoolSplashing);
        WOOL_DYE_SPLASHING_MAP.put("light_blue", () -> CreateMoreFarmablesConfig.Wool_Splashing.lightBlueWoolSplashing);
        WOOL_DYE_SPLASHING_MAP.put("blue", () -> CreateMoreFarmablesConfig.Wool_Splashing.blueWoolSplashing);
        WOOL_DYE_SPLASHING_MAP.put("purple", () -> CreateMoreFarmablesConfig.Wool_Splashing.purpleWoolSplashing);
        WOOL_DYE_SPLASHING_MAP.put("magenta", () -> CreateMoreFarmablesConfig.Wool_Splashing.magentaWoolSplashing);
        WOOL_DYE_SPLASHING_MAP.put("pink", () -> CreateMoreFarmablesConfig.Wool_Splashing.pinkWoolSplashing);

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
    }

    public static void init(IEventBus modEventBus) {
        CONDITION_SERIALIZERS.register(modEventBus);
    }
}