package pl.braintelligence.reactive.Reactor

import pl.braintelligence.domain.Person
import reactor.core.publisher.Flux

class Part002_Merge {

    fun mergeStreams(
            stream1: Flux<String>,
            stream2: Flux<String>
    ): Flux<String> =
            TODO("Merge two stream - watch what happens")

    fun mergeFluxWithInterleave(
            person1: Flux<Person>,
            person2: Flux<Person>,
            person3: Flux<Person>
    ): Flux<Person> =
            TODO("Merge 3 sources with interleave (in other works order doesn't matter)")
}

class Part002_MergeSolution {

    fun mergeFluxWithInterleave(
            person1: Flux<Person>,
            person2: Flux<Person>,
            person3: Flux<Person>
    ): Flux<Person> =
            person1.mergeWith(person2).mergeWith(person3)

    fun mergeFluxWithoutInterleave(
            person1: Flux<Person>,
            person2: Flux<Person>,
            person3: Flux<Person>
    ): Flux<Person> =
            person1.concatWith(person2).concatWith(person3)

}
