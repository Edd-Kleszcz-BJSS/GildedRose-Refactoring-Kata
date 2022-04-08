package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.Quality;

public class BackstagePass extends Item implements UpdateQuality {
    public BackstagePass(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    public void updateItem() {
        sellIn--;
        quality += getIncrementValue();
        resetIllegalQuality();
    }

    private int getIncrementValue() {
        if (sellIn < 0) return -quality;
        else if (sellIn < 5) return 3;
        else if (sellIn < 10) return 2;
        else return 1;
    }

    @Override
    public void resetIllegalQuality() {
        if (quality > Quality.MAX.value) {
            quality = 50;
        } else if (quality < Quality.MIN.value) {
            quality = 0;
        }
    }

    @Override
    public int getSellIn() {
        return sellIn;
    }

    @Override
    public int getQuality() {
        return quality;
    }
}
