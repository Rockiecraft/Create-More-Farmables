package com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.moltenblasting;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record MoltenBlastingRecipeInput(ItemStack item, ResourceLocation fluid) implements RecipeInput {

    @Override
    public ItemStack getItem(int index) {
        if (index != 0) {
            throw new IllegalArgumentException("No item for index " + index);
        }
        return item;
    }

    @Override
    public int size() {
        return 1;
    }
}
