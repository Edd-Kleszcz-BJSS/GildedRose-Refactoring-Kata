package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    private GildedRose addAndUpdateApp(Item[] products) {
        Item[] items = products;
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app;
    }

    private int getQuality(GildedRose app, int index) {
        return app.items[index].quality;
    }

    @Test
    void foo() {
        GildedRose app = addAndUpdateApp(new Item[]{new Item("foo", 10, 10)});
        assertEquals("foo", app.items[0].name);
    }


    @Test
    void givenStandardItemBeforeSellIn_returnsDecrementedValues() {
        GildedRose app = addAndUpdateApp(new Item[]{new Item("foo", 10, 10)});
        assertEquals(9, getQuality(app,0));
        assertEquals(9, app.items[0].sellIn);
    }
    @Test
    void givenStandardItemAfterSellIn_returnDecrementedValues() {
        GildedRose app = addAndUpdateApp(new Item[]{new Item("foo", 0, 10)});
        assertEquals(8, getQuality(app,0));
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void givenLowQualityStandardItem_returnsZeroQuality() {
        Item[] items = new Item[] {new Item("foo", 10, 0), new Item("bar", -1, 1)};
        GildedRose app = addAndUpdateApp(items);
        assertEquals(0, getQuality(app,0));
        assertEquals(0, getQuality(app,1));
    }

    @Test
    void givenAgedBrie_returnsIncreasedQuality() {
        Item[] items = new Item[] {new Item("Aged Brie", 10, 10)};
        GildedRose app = addAndUpdateApp(items);
        assertEquals(11, getQuality(app,0));
    }

    @Test
    void givenHighQualityBree_returnMaxQuality() {
        GildedRose app = addAndUpdateApp(new Item[]{new Item("Aged Brie", 10, 49), new Item("Aged Brie", 10, 50)});
        assertEquals(50, getQuality(app,0));
        assertEquals(50, getQuality(app,1));
    }

    @Test
    void givenAgedBrieAfterSellIn_returnQualityIncreasedBy2() {
        GildedRose app = addAndUpdateApp(new Item[]{new Item("Aged Brie", 0, 10)});
        assertEquals(12, getQuality(app,0));
    }

    @Test
    void givenSulfuras_returnConstantQuality() {
        GildedRose app = addAndUpdateApp(new Item[] {new Item("Sulfuras, Hand of Ragnaros", 10, 15), new Item("Sulfuras, Hand of Ragnaros", 0, 25)});
        assertEquals(15, getQuality(app, 0));
        assertEquals(25, getQuality(app, 1));
    }

    @Test
    void givenBackstagePassBeforeLargeSellIn_returnIncrementedQuality() {
        GildedRose app = addAndUpdateApp(new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 20, 5)});
        assertEquals(6, getQuality(app, 0));
    }

    @Test
    void givenBackstagePassBeforeSmallSellIn_returnDoubleIncrementedQuality() {
        GildedRose app = addAndUpdateApp(new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 9, 10)});
        assertEquals(12, getQuality(app, 0));
    }

    @Test
    void givenBackstagePassBeforeTinySellIn_returnTripleIncrementedQuality() {
        GildedRose app = addAndUpdateApp(new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 4, 10)});
        assertEquals(13, getQuality(app, 0));
    }

    @Test
    void givenBackstagePassBeforeSellInAndLargeQuality_returnQualityMax() {
        GildedRose app = addAndUpdateApp(new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 14, 49),new Item("Backstage passes to a TAFKAL80ETC concert", 9, 49),new Item("Backstage passes to a TAFKAL80ETC concert", 4, 49)});
        assertEquals(50, getQuality(app, 0));
        assertEquals(50, getQuality(app, 1));
        assertEquals(50, getQuality(app, 2));
    }

    @Test
    void givenBackstagePassAfterSellIn_return0Quality() {
        GildedRose app = addAndUpdateApp(new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10)});
        assertEquals(0, getQuality(app, 0));
    }

}
