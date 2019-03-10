fun main(args: Array<String>) {

    // example of first class citizen OR function as a value
    val adder: (Int, Int) -> Double = { a, b -> (a + b).toDouble() }

    print(adder(1, 1))

}
