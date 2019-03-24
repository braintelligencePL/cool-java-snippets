package pl.braintelligence.functional_java.vavr.value;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;
import org.springframework.data.util.Lazy;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LazyExamples {

    @Test
    @Description("Lazy is memoized and its referentially transparent")
    void lazyExample() {
        // given:
        val result = Lazy.of(UUID.randomUUID())
                .map(Object::toString)
                .map(String::toUpperCase);

        // when:
        val firstCallUUID = result.get();  // 52EA7812
        val secondCallUUID = result.get(); // 52EA7812

        // then:
        assertThat(secondCallUUID)
                .isEqualTo(firstCallUUID);
    }

}
