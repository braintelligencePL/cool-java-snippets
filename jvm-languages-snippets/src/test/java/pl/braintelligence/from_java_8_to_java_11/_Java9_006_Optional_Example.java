package pl.braintelligence.from_java_8_to_java_11;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class _Java9_006_Optional_Example {

    @Test
    void if_else_if_else() {
        // given: default temperature
        var defaultTemperature =
                Optional.of(new Temperature(10.5));

        // when: fetch some external temperature from API, DB... fluently chained calls
        var result =
                getTemperatureFromGoogle()
                        .or(this::getTemperatureFromYourDB)
                        .or(() -> defaultTemperature);

        // then:
        assertThat(result.get().celsiusDegrees)
                .isEqualTo(10.5);

    }

    Optional<Temperature> getTemperatureFromYourDB() {
        return Optional.empty(); // for example call from your database
    }

    Optional<Temperature> getTemperatureFromGoogle() {
        return Optional.ofNullable(null); // for example call from some external API
    }

    class Temperature {
        private Double celsiusDegrees;

        Temperature(Double celsiusDegrees) {
            this.celsiusDegrees = celsiusDegrees;
        }
    }

}
