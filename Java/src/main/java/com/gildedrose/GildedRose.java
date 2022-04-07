package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            items[i].sellIn--;
            updateItemValues(i, items[i].name);
            resetQuality(i);
        }
    }

    private void updateItemValues(int i, String itemName) {
        if (itemName.equals("Sulfuras, Hand of Ragnaros")) {
            items[i].quality = Quality.SULFURAS.value;
            items[i].sellIn++;
        } else if (itemName.equals("Aged Brie")) {
            items[i].quality += getStandardIncrementValue(i, 1);
        } else if (itemName.equals("Backstage passes to a TAFKAL80ETC concert")) {
            items[i].quality += getTicketIncrementValue(i);
        } else if (itemName.contains("Conjured")) {
            items[i].quality -= getStandardIncrementValue(i, 2);
        } else {
            items[i].quality -= getStandardIncrementValue(i, 1);
        }
    }

    private void resetQuality(int i) {
        if (items[i].quality >= Quality.MAX.value && !items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
            items[i].quality = 50;
        }
        else if (items[i].quality < Quality.MIN.value) {
            items[i].quality = 0;
        }
    }

    private int getStandardIncrementValue(int i, int multiplier) {
        return items[i].sellIn >= 0 ? 1 * multiplier : 2 * multiplier;
    }

    private int getTicketIncrementValue(int i) {
        int increment;
        if (items[i].sellIn < 0) increment = -items[i].quality;
        else if (items[i].sellIn < 5) increment = 3;
        else if (items[i].sellIn < 10) increment = 2;
        else increment = 1;
        return increment;
    }
}
