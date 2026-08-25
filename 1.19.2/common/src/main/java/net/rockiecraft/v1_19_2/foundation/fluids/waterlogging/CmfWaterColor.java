package net.rockiecraft.v1_20_1.foundation.fluids.waterlogging;

import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.DyeColor;

// Blockstate property enum for which dyed water (if any) is filling a waterlogged block.
// NONE must stay first so EnumProperty defaults existing vanilla-waterlogged blocks to plain water.
// Kept separate from DyeColor since DyeColor has no NONE entry.
public enum CmfWaterColor implements StringRepresentable {
    NONE("none", null),
    WHITE("white", DyeColor.WHITE),
    ORANGE("orange", DyeColor.ORANGE),
    MAGENTA("magenta", DyeColor.MAGENTA),
    LIGHT_BLUE("light_blue", DyeColor.LIGHT_BLUE),
    YELLOW("yellow", DyeColor.YELLOW),
    LIME("lime", DyeColor.LIME),
    PINK("pink", DyeColor.PINK),
    GRAY("gray", DyeColor.GRAY),
    LIGHT_GRAY("light_gray", DyeColor.LIGHT_GRAY),
    CYAN("cyan", DyeColor.CYAN),
    PURPLE("purple", DyeColor.PURPLE),
    BLUE("blue", DyeColor.BLUE),
    BROWN("brown", DyeColor.BROWN),
    GREEN("green", DyeColor.GREEN),
    RED("red", DyeColor.RED),
    BLACK("black", DyeColor.BLACK);

    private final String serializedName;
    private final DyeColor dyeColor;

    CmfWaterColor(String serializedName, DyeColor dyeColor) {
        this.serializedName = serializedName;
        this.dyeColor = dyeColor;
    }

    public DyeColor dyeColor() {
        return dyeColor;
    }

    public static CmfWaterColor fromDyeColor(DyeColor color) {
        if (color == null) return NONE;
        for (CmfWaterColor c : values()) {
            if (c.dyeColor == color) return c;
        }
        return NONE;
    }

    @Override
    public String getSerializedName() {
        return serializedName;
    }
}
