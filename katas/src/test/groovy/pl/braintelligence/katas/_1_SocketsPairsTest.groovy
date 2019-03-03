package pl.braintelligence.katas

import spock.lang.Specification

// Sock Merchant - from Hackerrank
class _1_SocketsPairsTest extends Specification {

    public static final int NUMBER_OF_PAIRS = 4
    public static final int[] LIST_OF_SOCKS_COLORS = [1, 1, 3, 1, 2, 1, 3, 3, 3, 3]

    def "Should count number of pairs (test for java)"() {
        given:
        def socketPairs = new Java_1_SocketsPairs()

        when: "count all pairs"
        def result = socketPairs.countNumberOfPairs(LIST_OF_SOCKS_COLORS)

        then:
        result == NUMBER_OF_PAIRS
    }

    def "Should count number of pairs (test for kotlin)"() {
        given:
        def socketPairs = new Kotlin_1_SocketsPairs()

        when:
        def result = socketPairs.countNumberOfPairs(LIST_OF_SOCKS_COLORS)

        then:
        result == NUMBER_OF_PAIRS
    }
}