package com.rockiecraft.create_more_farmables.v1_21_1.foundation;

import com.rockiecraft.create_more_farmables.v1_21_1.CreateMoreFarmables;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.fluids.blocks.fluids.DyedWaterLiquidBlock;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.fluids.blocks.fluids.LiquidQuartzLiquidBlock;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.fluids.blocks.fluids.LiquidRedstoneLiquidBlock;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.fluids.blocks.fluids.MoltenEndstoneLiquidBlock;

import com.rockiecraft.create_more_farmables.v1_21_1.foundation.fluids.builder.FluidTypeBuilder;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.pathfinder.PathType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class AllFluids {

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, CreateMoreFarmables.MODID);
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, CreateMoreFarmables.MODID);

    public static final FluidData LIQUID_REDSTONE = FluidTypeBuilder.create("liquid_redstone")
            .density(3000)
            .viscosity(6000)
            .temperature(1300)
            .lightLevel(15)
            .motionScale(0.007D)
            .pathType(PathType.LAVA)
            .tickRate(20)
            .canConvertToSource(false)
            .tintColor(-5231066)
            .lang("Liquid Redstone")
            .block(props -> BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA))
            .blockFactory(LiquidRedstoneLiquidBlock::new)
            .register();

    public static final FluidData LIQUID_QUARTZ = FluidTypeBuilder.create("liquid_quartz")
            .density(3000)
            .viscosity(6000)
            .temperature(1300)
            .lightLevel(15)
            .motionScale(0.007D)
            .pathType(PathType.LAVA)
            .tickRate(20)
            .canConvertToSource(false)
            .tintColor(0xFFE0E0E0)
            .lang("Liquid Quartz")
            .block(props -> BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA))
            .blockFactory(LiquidQuartzLiquidBlock::new)
            .register();

    public static final FluidData MOLTEN_ENDSTONE = FluidTypeBuilder.create("molten_endstone")
            .density(3000)
            .viscosity(6000)
            .temperature(1300)
            .lightLevel(15)
            .motionScale(0.007D)
            .pathType(PathType.LAVA)
            .tickRate(20)
            .canConvertToSource(false)
            .tintColor(0xFFF0F090)
            .lang("Molten Endstone")
            .block(props -> BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA))
            .blockFactory(MoltenEndstoneLiquidBlock::new)
            .register();

    private static FluidData dyedWater(String name, int tint, String lang) {
        return FluidTypeBuilder.create(name)
                .motionScale(0.014D)
                .tintColor(tint)
                .tickRate(5)
                .lang(lang)
                .sharedSourceTexture("dyed_water")
                .sharedFlowingTexture("flowing_dyed_water")
                .block(props -> BlockBehaviour.Properties.ofFullCopy(Blocks.WATER))
                .blockFactory(DyedWaterLiquidBlock::new)
                .register();
    }

    public static final FluidData WHITE_DYED_WATER = dyedWater("white_dyed_water", -393218, "White Dyed Water");
    public static final FluidData LIGHT_GRAY_DYED_WATER = dyedWater("light_gray_dyed_water", -6447721, "Light Gray Dyed Water");
    public static final FluidData GRAY_DYED_WATER = dyedWater("gray_dyed_water", -12103854, "Gray Dyed Water");
    public static final FluidData BLACK_DYED_WATER = dyedWater("black_dyed_water", -14869215, "Black Dyed Water");
    public static final FluidData BROWN_DYED_WATER = dyedWater("brown_dyed_water", -8170446, "Brown Dyed Water");
    public static final FluidData RED_DYED_WATER = dyedWater("red_dyed_water", -5231066, "Red Dyed Water");
    public static final FluidData ORANGE_DYED_WATER = dyedWater("orange_dyed_water", -425955, "Orange Dyed Water");
    public static final FluidData YELLOW_DYED_WATER = dyedWater("yellow_dyed_water", -75715, "Yellow Dyed Water");
    public static final FluidData LIME_DYED_WATER = dyedWater("lime_dyed_water", -8337633, "Lime Dyed Water");
    public static final FluidData GREEN_DYED_WATER = dyedWater("green_dyed_water", -10585066, "Green Dyed Water");
    public static final FluidData CYAN_DYED_WATER = dyedWater("cyan_dyed_water", -15295332, "Cyan Dyed Water");
    public static final FluidData LIGHT_BLUE_DYED_WATER = dyedWater("light_blue_dyed_water", -12930086, "Light Blue Dyed Water");
    public static final FluidData BLUE_DYED_WATER = dyedWater("blue_dyed_water", -12827478, "Blue Dyed Water");
    public static final FluidData PURPLE_DYED_WATER = dyedWater("purple_dyed_water", -7785800, "Purple Dyed Water");
    public static final FluidData MAGENTA_DYED_WATER = dyedWater("magenta_dyed_water", -3715395, "Magenta Dyed Water");
    public static final FluidData PINK_DYED_WATER = dyedWater("pink_dyed_water", -816214, "Pink Dyed Water");

    public record FluidData(
            DeferredHolder<FluidType, FluidType> type,
            DeferredHolder<Fluid, ?> source,
            DeferredHolder<Fluid, ?> flowing,
            RegistryEntry<? extends Block> block,
            RegistryEntry<? extends Item> bucket
    ) {}

    public static void init(IEventBus modEventBus) {
        FLUID_TYPES.register(modEventBus);
        FLUIDS.register(modEventBus);
    }

    public static final Map<DyeColor, FluidData> DYED_WATER_BY_COLOR = new EnumMap<>(DyeColor.class);
    public static final Map<String, FluidData> MOLTEN_FLUIDS = new LinkedHashMap<>();

    static {
        DYED_WATER_BY_COLOR.put(DyeColor.WHITE, WHITE_DYED_WATER);
        DYED_WATER_BY_COLOR.put(DyeColor.LIGHT_GRAY, LIGHT_GRAY_DYED_WATER);
        DYED_WATER_BY_COLOR.put(DyeColor.GRAY, GRAY_DYED_WATER);
        DYED_WATER_BY_COLOR.put(DyeColor.BLACK, BLACK_DYED_WATER);
        DYED_WATER_BY_COLOR.put(DyeColor.BROWN, BROWN_DYED_WATER);
        DYED_WATER_BY_COLOR.put(DyeColor.RED, RED_DYED_WATER);
        DYED_WATER_BY_COLOR.put(DyeColor.ORANGE, ORANGE_DYED_WATER);
        DYED_WATER_BY_COLOR.put(DyeColor.YELLOW, YELLOW_DYED_WATER);
        DYED_WATER_BY_COLOR.put(DyeColor.LIME, LIME_DYED_WATER);
        DYED_WATER_BY_COLOR.put(DyeColor.GREEN, GREEN_DYED_WATER);
        DYED_WATER_BY_COLOR.put(DyeColor.CYAN, CYAN_DYED_WATER);
        DYED_WATER_BY_COLOR.put(DyeColor.LIGHT_BLUE, LIGHT_BLUE_DYED_WATER);
        DYED_WATER_BY_COLOR.put(DyeColor.BLUE, BLUE_DYED_WATER);
        DYED_WATER_BY_COLOR.put(DyeColor.PURPLE, PURPLE_DYED_WATER);
        DYED_WATER_BY_COLOR.put(DyeColor.MAGENTA, MAGENTA_DYED_WATER);
        DYED_WATER_BY_COLOR.put(DyeColor.PINK, PINK_DYED_WATER);

        MOLTEN_FLUIDS.put("liquid_redstone", LIQUID_REDSTONE);
        MOLTEN_FLUIDS.put("liquid_quartz", LIQUID_QUARTZ);
        MOLTEN_FLUIDS.put("molten_endstone", MOLTEN_ENDSTONE);
    }
}