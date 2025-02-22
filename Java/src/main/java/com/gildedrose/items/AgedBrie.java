package com.gildedrose.items;

public class AgedBrie extends AbstractBaseItem {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    public void updateItem() {
        sellIn--;
        quality += sellIn >= 0 ? 1 : 2;
        super.resetIllegalQuality();
    }
}
