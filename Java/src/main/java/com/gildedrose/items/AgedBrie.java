package com.gildedrose.items;

import com.gildedrose.Item;

public class AgedBrie extends Item implements UpdateQuality {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    public void updateItem() {
        sellIn--;
        quality += sellIn >= 0 ? 1 : 2;
    }
}
