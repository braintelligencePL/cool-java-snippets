package pl.braintelligence.java;

import io.vavr.Tuple;
import lombok.val;

public class TupleExample {
    public static void main(String[] args) {

        val tuple = Tuple.of("Something ", 1)
                .map(
                        stringValue -> stringValue.concat("else"),
                        integerValue -> integerValue + 1
                );

        System.out.println(tuple); // (Something else, 2)

    }
}
