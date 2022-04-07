package com.gildedrose;

public enum Quality {
    MAX(50), MIN(0), SULFURAS(80);

    public final int value;

    Quality(int value) {
        this.value = value;
    }
}
