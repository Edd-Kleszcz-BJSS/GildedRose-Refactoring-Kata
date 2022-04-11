package com.gildedrose.items;

import com.gildedrose.Quality;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackstagePassTest {
    @Test
    void givenSellInBetween1And5_returnQualityIncreaseOf3() {
        BackstagePass pass = new BackstagePass(4, 20);
        pass.updateItem();
        assertEquals(23, pass.quality);
    }

    @Test
    void givenSellInBetween6And10_returnQualityIncreaseOf2() {
        BackstagePass pass = new BackstagePass(7, 20);
        pass.updateItem();
        assertEquals(22, pass.quality);
    }

    @Test
    void givenSellInGreaterThan10_returnQualityIncreaseOf1() {
        BackstagePass pass = new BackstagePass(11, 20);
        pass.updateItem();
        assertEquals(21, pass.quality);
    }

    @Test
    void givenSellIn0OrLess_returnQualityOf0() {
        BackstagePass pass = new BackstagePass(0, 20);
        pass.updateItem();
        assertEquals(0, pass.quality);
    }

    @Test
    void givenAnUpdate_sellInDecreaseBy1() {
        BackstagePass pass = new BackstagePass(10, 10);
        pass.updateItem();
        assertEquals(9, pass.sellIn);
    }

    @Test
    void onUpdate_ifQualityBecomesIllegal_returnQualityWithinBounds() {
        int nearMax = Quality.MAX.value - 1;
        BackstagePass pass = new BackstagePass(4, nearMax);
        pass.updateItem();
        assertEquals(Quality.MAX.value, pass.quality);
    }

    @Test
    void givenNegativeQuality_throwAnException() {
        assertThrows(Exception.class, () -> new BackstagePass(10, -1));
    }
}
