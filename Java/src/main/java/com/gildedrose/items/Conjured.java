package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.Quality;

public class Conjured extends Item implements UpdateQuality {
    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateItem() {
        sellIn--;
        quality -= sellIn >= 0 ? 2 : 4;
        resetIllegalQuality();
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
