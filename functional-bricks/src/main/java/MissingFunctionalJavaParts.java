import io.vavr.collection.List;
import io.vavr.collection.Seq;
import io.vavr.collection.Stream;
import io.vavr.control.Option;
import lombok.val;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MissingFunctionalJavaParts {

    public static void main(String[] args) {


        // iterating with index
        System.out.println(
                vavrZippingWithIndex("One", "Two")
        );


        // iterating is less verbose
        Stream.of(1, 2, 3, 4)
                .map(i -> i + 1)
                .peek(System.out::println);


        // legacy flatMap
        val legacyWay = legacyFlatMap(java.util.List.of(
                Optional.of("One"),
                Optional.of("Two")
        ));

        System.out.println(legacyWay);

        // vavr flatMap
        val vavrWay = vavrFlatMap(List.of(
                Option.of("One"),
                Option.of("One")
        ));

    }

    private static Seq<String> vavrZippingWithIndex(String... args) {
        return List
                .of(args)
                .zipWithIndex((arg, index) -> index + ". " + arg);
    }


    private static java.util.List<String> legacyFlatMap(java.util.List<Optional<String>> args) {
        return args
                .stream()
                .flatMap(Optional::stream) // since Java 9
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    private static Seq vavrFlatMap(Seq<Option<String>> args) {
        return args
                .flatMap(Function.identity()) // same as flatMap(arg -> arg)
                .map(String::toLowerCase);
    }
}
