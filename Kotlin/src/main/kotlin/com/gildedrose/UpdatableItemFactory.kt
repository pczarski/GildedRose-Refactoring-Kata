package com.gildedrose

private fun sulfuras(item: Item): UpdatableItem = object: UpdatableItem(Item(item.name, item.sellIn, 80)) {

    override fun updateQuality() {
        return
    }

    override fun updateSellIn() {
        return
    }
}

private fun agedBrie(item: Item): UpdatableItem = object: UpdatableItemDecrementalSellin(item) {
    override fun updateQuality() {
        getQualityUpdater(1).updateQuality(this)
    }
}

private fun backstagePasses(item: Item): UpdatableItem = object: UpdatableItemDecrementalSellin(item) {
    override fun updateQuality() {
        getQualityUpdater(sellInThresholds = arrayOf(-1, 5, 10), amounts = arrayOf(0-MAX_QUALITY, 3, 2, 1)).updateQuality(this)
    }
}

private fun conjured(item: Item): UpdatableItem = object: UpdatableItemDecrementalSellin(item) {
    override fun updateQuality() {
        getQualityUpdater(2).changeQuality(this)
    }

}

private fun defaultItem(item: Item): UpdatableItem = object: UpdatableItemDecrementalSellin(item) {
    override fun updateQuality() {
        getQualityUpdater(-1).updateQuality(this)
    }
}

internal interface UpdatableItemFactory {
    fun make(item: Item): UpdatableItem
}

private val specialItemsMap = mapOf(
    "Sulfuras" to object: UpdatableItemFactory { override fun make(item: Item): UpdatableItem { return sulfuras(item) } },
    "Aged Brie" to object: UpdatableItemFactory { override fun make(item: Item): UpdatableItem { return agedBrie(item) } },
    "Backstage passes" to object: UpdatableItemFactory { override fun make(item: Item): UpdatableItem { return backstagePasses(item) } },
    "Conjured" to object: UpdatableItemFactory { override fun make(item: Item): UpdatableItem { return conjured(item) } },
)

private val defaultItemFactory = object: UpdatableItemFactory { override fun make(item: Item): UpdatableItem { return defaultItem(item) } }

fun updatableItem(item: Item): UpdatableItem {
    var baseName = "not a special item"
    specialItemsMap.keys.forEach {
        if (item.nameContains(it)) baseName = it
    }
    return specialItemsMap.getOrDefault(baseName, defaultItemFactory).make(item)
}