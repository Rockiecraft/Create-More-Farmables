package com.rockiecraft.create_more_farmables.v1_21_1.foundation;

import com.rockiecraft.create_more_farmables.v1_21_1.CreateMoreFarmables;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class ModCreativeTabs {

    public static final ResourcefulRegistry<CreativeModeTab> CREATIVE_TABS = ResourcefulRegistries.create(BuiltInRegistries.CREATIVE_MODE_TAB, CreateMoreFarmables.MODID);

    public static final Supplier<CreativeModeTab> CREATE_MORE_FARMABLES_TAB = CREATIVE_TABS.register("create_more_farmables_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.literal("Create: More Farmables"))
                    .icon(() -> new ItemStack(AllItems.SHULKER_SHELL_FRAGMENT.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(AllItems.ECHO_SHARD_DUST.get());
                        output.accept(AllItems.ENDER_PEARL_DUST.get());
                        output.accept(AllItems.NETHERITE_DUST.get());
                        output.accept(AllItems.UNPROCESSED_NETHERITE_DUST.get());
                        output.accept(AllItems.SHULKER_SHELL_FRAGMENT.get());
                        output.accept(AllItems.HEART_OF_THE_SEA_FRAGMENT.get());
                        output.accept(AllItems.NAUTILUS_SHELL_FRAGMENT.get());

                        output.accept(AllItems.UNPROCESSED_BLAZE_ROD.get());
                        output.accept(AllItems.SHULKER_COMPOUND.get());
                        output.accept(AllItems.DYE_TEMPLATE.get());
                        output.accept(AllItems.WOOD_STRING.get());

                        output.accept(AllItems.WOOD_STRING_WOOL_BLOCK.get());

                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_1.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_2.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_3.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_4.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_5.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_6.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_7.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_8.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_9.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_10.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_11.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_12.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_13.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_14.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_15.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_16.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_17.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_18.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_19.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_20.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_21.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_22.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_23.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_24.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_25.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_26.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_27.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_28.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_29.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_30.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_31.get());
                        output.accept(AllItems.REDSTONE_LINK_FREQ_TAG_32.get());

                        output.accept(AllFluids.LIQUID_QUARTZ.bucket().get());
                        output.accept(AllFluids.LIQUID_REDSTONE.bucket().get());
                        output.accept(AllFluids.MOLTEN_ENDSTONE.bucket().get());
                        output.accept(AllFluids.WHITE_DYED_WATER.bucket().get());
                        output.accept(AllFluids.LIGHT_GRAY_DYED_WATER.bucket().get());
                        output.accept(AllFluids.GRAY_DYED_WATER.bucket().get());
                        output.accept(AllFluids.BLACK_DYED_WATER.bucket().get());
                        output.accept(AllFluids.BROWN_DYED_WATER.bucket().get());
                        output.accept(AllFluids.RED_DYED_WATER.bucket().get());
                        output.accept(AllFluids.ORANGE_DYED_WATER.bucket().get());
                        output.accept(AllFluids.YELLOW_DYED_WATER.bucket().get());
                        output.accept(AllFluids.GREEN_DYED_WATER.bucket().get());
                        output.accept(AllFluids.LIME_DYED_WATER.bucket().get());
                        output.accept(AllFluids.CYAN_DYED_WATER.bucket().get());
                        output.accept(AllFluids.LIGHT_BLUE_DYED_WATER.bucket().get());
                        output.accept(AllFluids.BLUE_DYED_WATER.bucket().get());
                        output.accept(AllFluids.PURPLE_DYED_WATER.bucket().get());
                        output.accept(AllFluids.MAGENTA_DYED_WATER.bucket().get());
                        output.accept(AllFluids.PINK_DYED_WATER.bucket().get());

                    })
                    .build()
    );
}
