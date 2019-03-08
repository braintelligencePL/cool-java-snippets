package pl.braintelligence.katas

class Kotlin_2_Multiples_of_3_5 {

    fun findSumOfMultiples_3_5(naturalNumber: Int): Int {

        var result = 0

        (3 until naturalNumber step 3).forEach {
            result += it
        }

        (5 until naturalNumber step 5).forEach {
            result += it
        }

        return result

    }
}
