package pl.braintelligence.from_java_8_to_java_11;

import io.vavr.control.Try;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class _Java9_002_ImmutableCollections {

    @Test
    @DisplayName("Its immutable but you can add something...")
    void standardJavaCollection() {
        // given:
        var list = java.util.List.of(1, 2, 3, 4, 5);

        // when:
        var thrown = Try.of(() ->
                list.add(123)
        );

        // then:
        assertThrows(
                UnsupportedOperationException.class,
                thrown::get
        );

    }


    @Test
    @DisplayName("Once there was Guava now its Vavr!")
    void vavrCollections() {
        // given:
        var list = io.vavr.collection.List.of(1, 2, 3, 4, 5);

        // when:
        list = list.append(123);

        // then:
        assertThat(list.size())
                .isEqualTo(6);

        // when:
        list = list.dropWhile(number -> number < 40);

        // then:
        assertThat(list.size())
                .isEqualTo(1);
    }
}

