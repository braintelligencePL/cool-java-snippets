package pl.braintelligence.katas

class Kotlin_1_SocketsPairs {

    fun countNumberOfPairsLongVersion(arr: IntArray): Int {
        val colors: List<Int> = arr.toList()

        val groupedColors = colors.groupBy { it }

        val eachPairsGroupCounted = groupedColors.values.map { countPairs(it) }

        return eachPairsGroupCounted.sum()
    }

    fun countNumberOfPairsShortVersion(arr: IntArray) = arr.toList()
            .groupBy { it }.values
            .map { countPairs(it) }
            .sum()

    private fun countPairs(it: List<Int>) = it.size / 2

}
