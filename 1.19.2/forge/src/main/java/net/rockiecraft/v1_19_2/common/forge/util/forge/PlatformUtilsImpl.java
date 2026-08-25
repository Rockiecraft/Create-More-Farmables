//package net.rockiecraft.common.forge.util.forge;
//
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.CreativeModeTab;
//import net.minecraft.world.item.ItemStack;
//import org.jetbrains.annotations.NotNull;
//
//import java.util.function.Supplier;
//
//public class PlatformUtilsImpl {
//    public static CreativeModeTab createTab(ResourceLocation location, Supplier<ItemStack> icon) {
//        return new CreativeModeTab(location.getNamespace() + "." + location.getPath()) {
//            @Override
//            public ItemStack makeIcon() {
//                return icon.get();
//            }
//        };
//    }
//}
