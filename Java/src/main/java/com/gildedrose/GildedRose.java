package com.gildedrose;

import com.gildedrose.items.ItemFactory;
import com.gildedrose.items.services.UpdateQuality;
import org.jetbrains.annotations.NotNull;

class GildedRose {
    UpdateQuality[] items;

    public GildedRose(@NotNull Item[] items) {
        UpdateQuality[] newItems = new UpdateQuality[items.length];
        for (int i = 0; i < items.length; i++) {
            newItems[i] = ItemFactory.createItem(items[i]);
        }
        this.items = newItems;
    }

    public void updateQuality() {
        for (UpdateQuality item: items) {
            item.updateItem();
        }
    }
}
