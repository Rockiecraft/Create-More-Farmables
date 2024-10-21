package net.rockiecraft.create_more_farmables;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = CreateMoreFarmables.ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateMoreFarmables.ID);

    public static final List<Supplier<? extends ItemLike>> CREATE_MORE_FARMABLES_TAB_ITEMS = new ArrayList<>();

    public static final RegistryObject<CreativeModeTab> CREATE_MORE_FARMABLES_TAB = TABS.register("create_more_farmables_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.create_more_farmables_tab"))
                    .icon(AllItems.SHULKER_SHELL_FRAGMENT.get()::getDefaultInstance)
                    .displayItems((displayParams, output) ->
                            CREATE_MORE_FARMABLES_TAB_ITEMS.forEach(itemLike -> output.accept(itemLike.get())))
                    .build()
    );

    public static <T extends Item> RegistryObject<T> addToTab(RegistryObject<T> itemLike) {
        CREATE_MORE_FARMABLES_TAB_ITEMS.add(itemLike);
        return itemLike;
    }




    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == net.minecraft.world.item.CreativeModeTabs.INGREDIENTS) {
            event.getEntries().putBefore(Items.NETHERITE_SCRAP.getDefaultInstance(), AllItems.NETHERITE_DUST.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putBefore(Items.NETHERITE_SCRAP.getDefaultInstance(), AllItems.UNPROCESSED_NETHERITE_DUST.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putBefore(Items.BLAZE_ROD.getDefaultInstance(), AllItems.UNPROCESSED_BLAZE_ROD.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putBefore(Items.SHULKER_SHELL.getDefaultInstance(), AllItems.SHULKER_COMPOUND.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putBefore(Items.SHULKER_SHELL.getDefaultInstance(), AllItems.SHULKER_SHELL_FRAGMENT.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putBefore(Items.STRING.getDefaultInstance(), AllItems.WOOD_STRING.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putBefore(Items.WHITE_DYE.getDefaultInstance(), AllItems.DYE_TEMPLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        if(event.getTabKey() == net.minecraft.world.item.CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.getEntries().putAfter(Items.LAVA_BUCKET.getDefaultInstance(), AllItems.MOLTEN_ENDSTONE_BUCKET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.WATER_BUCKET.getDefaultInstance(), AllItems.PINK_DYED_WATER_BUCKET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.WATER_BUCKET.getDefaultInstance(), AllItems.MAGENTA_DYED_WATER_BUCKET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.WATER_BUCKET.getDefaultInstance(), AllItems.PURPLE_DYED_WATER_BUCKET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.WATER_BUCKET.getDefaultInstance(), AllItems.BLUE_DYED_WATER_BUCKET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.WATER_BUCKET.getDefaultInstance(), AllItems.LIGHT_BLUE_DYED_WATER_BUCKET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.WATER_BUCKET.getDefaultInstance(), AllItems.CYAN_DYED_WATER_BUCKET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.WATER_BUCKET.getDefaultInstance(), AllItems.LIME_DYED_WATER_BUCKET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.WATER_BUCKET.getDefaultInstance(), AllItems.GREEN_DYED_WATER_BUCKET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.WATER_BUCKET.getDefaultInstance(), AllItems.YELLOW_DYED_WATER_BUCKET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.WATER_BUCKET.getDefaultInstance(), AllItems.ORANGE_DYED_WATER_BUCKET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.WATER_BUCKET.getDefaultInstance(), AllItems.RED_DYED_WATER_BUCKET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.WATER_BUCKET.getDefaultInstance(), AllItems.BROWN_DYED_WATER_BUCKET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.WATER_BUCKET.getDefaultInstance(), AllItems.BLACK_DYED_WATER_BUCKET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.WATER_BUCKET.getDefaultInstance(), AllItems.GRAY_DYED_WATER_BUCKET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.WATER_BUCKET.getDefaultInstance(), AllItems.LIGHT_GRAY_DYED_WATER_BUCKET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.WATER_BUCKET.getDefaultInstance(), AllItems.WHITE_DYED_WATER_BUCKET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

        }
        if(event.getTabKey() == net.minecraft.world.item.CreativeModeTabs.COLORED_BLOCKS) {
            event.getEntries().putBefore(Items.WHITE_WOOL.getDefaultInstance(), AllItems.WOOD_STRING_WOOL_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        if(event.getTab() == CREATE_MORE_FARMABLES_TAB.get()) {
            event.accept(AllItems.NETHERITE_DUST.get());
            event.accept(AllItems.UNPROCESSED_NETHERITE_DUST.get());
            event.accept(AllItems.UNPROCESSED_BLAZE_ROD.get());

            event.accept(AllItems.SHULKER_COMPOUND.get());
            event.accept(AllItems.SHULKER_SHELL_FRAGMENT.get());
            event.accept(AllItems.DYE_TEMPLATE.get());
            event.accept(AllItems.WOOD_STRING.get());


            event.accept(AllBlocks.WOOD_STRING_WOOL_BLOCK.get());

            event.accept(AllItems.LIQUID_REDSTONE_BUCKET.get());
            event.accept(AllItems.MOLTEN_ENDSTONE_BUCKET.get());
            event.accept(AllItems.WHITE_DYED_WATER_BUCKET.get());
            event.accept(AllItems.LIGHT_GRAY_DYED_WATER_BUCKET.get());
            event.accept(AllItems.GRAY_DYED_WATER_BUCKET.get());
            event.accept(AllItems.BLACK_DYED_WATER_BUCKET.get());
            event.accept(AllItems.BROWN_DYED_WATER_BUCKET.get());
            event.accept(AllItems.RED_DYED_WATER_BUCKET.get());
            event.accept(AllItems.ORANGE_DYED_WATER_BUCKET.get());
            event.accept(AllItems.YELLOW_DYED_WATER_BUCKET.get());
            event.accept(AllItems.GREEN_DYED_WATER_BUCKET.get());
            event.accept(AllItems.LIME_DYED_WATER_BUCKET.get());
            event.accept(AllItems.CYAN_DYED_WATER_BUCKET.get());
            event.accept(AllItems.LIGHT_BLUE_DYED_WATER_BUCKET.get());
            event.accept(AllItems.BLUE_DYED_WATER_BUCKET.get());
            event.accept(AllItems.PURPLE_DYED_WATER_BUCKET.get());
            event.accept(AllItems.MAGENTA_DYED_WATER_BUCKET.get());
            event.accept(AllItems.PINK_DYED_WATER_BUCKET.get());
        }
    }
}
