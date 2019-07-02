package pl.braintelligence

fun main() {
    var list = listOf<Int>(1, 2, 3)

    print(list.midElement())
}

fun <T> List<T>.midElement(): T {
    require(isNotEmpty()) { throw NoSuchElementException("List is empty") }
    return this[size / 2]
}
