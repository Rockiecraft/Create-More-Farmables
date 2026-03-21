package net.rockiecraft.foundaton.registry;

import com.teamresourceful.resourcefulconfig.common.annotations.Config;
import com.teamresourceful.resourcefulconfig.common.annotations.ConfigEntry;
import com.teamresourceful.resourcefulconfig.common.config.EntryType;

@Config("create_more_farmables") // This defines the filename
public final class MyConfig {
    @ConfigEntry(id = "enableSpecialRecipe",
            type = EntryType.BOOLEAN,
            translation = "config.create_more_farmables.recipe")
    public static boolean enableSpecialRecipe = true;
}
