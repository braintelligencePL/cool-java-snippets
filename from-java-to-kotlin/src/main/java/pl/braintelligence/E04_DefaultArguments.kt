package pl.braintelligence

fun main() {
    hello("world")
}

fun hello(name: String = "World") = println("Hello, $name!")
