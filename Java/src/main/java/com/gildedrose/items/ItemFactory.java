package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.Quality;
import com.gildedrose.items.services.UpdateQuality;

public class ItemFactory {
    public static UpdateQuality createItem(Item item) throws RuntimeException {
        isValidItem(item);

        if ("Sulfuras, Hand of Ragnaros".equals(item.name)) {
            return new Sulfuras(item.sellIn, item.quality);
        } else if ("Aged Brie".equals(item.name)) {
            return new AgedBrie(item.sellIn, item.quality);
        } else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.name)) {
            return new BackstagePass(item.sellIn, item.quality);
        } else if (item.name.contains("Conjured")) { //Extract to method
            return new Conjured(item.name, item.sellIn, item.quality);
        } else {
            return new Other(item.name, item.sellIn, item.quality);
        }
    }

    private static void isValidItem(Item item) throws RuntimeException {
        boolean hasIllegalQuality = item.quality < Quality.MIN.value || item.quality > Quality.MAX.value;
        if (hasIllegalQuality && !"Sulfuras, Hand of Ragnaros".equals(item.name)) {
            throw new RuntimeException("Invalid Item");
        }
    }
}
