package com.gildedrose.items;

import com.gildedrose.items.services.CreateItem;
import com.gildedrose.items.services.UpdateQuality;

public class ItemFactory implements CreateItem {
    @Override
        public UpdateQuality createItem(String name, int sellIn, int quality) throws RuntimeException {
        if ("Sulfuras, Hand of Ragnaros".equals(name)) {
            return new Sulfuras(sellIn);
        } else if ("Aged Brie".equals(name)) {
            return new AgedBrie(sellIn, quality);
        } else if ("Backstage passes to a TAFKAL80ETC concert".equals(name)) {
            return new BackstagePass(sellIn, quality);
        } else if (name.contains("Conjured")) { //Extract to method
            return new Conjured(name, sellIn, quality);
        } else {
            return new Other(name, sellIn, quality);
        }
    }
}
