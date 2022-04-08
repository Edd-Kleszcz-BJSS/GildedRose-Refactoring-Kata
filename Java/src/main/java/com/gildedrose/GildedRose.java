package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        ItemChecker.areValidItems(items);
        this.items = items;
    }

    public void updateQuality() {
        for (Item item: items) {
            if (isLegendary(item)) continue;
            item.sellIn--;
            updateItemValues(item);
            resetExtremeQuality(item);
        }
    }

    private boolean isLegendary(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    //Refactor - (Switch), OO Abusers, 2nd vid
    private void updateItemValues(Item item) {
        if (item.name.equals("Aged Brie")) {
            item.quality += getStandardIncrementValue(item, 1);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality += getTicketIncrementValue(item);
        } else if (item.name.contains("Conjured")) {
            item.quality -= getStandardIncrementValue(item, 2);
        } else {
            item.quality -= getStandardIncrementValue(item, 1);
        }
    }

    private void resetExtremeQuality(Item item) {
        if (item.quality > Quality.MAX.value) {
            item.quality = 50;
        } else if (item.quality < Quality.MIN.value) {
            item.quality = 0;
        }
    }

    private int getStandardIncrementValue(Item item, int incrementValue) {
        return item.sellIn >= 0 ? incrementValue : 2 * incrementValue;
    }

    private int getTicketIncrementValue(Item item) {
        int increment;
        if (item.sellIn < 0) increment = -item.quality;
        else if (item.sellIn < 5) increment = 3;
        else if (item.sellIn < 10) increment = 2;
        else increment = 1;
        return increment;
    }
}
