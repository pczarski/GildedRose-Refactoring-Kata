package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        val updatableItems: List<UpdatableItem> = items.map { item -> updatableItem(item) }
        for (item in updatableItems) {
            item.updateSellIn()
            item.updateQuality()
        }
        this.items = updatableItems.toTypedArray()

    }

}

