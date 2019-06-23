package pl.braintelligence.katas

import spock.lang.Specification

class _5_Primes extends Specification {


    def "Find total of sqrt of first k primes starting with n"() {
        given:
        def subject = new Kotlin_5_Primes()

        when:
        def result1 = subject.computeImperativeStyle(3, 3)
        def result2 = subject.computeFunctionalStyle(3, 3)

        then:
        result1 == 34
        result2 == 34
    }

    def "Should be true when number is prime"() {
        given: "prime number"

        when:
        def result = PrimeFinder.isPrime(number)

        then:
        result == isPrime

        where:
        number | isPrime
        2      | true
        9      | false
        4      | false
        5      | true
    }
}
