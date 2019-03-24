package pl.braintelligence.functional_java.vavr.other;

import io.vavr.collection.HashMap;
import lombok.val;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OtherExamples {

    @Test
    public void simpleHashMap() {
        // given: functional sugar to instantiate HashMap and do some computations on it
        val things = HashMap.of(
                "qwe", "cAt",
                "a", "WHAs",
                "rty", "DOg"
        ).bimap(
                String::toUpperCase,
                String::toLowerCase
        );

        // expect:
        val result = things.get("QWE").getOrElse("");

        assertThat(result)
                .isEqualTo("cat");
    }

}
