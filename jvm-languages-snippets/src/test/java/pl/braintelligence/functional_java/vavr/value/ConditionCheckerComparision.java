package pl.braintelligence.functional_java.vavr.value;

import io.vavr.control.Option;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ConditionCheckerComparision {

    private String valueToCheck = "AqwertyZ";

    @Test
    void optionExample_normalIfElseCheck() {
        // given:
        String result;

        // when: normal if-else check
        if (valueToCheck != null && valueToCheck.startsWith("A") && valueToCheck.endsWith("Z")) {
            result = "YEYY!!";
        } else {
            result = "ELSE";
        }

        //then:
        assertThat(result)
                .isEqualTo("YEYY!!");
    }

    @Test
    void optionExample_vavrNullCheck() {
        // when: vavr if-else
        val result = Option.of(valueToCheck)
                .filter(startsWith("A"))
                .filter(startsWith("Z"))
                .map(ignore -> "YEYY!!")
                .getOrElse("ELSE");

        // then:
        assertThat(result)
                .isEqualTo("YEYY!!");
    }

    @NotNull
    private Predicate<String> startsWith(String a) {
        return given -> given.startsWith("A");
    }
}
