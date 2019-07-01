package pl.braintelligence

fun main() {
    val a = 4
    val b = 7

    // Java way
    println(getStringInterpolation(a, b))

    // Kotlin way - String interpolation
    getStringInterpolation(1, 1).run { print(this) }

    // Kotlin way - multiline String
    getMultiline().run { print(this) }
}

// without class function exists in package scope
fun getStringInterpolation(a: Int, b: Int) = "sum of $a and $b is ${a + b}"

fun getMultiline() = """
        |First Line
        |Second Line
        |Third Line
    """.trimMargin()

