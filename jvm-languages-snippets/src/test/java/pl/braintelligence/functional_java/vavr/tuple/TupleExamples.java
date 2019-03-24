package pl.braintelligence.functional_java.vavr.tuple;

import io.vavr.Tuple;
import lombok.val;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TupleExamples {

    @Test
    void tupleExample() {
        // given:
        val tuple = Tuple.of("Something ", 1);

        // when:
        val result = tuple.map(
                stringValue -> stringValue.concat("else"),
                integerValue -> integerValue + 1
        );

        // then:
        assertThat(result)
                .isEqualTo(Tuple.of("Something else", 2));
    }

}
