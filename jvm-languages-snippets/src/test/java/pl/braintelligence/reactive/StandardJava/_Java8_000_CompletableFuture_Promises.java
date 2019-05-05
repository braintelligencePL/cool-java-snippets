package pl.braintelligence.reactive.StandardJava;

import io.vavr.control.Either;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class _Java8_000_CompletableFuture_Promises {

    @Test
    void streamEnchanced() {
        // given:

        // when:

        // then:
    }

    @Test
    public void supplyAsync() throws InterruptedException {
        CompletableFuture<Either<Integer, String>> completableFuture = CompletableFuture.supplyAsync(this::getValue);
        completableFuture.whenComplete((result, throwable) -> System.out.println(result.right().get()));
        Thread.sleep(2000);
    }

    public Either<Integer, String> getValue() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Either.right(UUID.randomUUID().toString());
    }
}
