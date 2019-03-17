package pl.braintelligence.java.katas

import spock.lang.Specification

// Sock Merchant - from HackerRank
class _1_SocketsPairsTest extends Specification {

    public static final int NUMBER_OF_PAIRS = 4
    public static final int[] LIST_OF_SOCKS_COLORS = [1, 1, 3, 1, 2, 1, 3, 3, 3, 3]
    // each number represents a color (doesn't matter what color it is)
    // e.g. Pair = 9,9

    def "(java) Should count number of pairs"() {
        given:
        def subject = new Java_1_SocketsPairs()

        when: "count all possible socks pairs of each color"
        def numberOfPairsLongVersion = subject.countNumberOfPairsLongVersion(LIST_OF_SOCKS_COLORS)
        def numberOfPairsShortVersion = subject.countNumberOfPairsShortVersion(LIST_OF_SOCKS_COLORS)

        then:
        numberOfPairsLongVersion == NUMBER_OF_PAIRS
        numberOfPairsShortVersion == NUMBER_OF_PAIRS
    }

    def "(kotlin) Should count number of pairs"() {
        given:
        def subject = new Kotlin_1_SocketsPairs()

        when: "count all possible socks pairs of each color"
        def numberOfPairsLongVersion = subject.countNumberOfPairsLongVersion(LIST_OF_SOCKS_COLORS)
        def numberOfPairsShortVersion = subject.countNumberOfPairsShortVersion(LIST_OF_SOCKS_COLORS)

        then:
        numberOfPairsLongVersion == NUMBER_OF_PAIRS
        numberOfPairsShortVersion == NUMBER_OF_PAIRS
    }
}
