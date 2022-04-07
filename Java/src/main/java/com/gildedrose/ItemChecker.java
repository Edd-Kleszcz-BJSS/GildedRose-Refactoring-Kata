package com.gildedrose;

public class ItemChecker {
    public static void areValidItems(Item[] items) {
        containsItems(items);
        allHaveValidQuality(items);
    }

    private static boolean containsItems(Item[] items) {
        boolean isEmpty = items.length == 0;

        if (isEmpty) {
            throw new NullPointerException("Items empty");
        }

        return true;
    }

    private static boolean allHaveValidQuality(Item[] items) throws RuntimeException {
        for (int index = 0; index < items.length; index++) {
            if (items[index].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[index].quality = Quality.SULFURAS.value;
            } else if (items[index].quality < Quality.MIN.value) {
                throw new RuntimeException("Item quality insufficient");
            } else if (items[index].quality > Quality.MAX.value) {
                throw new RuntimeException("Item quality extreme");
            }
        }
        return true;
    }

}
