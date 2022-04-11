package com.gildedrose.items;

import com.gildedrose.Quality;

public class Sulfuras extends ConnectorItem {
    public Sulfuras(int sellIn, int quality) {
        super("Sulfuras, Hand of Ragnaros", sellIn, Quality.SULFURAS.value);
    }

    @Override
    public void updateItem() {}

    @Override
    protected void resetIllegalQuality() {}
}
