package pl.braintelligence.katas

import spock.lang.Specification

// https://www.hackerrank.com/challenges/java-bigdecimal/problem
class _3_BigDecimalSortDescTest extends Specification {

    def "(kotlin) Should sort BigDecimal array in descending order"() {
        given:
        def subject = new Kotlin_3_BigDecimalSortDesc()
        def numbers = [
                new BigDecimal(".123"),
                new BigDecimal("-100"),
                new BigDecimal("000.000"),
                new BigDecimal("02.24"),
                new BigDecimal("50.2")
        ]

        when:
        def result = subject.sortNumbersDescending(numbers)

        then:
        with(result) {
            get(0) == 50.2
            get(1) == 02.24
            get(2) == 0.123
            get(3) == 000.000
            get(4) == -100
        }
    }

    def "(java) Should sort BigDecimal array in descending order"() {
        given:
        def subject = new Java_3_BigDecimalSortDesc()
        def numbers = [
                new BigDecimal(".123"),
                new BigDecimal("-100"),
                new BigDecimal("000.000"),
                new BigDecimal("02.24"),
                new BigDecimal("50.2")
        ]

        when:
        def result = subject.sortNumbersDescending(numbers)

        then:
        with(result) {
            get(0) == 50.2
            get(1) == 02.24
            get(2) == 0.123
            get(3) == 000.000
            get(4) == -100
        }

    }

}
