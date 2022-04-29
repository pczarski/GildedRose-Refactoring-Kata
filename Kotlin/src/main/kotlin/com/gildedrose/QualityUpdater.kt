package com.gildedrose

abstract class QualityUpdater {

    internal abstract fun changeQuality(item: Item)

    fun updateQuality(item: Item) {
        changeQuality(item)
        if (item.sellIn < 0) changeQuality(item)
    }
}

/**
 * thresholds correspond to amounts in intervals: (thresholds[i], thresholds[i+1]] -> amount[i]
 * final threshold is Integer.MAX
 * assumes thresholds are sorted ascending
 */
fun getQualityUpdater(sellInThresholds: Array<Int>, amounts: Array<Int>): QualityUpdater {

    if (sellInThresholds.size + 1 != amounts.size) throw IllegalArgumentException()

    val actualThresholds = arrayOf(Integer.MIN_VALUE) + sellInThresholds + arrayOf(Integer.MAX_VALUE)

    return object : QualityUpdater() {
        override fun changeQuality(item: Item) {
            for (i in actualThresholds.indices) {
                if (item.sellIn > actualThresholds[i] && item.sellIn <= actualThresholds[i + 1]) {
                    item.changeQuality(amounts[i])
                    return
                }
            }
        }
    }
}


fun getQualityUpdater(value: Int) = object : QualityUpdater() {
    override fun changeQuality(item: Item) {
        item.changeQuality(value)
    }
}
//
//fun customIntervalsUpdater(degree: Int, thresholds: Array<Int>, degrees: Array<Int>) = object: QualityUpdater() {
//    override fun changeQuality(item: Item) {
//        for ()
//    }
//}
//
//fun incrementalUpdater(degree: Int) = object: QualityUpdater() {
//    override fun changeQuality(item: Item) {
//        item.incrementQuality(degree)
//    }
//
//}
//
//fun decrementalUpdater(degree: Int) = object: QualityUpdater() {
//    override fun changeQuality(item: Item) {
//        item.decrementQuality(degree)
//    }
//}