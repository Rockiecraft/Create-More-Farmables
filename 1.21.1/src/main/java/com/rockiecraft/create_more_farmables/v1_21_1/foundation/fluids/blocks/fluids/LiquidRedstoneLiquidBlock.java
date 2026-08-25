package com.rockiecraft.create_more_farmables.v1_21_1.foundation.fluids.blocks.fluids;

import com.rockiecraft.create_more_farmables.v1_21_1.foundation.damagetypes.AllDamageSources;
import com.rockiecraft.create_more_farmables.v1_21_1.infrastructure.config.CreateMoreFarmablesConfig;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;

import java.util.function.Supplier;

public class LiquidRedstoneLiquidBlock extends AbstractMoltenLiquidBlock {

    public LiquidRedstoneLiquidBlock(Supplier<? extends FlowingFluid> fluid, Properties properties) {
        super(fluid, properties, AllDamageSources.LIQUID_REDSTONE);
    }

    @Override
    protected boolean isInteractionEnabled() {
        return CreateMoreFarmablesConfig.CreateMoreFarmables_fluid_interactions.ToggleAllInteractions
            && CreateMoreFarmablesConfig.CreateMoreFarmables_fluid_interactions.LiquidRedstoneInteraction;
    }

    @Override
    protected String getConversionBlockId() {
        return CreateMoreFarmablesConfig.CreateMoreFarmables_fluid_interactions.LiquidRedstoneConversionBlock;
    }

    @Override
    protected BlockState getFallbackConversion() {
        return Blocks.REDSTONE_BLOCK.defaultBlockState();
    }
}
