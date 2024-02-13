package net.rockiecraft.create_more_farmables.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.rockiecraft.create_more_farmables.AllBlocks;
import net.rockiecraft.create_more_farmables.AllFluidTypes;
import net.rockiecraft.create_more_farmables.AllFluids;
import net.rockiecraft.create_more_farmables.AllItems;

public abstract class BlueDyedWaterFluid extends ForgeFlowingFluid{

    public static final Properties PROPERTIES = new Properties(AllFluidTypes.BLUE_DYED_WATER_TYPE, AllFluids.BLUE_DYED_WATER,
            AllFluids.FLOWING_BLUE_DYED_WATER).explosionResistance(100f).bucket(AllItems.BLUE_DYED_WATER_BUCKET).block(() -> (LiquidBlock) AllBlocks.BLUE_DYED_WATER.get());



    private BlueDyedWaterFluid() {
        super(PROPERTIES);
    }

    public static class Source extends BlueDyedWaterFluid {
        public int getAmount(FluidState state) {
            return 8;
        }

        public boolean isSource(FluidState state) {
            return true;
        }
    }

    public static class Flowing extends BlueDyedWaterFluid {
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
        }

        public boolean isSource(FluidState state) {
            return false;
        }
    }
}
