package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.Quality;
import org.jetbrains.annotations.NotNull;

abstract public class ConnectorItem extends Item implements UpdateQuality {
    public ConnectorItem(@NotNull String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    protected void resetIllegalQuality() {
        quality = Math.max(quality, Quality.MIN.value);
        quality = Math.min(quality, Quality.MAX.value);
    }

    @Override
    public boolean hasInvalidQuality() {
        return quality < Quality.MIN.value || quality > Quality.MAX.value;
    }
}
