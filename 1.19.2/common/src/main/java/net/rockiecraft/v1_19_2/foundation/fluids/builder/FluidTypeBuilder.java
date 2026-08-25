package net.rockiecraft.v1_20_1.foundation.fluids.builder;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import dev.architectury.core.block.ArchitecturyLiquidBlock;
import dev.architectury.core.item.ArchitecturyBucketItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.rockiecraft.v1_19_2.CreateMoreFarmables;
import net.rockiecraft.v1_20_1.foundation.AllBlocks;
import net.rockiecraft.v1_20_1.foundation.AllFluids;
import net.rockiecraft.v1_20_1.foundation.AllItems;
import net.rockiecraft.v1_20_1.foundation.fluids.platform.FluidPlatformHelper;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

// Config holder and registrar for a fluid; .register() registers the source/flowing Fluid, Block, and bucket Item in one go.
public class FluidTypeBuilder {

    // Every builder that's gone through register(), used by initClient() to register texture/tint/overlay for each fluid.
    private static final Map<String, FluidTypeBuilder> REGISTRY = new LinkedHashMap<>();

    // name -> display name, read by the Forge lang datagen provider (CMFLangProvider).
    private static final Map<String, String> LANG = new LinkedHashMap<>();

    private final String name;
    private String langName;

    // Physics & general behavior defaults
    private int density = 1000, viscosity = 1000, tint = -1, temperature = 300, tickRate = 5, lightLevel = 0;
    private double motionScale = 0.014D;
    private boolean canSwim = true, canDrown = true, canConvertToSource = true;
    private BlockPathTypes pathType = BlockPathTypes.WATER;

    // Texture/overlay fields, consumed by FluidPlatformHelper.registerClientRendering()
    private ResourceLocation still;
    private ResourceLocation flowing;
    private ResourceLocation overlay = new ResourceLocation("block/water_overlay");
    private ResourceLocation screenOverlay = new ResourceLocation("textures/misc/underwater.png");

    private BlockBehaviour.Properties blockProps = BlockBehaviour.Properties.copy(Blocks.WATER);
    private Item.Properties bucketProps = new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1);

    // Defaults to a plain ArchitecturyLiquidBlock; each fluid overrides with its own subclass (MoltenLiquidBlock, DyedWaterLiquidBlock, etc).
    private BiFunction<Supplier<? extends FlowingFluid>, BlockBehaviour.Properties, Block> blockFactory = ArchitecturyLiquidBlock::new;

    private FluidTypeBuilder(String name) {
        this.name = name;
        // Default texture convention: block/<name> and block/flowing_<name>; override via sharedSourceTexture/sharedFlowingTexture.
        this.still = new ResourceLocation(CreateMoreFarmables.MOD_ID + ":block/" + name);
        this.flowing = new ResourceLocation(CreateMoreFarmables.MOD_ID + ":block/" + name);
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
    public FluidTypeBuilder pathType(BlockPathTypes p) { this.pathType = p; return this; }
    public FluidTypeBuilder tickRate(int t) { this.tickRate = t; return this; }
    // Display name for lang entries; defaults to a title-cased version of the registration name if unset.
    public FluidTypeBuilder lang(String displayName) { this.langName = displayName; return this; }
    public FluidTypeBuilder overlay(ResourceLocation loc) { this.overlay = loc; return this; }
    public FluidTypeBuilder screenOverlay(ResourceLocation loc) { this.screenOverlay = loc; return this; }
    // Arbitrary texture override for textures that don't follow the block/<name> convention.
    public FluidTypeBuilder sourceTexture(ResourceLocation loc) { this.still = loc; return this; }
    public FluidTypeBuilder flowingTexture(ResourceLocation loc) { this.flowing = loc; return this; }

    // Sets the still texture to this mod's block/<path>.
    public FluidTypeBuilder sourceTexture(String path) {
        this.still = new ResourceLocation(CreateMoreFarmables.MOD_ID + ":block/" + path);
        return this;
    }

    // Same as sourceTexture(String), but for the flowing texture.
    public FluidTypeBuilder flowingTexture(String path) {
        this.flowing = new ResourceLocation(CreateMoreFarmables.MOD_ID + ":block/" + path);
        return this;
    }

    // Points this fluid's still texture at another fluid name's texture, e.g. all dyed waters share "dyed_water".
    public FluidTypeBuilder sharedSourceTexture(String name) {
        this.still = new ResourceLocation(CreateMoreFarmables.MOD_ID + ":block/" + name);
        return this;
    }

    // Same as sharedSourceTexture(String), but for the flowing texture.
    public FluidTypeBuilder sharedFlowingTexture(String name) {
        this.flowing = new ResourceLocation(CreateMoreFarmables.MOD_ID + ":block/" + name);
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

    public FluidTypeBuilder blockFactory(BiFunction<Supplier<? extends FlowingFluid>, BlockBehaviour.Properties, Block> factory) {
        this.blockFactory = factory;
        return this;
    }

    // Registers the source + flowing Fluid, Block, and bucket Item. Client rendering is registered separately via initClient().
    public AllFluids.Registered register() {
        REGISTRY.put(name, this);
        LANG.put(name, langName != null ? langName : titleCase(name));

        RegistryEntry<Fluid> source = AllFluids.FLUIDS.register(name, () -> FluidPlatformHelper.createSourceFluid(
                name, density, viscosity, tint, temperature, tickRate, lightLevel, motionScale,
                canSwim, canDrown, canConvertToSource, pathType, still, flowing, overlay));
        RegistryEntry<FlowingFluid> flowingEntry = AllFluids.FLUIDS.register("flowing_" + name, () -> (FlowingFluid) FluidPlatformHelper.createFlowingFluid(
                name, density, viscosity, tint, temperature, tickRate, lightLevel, motionScale,
                canSwim, canDrown, canConvertToSource, pathType, still, flowing, overlay));

        // Not dereferenced here - on Forge the Fluid registry resolves after Block/Item, so this can only be called later.
        // Explicit cast since RegistryEntry<Fluid>::get is a Supplier<Fluid>, but callers need Supplier<? extends FlowingFluid>.
        Supplier<FlowingFluid> sourceSupplier = () -> (FlowingFluid) source.get();

        RegistryEntry<Block> block = AllBlocks.BLOCKS.register(name,
                () -> blockFactory.apply(sourceSupplier, blockProps));

        RegistryEntry<Item> bucket = AllItems.BASIC_ITEMS.register(name + "_bucket", () -> new ArchitecturyBucketItem(
                sourceSupplier, bucketProps.tab(AllItems.MAIN_TAB)));

        return new AllFluids.Registered(source, flowingEntry, block, bucket);
    }

    // Call from each loader's client-only entrypoint; registers texture/tint/overlay for every fluid registered so far.
    public static void initClient() {
        REGISTRY.forEach((name, builder) -> FluidPlatformHelper.registerClientRendering(
                name, builder.still, builder.flowing, builder.overlay, builder.tint));
    }

    // name -> display name for every fluid registered so far. Consumed by CMFLangProvider.
    public static Map<String, String> getLangEntries() {
        return Collections.unmodifiableMap(LANG);
    }

    // "liquid_quartz" -> "Liquid Quartz". Only used as the .lang(...) fallback.
    private static String titleCase(String name) {
        String[] words = name.split("_");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (word.isEmpty()) continue;
            if (result.length() > 0) result.append(' ');
            result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1));
        }
        return result.toString();
    }
}
