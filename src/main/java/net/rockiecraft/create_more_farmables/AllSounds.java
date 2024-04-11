//package net.rockiecraft.create_more_farmables;
//
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.sounds.SoundEvent;
//import net.minecraftforge.common.util.ForgeSoundType;
//import net.minecraftforge.eventbus.api.IEventBus;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.RegistryObject;
//
//public class AllSounds {
//    public static final DeferredRegister<SoundEvent> SOUND_EVENTS
//            = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, CreateMoreFarmables.ID);
//
//
//
//
//    public static final ForgeSoundType SOUND_BLOCK_SOUNDS = new ForgeSoundType(1f, 1f,
//            );
//
//    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
//        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(CreateMoreFarmables.ID, name)));
//    }
//
//    public static void register(IEventBus eventbus) {
//        SOUND_EVENTS.register(eventbus);
//    }
//}
