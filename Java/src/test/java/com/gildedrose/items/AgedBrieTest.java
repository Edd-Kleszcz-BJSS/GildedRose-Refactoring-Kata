package com.gildedrose.items;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgedBrieTest {
    @Test
    void givenPositiveSellIn_returnQualityIncreaseOf1() {
        AgedBrie brie = new AgedBrie(1, 10);
        brie.updateItem();
        assertEquals(11, brie.quality);
    }

    @Test
    void givenNegativeOrZeroSellIn_returnQualityIncreaseOf2() {
        AgedBrie brie = new AgedBrie(-10, 10);
        AgedBrie brie2 = new AgedBrie(0, 10);

        brie.updateItem();
        brie2.updateItem();

        assertEquals(12, brie.quality);
        assertEquals(12, brie2.quality);
    }

    @Test
    void givenNegativeQuality_throwAnException() {
        assertThrows(Exception.class, () -> new AgedBrie(10, -1));
    }
}
