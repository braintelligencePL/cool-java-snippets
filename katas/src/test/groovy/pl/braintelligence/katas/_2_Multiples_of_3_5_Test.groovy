package pl.braintelligence.katas

import spock.lang.Specification

// Project Euler #1: Multiples of 3 and 5 from HackerRank
class _2_Multiples_of_3_5_Test extends Specification {

    public static final int NATURAL_NUMBER_10 = 10
    public static final int NATURAL_NUMBER_100 = 100

    public static final int SUM_OF_3_5_MULTIPLES_10 = 23
    public static final int SUM_OF_3_5_MULTIPLES_100 = 2318

    def "(java) Should find sum of all multiples for 3, 5"() {
        given:
        def subject = new Java_2_Multiples_of_3_5()

        when: "N=10 we get 3,6,9 and 5"
        def result1 = subject.findSum(NATURAL_NUMBER_10)
        def result2 = subject.findSum(NATURAL_NUMBER_100)

        then: "sum for 3+6+9+5 is 23"
        result1 == SUM_OF_3_5_MULTIPLES_10
        result2 == SUM_OF_3_5_MULTIPLES_100
    }

    def "(kotlin) Should find sum of all multiples for 3, 5"() {
        given:
        def subject = new Kotlin_2_Multiples_of_3_5()

        when: "For NaturalNumber=10 we get 3,6,9 and 5"
        def result11 = subject.findSum1(NATURAL_NUMBER_10)
        def result12 = subject.findSum2(NATURAL_NUMBER_10)
        def result21 = subject.findSum1(NATURAL_NUMBER_100)
        def result22 = subject.findSum2(NATURAL_NUMBER_100)

        then: "sum for NaturalNumber=10 is 23 (3+6+9+5)"
        result11 == SUM_OF_3_5_MULTIPLES_10
        result12 == SUM_OF_3_5_MULTIPLES_10
        result21 == SUM_OF_3_5_MULTIPLES_100
        result22 == SUM_OF_3_5_MULTIPLES_100
    }
}
