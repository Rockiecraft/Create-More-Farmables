package com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.dyesplashing;

import java.util.Optional;

import org.jetbrains.annotations.Nullable;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.DyeColor;

public class DyeSplashingRecipeParams extends ProcessingRecipeParams {

    @Nullable
    protected DyeColor color;

    protected DyeSplashingRecipeParams() {
        super();
    }

    @Nullable
    public DyeColor color() {
        return color;
    }

    public static final MapCodec<DyeSplashingRecipeParams> CODEC =
        Codec.mapPair(
            codec(DyeSplashingRecipeParams::new),
            DyeColor.CODEC.optionalFieldOf("color")
        ).xmap(
            pair -> {
                DyeSplashingRecipeParams params = pair.getFirst();
                params.color = pair.getSecond().orElse(null);
                return params;
            },
            params -> Pair.of(params, Optional.ofNullable(params.color))
        );

    public static final StreamCodec<RegistryFriendlyByteBuf, DyeSplashingRecipeParams> STREAM_CODEC =
        streamCodec(DyeSplashingRecipeParams::new);

    @Override
    protected void encode(RegistryFriendlyByteBuf buffer) {
        super.encode(buffer);
        buffer.writeNullable(color, (buf, c) -> buf.writeEnum(c));
    }

    @Override
    protected void decode(RegistryFriendlyByteBuf buffer) {
        super.decode(buffer);
        color = buffer.readNullable(buf -> buf.readEnum(DyeColor.class));
    }
}
