package net.rockiecraft.create_more_farmables.block;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.rockiecraft.create_more_farmables.AllFluids;

public class GreenDyedWaterBlock extends LiquidBlock {
    public GreenDyedWaterBlock() {
       super(AllFluids.GREEN_DYED_WATER, Properties.of().mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
   }

}
