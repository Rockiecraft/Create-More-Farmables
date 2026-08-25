package net.rockiecraft.v1_20_1.foundation.registry.recipe.dyesplashing;

import org.jetbrains.annotations.Nullable;

import com.google.gson.JsonObject;
import com.simibubi.create.content.processing.recipe.ProcessingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder.ProcessingRecipeParams;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;

public class DyeSplashingRecipe extends ProcessingRecipe<DyeSplashingRecipe.DyeSplashingWrapper> {

    @Nullable
    private DyeColor color;

    public DyeSplashingRecipe(ProcessingRecipeParams params) {
        super(DyeSplashingRecipeType.DYE_SPLASHING, params);
    }

    @Override
    public boolean matches(DyeSplashingWrapper inv, Level level) {
        if (inv.isEmpty())
            return false;
        if (color != null && color != inv.color)
            return false;
        return ingredients.get(0)
            .test(inv.getItem(0));
    }

    @Nullable
    public DyeColor getColor() {
        return color;
    }

    @Override
    protected int getMaxInputCount() {
        return 1;
    }

    @Override
    protected int getMaxOutputCount() {
        return 12;
    }

    @Override
    public void readAdditional(JsonObject json) {
        super.readAdditional(json);
        color = GsonHelper.isValidNode(json, "color")
            ? DyeColor.byName(GsonHelper.getAsString(json, "color"), null)
            : null;
    }

    @Override
    public void writeAdditional(JsonObject json) {
        super.writeAdditional(json);
        if (color != null)
            json.addProperty("color", color.getName());
    }

    @Override
    public void readAdditional(FriendlyByteBuf buffer) {
        super.readAdditional(buffer);
        color = buffer.readBoolean() ? buffer.readEnum(DyeColor.class) : null;
    }

    @Override
    public void writeAdditional(FriendlyByteBuf buffer) {
        super.writeAdditional(buffer);
        buffer.writeBoolean(color != null);
        if (color != null)
            buffer.writeEnum(color);
    }

    public static class DyeSplashingWrapper extends SimpleContainer {
        @Nullable
        public DyeColor color;

        public DyeSplashingWrapper() {
            super(1);
        }
    }

}
