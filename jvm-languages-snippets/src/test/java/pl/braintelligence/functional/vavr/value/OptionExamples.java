package pl.braintelligence.functional.vavr.value;

import io.vavr.collection.List;
import io.vavr.control.Option;
import lombok.val;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OptionExamples {

    @Test
    void optionExample() {
        // given:
        val result = Option.of(null)
                .map(Object::toString)
                .map(String::toLowerCase)
                .getOrElse(() -> "option default");

        // expect:
        assertThat(result)
                .isEqualTo("option default");
    }

}
