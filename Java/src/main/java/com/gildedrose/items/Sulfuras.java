package com.gildedrose.items;

import com.gildedrose.Item;

public class Sulfuras extends Item implements UpdateQuality {
    public Sulfuras(int sellIn, int quality) {
        super("Sulfuras, Hand of Ragnaros", sellIn, 80);
    }

    @Override
    public void updateItem() {}

    @Override
    public void resetExtremeQuality() {
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
