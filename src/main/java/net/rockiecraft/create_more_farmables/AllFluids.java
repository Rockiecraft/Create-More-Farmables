
package net.rockiecraft.create_more_farmables;


import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.FluidType.Properties;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

import java.util.function.Consumer;

import static net.minecraft.client.renderer.RenderType.translucent;


public class AllFluids {

	public AllFluids() {}

	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, CreateMoreFarmables.ID);
	/*
	 * replace "MOLTEN_ENDSTONE_" with the name of the custom liquid you wish to create a type of.
	 * keep in mind that the name is case-sensitive.
	 */
	public static final DeferredRegister<FluidType> FLUID_TYPES;
	public static final DeferredRegister<Fluid> FLUIDS;
	public static final DeferredRegister<Block> BLOCKS;

	public static final RegistryObject<FluidType> WHITE_DYED_WATER_FLUID_TYPE;
	public static final RegistryObject<FlowingFluid> WHITE_DYED_WATER;
	public static final RegistryObject<Fluid> FLOWING_WHITE_DYED_WATER;
	public static final RegistryObject<LiquidBlock> WHITE_DYED_WATER_BLOCK;

// -----------------------------------------------------------------------------

	public static final RegistryObject<FluidType> BLACK_DYED_WATER_FLUID_TYPE;

	public static final RegistryObject<FlowingFluid> BLACK_DYED_WATER;

 	public static final RegistryObject<Fluid> FLOWING_BLACK_DYED_WATER;

	 public static final RegistryObject<LiquidBlock> BLACK_DYED_WATER_BLOCK;

// -----------------------------------------------------------------------------

	public static final RegistryObject<FluidType> GRAY_DYED_WATER_FLUID_TYPE;

	public static final RegistryObject<FlowingFluid> GRAY_DYED_WATER;

	public static final RegistryObject<Fluid> FLOWING_GRAY_DYED_WATER;

	public static final RegistryObject<LiquidBlock> GRAY_DYED_WATER_BLOCK;


//-----------------------------------------------------------------------------
	public static final RegistryObject<FluidType> BLUE_DYED_WATER_FLUID_TYPE;
	public static final RegistryObject<FlowingFluid> BLUE_DYED_WATER;
	 public static final RegistryObject<Fluid> FLOWING_BLUE_DYED_WATER;
 	public static final RegistryObject<LiquidBlock> BLUE_DYED_WATER_BLOCK;
//-----------------------------------------------------------------------------
	public static final RegistryObject<FluidType> RED_DYED_WATER_FLUID_TYPE;
	public static final RegistryObject<FlowingFluid> RED_DYED_WATER;
 	public static final RegistryObject<Fluid> FLOWING_RED_DYED_WATER;
 	public static final RegistryObject<LiquidBlock> RED_DYED_WATER_BLOCK;
 //-----------------------------------------------------------------------------
	public static final RegistryObject<FluidType> PURPLE_DYED_WATER_FLUID_TYPE;
	public static final RegistryObject<FlowingFluid> PURPLE_DYED_WATER;
 	public static final RegistryObject<Fluid> FLOWING_PURPLE_DYED_WATER;
 	public static final RegistryObject<LiquidBlock> PURPLE_DYED_WATER_BLOCK;
// -----------------------------------------------------------------------------
	public static final RegistryObject<FluidType> PINK_DYED_WATER_FLUID_TYPE;
	public static final RegistryObject<FlowingFluid> PINK_DYED_WATER;
	 public static final RegistryObject<Fluid> FLOWING_PINK_DYED_WATER;
 	public static final RegistryObject<LiquidBlock> PINK_DYED_WATER_BLOCK;
// -----------------------------------------------------------------------------
	public static final RegistryObject<FluidType> MAGENTA_DYED_WATER_FLUID_TYPE;
	public static final RegistryObject<FlowingFluid> MAGENTA_DYED_WATER;
 	public static final RegistryObject<Fluid> FLOWING_MAGENTA_DYED_WATER;
 	public static final RegistryObject<LiquidBlock> MAGENTA_DYED_WATER_BLOCK;
 //-----------------------------------------------------------------------------

    public static final RegistryObject<FluidType> LIGHT_GRAY_DYED_WATER_FLUID_TYPE;

	public static final RegistryObject<FlowingFluid> LIGHT_GRAY_DYED_WATER;

 	public static final RegistryObject<Fluid> FLOWING_LIGHT_GRAY_DYED_WATER;

 	public static final RegistryObject<LiquidBlock> LIGHT_GRAY_DYED_WATER_BLOCK;


 //-----------------------------------------------------------------------------
	public static final RegistryObject<FluidType> GREEN_DYED_WATER_FLUID_TYPE;
	public static final RegistryObject<FlowingFluid> GREEN_DYED_WATER;
	 public static final RegistryObject<Fluid> FLOWING_GREEN_DYED_WATER;
 	public static final RegistryObject<LiquidBlock> GREEN_DYED_WATER_BLOCK;
 //-----------------------------------------------------------------------------
	public static final RegistryObject<FluidType> LIME_DYED_WATER_FLUID_TYPE;
	public static final RegistryObject<FlowingFluid> LIME_DYED_WATER;
 	public static final RegistryObject<Fluid> FLOWING_LIME_DYED_WATER;
 	public static final RegistryObject<LiquidBlock> LIME_DYED_WATER_BLOCK;
 //-----------------------------------------------------------------------------
	public static final RegistryObject<FluidType> CYAN_DYED_WATER_FLUID_TYPE;
	public static final RegistryObject<FlowingFluid> CYAN_DYED_WATER;
 	public static final RegistryObject<Fluid> FLOWING_CYAN_DYED_WATER;
 	public static final RegistryObject<LiquidBlock> CYAN_DYED_WATER_BLOCK;
