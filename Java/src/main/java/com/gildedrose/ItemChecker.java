package com.gildedrose;

public class ItemChecker {
    public static boolean allHaveValidQuality(Item[] items) throws RuntimeException {
        for (int index = 0; index < items.length; index++) {
            if (items[index].quality < Quality.MIN.value) {
                throw new RuntimeException("Item quality insufficient");
            }
        }
        return true;
    }
}
