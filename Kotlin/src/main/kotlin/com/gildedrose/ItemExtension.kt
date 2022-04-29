package com.gildedrose

val MAX_QUALITY: Int
    get() = 50

fun Item.nameContains(otherName: String): Boolean {
    return this.name.contains(otherName, ignoreCase = true)
}

fun Item.changeQuality(value: Int) {
    this.quality = (this.quality + value).coerceAtLeast(0).coerceAtMost(MAX_QUALITY)
}

//fun Item.decrementQuality(amount: Int) {
//    this.quality = (this.quality - amount).coerceAtLeast(0)
//}
//
//fun Item.incrementQuality(amount: Int) {
//    if(amount <= 0) throw IllegalArgumentException()
//    this.quality = (this.quality + amount).coerceAtMost(50)
//}
//
//fun Item.incrementQuality() {
//    this.incrementQuality(1)
//}

