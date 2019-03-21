package pl.braintelligence.functional_java.vavr;

import io.vavr.Function0;

import java.util.UUID;

public class
Memoization {
    public static void main(String[] args) {
        Function0<UUID> memoizedRandomUUID = Function0.of(UUID::randomUUID).memoized();

        System.out.println(memoizedRandomUUID.apply()); // 80cc9c17...
        System.out.println(memoizedRandomUUID.apply()); // 80cc9c17...
    }
}
