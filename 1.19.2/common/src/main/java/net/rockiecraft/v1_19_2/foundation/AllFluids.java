package net.rockiecraft.v1_20_1.foundation;

import org.jetbrains.annotations.Nullable;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.rockiecraft.v1_19_2.CreateMoreFarmables;
import net.rockiecraft.v1_20_1.foundation.fluids.blocks.DyedWaterLiquidBlock;
import net.rockiecraft.v1_20_1.foundation.fluids.blocks.MoltenLiquidBlock;
import net.rockiecraft.v1_20_1.foundation.fluids.builder.FluidTypeBuilder;

import java.util.Map;

public class AllFluids {

    public static final ResourcefulRegistry<Fluid> FLUIDS = ResourcefulRegistries.create(Registry.FLUID, CreateMoreFarmables.MOD_ID);

    // --- Molten fluids ---
    public static final Registered LIQUID_QUARTZ = FluidTypeBuilder.create("liquid_quartz")
            .viscosity(6000)
            .density(3000)
            .tintColor(-393218)
            .pathType(BlockPathTypes.LAVA)
            .canSwim(true)
            .canDrown(true)
            .canConvertToSource(true)
            .tickRate(20)
            .lang("Liquid Quartz")
            .sourceTexture("liquid_quartz")
            .flowingTexture("flowing_liquid_quartz")
            .block(props -> BlockBehaviour.Properties.copy(Blocks.LAVA))
            .blockFactory(MoltenLiquidBlock::new)
            .register();

    public static final Registered LIQUID_REDSTONE = FluidTypeBuilder.create("liquid_redstone")
            .viscosity(6000)
            .density(3000)
            .tintColor(-5231066)
            .pathType(BlockPathTypes.LAVA)
            .canSwim(true)
            .canDrown(true)
            .canConvertToSource(true)
            .tickRate(20)
            .lang("Liquid Redstone")
            .block(props -> BlockBehaviour.Properties.copy(Blocks.LAVA))
            .blockFactory(MoltenLiquidBlock::new)
            .register();

    public static final Registered MOLTEN_ENDSTONE = FluidTypeBuilder.create("molten_endstone")
            .viscosity(6000)
            .density(3000)
            .tintColor(-75715)
            .pathType(BlockPathTypes.LAVA)
            .canSwim(true)
            .canDrown(false)
            .canConvertToSource(false)
            .temperature(1300)
            .tickRate(30)
            .lang("Molten Endstone")
            .block(props -> BlockBehaviour.Properties.copy(Blocks.LAVA))
            .blockFactory(MoltenLiquidBlock::new)
            .register();

    // --- Dyed water (all share the same physics/texture, differ only by tint) ---
    private static Registered dyedWater(String name, int tint) {
        return FluidTypeBuilder.create(name)
                .viscosity(1000)
                .density(1000)
                .tintColor(tint)
                .pathType(BlockPathTypes.WATER)
                .canSwim(true)
                .canDrown(true)
                // Matches vanilla water spring behavior; the dupe bug was waterlogged blocks miscounted as source neighbors, not this flag.
                .canConvertToSource(true)
                .tickRate(5)
                .sharedSourceTexture("dyed_water")
                .sharedFlowingTexture("flowing_dyed_water")
                .block(props -> BlockBehaviour.Properties.copy(Blocks.WATER))
                .blockFactory(DyedWaterLiquidBlock::new)
                .register();
    }

