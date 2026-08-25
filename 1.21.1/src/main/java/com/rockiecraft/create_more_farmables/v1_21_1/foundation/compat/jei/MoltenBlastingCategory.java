package com.rockiecraft.create_more_farmables.v1_21_1.foundation.compat.jei;

import org.jetbrains.annotations.NotNull;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.AllFluids;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.moltenblasting.MoltenBlastingRecipe;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllPartialModels;
import com.simibubi.create.compat.jei.category.ProcessingViaFanCategory;
import com.simibubi.create.compat.jei.category.animations.AnimatedKinetics;
import com.simibubi.create.foundation.gui.AllGuiTextures;

import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import net.createmod.catnip.gui.element.GuiGameElement;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;

public class MoltenBlastingCategory extends ProcessingViaFanCategory.MultiOutput<MoltenBlastingRecipe> {

    public MoltenBlastingCategory(Info<MoltenBlastingRecipe> info) {
        super(info);
    }

    @Override
    public void draw(MoltenBlastingRecipe recipe, @NotNull IRecipeSlotsView iRecipeSlotsView, GuiGraphics graphics,
        double mouseX, double mouseY) {
        renderWidgets(graphics, recipe, mouseX, mouseY);

        PoseStack matrixStack = graphics.pose();
        matrixStack.pushPose();
        translateFan(matrixStack);
        matrixStack.mulPose(Axis.XP.rotationDegrees(-12.5f));
        matrixStack.mulPose(Axis.YP.rotationDegrees(22.5f));

        AnimatedKinetics.defaultBlockElement(AllPartialModels.ENCASED_FAN_INNER)
            .rotateBlock(180, 0, AnimatedKinetics.getCurrentAngle() * 16)
            .scale(SCALE)
            .render(graphics);

        AnimatedKinetics.defaultBlockElement(AllBlocks.ENCASED_FAN.getDefaultState())
            .rotateBlock(0, 180, 0)
            .atLocal(0, 0, 0)
            .scale(SCALE)
            .render(graphics);

        renderAttachedFluid(graphics, recipe.getFluid());
        matrixStack.popPose();
    }

    @Override
    protected void renderAttachedBlock(@NotNull GuiGraphics graphics) {

        renderAttachedFluid(graphics, ResourceLocation.fromNamespaceAndPath("create_more_farmables", "liquid_quartz"));
    }

    private void renderAttachedFluid(GuiGraphics graphics, ResourceLocation fluidId) {
        AllFluids.FluidData data = AllFluids.MOLTEN_FLUIDS.get(fluidId.getPath());
        Fluid fluid = (data != null ? data : AllFluids.LIQUID_QUARTZ).source()
            .get();
        GuiGameElement.of(fluid)
            .scale(SCALE)
            .atLocal(0, 0, 2)
            .lighting(AnimatedKinetics.DEFAULT_LIGHTING)
            .render(graphics);
    }

    @Override
    protected AllGuiTextures getBlockShadow() {
        return AllGuiTextures.JEI_SHADOW;
    }
}
