package pl.braintelligence.reactive.Reactor

import org.apache.catalina.User
import pl.braintelligence.domain.Person
import reactor.core.publisher.Flux

class Part002_Merge {

    fun mergeStreams(stream1: Flux<String>, stream2: Flux<String>): Flux<String> =
            TODO("Merge two stream - watch what happens")

    fun mergeFluxWithInterleave(person: Flux<Person>): Flux<User> = TODO()
}

class Part002_MergeSolution {

    fun mergeStreams(stream1: Flux<String>, stream2: Flux<String>): Flux<String> = Flux
            .merge(stream1, stream2)

    fun mergeFluxWithInterleave(
            person1: Flux<Person>,
            person2: Flux<Person>,
            person3: Flux<Person>
    ): Flux<Person> = person1.mergeWith(person2).mergeWith(person3)
}
