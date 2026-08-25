package net.rockiecraft.v1_20_1.foundation.fluids.platform;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.pathfinder.BlockPathTypes;

// Platform-specific fluid registration: source/flowing fluid creation and client render registration differ between Forge and Fabric.
public class FluidPlatformHelper {

    @ExpectPlatform
    public static FlowingFluid createSourceFluid(
            String name, int density, int viscosity, int tint, int temperature, int tickRate,
            int lightLevel, double motionScale, boolean canSwim, boolean canDrown,
            boolean canConvertToSource, BlockPathTypes pathType,
            ResourceLocation stillTexture, ResourceLocation flowingTexture, ResourceLocation overlay) {
        throw new AssertionError("FluidPlatformHelper not implemented on this platform");
    }

    @ExpectPlatform
    public static FlowingFluid createFlowingFluid(
            String name, int density, int viscosity, int tint, int temperature, int tickRate,
            int lightLevel, double motionScale, boolean canSwim, boolean canDrown,
            boolean canConvertToSource, BlockPathTypes pathType,
            ResourceLocation stillTexture, ResourceLocation flowingTexture, ResourceLocation overlay) {
        throw new AssertionError("FluidPlatformHelper not implemented on this platform");
    }

    @ExpectPlatform
    public static void registerClientRendering(
            String name, ResourceLocation stillTexture, ResourceLocation flowingTexture,
            ResourceLocation overlay, int tint) {
        throw new AssertionError("FluidPlatformHelper not implemented on this platform");
    }
}
