package pl.braintelligence.functional_java.vavr;

import io.vavr.collection.List;
import io.vavr.collection.Seq;
import io.vavr.collection.Stream;
import io.vavr.control.Option;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.lang3.RandomStringUtils;
import pl.braintelligence.functional_java.vavr.domain.user.User;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static io.vavr.CheckedFunction1.lift;


public class BetterJavaWithVavr {
}

class Iterating {
    public static void main(String[] args) {

        // iterating with index
        System.out.println(
                vavrZippingWithIndex("One", "Two")
        );

        // iterating is less verbose
        Stream.of(1, 2, 3, 4, 5)
                .map(i -> i + 5)
                .peek(System.out::println);

    }

    private static Seq<String> vavrZippingWithIndex(String... args) {
        return List
                .of(args)
                .zipWithIndex((arg, index) -> index + ". " + arg);
    }
}

class FlatMapping {
    public static void main(String[] args) {

        // legacy flatMap
        val legacyWay = legacyFlatMap(java.util.List.of(
                Optional.of("One"),
                Optional.of("One")
        )).stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(legacyWay);

        // vavr flatMap
        val vavrWay = vavrFlatMap(List.of(
                Option.of("One"),
                Option.of("One")
        )).distinct();
        System.out.println(vavrWay.distinct());

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

@Slf4j
class Lifting {
    public static void main(String[] args) {

        // classic try-catch
        try {
            User.findUserInfoByAccountNumber(RandomStringUtils.randomAlphanumeric(22));
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        System.out.println(
                lift(User::findUserInfoByAccountNumber)
                        .apply(RandomStringUtils.randomAlphanumeric(22))
                        .getOrElse(Collections.singletonList("DEFAULT"))
        );

        Try.of(() -> User.findUserInfoByAccountNumber("123"))
                .onSuccess(System.out::println);
    }

}
