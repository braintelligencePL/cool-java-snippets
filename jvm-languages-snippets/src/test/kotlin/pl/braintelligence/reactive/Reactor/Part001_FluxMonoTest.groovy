package pl.braintelligence.reactive.Reactor

import pl.braintelligence.other.domain.Person
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.test.StepVerifier
import spock.lang.Specification

import java.time.Duration

class Part001_FluxMonoTest extends Specification {

    def fluxMono = new Part001_FluxMonoSolution()

    def "Should create emptyFlux"() {
        when:
        def subject = fluxMono.emptyFlux()

        then:
        StepVerifier.create(subject)
                .verifyComplete()
    }

    def "Should create emptyMono"() {
        when:
        def subject = fluxMono.emptyMono()

        then:
        StepVerifier.create(subject)
                .verifyComplete()
    }

    def "Should create Flux fromValues()"() {
        when:
        def subject = fluxMono.fluxFromValues()

        then:
        StepVerifier.create(subject)
                .expectNext("foo", "bar")
                .verifyComplete()
    }

    def "Should create Flux from List"() {
        when:
        def subject = fluxMono.fluxFromList()

        then:
        StepVerifier.create(subject)
                .expectNext("foo", "bar")
                .verifyComplete()
    }

    def "Should return IllegalStateException"() {
        when:
        def subject = fluxMono.errorFlux()

        then:
        StepVerifier.create(subject)
                .verifyError(IllegalStateException.class)
    }

    def "Should count each every 100ms"() {
        when:
        def subject = fluxMono.counter()

        then:
        StepVerifier.create(subject)
                .expectNext(0L, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L)
                .verifyComplete()
    }

    def "Should create Person"() {
        when:
        def subject = fluxMono.createTwoPersons()

        then:
        StepVerifier.create(subject)
                .expectNextMatches { it.name == "name-1" }
                .assertNext {
                    it.with {
                        it.name == "name-2"
                        it.lastname == "last-2"
                    }
                }
                .verifyComplete()
    }

    def "Should create 10000 elements"() {
        when:
        def subject = fluxMono.expectLotsOfElements()

        then:
        StepVerifier.withVirtualTime(subject)
                .thenAwait(Duration.ofSeconds(10_000))
                .expectNextCount(10_000)
                .verifyComplete()
    }

    def "Should capitalize one"() {
        given:
        def person = Mono.just(new Person("upper", "case"))

        when:
        def subject = fluxMono.capitalizeOne(person)

        then:
        StepVerifier.create(subject)
                .expectNext(new Person("UPPER", "CASE"))
                .verifyComplete()
    }

    def "Should capitalize many"() {
        given:
        def persons = Flux.just(
                new Person("upper1", "case1"),
                new Person("upper2", "case2"),
        )

        when:
        def subject = fluxMono.capitalizeMany(persons)

        then:
        StepVerifier.create(subject)
                .expectNext(new Person("UPPER1", "CASE1"))
                .expectNext(new Person("UPPER2", "CASE2"))
                .verifyComplete()

    }



}
