package net.rockiecraft.v1_19_2.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.rockiecraft.v1_20_1.foundation.AllFluids;

public final class CreateMoreFarmablesFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Botarium's ClientHooks.setRenderLayer is gone - Fabric's own equivalent is
        // fabric-blockrenderlayer-v1's BlockRenderLayerMap (already a transitive dependency
        // via the fabric-api umbrella, no new gradle dependency needed).
        //
        // putBlock() alone changes nothing visually - the LiquidBlock has no real block model
        // (it's rendered via LiquidBlockRenderer instead), so it's putFluid() that actually
        // controls the liquid mesh's render type. Without it the fluid falls back to
        // RenderType.solid() and renders fully opaque even though putBlock() succeeded - this
        // was the actual cause of dyed water rendering as solid colored blocks instead of
        // translucent water. Both source and flowing need it, since they're registered as two
        // separate Fluid instances.
        for (AllFluids.Registered dyedWater : AllFluids.DYED_WATER_BY_COLOR.values()) {
            BlockRenderLayerMap.INSTANCE.putBlock(dyedWater.block().get(), RenderType.translucent());
            BlockRenderLayerMap.INSTANCE.putFluid(dyedWater.source().get(), RenderType.translucent());
            BlockRenderLayerMap.INSTANCE.putFluid(dyedWater.flowing().get(), RenderType.translucent());
        }

        // Texture/tint/overlay for every registered fluid - previously handled internally by
        // Botarium's FluidData registration, now goes through FluidPlatformHelper.
        AllFluids.initClient();
    }
}
