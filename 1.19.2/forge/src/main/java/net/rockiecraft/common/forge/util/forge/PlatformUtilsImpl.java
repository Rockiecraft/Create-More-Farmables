package net.rockiecraft.common.forge.util.forge;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.rockiecraft.common.forge.recipe.forge.RecipeConditionImpl;
import net.rockiecraft.foundaton.registry.recipe.config.condition.IRecipeConditionSerializer;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class PlatformUtilsImpl {
    public static CreativeModeTab createTab(ResourceLocation loc, Supplier<ItemStack> icon) {
        return new CreativeModeTab(loc.getNamespace() + "." + loc.getPath()) {
            @Override
            public @NotNull ItemStack makeIcon() {
                return icon.get();
            }
        };
    }

    public static void registerRecipeConditionSerializer(IRecipeConditionSerializer<?> recipeConditionSerializer) {
        CraftingHelper.register(new RecipeConditionImpl.Serializer(recipeConditionSerializer));
    }
}
