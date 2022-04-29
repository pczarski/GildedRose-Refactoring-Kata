package com.gildedrose

class GildedRose(var items: Array<Item>) {
    fun updateQuality() {
        val updatableItems: List<UpdatableItem> = items.map { item -> updatableItem(item) }
        updatableItems.forEach {it.updateSellIn(); it.updateQuality()}
        this.items = updatableItems.toTypedArray()
    }
}