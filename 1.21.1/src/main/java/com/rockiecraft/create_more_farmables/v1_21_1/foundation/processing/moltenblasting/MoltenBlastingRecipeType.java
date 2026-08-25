package com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.moltenblasting;

import java.util.Optional;

import com.google.common.base.Joiner;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.rockiecraft.create_more_farmables.v1_21_1.CreateMoreFarmables;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeParams;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MoltenBlastingRecipeType implements IRecipeTypeInfo {

    private static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
        DeferredRegister.create(Registries.RECIPE_SERIALIZER, CreateMoreFarmables.MODID);
    private static final DeferredRegister<RecipeType<?>> TYPES =
        DeferredRegister.create(Registries.RECIPE_TYPE, CreateMoreFarmables.MODID);

    public static final MoltenBlastingRecipeType MOLTEN_BLASTING = new MoltenBlastingRecipeType();

    private final ResourceLocation id = CreateMoreFarmables.id("molten_blasting");

    private final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<MoltenBlastingRecipe>> serializer =
        SERIALIZERS.register("molten_blasting", Serializer::new);

    private final DeferredHolder<RecipeType<?>, RecipeType<MoltenBlastingRecipe>> type =
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
    public <I extends RecipeInput, R extends Recipe<I>> RecipeType<R> getType() {
        return (RecipeType<R>) type.get();
    }

    public <I extends RecipeInput, R extends Recipe<I>> Optional<RecipeHolder<R>> find(I input, Level level) {
        return level.getRecipeManager()
            .getRecipeFor(getType(), input, level);
    }

    public static void init(IEventBus modEventBus) {
        SERIALIZERS.register(modEventBus);
        TYPES.register(modEventBus);
    }

    public static class Serializer implements RecipeSerializer<MoltenBlastingRecipe> {

        private static final MapCodec<MoltenBlastingRecipe> CODEC = Codec.mapPair(
                ProcessingRecipeParams.CODEC,
                ResourceLocation.CODEC.fieldOf("fluid")
            ).xmap(
                pair -> new MoltenBlastingRecipe(pair.getFirst(), pair.getSecond()),
                recipe -> Pair.of(recipe.getParams(), recipe.getFluid())
            )
            .validate(recipe -> {
                var errors = recipe.validate();
                if (errors.isEmpty())
                    return DataResult.success(recipe);
                errors.add(recipe.getClass()
                    .getSimpleName() + " failed validation:");
                return DataResult.error(() -> Joiner.on('\n')
                    .join(errors), recipe);
            });

        private static final StreamCodec<RegistryFriendlyByteBuf, MoltenBlastingRecipe> STREAM_CODEC = StreamCodec.of(
            (buffer, recipe) -> {
                ProcessingRecipeParams.STREAM_CODEC.encode(buffer, recipe.getParams());
                buffer.writeResourceLocation(recipe.getFluid());
            },
            buffer -> {
                ProcessingRecipeParams params = ProcessingRecipeParams.STREAM_CODEC.decode(buffer);
                ResourceLocation fluid = buffer.readResourceLocation();
                return new MoltenBlastingRecipe(params, fluid);
            }
        );

        @Override
        public MapCodec<MoltenBlastingRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, MoltenBlastingRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
