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
        resetExtremeQuality();
    }

    @Override
    public void resetExtremeQuality() {
        if (quality > Quality.MAX.value) {
            quality = 50;
        } else if (quality < Quality.MIN.value) {
            quality = 0;
        }
    }

    @Override
    public String getName() {
        return name;
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
