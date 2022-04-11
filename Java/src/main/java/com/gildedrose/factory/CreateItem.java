package com.gildedrose.factory;

import com.gildedrose.items.services.UpdateQuality;

public interface CreateItem {
    UpdateQuality createItem(String name, int sellIn, int quality) throws RuntimeException;
}
