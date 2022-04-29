package com.gildedrose

private fun sulfuras(item: Item): UpdatableItem = object: UpdatableItem(Item(item.name, item.sellIn, 80)) {

    init {
        if(item.quality < 80) throw IllegalArgumentException()
    }

    override fun updateQuality() {
        return
    }

    override fun updateSellIn() {
        return
    }
}

private fun agedBrie(item: Item): UpdatableItem = object: UpdatableItemDecrementalSellin(item) {
    override fun updateQuality() {
        this.incrementQuality()
        if(sellIn < 0) this.incrementQuality()
    }
}

private fun backstagePasses(item: Item): UpdatableItem = object: UpdatableItemDecrementalSellin(item) {
    override fun updateQuality() {
        when  {
            this.sellIn < 0 -> {this.quality = 0; return}
            this.sellIn <= 5 -> {this.incrementQuality(3); return}
            this.sellIn <= 10 -> {this.incrementQuality(2); return}
        }
        this.incrementQuality()
    }
}

private fun defaultItem(item: Item): UpdatableItem = object: UpdatableItemDecrementalSellin(item) {
    override fun updateQuality() {
        this.decrementQuality()
        if(sellIn < 0) this.decrementQuality()
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