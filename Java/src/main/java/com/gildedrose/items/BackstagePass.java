package com.gildedrose.items;

public class BackstagePass extends ConnectorItem {
    public BackstagePass(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    public void updateItem() {
        sellIn--;
        quality += getIncrementValue();
        super.resetIllegalQuality();
    }

    private int getIncrementValue() {
        if (sellIn < 0) return -quality;
        else if (sellIn < 5) return 3;
        else if (sellIn < 10) return 2;
        else return 1;
    }
}
