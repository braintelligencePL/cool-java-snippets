package pl.braintelligence.katas

class Kotlin_4_KMostFrequentElements {

    fun kMostFreqElements(numbers: List<Int>): Int? = numbers
            .groupBy { it }
            .mapValues { it.value.count() }
            .maxBy { it.value }
            ?.key

}
