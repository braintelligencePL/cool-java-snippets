package pl.braintelligence.reactive.Reactor

import pl.braintelligence.domain.Person
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.test.StepVerifier
import spock.lang.Specification

import java.time.Duration

class Part001_FluxMonoTest extends Specification {

    def exercise = new Part001_FluxMono()

    def "Should create emptyFlux"() {
        when:
        def subject = exercise.emptyFlux()

        then:
        StepVerifier.create(subject)
                .verifyComplete()
    }

    def "Should create emptyMono"() {
        when:
        def subject = exercise.emptyMono()

        then:
        StepVerifier.create(subject)
                .verifyComplete()
    }

    def "Should create Flux fromValues (NO ARRAY ALLOWED)"() {
        when:
        def subject = exercise.fluxFromValues()

        then:
        StepVerifier.create(subject)
                .expectNext("foo", "bar")
                .verifyComplete()
    }

    def "Should create Flux from List"() {
        when:
        def subject = exercise.fluxFromList()

        then:
        StepVerifier.create(subject)
                .expectNext("foo", "bar")
                .verifyComplete()
    }

    def "Should return IllegalStateException"() {
        when:
        def subject = exercise.errorFlux()

        then:
        StepVerifier.create(subject)
                .verifyError(IllegalStateException.class)
    }

    def "Should count each every 100ms"() {
        when:
        def subject = exercise.counter()

        then:
        StepVerifier.create(subject)
                .expectNext(0L, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L)
                .verifyComplete()
    }

    def "Should create Person"() {
        when:
        def subject = exercise.createTwoPersons()

        then:
        StepVerifier.create(subject)
                .expectNextMatches { it.firstname == "firstname-1" }
                .assertNext {
                    it.with {
                        it.firstname == "firstname-2"
                        it.lastname == "last-2"
                    }
                }
                .verifyComplete()
    }

    def "Should create 10000 elements"() {
        when:
        def subject = exercise.expectLotsOfElements()

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
        def subject = exercise.capitalizeOne(person)

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
        def subject = exercise.capitalizeMany(persons)

        then:
        StepVerifier.create(subject)
                .expectNext(new Person("UPPER1", "CASE1"))
                .expectNext(new Person("UPPER2", "CASE2"))
                .verifyComplete()
    }

}
