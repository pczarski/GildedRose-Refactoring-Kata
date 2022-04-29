package com.gildedrose

abstract class UpdatableItemDecrementalSellin(item: Item): UpdatableItem(item) {
    override fun updateSellIn() {
        this.sellIn -= 1
    }
}