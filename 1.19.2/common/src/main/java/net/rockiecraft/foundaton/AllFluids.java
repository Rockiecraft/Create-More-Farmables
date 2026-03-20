package net.rockiecraft.foundaton;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.botarium.api.registry.fluid.BotariumFlowingFluid;
import earth.terrarium.botarium.api.registry.fluid.BotariumSourceFluid;
import net.minecraft.core.Registry;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.rockiecraft.CreateMoreFarmables;
import net.rockiecraft.foundaton.registry.fluids.AllFluidProperties;


public class AllFluids {

    public static final ResourcefulRegistry<Fluid> FLUIDS = ResourcefulRegistries.create(Registry.FLUID, CreateMoreFarmables.MOD_ID);

    //    public static final RegistryEntry<Fluid> _DYED_WATER = FLUIDS.register("_dyed_water",
    //    () -> new BotariumSourceFluid(AllFluidProperties._DYED_WATER));
    //    public static final RegistryEntry<Fluid> FLOWING__DYED_WATER = FLUIDS.register("flowing__dyed_water",
    //    () -> new BotariumFlowingFluid(AllFluidProperties._DYED_WATER));

    public static final RegistryEntry<Fluid> LIQUID_QUARTZ = FLUIDS.register("liquid_quartz",
            () -> new BotariumSourceFluid(AllFluidProperties.LIQUID_QUARTZ));
    public static final RegistryEntry<FlowingFluid> FLOWING_LIQUID_QUARTZ = FLUIDS.register("flowing_liquid_quartz",
            () -> new BotariumFlowingFluid(AllFluidProperties.LIQUID_QUARTZ));

    public static final RegistryEntry<Fluid> LIQUID_REDSTONE = FLUIDS.register("liquid_redstone",
            () -> new BotariumSourceFluid(AllFluidProperties.LIQUID_REDSTONE));
    public static final RegistryEntry<FlowingFluid> FLOWING_LIQUID_REDSTONE = FLUIDS.register("flowing_liquid_redstone",
            () -> new BotariumFlowingFluid(AllFluidProperties.LIQUID_REDSTONE));

    public static final RegistryEntry<FlowingFluid> MOLTEN_ENDSTONE= FLUIDS.register("molten_endstone",
            () -> new BotariumSourceFluid(AllFluidProperties.MOLTEN_ENDSTONE));
    public static final RegistryEntry<FlowingFluid> FLOWING_MOLTEN_ENDSTONE = FLUIDS.register("flowing_molten_endstone",
            () -> new BotariumFlowingFluid(AllFluidProperties.MOLTEN_ENDSTONE));




    public static final RegistryEntry<Fluid> WHITE_DYED_WATER = FLUIDS.register("white_dyed_water",
            () -> new BotariumSourceFluid(AllFluidProperties.WHITE_DYED_WATER));
    public static final RegistryEntry<FlowingFluid> FLOWING_WHITE_DYED_WATER = FLUIDS.register("flowing_white_dyed_water",
            () -> new BotariumFlowingFluid(AllFluidProperties.WHITE_DYED_WATER));

    public static final RegistryEntry<Fluid> LIGHT_GRAY_DYED_WATER = FLUIDS.register("light_gray_dyed_water",
            () -> new BotariumSourceFluid(AllFluidProperties.LIGHT_GRAY_DYED_WATER));
    public static final RegistryEntry<FlowingFluid> FLOWING_LIGHT_GRAY_DYED_WATER = FLUIDS.register("flowing_light_gray_dyed_water",
            () -> new BotariumFlowingFluid(AllFluidProperties.LIGHT_GRAY_DYED_WATER));

    public static final RegistryEntry<Fluid> GRAY_DYED_WATER = FLUIDS.register("gray_dyed_water",
            () -> new BotariumSourceFluid(AllFluidProperties.GRAY_DYED_WATER));
    public static final RegistryEntry<FlowingFluid> FLOWING_GRAY_DYED_WATER = FLUIDS.register("flowing_gray_dyed_water",
            () -> new BotariumFlowingFluid(AllFluidProperties.GRAY_DYED_WATER));

    public static final RegistryEntry<Fluid> BLACK_DYED_WATER = FLUIDS.register("black_dyed_water",
            () -> new BotariumSourceFluid(AllFluidProperties.BLACK_DYED_WATER));
    public static final RegistryEntry<FlowingFluid> FLOWING_BLACK_DYED_WATER = FLUIDS.register("flowing_black_dyed_water",
            () -> new BotariumFlowingFluid(AllFluidProperties.BLACK_DYED_WATER));

    public static final RegistryEntry<Fluid> BROWN_DYED_WATER = FLUIDS.register("brown_dyed_water",
            () -> new BotariumSourceFluid(AllFluidProperties.BROWN_DYED_WATER));
    public static final RegistryEntry<FlowingFluid> FLOWING_BROWN_DYED_WATER = FLUIDS.register("flowing_brown_dyed_water",
            () -> new BotariumFlowingFluid(AllFluidProperties.BROWN_DYED_WATER));

