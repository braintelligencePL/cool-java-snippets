package pl.braintelligence.java;

import io.vavr.collection.List;
import io.vavr.collection.Seq;
import io.vavr.collection.Stream;
import io.vavr.control.Option;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.lang3.RandomStringUtils;
import pl.braintelligence.java.domain.user.User;

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
class ConditionChecker {
    public static void main(String[] args) {

        // Classical if/else for null
        log.info(
                nullCheck(null)
        );

        // Better if/else with Option
        log.info(
                vavrNullCheck(null)
        );

        // More verbose example for conditions
        log.info(
                normalConditionChecker("qwerty")
        );

        // Functional condition check
        log.info(
                vavrConditionChecker("AqwertyZ")
        );


    }

    private static String nullCheck(String value) {
        if (value != null) {
            return value.toUpperCase();
        }
        return value;
    }

    private static String vavrNullCheck(String value) {
        return Option.of(value)
                .map(String::toLowerCase) // executed only when Option is some()
                .getOrElse("DEFAULT");
    }


    private static String normalConditionChecker(String value) {
        if (value != null && value.startsWith("A") && value.endsWith("Z")) {
            return "YEYY!!";
        } else {
            return "ELSE";
        }
    }

    private static String vavrConditionChecker(String value) {
        return Option.of(value)
                .filter(given -> given.startsWith("A"))
                .filter(given -> given.endsWith("Z"))
                .map(ignore -> "YEYY!!")
                .getOrElse("ELSE");
    }
}

@Slf4j
class ValidationCheck {
    public static void main(String[] args) {

        // Dont try that at home
        try {
            User.legacyAccountNumberCheck(RandomStringUtils.randomAlphanumeric(23));
        } catch (IllegalArgumentException ex) {
            log.error(ex.getMessage());
        }

        // Make that instead
        System.out.println(
                lift(User::legacyAccountNumberCheck)
                        .apply(RandomStringUtils.randomAlphanumeric(28))
                        .getOrElse("DEFAULT")
        );
    }
}

