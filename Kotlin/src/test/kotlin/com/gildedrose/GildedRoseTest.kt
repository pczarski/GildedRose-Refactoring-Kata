package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    val items = arrayOf(
        Item("+5 Dexterity Vest", 10, 20), //
        Item("Aged Brie", 2, 0), //
        Item("Elixir of the Mongoose", 5, 7), //
        Item("Sulfuras, Hand of Ragnaros", 0, 80), //
        Item("Sulfuras, Hand of Ragnaros", -1, 80),
        Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
        Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
        // this conjured item does not work properly yet
        Item("Conjured Mana Cake", 3, 6)
    )

    @Test
    fun foo() {
        val items = arrayOf<Item>(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("foo", app.items[0].name)
    }

    @Test
    internal fun `validate update quality`() {
        val app = GildedRose(items)
        app.updateQuality()

        assertItem(Item("+5 Dexterity Vest", 9, 19), items[0])
        assertItem(Item("Aged Brie", 1, 1), items[1])
        assertItem(Item("Elixir of the Mongoose", 4, 6), items[2])
        assertItem(Item("Sulfuras, Hand of Ragnaros", 0, 80), items[3])
        assertItem(Item("Sulfuras, Hand of Ragnaros", -1, 80), items[4])
        assertItem(Item("Backstage passes to a TAFKAL80ETC concert", 14, 21), items[5])
        assertItem(Item("Backstage passes to a TAFKAL80ETC concert", 9, 50), items[6])
        assertItem(Item("Backstage passes to a TAFKAL80ETC concert", 4, 50), items[7])
        assertItem(Item("Conjured Mana Cake", 2, 5), items[8])
    }

    private fun assertItem(expectedItem: Item, actualItem: Item) {
        assertEquals(expectedItem.name, actualItem.name)
        assertEquals(expectedItem.sellIn, actualItem.sellIn, actualItem.name)
        assertEquals(expectedItem.quality, actualItem.quality, actualItem.name)
    }
}


