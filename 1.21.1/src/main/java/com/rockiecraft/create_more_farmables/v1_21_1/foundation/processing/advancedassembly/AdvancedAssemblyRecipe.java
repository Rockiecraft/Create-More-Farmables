package com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.advancedassembly;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.rockiecraft.create_more_farmables.v1_21_1.foundation.CmfDataComponents;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.CmfDataComponents.AdvancedAssembly;
import com.simibubi.create.content.processing.recipe.ProcessingOutput;
import com.simibubi.create.AllRecipeTypes;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.moltenblasting.MoltenBlastingRecipeType;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.dyesplashing.DyeSplashingRecipeType;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.items.wrapper.RecipeWrapper;

public class AdvancedAssemblyRecipe implements Recipe<RecipeWrapper> {
    protected AdvancedAssemblyRecipeType.Serializer serializer;

    protected Ingredient ingredient;
    protected List<AdvancedAssemblyStep> sequence;
    protected int loops;
    protected ProcessingOutput transitionalItem;

    public final List<ProcessingOutput> resultPool;

    public AdvancedAssemblyRecipe(AdvancedAssemblyRecipeType.Serializer serializer) {
        this.serializer = serializer;
        sequence = new ArrayList<>();
        resultPool = new ArrayList<>();
        loops = 1;
    }

    public boolean appliesTo(ResourceLocation id, ItemStack input) {
        if (input.has(CmfDataComponents.ADVANCED_ASSEMBLY)) {

            return getTransitionalItem().getItem() == input.getItem() && input
                    .get(CmfDataComponents.ADVANCED_ASSEMBLY)
                    .id().equals(id);
        }
        return ingredient.test(input);
    }

    public AdvancedAssemblyStep getNextStep(ItemStack input) {
        return sequence.get(getStep(input) % sequence.size());
    }

    public int getStep(ItemStack input) {
        if (!input.has(CmfDataComponents.ADVANCED_ASSEMBLY))
            return 0;

        return input.get(CmfDataComponents.ADVANCED_ASSEMBLY).step();
    }

    public ItemStack advance(ResourceLocation id, ItemStack input, RandomSource random) {
        int step = getStep(input);
        if ((step + 1) / sequence.size() >= loops) {
            ItemStack result = rollResult(random);
            return result.isEmpty() ? ItemStack.EMPTY : result.copyWithCount(result.getCount() * input.getCount());
        }

        ItemStack advancedItem;
        if (getTransitionalItem().getItem() == input.getItem()) {

            advancedItem = input.copyWithCount(input.getCount());
        } else {
            advancedItem = getTransitionalItem().copyWithCount(input.getCount());
        }
        AdvancedAssembly data = new AdvancedAssembly(id, step + 1, (step + 1f) / (sequence.size() * loops));
        advancedItem.set(CmfDataComponents.ADVANCED_ASSEMBLY, data);
        return advancedItem;
    }

    private ItemStack rollResult(RandomSource random) {
        float totalWeight = 0;
        for (ProcessingOutput entry : resultPool)
            totalWeight += entry.getChance();
        float number = random.nextFloat() * totalWeight;
        for (ProcessingOutput entry : resultPool) {
            number -= entry.getChance();
            if (number < 0)
                return entry.getStack()
                        .copy();
        }
        return ItemStack.EMPTY;
    }

    public int getLoops() {
        return loops;
    }

    public static Optional<AdvancedAssemblyRecipe> byId(Level level, ResourceLocation id) {
        return level.getRecipeManager()
                .byKey(id)
                .map(RecipeHolder::value)
                .filter(AdvancedAssemblyRecipe.class::isInstance)
                .map(AdvancedAssemblyRecipe.class::cast);
    }

    public static Optional<RecipeHolder<AdvancedAssemblyRecipe>> findStartingRecipe(Level level, ItemStack input,
                                                                                    Predicate<AdvancedAssemblyStep> firstStepFilter) {
        for (RecipeHolder<AdvancedAssemblyRecipe> holder : level.getRecipeManager()
                .getAllRecipesFor(AdvancedAssemblyRecipeType.ADVANCED_ASSEMBLY.get())) {
            AdvancedAssemblyRecipe recipe = holder.value();
            boolean ingredientMatches = !recipe.sequence.isEmpty() && recipe.ingredient.test(input);
            boolean firstStepMatches = !recipe.sequence.isEmpty() && firstStepFilter.test(recipe.sequence.get(0));
            if (recipe.sequence.isEmpty() || !ingredientMatches)
                continue;
            if (!firstStepMatches)
                continue;
            return Optional.of(holder);
        }
        return Optional.empty();
    }

