package pl.braintelligence

fun main() {
    val name: String? = null

    name?.let { print(it.length) }

    name ?: print("default fallback")

    name?.let {
        print(it.length)
    } ?: run {
        print("default fallback")
    }

}
