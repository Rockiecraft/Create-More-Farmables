package net.rockiecraft.v1_20_1.foundation.fluids.platform.forge;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rockiecraft.v1_19_2.CreateMoreFarmables;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class FluidPlatformHelperImpl {

    private static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, CreateMoreFarmables.MOD_ID);

    private static final Map<String, RegistryObject<FluidType>> FLUID_TYPE_CACHE = new ConcurrentHashMap<>();

    public static void bindEventBus(IEventBus modEventBus) {
        FLUID_TYPES.register(modEventBus);
    }

    public static FlowingFluid createSourceFluid(
            String name, int density, int viscosity, int tint, int temperature, int tickRate,
            int lightLevel, double motionScale, boolean canSwim, boolean canDrown,
            boolean canConvertToSource, BlockPathTypes pathType,
            ResourceLocation stillTexture, ResourceLocation flowingTexture, ResourceLocation overlay) {
        return new ForgeFlowingFluid.Source(buildProperties(name, density, viscosity, tint, temperature,
                tickRate, lightLevel, motionScale, canSwim, canDrown, canConvertToSource, pathType,
                stillTexture, flowingTexture, overlay));
    }

    public static FlowingFluid createFlowingFluid(
            String name, int density, int viscosity, int tint, int temperature, int tickRate,
            int lightLevel, double motionScale, boolean canSwim, boolean canDrown,
            boolean canConvertToSource, BlockPathTypes pathType,
            ResourceLocation stillTexture, ResourceLocation flowingTexture, ResourceLocation overlay) {
        return new ForgeFlowingFluid.Flowing(buildProperties(name, density, viscosity, tint, temperature,
                tickRate, lightLevel, motionScale, canSwim, canDrown, canConvertToSource, pathType,
                stillTexture, flowingTexture, overlay));
    }

    public static void registerClientRendering(
            String name, ResourceLocation stillTexture, ResourceLocation flowingTexture,
            ResourceLocation overlay, int tint) {
        // No-op on Forge - texture/tint/overlay are read straight off the FluidType via
        // FluidType was registered during createSourceFluid/createFlowingFluid. Kept as a
        // method so AllFluids/CreateMoreFarmablesForgeClient can call it unconditionally
        // without an if-Forge check.
    }

    private static ForgeFlowingFluid.Properties buildProperties(
            String name, int density, int viscosity, int tint, int temperature, int tickRate,
            int lightLevel, double motionScale, boolean canSwim, boolean canDrown,
            boolean canConvertToSource, BlockPathTypes pathType,
            ResourceLocation stillTexture, ResourceLocation flowingTexture, ResourceLocation overlay) {
        RegistryObject<FluidType> fluidType = getOrRegisterFluidType(name, density, viscosity, tint, temperature,
                lightLevel, motionScale, canSwim, canDrown, canConvertToSource, pathType,
                stillTexture, flowingTexture, overlay);
        ResourceLocation sourceId = new ResourceLocation(CreateMoreFarmables.MOD_ID, name);
        ResourceLocation flowingId = new ResourceLocation(CreateMoreFarmables.MOD_ID, "flowing_" + name);
        // Block is registered separately in common AllFluids.register() under this same `name`
        // (AllBlocks.BLOCKS.register(name, ...)). Without wiring it back here, Properties.block
        // defaults to a supplier that returns Blocks.AIR, so getBlock() (and therefore
        // createLegacyBlock(), used by JEI's GuiGameElement.of(Fluid)) silently resolves to air
        // instead of the real MoltenLiquidBlock/DyedWaterLiquidBlock, crashing the moment
        // something tries to set a fluid-state property (e.g. LEVEL) on it. Looked up lazily by
        // id, same pattern as sourceId/flowingId above, since block registration order isn't
        // guaranteed relative to this running.
        ResourceLocation blockId = new ResourceLocation(CreateMoreFarmables.MOD_ID, name);
        // Same missing-link issue as the block above: AllFluids.register() registers the bucket
        // Item (via ArchitecturyBucketItem) separately too, under `name + "_bucket"`, and
        // nothing wires it back into Properties either. Left unset, Properties.bucket defaults
        // to a supplier that doesn't resolve to this fluid's actual bucket item, so picking the
        // fluid up with a bucket wouldn't behave correctly.
        ResourceLocation bucketId = new ResourceLocation(CreateMoreFarmables.MOD_ID, name + "_bucket");

        return new ForgeFlowingFluid.Properties(
                fluidType,
                () -> (Fluid) Registry.FLUID.get(sourceId),
                () -> (FlowingFluid) Registry.FLUID.get(flowingId))
                .block(() -> (net.minecraft.world.level.block.LiquidBlock) ForgeRegistries.BLOCKS.getValue(blockId))
                .bucket(() -> ForgeRegistries.ITEMS.getValue(bucketId))
                .slopeFindDistance(4)
                .levelDecreasePerBlock(1)
                .tickRate(tickRate)
                .explosionResistance(100f);
    }

    private static RegistryObject<FluidType> getOrRegisterFluidType(
            String name, int density, int viscosity, int tint, int temperature,
            int lightLevel, double motionScale, boolean canSwim, boolean canDrown,
            boolean canConvertToSource, BlockPathTypes pathType,
            ResourceLocation stillTexture, ResourceLocation flowingTexture, ResourceLocation overlay) {
        return FLUID_TYPE_CACHE.computeIfAbsent(name, n -> FLUID_TYPES.register(n, () -> new CmfFluidType(
                density, viscosity, temperature, lightLevel, motionScale, canSwim, canDrown, canConvertToSource,
                pathType, stillTexture, flowingTexture, tint)));
    }

    private static class CmfFluidType extends FluidType {
        private final ResourceLocation stillTexture;
        private final ResourceLocation flowingTexture;
        private final int tint;

        CmfFluidType(int density, int viscosity, int temperature, int lightLevel, double motionScale,
                     boolean canSwim, boolean canDrown, boolean canConvertToSource, BlockPathTypes pathType,
                     ResourceLocation stillTexture, ResourceLocation flowingTexture, int tint) {
            super(Properties.create()
                    .density(density)
                    .viscosity(viscosity)
                    .temperature(temperature)
                    .lightLevel(lightLevel)
                    .motionScale(motionScale)
                    .canSwim(canSwim)
                    .canDrown(canDrown)
                    .canConvertToSource(canConvertToSource)
                    .pathType(pathType)
                    .adjacentPathType(pathType));
            this.stillTexture = stillTexture;
            this.flowingTexture = flowingTexture;
            this.tint = tint;
        }

        @Override
        public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
            consumer.accept(new IClientFluidTypeExtensions() {
                @Override
                public ResourceLocation getStillTexture() {
                    return stillTexture;
                }

                @Override
                public ResourceLocation getFlowingTexture() {
                    return flowingTexture;
                }

                @Override
                public int getTintColor() {
                    return tint;
                }
            });
        }
    }
}