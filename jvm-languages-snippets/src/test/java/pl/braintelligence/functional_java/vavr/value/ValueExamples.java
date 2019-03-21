package pl.braintelligence.functional_java.vavr.value;

import io.vavr.control.Option;
import io.vavr.control.Try;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;
import org.springframework.data.util.Lazy;

import java.net.URL;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class ValueExamples {

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

    @Test
    void tryExample_createURL() {
        // given:
        val result = Try.of(() -> new URL("BLAAH//hHttp://braintelligence.pl"))
                .map(URL::getHost)
                .getOrElse(() -> "google.pl");

        // expect:
        assertThat(result)
                .isEqualTo("google.pl");
    }

    @Test
    @DisplayName("Should fail when divided by zero")
    void tryExample_division() {
        // when: divided by zero throw ArithmeticException
        Throwable thrown = catchThrowable(() ->
                divide(1, 0)
                        .onFailure(ex -> System.out.println("Not a number"))
                        .onSuccess(System.out::println)
                        .get()
        );

        // then: verify ArithmeticException
        assertThat(thrown)
                .isInstanceOf(ArithmeticException.class);
    }


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

    Try<Integer> divide(Integer dividend, Integer divisor) {
        return Try.of(() -> dividend / divisor);
    }
}
