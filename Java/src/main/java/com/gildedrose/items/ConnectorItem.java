package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.Quality;

abstract public class ConnectorItem extends Item implements UpdateQuality {
    public ConnectorItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public int getSellIn() {
        return sellIn;
    }

    @Override
    public int getQuality() {
        return quality;
    }

    protected void resetIllegalQuality() {
        quality = quality < Quality.MIN.value ? 0 : quality;
        quality = quality > Quality.MAX.value ? 50 : quality;
    }
}
