package pl.braintelligence.from_java_8_to_java_11;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class _111_java10_ {

    @Test
    @Description("Not obvious var feature")
    void java10() {
        // given:
        var counter = new Object() {
            int count = 0;
        };

        // when:
        counter.count++;

        // then:
        assertThat(counter.count)
                .isEqualTo(1);
    }

}
