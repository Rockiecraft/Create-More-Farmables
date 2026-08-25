package net.rockiecraft.v1_20_1.foundation.fluids.platform.fabric;

import dev.architectury.core.fluid.ArchitecturyFlowingFluid;
import dev.architectury.core.fluid.SimpleArchitecturyFluidAttributes;
import dev.architectury.event.events.client.ClientTextureStitchEvent;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.rockiecraft.v1_19_2.CreateMoreFarmables;

import java.util.Optional;

public class FluidPlatformHelperImpl {

    public static FlowingFluid createSourceFluid(
            String name, int density, int viscosity, int tint, int temperature, int tickRate,
            int lightLevel, double motionScale, boolean canSwim, boolean canDrown,
            boolean canConvertToSource, BlockPathTypes pathType,
            ResourceLocation stillTexture, ResourceLocation flowingTexture, ResourceLocation overlay) {
        return new ArchitecturyFlowingFluid.Source(buildAttributes(
                name, density, viscosity, tint, temperature, tickRate, lightLevel,
                canConvertToSource, pathType, stillTexture, flowingTexture, overlay));
    }

    public static FlowingFluid createFlowingFluid(
            String name, int density, int viscosity, int tint, int temperature, int tickRate,
            int lightLevel, double motionScale, boolean canSwim, boolean canDrown,
            boolean canConvertToSource, BlockPathTypes pathType,
            ResourceLocation stillTexture, ResourceLocation flowingTexture, ResourceLocation overlay) {
        return new ArchitecturyFlowingFluid.Flowing(buildAttributes(
                name, density, viscosity, tint, temperature, tickRate, lightLevel,
                canConvertToSource, pathType, stillTexture, flowingTexture, overlay));
    }

    public static void registerClientRendering(
            String name, ResourceLocation stillTexture, ResourceLocation flowingTexture,
            ResourceLocation overlay, int tint) {
        // Render handler/tint is already wired automatically (see class javadoc) - this only
        ClientTextureStitchEvent.PRE.register((atlas, spriteAdder) -> {
            if (atlas.location().equals(TextureAtlas.LOCATION_BLOCKS)) {
                spriteAdder.accept(stillTexture);
                spriteAdder.accept(flowingTexture);
                if (overlay != null) {
                    spriteAdder.accept(overlay);
                }
            }
        });
    }

    private static SimpleArchitecturyFluidAttributes buildAttributes(
            String name, int density, int viscosity, int tint, int temperature, int tickRate,
            int lightLevel, boolean canConvertToSource, BlockPathTypes pathType,
            ResourceLocation stillTexture, ResourceLocation flowingTexture, ResourceLocation overlay) {
        ResourceLocation sourceId = new ResourceLocation(CreateMoreFarmables.MOD_ID, name);
        ResourceLocation flowingId = new ResourceLocation(CreateMoreFarmables.MOD_ID, "flowing_" + name);
        ResourceLocation blockId = new ResourceLocation(CreateMoreFarmables.MOD_ID, name);
        ResourceLocation bucketId = new ResourceLocation(CreateMoreFarmables.MOD_ID, name + "_bucket");
        boolean lavaLike = pathType == BlockPathTypes.LAVA;

        return SimpleArchitecturyFluidAttributes
                .of(() -> Registry.FLUID.get(flowingId), () -> Registry.FLUID.get(sourceId))
                .convertToSource(canConvertToSource)
                .tickDelay(tickRate)
                .density(density)
                .viscosity(viscosity)
                .temperature(temperature)
                .luminosity(lightLevel)
                .color(tint)
                .sourceTexture(stillTexture)
                .flowingTexture(flowingTexture)
                .overlayTexture(overlay)
                // Vanilla's real slopeFindDistance/dropOff: water is 4/1, lava is 2/2 in the
                // overworld - mirrored here per pathType rather than left at the water-shaped
                // 4/1 default for every fluid regardless of lava-likeness.
                .slopeFindDistance(lavaLike ? 2 : 4)
                .dropOff(lavaLike ? 2 : 1)
                .bucketItem(() -> Optional.of(Registry.ITEM.get(bucketId)))
                .block(() -> {
                    Block block = Registry.BLOCK.get(blockId);
                    return block instanceof LiquidBlock liquidBlock
                            ? Optional.of(liquidBlock)
                            : Optional.<LiquidBlock>empty();
                })
                .fillSound(lavaLike ? SoundEvents.BUCKET_FILL_LAVA : SoundEvents.BUCKET_FILL)
                .emptySound(lavaLike ? SoundEvents.BUCKET_EMPTY_LAVA : SoundEvents.BUCKET_EMPTY);
    }
}