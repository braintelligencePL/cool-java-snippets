package pl.braintelligence.from_java_8_to_java_11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class _Java9_004_StreamImprovements {

    @Test
    void takeWhile() {
        // given:
        var abc = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i");

        // when:
        var result = abc.stream()
                .takeWhile(it -> !it.equals("c"))
                .collect(toList());

        // then:
        assertThat(result)
                .contains("a", "b");
    }

    @Test
    void dropWhile() {
        // given:
        var abc = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i");

        // when:
        var result = abc.stream()
                .dropWhile(it -> !it.equals("c"))
                .collect(toList());

        // then:
        assertThat(result)
                .contains("c", "d", "e", "f", "g", "h", "i");
    }


    @Test
    @DisplayName("iterate from java 8")
    void iterateFromJava8() {
        // when: iterate(final T seed, final UnaryOperator f)
        var numbers = Stream.iterate(1, i -> i + 1)
                .limit(10)
                .collect(toList());

        // then:
        assertThat(numbers)
                .contains(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    @Test
    @DisplayName("iterate from java 9")
    void iterateFromJava9() {
        // when: iterate(T seed, Predicate hasNext, UnaryOperator next)
        var numbers = Stream.iterate(1, limit(10), i -> i + 1)
                .collect(toList());

        // then:
        assertThat(numbers)
                .contains(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    private Predicate<Integer> limit(int number) {
        return i -> i <= number;
    }

    @Test
    void StreamOfNullable() {
        // given:
        var stream = Stream.ofNullable(null);

        // when:
        var result = stream.count();

        // then:
        assertThat(result)
                .isEqualTo(0);
    }
}
