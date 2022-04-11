package com.gildedrose.items;

import com.gildedrose.Quality;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConjuredTest {
    @Test
    void givenSellInGreaterThan0_returnQualityDecreaseOf2() {
        Conjured conjured = new Conjured("Conjured Item", 10, 10);
        conjured.updateItem();
        assertEquals(8, conjured.quality);
    }

    @Test
    void givenSellInOf0OrLess_returnQualityDecreaseOf4() {
        Conjured conjured = new Conjured("Conjured Item", 0, 10);
        conjured.updateItem();
        assertEquals(6, conjured.quality);
    }

    @Test
    void givenAnUpdate_sellInDecreaseBy1() {
        Conjured conjured = new Conjured("Conjured Item",10, 10);
        conjured.updateItem();
        assertEquals(9, conjured.sellIn);
    }

    @Test
    void onUpdate_ifQualityBecomesIllegal_returnQualityWithinBounds() {
        int nearMin = Quality.MIN.value + 1;
        Conjured conjured = new Conjured("Conjured Item",-3, nearMin);
        conjured.updateItem();
        assertEquals(Quality.MIN.value, conjured.quality);
    }

    @Test
    void givenNegativeQuality_throwAnException() {
        assertThrows(Exception.class, () -> new Conjured("Conjured Item",10, -1));
    }
}
