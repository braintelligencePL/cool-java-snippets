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

}
