package pl.braintelligence.from_java_8_to_java_11;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class _JavaXX_000_WaysToHandleNullsInList {

    @Test
    void checkNull_1() {
        // given:
        var list = Arrays.asList("111", null, null, null);

        // when:
        var result = list.stream()
                .filter(Objects::nonNull)
                .collect(toList());

        // then:
        assertThat(result.size())
                .isEqualTo(1);
    }

    @Test
    void checkNull_2() {
        // given:
        var list = new ArrayList<>(
                Arrays.asList("111", null, null, null)
        );

        // when:
        list.removeIf(Objects::isNull);

        // then:
        assertThat(list.size())
                .isEqualTo(1);
    }


}
