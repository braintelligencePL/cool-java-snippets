package pl.braintelligence.from_java_8_to_java_11;

import org.junit.jupiter.api.Test;

public class _Java11_000_StringsHelpers {

    @Test
    void stringsHelpers() {

        " ".isBlank();                // true
        " Foo Bar ".strip();          // "Foo Bar"
        " Foo Bar ".stripTrailing();  // " Foo Bar"
        " Foo Bar ".stripLeading();   // "Foo Bar "
        "Java".repeat(3);             // "JavaJavaJava"
        "A\nB\nC".lines().count();    // 3

    }

}
