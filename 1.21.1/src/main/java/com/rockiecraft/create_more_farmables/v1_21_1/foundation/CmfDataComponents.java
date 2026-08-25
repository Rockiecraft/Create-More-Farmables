package com.rockiecraft.create_more_farmables.v1_21_1.foundation;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.rockiecraft.create_more_farmables.v1_21_1.CreateMoreFarmables;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CmfDataComponents {

    private static final DeferredRegister.DataComponents DATA_COMPONENTS =
        DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, CreateMoreFarmables.MODID);

    public static final DataComponentType<AdvancedAssembly> ADVANCED_ASSEMBLY = register(
        "advanced_assembly",
        builder -> builder.persistent(AdvancedAssembly.CODEC)
            .networkSynchronized(AdvancedAssembly.STREAM_CODEC)
    );

    private static <T> DataComponentType<T> register(String name,
                                                       java.util.function.UnaryOperator<DataComponentType.Builder<T>> builder) {
        DataComponentType<T> type = builder.apply(DataComponentType.builder()).build();
        DATA_COMPONENTS.register(name, () -> type);
        return type;
    }

    public static void init(IEventBus modEventBus) {
        DATA_COMPONENTS.register(modEventBus);
    }

    public record AdvancedAssembly(ResourceLocation id, int step, float progress) {
        public static final Codec<AdvancedAssembly> CODEC = RecordCodecBuilder.create(i -> i.group(
            ResourceLocation.CODEC.fieldOf("id").forGetter(AdvancedAssembly::id),
            Codec.INT.fieldOf("step").forGetter(AdvancedAssembly::step),
            Codec.FLOAT.fieldOf("progress").forGetter(AdvancedAssembly::progress)
        ).apply(i, AdvancedAssembly::new));

        public static final StreamCodec<ByteBuf, AdvancedAssembly> STREAM_CODEC = StreamCodec.composite(
            ResourceLocation.STREAM_CODEC, AdvancedAssembly::id,
            ByteBufCodecs.INT, AdvancedAssembly::step,
            ByteBufCodecs.FLOAT, AdvancedAssembly::progress,
            AdvancedAssembly::new
        );
    }
}
