package com.gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    private GildedRose addAndUpdateApp(Item[] items) {
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app;
    }

    private int getQuality(GildedRose app, int index) {
        Item item = (Item) app.items[index];
        return item.quality;
    }

    private int getSellIn(GildedRose app, int index) {
        Item item = (Item) app.items[index];
        return item.sellIn;
    }

    @Test
    void givenStandardItemBeforeSellIn_returnsDecrementedValues() {
        GildedRose app = addAndUpdateApp(new Item[]{new Item("foo", 10, 10)});
        assertEquals(9, getQuality(app,0));
        assertEquals(9, getSellIn(app, 0));
    }
    @Test
    void givenStandardItemAfterSellIn_returnDecrementedValues() {
        GildedRose app = addAndUpdateApp(new Item[]{new Item("foo", 0, 10)});
        assertEquals(8, getQuality(app,0));
        assertEquals(-1, getSellIn(app, 0));
    }

    @Test
    void givenLowQualityStandardItem_returnsZeroQuality() {
        Item[] items = new Item[] {new Item("foo", 10, 0), new Item("bar", -1, 1)};
        GildedRose app = addAndUpdateApp(items);
        assertEquals(0, getQuality(app,0));
        assertEquals(0, getQuality(app,1));
        assertEquals(9, getSellIn(app, 0));
        assertEquals(-2, getSellIn(app, 1));
    }

    @Test
    void givenAgedBrie_returnsIncreasedQuality() {
        Item[] items = new Item[] {new Item("Aged Brie", 10, 10)};
        GildedRose app = addAndUpdateApp(items);
        assertEquals(11, getQuality(app,0));
        assertEquals(9, getSellIn(app, 0));
    }

    @Test
    void givenHighQualityBree_returnMaxQuality() {
        GildedRose app = addAndUpdateApp(new Item[]{new Item("Aged Brie", 10, 49), new Item("Aged Brie", 10, 50)});
        assertEquals(50, getQuality(app,0));
        assertEquals(50, getQuality(app,1));
        assertEquals(9, getSellIn(app, 0));
        assertEquals(9, getSellIn(app, 1));
    }

    @Test
    void givenAgedBrieAfterSellIn_returnQualityIncreasedBy2() {
        GildedRose app = addAndUpdateApp(new Item[]{new Item("Aged Brie", 0, 10)});
        assertEquals(12, getQuality(app,0));
        assertEquals(-1, getSellIn(app, 0));
    }

    @Test
    void givenSulfuras_returnConstantQuality() {
        GildedRose app = addAndUpdateApp(new Item[] {new Item("Sulfuras, Hand of Ragnaros", 10, 15), new Item("Sulfuras, Hand of Ragnaros", 0, 25)});
        assertEquals(80, getQuality(app, 0));
        assertEquals(80, getQuality(app, 1));
    }

    @Test
    void givenSulfurasItem_returnAppropriateQualityBeforeUpdate() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 70);
        GildedRose app = new GildedRose(new Item[] {item});
        assertEquals(80, getQuality(app, 0));
        assertEquals(10, getSellIn(app, 0));
    }

    @Test
    void givenBackstagePassBeforeLargeSellIn_returnIncrementedQuality() {
        GildedRose app = addAndUpdateApp(new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 20, 5)});
        assertEquals(6, getQuality(app, 0));
        assertEquals(19, getSellIn(app, 0));
    }

    @Test
    void givenBackstagePassBeforeSmallSellIn_returnDoubleIncrementedQuality() {
        GildedRose app = addAndUpdateApp(new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10)});
        assertEquals(12, getQuality(app, 0));
        assertEquals(9, getSellIn(app, 0));
    }

    @Test
    void givenBackstagePassBeforeTinySellIn_returnTripleIncrementedQuality() {
        GildedRose app = addAndUpdateApp(new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10)});
        assertEquals(13, getQuality(app, 0));
        assertEquals(4, getSellIn(app, 0));
    }

    @Test
    void givenBackstagePassBeforeSellInAndLargeQuality_returnQualityMax() {
        GildedRose app = addAndUpdateApp(new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 14, 49),new Item("Backstage passes to a TAFKAL80ETC concert", 9, 49),new Item("Backstage passes to a TAFKAL80ETC concert", 4, 49)});
        assertEquals(50, getQuality(app, 0));
        assertEquals(50, getQuality(app, 1));
        assertEquals(50, getQuality(app, 2));
        assertEquals(13, getSellIn(app, 0));
        assertEquals(8, getSellIn(app, 1));
        assertEquals(3, getSellIn(app, 2));
    }

    @Test
    void givenBackstagePassAfterSellIn_return0Quality() {
        GildedRose app = addAndUpdateApp(new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10)});
        assertEquals(0, getQuality(app, 0));
        assertEquals(-1, getSellIn(app, 0));
    }

    @Test
    void givenBackstagePassAfterSellInAfterMultipleDays_returnsConsistent0Quality() {
        GildedRose app = new GildedRose(new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10)});
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(0, getQuality(app, 0));
        assertEquals(-3, getSellIn(app, 0));
    }

    @Test
    void givenConjuredItemBeforeSellIn_returnDeprecatedQuality() {
        GildedRose app = addAndUpdateApp(new Item[]{new Item("Conjured Wand", 10, 10), new Item("Conjured Broom", 10, 10)});
        assertEquals(8, getQuality(app, 0));
        assertEquals(8, getQuality(app, 1));
        assertEquals(9, getSellIn(app, 0));
        assertEquals(9, getSellIn(app, 1));
    }

    @Test
    void givenConjuredItemAfterSellIn_returnDoubleDeprecatedQuality() {
        GildedRose app = addAndUpdateApp(new Item[]{new Item("Conjured Wand", -2, 10), new Item("Conjured Broom", 0, 10)});
        assertEquals(6, getQuality(app, 0));
        assertEquals(6, getQuality(app, 1));
        assertEquals(-3, getSellIn(app, 0));
        assertEquals(-1, getSellIn(app, 1));
    }

    @Test
    void givenConjuredItemWithLowQuality_returnZeroQuality() {
        GildedRose app = addAndUpdateApp(new Item[]{new Item("Conjured Wand", 2, 1), new Item("Conjured Broom", 10, 0)});
        assertEquals(0, getQuality(app, 0));
        assertEquals(0, getQuality(app, 1));
        assertEquals(1, getSellIn(app, 0));
        assertEquals(9, getSellIn(app, 1));
    }

    // *** SAD TESTS ***

    @Test
    void givenAnItemWithNegativeQuality_throwsAnErrorBeforeAppCreation() {
        Item item = new Item("test", 10, -1);
        Assertions.assertThrows(RuntimeException.class, () -> new GildedRose(new Item[] {item}));
    }

    @Test
    void givenAnItemWithExtremeQuality_throwsAnErrorBeforeAppCreation() {
        Item item = new Item("test", 10, 51);
        Assertions.assertThrows(RuntimeException.class, () -> new GildedRose(new Item[] {item}));
    }

    @Test
    void givenSulfurasItemWithAppropriateQuality_returnAppAsUsual() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 80);
        GildedRose app = new GildedRose(new Item[] {item});
        assertEquals(80, getQuality(app, 0));
        assertEquals(10, getSellIn(app, 0));
    }

    @Test
    void givenNullFieldInItem_throwsNullException() {
        Item[] items = new Item[] {new Item(null, 0, 0)};
        Assertions.assertThrows(NullPointerException.class, () -> new GildedRose(items));
    }

    @Test
    void givenNullItemsArray_throwsNullException() {
        Assertions.assertThrows(Exception.class, () -> new GildedRose(null));
    }
}
