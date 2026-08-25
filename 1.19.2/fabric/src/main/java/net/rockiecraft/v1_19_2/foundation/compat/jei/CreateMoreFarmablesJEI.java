package net.rockiecraft.v1_20_1.foundation.compat.jei;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import javax.annotation.Nonnull;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.compat.jei.DoubleItemIcon;
import com.simibubi.create.compat.jei.EmptyBackground;
import com.simibubi.create.compat.jei.category.CreateRecipeCategory;

import io.github.fabricators_of_create.porting_lib.mixin.common.accessor.RecipeManagerAccessor;
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
import net.minecraft.world.item.crafting.Recipe;
import net.rockiecraft.v1_19_2.CreateMoreFarmables;
import net.rockiecraft.v1_20_1.foundation.registry.recipe.dyesplashing.DyeSplashingRecipe;
import net.rockiecraft.v1_20_1.foundation.registry.recipe.dyesplashing.DyeSplashingRecipeType;
import net.rockiecraft.v1_20_1.foundation.registry.recipe.moltenblasting.MoltenBlastingRecipe;
import net.rockiecraft.v1_20_1.foundation.registry.recipe.moltenblasting.MoltenBlastingRecipeType;

@JeiPlugin
public class CreateMoreFarmablesJEI implements IModPlugin {

	private static final ResourceLocation ID = new ResourceLocation(CreateMoreFarmables.MOD_ID, "jei_plugin");

	private DyeSplashingCategory dyeSplashingCategory;
	private MoltenBlastingCategory moltenBlastingCategory;

	@Override
	@Nonnull
	public ResourceLocation getPluginUid() {
		return ID;
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		IDrawable background = new EmptyBackground(178, 72);
		IDrawable icon = new DoubleItemIcon(
			() -> new ItemStack(AllItems.PROPELLER.get()),
			() -> new ItemStack(Items.RED_DYE));

		Supplier<List<DyeSplashingRecipe>> recipesSupplier = () -> {
			List<DyeSplashingRecipe> recipes = new ArrayList<>();
			Minecraft minecraft = Minecraft.getInstance();
			if (minecraft.getConnection() == null)
				return recipes;

			Map<ResourceLocation, Recipe<?>> byId = ((RecipeManagerAccessor) minecraft.getConnection()
				.getRecipeManager()).port_lib$getRecipes()
				.get(DyeSplashingRecipeType.DYE_SPLASHING.getType());
			if (byId != null)
				byId.values().forEach(recipe -> recipes.add((DyeSplashingRecipe) recipe));

			return recipes;
		};

		CreateRecipeCategory.Info<DyeSplashingRecipe> info = new CreateRecipeCategory.Info<>(
			DyeSplashingCategory.TYPE,
			Component.translatable("recipe." + CreateMoreFarmables.MOD_ID + ".dye_splashing"),
			background, icon, recipesSupplier,
			List.of(AllBlocks.ENCASED_FAN::asStack));

		dyeSplashingCategory = new DyeSplashingCategory(info);
		registration.addRecipeCategories(dyeSplashingCategory);

		IDrawable moltenIcon = new DoubleItemIcon(
			() -> new ItemStack(AllItems.PROPELLER.get()),
			() -> new ItemStack(Items.MAGMA_CREAM));

		Supplier<List<MoltenBlastingRecipe>> moltenRecipesSupplier = () -> {
			List<MoltenBlastingRecipe> recipes = new ArrayList<>();
			Minecraft minecraft = Minecraft.getInstance();
			if (minecraft.getConnection() == null)
				return recipes;

			Map<ResourceLocation, Recipe<?>> byId = ((RecipeManagerAccessor) minecraft.getConnection()
				.getRecipeManager()).port_lib$getRecipes()
				.get(MoltenBlastingRecipeType.MOLTEN_BLASTING.getType());
			if (byId != null)
				byId.values().forEach(recipe -> recipes.add((MoltenBlastingRecipe) recipe));

			return recipes;
		};

		CreateRecipeCategory.Info<MoltenBlastingRecipe> moltenInfo = new CreateRecipeCategory.Info<>(
			MoltenBlastingCategory.TYPE,
			Component.translatable("recipe." + CreateMoreFarmables.MOD_ID + ".molten_blasting"),
			background, moltenIcon, moltenRecipesSupplier,
			List.of(AllBlocks.ENCASED_FAN::asStack));

		moltenBlastingCategory = new MoltenBlastingCategory(moltenInfo);
		registration.addRecipeCategories(moltenBlastingCategory);
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		dyeSplashingCategory.registerRecipes(registration);
		moltenBlastingCategory.registerRecipes(registration);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		dyeSplashingCategory.registerCatalysts(registration);
		moltenBlastingCategory.registerCatalysts(registration);
	}

}
