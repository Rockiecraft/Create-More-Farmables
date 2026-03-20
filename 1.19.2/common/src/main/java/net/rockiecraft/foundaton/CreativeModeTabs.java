//package net.rockiecraft.foundaton;
//
//import dev.architectury.registry.CreativeTabRegistry;
//import dev.architectury.registry.registries.DeferredRegister;
//import dev.architectury.registry.registries.RegistrySupplier;
//import net.minecraft.core.registries.Registries;
//import net.minecraft.network.chat.Component;
//import net.minecraft.world.item.CreativeModeTab;
//import net.minecraft.world.item.ItemStack;
//import net.rockiecraft.CreateMoreFarmables;
//
//public class CreativeModeTabs {
//
//    public static final DeferredRegister<CreativeModeTab> TABS =
//            DeferredRegister.create(CreateMoreFarmables.MOD_ID, Registries.CREATIVE_MODE_TAB);
//
//    public static final RegistrySupplier<CreativeModeTab> CREATE_MORE_FARMABLES_TAB = TABS.register(
//            "create_more_farmables_tab",
//            () -> CreativeTabRegistry.create(
//                    builder -> builder
//                            .title(Component.translatable("Create: More Farmables"))
//                            .icon(() -> new ItemStack(AllItems.SHULKER_SHELL_FRAGMENT.get()))
//                            .displayItems((parameters, output) -> {
//
//                                output.accept(AllItems.ECHO_SHARD_DUST.get());
//                                output.accept(AllItems.ENDER_PEARL_DUST.get());
//                                output.accept(AllItems.NETHERITE_DUST.get());
//                                output.accept(AllItems.UNPROCESSED_NETHERITE_DUST.get());
//                                output.accept(AllItems.SHULKER_SHELL_FRAGMENT.get());
//                                output.accept(AllItems.HEART_OF_THE_SEA_FRAGMENT.get());
//                                output.accept(AllItems.NAUTILUS_SHELL_FRAGMENT.get());
//
//                                output.accept(AllItems.UNPROCESSED_BLAZE_ROD.get());
//                                output.accept(AllItems.SHULKER_COMPOUND.get());
//                                output.accept(AllItems.DYE_TEMPLATE.get());
//                                output.accept(AllItems.WOOD_STRING.get());
//
//
//                                output.accept(AllItems.WOOD_STRING_WOOL_BLOCK.get());
//
//                                output.accept(AllItems.LIQUID_QUARTZ_BUCKET.get());
//                                output.accept(AllItems.LIQUID_REDSTONE_BUCKET.get());
//                                output.accept(AllItems.MOLTEN_ENDSTONE_BUCKET.get());
//                                output.accept(AllItems.WHITE_DYED_WATER_BUCKET.get());
//                                output.accept(AllItems.LIGHT_GRAY_DYED_WATER_BUCKET.get());
//                                output.accept(AllItems.GRAY_DYED_WATER_BUCKET.get());
//                                output.accept(AllItems.BLACK_DYED_WATER_BUCKET.get());
//                                output.accept(AllItems.BROWN_DYED_WATER_BUCKET.get());
//                                output.accept(AllItems.RED_DYED_WATER_BUCKET.get());
//                                output.accept(AllItems.ORANGE_DYED_WATER_BUCKET.get());
//                                output.accept(AllItems.YELLOW_DYED_WATER_BUCKET.get());
//                                output.accept(AllItems.GREEN_DYED_WATER_BUCKET.get());
//                                output.accept(AllItems.LIME_DYED_WATER_BUCKET.get());
//                                output.accept(AllItems.CYAN_DYED_WATER_BUCKET.get());
//                                output.accept(AllItems.LIGHT_BLUE_DYED_WATER_BUCKET.get());
//                                output.accept(AllItems.BLUE_DYED_WATER_BUCKET.get());
//                                output.accept(AllItems.PURPLE_DYED_WATER_BUCKET.get());
//                                output.accept(AllItems.MAGENTA_DYED_WATER_BUCKET.get());
//                                output.accept(AllItems.PINK_DYED_WATER_BUCKET.get());
//
//                            })
//            )
//    );
//
//    public static void init() {
//        TABS.register();
//    }
//
//}
