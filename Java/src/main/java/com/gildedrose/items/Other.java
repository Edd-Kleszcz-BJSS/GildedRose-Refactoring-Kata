package com.gildedrose.items;

import com.gildedrose.Quality;

public class Other extends ConnectorItem {
    public Other(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateItem() {
        sellIn--;
        quality -= sellIn >= 0 ? 1 : 2;
        super.resetIllegalQuality();
    }
}
