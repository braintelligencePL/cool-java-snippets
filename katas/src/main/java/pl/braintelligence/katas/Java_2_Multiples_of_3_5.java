package pl.braintelligence.katas;

import java.util.stream.IntStream;

public class Java_2_Multiples_of_3_5 {

    public int findSum(int naturalNumber) {
        return IntStream.range(3, naturalNumber)
                .filter(step -> step % 3 == 0 || step % 5 == 0)
                .sum();
    }

}

