package pl.braintelligence.reactive.Reactor

import reactor.core.publisher.Flux
import java.time.Duration
import java.util.*

class Part001_Flux {

    fun emptyFlux(): Flux<String> = TODO("Return an empty Flux")

    fun fluxFromValues(): Flux<String> = TODO("Return a Flux with 2 values foo, bar (NO ARRAY)")

    fun fluxFromList(): Flux<String> = TODO("Return a Flux with 2 values foo, bar (AS LIST)")

    fun errorFlux(): Flux<String> = TODO("Return IllegalStateException")

    fun counter(): Flux<Long> = TODO("Create a _001_Flux that emits increasing values from 0 to 9 each 100ms")

}

class Part001_FluxSolution {

    fun emptyFlux(): Flux<String> = Flux.empty()

    fun fluxFromValues(): Flux<String> = Flux.just("foo", "bar")

    fun fluxFromList(): Flux<String> = Flux.fromIterable(Arrays.asList("foo", "bar"))

    fun errorFlux(): Flux<String> = Flux.error(IllegalStateException())

    fun counter(): Flux<Long> = Flux
            .interval(Duration.ofMillis(100))
            .take(10)
}
