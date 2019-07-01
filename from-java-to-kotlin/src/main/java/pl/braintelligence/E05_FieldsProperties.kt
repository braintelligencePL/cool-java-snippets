package pl.braintelligence

class Person {
    var name: String = "Jack"
        set(name) {
            if (name.isNotEmpty()) field = name
        }
}

fun main() {
    val person = Person()
    person.name = "Other Jack"

    print(person.name)
}
