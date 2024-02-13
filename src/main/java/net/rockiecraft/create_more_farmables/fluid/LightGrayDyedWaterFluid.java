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

public abstract class LightGrayDyedWaterFluid extends ForgeFlowingFluid{

    public static final Properties PROPERTIES = new Properties(AllFluidTypes.LIGHT_GRAY_DYED_WATER_TYPE, AllFluids.LIGHT_GRAY_DYED_WATER,
            AllFluids.FLOWING_LIGHT_GRAY_DYED_WATER).explosionResistance(100f).bucket(AllItems.LIGHT_GRAY_DYED_WATER_BUCKET).block(() -> (LiquidBlock) AllBlocks.LIGHT_GRAY_DYED_WATER.get());



    private LightGrayDyedWaterFluid() {
        super(PROPERTIES);
    }

    public static class Source extends LightGrayDyedWaterFluid {
        public int getAmount(FluidState state) {
            return 8;
        }

        public boolean isSource(FluidState state) {
            return true;
        }
    }

    public static class Flowing extends LightGrayDyedWaterFluid {
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
