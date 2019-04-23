package pl.braintelligence.katas

import spock.lang.Specification

class _4_KMostFrequentElementsTest extends Specification {

    def "(kotlin) Should give me most frequent element"() {
        given: "array of numbers"
        def subject = new Kotlin_4_KMostFrequentElements()
        def numbers = [4, 1, 4, 4, 2, 3, 4, 5, 4, 4, 3, 4, 4, 5, 6, 7, 4, 4, 4]

        expect: "most frequent is 4"
        subject.kMostFreqElements(numbers) == 4
    }
}
