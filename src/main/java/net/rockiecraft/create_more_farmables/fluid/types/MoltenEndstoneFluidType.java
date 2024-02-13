package net.rockiecraft.create_more_farmables.fluid.types;


import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;

import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class MoltenEndstoneFluidType extends FluidType {
    public MoltenEndstoneFluidType() {
        super(FluidType.Properties.create().canPushEntity(true).canSwim(false).canDrown(false).pathType(BlockPathTypes.LAVA).adjacentPathType(null).motionScale(0.007D).lightLevel(13).temperature(55500).canConvertToSource(true)
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH));

    }

    @Override
    public void initializeClient(@NotNull Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            /**
             * replace the "create_more_farmables" with your mod id, replace "block/molten_endstone" with your block name.
             */
            private static final ResourceLocation
                    STILL_TEXTURE = new ResourceLocation("create_more_farmables:block/molten_endstone"),
                    FLOWING_TEXTURE = new ResourceLocation("create_more_farmables:block/flowing_molten_endstone");


            @Override
            public ResourceLocation getStillTexture() {return STILL_TEXTURE;}

            @Override
            public ResourceLocation getFlowingTexture() {return FLOWING_TEXTURE;}
        });
    }
}
