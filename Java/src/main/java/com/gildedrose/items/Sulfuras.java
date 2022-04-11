package com.gildedrose.items;

import com.gildedrose.Quality;

public class Sulfuras extends AbstractBaseItem {
    public Sulfuras(int sellIn) {
        super("Sulfuras, Hand of Ragnaros", sellIn, Quality.SULFURAS.value);
    }

    @Override
    public void updateItem() {}
}
