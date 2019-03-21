package pl.braintelligence.functional_java.vavr.kotlin

fun main(args: Array<String>) {

    // example of first class citizen (another name is  function as a a value)
    val adder: (Int, Int) -> Double = { a, b -> (a + b).toDouble() }

    print(adder(1, 1))

}
