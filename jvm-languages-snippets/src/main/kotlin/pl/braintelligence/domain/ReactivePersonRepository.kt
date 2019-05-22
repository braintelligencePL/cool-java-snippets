package pl.braintelligence.domain

import org.reactivestreams.Publisher
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toFlux
import java.time.Duration
import java.util.function.BiFunction

class ReactivePersonRepository(
        val delayInMs: Long = DEFAULT_DELAY_IN_MS,
        val persons: List<Person> = listOf(Person.WALTER_WHITE, Person.JESSE_PINKMAN, Person.JON_SNOW)
) : ReactiveRepository<Person> {

    override fun save(publisher: Publisher<Person>): Mono<Void> {
        TODO("not implemented")
    }

    override fun findFirst(): Mono<Person> {
        TODO("not implemented")
    }

    override fun findById(id: String): Mono<Person> {
        TODO("not implemented")
    }

    override fun findAll(): Flux<Person> {
        return withDelay(persons.toFlux())
    }

    fun withDelay(userFlux: Flux<Person>): Flux<Person> {
        return Flux.interval(Duration.ofMillis(delayInMs)).zipWith(userFlux, BiFunction { _, user -> user })
    }
    companion object {
        private const val DEFAULT_DELAY_IN_MS = 100L
    }
}
