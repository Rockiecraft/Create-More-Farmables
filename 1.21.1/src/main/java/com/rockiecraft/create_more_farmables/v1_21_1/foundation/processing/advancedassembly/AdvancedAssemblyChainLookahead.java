package com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.advancedassembly;

import com.simibubi.create.content.kinetics.belt.BeltBlockEntity;
import com.simibubi.create.content.kinetics.crusher.CrushingWheelControllerBlockEntity;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

import java.util.List;

public final class AdvancedAssemblyChainLookahead {

    private AdvancedAssemblyChainLookahead() {
    }

    private static final int MAX_SCAN_DISTANCE = 48;

    private static final int PERPENDICULAR_RADIUS = 1;


    private static final int MAX_FAN_STREAM_DISTANCE = 8;

    public static boolean verifyRemainingSteps(Level level, BlockPos scanFrom, Direction direction,
                                               List<AdvancedAssemblyStep> sequence, int fromStepIndexInclusive) {
        if (direction.getAxis().isVertical()) {
            // A fan mounted above (or below) the belt blows across the assembly line instead of
            // along it, so the remaining steps have to be scanned along the belt's own travel
            // direction, starting from the belt itself.
            BeltBlockEntity belt = findBeltInStream(level, scanFrom, direction);
            if (belt == null)
                return false;
            scanFrom = belt.getBlockPos();
            direction = belt.getMovementFacing();
        }

        BlockPos cursor = scanFrom;

        for (int stepIndex = fromStepIndexInclusive; stepIndex < sequence.size(); stepIndex++) {
            AdvancedAssemblyStep step = sequence.get(stepIndex);
            boolean found = false;
            BlockPos matchedAt = null;

            for (int scanned = 0; scanned < MAX_SCAN_DISTANCE; scanned++) {
                cursor = cursor.relative(direction);
                BlockPos hit = findMatchInCrossSection(level, cursor, direction, step);
                if (hit != null) {
                    found = true;
                    matchedAt = hit;
                    break;
                }
            }


            if (!found) {
                return false;
            }
        }


        return true;
    }

    private static BlockPos findMatchInCrossSection(Level level, BlockPos center, Direction direction,
                                                    AdvancedAssemblyStep step) {
        Direction.Axis scanAxis = direction.getAxis();

        for (int a = -PERPENDICULAR_RADIUS; a <= PERPENDICULAR_RADIUS; a++) {
            for (int b = -PERPENDICULAR_RADIUS; b <= PERPENDICULAR_RADIUS; b++) {
                BlockPos candidate = offsetPerpendicular(center, scanAxis, a, b);
                if (stepMatchesAt(level, candidate, step))
                    return candidate;
            }
        }
        return null;
    }

    private static BlockPos offsetPerpendicular(BlockPos center, Direction.Axis scanAxis, int a, int b) {
        return switch (scanAxis) {
            case X -> center.offset(0, a, b);
            case Y -> center.offset(a, 0, b);
            case Z -> center.offset(a, b, 0);
        };
    }


    private static BeltBlockEntity findBeltInStream(Level level, BlockPos scanFrom, Direction streamDirection) {
        for (int i = 0; i <= MAX_FAN_STREAM_DISTANCE; i++) {
            BlockPos pos = scanFrom.relative(streamDirection, i);
            for (int below = 0; below <= 1; below++) {
                if (level.getBlockEntity(pos.below(below)) instanceof BeltBlockEntity belt)
                    return belt;
            }
        }
        return null;
    }

    private static boolean stepMatchesAt(Level level, BlockPos pos, AdvancedAssemblyStep step) {
        FanProcessingType fanType = FanProcessingType.getAt(level, pos);
        if (fanType != null && step.matchesFanType(fanType))
            return true;

        if (step.isCrushingStep()) {
            if (isCrushingWheelControllerAt(level, pos))
                return true;

            for (Direction side : Direction.values())
                if (isCrushingWheelControllerAt(level, pos.relative(side)))
                    return true;
        }

        return false;
    }

    private static boolean isCrushingWheelControllerAt(Level level, BlockPos pos) {
        BlockEntity be = level.getBlockEntity(pos);
        return be instanceof CrushingWheelControllerBlockEntity;
    }
}