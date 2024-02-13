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

public abstract class MoltenEndstoneFluid extends ForgeFlowingFluid {
    public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(AllFluidTypes.MOLTEN_ENDSTONE_TYPE, AllFluids.MOLTEN_ENDSTONE,
            AllFluids.FLOWING_MOLTEN_ENDSTONE).explosionResistance(100f).bucket(AllItems.MOLTEN_ENDSTONE_BUCKET).block(() -> (LiquidBlock) AllBlocks.MOLTEN_ENDSTONE.get());



    private MoltenEndstoneFluid() {
        super(PROPERTIES);
    }

    public static class Source extends MoltenEndstoneFluid {
        public int getAmount(FluidState state) {
            return 8;
        }

        public boolean isSource(FluidState state) {
            return true;
        }
    }

    public static class Flowing extends MoltenEndstoneFluid {
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

