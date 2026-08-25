package com.rockiecraft.create_more_farmables.v1_21_1.foundation.compat.jei;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.AllFluids;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.advancedassembly.AdvancedAssemblyRecipe;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.advancedassembly.AdvancedAssemblyStep;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.dyesplashing.DyeSplashingRecipe;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.dyesplashing.DyeSplashingRecipeType;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.moltenblasting.MoltenBlastingRecipe;
import com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.moltenblasting.MoltenBlastingRecipeType;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllPartialModels;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.compat.jei.category.CreateRecipeCategory;
import com.simibubi.create.compat.jei.category.animations.AnimatedCrushingWheels;
import com.simibubi.create.compat.jei.category.animations.AnimatedDeployer;
import com.simibubi.create.compat.jei.category.animations.AnimatedKinetics;
import com.simibubi.create.compat.jei.category.animations.AnimatedMixer;
import com.simibubi.create.compat.jei.category.animations.AnimatedPress;
import com.simibubi.create.compat.jei.category.animations.AnimatedSaw;
import com.simibubi.create.compat.jei.category.animations.AnimatedSpout;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import com.simibubi.create.content.fluids.transfer.FillingRecipe;
import com.simibubi.create.content.kinetics.mixer.MixingRecipe;
import com.simibubi.create.content.processing.basin.BasinRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingOutput;
import com.simibubi.create.foundation.gui.AllGuiTextures;
import com.simibubi.create.foundation.gui.AllIcons;
import com.simibubi.create.foundation.utility.CreateLang;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;

import net.createmod.catnip.gui.element.GuiGameElement;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

import java.util.Arrays;

public class AdvancedAssemblyCategory extends CreateRecipeCategory<AdvancedAssemblyRecipe> {

    private static final int ICON = 18;
    private static final int MARGIN = 3;

    private static final int COLUMN = 34;
    private static final int MAX_COLUMNS = 8;
    private static final int ROW_HEIGHT = 78;
    private static final int NUMERAL_Y = 2;

    private static final int ANIM_Y = 50;

    private static final int FAN_SCALE = 13;

    private static final int HORIZONTAL_SHIFT = -8;

    // JEI's recipe area is 198 wide; its height is min(screen height - 58, maxRecipeGuiHeight).
    private static final int MAX_WIDTH = 198;
    private static final int DEFAULT_MAX_HEIGHT = 350;
    private static final int JEI_TOP_OFFSET = 58;

    private static final int TERMINAL_GAP = 2;
    private static final int BOTTOM_PADDING = 3;
    private static final int ARROW_HEIGHT = 10;

