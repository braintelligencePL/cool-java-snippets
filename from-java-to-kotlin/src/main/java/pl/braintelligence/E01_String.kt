package pl.braintelligence

fun main() {
    val a = 4
    val b = 7

    println(getStringInterpolation(a, b))

    getStringInterpolation(1, 1).run { print(this) }

    println(
            getMultiline()
    )
}

private fun getStringInterpolation(a: Int, b: Int) = "sum of $a and $b is ${a + b}"

private fun getMultiline() = """
        |First Line
        |Second Line
        |Third Line
    """.trimMargin()

