package pl.braintelligence

fun main() {

    val str: String = "abc"

    // Instance of and smart cast
    if (str is String) {
        println(str.substring(1))
    }

    val list = listOf("1", "2", 3, 4)

    // One way - more Java way
    val result = list
            .filter { String::class.java.isInstance(it) }
            .run { print(this) } // bc

    // Another way - more Kotlin way
    list.filter { it is String }.run { print(this) } // bc

}
