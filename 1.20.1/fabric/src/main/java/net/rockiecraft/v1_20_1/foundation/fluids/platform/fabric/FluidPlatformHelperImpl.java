package net.rockiecraft.v1_20_1.foundation.fluids.platform.fabric;

import dev.architectury.core.fluid.ArchitecturyFlowingFluid;
import dev.architectury.core.fluid.SimpleArchitecturyFluidAttributes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.rockiecraft.v1_20_1.CreateMoreFarmables;

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
        // No-op, same as Forge - no manual sprite registration needed. Since 1.19.3, vanilla's
        // textures/block/, and directory sources scan *every* namespace's textures folder, not
        // just vanilla's. Our fluid textures already live under
        // assets/create_more_farmables/textures/block/, so they're auto-included in the block
        // atlas with no registration code at all. This is also why the old Fabric Textures API
        // (ClientSpriteRegistryCallback, this method's previous implementation) was removed
        // entirely as of 1.19.3 - it existed to solve exactly this problem, and vanilla now
        // solves it by default.
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
                .of(() -> BuiltInRegistries.FLUID.get(flowingId), () -> BuiltInRegistries.FLUID.get(sourceId))
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
                .bucketItem(() -> Optional.of(BuiltInRegistries.ITEM.get(bucketId)))
                .block(() -> {
                    Block block = BuiltInRegistries.BLOCK.get(blockId);
                    return block instanceof LiquidBlock liquidBlock
                            ? Optional.of(liquidBlock)
                            : Optional.<LiquidBlock>empty();
                })
                .fillSound(lavaLike ? SoundEvents.BUCKET_FILL_LAVA : SoundEvents.BUCKET_FILL)
                .emptySound(lavaLike ? SoundEvents.BUCKET_EMPTY_LAVA : SoundEvents.BUCKET_EMPTY);
    }
}