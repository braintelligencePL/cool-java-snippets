package pl.braintelligence.functional.standard;

import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class _Java8_001_Functions {

    @Test
    public void mapStream() {
        String words = Stream.of("hello_functional_world")
                .map(replaceWordsFunction())
                .map(String::toUpperCase)
                .reduce("", String::concat);

        assertThat(words)
                .isEqualTo("HELLO FUNCTIONAL WORLD");
    }

    private Function<String, String> replaceWordsFunction() {
        return string -> string.replace("_", " ");
    }


}