//-----------------------------------------------------------------------------
	public static final RegistryObject<FluidType> BROWN_DYED_WATER_FLUID_TYPE;
	public static final RegistryObject<FlowingFluid> BROWN_DYED_WATER;
 	public static final RegistryObject<Fluid> FLOWING_BROWN_DYED_WATER;
 	public static final RegistryObject<LiquidBlock> BROWN_DYED_WATER_BLOCK;
//-----------------------------------------------------------------------------
	public static final RegistryObject<FluidType> LIGHT_BLUE_DYED_WATER_FLUID_TYPE;
	public static final RegistryObject<FlowingFluid> LIGHT_BLUE_DYED_WATER;
 	public static final RegistryObject<Fluid> FLOWING_LIGHT_BLUE_DYED_WATER;
 	public static final RegistryObject<LiquidBlock> LIGHT_BLUE_DYED_WATER_BLOCK;
//-----------------------------------------------------------------------------
	public static final RegistryObject<FluidType> ORANGE_DYED_WATER_FLUID_TYPE;
	public static final RegistryObject<FlowingFluid> ORANGE_DYED_WATER;
 	public static final RegistryObject<Fluid> FLOWING_ORANGE_DYED_WATER;
 	public static final RegistryObject<LiquidBlock> ORANGE_DYED_WATER_BLOCK;
 //-----------------------------------------------------------------------------
	public static final RegistryObject<FluidType> YELLOW_DYED_WATER_FLUID_TYPE;
	public static final RegistryObject<FlowingFluid> YELLOW_DYED_WATER;
	 public static final RegistryObject<Fluid> FLOWING_YELLOW_DYED_WATER;
 	public static final RegistryObject<LiquidBlock> YELLOW_DYED_WATER_BLOCK;
 //-----------------------------------------------------------------------------


    public static final RegistryObject<FluidType> MOLTEN_ENDSTONE_FLUID_TYPE;
	public static final RegistryObject<FlowingFluid> MOLTEN_ENDSTONE;
 	public static final RegistryObject<Fluid> FLOWING_MOLTEN_ENDSTONE;
 	public static final RegistryObject<LiquidBlock> MOLTEN_ENDSTONE_BLOCK;


    public static ForgeFlowingFluid.Properties MOLTENENDSTONEFluidProperties() {
		return (new ForgeFlowingFluid.Properties(MOLTEN_ENDSTONE_FLUID_TYPE, MOLTEN_ENDSTONE, FLOWING_MOLTEN_ENDSTONE)).block(MOLTEN_ENDSTONE_BLOCK).bucket(AllItems.MOLTEN_ENDSTONE_BUCKET);

	}

	public static ForgeFlowingFluid.Properties WHITEDYEDWATERFluidProperties() {
		return (new ForgeFlowingFluid.Properties(WHITE_DYED_WATER_FLUID_TYPE, WHITE_DYED_WATER, FLOWING_WHITE_DYED_WATER)).block(WHITE_DYED_WATER_BLOCK).bucket(AllItems.WHITE_DYED_WATER_BUCKET);

	}

	public static ForgeFlowingFluid.Properties LIGHTGRAYDYEDWATERFluidProperties() {
		return (new ForgeFlowingFluid.Properties(LIGHT_GRAY_DYED_WATER_FLUID_TYPE, LIGHT_GRAY_DYED_WATER, FLOWING_LIGHT_GRAY_DYED_WATER)).block(LIGHT_GRAY_DYED_WATER_BLOCK).bucket(AllItems.LIGHT_GRAY_DYED_WATER_BUCKET);

	}

	public static ForgeFlowingFluid.Properties GRAYDYEDWATERFluidProperties() {
		return (new ForgeFlowingFluid.Properties(GRAY_DYED_WATER_FLUID_TYPE, GRAY_DYED_WATER, FLOWING_GRAY_DYED_WATER)).block(GRAY_DYED_WATER_BLOCK).bucket(AllItems.GRAY_DYED_WATER_BUCKET);

	}

	public static ForgeFlowingFluid.Properties BLACKDYEDWATERFluidProperties() {
		return (new ForgeFlowingFluid.Properties(BLACK_DYED_WATER_FLUID_TYPE, BLACK_DYED_WATER, FLOWING_BLACK_DYED_WATER)).block(BLACK_DYED_WATER_BLOCK).bucket(AllItems.BLACK_DYED_WATER_BUCKET);

	}
	public static ForgeFlowingFluid.Properties BROWNDYEDWATERFluidProperties() {
		return (new ForgeFlowingFluid.Properties(BROWN_DYED_WATER_FLUID_TYPE, BROWN_DYED_WATER, FLOWING_BROWN_DYED_WATER)).block(BROWN_DYED_WATER_BLOCK).bucket(AllItems.BROWN_DYED_WATER_BUCKET);
	}

	public static ForgeFlowingFluid.Properties REDDYEDWATERFluidProperties() {
        return (new ForgeFlowingFluid.Properties(RED_DYED_WATER_FLUID_TYPE, RED_DYED_WATER, FLOWING_RED_DYED_WATER)).block(RED_DYED_WATER_BLOCK).bucket(AllItems.RED_DYED_WATER_BUCKET);

    }

	public static ForgeFlowingFluid.Properties ORANGEDYEDWATERFluidProperties() {
		return (new ForgeFlowingFluid.Properties(ORANGE_DYED_WATER_FLUID_TYPE, ORANGE_DYED_WATER, FLOWING_ORANGE_DYED_WATER)).block(ORANGE_DYED_WATER_BLOCK).bucket(AllItems.ORANGE_DYED_WATER_BUCKET);

	}

	public static ForgeFlowingFluid.Properties YELLOWDYEDWATERFluidProperties() {
        return (new ForgeFlowingFluid.Properties(YELLOW_DYED_WATER_FLUID_TYPE, YELLOW_DYED_WATER, FLOWING_YELLOW_DYED_WATER)).block(YELLOW_DYED_WATER_BLOCK).bucket(AllItems.YELLOW_DYED_WATER_BUCKET);

    }
	public static ForgeFlowingFluid.Properties GREENDYEDWATERFluidProperties() {
		return (new ForgeFlowingFluid.Properties(GREEN_DYED_WATER_FLUID_TYPE, GREEN_DYED_WATER, FLOWING_GREEN_DYED_WATER)).block(GREEN_DYED_WATER_BLOCK).bucket(AllItems.GREEN_DYED_WATER_BUCKET);
	}

	public static ForgeFlowingFluid.Properties LIMEDYEDWATERFluidProperties() {
		return (new ForgeFlowingFluid.Properties(LIME_DYED_WATER_FLUID_TYPE, LIME_DYED_WATER, FLOWING_LIME_DYED_WATER)).block(LIME_DYED_WATER_BLOCK).bucket(AllItems.LIME_DYED_WATER_BUCKET);

	}

	public static ForgeFlowingFluid.Properties CYANDYEDWATERFluidProperties() {
		return (new ForgeFlowingFluid.Properties(CYAN_DYED_WATER_FLUID_TYPE, CYAN_DYED_WATER, FLOWING_CYAN_DYED_WATER)).block(CYAN_DYED_WATER_BLOCK).bucket(AllItems.CYAN_DYED_WATER_BUCKET);

	}
	public static ForgeFlowingFluid.Properties LIGHTBLUEDYEDWATERFluidProperties() {
		return (new ForgeFlowingFluid.Properties(LIGHT_BLUE_DYED_WATER_FLUID_TYPE, LIGHT_BLUE_DYED_WATER, FLOWING_LIGHT_BLUE_DYED_WATER)).block(LIGHT_BLUE_DYED_WATER_BLOCK).bucket(AllItems.LIGHT_BLUE_DYED_WATER_BUCKET);

	}

	public static ForgeFlowingFluid.Properties BLUEDYEDWATERFluidProperties() {
		return (new ForgeFlowingFluid.Properties(BLUE_DYED_WATER_FLUID_TYPE, BLUE_DYED_WATER, FLOWING_BLUE_DYED_WATER)).block(BLUE_DYED_WATER_BLOCK).bucket(AllItems.BLUE_DYED_WATER_BUCKET);

	}

	public static ForgeFlowingFluid.Properties PURPLEDYEDWATERFluidProperties() {
		return (new ForgeFlowingFluid.Properties(PURPLE_DYED_WATER_FLUID_TYPE, PURPLE_DYED_WATER, FLOWING_PURPLE_DYED_WATER)).block(PURPLE_DYED_WATER_BLOCK).bucket(AllItems.PURPLE_DYED_WATER_BUCKET);

	}
	public static ForgeFlowingFluid.Properties MAGENTADYEDWATERFluidProperties() {
		return (new ForgeFlowingFluid.Properties(MAGENTA_DYED_WATER_FLUID_TYPE, MAGENTA_DYED_WATER, FLOWING_MAGENTA_DYED_WATER)).block(MAGENTA_DYED_WATER_BLOCK).bucket(AllItems.MAGENTA_DYED_WATER_BUCKET);
	}
	public static ForgeFlowingFluid.Properties PINKDYEDWATERFluidProperties() {
        return (new ForgeFlowingFluid.Properties(PINK_DYED_WATER_FLUID_TYPE, PINK_DYED_WATER, FLOWING_PINK_DYED_WATER)).block(PINK_DYED_WATER_BLOCK).bucket(AllItems.PINK_DYED_WATER_BUCKET);

    }


	static {
		FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, "create_more_farmables");
		FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, "create_more_farmables");
		BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "create_more_farmables");
		// -----------------------------------------------------------------------------
		MOLTEN_ENDSTONE_FLUID_TYPE = FLUID_TYPES.register("molten_endstone", () -> {
			return new FluidType(Properties.create().fallDistanceModifier(0F).canExtinguish(true).supportsBoating(true).canHydrate(true).canPushEntity(true).pathType(BlockPathTypes.WATER).motionScale(0.007D).canConvertToSource(true)
					.sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)) {
				public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
					consumer.accept(new IClientFluidTypeExtensions() {
						private static final ResourceLocation
								STILL_TEXTURE = new ResourceLocation("create_more_farmables:block/flowing_molten_endstone"),
								FLOWING_TEXTURE = new ResourceLocation("create_more_farmables:block/flowing_molten_endstone");

						public ResourceLocation getStillTexture() {
							return STILL_TEXTURE;
						}

						public ResourceLocation getFlowingTexture() {
							return FLOWING_TEXTURE;
						}

					});
				}
			};
		});

		MOLTEN_ENDSTONE = FLUIDS.register("molten_endstone", () -> {
			return new ForgeFlowingFluid.Source(MOLTENENDSTONEFluidProperties());
		});
		FLOWING_MOLTEN_ENDSTONE= FLUIDS.register("flowing_molten_endstone", () -> {
			return new ForgeFlowingFluid.Flowing(MOLTENENDSTONEFluidProperties());
		});

		MOLTEN_ENDSTONE_BLOCK = BLOCKS.register("molten_endstone_block",() -> {
			return new LiquidBlock(AllFluids.MOLTEN_ENDSTONE, BlockBehaviour.Properties.of().mapColor(MapColor.FIRE).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
		});



		// -----------------------------------------------------------------------------
		WHITE_DYED_WATER_FLUID_TYPE = FLUID_TYPES.register("white_dyed_water", () -> {
			return new FluidType(Properties.create().fallDistanceModifier(0F).canExtinguish(true).supportsBoating(true).canHydrate(true).canPushEntity(true).pathType(BlockPathTypes.WATER).motionScale(0.007D).canConvertToSource(true)
					.sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)) {
				public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
					consumer.accept(new IClientFluidTypeExtensions() {
						private static final ResourceLocation
								STILL_TEXTURE = new ResourceLocation("create_more_farmables:block/dyed_water"),
								FLOWING_TEXTURE = new ResourceLocation("create_more_farmables:block/flowing_dyed_water");

						public ResourceLocation getStillTexture() {
							return STILL_TEXTURE;
						}

						public ResourceLocation getFlowingTexture() {
							return FLOWING_TEXTURE;
						}

						public int getTintColor() {
							return -393218;
						}

						public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
							int color = this.getTintColor();
							return new Vector3f((float)(color >> 16 & 255) / 255.0F, (float)(color >> 8 & 255) / 255.0F, (float)(color & 255) / 255.0F);
						}

					});
				}
			};
		});

		WHITE_DYED_WATER = FLUIDS.register("white_dyed_water", () -> {
			return new ForgeFlowingFluid.Source(WHITEDYEDWATERFluidProperties());
		});
		FLOWING_WHITE_DYED_WATER = FLUIDS.register("flowing_white_dyed_water", () -> {
			return new ForgeFlowingFluid.Flowing(WHITEDYEDWATERFluidProperties());
		});

		WHITE_DYED_WATER_BLOCK = BLOCKS.register("white_dyed_water_block",() -> {
			return new LiquidBlock(AllFluids.WHITE_DYED_WATER, BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
		});

		// -----------------------------------------------------------------------------
		LIGHT_GRAY_DYED_WATER_FLUID_TYPE = FLUID_TYPES.register("light_gray_dyed_water", () -> {
			return new FluidType(Properties.create().fallDistanceModifier(0F).canExtinguish(true).supportsBoating(true).canHydrate(true).canPushEntity(true).pathType(BlockPathTypes.WATER).motionScale(0.007D).canConvertToSource(true)
					.sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)) {
				public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
					consumer.accept(new IClientFluidTypeExtensions() {
						private static final ResourceLocation
								STILL_TEXTURE = new ResourceLocation("create_more_farmables:block/dyed_water"),
								FLOWING_TEXTURE = new ResourceLocation("create_more_farmables:block/flowing_dyed_water");

						public ResourceLocation getStillTexture() {
							return STILL_TEXTURE;
						}

						public ResourceLocation getFlowingTexture() {
							return FLOWING_TEXTURE;
						}

						public int getTintColor() {
							return -6447721;
						}

						public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
							int color = this.getTintColor();
							return new Vector3f((float)(color >> 16 & 255) / 255.0F, (float)(color >> 8 & 255) / 255.0F, (float)(color & 255) / 255.0F);
						}

					});
				}
			};
		});

		LIGHT_GRAY_DYED_WATER = FLUIDS.register("light_gray_dyed_water", () -> {
			return new ForgeFlowingFluid.Source(LIGHTGRAYDYEDWATERFluidProperties());
		});
		FLOWING_LIGHT_GRAY_DYED_WATER = FLUIDS.register("flowing_light_gray_dyed_water", () -> {
			return new ForgeFlowingFluid.Flowing(LIGHTGRAYDYEDWATERFluidProperties());
		});

		LIGHT_GRAY_DYED_WATER_BLOCK = BLOCKS.register("light_gray_dyed_water_block",() -> {
			return new LiquidBlock(AllFluids.LIGHT_GRAY_DYED_WATER, BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
		});
		// -----------------------------------------------------------------------------
		GRAY_DYED_WATER_FLUID_TYPE = FLUID_TYPES.register("gray_dyed_water", () -> {
			return new FluidType(Properties.create().fallDistanceModifier(0F).canExtinguish(true).supportsBoating(true).canHydrate(true).canPushEntity(true).pathType(BlockPathTypes.WATER).motionScale(0.007D).canConvertToSource(true)
					.sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)) {
				public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
					consumer.accept(new IClientFluidTypeExtensions() {
						private static final ResourceLocation
								STILL_TEXTURE = new ResourceLocation("create_more_farmables:block/dyed_water"),
								FLOWING_TEXTURE = new ResourceLocation("create_more_farmables:block/flowing_dyed_water");

						public ResourceLocation getStillTexture() {
							return STILL_TEXTURE;
						}

						public ResourceLocation getFlowingTexture() {
							return FLOWING_TEXTURE;
						}

						public int getTintColor() {
							return -12103854;
						}

						public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
							int color = this.getTintColor();
							return new Vector3f((float)(color >> 16 & 255) / 255.0F, (float)(color >> 8 & 255) / 255.0F, (float)(color & 255) / 255.0F);
						}

					});
				}
			};
		});

		GRAY_DYED_WATER = FLUIDS.register("gray_dyed_water", () -> {
			return new ForgeFlowingFluid.Source(GRAYDYEDWATERFluidProperties());
		});
		FLOWING_GRAY_DYED_WATER = FLUIDS.register("flowing_gray_dyed_water", () -> {
			return new ForgeFlowingFluid.Flowing(GRAYDYEDWATERFluidProperties());
		});

		GRAY_DYED_WATER_BLOCK = BLOCKS.register("gray_dyed_water_block",() -> {
			return new LiquidBlock(AllFluids.GRAY_DYED_WATER, BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
		});

		// -----------------------------------------------------------------------------
		BLACK_DYED_WATER_FLUID_TYPE = FLUID_TYPES.register("black_dyed_water", () -> {
			return new FluidType(Properties.create().fallDistanceModifier(0F).canExtinguish(true).supportsBoating(true).canHydrate(true).canPushEntity(true).pathType(BlockPathTypes.WATER).motionScale(0.007D).canConvertToSource(true)
					.sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)) {
				public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
					consumer.accept(new IClientFluidTypeExtensions() {
						private static final ResourceLocation
								STILL_TEXTURE = new ResourceLocation("create_more_farmables:block/dyed_water"),
								FLOWING_TEXTURE = new ResourceLocation("create_more_farmables:block/flowing_dyed_water");

						public ResourceLocation getStillTexture() {
							return STILL_TEXTURE;
						}

						public ResourceLocation getFlowingTexture() {
							return FLOWING_TEXTURE;
						}

						public int getTintColor() {
							return -14869215;
						}

						public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
							int color = this.getTintColor();
							return new Vector3f((float)(color >> 16 & 255) / 255.0F, (float)(color >> 8 & 255) / 255.0F, (float)(color & 255) / 255.0F);
						}

					});
				}
			};
		});

		BLACK_DYED_WATER = FLUIDS.register("black_dyed_water", () -> {
			return new ForgeFlowingFluid.Source(BLACKDYEDWATERFluidProperties());
		});
		FLOWING_BLACK_DYED_WATER = FLUIDS.register("flowing_black_dyed_water", () -> {
			return new ForgeFlowingFluid.Flowing(BLACKDYEDWATERFluidProperties());
		});

		BLACK_DYED_WATER_BLOCK = BLOCKS.register("black_dyed_water_block",() -> {
			return new LiquidBlock(AllFluids.BLACK_DYED_WATER, BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
		});

		// -----------------------------------------------------------------------------
		BROWN_DYED_WATER_FLUID_TYPE = FLUID_TYPES.register("brown_dyed_water", () -> {
			return new FluidType(Properties.create().fallDistanceModifier(0F).canExtinguish(true).supportsBoating(true).canHydrate(true).canPushEntity(true).pathType(BlockPathTypes.WATER).motionScale(0.007D).canConvertToSource(true)
					.sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)) {
				public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
					consumer.accept(new IClientFluidTypeExtensions() {
						private static final ResourceLocation
								STILL_TEXTURE = new ResourceLocation("create_more_farmables:block/dyed_water"),
								FLOWING_TEXTURE = new ResourceLocation("create_more_farmables:block/flowing_dyed_water");

						public ResourceLocation getStillTexture() {
							return STILL_TEXTURE;
						}

						public ResourceLocation getFlowingTexture() {
							return FLOWING_TEXTURE;
						}
						
						public int getTintColor() {
							return -8170446;
						}

						public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
							int color = this.getTintColor();
							return new Vector3f((float)(color >> 16 & 255) / 255.0F, (float)(color >> 8 & 255) / 255.0F, (float)(color & 255) / 255.0F);
						}

					});
				}
			};
		});

		BROWN_DYED_WATER = FLUIDS.register("brown_dyed_water", () -> {
			return new ForgeFlowingFluid.Source(BROWNDYEDWATERFluidProperties());
		});
		FLOWING_BROWN_DYED_WATER = FLUIDS.register("flowing_brown_dyed_water", () -> {
			return new ForgeFlowingFluid.Flowing(BROWNDYEDWATERFluidProperties());
		});

		BROWN_DYED_WATER_BLOCK = BLOCKS.register("brown_dyed_water_block",() -> {
			return new LiquidBlock(AllFluids.BROWN_DYED_WATER, BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
		});

        // -----------------------------------------------------------------------------
		RED_DYED_WATER_FLUID_TYPE = FLUID_TYPES.register("red_dyed_water", () -> {
			return new FluidType(Properties.create().fallDistanceModifier(0F).canExtinguish(true).supportsBoating(true).canHydrate(true).canPushEntity(true).pathType(BlockPathTypes.WATER).motionScale(0.007D).canConvertToSource(true)
                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)) {
				public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
					consumer.accept(new IClientFluidTypeExtensions() {
						private static final ResourceLocation
                                STILL_TEXTURE = new ResourceLocation("create_more_farmables:block/dyed_water"),
                                FLOWING_TEXTURE = new ResourceLocation("create_more_farmables:block/flowing_dyed_water");

                        public ResourceLocation getStillTexture() {
                            return STILL_TEXTURE;
                        }

                        public ResourceLocation getFlowingTexture() {
                            return FLOWING_TEXTURE;
                        }

                        public int getTintColor() {
                            return -5231066;
                        }

                        public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
							int color = this.getTintColor();
							return new Vector3f((float)(color >> 16 & 255) / 255.0F, (float)(color >> 8 & 255) / 255.0F, (float)(color & 255) / 255.0F);
						}
					});
				}
			};
		});

		RED_DYED_WATER = FLUIDS.register("red_dyed_water", () -> {
            return new ForgeFlowingFluid.Source(REDDYEDWATERFluidProperties());
        });
		FLOWING_RED_DYED_WATER = FLUIDS.register("flowing_red_dyed_water", () -> {
            return new ForgeFlowingFluid.Flowing(REDDYEDWATERFluidProperties());
        });
		RED_DYED_WATER_BLOCK = BLOCKS.register("red_dyed_water_block",() -> {
            return new LiquidBlock(AllFluids.RED_DYED_WATER, BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
        });
		// -----------------------------------------------------------------------------
		ORANGE_DYED_WATER_FLUID_TYPE = FLUID_TYPES.register("orange_dyed_water", () -> {
			return new FluidType(Properties.create().fallDistanceModifier(0F).canExtinguish(true).supportsBoating(true).canHydrate(true).canPushEntity(true).pathType(BlockPathTypes.WATER).motionScale(0.007D).canConvertToSource(true)
                  .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)) {
				public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
					consumer.accept(new IClientFluidTypeExtensions() {
						private static final ResourceLocation
                                STILL_TEXTURE = new ResourceLocation("create_more_farmables:block/dyed_water"),
                                FLOWING_TEXTURE = new ResourceLocation("create_more_farmables:block/flowing_dyed_water");

                        public ResourceLocation getStillTexture() {
                            return STILL_TEXTURE;
                        }

                        public ResourceLocation getFlowingTexture() {
                            return FLOWING_TEXTURE;
                        }

                        public int getTintColor() {
                            return -425955;
                        }
						public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
							int color = this.getTintColor();
                            return new Vector3f((float)(color >> 16 & 255) / 255.0F, (float)(color >> 8 & 255) / 255.0F, (float)(color & 255) / 255.0F);
						}
					});
				}
			};
		});
		ORANGE_DYED_WATER = FLUIDS.register("orange_dyed_water", () -> {
            return new ForgeFlowingFluid.Source(ORANGEDYEDWATERFluidProperties());
        });
		FLOWING_ORANGE_DYED_WATER = FLUIDS.register("flowing_orange_dyed_water", () -> {
            return new ForgeFlowingFluid.Flowing(ORANGEDYEDWATERFluidProperties());
        });
		ORANGE_DYED_WATER_BLOCK = BLOCKS.register("orange_dyed_water_block",() -> {
			return new LiquidBlock(AllFluids.ORANGE_DYED_WATER, BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
		});
		// -----------------------------------------------------------------------------
		YELLOW_DYED_WATER_FLUID_TYPE = FLUID_TYPES.register("yellow_dyed_water", () -> {
			return new FluidType(Properties.create().fallDistanceModifier(0F).canExtinguish(true).supportsBoating(true).canHydrate(true).canPushEntity(true).pathType(BlockPathTypes.WATER).motionScale(0.007D).canConvertToSource(true)
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)) {
				public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
					consumer.accept(new IClientFluidTypeExtensions() {
						private static final ResourceLocation
                                STILL_TEXTURE = new ResourceLocation("create_more_farmables:block/dyed_water"),
                                FLOWING_TEXTURE = new ResourceLocation("create_more_farmables:block/flowing_dyed_water");

                        public ResourceLocation getStillTexture() {
                            return STILL_TEXTURE;
                        }

                        public ResourceLocation getFlowingTexture() {
                            return FLOWING_TEXTURE;
                        }

                        public int getTintColor() {
                            return -75715;
                        }
						public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
							int color = this.getTintColor();
                            return new Vector3f((float)(color >> 16 & 255) / 255.0F, (float)(color >> 8 & 255) / 255.0F, (float)(color & 255) / 255.0F);
						}
					});
				}
			};
		});
		YELLOW_DYED_WATER = FLUIDS.register("yellow_dyed_water", () -> {
            return new ForgeFlowingFluid.Source(YELLOWDYEDWATERFluidProperties());
        });
		FLOWING_YELLOW_DYED_WATER = FLUIDS.register("flowing_yellow_dyed_water", () -> {
            return new ForgeFlowingFluid.Flowing(YELLOWDYEDWATERFluidProperties());
        });
		YELLOW_DYED_WATER_BLOCK = BLOCKS.register("yellow_dyed_water_block",() -> {
			return new LiquidBlock(AllFluids.YELLOW_DYED_WATER, BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
		});
		// -----------------------------------------------------------------------------
		GREEN_DYED_WATER_FLUID_TYPE = FLUID_TYPES.register("green_dyed_water", () -> {
			return new FluidType(Properties.create().fallDistanceModifier(0F).canExtinguish(true).supportsBoating(true).canHydrate(true).canPushEntity(true).pathType(BlockPathTypes.WATER).motionScale(0.007D).canConvertToSource(true)
              .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)) {
				public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
					consumer.accept(new IClientFluidTypeExtensions() {
						private static final ResourceLocation
                                STILL_TEXTURE = new ResourceLocation("create_more_farmables:block/dyed_water"),
                                FLOWING_TEXTURE = new ResourceLocation("create_more_farmables:block/flowing_dyed_water");

                        public ResourceLocation getStillTexture() {
                            return STILL_TEXTURE;
                        }

                        public ResourceLocation getFlowingTexture() {
                            return FLOWING_TEXTURE;
                        }

                        public int getTintColor() {
                            return -10585066;
                        }
						public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
							int color = this.getTintColor();
                            return new Vector3f((float)(color >> 16 & 255) / 255.0F, (float)(color >> 8 & 255) / 255.0F, (float)(color & 255) / 255.0F);
						}
					});
				}
			};
		});
		GREEN_DYED_WATER = FLUIDS.register("green_dyed_water", () -> {
            return new ForgeFlowingFluid.Source(GREENDYEDWATERFluidProperties());
        });
		FLOWING_GREEN_DYED_WATER = FLUIDS.register("flowing_green_dyed_water", () -> {
            return new ForgeFlowingFluid.Flowing(GREENDYEDWATERFluidProperties());
        });
		GREEN_DYED_WATER_BLOCK = BLOCKS.register("green_dyed_water_block",() -> {
			return new LiquidBlock(AllFluids.GREEN_DYED_WATER, BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
		});
		// -----------------------------------------------------------------------------
		LIME_DYED_WATER_FLUID_TYPE = FLUID_TYPES.register("lime_dyed_water", () -> {
			return new FluidType(Properties.create().fallDistanceModifier(0F).canExtinguish(true).supportsBoating(true).canHydrate(true).canPushEntity(true).pathType(BlockPathTypes.WATER).motionScale(0.007D).canConvertToSource(true)
            .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)) {
				public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
					consumer.accept(new IClientFluidTypeExtensions() {
						private static final ResourceLocation
                                STILL_TEXTURE = new ResourceLocation("create_more_farmables:block/dyed_water"),
                                FLOWING_TEXTURE = new ResourceLocation("create_more_farmables:block/flowing_dyed_water");

                        public ResourceLocation getStillTexture() {
                            return STILL_TEXTURE;
                        }

                        public ResourceLocation getFlowingTexture() {
                            return FLOWING_TEXTURE;
                        }

                        public int getTintColor() {
                            return -8337633;
                        }
						public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
							int color = this.getTintColor();
                            return new Vector3f((float)(color >> 16 & 255) / 255.0F, (float)(color >> 8 & 255) / 255.0F, (float)(color & 255) / 255.0F);
						}
					});
				}
			};
		});
		LIME_DYED_WATER = FLUIDS.register("lime_dyed_water", () -> {
            return new ForgeFlowingFluid.Source(LIMEDYEDWATERFluidProperties());
        });
		FLOWING_LIME_DYED_WATER = FLUIDS.register("flowing_lime_dyed_water", () -> {
            return new ForgeFlowingFluid.Flowing(LIMEDYEDWATERFluidProperties());
        });
		LIME_DYED_WATER_BLOCK = BLOCKS.register("lime_dyed_water_block",() -> {
			return new LiquidBlock(AllFluids.LIME_DYED_WATER, BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
		});
		// -----------------------------------------------------------------------------
		CYAN_DYED_WATER_FLUID_TYPE = FLUID_TYPES.register("cyan_dyed_water", () -> {
			return new FluidType(Properties.create().fallDistanceModifier(0F).canExtinguish(true).supportsBoating(true).canHydrate(true).canPushEntity(true).pathType(BlockPathTypes.WATER).motionScale(0.007D).canConvertToSource(true)
          		.sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)) {
				public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
					consumer.accept(new IClientFluidTypeExtensions() {
                        private static final ResourceLocation
                                STILL_TEXTURE = new ResourceLocation("create_more_farmables:block/dyed_water"),
                                FLOWING_TEXTURE = new ResourceLocation("create_more_farmables:block/flowing_dyed_water");

                        public ResourceLocation getStillTexture() {
                            return STILL_TEXTURE;
                        }

                        public ResourceLocation getFlowingTexture() {
                            return FLOWING_TEXTURE;
                        }

                        public int getTintColor() {
                            return -15295332;
                        }
						public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
							int color = this.getTintColor();
                            return new Vector3f((float)(color >> 16 & 255) / 255.0F, (float)(color >> 8 & 255) / 255.0F, (float)(color & 255) / 255.0F);
						}
                    });
				}
			};
		});
		CYAN_DYED_WATER = FLUIDS.register("cyan_dyed_water", () -> {
            return new ForgeFlowingFluid.Source(CYANDYEDWATERFluidProperties());
        });
		FLOWING_CYAN_DYED_WATER = FLUIDS.register("flowing_cyan_dyed_water", () -> {
            return new ForgeFlowingFluid.Flowing(CYANDYEDWATERFluidProperties());
        });
		CYAN_DYED_WATER_BLOCK = BLOCKS.register("cyan_dyed_water_block",() -> {
			return new LiquidBlock(AllFluids.CYAN_DYED_WATER, BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
		});
		// -----------------------------------------------------------------------------
		LIGHT_BLUE_DYED_WATER_FLUID_TYPE = FLUID_TYPES.register("light_blue_dyed_water", () -> {
			return new FluidType(Properties.create().fallDistanceModifier(0F).canExtinguish(true).supportsBoating(true).canHydrate(true).canPushEntity(true).pathType(BlockPathTypes.WATER).motionScale(0.007D).canConvertToSource(true)
        			.sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)) {
				public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
					consumer.accept(new IClientFluidTypeExtensions() {
						private static final ResourceLocation
                                STILL_TEXTURE = new ResourceLocation("create_more_farmables:block/dyed_water"),
                                FLOWING_TEXTURE = new ResourceLocation("create_more_farmables:block/flowing_dyed_water");

                        public ResourceLocation getStillTexture() {
                            return STILL_TEXTURE;
                        }

                        public ResourceLocation getFlowingTexture() {
                            return FLOWING_TEXTURE;
                        }

                        public int getTintColor() {
                            return -12930086;
                        }
						public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
							int color = this.getTintColor();
                            return new Vector3f((float)(color >> 16 & 255) / 255.0F, (float)(color >> 8 & 255) / 255.0F, (float)(color & 255) / 255.0F);
						}
					});
				}
			};
		});
		LIGHT_BLUE_DYED_WATER = FLUIDS.register("light_blue_dyed_water", () -> {
			return new ForgeFlowingFluid.Source(LIGHTBLUEDYEDWATERFluidProperties());
		});
		FLOWING_LIGHT_BLUE_DYED_WATER = FLUIDS.register("flowing_light_blue_dyed_water", () -> {
            return new ForgeFlowingFluid.Flowing(LIGHTBLUEDYEDWATERFluidProperties());
        });
		LIGHT_BLUE_DYED_WATER_BLOCK = BLOCKS.register("light_blue_dyed_water_block",() -> {
			return new LiquidBlock(AllFluids.LIGHT_BLUE_DYED_WATER, BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
		});
		// -----------------------------------------------------------------------------
		BLUE_DYED_WATER_FLUID_TYPE = FLUID_TYPES.register("blue_dyed_water", () -> {
			return new FluidType(Properties.create().fallDistanceModifier(0F).canExtinguish(true).supportsBoating(true).canHydrate(true).canPushEntity(true).pathType(BlockPathTypes.WATER).motionScale(0.007D).canConvertToSource(true)
      			.sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)) {
				public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
					consumer.accept(new IClientFluidTypeExtensions() {
						private static final ResourceLocation
                                STILL_TEXTURE = new ResourceLocation("create_more_farmables:block/dyed_water"),
                                FLOWING_TEXTURE = new ResourceLocation("create_more_farmables:block/flowing_dyed_water");

                        public ResourceLocation getStillTexture() {
                            return STILL_TEXTURE;
                        }

                        public ResourceLocation getFlowingTexture() {
                            return FLOWING_TEXTURE;
                        }

                        public int getTintColor() {
                            return -12827478;
                        }
						public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
							int color = this.getTintColor();
                            return new Vector3f((float)(color >> 16 & 255) / 255.0F, (float)(color >> 8 & 255) / 255.0F, (float)(color & 255) / 255.0F);
						}
					});
				}
			};
		});
		BLUE_DYED_WATER = FLUIDS.register("blue_dyed_water", () -> {
            return new ForgeFlowingFluid.Source(BLUEDYEDWATERFluidProperties());
        });
		FLOWING_BLUE_DYED_WATER = FLUIDS.register("flowing_blue_dyed_water", () -> {
            return new ForgeFlowingFluid.Flowing(BLUEDYEDWATERFluidProperties());
        });
		BLUE_DYED_WATER_BLOCK = BLOCKS.register("blue_dyed_water_block",() -> {
			return new LiquidBlock(AllFluids.BLUE_DYED_WATER, BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
		});
		// -----------------------------------------------------------------------------
		PURPLE_DYED_WATER_FLUID_TYPE = FLUID_TYPES.register("purple_dyed_water", () -> {
			return new FluidType(Properties.create().fallDistanceModifier(0F).canExtinguish(true).supportsBoating(true).canHydrate(true).canPushEntity(true).pathType(BlockPathTypes.WATER).motionScale(0.007D).canConvertToSource(true)
                  .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)) {
				public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
					consumer.accept(new IClientFluidTypeExtensions() {
						private static final ResourceLocation
                                STILL_TEXTURE = new ResourceLocation("create_more_farmables:block/dyed_water"),
                                FLOWING_TEXTURE = new ResourceLocation("create_more_farmables:block/flowing_dyed_water");

                        public ResourceLocation getStillTexture() {
                            return STILL_TEXTURE;
                        }

                        public ResourceLocation getFlowingTexture() {
                            return FLOWING_TEXTURE;
                        }

                        public int getTintColor() {
                            return -7785800;
                        }
						public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
							int color = this.getTintColor();
                            return new Vector3f((float)(color >> 16 & 255) / 255.0F, (float)(color >> 8 & 255) / 255.0F, (float)(color & 255) / 255.0F);
						}
					});
				}
			};
		});
		PURPLE_DYED_WATER = FLUIDS.register("purple_dyed_water", () -> {
            return new ForgeFlowingFluid.Source(PURPLEDYEDWATERFluidProperties());
        });
		FLOWING_PURPLE_DYED_WATER = FLUIDS.register("flowing_purple_dyed_water", () -> {
            return new ForgeFlowingFluid.Flowing(PURPLEDYEDWATERFluidProperties());
        });
		PURPLE_DYED_WATER_BLOCK = BLOCKS.register("purple_dyed_water_block",() -> {
			return new LiquidBlock(AllFluids.PURPLE_DYED_WATER, BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
		});
		// -----------------------------------------------------------------------------
		MAGENTA_DYED_WATER_FLUID_TYPE = FLUID_TYPES.register("magenta_dyed_water", () -> {
			return new FluidType(Properties.create().fallDistanceModifier(0F).canExtinguish(true).supportsBoating(true).canHydrate(true).canPushEntity(true).pathType(BlockPathTypes.WATER).motionScale(0.007D).canConvertToSource(true)
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)) {
				public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
					consumer.accept(new IClientFluidTypeExtensions() {
						private static final ResourceLocation
                                STILL_TEXTURE = new ResourceLocation("create_more_farmables:block/dyed_water"),
                                FLOWING_TEXTURE = new ResourceLocation("create_more_farmables:block/flowing_dyed_water");

                        public ResourceLocation getStillTexture() {
                            return STILL_TEXTURE;
                        }

                        public ResourceLocation getFlowingTexture() {
                            return FLOWING_TEXTURE;
                        }

                        public int getTintColor() {
                            return -3715395;
                        }
						public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
							int color = this.getTintColor();
                            return new Vector3f((float)(color >> 16 & 255) / 255.0F, (float)(color >> 8 & 255) / 255.0F, (float)(color & 255) / 255.0F);
						}
					});
				}
			};
		});
		MAGENTA_DYED_WATER = FLUIDS.register("magenta_dyed_water", () -> {
            return new ForgeFlowingFluid.Source(MAGENTADYEDWATERFluidProperties());
        });
		FLOWING_MAGENTA_DYED_WATER = FLUIDS.register("flowing_magenta_dyed_water", () -> {
            return new ForgeFlowingFluid.Flowing(MAGENTADYEDWATERFluidProperties());
        });
		MAGENTA_DYED_WATER_BLOCK = BLOCKS.register("magenta_dyed_water_block",() -> {
			return new LiquidBlock(AllFluids.MAGENTA_DYED_WATER, BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
		});
		// -----------------------------------------------------------------------------
		PINK_DYED_WATER_FLUID_TYPE = FLUID_TYPES.register("pink_dyed_water", () -> {
			return new FluidType(Properties.create().fallDistanceModifier(0F).canExtinguish(true).supportsBoating(true).canHydrate(true).canPushEntity(true).pathType(BlockPathTypes.WATER).motionScale(0.007D).canConvertToSource(true)
              .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)) {
				public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
					consumer.accept(new IClientFluidTypeExtensions() {
						private static final ResourceLocation
                                STILL_TEXTURE = new ResourceLocation("create_more_farmables:block/dyed_water"),
                                FLOWING_TEXTURE = new ResourceLocation("create_more_farmables:block/flowing_dyed_water");

                        public ResourceLocation getStillTexture() {
                            return STILL_TEXTURE;
                        }

                        public ResourceLocation getFlowingTexture() {
                            return FLOWING_TEXTURE;
                        }

                        public int getTintColor() {
                            return -816214;
                        }
						public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
							int color = this.getTintColor();
                            return new Vector3f((float)(color >> 16 & 255) / 255.0F, (float)(color >> 8 & 255) / 255.0F, (float)(color & 255) / 255.0F);
						}
					});
				}
			};
		});
		PINK_DYED_WATER = FLUIDS.register("pink_dyed_water", () -> {
            return new ForgeFlowingFluid.Source(PINKDYEDWATERFluidProperties());
        });
		FLOWING_PINK_DYED_WATER = FLUIDS.register("flowing_pink_dyed_water", () -> {
            return new ForgeFlowingFluid.Flowing(PINKDYEDWATERFluidProperties());
        });
		PINK_DYED_WATER_BLOCK = BLOCKS.register("pink_dyed_water_block",() -> {
			return new LiquidBlock(AllFluids.PINK_DYED_WATER, BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
		});


	}


	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(WHITE_DYED_WATER.get(), translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_WHITE_DYED_WATER.get(), translucent());

			ItemBlockRenderTypes.setRenderLayer(BLACK_DYED_WATER.get(), translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_BLACK_DYED_WATER.get(), translucent());

            ItemBlockRenderTypes.setRenderLayer(GRAY_DYED_WATER.get(), translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_GRAY_DYED_WATER.get(), translucent());

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

