package com.gildedrose.items;

import com.gildedrose.Item;

public class Conjured extends Item implements UpdateQuality {
    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateItem() {
        sellIn--;
        quality -= sellIn >= 0 ? 1 : 2;
    }
}
