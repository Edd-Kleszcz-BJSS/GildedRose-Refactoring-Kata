package com.gildedrose;

import com.gildedrose.items.services.UpdateQuality;
import com.gildedrose.stubs.UpdateQualityStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GildedRoseTest {
    @Test
    void givenArrayOfOneUpdateQualityMethod_returnsUpdatedValues() {
        UpdateQuality[] items = new UpdateQualityStub[] {new UpdateQualityStub()};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        UpdateQualityStub stub = (UpdateQualityStub) app.items[0];
        assertEquals(1, stub.getTimesUpdateItemInvoked());
    }

    @Test
    void givenArrayOfMultipleUpdateQualityMethods_returnUpdatedValues() {
        UpdateQuality[] items = new UpdateQualityStub[] {new UpdateQualityStub(), new UpdateQualityStub(), new UpdateQualityStub()};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        UpdateQualityStub[] stubs = (UpdateQualityStub[]) app.items;

        for (UpdateQualityStub stub: stubs) {
            assertEquals(1, stub.getTimesUpdateItemInvoked());
        }
    }

    @Test
    void givenArrayOfMultipleUpdateQualityMethodsAndInvocations_returnUpdatedValues() {
        UpdateQuality[] items = new UpdateQualityStub[] {new UpdateQualityStub(), new UpdateQualityStub(), new UpdateQualityStub()};
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < 4; i++) {
            app.updateQuality();
        }

        UpdateQualityStub[] stubs = (UpdateQualityStub[]) app.items;

        for (UpdateQualityStub stub: stubs) {
            assertEquals(4, stub.getTimesUpdateItemInvoked());
        }
    }

    @Test
    void givenNullConstructorArgument_throwAnError() {
        assertThrows(Exception.class, () -> new GildedRose(null));
    }

    @Test
    void givenArrayContainingNull_throwAnError() {
        UpdateQuality[] items = new UpdateQuality[] {null};
        GildedRose app = new GildedRose(items);

        assertThrows(Exception.class, app::updateQuality);
    }
}
