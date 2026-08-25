package com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.moltenblasting;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;

public class MoltenBlastingRecipeParams extends ProcessingRecipeParams {

    protected ResourceLocation fluid;

    protected MoltenBlastingRecipeParams() {
        super();
    }

    public ResourceLocation fluid() {
        return fluid;
    }

    public static final MapCodec<MoltenBlastingRecipeParams> CODEC =
        Codec.mapPair(
            codec(MoltenBlastingRecipeParams::new),
            ResourceLocation.CODEC.fieldOf("fluid")
        ).xmap(
            pair -> {
                MoltenBlastingRecipeParams params = pair.getFirst();
                params.fluid = pair.getSecond();
                return params;
            },
            params -> Pair.of(params, params.fluid)
        );

    public static final StreamCodec<RegistryFriendlyByteBuf, MoltenBlastingRecipeParams> STREAM_CODEC =
        streamCodec(MoltenBlastingRecipeParams::new);

    @Override
    protected void encode(RegistryFriendlyByteBuf buffer) {
        super.encode(buffer);
        buffer.writeResourceLocation(fluid);
    }

    @Override
    protected void decode(RegistryFriendlyByteBuf buffer) {
        super.decode(buffer);
        fluid = buffer.readResourceLocation();
    }
}
