package com.gildedrose.items;

import com.gildedrose.factory.ItemFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemFactoryTest {
    ItemFactory itemFactory = new ItemFactory();

    @Test
    void givenSulfuras_returnsNewSulfurasObject() {
        assertEquals(Sulfuras.class, itemFactory.createItem("Sulfuras, Hand of Ragnaros", 10, 10).getClass());
    }

    @Test
    void givenAgedBrie_returnNewAgedBrieObject() {
        assertEquals(AgedBrie.class, itemFactory.createItem("Aged Brie", 10, 10).getClass());
    }

    @Test
    void givenBackstagePass_returnNewBackstagePassObject() {
        assertEquals(BackstagePass.class, itemFactory.createItem("Backstage passes to a TAFKAL80ETC concert", 1, 1).getClass());
    }

    @Test
    void givenAnythingElse_returnNewOtherObject() {
        assertEquals(Other.class, itemFactory.createItem("Something Else", 10, 10).getClass());
    }

    @Test
    void givenConjuredItem_returnConjuredObject() {
        assertEquals(Conjured.class, itemFactory.createItem("Conjured Cake", 10, 10).getClass());
    }
}
