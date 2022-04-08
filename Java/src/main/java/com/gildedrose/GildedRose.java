package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        ItemChecker.areValidItems(items);
        this.items = items;
    }

    public void updateQuality() {
        for (int index = 0; index < items.length; index++) {
            if (items[index].name.equals("Sulfuras, Hand of Ragnaros")) continue;
            items[index].sellIn--;
            updateItemValues(index, items[index].name);
            resetExtremeQuality(index);
        }
    }

    private void updateItemValues(int index, String itemName) {
        if (itemName.equals("Aged Brie")) {
            items[index].quality += getStandardIncrementValue(index, 1);
        } else if (itemName.equals("Backstage passes to a TAFKAL80ETC concert")) {
            items[index].quality += getTicketIncrementValue(index);
        } else if (itemName.contains("Conjured")) {
            items[index].quality -= getStandardIncrementValue(index, 2);
        } else {
            items[index].quality -= getStandardIncrementValue(index, 1);
        }
    }

    private void resetExtremeQuality(int index) {
        if (items[index].quality > Quality.MAX.value) {
            items[index].quality = 50;
        } else if (items[index].quality < Quality.MIN.value) {
            items[index].quality = 0;
        }
    }

    private int getStandardIncrementValue(int index, int incrementValue) {
        return items[index].sellIn >= 0 ? incrementValue : 2 * incrementValue;
    }

    private int getTicketIncrementValue(int index) {
        int increment;
        if (items[index].sellIn < 0) increment = -items[index].quality;
        else if (items[index].sellIn < 5) increment = 3;
        else if (items[index].sellIn < 10) increment = 2;
        else increment = 1;
        return increment;
    }
}
