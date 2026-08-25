package com.rockiecraft.create_more_farmables.v1_21_1.foundation.fluids.builder;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import com.rockiecraft.create_more_farmables.v1_21_1.CreateMoreFarmables;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.AllBlocks;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.AllFluids;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.AllItems;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.pathfinder.PathType;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class FluidTypeBuilder {

    private static final Map<String, FluidTypeBuilder> REGISTRY = new LinkedHashMap<>();

    private static final Map<String, String> LANG = new LinkedHashMap<>();

    private final String name;
    private String langName;

    private int density = 1000, viscosity = 1000, tint = -1, temperature = 300, tickRate = 5, lightLevel = 0;
    private double motionScale = 0.014D;
    private boolean canSwim = true, canDrown = true, canConvertToSource = true;
    private PathType pathType = PathType.WATER;

    private ResourceLocation still;
    private ResourceLocation flowing;
    private ResourceLocation overlay = ResourceLocation.withDefaultNamespace("block/water_overlay");
    private ResourceLocation screenOverlay = ResourceLocation.withDefaultNamespace("textures/misc/underwater.png");

    private BlockBehaviour.Properties blockProps = BlockBehaviour.Properties.ofFullCopy(Blocks.WATER);
    private Item.Properties bucketProps = new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET);

    private BlockFactory blockFactory = (fluid, props) -> new LiquidBlock(fluid.get(), props);

    private DeferredHolder<Fluid, BaseFlowingFluid.Source> sourceHolder;
    private DeferredHolder<Fluid, BaseFlowingFluid.Flowing> flowingHolder;
    private RegistryEntry<Block> blockEntry;
    private RegistryEntry<Item> bucketEntry;

    private FluidTypeBuilder(String name) {
        this.name = name;
        this.still = CreateMoreFarmables.id("block/" + name);
        this.flowing = CreateMoreFarmables.id("block/flowing_" + name);
    }

    public static FluidTypeBuilder create(String name) {
        return new FluidTypeBuilder(name);
    }

    public FluidTypeBuilder density(int d) { this.density = d; return this; }
    public FluidTypeBuilder viscosity(int v) { this.viscosity = v; return this; }
    public FluidTypeBuilder tintColor(int t) { this.tint = t; return this; }
    public FluidTypeBuilder temperature(int t) { this.temperature = t; return this; }
    public FluidTypeBuilder lightLevel(int l) { this.lightLevel = l; return this; }
    public FluidTypeBuilder motionScale(double m) { this.motionScale = m; return this; }
    public FluidTypeBuilder canSwim(boolean s) { this.canSwim = s; return this; }
    public FluidTypeBuilder canDrown(boolean d) { this.canDrown = d; return this; }
    public FluidTypeBuilder canConvertToSource(boolean c) { this.canConvertToSource = c; return this; }
    public FluidTypeBuilder pathType(PathType p) { this.pathType = p; return this; }
    public FluidTypeBuilder tickRate(int t) { this.tickRate = t; return this; }

    public FluidTypeBuilder lang(String displayName) { this.langName = displayName; return this; }
    public FluidTypeBuilder overlay(ResourceLocation loc) { this.overlay = loc; return this; }
    public FluidTypeBuilder screenOverlay(ResourceLocation loc) { this.screenOverlay = loc; return this; }

    public FluidTypeBuilder sourceTexture(ResourceLocation loc) { this.still = loc; return this; }
    public FluidTypeBuilder flowingTexture(ResourceLocation loc) { this.flowing = loc; return this; }

    public FluidTypeBuilder sourceTexture(String path) {
        this.still = CreateMoreFarmables.id("block/" + path);
        return this;
    }

    public FluidTypeBuilder flowingTexture(String path) {
        this.flowing = CreateMoreFarmables.id("block/" + path);
        return this;
    }

    public FluidTypeBuilder sharedSourceTexture(String name) {
        this.still = CreateMoreFarmables.id("block/" + name);
        return this;
    }

    public FluidTypeBuilder sharedFlowingTexture(String name) {
        this.flowing = CreateMoreFarmables.id("block/" + name);
        return this;
    }

    public FluidTypeBuilder block(UnaryOperator<BlockBehaviour.Properties> func) {
        this.blockProps = func.apply(this.blockProps);
        return this;
    }

    public FluidTypeBuilder bucket(UnaryOperator<Item.Properties> func) {
        this.bucketProps = func.apply(this.bucketProps);
        return this;
    }

    public FluidTypeBuilder blockFactory(BlockFactory factory) {
        this.blockFactory = factory;
        return this;
    }

    @FunctionalInterface
    public interface BlockFactory {
        Block create(Supplier<? extends FlowingFluid> fluid, BlockBehaviour.Properties props);
    }

    public AllFluids.FluidData register() {
        REGISTRY.put(name, this);
        LANG.put(name, langName != null ? langName : titleCase(name));

        DeferredHolder<FluidType, FluidType> type = AllFluids.FLUID_TYPES.register(name, this::build);

        sourceHolder = AllFluids.FLUIDS.register(name, () -> new BaseFlowingFluid.Source(makeProperties(type)));
        flowingHolder = AllFluids.FLUIDS.register("flowing_" + name, () -> new BaseFlowingFluid.Flowing(makeProperties(type)));

        blockEntry = AllBlocks.BLOCKS.register(name, () -> blockFactory.create(sourceHolder, blockProps));
        bucketEntry = AllItems.BASIC_ITEMS.register(name + "_bucket", () -> new BucketItem(sourceHolder.get(), bucketProps));

        return new AllFluids.FluidData(type, sourceHolder, flowingHolder, blockEntry, bucketEntry);
    }

    private BaseFlowingFluid.Properties makeProperties(DeferredHolder<FluidType, FluidType> type) {
        return new BaseFlowingFluid.Properties(type,
                () -> sourceHolder.get(),
                () -> flowingHolder.get())
                .bucket(() -> (BucketItem) bucketEntry.get())
                .block(() -> (LiquidBlock) blockEntry.get())
                .tickRate(tickRate);
    }

    public static Map<String, String> getLangEntries() {
        return Collections.unmodifiableMap(LANG);
    }

    private static String titleCase(String name) {
        String[] words = name.split("_");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (word.isEmpty()) continue;
            if (!result.isEmpty()) result.append(' ');
            result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1));
        }
        return result.toString();
    }

    private FluidType build() {
        return new FluidType(FluidType.Properties.create()
                .density(density)
                .viscosity(viscosity)
                .temperature(temperature)
                .lightLevel(lightLevel)
                .motionScale(motionScale)
                .canSwim(canSwim)
                .canDrown(canDrown)
                .canConvertToSource(canConvertToSource)
                .pathType(pathType)) {

            @Override
            public void initializeClient(java.util.function.Consumer<IClientFluidTypeExtensions> consumer) {
                consumer.accept(new IClientFluidTypeExtensions() {

                    @Override
                    public ResourceLocation getStillTexture() {
                        return still;
                    }

                    @Override
                    public ResourceLocation getFlowingTexture() {
                        return flowing;
                    }

                    @Override
                    public int getTintColor() {
                        return tint;
                    }

                    @Override
                    public ResourceLocation getOverlayTexture() {
                        return overlay;
                    }

                    @Override
                    public ResourceLocation getRenderOverlayTexture(Minecraft mc) {
                        return screenOverlay;
                    }
                });
            }
        };
    }
}