    private static final String[] ROMANS = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII",
            "IX", "X", "XI", "XII", "XIII", "XIV", "XV" };

    private final AnimatedCrushingWheels crushingWheels = new AnimatedCrushingWheels();
    private final AnimatedDeployer deployer = new AnimatedDeployer();
    private final AnimatedPress press = new AnimatedPress(false);
    private final AnimatedSaw saw = new AnimatedSaw();
    private final AnimatedSpout spout = new AnimatedSpout();
    private final AnimatedMixer mixer = new AnimatedMixer();

    // Size of the recipe currently being laid out, updated in setRecipe(). JEI queries these right
    // after setRecipe() while creating the layout, so they describe that exact recipe.
    private int layoutWidth = MAX_WIDTH;
    private int layoutHeight = DEFAULT_MAX_HEIGHT;

    public AdvancedAssemblyCategory(Info<AdvancedAssemblyRecipe> info) {
        super(info);
    }

    @Override
    public int getWidth() {
        return layoutWidth;
    }

    @Override
    public int getHeight() {
        return layoutHeight;
    }

    @Override
    protected void setRecipe(IRecipeLayoutBuilder builder, AdvancedAssemblyRecipe recipe, IFocusGroup focuses) {
        List<AdvancedAssemblyStep> sequence = recipe.getSequence();
        layoutWidth = widthFor(sequence.size());
        layoutHeight = cappedHeight(sequence.size());
        int terminalY = terminalY(sequence.size());
        int firstStepCenter = stepCenterX(0, sequence.size());

        int rawInputX = firstStepCenter - COLUMN / 2 - 2 * ICON - MARGIN;

        int inputX = Math.max(MARGIN + 2, rawInputX);
        int totalRows = rowCount(sequence.size());
        int inputY = ANIM_Y + 24;
        builder.addSlot(RecipeIngredientRole.INPUT, inputX, inputY)
                .setBackground(getRenderedSlot(), -1, -1)
                .addItemStacks(List.of(recipe.getIngredient().getItems()));

        for (int i = 0; i < sequence.size(); i++)
            addStepRequirements(builder, sequence.get(i), stepCenterX(i, sequence.size()), stepTopY(i));

        if (recipe.resultPool.isEmpty() || sequence.isEmpty())
            return;
        ProcessingOutput primaryResult = recipe.resultPool.getFirst();
        int lastStepCenter = stepCenterX(sequence.size() - 1, sequence.size());

        int visibleLastStep = Math.min(sequence.size() - 1, MAX_COLUMNS * 2 - 1);
        int outputX = lastStepCenter + COLUMN / 2 + ICON + MARGIN;
        int outputY = stepTopY(visibleLastStep) + ANIM_Y + 24;
        builder.addSlot(RecipeIngredientRole.OUTPUT, outputX, outputY)
                .setBackground(getRenderedSlot(primaryResult), -1, -1)
                .addItemStack(primaryResult.getStack())
                .addRichTooltipCallback(addStochasticTooltip(primaryResult));
    }

    private void addStepRequirements(IRecipeLayoutBuilder builder, AdvancedAssemblyStep step, int centerX, int topY) {
        RecipeType<?> type = step.getStepType();
        int requirementY = topY + 14;
        if (type == AllRecipeTypes.DEPLOYING.getType() && step.getRecipe().getIngredients().size() > 1) {
            builder.addSlot(RecipeIngredientRole.INPUT, centerX - ICON / 2, requirementY)
                    .setBackground(getRenderedSlot(), -1, -1)
                    .addIngredients(step.getRecipe().getIngredients().get(1));
        } else if (type == AllRecipeTypes.FILLING.getType() && step.getRecipe() instanceof FillingRecipe filling) {
            addFluidSlot(builder, centerX - ICON / 2, requirementY, filling.getRequiredFluid());
        } else if (type == AllRecipeTypes.MIXING.getType() && step.getRecipe() instanceof BasinRecipe mixing) {
            if (mixing.getIngredients().size() > 1) {
                var itemSlot = builder.addSlot(RecipeIngredientRole.INPUT, centerX - ICON - 1, requirementY)
                        .setBackground(getRenderedSlot(), -1, -1);
                mixing.getIngredients().subList(1, mixing.getIngredients().size()).forEach(itemSlot::addIngredients);
            }
            if (!mixing.getFluidIngredients().isEmpty())
                addFluidSlot(builder, centerX + 1, requirementY, mixing.getFluidIngredients().getFirst());
        }
    }

    @Override
    protected void draw(AdvancedAssemblyRecipe recipe, IRecipeSlotsView slotsView, GuiGraphics graphics,
                        double mouseX, double mouseY) {
        Font font = Minecraft.getInstance().font;
        List<AdvancedAssemblyStep> sequence = recipe.getSequence();
        for (int i = 0; i < sequence.size(); i++) {
            int x = stepCenterX(i, sequence.size());
            int y = stepTopY(i);
            MutableComponent numeral = Component.literal(ROMANS[Math.min(i, ROMANS.length - 1)]);
            graphics.drawString(font, numeral, x - font.width(numeral) / 2, y + NUMERAL_Y, 0x888888, false);
            drawStepAnimation(graphics, sequence.get(i), x, y + ANIM_Y);
        }
        int totalRows = rowCount(sequence.size());
        int visibleRows = Math.min(totalRows, 2);
        for (int r = 0; r < visibleRows; r++) {
            int arrowY = stepTopY(r * MAX_COLUMNS) + ANIM_Y + 24;
            AllGuiTextures.JEI_LONG_ARROW.render(graphics, (widthFor(sequence.size()) - 71) / 2, arrowY);
        }
        if (recipe.getLoops() > 1) {
            int repeatY = terminalY(sequence.size()) + 3;
            AllIcons.I_SEQ_REPEAT.render(graphics, 32, repeatY);
            graphics.drawString(font, Component.literal("x" + recipe.getLoops()), 50, repeatY + 4, 0x888888, false);
        }
    }

    @Override
    public @NotNull List<Component> getTooltipStrings(AdvancedAssemblyRecipe recipe, IRecipeSlotsView slotsView,
                                                      double mouseX, double mouseY) {
        List<AdvancedAssemblyStep> sequence = recipe.getSequence();
        for (int i = 0; i < sequence.size(); i++) {
            int x = stepCenterX(i, sequence.size()) - COLUMN / 2;
            int y = stepTopY(i);
            if (mouseX >= x && mouseX < x + COLUMN && mouseY >= y && mouseY < y + ROW_HEIGHT) {
                List<Component> tooltip = new ArrayList<>();
                tooltip.add(CreateLang.translateDirect("recipe.assembly.step", i + 1));
                tooltip.add(stepDescription(sequence.get(i)).withStyle(ChatFormatting.DARK_GREEN));
                return tooltip;
            }
        }
        return List.of();
    }


    private int stepCenterX(int index, int totalSteps) {
        int row = index / MAX_COLUMNS;
        int rowStartIndex = row * MAX_COLUMNS;
        int remaining = Math.max(totalSteps - rowStartIndex, 0);
        int columnsInRow = Math.min(remaining, MAX_COLUMNS);
        int indexInRow = index % MAX_COLUMNS;
        int rowWidth = columnsInRow * COLUMN;
        int start = (widthFor(totalSteps) - rowWidth) / 2 + COLUMN / 2 + HORIZONTAL_SHIFT;
        return start + indexInRow * COLUMN;
    }

    private int stepTopY(int index) {
        int row = index / MAX_COLUMNS;
        if (row == 0)
            return 0;
        return row * (ROW_HEIGHT + ARROW_HEIGHT + TERMINAL_GAP);
    }

    private int terminalY(int stepCount) {
        int rows = rowCount(stepCount);
        return rows * (ROW_HEIGHT + ARROW_HEIGHT + TERMINAL_GAP) + TERMINAL_GAP;
    }

    private static int rowCount(int steps) {
        return Math.max(1, (steps + MAX_COLUMNS - 1) / MAX_COLUMNS);
    }


    private static int widthFor(int steps) {
        int cappedSteps = Math.min(steps, MAX_COLUMNS * 2);
        int stepsInWidestRow = Math.min(cappedSteps, MAX_COLUMNS);
        int needed = stepsInWidestRow * COLUMN + 2 * (ICON + MARGIN);
        return Math.max(MAX_WIDTH, needed);
    }


    private static int heightFor(int steps) {
        int rows = Math.min(rowCount(steps), 2);
        return rows * (ROW_HEIGHT + ARROW_HEIGHT + TERMINAL_GAP) + TERMINAL_GAP + ICON + BOTTOM_PADDING;
    }


    private int cappedHeight(int steps) {
        return heightFor(steps);
    }

    private int maxHeight() {
        Minecraft mc = Minecraft.getInstance();
        if (mc == null || mc.getWindow() == null)
            return DEFAULT_MAX_HEIGHT;
        return Math.min(DEFAULT_MAX_HEIGHT, mc.getWindow().getGuiScaledHeight() - JEI_TOP_OFFSET);
    }

    private void drawStepAnimation(GuiGraphics graphics, AdvancedAssemblyStep step, int x, int y) {
        RecipeType<?> type = step.getStepType();

        if (type == AllRecipeTypes.CRUSHING.getType()) {
            drawCrushingWheels(graphics, x, y);
            return;
        }
        if (type == AllRecipeTypes.DEPLOYING.getType()) {
            drawCompact(graphics, x, y, deployer, .55f, 0);
            return;
        }
        if (type == AllRecipeTypes.PRESSING.getType()) {
            drawCompact(graphics, x, y, press, .5f, 0);
            return;
        }
        if (type == AllRecipeTypes.CUTTING.getType()) {
            drawCompact(graphics, x, y, saw, .5f, 15);
            return;
        }
        if (type == AllRecipeTypes.FILLING.getType() && step.getRecipe() instanceof FillingRecipe filling) {
            drawSpout(graphics, x, y, filling);
            return;
        }
        if (type == AllRecipeTypes.MIXING.getType() && step.getRecipe() instanceof MixingRecipe) {
            drawCompact(graphics, x, y, mixer, .5f, 0);
            return;
        }
        if (type == RecipeType.SMELTING || type == RecipeType.BLASTING) {
            drawFan(graphics, x, y, () -> Fluids.LAVA);
            return;
        }
        if (type == AllRecipeTypes.SPLASHING.getType()) {
            drawFan(graphics, x, y, () -> Fluids.WATER);
            return;
        }
        if (type == AllRecipeTypes.HAUNTING.getType()) {
            drawHauntingFan(graphics, x, y);
            return;
        }
        if (type == MoltenBlastingRecipeType.MOLTEN_BLASTING.getType()
                && step.getRecipe() instanceof MoltenBlastingRecipe moltenBlasting) {
            drawFan(graphics, x, y, () -> moltenFluid(moltenBlasting.getFluid()));
            return;
        }
        if (type == DyeSplashingRecipeType.DYE_SPLASHING.getType()
                && step.getRecipe() instanceof DyeSplashingRecipe dyeSplashing) {
            drawFan(graphics, x, y, () -> dyedWaterFluid(dyeSplashing));
        }
    }

    private void drawCrushingWheels(GuiGraphics graphics, int x, int y) {

        PoseStack ms = graphics.pose();
        ms.pushPose();

        ms.translate(x - COMPACT_X_OFFSET, y, 100);

        int scale = FAN_SCALE;

        BlockState wheel = AllBlocks.CRUSHING_WHEEL.getDefaultState()
                .setValue(BlockStateProperties.AXIS, Direction.Axis.X);

        ms.translate(0, 0, 150);
        ms.mulPose(Axis.XP.rotationDegrees(70f));
        ms.mulPose(Axis.YP.rotationDegrees(-5f));

        float spin = AnimatedKinetics.getCurrentAngle();

        AnimatedKinetics.defaultBlockElement(wheel)
                .rotateBlock(0, 90, spin)
                .atLocal(0.5, -1.0, -1.0)
                .scale(12)
                .render(graphics);

        AnimatedKinetics.defaultBlockElement(wheel)
                .rotateBlock(0, 90, -spin)
                .atLocal(0.2, 5.0, 0.5)
                .scale(13)
                .render(graphics);

        ms.popPose();
    }

    private static final int COMPACT_X_OFFSET = 4;
    private static void drawCompact(GuiGraphics graphics, int x, int y, AnimatedKinetics animation, float scale, int animationY) {
        PoseStack ms = graphics.pose();
        ms.pushPose();

        ms.translate(x - COMPACT_X_OFFSET, y, 0);
        ms.scale(scale, scale, scale);
        animation.draw(graphics, 0, animationY);
        ms.popPose();
    }

    private void drawSpout(GuiGraphics graphics, int x, int y, FillingRecipe filling) {
        PoseStack ms = graphics.pose();
        ms.pushPose();

        ms.translate(x - COMPACT_X_OFFSET, y, 0);
        ms.scale(.55f, .55f, .55f);
        spout.withFluids(Arrays.asList(filling.getRequiredFluid().getFluids())).draw(graphics, 0, 0);
        ms.popPose();
    }

    private static void drawHauntingFan(GuiGraphics graphics, int x, int y) {
        PoseStack ms = graphics.pose();
        ms.pushPose();
        ms.translate(x, y, 0);
        ms.mulPose(Axis.XP.rotationDegrees(-12.5f));
        ms.mulPose(Axis.YP.rotationDegrees(22.5f));
        AnimatedKinetics.defaultBlockElement(AllPartialModels.ENCASED_FAN_INNER).rotateBlock(180, 0, AnimatedKinetics.getCurrentAngle() * 16).scale(FAN_SCALE).render(graphics);
        AnimatedKinetics.defaultBlockElement(AllBlocks.ENCASED_FAN.getDefaultState()).rotateBlock(0, 180, 0).scale(FAN_SCALE).render(graphics);
        GuiGameElement.of(Blocks.SOUL_FIRE.defaultBlockState()).scale(FAN_SCALE).atLocal(0, 0, 2).lighting(AnimatedKinetics.DEFAULT_LIGHTING).render(graphics);
        ms.popPose();
    }

    private static void drawFan(GuiGraphics graphics, int x, int y, java.util.function.Supplier<Fluid> fluid) {
        PoseStack ms = graphics.pose();
        ms.pushPose();
        ms.translate(x, y, 0);
        ms.mulPose(Axis.XP.rotationDegrees(-12.5f));
        ms.mulPose(Axis.YP.rotationDegrees(22.5f));

        AnimatedKinetics.defaultBlockElement(AllPartialModels.ENCASED_FAN_INNER)
                .rotateBlock(180, 0, AnimatedKinetics.getCurrentAngle() * 16)
                .scale(FAN_SCALE)
                .render(graphics);

        AnimatedKinetics.defaultBlockElement(AllBlocks.ENCASED_FAN.getDefaultState())
                .rotateBlock(0, 180, 0)
                .atLocal(0, 0, 0)
                .scale(FAN_SCALE)
                .render(graphics);

        Fluid attachedFluid = fluid.get();

        if (attachedFluid != Fluids.EMPTY)
            GuiGameElement.of(attachedFluid)
                    .scale(FAN_SCALE)
                    .atLocal(0, 0, 2)
                    .lighting(AnimatedKinetics.DEFAULT_LIGHTING)
                    .render(graphics);

        ms.popPose();
    }

    private static Fluid moltenFluid(ResourceLocation fluidId) {
        AllFluids.FluidData data = AllFluids.MOLTEN_FLUIDS.get(fluidId.getPath());
        return (data != null ? data : AllFluids.LIQUID_QUARTZ).source()
                .get();
    }

    private static Fluid dyedWaterFluid(DyeSplashingRecipe recipe) {
        DyeColor color = recipe.getColor() != null ? recipe.getColor() : DyeColor.WHITE;
        return AllFluids.DYED_WATER_BY_COLOR.get(color)
                .source()
                .get();
    }

    private static MutableComponent stepDescription(AdvancedAssemblyStep step) {
        RecipeType<?> type = step.getStepType();
        if (type == AllRecipeTypes.CRUSHING.getType())
            return CreateLang.translateDirect("create_more_farmables.recipe.advanced_assembly.step.crushing");
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
            return CreateLang.translateDirect("create_more_farmables.recipe.advanced_assembly.step.blasting");
        if (type == AllRecipeTypes.SPLASHING.getType())
            return CreateLang.translateDirect("create_more_farmables.recipe.advanced_assembly.step.splashing");
        if (type == AllRecipeTypes.HAUNTING.getType())
            return CreateLang.translateDirect("create_more_farmables.recipe.advanced_assembly.step.haunting");
        if (type == MoltenBlastingRecipeType.MOLTEN_BLASTING.getType())
            return CreateLang.translateDirect("create_more_farmables.recipe.advanced_assembly.step.molten_blasting");
        if (type == DyeSplashingRecipeType.DYE_SPLASHING.getType())
            return CreateLang.translateDirect("create_more_farmables.recipe.advanced_assembly.step.dye_splashing");
        return Component.literal("?");
    }
}
