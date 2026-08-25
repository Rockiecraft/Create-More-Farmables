package net.rockiecraft.v1_20_1.foundation;

import com.teamresourceful.resourcefullib.common.item.tabs.ResourcefulCreativeTab;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.rockiecraft.v1_20_1.CreateMoreFarmables;

import java.util.function.Supplier;

public class CreativeModeTabs {


    public static final Supplier<CreativeModeTab> CREATE_MORE_FARMABLES_MAIN_TAB = new ResourcefulCreativeTab(
            new ResourceLocation(CreateMoreFarmables.MOD_ID, "main_tab"))
            .setItemIcon(AllItems.SHULKER_SHELL_FRAGMENT)
            .addRegistry(AllItems.BASIC_ITEMS)
            .build();

    public static void init() {
    }

}
