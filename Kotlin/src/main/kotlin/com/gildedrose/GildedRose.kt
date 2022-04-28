package com.gildedrose

class GildedRose(var items: Array<Item>) {

    private fun updateItemSellIn(item: Item) {
        if (item.name != "Sulfuras, Hand of Ragnaros") {
            item.sellIn = item.sellIn - 1
        }
    }

    fun updateQuality() {
        for (item in items) {
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
                if (item.quality > 0) {
                    if (item.name != "Sulfuras, Hand of Ragnaros") {
                        item.quality = item.quality - 1
                    }
                }
            }

            updateItemSellIn(item)

            if (item.sellIn >= 0) continue
            if (item.name != "Aged Brie") {
                if (item.name != "Backstage passes to a TAFKAL80ETC concert") {
                    if (item.quality > 0) {
                        if (item.name != "Sulfuras, Hand of Ragnaros") {
                            item.quality = item.quality - 1
                        }
                    }
                } else {
                    item.quality = 0
                }
            } else {
                item.incrementQuality()
            }
        }
    }

}

