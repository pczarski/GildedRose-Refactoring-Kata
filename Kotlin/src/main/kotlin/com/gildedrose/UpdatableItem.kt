package com.gildedrose

abstract class UpdatableItem(item: Item) : Item(item.name, item.sellIn, item.quality) {
    abstract fun updateQuality()
}