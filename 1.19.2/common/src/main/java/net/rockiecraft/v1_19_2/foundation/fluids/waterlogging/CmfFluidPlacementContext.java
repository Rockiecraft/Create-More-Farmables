package net.rockiecraft.v1_20_1.foundation.fluids.waterlogging;

// Tracks whether fluid code is running inside a deliberate player bucket-pour vs. automatic fluid spread, so dyed water only waterlogs blocks on a real pour.
public final class CmfFluidPlacementContext {

    // ThreadLocal for safety against off-thread ticking and pour re-entrancy, even though world ticking is normally single-threaded.
    private static final ThreadLocal<Boolean> DELIBERATE_POUR = ThreadLocal.withInitial(() -> false);

    private CmfFluidPlacementContext() {}

    public static boolean isDeliberatePour() {
        return DELIBERATE_POUR.get();
    }

    // Set true at BucketItem#emptyContents HEAD and false at every RETURN; doesn't restore a "previous" value since emptyContents can recurse once on the same singleton item.
    public static void setDeliberatePour(boolean value) {
        DELIBERATE_POUR.set(value);
    }
}
