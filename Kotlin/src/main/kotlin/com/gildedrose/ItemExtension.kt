package com.gildedrose

const val MAX_QUALITY: Int = 50

fun Item.nameContains(otherName: String): Boolean {
    return this.name.contains(otherName, ignoreCase = true)
}

fun Item.changeQuality(value: Int) {
    this.quality = (this.quality + value).coerceAtLeast(0).coerceAtMost(MAX_QUALITY)
}