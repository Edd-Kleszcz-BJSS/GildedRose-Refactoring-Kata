package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            String itemName = items[i].name;
            items[i].sellIn--;
            updateItemValues(i, itemName);
            resetQuality(i);
        }
    }

    private void updateItemValues(int i, String itemName) {
        if (itemName.equals("Sulfuras, Hand of Ragnaros")) {
            items[i].sellIn++;
        } else if (itemName.equals("Aged Brie")) {
            int increment = items[i].sellIn >= 0 ? 1 : 2;
            items[i].quality += increment;
        } else if (itemName.equals("Backstage passes to a TAFKAL80ETC concert")) {
            int increment = incrementPasses(i);
            items[i].quality += increment;
        } else {
            int increment = items[i].sellIn >= 0 ? 1 : 2;
            items[i].quality -= increment;
        }
    }

    private void resetQuality(int i) {
        if (items[i].quality >= 50) items[i].quality = 50;
        else if (items[i].quality < 0) items[i].quality = 0;
    }

    private int incrementPasses(int i) {
        int increment;
        if (items[i].sellIn < 0) increment = -items[i].quality;
        else if (items[i].sellIn < 5) increment = 3;
        else if (items[i].sellIn < 10) increment = 2;
        else increment = 1;
        return increment;
    }
}
