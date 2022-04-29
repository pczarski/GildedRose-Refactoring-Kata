package com.gildedrose

fun Item.nameContains(otherItem: String): Boolean {
    return this.name.contains(otherItem, ignoreCase = false)
}

fun Item.decrementQuality() {
    this.quality = Integer.max(this.quality - 1, 0)
}

fun Item.incrementQuality(amount: Int) {
    if(amount <= 0) throw IllegalArgumentException()
    this.quality = Integer.min(this.quality + amount, 50)
}

fun Item.incrementQuality() {
    this.incrementQuality(1)
}

