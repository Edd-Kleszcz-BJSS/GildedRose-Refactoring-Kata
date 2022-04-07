package com.gildedrose;

public class ItemChecker {
    public static void areValidItems(Item[] items) throws RuntimeException {
        containsItems(items);
        hasCompleteItems(items);
        allHaveValidQuality(items);
    }

    private static void containsItems(Item [] items) throws NullPointerException {
        if (items == null) {
            throw new NullPointerException("Items must be fully defined");
        } else if (items.length == 0) {
            throw new NullPointerException("Items empty");
        }
    }

    private static void hasCompleteItems(Item[] items) {
        for (int index = 0; index < items.length; index++) {
            if (items[index].name == null) {
                throw new NullPointerException("Items must be fully defined");
            }
        }
    }

    private static void allHaveValidQuality(Item[] items) throws RuntimeException {
        for (int index = 0; index < items.length; index++) {
            if (items[index].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[index].quality = Quality.SULFURAS.value;
            } else if (items[index].quality < Quality.MIN.value) {
                throw new RuntimeException("Item quality insufficient");
            } else if (items[index].quality > Quality.MAX.value) {
                throw new RuntimeException("Item quality extreme");
            }
        }
    }

}
