package net.rockiecraft.create_more_farmables;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rockiecraft.create_more_farmables.fluids.AllFluids;

public class AllItems {

    public static final Item SHULKER_SHELL_FRAGMENT = registerItem("shulker_shell_fragment", new Item(new FabricItemSettings()));
    public static final Item SHULKER_COMPOUND = registerItem("shulker_compound", new Item(new FabricItemSettings()));
    public static final Item DYE_TEMPLATE = registerItem("dye_template", new Item(new FabricItemSettings()));
    public static final Item WOOD_STRING = registerItem("wood_string", new Item(new FabricItemSettings()));




    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CreateMoreFarmables.ID, name), item);
    }

    public static void registerModItems() {
        CreateMoreFarmables.LOGGER.info("Registering Mod Items for " + CreateMoreFarmables.ID);
    }
    public static final ItemGroup SHULKER_SHELL_FRAGMENT_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(CreateMoreFarmables.ID, "shulker_shell_fragment"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.shulker_shell_fragment"))
                    .icon(() -> new ItemStack(AllItems.SHULKER_SHELL_FRAGMENT)).entries((displayContext, entries) -> {
                        entries.add(AllItems.SHULKER_SHELL_FRAGMENT);
                        entries.add(AllItems.SHULKER_COMPOUND);
                        entries.add(AllItems.DYE_TEMPLATE);
                        entries.add(AllItems.WOOD_STRING);
                        entries.add(AllBlocks.WOOD_STRING_WOOL_BLOCK);
                        entries.add(AllFluids.MOLTEN_ENDSTONE_BUCKET);
                        entries.add(AllFluids.WHITE_DYED_WATER_BUCKET);
                        entries.add(AllFluids.LIGHT_GRAY_DYED_WATER_BUCKET);
                        entries.add(AllFluids.GRAY_DYED_WATER_BUCKET);
                        entries.add(AllFluids.BLACK_DYED_WATER_BUCKET);
                        entries.add(AllFluids.BROWN_DYED_WATER_BUCKET);
                        entries.add(AllFluids.RED_DYED_WATER_BUCKET);
                        entries.add(AllFluids.ORANGE_DYED_WATER_BUCKET);
                        entries.add(AllFluids.YELLOW_DYED_WATER_BUCKET);
                        entries.add(AllFluids.GREEN_DYED_WATER_BUCKET);
                        entries.add(AllFluids.LIME_DYED_WATER_BUCKET);
                        entries.add(AllFluids.CYAN_DYED_WATER_BUCKET);
                        entries.add(AllFluids.LIGHT_BLUE_DYED_WATER_BUCKET);
                        entries.add(AllFluids.BLUE_DYED_WATER_BUCKET);
                        entries.add(AllFluids.PURPLE_DYED_WATER_BUCKET);
                        entries.add(AllFluids.MAGENTA_DYED_WATER_BUCKET);
                        entries.add(AllFluids.PINK_DYED_WATER_BUCKET);

                    }).build());


    public static void registerItemGroups() {
        CreateMoreFarmables.LOGGER.info("Registering Item Groups for " + CreateMoreFarmables.ID);
    }

}
