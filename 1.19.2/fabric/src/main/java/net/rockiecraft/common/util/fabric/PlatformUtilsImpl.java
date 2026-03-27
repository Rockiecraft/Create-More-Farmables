package net.rockiecraft.common.util.fabric;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.rockiecraft.foundaton.registry.recipe.condition.IRecipeConditionSerializer;

import java.util.function.Supplier;

public class PlatformUtilsImpl {
    public static CreativeModeTab createTab(ResourceLocation loc, Supplier<ItemStack> icon) {
        return FabricItemGroupBuilder.build(loc, icon);
    }

    public static void registerRecipeConditionSerializer(IRecipeConditionSerializer<?> recipeConditionSerializer) {
        ResourceConditions.register(recipeConditionSerializer.getId(), json -> recipeConditionSerializer.readJson(json).test());
    }
}