    public static Optional<RecipeHolder<AdvancedAssemblyRecipe>> findForStep(Level level, ItemStack input,
                                                                              Predicate<AdvancedAssemblyStep> stepFilter) {
        if (!input.has(CmfDataComponents.ADVANCED_ASSEMBLY))
            return findStartingRecipe(level, input, stepFilter);

        AdvancedAssembly data = input.get(CmfDataComponents.ADVANCED_ASSEMBLY);
        return level.getRecipeManager().byKey(data.id())
                .filter(holder -> holder.value() instanceof AdvancedAssemblyRecipe)
                .map(holder -> new RecipeHolder<>(holder.id(), (AdvancedAssemblyRecipe) holder.value()))
                .filter(holder -> holder.value().appliesTo(holder.id(), input))
                .filter(holder -> !holder.value().getSequence().isEmpty())
                .filter(holder -> stepFilter.test(holder.value().getNextStep(input)));
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public List<AdvancedAssemblyStep> getSequence() {
        return sequence;
    }

    public ItemStack getTransitionalItem() {
        return transitionalItem.getStack();
    }

    @Override
    public boolean matches(RecipeWrapper inv, Level level) {
        return false;
    }

    @Override
    public ItemStack assemble(RecipeWrapper input, HolderLookup.Provider registries) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return resultPool.isEmpty() ? ItemStack.EMPTY : resultPool.getFirst()
                .getStack();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return serializer;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public RecipeType<?> getType() {
        return AdvancedAssemblyRecipeType.ADVANCED_ASSEMBLY.get();
    }

    @OnlyIn(Dist.CLIENT)
    public static void addToTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (!stack.has(CmfDataComponents.ADVANCED_ASSEMBLY))
            return;
        AdvancedAssembly data = stack.get(CmfDataComponents.ADVANCED_ASSEMBLY);

        Optional<RecipeHolder<?>> optionalRecipe = Minecraft.getInstance().level.getRecipeManager()
                .byKey(data.id());
        if (optionalRecipe.isEmpty())
            return;
        Recipe<?> recipe = optionalRecipe.get()
                .value();
        if (!(recipe instanceof AdvancedAssemblyRecipe advancedAssemblyRecipe))
            return;

        int length = advancedAssemblyRecipe.sequence.size();
        int step = advancedAssemblyRecipe.getStep(stack);
        int total = length * advancedAssemblyRecipe.loops;
        List<Component> tooltip = event.getToolTip();
        tooltip.add(CommonComponents.EMPTY);
        tooltip.add(Component.translatable("recipe.create_more_farmables.advanced_assembly")
                .withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.translatable("create_more_farmables.recipe.assembly.progress", step, total)
                .withStyle(ChatFormatting.DARK_GRAY));

        int remaining = total - step;
        for (int i = 0; i < length; i++) {
            if (i >= remaining)
                break;
            AdvancedAssemblyStep seqStep = advancedAssemblyRecipe.sequence.get((i + step) % length);
            Component textComponent = stepDescription(seqStep);
            if (i == 0)
                tooltip.add(Component.translatable("create_more_farmables.recipe.assembly.next", textComponent)
                        .withStyle(ChatFormatting.AQUA));
            else {
                tooltip.add(Component.literal("-> ").append(textComponent)
                        .withStyle(ChatFormatting.DARK_AQUA));
            }
        }
    }

    private static Component stepDescription(AdvancedAssemblyStep step) {
        RecipeType<?> type = step.getStepType();
        if (type == AllRecipeTypes.CRUSHING.getType())
            return Component.translatable("create_more_farmables.recipe.advanced_assembly.step.crushing");
        if (type == AllRecipeTypes.DEPLOYING.getType())
            return Component.literal("Deployer");
        if (type == AllRecipeTypes.PRESSING.getType())
            return Component.literal("Mechanical Press");
        if (type == AllRecipeTypes.CUTTING.getType())
            return Component.literal("Mechanical Saw");
        if (type == AllRecipeTypes.FILLING.getType())
            return Component.literal("Spout Filling");
        if (type == AllRecipeTypes.MIXING.getType())
            return Component.literal("Mechanical Mixer");
        if (type == RecipeType.SMELTING || type == RecipeType.BLASTING)
            return Component.translatable("create_more_farmables.recipe.advanced_assembly.step.blasting");
        if (type == AllRecipeTypes.SPLASHING.getType())
            return Component.translatable("create_more_farmables.recipe.advanced_assembly.step.splashing");
        if (type == AllRecipeTypes.HAUNTING.getType())
            return Component.translatable("create_more_farmables.recipe.advanced_assembly.step.haunting");
        if (type == MoltenBlastingRecipeType.MOLTEN_BLASTING.getType())
            return Component.translatable("create_more_farmables.recipe.advanced_assembly.step.molten_blasting");
        if (type == DyeSplashingRecipeType.DYE_SPLASHING.getType())
            return Component.translatable("create_more_farmables.recipe.advanced_assembly.step.dye_splashing");
        return Component.literal("?");
    }
}
