import io.vavr.Tuple;

public class TupleExample {
    public static void main(String[] args) {

        var tuple = Tuple.of("Something ", 1)
                .map(
                        stringValue -> stringValue.concat("else"),
                        integerValue -> integerValue + 1
                );

        System.out.println(tuple); // (Something else, 2)

    }
}
