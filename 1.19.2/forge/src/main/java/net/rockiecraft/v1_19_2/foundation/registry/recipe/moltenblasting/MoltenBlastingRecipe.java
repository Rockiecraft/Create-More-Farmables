package net.rockiecraft.v1_20_1.foundation.registry.recipe.moltenblasting;

import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.simibubi.create.content.processing.recipe.ProcessingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder.ProcessingRecipeParams;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.level.Level;

public class MoltenBlastingRecipe extends ProcessingRecipe<MoltenBlastingRecipe.MoltenBlastingWrapper> {

    private ResourceLocation fluid;

    public MoltenBlastingRecipe(ProcessingRecipeParams params) {
        super(MoltenBlastingRecipeType.MOLTEN_BLASTING, params);
    }

    @Override
    public boolean matches(MoltenBlastingWrapper inv, Level level) {
        if (inv.isEmpty())
            return false;
        if (!fluid.equals(inv.fluid))
            return false;
        return ingredients.get(0)
            .test(inv.getItem(0));
    }

    public ResourceLocation getFluid() {
        return fluid;
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
        String fluidId = GsonHelper.getAsString(json, "fluid");
        fluid = ResourceLocation.tryParse(fluidId);
        if (fluid == null)
            throw new JsonSyntaxException("Not a valid resource location: " + fluidId);
    }

    @Override
    public void writeAdditional(JsonObject json) {
        super.writeAdditional(json);
        json.addProperty("fluid", fluid.toString());
    }

    @Override
    public void readAdditional(FriendlyByteBuf buffer) {
        super.readAdditional(buffer);
        fluid = buffer.readResourceLocation();
    }

    @Override
    public void writeAdditional(FriendlyByteBuf buffer) {
        super.writeAdditional(buffer);
        buffer.writeResourceLocation(fluid);
    }

    public static class MoltenBlastingWrapper extends SimpleContainer {
        public ResourceLocation fluid;

        public MoltenBlastingWrapper() {
            super(1);
        }
    }

}
