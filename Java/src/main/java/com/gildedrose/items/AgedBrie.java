package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.Quality;

public class AgedBrie extends Item implements UpdateQuality {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    public void updateItem() {
        sellIn--;
        quality += sellIn >= 0 ? 1 : 2;
        resetIllegalQuality();
    }

    @Override
    public void resetIllegalQuality() {
        quality = quality < Quality.MIN.value ? 0 : quality;
        quality = quality > Quality.MAX.value ? 50 : quality;
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
