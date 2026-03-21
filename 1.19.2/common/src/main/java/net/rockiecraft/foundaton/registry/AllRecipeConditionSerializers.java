package net.rockiecraft.foundaton.registry;

import net.rockiecraft.foundaton.registry.recipe.config.condition.ConfigRecipeCondition;
import net.rockiecraft.foundaton.registry.recipe.config.condition.IRecipeConditionSerializer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllRecipeConditionSerializers {
    private static final List<IRecipeConditionSerializer<?>> SERIALIZERS = new ArrayList<>();

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> CONFIG_CONDITION =
            register(new ConfigRecipeCondition.Serializer());

    public static <T extends IRecipeConditionSerializer<?>> T register(T condition) {
        SERIALIZERS.add(condition);
        return condition;
    }

    public static List<IRecipeConditionSerializer<?>> getSerializers() {
        return Collections.unmodifiableList(SERIALIZERS);
    }

    public static void init() {

    }
}
