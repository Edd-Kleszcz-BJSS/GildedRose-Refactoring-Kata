package com.gildedrose.items;

public class Sulfuras extends ConnectorItem {
    public Sulfuras(int sellIn, int quality) {
        super("Sulfuras, Hand of Ragnaros", sellIn, 80);
    }

    @Override
    public void updateItem() {}

    @Override
    protected void resetIllegalQuality() {}
}
