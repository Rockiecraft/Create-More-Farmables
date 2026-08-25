package net.rockiecraft.v1_20_1.foundation.fluids.waterlogging;

import net.minecraft.world.level.block.state.properties.EnumProperty;

// Blockstate property shared by every vanilla block mixed in with dyed-water waterlogging support, alongside vanilla's WATERLOGGED.
public class CmfBlockStateProperties {
    public static final EnumProperty<CmfWaterColor> CMF_WATER_COLOR =
            EnumProperty.create("cmf_water_color", CmfWaterColor.class);

    private CmfBlockStateProperties() {}
}
