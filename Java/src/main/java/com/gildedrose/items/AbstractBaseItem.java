package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.Quality;
import com.gildedrose.items.services.UpdateQuality;
import org.jetbrains.annotations.NotNull;

abstract public class AbstractBaseItem extends Item implements UpdateQuality {
    public AbstractBaseItem(@NotNull String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        checkIsValidObject(name, quality);
    }

    protected void resetIllegalQuality() {
        quality = Math.max(quality, Quality.MIN.value);
        quality = Math.min(quality, Quality.MAX.value);
    }

    private void checkIsValidObject(String name, int quality) {
        boolean hasIllegalQuality = quality < Quality.MIN.value || quality > Quality.MAX.value;
        if (hasIllegalQuality && !"Sulfuras, Hand of Ragnaros".equals(name)) {
            throw new RuntimeException("Invalid Item");
        }
    }
}
