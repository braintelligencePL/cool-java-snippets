package pl.braintelligence.katas

class Kotlin_1_SocketsPairs {

    fun countNumberOfPairs(arr: IntArray): Int {
        val colors: List<Int> = arr.toList()

        val groupedColors = colors.groupBy { it }

        val eachPairsGroupCounted = groupedColors.values.map { countPairs(it) }

        return eachPairsGroupCounted.sum()
    }

    private fun countPairs(it: List<Int>) = it.size / 2

}
