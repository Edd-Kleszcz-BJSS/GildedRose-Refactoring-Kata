package com.gildedrose.items;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OtherTest {
    @Test
    void givenSellInGreaterThan0_returnQualityDecreaseOf1() {
        Other other = new Other("test", 10, 10);
        other.updateItem();
        assertEquals(9, other.quality);
    }

    @Test
    void givenSellInLessThanOrEqualTo0_returnQualityDecreaseOf2() {
        Other other = new Other("test", 0, 10);
        other.updateItem();
        assertEquals(8, other.quality);
    }

    @Test
    void givenNegativeQuality_throwAnException() {
        assertThrows(Exception.class, () -> new Other("Test",10, -1));
    }
}
