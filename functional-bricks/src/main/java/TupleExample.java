import io.vavr.Tuple;

public class TupleExample {
    public static void main(String[] args) {

        var tuple = Tuple.of("Something ", 1)
                .map(
                        s -> s.concat("else"),
                        i -> i + 1
                );

        System.out.println(tuple); // (Something else, 2)

    }
}
