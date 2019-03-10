package pl.braintelligence.katas

class Kotlin_2_Multiples_of_3_5 {

    fun findSum1(naturalNumber: Int): Int =
            (3 until naturalNumber)
                    .filter { it % 3 == 0 || it % 5 == 0 }
                    .sum()

    fun findSum2(naturalNumber: Int): Int =
            (3 until naturalNumber)
                    .filter { checkMultiplesOf(3, it) || checkMultiplesOf(5, it) }
                    .sum()

    private fun checkMultiplesOf(multiple: Int, currentValue: Int) = currentValue % multiple == 0
}
