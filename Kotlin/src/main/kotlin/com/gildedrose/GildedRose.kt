package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        val updatableItems: List<UpdatableItem> = items.map { item -> updatableItem(item) }
        for (item in updatableItems) {
            if (item.name == "Aged Brie" || item.name == "Backstage passes to a TAFKAL80ETC concert") {
                item.incrementQuality()

                if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
                    if (item.sellIn < 11) {
                        item.incrementQuality()
                    }

                    if (item.sellIn < 6) {
                        item.incrementQuality()
                    }
                }
            } else {
                if (item.name != "Sulfuras, Hand of Ragnaros") {
                    item.decrementQuality()
                }
            }

            item.updateSellIn()

            if (item.sellIn >= 0) continue
            if (item.name != "Aged Brie") {
                if (item.name != "Backstage passes to a TAFKAL80ETC concert") {
                    if (item.name != "Sulfuras, Hand of Ragnaros") {
                        item.decrementQuality()
                    }
                } else {
                    item.quality = 0
                }
            } else {
                item.incrementQuality()
            }
        }
        this.items = updatableItems.toTypedArray()

    }

}

