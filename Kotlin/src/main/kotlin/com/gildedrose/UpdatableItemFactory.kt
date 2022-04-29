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

private fun defaultItem(item: Item): UpdatableItem = object: UpdatableItemDecrementalSellin(item) {
    override fun updateQuality() {
        getQualityUpdater(-1).updateQuality(this)
    }
}

fun updatableItem(item: Item): UpdatableItem {
    when {
        item.nameContains("Sulfuras") -> return sulfuras(item)
        item.nameContains("Aged Brie") -> return agedBrie(item)
        item.nameContains("Backstage passes") -> return backstagePasses(item)
    }
    return defaultItem(item)
}