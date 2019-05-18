package pl.braintelligence.other.functional_bricks


data class User(val name: String, val address: Address)

data class Address(val street: String?)

fun main(args: Array<String>) {
    val user: User? = User("", Address(null))

    val printMe = user?.address?.street ?: "nasty null was found instead of a street :("

    print(printMe)
}
