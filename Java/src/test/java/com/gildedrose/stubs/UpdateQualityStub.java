package com.gildedrose.stubs;

import com.gildedrose.items.services.UpdateQuality;

public class UpdateQualityStub implements UpdateQuality {
    private int timesUpdateItemInvoked = 0;

    @Override
    public void updateItem() {
         timesUpdateItemInvoked++;
    }

    public int getTimesUpdateItemInvoked() {
        return timesUpdateItemInvoked;
    }
}
