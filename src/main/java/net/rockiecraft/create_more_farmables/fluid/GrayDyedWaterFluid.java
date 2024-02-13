package net.rockiecraft.create_more_farmables.fluid;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.rockiecraft.create_more_farmables.AllBlocks;
import net.rockiecraft.create_more_farmables.AllFluidTypes;
import net.rockiecraft.create_more_farmables.AllFluids;
import net.rockiecraft.create_more_farmables.AllItems;

public abstract class GrayDyedWaterFluid extends ForgeFlowingFluid{

    public static final Properties PROPERTIES = new Properties(AllFluidTypes.GREY_DYED_WATER_TYPE, AllFluids.GREY_DYED_WATER,
            AllFluids.FLOWING_GREY_DYED_WATER).explosionResistance(100f).bucket(AllItems.GRAY_DYED_WATER_BUCKET).block(() -> (LiquidBlock) AllBlocks.GREY_DYED_WATER.get());



    private GrayDyedWaterFluid() {
        super(PROPERTIES);
    }

    public static class Source extends GrayDyedWaterFluid {
        public int getAmount(FluidState state) {
            return 8;
        }

        public boolean isSource(FluidState state) {
            return true;
        }
    }

    public static class Flowing extends GrayDyedWaterFluid {
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
