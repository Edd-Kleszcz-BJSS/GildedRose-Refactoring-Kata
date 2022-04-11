package com.gildedrose.items;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SulfurasTest {
    @Test
    void doesNotDecreaseQuality() {
        Sulfuras sulfuras = new Sulfuras(1);
        sulfuras.updateItem();
        assertEquals(80, sulfuras.quality);
    }

    @Test
    void doesNotDecreaseSellIn() {
        Sulfuras sulfuras = new Sulfuras(1);
        sulfuras.updateItem();
        assertEquals(1, sulfuras.sellIn);
    }
}
