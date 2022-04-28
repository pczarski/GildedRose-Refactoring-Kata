package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void sellInDecreasedAfterUpdateCalled() {
        Item[] items = new Item[] { new Item("foo", 1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].sellIn, 0);
    }

    @Test
    void qualityDecreasesTwiceAsFastAfterSellIn0andBelow() {
        Item[] items = new Item[] { new Item("foo", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 8);
    }

    @Test
    void qualityOfItemIsNotNegative() {
        Item[] items = new Item[] { new Item("foo", -1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 0);
    }

    @ParameterizedTest
    @CsvSource({
        "foo, 0, 10, -1, 8",
        "foo, -1, 0, -2, 0",
        ""
    })
    void qualityUpdated(String itemName, int initialSellIn, int initialQuality, int expectedSellIn, int expectedQuality) {
        Item[] items = new Item[] { new Item(itemName, initialSellIn, initialQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].sellIn, expectedSellIn);
        assertEquals(app.items[0].quality, expectedQuality);
    }



}
