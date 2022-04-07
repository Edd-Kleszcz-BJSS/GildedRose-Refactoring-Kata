package com.gildedrose;

public class ItemChecker {
    public static void areValidItems(Item[] items) throws RuntimeException {
        containsValidItems(items);
        allHaveValidQuality(items);
    }

    private static void containsValidItems(Item [] items) throws NullPointerException {
        if (items == null) {
            throw new NullPointerException("Items must be fully defined");
        } else if (items.length == 0) {
            throw new NullPointerException("Items empty");
        }
        for (Item item : items) {
            if (item.name == null) {
                throw new NullPointerException("Items must be fully defined");
            }
        }
    }

    private static void allHaveValidQuality(Item[] items) throws RuntimeException {
        for (Item item : items) {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.quality = Quality.SULFURAS.value;
            } else if (item.quality < Quality.MIN.value) {
                throw new RuntimeException("Item quality insufficient");
            } else if (item.quality > Quality.MAX.value) {
                throw new RuntimeException("Item quality extreme");
            }
        }
    }
}
