package net.rockiecraft.create_more_farmables.Datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.rockiecraft.create_more_farmables.AllBlocks;
import net.rockiecraft.create_more_farmables.AllFluids;
import net.rockiecraft.create_more_farmables.CreateMoreFarmables;


public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CreateMoreFarmables.ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(AllBlocks.WOOD_STRING_WOOL_BLOCK);

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

}
