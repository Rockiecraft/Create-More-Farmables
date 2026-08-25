package net.rockiecraft.v1_20_1.foundation.registry.recipe.moltenblasting;

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

public class MoltenBlastingRecipeType implements IRecipeTypeInfo {

    public static final ResourcefulRegistry<RecipeSerializer<?>> SERIALIZERS =
            ResourcefulRegistries.create(Registry.RECIPE_SERIALIZER, CreateMoreFarmables.MOD_ID);
    public static final ResourcefulRegistry<RecipeType<?>> TYPES =
            ResourcefulRegistries.create(Registry.RECIPE_TYPE, CreateMoreFarmables.MOD_ID);

    public static final MoltenBlastingRecipeType MOLTEN_BLASTING = new MoltenBlastingRecipeType();

    private final ResourceLocation id = new ResourceLocation(CreateMoreFarmables.MOD_ID, "molten_blasting");

    private final RegistryEntry<RecipeSerializer<?>> serializer =
            SERIALIZERS.register("molten_blasting", () -> new ProcessingRecipeSerializer<>(MoltenBlastingRecipe::new));

    private final RegistryEntry<RecipeType<?>> type =
            TYPES.register("molten_blasting", () -> RecipeType.simple(id));

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

    public <C extends Container, R extends Recipe<C>> Optional<R> find(C inv, Level level) {
        return level.getRecipeManager()
            .getRecipeFor(getType(), inv, level);
    }

    public static void init() {
        SERIALIZERS.init();
        TYPES.init();
    }
}
