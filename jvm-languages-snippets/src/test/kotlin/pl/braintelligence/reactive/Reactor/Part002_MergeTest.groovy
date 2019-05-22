package pl.braintelligence.reactive.Reactor

import pl.braintelligence.domain.Person
import pl.braintelligence.domain.ReactivePersonRepository
import pl.braintelligence.domain.ReactiveRepository
import reactor.test.StepVerifier
import spock.lang.Specification


class Part002_MergeTest extends Specification {

    def exercise = new Part002_MergeSolution()

    ReactiveRepository<Person> slowRepository
    ReactiveRepository<Person> fastRepository
    ReactiveRepository<Person> middleRepository

    def setup() {
        slowRepository = new ReactivePersonRepository(500, List.of(Person.WHITE_WALKER, Person.JON_SNOW))
        middleRepository = new ReactivePersonRepository(250, List.of(Person.JOHN_DOE))
        fastRepository = new ReactivePersonRepository(50, List.of(Person.FRANSIS_UNDERWOOD, Person.WALTER_WHITE))
    }

    def "Should merge persons1, persons2, persons3 with interleave"() {
        when:
        def subject = exercise.mergeFluxWithInterleave(
                middleRepository.findAll(),
                fastRepository.findAll(),
                slowRepository.findAll(),
        )

        then:
        StepVerifier.create(subject)
                .expectNext(Person.FRANSIS_UNDERWOOD)
                .expectNext(Person.WALTER_WHITE)
                .expectNext(Person.JOHN_DOE)
                .expectNext(Person.WHITE_WALKER)
                .expectNext(Person.JON_SNOW)
                .verifyComplete()
    }
}
