package net.rockiecraft.foundaton.registry.recipe.condition;

import dev.architectury.registry.registries.*;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.rockiecraft.CreateMoreFarmables;
import net.rockiecraft.foundaton.registry.config.ConfigRecipeCondition;
import net.rockiecraft.foundaton.registry.config.CreateMoreFarmablesConfig;


import java.util.*;
import java.util.function.Supplier;

public class AllRecipeConditionSerializers {
    private static final List<IRecipeConditionSerializer<?>> SERIALIZERS = new ArrayList<>();

//    public static final Map<String, Supplier<Boolean>>  = new HashMap<>();

    public static final Map<String, Supplier<Boolean>> DYED_WATER_MAP = new HashMap<>();
    public static final Map<String, Supplier<Boolean>> DYE_TEMPLATE_FILLING_MAP = new HashMap<>();


    static {
        DYED_WATER_MAP.put("white", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.whiteDyedWaterMaking);
        DYED_WATER_MAP.put("orange", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.orangeDyedWaterMaking);
        DYED_WATER_MAP.put("magenta", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.magentaDyedWaterMaking);
        DYED_WATER_MAP.put("light_blue", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.lightBlueDyedWaterMaking);
        DYED_WATER_MAP.put("yellow", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.yellowDyedWaterMaking);
        DYED_WATER_MAP.put("lime", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.limeDyedWaterMaking);
        DYED_WATER_MAP.put("pink", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.pinkDyedWaterMaking);
        DYED_WATER_MAP.put("gray", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.grayDyedWaterMaking);
        DYED_WATER_MAP.put("light_gray", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.lightGrayDyedWaterMaking);
        DYED_WATER_MAP.put("cyan", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.cyanDyedWaterMaking);
        DYED_WATER_MAP.put("purple", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.purpleDyedWaterMaking);
        DYED_WATER_MAP.put("blue", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.blueDyedWaterMaking);
        DYED_WATER_MAP.put("brown", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.brownDyedWaterMaking);
        DYED_WATER_MAP.put("green", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.greenDyedWaterMaking);
        DYED_WATER_MAP.put("red", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.redDyedWaterMaking);
        DYED_WATER_MAP.put("black", () -> CreateMoreFarmablesConfig.Dyed_Water_Making.blackDyedWaterMaking);
    }

    public static final IRecipeConditionSerializer<ConfigRecipeCondition> DYED_WATER_MIXING = register(
            new ConfigRecipeCondition.Serializer(new ResourceLocation("create_more_farmables", "dyed_water_mixing"),
                    () -> CreateMoreFarmablesConfig.Dyed_Water_Making.allDyedWaterMixingEnabled,
                    DYED_WATER_MAP));

    

    public static <T extends IRecipeConditionSerializer<?>> T register(T condition) {
        SERIALIZERS.add(condition);
        return condition;
    }

    public static List<IRecipeConditionSerializer<?>> getSerializers() {
        return Collections.unmodifiableList(SERIALIZERS);
    }


    public static void init() {
        // 4. This "starts" the registry and prevents the "does not exist" crash
    }
}
