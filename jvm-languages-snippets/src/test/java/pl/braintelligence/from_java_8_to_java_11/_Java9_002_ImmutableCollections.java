package pl.braintelligence.from_java_8_to_java_11;

import io.vavr.control.Try;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class _Java9_002_ImmutableCollections {

    @Test
    public void standardJava8() {
        // given:
        List<String> names = new ArrayList<>();
            names.add("John");
            names.add("George");
            names.add("Betty");

        var list = Collections.unmodifiableList(names);

        // when:
        var thrown = Try.of(() ->
                list.add("Jack")
        );

        // then:
        assertThrows(
                UnsupportedOperationException.class,
                thrown::get
        );

    }

    @Test
    @DisplayName("Its immutable but you can use add method...")
    void standardJava9Collection() {
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

