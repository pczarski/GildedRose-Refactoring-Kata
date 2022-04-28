package com.gildedrose

class UpdatableItemFactory {
    fun updatableItem(item: Item): UpdatableItem {
        if(item.nameContains("Aged Brie")) {
            return object : UpdatableItem(item) {
                override fun updateQuality() {
                    if (this.quality < 50) {
                        this.incrementQuality()
                    }
                }

            }
        }
        return object : UpdatableItem(item) {
            override fun updateQuality() {
                TODO("Not yet implemented")
            }

        }
    }
}