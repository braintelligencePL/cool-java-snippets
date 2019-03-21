package pl.braintelligence.spock_tutorial.domain

open class UserRepositoryKotlinImpl : UserRepositoryKotlin {
    override fun save(user: User) {
        print("User saved")
    }

    override fun isAvailable(): Boolean = false
}
