package com.gildedrose;

import com.gildedrose.factory.ItemFactory;
import com.gildedrose.factory.CreateItem;
import com.gildedrose.items.services.UpdateQuality;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoldenTests {
    CreateItem itemFactory = new ItemFactory();
    public UpdateQuality[] createItems() {
        return new UpdateQuality[]{
            itemFactory.createItem("+5 Dexterity Vest", 10, 20),
            itemFactory.createItem("Aged Brie", 2, 0),
            itemFactory.createItem("Elixir of the Mongoose", 5, 7),
            itemFactory.createItem("Sulfuras, Hand of Ragnaros", 0, 80),
            itemFactory.createItem("Sulfuras, Hand of Ragnaros", -1, 80),
            itemFactory.createItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            itemFactory.createItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            itemFactory.createItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            itemFactory.createItem("Conjured Mana Cake", 3, 6)};
    }

    @Test
    void after1DayTick_returnsItemsWithTheirExpectedQualityAndSellInValues() {
        GildedRose app = new GildedRose(createItems());
        int[][] expectedValues = {{9, 19}, {1, 1}, {4, 6}, {0, 80}, {-1, 80}, {14, 21}, {9, 50}, {4, 50}, {2, 4}};
        app.updateQuality();

        for(int index = 0; index < app.items.length; index++) {
            Item item = (Item) app.items[index];
            assertEquals(expectedValues[index][0], item.sellIn);
            assertEquals(expectedValues[index][1], item.quality);
        }
    }

    @Test
    void after3DayTicks_returnsItemsWithTheirExpectedQualityAndSellInValues() {
        GildedRose app = new GildedRose(createItems());
        int[][] expectedValues = {{7, 17}, {-1, 4}, {2, 4}, {0, 80}, {-1, 80}, {12, 23}, {7, 50}, {2, 50}, {0, 0}};
        for (int day = 0; day < 3; day++) {
            app.updateQuality();
        }

        for(int index = 0; index < app.items.length; index++) {
            Item item = (Item) app.items[index];
            assertEquals(expectedValues[index][0], item.sellIn);
            assertEquals(expectedValues[index][1], item.quality);
        }
    }

    @Test
    void after10DayTicks_returnsItemsWithTheirExpectedQualityAndSellInValues() {
        GildedRose app = new GildedRose(createItems());
        int[][] expectedValues = {{0, 10}, {-8, 18}, {-5, 0}, {0, 80}, {-1, 80}, {5, 35}, {0, 50}, {-5, 0}, {-7, 0}};
        for (int day = 0; day < 10; day++) {
            app.updateQuality();
        }

        for(int index = 0; index < app.items.length; index++) {
            Item item = (Item) app.items[index];
            assertEquals(expectedValues[index][0], item.sellIn);
            assertEquals(expectedValues[index][1], item.quality);
        }
    }

    @Test
    void after16DayTicks_returnsItemsWithTheirExpectedQualityAndSellInValues() {
        GildedRose app = new GildedRose(createItems());
        int[][] expectedValues = {{-6, 0}, {-14, 30}, {-11, 0}, {0, 80}, {-1, 80}, {-1, 0}, {-6, 0}, {-11, 0}, {-13, 0}};
        for (int day = 0; day < 16; day++) {
            app.updateQuality();
        }

        for(int index = 0; index < app.items.length; index++) {
            Item item = (Item) app.items[index];
            assertEquals(expectedValues[index][0], item.sellIn);
            assertEquals(expectedValues[index][1], item.quality);
        }
    }

}
