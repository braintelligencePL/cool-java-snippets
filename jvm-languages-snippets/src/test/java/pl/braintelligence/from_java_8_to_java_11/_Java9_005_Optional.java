package pl.braintelligence.from_java_8_to_java_11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class _Java9_005_Optional {

    @Test
    void if_else() {
        // when:
        var optionalValue = Optional.ofNullable("value");

        // then:
        optionalValue.ifPresent(System.out::println); // 'value' is printed

        // and:
        optionalValue.ifPresentOrElse(
                System.out::print,   // 'value' is printed
                () -> System.out.print("Not found") // ...
        );
    }

    @Test
    @DisplayName("Java 9 gave us interoperability between Optionals and Streams.")
    void onlyIntegers() {
        // given:
        var stream = Stream.of(
                Optional.of(1),
                Optional.of(2),
                Optional.of("abc"),
                Optional.empty()
        );

        // when:
        var result = stream
                .flatMap(Optional::stream)
                .filter(Integer.class::isInstance)
                .collect(Collectors.toList());

        // then:
        assertThat(result)
                .isEqualTo(List.of(1, 2));
    }
}
