package com.rockiecraft.create_more_farmables.v1_21_1.foundation.compat.jei;

import java.util.List;
import java.util.function.Supplier;

import com.rockiecraft.create_more_farmables.v1_21_1.CreateMoreFarmables;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.advancedassembly.AdvancedAssemblyRecipe;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.advancedassembly.AdvancedAssemblyRecipeType;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.dyesplashing.DyeSplashingRecipe;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.dyesplashing.DyeSplashingRecipeType;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.moltenblasting.MoltenBlastingRecipe;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.moltenblasting.MoltenBlastingRecipeType;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.compat.jei.DoubleItemIcon;
import com.simibubi.create.compat.jei.EmptyBackground;
import com.simibubi.create.compat.jei.category.CreateRecipeCategory;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;

import static mezz.jei.api.recipe.RecipeType.createRecipeHolderType;

@JeiPlugin
public class CreateMoreFarmablesJeiPlugin implements IModPlugin {

    private static final ResourceLocation ID = CreateMoreFarmables.id("jei_plugin");

    private DyeSplashingCategory dyeSplashingCategory;
    private MoltenBlastingCategory moltenBlastingCategory;
    private AdvancedAssemblyCategory advancedAssemblyCategory;

    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IDrawable background = new EmptyBackground(178, 72);

        IDrawable dyeIcon = new DoubleItemIcon(
            () -> new ItemStack(AllItems.PROPELLER.get()),
            () -> new ItemStack(Items.RED_DYE));

        Supplier<List<RecipeHolder<DyeSplashingRecipe>>> dyeSplashingRecipes = () -> {
            Minecraft minecraft = Minecraft.getInstance();
            if (minecraft.getConnection() == null)
                return List.of();
            return minecraft.getConnection()
                .getRecipeManager()
                .getAllRecipesFor(DyeSplashingRecipeType.DYE_SPLASHING.<
                    com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.dyesplashing.DyeSplashingRecipeInput, DyeSplashingRecipe>getType());
        };

        CreateRecipeCategory.Info<DyeSplashingRecipe> dyeInfo = new CreateRecipeCategory.Info<>(
            createRecipeHolderType(CreateMoreFarmables.id("dye_splashing")),
            Component.translatable("recipe." + CreateMoreFarmables.MODID + ".dye_splashing"),
            background, dyeIcon, dyeSplashingRecipes,
            List.of(AllBlocks.ENCASED_FAN::asStack));

        dyeSplashingCategory = new DyeSplashingCategory(dyeInfo);

        IDrawable moltenIcon = new DoubleItemIcon(
            () -> new ItemStack(AllItems.PROPELLER.get()),
            () -> new ItemStack(Items.MAGMA_CREAM));

        Supplier<List<RecipeHolder<MoltenBlastingRecipe>>> moltenBlastingRecipes = () -> {
            Minecraft minecraft = Minecraft.getInstance();
            if (minecraft.getConnection() == null)
                return List.of();
            return minecraft.getConnection()
                .getRecipeManager()
                .getAllRecipesFor(MoltenBlastingRecipeType.MOLTEN_BLASTING.<
                    com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.moltenblasting.MoltenBlastingRecipeInput, MoltenBlastingRecipe>getType());
        };

        CreateRecipeCategory.Info<MoltenBlastingRecipe> moltenInfo = new CreateRecipeCategory.Info<>(
            createRecipeHolderType(CreateMoreFarmables.id("molten_blasting")),
            Component.translatable("recipe." + CreateMoreFarmables.MODID + ".molten_blasting"),
            background, moltenIcon, moltenBlastingRecipes,
            List.of(AllBlocks.ENCASED_FAN::asStack));

        moltenBlastingCategory = new MoltenBlastingCategory(moltenInfo);

        registration.addRecipeCategories(dyeSplashingCategory, moltenBlastingCategory, advancedAssemblyCategory());
    }

    private AdvancedAssemblyCategory advancedAssemblyCategory() {

        IDrawable background = new EmptyBackground(180, 190);
        IDrawable icon = new DoubleItemIcon(
            () -> new ItemStack(AllItems.PROPELLER.get()),
            () -> AllBlocks.CRUSHING_WHEEL.asStack());

        Supplier<List<RecipeHolder<AdvancedAssemblyRecipe>>> recipes = () -> {
            Minecraft minecraft = Minecraft.getInstance();
            if (minecraft.getConnection() == null)
                return List.of();
            return minecraft.getConnection()
                .getRecipeManager()
                .getAllRecipesFor(AdvancedAssemblyRecipeType.ADVANCED_ASSEMBLY.get());
        };

        CreateRecipeCategory.Info<AdvancedAssemblyRecipe> info = new CreateRecipeCategory.Info<>(
            createRecipeHolderType(CreateMoreFarmables.id("advanced_assembly")),
            Component.translatable("recipe." + CreateMoreFarmables.MODID + ".advanced_assembly"),
            background, icon, recipes,
            List.of(AllBlocks.CRUSHING_WHEEL::asStack, AllBlocks.ENCASED_FAN::asStack));

        advancedAssemblyCategory = new AdvancedAssemblyCategory(info);
        return advancedAssemblyCategory;
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        dyeSplashingCategory.registerRecipes(registration);
        moltenBlastingCategory.registerRecipes(registration);
        advancedAssemblyCategory.registerRecipes(registration);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        dyeSplashingCategory.registerCatalysts(registration);
        moltenBlastingCategory.registerCatalysts(registration);
        advancedAssemblyCategory.registerCatalysts(registration);
    }
}
