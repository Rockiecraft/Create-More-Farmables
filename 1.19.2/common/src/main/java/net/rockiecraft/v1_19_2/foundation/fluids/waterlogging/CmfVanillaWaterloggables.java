package net.rockiecraft.v1_20_1.foundation.fluids.waterlogging;

import net.minecraft.world.level.block.*;

import java.util.List;

// Allowlist of vanilla-only blocks CMF adds waterlogging support to - never add a modded block class here.
// Adding a blockstate property to a modded block can break its own shape/cache tables and crash on launch (this happened with Create).
// WallBlock pre-bakes a static shape map in its constructor, so MixinWallBlockShapes patches that map to add entries for CMF_WATER_COLOR.
public class CmfVanillaWaterloggables {

    private static final List<Class<? extends Block>> ALLOWED = List.of(
            FenceBlock.class,
            WallBlock.class,
            StairBlock.class,
            SlabBlock.class,
            TrapDoorBlock.class,
            IronBarsBlock.class,
            StainedGlassPaneBlock.class,
            LadderBlock.class,
            ChestBlock.class,
            TrappedChestBlock.class,
            EnderChestBlock.class,
            StandingSignBlock.class,
            WallSignBlock.class,
            RailBlock.class,
            DetectorRailBlock.class,
            PoweredRailBlock.class,
            LanternBlock.class,
            ChainBlock.class,
            CandleBlock.class,
            LightBlock.class,
            ScaffoldingBlock.class,
            SeaPickleBlock.class,
            ConduitBlock.class,
            LeavesBlock.class
    );

    private CmfVanillaWaterloggables() {}

    public static boolean isAllowed(Object owner) {
        if (!(owner instanceof Block)) return false;
        Class<?> clazz = owner.getClass();
        for (Class<? extends Block> allowed : ALLOWED) {
            if (allowed.isAssignableFrom(clazz)) return true;
        }
        return false;
    }
}
