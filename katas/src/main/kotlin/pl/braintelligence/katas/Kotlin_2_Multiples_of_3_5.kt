package pl.braintelligence.katas

class Kotlin_2_Multiples_of_3_5 {

    fun findSum(naturalNumber: Int): Int =
            (3 until naturalNumber)
                    .filter { it % 3 == 0 || it % 5 == 0 }
                    .sum()
}


fun HigherOrderFunction(): Int{

}
