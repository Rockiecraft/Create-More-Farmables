
package net.rockiecraft.create_more_farmables;


import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rockiecraft.create_more_farmables.fluid.*;
import net.rockiecraft.create_more_farmables.fluid.RedDyedWaterFluid;

import static net.minecraft.client.renderer.RenderType.translucent;


public class AllFluids {


	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, CreateMoreFarmables.ID);
	/*
	 * replace "MOLTEN_ENDSTONE_" with the name of the custom liquid you wish to create a type of.
	 * keep in mind that the name is case-sensitive.
	 */
	public static final RegistryObject<FlowingFluid> MOLTEN_ENDSTONE = REGISTRY.register("molten_endstone", () -> new MoltenEndstoneFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_MOLTEN_ENDSTONE = REGISTRY.register("flowing_molten_endstone", () -> new MoltenEndstoneFluid.Flowing());

	public static final RegistryObject<FlowingFluid> WHITE_DYED_WATER = REGISTRY.register("white_dyed_water", () -> new WhiteDyedWaterFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_WHITE_DYED_WATER = REGISTRY.register("flowing_white_dyed_water", () -> new WhiteDyedWaterFluid.Flowing());

	public static final RegistryObject<FlowingFluid> BLACK_DYED_WATER = REGISTRY.register("black_dyed_water", () -> new BlackDyedWaterFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_BLACK_DYED_WATER = REGISTRY.register("flowing_black_dyed_water", () -> new BlackDyedWaterFluid.Flowing());


	public static final RegistryObject<FlowingFluid> LIGHT_GRAY_DYED_WATER = REGISTRY.register("light_grey_dyed_water", () -> new LightGrayDyedWaterFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_LIGHT_GRAY_DYED_WATER = REGISTRY.register("flowing_light_gray_dyed_water", () -> new LightGrayDyedWaterFluid.Flowing());

	public static final RegistryObject<FlowingFluid> GREY_DYED_WATER = REGISTRY.register("grey_dyed_water", () -> new GrayDyedWaterFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_GREY_DYED_WATER = REGISTRY.register("flowing_grey_dyed_water", () -> new GrayDyedWaterFluid.Flowing());

	public static final RegistryObject<FlowingFluid> BLUE_DYED_WATER = REGISTRY.register("blue_dyed_water", () -> new BlueDyedWaterFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_BLUE_DYED_WATER = REGISTRY.register("flowing_blue_dyed_water", () -> new BlueDyedWaterFluid.Flowing());

	public static final RegistryObject<FlowingFluid> RED_DYED_WATER = REGISTRY.register("red_dyed_water", () -> new RedDyedWaterFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_RED_DYED_WATER = REGISTRY.register("flowing_red_dyed_water", () -> new RedDyedWaterFluid.Flowing());


	public static final RegistryObject<FlowingFluid> PURPLE_DYED_WATER = REGISTRY.register("purple_dyed_water", () -> new PurpleDyedWaterFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_PURPLE_DYED_WATER = REGISTRY.register("flowing_purple_dyed_water", () -> new PurpleDyedWaterFluid.Flowing());


	public static final RegistryObject<FlowingFluid> PINK_DYED_WATER = REGISTRY.register("pink_dyed_water", () -> new PinkDyedWaterFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_PINK_DYED_WATER = REGISTRY.register("flowing_pink_dyed_water", () -> new PinkDyedWaterFluid.Flowing());


	public static final RegistryObject<FlowingFluid> MAGENTA_DYED_WATER = REGISTRY.register("magenta_dyed_water", () -> new MagentaDyedWaterFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_MAGENTA_DYED_WATER = REGISTRY.register("flowing_magenta_dyed_water", () -> new MagentaDyedWaterFluid.Flowing());


	public static final RegistryObject<FlowingFluid> GREEN_DYED_WATER = REGISTRY.register("green_dyed_water", () -> new GreenDyedWaterFluid.Source());

	public static final RegistryObject<FlowingFluid> FLOWING_GREEN_DYED_WATER = REGISTRY.register("flowing_green_dyed_water", () -> new GreenDyedWaterFluid.Flowing());


	public static final RegistryObject<FlowingFluid> LIME_DYED_WATER = REGISTRY.register("lime_dyed_water", () -> new LimeDyedWaterFluid.Source());

	public static final RegistryObject<FlowingFluid> FLOWING_LIME_DYED_WATER = REGISTRY.register("flowing_lime_dyed_water", () -> new LimeDyedWaterFluid.Flowing());


	public static final RegistryObject<FlowingFluid> CYAN_DYED_WATER = REGISTRY.register("cyan_dyed_water", () -> new CyanDyedWaterFluid.Source());

	public static final RegistryObject<FlowingFluid> FLOWING_CYAN_DYED_WATER = REGISTRY.register("flowing_cyan_dyed_water", () -> new CyanDyedWaterFluid.Flowing());


	public static final RegistryObject<FlowingFluid> LIGHT_BLUE_DYED_WATER = REGISTRY.register("light_blue_dyed_water", () -> new LightBlueDyedWaterFluid.Source());

	public static final RegistryObject<FlowingFluid> FLOWING_LIGHT_BLUE_DYED_WATER = REGISTRY.register("flowing_light_blue_dyed_water", () -> new LightBlueDyedWaterFluid.Flowing());


	public static final RegistryObject<FlowingFluid> BROWN_DYED_WATER = REGISTRY.register("brown_dyed_water", () -> new BrownDyedWaterFluid.Source());

	public static final RegistryObject<FlowingFluid> FLOWING_BROWN_DYED_WATER = REGISTRY.register("flowing_brown_dyed_water", () -> new BrownDyedWaterFluid.Flowing());

	public static final RegistryObject<FlowingFluid> ORANGE_DYED_WATER = REGISTRY.register("orange_dyed_water", () -> new OrangeDyedWaterFluid.Source());

	public static final RegistryObject<FlowingFluid> FLOWING_ORANGE_DYED_WATER = REGISTRY.register("flowing_orange_dyed_water", () -> new OrangeDyedWaterFluid.Flowing());

	public static final RegistryObject<FlowingFluid> YELLOW_DYED_WATER = REGISTRY.register("yellow_dyed_water", () -> new YellowDyedWaterFluid.Source());

	public static final RegistryObject<FlowingFluid> FLOWING_YELLOW_DYED_WATER = REGISTRY.register("flowing_yellow_dyed_water", () -> new YellowDyedWaterFluid.Flowing());



	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(WHITE_DYED_WATER.get(), translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_WHITE_DYED_WATER.get(), translucent());

			ItemBlockRenderTypes.setRenderLayer(BLACK_DYED_WATER.get(), translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_BLACK_DYED_WATER.get(), translucent());

            ItemBlockRenderTypes.setRenderLayer(GREY_DYED_WATER.get(), translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_GREY_DYED_WATER.get(), translucent());

            ItemBlockRenderTypes.setRenderLayer(BLUE_DYED_WATER.get(), translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_BLUE_DYED_WATER.get(), translucent());

			ItemBlockRenderTypes.setRenderLayer(RED_DYED_WATER.get(), translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_RED_DYED_WATER.get(), translucent());

			ItemBlockRenderTypes.setRenderLayer(PURPLE_DYED_WATER.get(), translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_PURPLE_DYED_WATER.get(), translucent());

			ItemBlockRenderTypes.setRenderLayer(MAGENTA_DYED_WATER.get(), translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_MAGENTA_DYED_WATER.get(), translucent());

			ItemBlockRenderTypes.setRenderLayer(GREEN_DYED_WATER.get(), translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_GREEN_DYED_WATER.get(), translucent());

			ItemBlockRenderTypes.setRenderLayer(LIME_DYED_WATER.get(), translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_LIME_DYED_WATER.get(), translucent());

			ItemBlockRenderTypes.setRenderLayer(CYAN_DYED_WATER.get(), translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_CYAN_DYED_WATER.get(), translucent());

            ItemBlockRenderTypes.setRenderLayer(LIGHT_BLUE_DYED_WATER.get(), translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_LIGHT_BLUE_DYED_WATER.get(), translucent());

            ItemBlockRenderTypes.setRenderLayer(BROWN_DYED_WATER.get(), translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_BROWN_DYED_WATER.get(), translucent());

			ItemBlockRenderTypes.setRenderLayer(ORANGE_DYED_WATER.get(), translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_ORANGE_DYED_WATER.get(), translucent());

            ItemBlockRenderTypes.setRenderLayer(YELLOW_DYED_WATER.get(), translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_YELLOW_DYED_WATER.get(), translucent());

            ItemBlockRenderTypes.setRenderLayer(MAGENTA_DYED_WATER.get(), translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_MAGENTA_DYED_WATER.get(), translucent());

			ItemBlockRenderTypes.setRenderLayer(PINK_DYED_WATER.get(), translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_PINK_DYED_WATER.get(), translucent());

			ItemBlockRenderTypes.setRenderLayer(LIGHT_GRAY_DYED_WATER.get(), translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_LIGHT_GRAY_DYED_WATER.get(), translucent());

		}
	}

}

