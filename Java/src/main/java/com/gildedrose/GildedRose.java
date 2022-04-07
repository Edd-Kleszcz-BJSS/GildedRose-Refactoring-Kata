package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int index = 0; index < items.length; index++) {
            items[index].sellIn--;
            updateItemValues(index, items[index].name);
            resetQuality(index);
        }
    }

    private void updateItemValues(int index, String itemName) {
        if (itemName.equals("Sulfuras, Hand of Ragnaros")) {
            items[index].quality = Quality.SULFURAS.value;
            items[index].sellIn++;
        } else if (itemName.equals("Aged Brie")) {
            items[index].quality += getStandardIncrementValue(index, 1);
        } else if (itemName.equals("Backstage passes to a TAFKAL80ETC concert")) {
            items[index].quality += getTicketIncrementValue(index);
        } else if (itemName.contains("Conjured")) {
            items[index].quality -= getStandardIncrementValue(index, 2);
        } else {
            items[index].quality -= getStandardIncrementValue(index, 1);
        }
    }

    private void resetQuality(int index) {
        if (items[index].quality >= Quality.MAX.value && !items[index].name.equals("Sulfuras, Hand of Ragnaros")) {
            items[index].quality = 50;
        }
        else if (items[index].quality < Quality.MIN.value) {
            items[index].quality = 0;
        }
    }

    private int getStandardIncrementValue(int index, int multiplier) {
        return items[index].sellIn >= 0 ? 1 * multiplier : 2 * multiplier;
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
