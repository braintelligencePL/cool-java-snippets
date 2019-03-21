package pl.braintelligence.spock_tutorial.domain

data class User(
        private val name: String
) {
    fun getPrivilege(role: Role): Role = role
}

interface UserRepo {
    fun isAvailable(): Boolean
    fun save(user: User)
}

enum class Role {
    USER, ADMIN

}
