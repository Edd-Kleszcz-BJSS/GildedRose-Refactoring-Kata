package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.Quality;

public class Other extends Item implements UpdateQuality {
    public Other(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateItem() {
        sellIn--;
        quality -= sellIn >= 0 ? 1 : 2;
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
