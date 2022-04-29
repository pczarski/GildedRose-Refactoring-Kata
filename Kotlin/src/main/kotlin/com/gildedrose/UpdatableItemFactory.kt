package com.gildedrose

fun updatableItem(item: Item): UpdatableItem {
    if (item.nameContains("Aged Brie")) {
        return object : UpdatableItemDecrementalSellin(item) {
            override fun updateQuality() {
                TODO("Not yet implemented")
            }

        }
    }

    if (item.nameContains("Sulfuras")) {
        return object : UpdatableItem(Item(item.name, item.sellIn, 80)) {
            override fun updateQuality() {
                return
            }

            override fun updateSellIn() {
                return
            }

        }
    }
    return object : UpdatableItemDecrementalSellin(item) {
        override fun updateQuality() {
            TODO("Not yet implemented")
        }

    }
}