    public static final Registered WHITE_DYED_WATER = dyedWater("white_dyed_water", -393218);
    public static final Registered LIGHT_GRAY_DYED_WATER = dyedWater("light_gray_dyed_water", -6447721);
    public static final Registered GRAY_DYED_WATER = dyedWater("gray_dyed_water", -12103854);
    public static final Registered BLACK_DYED_WATER = dyedWater("black_dyed_water", -14869215);
    public static final Registered BROWN_DYED_WATER = dyedWater("brown_dyed_water", -8170446);
    public static final Registered RED_DYED_WATER = dyedWater("red_dyed_water", -5231066);
    public static final Registered ORANGE_DYED_WATER = dyedWater("orange_dyed_water", -425955);
    public static final Registered YELLOW_DYED_WATER = dyedWater("yellow_dyed_water", -75715);
    public static final Registered GREEN_DYED_WATER = dyedWater("green_dyed_water", -10585066);
    public static final Registered LIME_DYED_WATER = dyedWater("lime_dyed_water", -8337633);
    public static final Registered CYAN_DYED_WATER = dyedWater("cyan_dyed_water", -15295332);
    public static final Registered LIGHT_BLUE_DYED_WATER = dyedWater("light_blue_dyed_water", -12930086);
    public static final Registered BLUE_DYED_WATER = dyedWater("blue_dyed_water", -12827478);
    public static final Registered PURPLE_DYED_WATER = dyedWater("purple_dyed_water", -7785800);
    public static final Registered MAGENTA_DYED_WATER = dyedWater("magenta_dyed_water", -3715395);
    public static final Registered PINK_DYED_WATER = dyedWater("pink_dyed_water", -816214);

    // Molten fluids usable as a fan catalyst, keyed by the id used in recipe JSON and FanProcessingType ids.
    public static final Map<String, Registered> MOLTEN_FLUIDS = Map.of(
            "liquid_quartz", LIQUID_QUARTZ,
            "liquid_redstone", LIQUID_REDSTONE,
            "molten_endstone", MOLTEN_ENDSTONE
    );

    // Resolves a recipe's fluid id back to its Registered entry; null if not a known molten fluid.
    @Nullable
    public static Registered moltenFluidById(net.minecraft.resources.ResourceLocation id) {
        if (!CreateMoreFarmables.MOD_ID.equals(id.getNamespace()))
            return null;
        return MOLTEN_FLUIDS.get(id.getPath());
    }

    // Looks up a dyed water fluid by its DyeColor.
    public static final Map<DyeColor, Registered> DYED_WATER_BY_COLOR = Map.ofEntries(
            Map.entry(DyeColor.WHITE, WHITE_DYED_WATER),
            Map.entry(DyeColor.LIGHT_GRAY, LIGHT_GRAY_DYED_WATER),
            Map.entry(DyeColor.GRAY, GRAY_DYED_WATER),
            Map.entry(DyeColor.BLACK, BLACK_DYED_WATER),
            Map.entry(DyeColor.BROWN, BROWN_DYED_WATER),
            Map.entry(DyeColor.RED, RED_DYED_WATER),
            Map.entry(DyeColor.ORANGE, ORANGE_DYED_WATER),
            Map.entry(DyeColor.YELLOW, YELLOW_DYED_WATER),
            Map.entry(DyeColor.GREEN, GREEN_DYED_WATER),
            Map.entry(DyeColor.LIME, LIME_DYED_WATER),
            Map.entry(DyeColor.CYAN, CYAN_DYED_WATER),
            Map.entry(DyeColor.LIGHT_BLUE, LIGHT_BLUE_DYED_WATER),
            Map.entry(DyeColor.BLUE, BLUE_DYED_WATER),
            Map.entry(DyeColor.PURPLE, PURPLE_DYED_WATER),
            Map.entry(DyeColor.MAGENTA, MAGENTA_DYED_WATER),
            Map.entry(DyeColor.PINK, PINK_DYED_WATER)
    );

    // Holds the source/flowing/block/bucket entries produced by FluidTypeBuilder.register() for one fluid.
    public record Registered(
            RegistryEntry<Fluid> source,
            RegistryEntry<FlowingFluid> flowing,
            RegistryEntry<Block> block,
            RegistryEntry<Item> bucket
    ) {}

    public static void init() {
        FLUIDS.init();
    }

    // Call from each loader's client-only entrypoint; delegates to FluidTypeBuilder.
    public static void initClient() {
        FluidTypeBuilder.initClient();
    }
}
