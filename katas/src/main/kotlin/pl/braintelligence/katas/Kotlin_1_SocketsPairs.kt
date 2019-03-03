package pl.braintelligence.katas

class Kotlin_1_SocketsPairs {

    fun countNumberOfPairs(arr: IntArray): Int {
        val colors: Array<Int> = arr.toTypedArray()

        val groupedColors = colors.groupBy { it }

        val eachGroupPairsCounted = groupedColors.values.map { it.size / 2 }

        return eachGroupPairsCounted.sum()
    }

    fun findAllPairs2(arr: IntArray) = arr.toTypedArray()
            .groupBy { color -> color }
            .values
            .map { countPairs(it) }
            .sum()

    private fun countPairs(it: List<Int>) = it.size / 2

}
