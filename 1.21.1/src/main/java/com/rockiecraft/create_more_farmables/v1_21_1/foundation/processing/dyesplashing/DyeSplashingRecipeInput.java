package com.rockiecraft.create_more_farmables.v1_21_1.foundation.processing.dyesplashing;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record DyeSplashingRecipeInput(ItemStack item, DyeColor color) implements RecipeInput {

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
