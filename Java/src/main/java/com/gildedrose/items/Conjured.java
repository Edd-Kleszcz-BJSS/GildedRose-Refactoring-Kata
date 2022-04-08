package com.gildedrose.items;

import com.gildedrose.Quality;

public class Conjured extends ConnectorItem {
    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateItem() {
        sellIn--;
        quality -= sellIn >= 0 ? 2 : 4;
        super.resetIllegalQuality();
    }
}
