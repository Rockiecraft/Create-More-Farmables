package net.rockiecraft.create_more_farmables.item;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.rockiecraft.create_more_farmables.AllFluids;

public class WhiteDyedWaterBucketItem extends BucketItem {
   public WhiteDyedWaterBucketItem() {
       super(AllFluids.WHITE_DYED_WATER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
   }
}
