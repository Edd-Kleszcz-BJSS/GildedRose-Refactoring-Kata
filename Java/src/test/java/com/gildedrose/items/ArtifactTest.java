package com.gildedrose.items;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArtifactTest {
    @Test
    void givenSellInGreaterThan0_returnQualityDecreaseBy2() {
        Artifact artifact = new Artifact(10, 10);
        artifact.updateItem();
        assertEquals(8, artifact.quality);
    }

    @Test
    void givenSellInEqualTo0_returnQualityDecreaseBy0() {
        Artifact artifact = new Artifact(0, 10);
        artifact.updateItem();
        assertEquals(10, artifact.quality);
    }

    @Test
    void givenSellInGreaterThanMinus10AndLessThan0_returnQualityIncreaseBy1() {
        Artifact artifact = new Artifact(-9, 10);
        artifact.updateItem();
        assertEquals(11, artifact.quality);
    }

    @Test
    void givenSellInLessThanOrEqualToMinus10_returnQualityIncreaseBy2() {
        Artifact artifact = new Artifact(-10, 10);
        artifact.updateItem();
        assertEquals(12, artifact.quality);
    }

    @Test
    void onUpdateItemInvocation_reduceSellInBy1() {
        Artifact artifact = new Artifact(10, 10);
        artifact.updateItem();
        assertEquals(9, artifact.sellIn);
    }

    @Test
    void afterUpdate_ensureQualityRemainsWithinMinAndMaxBounds() {
        Artifact artifact = new Artifact(10, 1);
        Artifact artifact2 = new Artifact(-10, 49);
        artifact.updateItem();
        artifact2.updateItem();

        assertEquals(0, artifact.quality);
        assertEquals(50, artifact2.quality);
    }

    @Test
    void givenAnIllegalQualityAsConstructorArgument_throwAnException() {
        assertThrows(Exception.class, () -> new Artifact(10, -1));
        assertThrows(Exception.class, () -> new Artifact(10, 51));
    }
}
