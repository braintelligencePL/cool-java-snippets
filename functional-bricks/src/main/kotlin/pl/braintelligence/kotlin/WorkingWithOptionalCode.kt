package pl.braintelligence.kotlin


data class User(val name: String, val address: Address)

data class Address(val street: String?)

fun main(args: Array<String>) {
    val user = User("asd", Address(null))

    val printMe = user.address.street ?: "DEFAULT"

    print(printMe)
}

