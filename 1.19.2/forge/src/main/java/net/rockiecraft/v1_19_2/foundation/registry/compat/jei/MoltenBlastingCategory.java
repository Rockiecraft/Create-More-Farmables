package net.rockiecraft.v1_20_1.foundation.registry.compat.jei;

import org.jetbrains.annotations.NotNull;

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
import net.minecraft.world.level.material.Fluid;
import net.rockiecraft.v1_19_2.CreateMoreFarmables;
import net.rockiecraft.v1_20_1.foundation.AllFluids;
import net.rockiecraft.v1_20_1.foundation.registry.recipe.moltenblasting.MoltenBlastingRecipe;

public class MoltenBlastingCategory extends ProcessingViaFanCategory.MultiOutput<MoltenBlastingRecipe> {

	public static final RecipeType<MoltenBlastingRecipe> TYPE = new RecipeType<>(
		new ResourceLocation(CreateMoreFarmables.MOD_ID, "molten_blasting"), MoltenBlastingRecipe.class);

	public MoltenBlastingCategory(Info<MoltenBlastingRecipe> info) {
		super(info);
	}

	@Override
	public void draw(MoltenBlastingRecipe recipe, @NotNull IRecipeSlotsView iRecipeSlotsView, PoseStack matrixStack,
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

		renderAttachedFluid(matrixStack, recipe.getFluid());
		matrixStack.popPose();
	}

	@Override
	protected void renderAttachedBlock(@NotNull PoseStack matrixStack) {
		// Never actually called (draw() is fully overridden above) - only here to satisfy the
		// abstract method. Falls back to liquid_quartz if it ever were.
		renderAttachedFluid(matrixStack, new ResourceLocation(CreateMoreFarmables.MOD_ID, "liquid_quartz"));
	}

	private void renderAttachedFluid(PoseStack matrixStack, ResourceLocation fluidId) {
		AllFluids.Registered registered = AllFluids.moltenFluidById(fluidId);
		Fluid fluid = (registered != null ? registered : AllFluids.LIQUID_QUARTZ).source()
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
