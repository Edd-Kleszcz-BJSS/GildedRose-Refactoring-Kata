package com.gildedrose;

import com.gildedrose.items.ItemFactory;
import com.gildedrose.items.UpdateQuality;

class GildedRose {
    UpdateQuality[] items;

    public GildedRose(Item[] items) {
        UpdateQuality[] newItems = new UpdateQuality[items.length];
        for (int i = 0; i < items.length; i++) {
            newItems[i] = ItemFactory.createItem(items[i].name, items[i].sellIn, items[i].quality);
        }
        ItemChecker.areValidItems(newItems);

        this.items = newItems;
    }

    public void updateQuality() {
        for (UpdateQuality item: items) {
            item.updateItem();
        }
    }
}
