package com.rockiecraft.create_more_farmables.v1_21_1.infrastructure.config.condition;

import com.mojang.serialization.Codec;
import net.neoforged.neoforge.common.conditions.ICondition;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import org.apache.commons.lang3.mutable.MutableObject;

import java.util.Map;
import java.util.function.Supplier;

public record ConfigRecipeCondition(
        Supplier<Boolean> masterToggle,
        Map<String, Supplier<Boolean>> configMap,
        String configKey,
        MapCodec<ConfigRecipeCondition> selfCodec
) implements ICondition {

    public static MapCodec<ConfigRecipeCondition> createCodec(Supplier<Boolean> master, Map<String, Supplier<Boolean>> map) {
        MutableObject<MapCodec<ConfigRecipeCondition>> selfCodecHolder = new MutableObject<>();

        MapCodec<ConfigRecipeCondition> codec = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Codec.STRING.fieldOf("config").forGetter(ConfigRecipeCondition::configKey)
        ).apply(inst, key -> new ConfigRecipeCondition(master, map, key, selfCodecHolder.getValue())));

        selfCodecHolder.setValue(codec);
        return codec;
    }

    @Override
    public boolean test(IContext context) {
        return masterToggle.get() && configMap.getOrDefault(configKey, () -> false).get();
    }

    @Override
    public MapCodec<? extends ICondition> codec() {
        return selfCodec;
    }
}