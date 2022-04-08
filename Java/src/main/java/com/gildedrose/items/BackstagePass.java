package com.gildedrose.items;

import com.gildedrose.Item;

public class BackstagePass extends Item implements UpdateQuality {
    public BackstagePass(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    public void updateItem() {
        sellIn--;
        quality += getIncrementValue();
    }

    private int getIncrementValue() {
        if (sellIn < 0) return -quality;
        else if (sellIn < 5) return 3;
        else if (sellIn < 10) return 2;
        else return 1;
    }
}
