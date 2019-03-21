package pl.braintelligence.spock_tutorial.domain

open interface UserRepositoryKotlin {

    fun isAvailable(): Boolean

    fun save(user: User)
}
