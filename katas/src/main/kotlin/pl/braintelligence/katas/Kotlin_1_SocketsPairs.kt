package pl.braintelligence.katas

class Kotlin_1_SocketsPairs {

    fun findAllPairs(arr: IntArray): Int {
        val colors: Array<Int> = arr.toTypedArray()

        val groupedColors = colors.groupBy { it }

        val eachColorPairs = groupedColors.values.map { it.size / 2 }

        return eachColorPairs.sum()
    }

}
