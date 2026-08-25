package net.rockiecraft.v1_20_1.forge.client;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.rockiecraft.v1_20_1.foundation.AllFluids;

public final class CreateMoreFarmablesForgeClient {
    public static void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            // Botarium's ClientHooks.setRenderLayer is gone - Forge's own equivalent is
            // ItemBlockRenderTypes.setRenderLayer (a Forge-patched addition to the vanilla
            // class of the same name).
            //
            // Two separate registrations are needed here, not one. The Block-keyed overload
            // only governs the LiquidBlock's own block-model render pass (which is empty for a
            // liquid, so this alone changes nothing visually). The actual liquid mesh - what you
            // see when you look at the fluid - is drawn by LiquidBlockRenderer using whatever's
            // registered against the FLUID via the OTHER setRenderLayer(Fluid, RenderType)
            // overload (ItemBlockRenderTypes.getRenderLayer(FluidState) is keyed by Fluid, not
            // Block). Without that second call the fluid falls back to RenderType.solid() and
            // renders fully opaque even though the block-level registration below succeeded -
            // this was the actual cause of dyed water rendering as solid colored blocks instead
            // of translucent water. Both source and flowing need it, since they're registered as
            // two separate Fluid instances.
            for (AllFluids.Registered dyedWater : AllFluids.DYED_WATER_BY_COLOR.values()) {
                ItemBlockRenderTypes.setRenderLayer(dyedWater.block().get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(dyedWater.source().get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(dyedWater.flowing().get(), RenderType.translucent());
            }

            // Texture/tint/overlay for every registered fluid - previously handled internally
            // by Botarium's FluidData registration, now goes through FluidPlatformHelper.
            AllFluids.initClient();
        });
    }
}
