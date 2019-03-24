package pl.braintelligence.functional_java.spock_tutorial.domain


interface UserRepo {
    fun isAvailable(): Boolean
    fun save(user: User)
}


open class UserRepoImpl : UserRepo {
    override fun save(user: User) {
        print("User saved")
    }

    override fun isAvailable(): Boolean {
        return false
    }
}


data class User(private val name: String) {
    fun getPrivilege(role: Role): Role = role
}

enum class Role { USER, ADMIN }
