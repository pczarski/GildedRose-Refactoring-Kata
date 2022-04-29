package com.gildedrose

fun getQualityUpdater(value: Int) = object : QualityUpdater() {
    override fun changeQuality(item: Item) {
        item.changeQuality(value)
    }
}

/**
 * thresholds correspond to amounts in intervals: (thresholds[i], thresholds[i+1]] -> amount[i]
 * final threshold is Integer.MAX
 * assumes thresholds are sorted ascending
 * assumes thresholds.size + 1 == intervals.size
 */
fun getQualityUpdater(sellInThresholds: Array<Int>, amounts: Array<Int>): QualityUpdater {

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