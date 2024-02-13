package net.rockiecraft.create_more_farmables.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.rockiecraft.create_more_farmables.AllItems;
import net.rockiecraft.create_more_farmables.CreateMoreFarmables;

import javax.swing.*;


public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateMoreFarmables.ID);

    public static final RegistryObject<CreativeModeTab> CREATE_MORE_FARMABLES_TAB = CREATIVE_MODE_TABS.register("create_more_farmables",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(AllItems.SHULKER_SHELL_FRAGMENT.get()))
                    .title(Component.translatable("Create: More Farmables"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(AllItems.SHULKER_COMPOUND.get());
                        pOutput.accept(AllItems.SHULKER_SHELL_FRAGMENT.get());
                        pOutput.accept(AllItems.DYE_TEMPLATE.get());
                        pOutput.accept(AllItems.MOLTEN_ENDSTONE_BUCKET.get());
                        pOutput.accept(AllItems.WHITE_DYED_WATER_BUCKET.get());
                        pOutput.accept(AllItems.BLACK_DYED_WATER_BUCKET.get());
                        pOutput.accept(AllItems.GRAY_DYED_WATER_BUCKET.get());
                        pOutput.accept(AllItems.LIGHT_GRAY_DYED_WATER_BUCKET.get());
                        pOutput.accept(AllItems.RED_DYED_WATER_BUCKET.get());
                        pOutput.accept(AllItems.BLUE_DYED_WATER_BUCKET.get());
                        pOutput.accept(AllItems.PURPLE_DYED_WATER_BUCKET.get());
                        pOutput.accept(AllItems.LIGHT_BLUE_DYED_WATER_BUCKET.get());
                        pOutput.accept(AllItems.CYAN_DYED_WATER_BUCKET.get());
                        pOutput.accept(AllItems.GREEN_DYED_WATER_BUCKET.get());
                        pOutput.accept(AllItems.LIME_DYED_WATER_BUCKET.get());
                        pOutput.accept(AllItems.YELLOW_DYED_WATER_BUCKET.get());
                        pOutput.accept(AllItems.PINK_DYED_WATER_BUCKET.get());
                        pOutput.accept(AllItems.MAGENTA_DYED_WATER_BUCKET.get());
                        pOutput.accept(AllItems.ORANGE_DYED_WATER_BUCKET.get());
                        pOutput.accept(AllItems.BROWN_DYED_WATER_BUCKET.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
