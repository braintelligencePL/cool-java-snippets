package pl.braintelligence.reactive.Reactor

import pl.braintelligence.domain.Person
import pl.braintelligence.domain.ReactivePersonRepository
import pl.braintelligence.domain.ReactiveRepository
import reactor.test.StepVerifier
import spock.lang.Specification


class Part002_MergeTest extends Specification {

    def exercise = new Part002_MergeSolution()

    ReactiveRepository<Person> slowRepository
    ReactiveRepository<Person> middleRepository
    ReactiveRepository<Person> fastRepository

    def setup() {
        middleRepository = new ReactivePersonRepository(250, List.of(Person.JOHN_DOE))
        slowRepository = new ReactivePersonRepository(500, List.of(Person.WHITE_WALKER, Person.JON_SNOW))
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
                .expectNext(
                        Person.FRANSIS_UNDERWOOD, Person.WALTER_WHITE,
                        Person.JOHN_DOE,
                        Person.WHITE_WALKER, Person.JON_SNOW
                ).verifyComplete()
    }

    def "Should concat persons1, persons2, persons3 without interleave"() {
        when:
        def subject = exercise.mergeFluxWithoutInterleave(
                middleRepository.findAll(),
                slowRepository.findAll(),
                fastRepository.findAll(),
        )

        then:
        StepVerifier.create(subject)
                .expectNext(
                        Person.WHITE_WALKER, Person.JON_SNOW,
                        Person.JOHN_DOE,
                        Person.FRANSIS_UNDERWOOD, Person.WALTER_WHITE,
                ).verifyComplete()
    }



}
