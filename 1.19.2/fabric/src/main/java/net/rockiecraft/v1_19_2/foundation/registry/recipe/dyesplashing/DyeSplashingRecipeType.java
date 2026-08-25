package net.rockiecraft.v1_20_1.foundation.registry.recipe.dyesplashing;

import java.util.Optional;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeSerializer;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.rockiecraft.v1_19_2.CreateMoreFarmables;

public class DyeSplashingRecipeType implements IRecipeTypeInfo {

    public static final ResourcefulRegistry<RecipeSerializer<?>> SERIALIZERS =
            ResourcefulRegistries.create(Registry.RECIPE_SERIALIZER, CreateMoreFarmables.MOD_ID);
    public static final ResourcefulRegistry<RecipeType<?>> TYPES =
            ResourcefulRegistries.create(Registry.RECIPE_TYPE, CreateMoreFarmables.MOD_ID);

    public static final DyeSplashingRecipeType DYE_SPLASHING = new DyeSplashingRecipeType();

    private final ResourceLocation id = new ResourceLocation(CreateMoreFarmables.MOD_ID, "dye_splashing");

    private final RegistryEntry<RecipeSerializer<?>> serializer =
            SERIALIZERS.register("dye_splashing", () -> new ProcessingRecipeSerializer<>(DyeSplashingRecipe::new));

    private final RegistryEntry<RecipeType<?>> type =
            TYPES.register("dye_splashing", () -> simpleType(id));

    private static <T extends Recipe<?>> RecipeType<T> simpleType(ResourceLocation id) {
        String stringId = id.toString();
        return new RecipeType<T>() {
            @Override
            public String toString() {
                return stringId;
            }
        };
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends RecipeSerializer<?>> T getSerializer() {
        return (T) serializer.get();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends RecipeType<?>> T getType() {
        return (T) type.get();
    }

    /** Same helper Create's own AllRecipeTypes enum exposes (AllRecipeTypes.SPLASHING.find(...)). */
    public <C extends Container, R extends Recipe<C>> Optional<R> find(C inv, Level level) {
        return level.getRecipeManager()
                .getRecipeFor(getType(), inv, level);
    }

    public static void init() {
        SERIALIZERS.init();
        TYPES.init();
    }
}
