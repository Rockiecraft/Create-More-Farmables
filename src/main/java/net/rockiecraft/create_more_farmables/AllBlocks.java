package net.rockiecraft.create_more_farmables;


import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.rockiecraft.create_more_farmables.block.*;

public class AllBlocks {
    public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, CreateMoreFarmables.ID);
    /**
     * replace "MOLTEN_ENDSTONE_" with the name of the custom liquid you wish to create a block of.
     * keep in mind that the name is case-sensitive.
      */
    public static final RegistryObject<Block> MOLTEN_ENDSTONE = REGISTRY.register("molten_endstone", () -> new MoltenEndstoneBlock());

    public static final RegistryObject<Block> WHITE_DYED_WATER = REGISTRY.register("white_dyed_water", () -> new WhiteDyedWaterBlock());

    public static final RegistryObject<Block> BLACK_DYED_WATER = REGISTRY.register("black_dyed_water", () -> new BlackDyedWaterBlock());

    public static final RegistryObject<Block> GRAY_DYED_WATER = REGISTRY.register("gray_dyed_water", () -> new GrayDyedWaterBlock());

    public static final RegistryObject<Block> BLUE_DYED_WATER = REGISTRY.register("blue_dyed_water", () -> new BlueDyedWaterBlock());

    public static final RegistryObject<Block> RED_DYED_WATER = REGISTRY.register("red_dyed_water", () -> new RedDyedWaterBlock());

    public static final RegistryObject<Block> PURPLE_DYED_WATER = REGISTRY.register("purple_dyed_water", () -> new PurpleDyedWaterBlock());

    public static final RegistryObject<Block> PINK_DYED_WATER = REGISTRY.register("pink_dyed_water", () -> new PinkDyedWaterBlock());

    public static final RegistryObject<Block> MAGENTA_DYED_WATER = REGISTRY.register("magenta_dyed_water", () -> new MagentaDyedWaterBlock());

    public static final RegistryObject<Block> LIGHT_GRAY_DYED_WATER = REGISTRY.register("light_gray_dyed_water", () -> new LightGrayDyedWaterBlock());

    public static final RegistryObject<Block> GREEN_DYED_WATER = REGISTRY.register("green_dyed_water", () -> new GreenDyedWaterBlock());

    public static final RegistryObject<Block> LIME_DYED_WATER = REGISTRY.register("lime_dyed_water", () -> new LimeDyedWaterBlock());

    public static final RegistryObject<Block> CYAN_DYED_WATER = REGISTRY.register("cyan_dyed_water", () -> new CyanDyedWaterBlock());

    public static final RegistryObject<Block> BROWN_DYED_WATER = REGISTRY.register("brown_dyed_water", () -> new BrownDyedWaterBlock());

    public static final RegistryObject<Block> LIGHT_BLUE_DYED_WATER = REGISTRY.register("light_blue_dyed_water", () -> new LightBlueDyedWaterBlock());

    public static final RegistryObject<Block> ORANGE_DYED_WATER = REGISTRY.register("orange_dyed_water", () -> new OrangeDyedWaterBlock());

    public static final RegistryObject<Block> YELLOW_DYED_WATER = REGISTRY.register("yellow_dyed_water", () -> new YellowDyedWaterBlock());

}
