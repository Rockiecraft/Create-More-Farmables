package net.rockiecraft.v1_20_1.foundation;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.*;
import net.rockiecraft.v1_20_1.CreateMoreFarmables;

public class AllItems {


    public static final ResourcefulRegistry<Item> ITEMS = ResourcefulRegistries.create(BuiltInRegistries.ITEM, CreateMoreFarmables.MOD_ID);
    public static final ResourcefulRegistry<Item> BASIC_ITEMS = ResourcefulRegistries.create(ITEMS);

    public static final RegistryEntry<Item> ECHO_SHARD_DUST = BASIC_ITEMS.register("echo_shard_dust",
            () -> new Item(new Item.Properties()));

    public static final RegistryEntry<Item> ENDER_PEARL_DUST = BASIC_ITEMS.register("ender_pearl_dust",
            () -> new Item(new Item.Properties()));

    public static final RegistryEntry<Item> NETHERITE_DUST = BASIC_ITEMS.register("netherite_dust",
            () -> new Item(new Item.Properties()));

    public static final RegistryEntry<Item> UNPROCESSED_NETHERITE_DUST = BASIC_ITEMS.register("unprocessed_netherite_dust",
            () -> new Item(new Item.Properties()));

    public static final RegistryEntry<Item> NAUTILUS_SHELL_FRAGMENT = BASIC_ITEMS.register("nautilus_shell_fragment",
            () -> new Item(new Item.Properties()));

    public static final RegistryEntry<Item> HEART_OF_THE_SEA_FRAGMENT = BASIC_ITEMS.register("heart_of_the_sea_fragment",
            () -> new Item(new Item.Properties()));

    public static final RegistryEntry<Item> SHULKER_SHELL_FRAGMENT = BASIC_ITEMS.register("shulker_shell_fragment",
            () -> new Item(new Item.Properties()));

    public static final RegistryEntry<Item> SHULKER_COMPOUND = BASIC_ITEMS.register("shulker_compound",
            () -> new Item(new Item.Properties()));

    public static final RegistryEntry<Item> UNPROCESSED_BLAZE_ROD = BASIC_ITEMS.register("unprocessed_blaze_rod",
            () -> new Item(new Item.Properties()));

    public static final RegistryEntry<Item> DYE_TEMPLATE = BASIC_ITEMS.register("dye_template",
            () -> new Item(new Item.Properties()));

    public static final RegistryEntry<Item> WOOD_STRING = BASIC_ITEMS.register("wood_string",
            () -> new Item(new Item.Properties()));

    // Start of Redstone link Freq Items
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_1 = BASIC_ITEMS.register("redstone_link_freq_tag_1",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_2 = BASIC_ITEMS.register("redstone_link_freq_tag_2",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_3 = BASIC_ITEMS.register("redstone_link_freq_tag_3",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_4 = BASIC_ITEMS.register("redstone_link_freq_tag_4",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_5 = BASIC_ITEMS.register("redstone_link_freq_tag_5",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_6 = BASIC_ITEMS.register("redstone_link_freq_tag_6",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_7 = BASIC_ITEMS.register("redstone_link_freq_tag_7",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_8 = BASIC_ITEMS.register("redstone_link_freq_tag_8",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_9 = BASIC_ITEMS.register("redstone_link_freq_tag_9",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_10 = BASIC_ITEMS.register("redstone_link_freq_tag_10",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_11 = BASIC_ITEMS.register("redstone_link_freq_tag_11",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_12 = BASIC_ITEMS.register("redstone_link_freq_tag_12",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_13 = BASIC_ITEMS.register("redstone_link_freq_tag_13",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_14 = BASIC_ITEMS.register("redstone_link_freq_tag_14",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_15 = BASIC_ITEMS.register("redstone_link_freq_tag_15",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_16 = BASIC_ITEMS.register("redstone_link_freq_tag_16",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_17 = BASIC_ITEMS.register("redstone_link_freq_tag_17",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_18 = BASIC_ITEMS.register("redstone_link_freq_tag_18",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_19 = BASIC_ITEMS.register("redstone_link_freq_tag_19",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_20 = BASIC_ITEMS.register("redstone_link_freq_tag_20",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_21 = BASIC_ITEMS.register("redstone_link_freq_tag_21",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_22 = BASIC_ITEMS.register("redstone_link_freq_tag_22",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_23 = BASIC_ITEMS.register("redstone_link_freq_tag_23",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_24 = BASIC_ITEMS.register("redstone_link_freq_tag_24",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_25 = BASIC_ITEMS.register("redstone_link_freq_tag_25",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_26 = BASIC_ITEMS.register("redstone_link_freq_tag_26",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_27 = BASIC_ITEMS.register("redstone_link_freq_tag_27",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_28 = BASIC_ITEMS.register("redstone_link_freq_tag_28",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_29 = BASIC_ITEMS.register("redstone_link_freq_tag_29",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_30 = BASIC_ITEMS.register("redstone_link_freq_tag_30",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_31 = BASIC_ITEMS.register("redstone_link_freq_tag_31",
            () -> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> REDSTONE_LINK_FREQ_TAG_32 = BASIC_ITEMS.register("redstone_link_freq_tag_32",
            () -> new Item(new Item.Properties()));
    // End of Redstone link Freq Items

    public static final RegistryEntry<Item> WOOD_STRING_WOOL_BLOCK = BASIC_ITEMS.register("wood_string_wool_block",
            () -> new BlockItem(AllBlocks.WOOD_STRING_WOOL_BLOCK.get(), new Item.Properties()
                    .rarity(Rarity.UNCOMMON)
                    .stacksTo(64)
            ));


    public static void init() {
        AllItems.BASIC_ITEMS.init();
    }
}
