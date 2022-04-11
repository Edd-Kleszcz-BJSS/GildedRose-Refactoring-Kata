package com.gildedrose.items.services;

public interface CreateItem {
    UpdateQuality createItem(String name, int sellIn, int quality) throws RuntimeException;
}
