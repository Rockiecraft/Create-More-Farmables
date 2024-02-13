package net.rockiecraft.create_more_farmables;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fluids.FluidType;

import net.rockiecraft.create_more_farmables.fluid.types.*;

public class AllFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, CreateMoreFarmables.ID);
	// replace "MOLTEN_ENDSTONE_" with the name of the custom liquid you wish to create a type of. keep in mind that the name is case-sensitive.
	public static final RegistryObject<FluidType> MOLTEN_ENDSTONE_TYPE = REGISTRY.register("molten_endstone", MoltenEndstoneFluidType::new);

	public static final RegistryObject<FluidType> WHITE_DYED_WATER_TYPE = REGISTRY.register("white_dyed_water", WhiteDyedWaterFluidType::new);

	public static final RegistryObject<FluidType> BLACK_DYED_WATER_TYPE = REGISTRY.register("black_dyed_water", BlackDyedWaterFluidType::new);

	public static final RegistryObject<FluidType> GRAY_DYED_WATER_TYPE = REGISTRY.register("gray_dyed_water", () -> new GrayDyedWaterFluidType());

	public static final RegistryObject<FluidType> BLUE_DYED_WATER_TYPE = REGISTRY.register("blue_dyed_water", () -> new BlueDyedWaterFluidType());

	public static final RegistryObject<FluidType> RED_DYED_WATER_TYPE = REGISTRY.register("red_dyed_water", () -> new RedDyedWaterFluidType());

	public static final RegistryObject<FluidType> PURPLE_DYED_WATER_TYPE = REGISTRY.register("purple_dyed_water", () -> new PurpleDyedWaterFluidType());

	public static final RegistryObject<FluidType> PINK_DYED_WATER_TYPE = REGISTRY.register("pink_dyed_water", () -> new PinkDyedWaterFluidType());

	public static final RegistryObject<FluidType> MAGENTA_DYED_WATER_TYPE = REGISTRY.register("magenta_dyed_water", () -> new MagentaDyedWaterFluidType());

	public static final RegistryObject<FluidType> LIGHT_GRAY_DYED_WATER_TYPE = REGISTRY.register("light_gray_dyed_water", () -> new LightGrayDyedWaterFluidType());

	public static final RegistryObject<FluidType> GREEN_DYED_WATER_TYPE = REGISTRY.register("green_dyed_water", () -> new GreenDyedWaterFluidType());

	public static final RegistryObject<FluidType> LIME_DYED_WATER_TYPE = REGISTRY.register("lime_dyed_water", () -> new LimeDyedWaterFluidType());

	public static final RegistryObject<FluidType> CYAN_DYED_WATER_TYPE = REGISTRY.register("cyan_dyed_water", () -> new CyanDyedWaterFluidType());

	public static final RegistryObject<FluidType> LIGHT_BLUE_DYED_WATER_TYPE = REGISTRY.register("light_blue_dyed_water", () -> new LightBlueDyedWaterFluidType());

	public static final RegistryObject<FluidType> BROWN_DYED_WATER_TYPE = REGISTRY.register("brown_dyed_water", () -> new BrownDyedWaterFluidType());

	public static final RegistryObject<FluidType> ORANGE_DYED_WATER_TYPE = REGISTRY.register("orange_dyed_water", () -> new OrangeDyedWaterFluidType());

	public static final RegistryObject<FluidType> YELLOW_DYED_WATER_TYPE = REGISTRY.register("yellow_dyed_water", () -> new YellowDyedWaterFluidType());
}
