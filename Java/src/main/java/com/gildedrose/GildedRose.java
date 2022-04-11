package com.gildedrose;

import com.gildedrose.items.services.UpdateQuality;
import org.jetbrains.annotations.NotNull;

class GildedRose {
    UpdateQuality[] items;

    public GildedRose(@NotNull UpdateQuality[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (UpdateQuality item: items) {
            item.updateItem();
        }
    }
}
