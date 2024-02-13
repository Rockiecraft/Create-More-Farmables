package net.rockiecraft.create_more_farmables.fluid.types;

import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

import java.util.function.Consumer;

public class LightGrayDyedWaterFluidType extends FluidType {
    public LightGrayDyedWaterFluidType() {
       super(Properties.create().fallDistanceModifier(0F).canExtinguish(true).supportsBoating(true).canHydrate(true).canPushEntity(true).pathType(BlockPathTypes.WATER).motionScale(0.007D).canConvertToSource(true)
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH));

    }

    @Override
    public void initializeClient(@NotNull Consumer<IClientFluidTypeExtensions> consumer) {
       consumer.accept(new IClientFluidTypeExtensions() {
            private static final ResourceLocation
                    STILL_TEXTURE = new ResourceLocation("create_more_farmables:block/dyed_water"),
                    FLOWING_TEXTURE = new ResourceLocation("create_more_farmables:block/flowing_dyed_water");


            @Override
           public ResourceLocation getStillTexture() {
                return STILL_TEXTURE;
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return FLOWING_TEXTURE;
            }

            public int getTintColor() {
                return -6447721;
           }

            public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
                int color = this.getTintColor();
                return new Vector3f((float)(color >> 16 & 255) / 255.0F, (float)(color >> 8 & 255) / 255.0F, (float)(color & 255) / 255.0F);
            }
        });
    }

}