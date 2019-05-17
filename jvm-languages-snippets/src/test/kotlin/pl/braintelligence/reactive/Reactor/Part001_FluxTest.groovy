package pl.braintelligence.reactive.Reactor


import reactor.test.StepVerifier
import spock.lang.Specification

class Part001_FluxTest extends Specification {

    def part001_Flux = new Part001_FluxSolution()

    def "Should create emptyFlux"() {
        when:
        def subject = part001_Flux.emptyFlux()

        then:
        StepVerifier.create(subject)
                .verifyComplete()
    }

    def "Should create Flux fromValues()"() {
        when:
        def subject = part001_Flux.fluxFromValues()

        then:
        StepVerifier.create(subject)
                .expectNext("foo", "bar")
                .verifyComplete()
    }

    def "Should create Flux from List"() {
        when:
        def subject = part001_Flux.fluxFromList()

        then:
        StepVerifier.create(subject)
                .expectNext("foo", "bar")
                .verifyComplete()
    }

    def "Should return IllegalStateException"() {
        when:
        def subject = part001_Flux.errorFlux()

        then:
        StepVerifier.create(subject)
                .verifyError(IllegalStateException.class)
    }

    def "Should count each every 100ms"() {
        when:
        def subject = part001_Flux.counter()

        then:
        StepVerifier.create(subject)
                .expectNext(0L, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L)
                .verifyComplete()
    }

}
