package net.rockiecraft.create_more_farmables.item;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.rockiecraft.create_more_farmables.AllFluids;

public class YellowDyedWaterBucketItem extends BucketItem {
   public YellowDyedWaterBucketItem() {
       super(AllFluids.YELLOW_DYED_WATER, new Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
   }
}
