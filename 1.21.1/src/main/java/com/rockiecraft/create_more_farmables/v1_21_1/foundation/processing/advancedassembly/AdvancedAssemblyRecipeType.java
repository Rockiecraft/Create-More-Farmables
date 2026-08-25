package com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.advancedassembly;

import org.jetbrains.annotations.NotNull;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.rockiecraft.create_more_farmables.v1_21_1.CreateMoreFarmables;
import com.simibubi.create.content.processing.recipe.ProcessingOutput;

import net.createmod.catnip.codecs.stream.CatnipStreamCodecBuilders;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AdvancedAssemblyRecipeType {

    private static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
        DeferredRegister.create(Registries.RECIPE_SERIALIZER, CreateMoreFarmables.MODID);
    private static final DeferredRegister<RecipeType<?>> TYPES =
        DeferredRegister.create(Registries.RECIPE_TYPE, CreateMoreFarmables.MODID);

    private static final ResourceLocation ID = CreateMoreFarmables.id("advanced_assembly");

    public static final DeferredHolder<RecipeSerializer<?>, Serializer> SERIALIZER =
        SERIALIZERS.register("advanced_assembly", Serializer::new);

    public static final DeferredHolder<RecipeType<?>, RecipeType<AdvancedAssemblyRecipe>> ADVANCED_ASSEMBLY =
        TYPES.register("advanced_assembly", () -> RecipeType.simple(ID));

    public static void init(IEventBus modEventBus) {
        SERIALIZERS.register(modEventBus);
        TYPES.register(modEventBus);
    }

    public static class Serializer implements RecipeSerializer<AdvancedAssemblyRecipe> {

        private final MapCodec<AdvancedAssemblyRecipe> codec = RecordCodecBuilder.mapCodec(
            i -> i.group(
                Ingredient.CODEC.fieldOf("ingredient").forGetter(AdvancedAssemblyRecipe::getIngredient),
                ProcessingOutput.CODEC.fieldOf("transitional_item").forGetter(r -> r.transitionalItem),
                AdvancedAssemblyStep.CODEC.listOf().fieldOf("sequence").forGetter(AdvancedAssemblyRecipe::getSequence),
                ProcessingOutput.CODEC.listOf().fieldOf("results").forGetter(r -> r.resultPool),
                ExtraCodecs.NON_NEGATIVE_INT.optionalFieldOf("loops", 1).forGetter(AdvancedAssemblyRecipe::getLoops)
            ).apply(i, (ingredient, transitionalItem, sequence, results, loops) -> {
                AdvancedAssemblyRecipe recipe = new AdvancedAssemblyRecipe(this);
                recipe.ingredient = ingredient;
                recipe.transitionalItem = transitionalItem;
                recipe.sequence.addAll(sequence);
                recipe.resultPool.addAll(results);
                recipe.loops = loops;
                return recipe;
            })
        );

        private final StreamCodec<RegistryFriendlyByteBuf, AdvancedAssemblyRecipe> streamCodec = StreamCodec.composite(
            Ingredient.CONTENTS_STREAM_CODEC, AdvancedAssemblyRecipe::getIngredient,
            ProcessingOutput.STREAM_CODEC, r -> r.transitionalItem,
            CatnipStreamCodecBuilders.list(AdvancedAssemblyStep.STREAM_CODEC), AdvancedAssemblyRecipe::getSequence,
            CatnipStreamCodecBuilders.list(ProcessingOutput.STREAM_CODEC), r -> r.resultPool,
            ByteBufCodecs.VAR_INT, AdvancedAssemblyRecipe::getLoops,
            (ingredient, transitionalItem, sequence, results, loops) -> {
                AdvancedAssemblyRecipe recipe = new AdvancedAssemblyRecipe(this);
                recipe.ingredient = ingredient;
                recipe.transitionalItem = transitionalItem;
                recipe.sequence.addAll(sequence);
                recipe.resultPool.addAll(results);
                recipe.loops = loops;
                return recipe;
            }
        );

        @Override
        public @NotNull MapCodec<AdvancedAssemblyRecipe> codec() {
            return codec;
        }

        @Override
        public @NotNull StreamCodec<RegistryFriendlyByteBuf, AdvancedAssemblyRecipe> streamCodec() {
            return streamCodec;
        }
    }
}
