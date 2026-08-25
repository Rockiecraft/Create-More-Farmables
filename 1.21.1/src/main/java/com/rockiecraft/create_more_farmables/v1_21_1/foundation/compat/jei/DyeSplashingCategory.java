package com.rockiecraft.create_more_farmables.v1_21_1.foundation.compat.jei;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.AllFluids;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.dyesplashing.DyeSplashingRecipe;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllPartialModels;
import com.simibubi.create.compat.jei.category.ProcessingViaFanCategory;
import com.simibubi.create.compat.jei.category.animations.AnimatedKinetics;
import com.simibubi.create.foundation.gui.AllGuiTextures;

import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import net.createmod.catnip.gui.element.GuiGameElement;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.material.Fluid;

public class DyeSplashingCategory extends ProcessingViaFanCategory.MultiOutput<DyeSplashingRecipe> {

    public DyeSplashingCategory(Info<DyeSplashingRecipe> info) {
        super(info);
    }

    @Override
    public void draw(DyeSplashingRecipe recipe, @NotNull IRecipeSlotsView iRecipeSlotsView, GuiGraphics graphics,
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

        renderAttachedFluid(graphics, recipe.getColor());
        matrixStack.popPose();
    }

    @Override
    protected void renderAttachedBlock(@NotNull GuiGraphics graphics) {

        renderAttachedFluid(graphics, DyeColor.WHITE);
    }

    private void renderAttachedFluid(GuiGraphics graphics, @Nullable DyeColor color) {
        DyeColor renderedColor = color != null ? color : DyeColor.WHITE;
        Fluid fluid = AllFluids.DYED_WATER_BY_COLOR.get(renderedColor)
            .source()
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