    public static final RegistryEntry<Fluid> RED_DYED_WATER = FLUIDS.register("red_dyed_water",
            () -> new BotariumSourceFluid(AllFluidProperties.RED_DYED_WATER));
    public static final RegistryEntry<FlowingFluid> FLOWING_RED_DYED_WATER = FLUIDS.register("flowing_red_dyed_water",
            () -> new BotariumFlowingFluid(AllFluidProperties.RED_DYED_WATER));

    public static final RegistryEntry<Fluid> ORANGE_DYED_WATER = FLUIDS.register("orange_dyed_water",
            () -> new BotariumSourceFluid(AllFluidProperties.ORANGE_DYED_WATER));
    public static final RegistryEntry<FlowingFluid> FLOWING_ORANGE_DYED_WATER = FLUIDS.register("flowing_orange_dyed_water",
            () -> new BotariumFlowingFluid(AllFluidProperties.ORANGE_DYED_WATER));

    public static final RegistryEntry<Fluid> YELLOW_DYED_WATER = FLUIDS.register("yellow_dyed_water",
            () -> new BotariumSourceFluid(AllFluidProperties.YELLOW_DYED_WATER));
    public static final RegistryEntry<FlowingFluid> FLOWING_YELLOW_DYED_WATER = FLUIDS.register("flowing_yellow_dyed_water",
            () -> new BotariumFlowingFluid(AllFluidProperties.YELLOW_DYED_WATER));

    public static final RegistryEntry<Fluid> GREEN_DYED_WATER = FLUIDS.register("green_dyed_water",
            () -> new BotariumSourceFluid(AllFluidProperties.GREEN_DYED_WATER));
    public static final RegistryEntry<FlowingFluid> FLOWING_GREEN_DYED_WATER = FLUIDS.register("flowing_green_dyed_water",
            () -> new BotariumFlowingFluid(AllFluidProperties.GREEN_DYED_WATER));

    public static final RegistryEntry<Fluid> LIME_DYED_WATER = FLUIDS.register("lime_dyed_water",
            () -> new BotariumSourceFluid(AllFluidProperties.LIME_DYED_WATER));
    public static final RegistryEntry<FlowingFluid> FLOWING_LIME_DYED_WATER = FLUIDS.register("flowing_lime_dyed_water",
            () -> new BotariumFlowingFluid(AllFluidProperties.LIME_DYED_WATER));

    public static final RegistryEntry<Fluid> CYAN_DYED_WATER = FLUIDS.register("cyan_dyed_water",
            () -> new BotariumSourceFluid(AllFluidProperties.CYAN_DYED_WATER));
    public static final RegistryEntry<FlowingFluid> FLOWING_CYAN_DYED_WATER = FLUIDS.register("flowing_cyan_dyed_water",
            () -> new BotariumFlowingFluid(AllFluidProperties.CYAN_DYED_WATER));

    public static final RegistryEntry<Fluid> LIGHT_BLUE_DYED_WATER = FLUIDS.register("light_blue_dyed_water",
            () -> new BotariumSourceFluid(AllFluidProperties.LIGHT_BLUE_DYED_WATER));
    public static final RegistryEntry<FlowingFluid>FLOWING_LIGHT_BLUE_DYED_WATER = FLUIDS.register("flowing_light_blue_dyed_water",
            () -> new BotariumFlowingFluid(AllFluidProperties.LIGHT_BLUE_DYED_WATER));

    public static final RegistryEntry<Fluid> BLUE_DYED_WATER = FLUIDS.register("blue_dyed_water",
            () -> new BotariumSourceFluid(AllFluidProperties.BLUE_DYED_WATER));
    public static final RegistryEntry<FlowingFluid> FLOWING_BLUE_DYED_WATER = FLUIDS.register("flowing_blue_dyed_water",
            () -> new BotariumFlowingFluid(AllFluidProperties.BLUE_DYED_WATER));

    public static final RegistryEntry<Fluid> PURPLE_DYED_WATER = FLUIDS.register("purple_dyed_water",
            () -> new BotariumSourceFluid(AllFluidProperties.PURPLE_DYED_WATER));
    public static final RegistryEntry<FlowingFluid> FLOWING_PURPLE_DYED_WATER = FLUIDS.register("flowing_purple_dyed_water",
            () -> new BotariumFlowingFluid(AllFluidProperties.PURPLE_DYED_WATER));

    public static final RegistryEntry<Fluid> MAGENTA_DYED_WATER = FLUIDS.register("magenta_dyed_water",
            () -> new BotariumSourceFluid(AllFluidProperties.MAGENTA_DYED_WATER));
    public static final RegistryEntry<FlowingFluid> FLOWING_MAGENTA_DYED_WATER = FLUIDS.register("flowing_magenta_dyed_water",
            () -> new BotariumFlowingFluid(AllFluidProperties.MAGENTA_DYED_WATER));

    public static final RegistryEntry<Fluid> PINK_DYED_WATER = FLUIDS.register("pink_dyed_water",
            () -> new BotariumSourceFluid(AllFluidProperties.PINK_DYED_WATER));
    public static final RegistryEntry<FlowingFluid> FLOWING_PINK_DYED_WATER = FLUIDS.register("flowing_pink_dyed_water",
            () -> new BotariumFlowingFluid(AllFluidProperties.PINK_DYED_WATER));


    public static void init() {
        FLUIDS.init();
    }
}
