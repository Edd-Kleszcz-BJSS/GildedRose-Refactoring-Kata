package com.gildedrose.items;

import com.gildedrose.Item;

public class Other extends Item implements UpdateQuality {
    public Other(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateItem() {
        sellIn--;
        quality -= sellIn >= 0 ? 1 : 2;
    }
}
