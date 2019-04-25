package pl.braintelligence.from_java_8_to_java_11;

import java.util.List;
import java.util.function.Predicate;

interface _000_Java9_InterfacePrivateMethods {

    default int sumEvenNumbers(List<Integer> numbers) {
        return sum(this::isEven, numbers);
    }

    private int sum(Predicate<Integer> predicate, List<Integer> numbers) {
        return numbers.stream()
                .filter(predicate)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private boolean isEven(int value) {
        return value % 2 == 0;
    }

}
