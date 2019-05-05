package pl.braintelligence.from_java_8_to_java_11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import java.util.function.Consumer;

public class _Java11_001_YouCanAnnotateLambdas {

    @Test
    @DisplayName("You can put annotations to lambdas!")
    void java11() {
        Consumer<Double> consumer = (@Deprecated var money) -> System.out.println(money);
    }

}
