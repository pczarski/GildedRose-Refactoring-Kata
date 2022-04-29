package com.gildedrose

abstract class QualityUpdater {

    internal abstract fun changeQuality(item: Item)

    fun updateQuality(item: Item) {
        changeQuality(item)
        if (item.sellIn < 0) changeQuality(item)
    }
}