package net.rockiecraft.create_more_farmables;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import net.rockiecraft.create_more_farmables.fluids.AllFluids;

public class CreateMoreFarmablesClient implements ClientModInitializer {
    public static final String ID = "create_more_farmables";
    @Override
    public void onInitializeClient() {

        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.STILL_MOLTEN_ENDSTONE, AllFluids.FLOWING_MOLTEN_ENDSTONE,
                new SimpleFluidRenderHandler(
                        new Identifier("create_more_farmables:block/molten_endstone"),
                        new Identifier("create_more_farmables:block/flowing_molten_endstone"),
                        -425955
                ));
        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.STILL_WHITE_DYED_WATER, AllFluids.FLOWING_WHITE_DYED_WATER,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),
                        -393218
                ));

        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.STILL_LIGHT_GRAY_DYED_WATER, AllFluids.FLOWING_LIGHT_GRAY_DYED_WATER,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),
                        -6447721
                ));

        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.STILL_GRAY_DYED_WATER, AllFluids.FLOWING_GRAY_DYED_WATER,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),
                        -12103854
                ));

        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.STILL_BLACK_DYED_WATER, AllFluids.FLOWING_BLACK_DYED_WATER,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),
                        -14869215
                ));

        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.STILL_BROWN_DYED_WATER, AllFluids.FLOWING_BROWN_DYED_WATER,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),
                        -8170446
                ));

        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.STILL_RED_DYED_WATER, AllFluids.FLOWING_RED_DYED_WATER,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),
                        -5231066
                ));

        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.STILL_ORANGE_DYED_WATER, AllFluids.FLOWING_ORANGE_DYED_WATER,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),
                        -425955
                ));

        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.STILL_YELLOW_DYED_WATER, AllFluids.FLOWING_YELLOW_DYED_WATER,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),
                        -75715
                ));

        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.STILL_GREEN_DYED_WATER, AllFluids.FLOWING_GREEN_DYED_WATER,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),
                        -10585066
                ));

        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.STILL_LIME_DYED_WATER, AllFluids.FLOWING_LIME_DYED_WATER,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),
                        -8337633
                ));

        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.STILL_CYAN_DYED_WATER, AllFluids.FLOWING_CYAN_DYED_WATER,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),
                        -15295332
                ));

        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.STILL_LIGHT_BLUE_DYED_WATER, AllFluids.FLOWING_LIGHT_BLUE_DYED_WATER,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),

                        -12930086
                ));

        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.STILL_BLUE_DYED_WATER, AllFluids.FLOWING_BLUE_DYED_WATER,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),

                        -12827478
                ));

        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.STILL_PURPLE_DYED_WATER, AllFluids.FLOWING_PURPLE_DYED_WATER,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),

                        -7785800
                ));

        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.STILL_MAGENTA_DYED_WATER, AllFluids.FLOWING_MAGENTA_DYED_WATER,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),

                        -3715395
                ));

        FluidRenderHandlerRegistry.INSTANCE.register(AllFluids.STILL_PINK_DYED_WATER, AllFluids.FLOWING_PINK_DYED_WATER,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),

                        -816214
                ));






        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                AllFluids.STILL_WHITE_DYED_WATER, AllFluids.FLOWING_WHITE_DYED_WATER);

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                AllFluids.STILL_LIGHT_GRAY_DYED_WATER, AllFluids.FLOWING_LIGHT_GRAY_DYED_WATER);

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                AllFluids.STILL_GRAY_DYED_WATER, AllFluids.FLOWING_GRAY_DYED_WATER);

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                AllFluids.STILL_BLACK_DYED_WATER, AllFluids.FLOWING_BLACK_DYED_WATER);

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                AllFluids.STILL_BROWN_DYED_WATER, AllFluids.FLOWING_BROWN_DYED_WATER);

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                AllFluids.STILL_RED_DYED_WATER, AllFluids.FLOWING_RED_DYED_WATER);

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                AllFluids.STILL_ORANGE_DYED_WATER, AllFluids.FLOWING_ORANGE_DYED_WATER);

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                AllFluids.STILL_YELLOW_DYED_WATER, AllFluids.FLOWING_YELLOW_DYED_WATER);

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                AllFluids.STILL_GREEN_DYED_WATER, AllFluids.FLOWING_GREEN_DYED_WATER);

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                AllFluids.STILL_LIME_DYED_WATER, AllFluids.FLOWING_LIME_DYED_WATER);

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                AllFluids.STILL_CYAN_DYED_WATER, AllFluids.FLOWING_CYAN_DYED_WATER);

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                AllFluids.STILL_LIGHT_BLUE_DYED_WATER, AllFluids.FLOWING_LIGHT_BLUE_DYED_WATER);

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                AllFluids.STILL_BLUE_DYED_WATER, AllFluids.FLOWING_BLUE_DYED_WATER);

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                AllFluids.STILL_PURPLE_DYED_WATER, AllFluids.FLOWING_PURPLE_DYED_WATER);

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                AllFluids.STILL_MAGENTA_DYED_WATER, AllFluids.FLOWING_MAGENTA_DYED_WATER);

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                AllFluids.STILL_PINK_DYED_WATER, AllFluids.FLOWING_PINK_DYED_WATER);
    }
}
