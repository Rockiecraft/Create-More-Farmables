package net.rockiecraft.v1_19_2.common.forge.datagen.providers;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.rockiecraft.v1_19_2.CreateMoreFarmables;
import net.rockiecraft.v1_20_1.foundation.AllBlocks;

public class CMFBlockStateProvider extends BlockStateProvider {
    public CMFBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, CreateMoreFarmables.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        simpleBlock(AllBlocks.WOOD_STRING_WOOL_BLOCK.get());

//        simpleBlock(AllBlocks.MOLTEN_ENDSTONE.get());
//        simpleBlock(AllBlocks.LIQUID_QUARTZ.get());
//        simpleBlock(AllBlocks.LIQUID_REDSTONE.get());
//
//        simpleBlock(AllBlocks.WHITE_DYED_WATER.get());
//        simpleBlock(AllBlocks.LIGHT_GRAY_DYED_WATER.get());
//        simpleBlock(AllBlocks.GRAY_DYED_WATER.get());
//        simpleBlock(AllBlocks.BLACK_DYED_WATER.get());
//        simpleBlock(AllBlocks.BROWN_DYED_WATER.get());
//        simpleBlock(AllBlocks.RED_DYED_WATER.get());
//        simpleBlock(AllBlocks.ORANGE_DYED_WATER.get());
//        simpleBlock(AllBlocks.YELLOW_DYED_WATER.get());
//        simpleBlock(AllBlocks.GREEN_DYED_WATER.get());
//        simpleBlock(AllBlocks.LIME_DYED_WATER.get());
//        simpleBlock(AllBlocks.CYAN_DYED_WATER.get());
//        simpleBlock(AllBlocks.LIGHT_BLUE_DYED_WATER.get());
//        simpleBlock(AllBlocks.BLUE_DYED_WATER.get());
//        simpleBlock(AllBlocks.PURPLE_DYED_WATER.get());
//        simpleBlock(AllBlocks.MAGENTA_DYED_WATER.get());
//        simpleBlock(AllBlocks.PINK_DYED_WATER.get());
    }
}
