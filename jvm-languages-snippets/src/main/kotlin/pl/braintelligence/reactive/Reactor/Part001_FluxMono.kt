package pl.braintelligence.reactive.Reactor

import pl.braintelligence.domain.Person
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import java.util.*
import java.util.function.Supplier

class Part001_FluxMono {

    fun emptyFlux(): Flux<String> =
            TODO("Return an empty Flux")

    fun emptyMono(): Flux<String> =
            TODO("Return an empty Mono")

    fun fluxFromValues(): Flux<String> =
            TODO("Return a Flux with 2 values foo, bar (NO ARRAY ALLOWED)")

    fun fluxFromList(): Flux<String> =
            TODO("Return a Flux with 2 values foo, bar (AS LIST)")

    fun errorFlux(): Flux<String> =
            TODO("Return (throw) IllegalStateException")

    fun counter(): Flux<Long> =
            TODO("Create a Flux that emits increasing values from 0L...9L each 100ms")

    fun expectLotsOfElements(): Supplier<Flux<Long>> =
            TODO("Expect 10000 elements at intervals of 1 seconds")

    fun createTwoPersons(): Flux<Person> =
            TODO("Create two Persons (read test for constructor parameters)")

    fun capitalizeOne(): Mono<Person> =
            TODO("Capitalize the user username, firstname and lastname")

    fun capitalizeMany(users: Flux<Person>): Flux<Person> =
            TODO("Capitalize the users username, firstName and lastName")
}

class Part001_FluxMonoSolution {

    fun emptyFlux(): Flux<String> = Flux
            .empty()

    fun emptyMono(): Mono<String> = Mono
            .empty()

    fun fluxFromValues(): Flux<String> = Flux
            .just("foo", "bar")

    fun fluxFromList(): Flux<String> = Flux
            .fromIterable(Arrays.asList("foo", "bar"))

    fun errorFlux(): Flux<String> = Flux
            .error(IllegalStateException())

    fun counter(): Flux<Long> = Flux
            .interval(Duration.ofMillis(100))
            .take(10)

    fun expectLotsOfElements(): Supplier<Flux<Long>> = Supplier {
        Flux.interval(Duration.ofSeconds(1))
                .take(10_000)
    }

    fun createTwoPersons(): Flux<Person> = Flux.just(
            Person("firstname-1", "last-1"),
            Person("firstname-2", "last-2")
    )

    fun capitalizeOne(user: Mono<Person>): Mono<Person> = user.map {
        Person(
                it.firstname.toUpperCase(),
                it.lastname.toUpperCase()
        )
    }

    fun capitalizeMany(users: Flux<Person>): Flux<Person> = users.map {
        Person(
                it.firstname.toUpperCase(),
                it.lastname.toUpperCase()
        )
    }

}
