package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void givenStandardItemBeforeSellIn_returnsDecrementedValues() {
        Item[] items = new Item[] { new Item("foo", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }
    @Test
    void givenStandardItemAfterSellIn_returnDecrementedValues() {
        Item[] items = new Item[] { new Item("foo", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void givenLowQualityStandardItem_returnsZeroQuality() {
        Item[] items = new Item[] { new Item("foo", 10, 0), new Item("bar", -1, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(0, app.items[1].quality);
    }

}
