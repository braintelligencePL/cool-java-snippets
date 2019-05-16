package pl.braintelligence.functional.standard;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class _Java8_000_Stream {

    @Test
    public void howDoesStreamWorks() {
        // when:
        var fruit = Stream.of("apple")
                .map(a -> "pinapple")
                .map(p -> "orange")
                .map(o -> "bannana")
                .reduce("Fruit: ", String::concat);

        // then:
        assertThat(fruit)
                .isEqualTo("Fruit: bannana");
    }

    @Test
    public void sortStream() {
        // when:
        var result = Stream.of(5, 2, 11, 14, 76)
                .sorted()
                .collect(toList());

        // then:
        assertThat(result)
                .isEqualTo(List.of(2, 5, 11, 14, 76));
    }

    @Test
    public void distinctStream() {
        // when:
        var result = Stream.of(1, 1, 1, 3, 5, 5, 5, 3, 3, 3)
                .distinct()
                .collect(toList());

        // then:
        assertThat(result)
                .isEqualTo(List.of(1, 3, 5));
    }

    @Test
    void matchStream() {
        // when:
        var isMatch = Stream.of(1, 2, 3, 4, 5, 6)
                .anyMatch(value -> value > 5);

        // then:
        assertThat(isMatch)
                .isTrue();
    }

    @Test
    void maxStream() {
        // when:
        var result = Stream.of(500, 1, 2, 3)
                .max(Comparator.comparingInt(i -> i))
                .get();

        // then:
        assertThat(result)
                .isEqualTo(500);
    }
}
