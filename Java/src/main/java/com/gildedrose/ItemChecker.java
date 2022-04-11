package com.gildedrose;

import com.gildedrose.items.UpdateQuality;
import org.jetbrains.annotations.NotNull;

public class ItemChecker {
    public static void areValidItems(@NotNull UpdateQuality[] items) throws RuntimeException {
        containsValidItems(items);
        allHaveValidQuality(items);
    }

    private static void containsValidItems(UpdateQuality[] items) throws NullPointerException {
        if (items.length == 0) {
            throw new NullPointerException("Items empty");
        }
    }

    private static void allHaveValidQuality(UpdateQuality[] items) throws RuntimeException {
        for (UpdateQuality item: items) {
            if (item.hasInvalidQuality()) {
                throw new RuntimeException("Item has Illegal Quality");
            }
        }
    }
}
