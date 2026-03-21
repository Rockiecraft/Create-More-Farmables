package net.rockiecraft.foundaton;


import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.botarium.api.registry.fluid.BotariumLiquidBlock;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.rockiecraft.CreateMoreFarmables;
import net.rockiecraft.foundaton.registry.fluids.AllFluidProperties;
import net.rockiecraft.foundaton.registry.blocks.fluids.LiquidQuartzLiquidBlock;
import net.rockiecraft.foundaton.registry.blocks.fluids.LiquidRedstoneLiquidBlock;
import net.rockiecraft.foundaton.registry.blocks.fluids.MoltenEndstoneLiquidBlock;
import net.minecraft.world.level.block.*;

public class AllBlocks {


    public static final ResourcefulRegistry<Block> BLOCKS = ResourcefulRegistries.create(Registry.BLOCK, CreateMoreFarmables.MOD_ID);
    public static final ResourcefulRegistry<Block> FLUIDS = ResourcefulRegistries.create(BLOCKS);


    public static final RegistryEntry<Block> WOOD_STRING_WOOL_BLOCK = BLOCKS.register("wood_string_wool_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));

//    public static final RegistryEntry<Block> _BLOCK  = FLUIDS.register("_block",
//    () -> new BotariumLiquidBlock(AllFluidProperties.YOURFLUID, BlockBehaviour.Properties.copy(Blocks.WATER).liquid()));

//    public static final RegistryEntry<Block> OXYGEN = FLUIDS.register("oxygen",
//    () -> new BotariumLiquidBlock(AllFluidProperties.LIQUID_QUARTZ, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryEntry<Block> LIQUID_QUARTZ  = AllBlocks.BLOCKS.register("liquid_quartz",
            () -> new LiquidQuartzLiquidBlock(AllFluidProperties.LIQUID_QUARTZ, BlockBehaviour.Properties.copy(Blocks.LAVA)));
    public static final RegistryEntry<Block> LIQUID_REDSTONE = AllBlocks.BLOCKS.register("liquid_redstone",
            () -> new LiquidRedstoneLiquidBlock(AllFluidProperties.LIQUID_REDSTONE, BlockBehaviour.Properties.copy(Blocks.LAVA)));
//    public static final RegistryEntry<Block> MOLTEN_ENDSTONE = FLUIDS.register("molten_endstone",
//            () -> new LiquidRedstoneLiquidBlock(AllFluidProperties.MOLTEN_ENDSTONE, BlockBehaviour.Properties.copy(Blocks.LAVA));

    public static final RegistryEntry<Block> MOLTEN_ENDSTONE = AllBlocks.BLOCKS.register("molten_endstone",
            () -> new BotariumLiquidBlock(AllFluidProperties.MOLTEN_ENDSTONE, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryEntry<Block> WHITE_DYED_WATER = AllBlocks.BLOCKS.register("white_dyed_water",
            () -> new BotariumLiquidBlock(AllFluidProperties.WHITE_DYED_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryEntry<Block> LIGHT_GRAY_DYED_WATER = AllBlocks.BLOCKS.register("light_gray_dyed_water",
            () -> new BotariumLiquidBlock(AllFluidProperties.LIGHT_GRAY_DYED_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryEntry<Block> GRAY_DYED_WATER = AllBlocks.BLOCKS.register("gray_dyed_water",
            () -> new BotariumLiquidBlock(AllFluidProperties.GRAY_DYED_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryEntry<Block> BLACK_DYED_WATER= AllBlocks.BLOCKS.register("black_dyed_water",
            () -> new BotariumLiquidBlock(AllFluidProperties.BLACK_DYED_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryEntry<Block> BROWN_DYED_WATER = AllBlocks.BLOCKS.register("brown_dyed_water",
            () -> new BotariumLiquidBlock(AllFluidProperties.BROWN_DYED_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryEntry<Block> RED_DYED_WATER = AllBlocks.BLOCKS.register("red_dyed_water",
            () -> new BotariumLiquidBlock(AllFluidProperties.RED_DYED_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryEntry<Block> ORANGE_DYED_WATER = AllBlocks.BLOCKS.register("orange_dyed_water",
            () -> new BotariumLiquidBlock(AllFluidProperties.ORANGE_DYED_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryEntry<Block> YELLOW_DYED_WATER = AllBlocks.BLOCKS.register("yellow_dyed_water",
            () -> new BotariumLiquidBlock(AllFluidProperties.YELLOW_DYED_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryEntry<Block> GREEN_DYED_WATER = AllBlocks.BLOCKS.register("green_dyed_water",
            () -> new BotariumLiquidBlock(AllFluidProperties.GREEN_DYED_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryEntry<Block> LIME_DYED_WATER = AllBlocks.BLOCKS.register("lime_dyed_water",
            () -> new BotariumLiquidBlock(AllFluidProperties.LIME_DYED_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryEntry<Block> CYAN_DYED_WATER = AllBlocks.BLOCKS.register("cyan_dyed_water",
            () -> new BotariumLiquidBlock(AllFluidProperties.CYAN_DYED_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryEntry<Block> LIGHT_BLUE_DYED_WATER = AllBlocks.BLOCKS.register("light_blue_dyed_water",
            () -> new BotariumLiquidBlock(AllFluidProperties.LIGHT_BLUE_DYED_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryEntry<Block> BLUE_DYED_WATER = AllBlocks.BLOCKS.register("blue_dyed_water",
            () -> new BotariumLiquidBlock(AllFluidProperties.BLUE_DYED_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryEntry<Block> PURPLE_DYED_WATER = AllBlocks.BLOCKS.register("purple_dyed_water",
            () -> new BotariumLiquidBlock(AllFluidProperties.PURPLE_DYED_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryEntry<Block> MAGENTA_DYED_WATER = AllBlocks.BLOCKS.register("magenta_dyed_water",
            () -> new BotariumLiquidBlock(AllFluidProperties.MAGENTA_DYED_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryEntry<Block> PINK_DYED_WATER = AllBlocks.BLOCKS.register("pink_dyed_water",
            () -> new BotariumLiquidBlock(AllFluidProperties.PINK_DYED_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)));


    public static void init() {
        AllBlocks.FLUIDS.init();
        AllBlocks.BLOCKS.init();
    }



}
