package pl.braintelligence.katas

import spock.lang.Specification

// Project Euler #1: Multiples of 3 and 5
class _2_Multiples_of_3_5_Test extends Specification {

    public static final int NATURAL_NUMBER = 10
    public static final int SUM_OF_MULTIPLES_3_5_FOR_GIVEN_NATURAL_NUMBER = 23

    def "(java) Should find sum of all multiples for 3, 5"() {
        given:
        def sumOfMultiples = new Java_2_Multiples_of_3_5()

        when: "N=10 we get 3,6,9 and 5"
        def result = sumOfMultiples.findSumOfMultiples_3_5(NATURAL_NUMBER)

        then: "sum for 3+6+9+5 is 23"
        result == SUM_OF_MULTIPLES_3_5_FOR_GIVEN_NATURAL_NUMBER
    }

    def "(kotlin) Should find sum of all multiples for 3, 5"() {
        given:
        def sumOfMultiples = new Kotlin_2_Multiples_of_3_5()

        when: "N=10 we get 3,6,9 and 5"
        def result = sumOfMultiples.findSumOfMultiples_3_5(NATURAL_NUMBER)

        then: "sum for 3+6+9+5 is 23"
        result == SUM_OF_MULTIPLES_3_5_FOR_GIVEN_NATURAL_NUMBER
    }
}
