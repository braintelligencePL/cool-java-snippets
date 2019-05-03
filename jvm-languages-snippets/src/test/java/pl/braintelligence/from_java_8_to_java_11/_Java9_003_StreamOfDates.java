package pl.braintelligence.from_java_8_to_java_11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class _Java9_003_StreamOfDates {

    @Test
    @DisplayName("Get X days")
    void streamAndDate_Java8() {
        // given:
        var startingDay = LocalDate.now();
        var days = 10;

        // when: "more abstract"
        var result = Stream.iterate(startingDay, date -> date.plusDays(1))
                .limit(days)
                .collect(toList());

        // then:
        assertThat(result.size())
                .isEqualTo(10);
    }

    @Test
    @DisplayName("List/Stream of days")
    void streamAndDate_Java9() {
        // given:
        var startingDay = LocalDate.now();
        var endingDay = LocalDate.now().plusDays(10);

        // when: "more descriptive"
        var result = startingDay
                .datesUntil(endingDay)
                .collect(toList());

        // then:
        assertThat(result.size())
                .isEqualTo(10);
    }
}
