package pl.braintelligence.other.functional_bricks

fun main() {
    val adder: (Int, Int) -> Double = { a, b -> (a + b).toDouble() }
    print(adder(1, 1))
}
