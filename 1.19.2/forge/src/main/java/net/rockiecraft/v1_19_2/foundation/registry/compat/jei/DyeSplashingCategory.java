package net.rockiecraft.v1_20_1.foundation.registry.compat.jei;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllPartialModels;
import com.simibubi.create.compat.jei.category.ProcessingViaFanCategory;
import com.simibubi.create.compat.jei.category.animations.AnimatedKinetics;
import com.simibubi.create.foundation.gui.AllGuiTextures;
import com.simibubi.create.foundation.gui.element.GuiGameElement;

import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.material.Fluid;
import net.rockiecraft.v1_19_2.CreateMoreFarmables;
import net.rockiecraft.v1_20_1.foundation.AllFluids;
import net.rockiecraft.v1_20_1.foundation.registry.recipe.dyesplashing.DyeSplashingRecipe;

public class DyeSplashingCategory extends ProcessingViaFanCategory.MultiOutput<DyeSplashingRecipe> {

	public static final RecipeType<DyeSplashingRecipe> TYPE = new RecipeType<>(
		new ResourceLocation(CreateMoreFarmables.MOD_ID, "dye_splashing"), DyeSplashingRecipe.class);

	public DyeSplashingCategory(Info<DyeSplashingRecipe> info) {
		super(info);
	}

	@Override
	public void draw(DyeSplashingRecipe recipe, @NotNull IRecipeSlotsView iRecipeSlotsView, PoseStack matrixStack,
		double mouseX, double mouseY) {
		renderWidgets(matrixStack, recipe, mouseX, mouseY);

		matrixStack.pushPose();
		translateFan(matrixStack);
		matrixStack.mulPose(Vector3f.XP.rotationDegrees(-12.5f));
		matrixStack.mulPose(Vector3f.YP.rotationDegrees(22.5f));

		AnimatedKinetics.defaultBlockElement(AllPartialModels.ENCASED_FAN_INNER)
			.rotateBlock(180, 0, AnimatedKinetics.getCurrentAngle() * 16)
			.scale(SCALE)
			.render(matrixStack);

		AnimatedKinetics.defaultBlockElement(AllBlocks.ENCASED_FAN.getDefaultState())
			.rotateBlock(0, 180, 0)
			.atLocal(0, 0, 0)
			.scale(SCALE)
			.render(matrixStack);

		renderAttachedFluid(matrixStack, recipe.getColor());
		matrixStack.popPose();
	}

	@Override
	protected void renderAttachedBlock(@NotNull PoseStack matrixStack) {
		// Never actually called (draw() is fully overridden above) - only here to satisfy the
		// abstract method. Falls back to plain white dyed water if it ever were.
		renderAttachedFluid(matrixStack, DyeColor.WHITE);
	}

	private void renderAttachedFluid(PoseStack matrixStack, @Nullable DyeColor color) {
		DyeColor renderedColor = color != null ? color : DyeColor.WHITE;
		Fluid fluid = AllFluids.DYED_WATER_BY_COLOR.get(renderedColor)
			.source()
			.get();
		GuiGameElement.of(fluid)
			.scale(SCALE)
			.atLocal(0, 0, 2)
			.lighting(AnimatedKinetics.DEFAULT_LIGHTING)
			.render(matrixStack);
	}

	@Override
	protected AllGuiTextures getBlockShadow() {
		return AllGuiTextures.JEI_SHADOW;
	}

}
