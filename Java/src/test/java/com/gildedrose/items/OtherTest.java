package com.gildedrose.items;

import com.gildedrose.Quality;
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
    void givenAnUpdate_sellInDecreaseBy1() {
        Other other = new Other("test",10, 10);
        other.updateItem();
        assertEquals(9, other.sellIn);
    }

    @Test
    void onUpdate_ifQualityBecomesIllegal_returnQualityWithinBounds() {
        int nearMin = Quality.MIN.value + 1;
        Other other = new Other("Other",-3, nearMin);
        other.updateItem();
        assertEquals(Quality.MIN.value, other.quality);
    }

    @Test
    void givenNegativeQuality_throwAnException() {
        assertThrows(Exception.class, () -> new Other("Test",10, -1));
    }
}
