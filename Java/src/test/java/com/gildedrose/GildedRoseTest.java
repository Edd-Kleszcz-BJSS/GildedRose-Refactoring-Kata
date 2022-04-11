package com.gildedrose;

import com.gildedrose.items.ItemFactory;
import com.gildedrose.items.services.CreateItem;
import com.gildedrose.items.services.UpdateQuality;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class GildedRoseTest {
    CreateItem itemFactory = new ItemFactory();

    private GildedRose addAndUpdateApp(UpdateQuality[] items) {
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
        GildedRose app = addAndUpdateApp(new UpdateQuality[]{itemFactory.createItem("foo", 10, 10)});
        assertEquals(9, getQuality(app,0));
        assertEquals(9, getSellIn(app, 0));
    }
    @Test
    void givenStandardItemAfterSellIn_returnDecrementedValues() {
        GildedRose app = addAndUpdateApp(new UpdateQuality[]{itemFactory.createItem("foo", 0, 10)});
        assertEquals(8, getQuality(app,0));
        assertEquals(-1, getSellIn(app, 0));
    }

    @Test
    void givenLowQualityStandardItem_returnsZeroQuality() {
        UpdateQuality[] items = new UpdateQuality[]{itemFactory.createItem("foo", 10, 0), itemFactory.createItem("bar", -1, 1)};
        GildedRose app = addAndUpdateApp(items);
        assertEquals(0, getQuality(app,0));
        assertEquals(0, getQuality(app,1));
        assertEquals(9, getSellIn(app, 0));
        assertEquals(-2, getSellIn(app, 1));
    }

    @Test
    void givenAgedBrie_returnsIncreasedQuality() {
        UpdateQuality[] items = new UpdateQuality[] {itemFactory.createItem("Aged Brie", 10, 10)};
        GildedRose app = addAndUpdateApp(items);
        assertEquals(11, getQuality(app,0));
        assertEquals(9, getSellIn(app, 0));
    }

    @Test
    void givenHighQualityBree_returnMaxQuality() {
        GildedRose app = addAndUpdateApp(new UpdateQuality[]{itemFactory.createItem("Aged Brie", 10, 49), itemFactory.createItem("Aged Brie", 10, 50)});
        assertEquals(50, getQuality(app,0));
        assertEquals(50, getQuality(app,1));
        assertEquals(9, getSellIn(app, 0));
        assertEquals(9, getSellIn(app, 1));
    }

    @Test
    void givenAgedBrieAfterSellIn_returnQualityIncreasedBy2() {
        GildedRose app = addAndUpdateApp(new UpdateQuality[]{itemFactory.createItem("Aged Brie", 0, 10)});
        assertEquals(12, getQuality(app,0));
        assertEquals(-1, getSellIn(app, 0));
    }

    @Test
    void givenSulfuras_returnConstantQuality() {
        GildedRose app = addAndUpdateApp(new UpdateQuality[] {itemFactory.createItem("Sulfuras, Hand of Ragnaros", 10, 15), itemFactory.createItem("Sulfuras, Hand of Ragnaros", 0, 25)});
        assertEquals(80, getQuality(app, 0));
        assertEquals(80, getQuality(app, 1));
    }

    @Test
    void givenSulfurasItem_returnAppropriateQualityBeforeUpdate() {
        UpdateQuality item = itemFactory.createItem("Sulfuras, Hand of Ragnaros", 10, 70);
        GildedRose app = new GildedRose(new UpdateQuality[] {item});
        assertEquals(80, getQuality(app, 0));
        assertEquals(10, getSellIn(app, 0));
    }

    @Test
    void givenBackstagePassBeforeLargeSellIn_returnIncrementedQuality() {
        GildedRose app = addAndUpdateApp(new UpdateQuality[] {itemFactory.createItem("Backstage passes to a TAFKAL80ETC concert", 20, 5)});
        assertEquals(6, getQuality(app, 0));
        assertEquals(19, getSellIn(app, 0));
    }

    @Test
    void givenBackstagePassBeforeSmallSellIn_returnDoubleIncrementedQuality() {
        GildedRose app = addAndUpdateApp(new UpdateQuality[] {itemFactory.createItem("Backstage passes to a TAFKAL80ETC concert", 10, 10)});
        assertEquals(12, getQuality(app, 0));
        assertEquals(9, getSellIn(app, 0));
    }

    @Test
    void givenBackstagePassBeforeTinySellIn_returnTripleIncrementedQuality() {
        GildedRose app = addAndUpdateApp(new UpdateQuality[] {itemFactory.createItem("Backstage passes to a TAFKAL80ETC concert", 5, 10)});
        assertEquals(13, getQuality(app, 0));
        assertEquals(4, getSellIn(app, 0));
    }

    @Test
    void givenBackstagePassBeforeSellInAndLargeQuality_returnQualityMax() {
        GildedRose app = addAndUpdateApp(new UpdateQuality[] {itemFactory.createItem("Backstage passes to a TAFKAL80ETC concert", 14, 49), itemFactory.createItem("Backstage passes to a TAFKAL80ETC concert", 9, 49), itemFactory.createItem("Backstage passes to a TAFKAL80ETC concert", 4, 49)});
        assertEquals(50, getQuality(app, 0));
        assertEquals(50, getQuality(app, 1));
        assertEquals(50, getQuality(app, 2));
        assertEquals(13, getSellIn(app, 0));
        assertEquals(8, getSellIn(app, 1));
        assertEquals(3, getSellIn(app, 2));
    }

    @Test
    void givenBackstagePassAfterSellIn_return0Quality() {
        GildedRose app = addAndUpdateApp(new UpdateQuality[] {itemFactory.createItem("Backstage passes to a TAFKAL80ETC concert", 0, 10)});
        assertEquals(0, getQuality(app, 0));
        assertEquals(-1, getSellIn(app, 0));
    }

    @Test
    void givenBackstagePassAfterSellInAfterMultipleDays_returnsConsistent0Quality() {
        GildedRose app = new GildedRose(new UpdateQuality[] {itemFactory.createItem("Backstage passes to a TAFKAL80ETC concert", 0, 10)});
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(0, getQuality(app, 0));
        assertEquals(-3, getSellIn(app, 0));
    }

    @Test
    void givenConjuredItemBeforeSellIn_returnDeprecatedQuality() {
        GildedRose app = addAndUpdateApp(new UpdateQuality[]{itemFactory.createItem("Conjured Wand", 10, 10), itemFactory.createItem("Conjured Broom", 10, 10)});
        assertEquals(8, getQuality(app, 0));
        assertEquals(8, getQuality(app, 1));
        assertEquals(9, getSellIn(app, 0));
        assertEquals(9, getSellIn(app, 1));
    }

    @Test
    void givenConjuredItemAfterSellIn_returnDoubleDeprecatedQuality() {
        GildedRose app = addAndUpdateApp(new UpdateQuality[]{itemFactory.createItem("Conjured Wand", -2, 10), itemFactory.createItem("Conjured Broom", 0, 10)});
        assertEquals(6, getQuality(app, 0));
        assertEquals(6, getQuality(app, 1));
        assertEquals(-3, getSellIn(app, 0));
        assertEquals(-1, getSellIn(app, 1));
    }

    @Test
    void givenConjuredItemWithLowQuality_returnZeroQuality() {
        GildedRose app = addAndUpdateApp(new UpdateQuality[]{itemFactory.createItem("Conjured Wand", 2, 1), itemFactory.createItem("Conjured Broom", 10, 0)});
        assertEquals(0, getQuality(app, 0));
        assertEquals(0, getQuality(app, 1));
        assertEquals(1, getSellIn(app, 0));
        assertEquals(9, getSellIn(app, 1));
    }

    // *** SAD TESTS ***

    @Test
    void givenAnItemWithNegativeQuality_throwsAnErrorBeforeAppCreation() {
        Assertions.assertThrows(RuntimeException.class, () -> itemFactory.createItem("test", 10, -1));
    }

    @Test
    void givenAnItemWithExtremeQuality_throwsAnErrorBeforeAppCreation() {
        Assertions.assertThrows(RuntimeException.class, () -> itemFactory.createItem("test", 10, 51));
    }

    @Test
    void givenSulfurasItemWithAppropriateQuality_returnAppAsUsual() {
        UpdateQuality item = itemFactory.createItem("Sulfuras, Hand of Ragnaros", 10, 80);
        GildedRose app = new GildedRose(new UpdateQuality[] {item});
        assertEquals(80, getQuality(app, 0));
        assertEquals(10, getSellIn(app, 0));
    }

    @Test
    void givenNullFieldInItem_throwsNullException() {
        Assertions.assertThrows(NullPointerException.class, () -> itemFactory.createItem(null, 0, 0));
    }

    @Test
    void givenNullItemsArray_throwsNullException() {
        Assertions.assertThrows(Exception.class, () -> new GildedRose(null));
    }
}
