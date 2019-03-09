package pl.braintelligence.katas

class Kotlin_2_Multiples_of_3_5 {

    fun findSumOfMultiples_3_5(naturalNumber: Int): Int {

        return (3 until naturalNumber)
                .filter { it % 3 == 0 || it % 5 == 0 }
                .sum()

    }


}
