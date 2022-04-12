package com.gildedrose.items;

public class Artifact extends AbstractBaseItem {
    public Artifact(int sellIn, int quality) {
        super("Ancient Artifact", sellIn, quality);
    }

    @Override
    public void updateItem() {
        quality += getIncrementValue();
        sellIn--;
        resetIllegalQuality();
    }

    private int getIncrementValue() {
        if (sellIn > 0) {
            return -2;
        } else if (sellIn == 0) {
            return 0;
        } else if (sellIn > -10) {
            return 1;
        } else {
            return 2;
        }
    }
}
