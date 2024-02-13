package net.rockiecraft.create_more_farmables.item;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.rockiecraft.create_more_farmables.AllFluids;


public class MoltenEndstoneBucketItem extends BucketItem {
    public MoltenEndstoneBucketItem() {
        super(AllFluids.MOLTEN_ENDSTONE, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
    }
}
/*
     * replace "MOLTEN_ENDSTONE_" with the name of the custom liquid you wish to put in a bucket.
     * keep in mind that the name is case-sensitive.
     */

