package net.rockiecraft.v1_20_1.foundation.fluids.waterlogging;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.rockiecraft.v1_20_1.foundation.AllFluids;

// Central logic for whether a waterloggable block can hold dyed water and which color it's holding, kept out of the mixins.
public class CmfWaterloggingHelper {

    private CmfWaterloggingHelper() {}

    // True for Fluids.WATER itself or any of our 16 dyed-water source/flowing fluids.
    public static boolean isWaterOrDyedWater(Fluid fluid) {
        if (fluid == Fluids.WATER) return true;
        return colorOf(fluid) != null;
    }

    // Null if fluid isn't one of our dyed waters.
    private static DyeColor colorOf(Fluid fluid) {
        for (DyeColor color : DyeColor.values()) {
            AllFluids.Registered reg = AllFluids.DYED_WATER_BY_COLOR.get(color);
            if (fluid == reg.source().get() || fluid == reg.flowing().get()) return color;
        }
        return null;
    }

    public static CmfWaterColor colorForPlacedFluid(Fluid fluid) {
        return CmfWaterColor.fromDyeColor(colorOf(fluid));
    }

    // The fluid state a waterlogged block should report via getFluidState(), based on its CMF_WATER_COLOR.
    public static FluidState getColoredFluidState(BlockState state) {
        if (!state.hasProperty(CmfBlockStateProperties.CMF_WATER_COLOR)) {
            return Fluids.WATER.getSource(false);
        }
        CmfWaterColor color = state.getValue(CmfBlockStateProperties.CMF_WATER_COLOR);
        if (color == CmfWaterColor.NONE) {
            return Fluids.WATER.getSource(false);
        }
        AllFluids.Registered reg = AllFluids.DYED_WATER_BY_COLOR.get(color.dyeColor());
        if (reg == null) {
            // Falls back rather than throws, since this runs on every fluid tick - a thrown exception here would leave the fluid permanently stuck.
            return Fluids.WATER.getSource(false);
        }
        return ((net.minecraft.world.level.material.FlowingFluid) reg.source().get()).getSource(false);
    }

    // True if pos already has a horizontal neighbor holding a real source of this exact fluid, letting spring formation work across waterlogged blocks like vanilla.
    public static boolean hasSpringEligibleSourceNeighbor(net.minecraft.world.level.BlockGetter level, net.minecraft.core.BlockPos pos, Fluid fluid) {
        for (net.minecraft.core.Direction direction : net.minecraft.core.Direction.Plane.HORIZONTAL) {
            FluidState neighborState = level.getFluidState(pos.relative(direction));
            if (neighborState.getType() == fluid && neighborState.isSource()) {
                return true;
            }
        }
        return false;
    }

    // The bucket item to hand back when scooping this waterlogged state's contents.
    public static net.minecraft.world.item.Item bucketItemFor(BlockState state) {
        if (!state.hasProperty(CmfBlockStateProperties.CMF_WATER_COLOR)) {
            return net.minecraft.world.item.Items.WATER_BUCKET;
        }
        CmfWaterColor color = state.getValue(CmfBlockStateProperties.CMF_WATER_COLOR);
        if (color == CmfWaterColor.NONE) {
            return net.minecraft.world.item.Items.WATER_BUCKET;
        }
        AllFluids.Registered reg = AllFluids.DYED_WATER_BY_COLOR.get(color.dyeColor());
        if (reg == null) {
            return net.minecraft.world.item.Items.WATER_BUCKET;
        }
        return reg.bucket().get();
    }
}
