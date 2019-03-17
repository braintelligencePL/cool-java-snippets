package pl.braintelligence.java;

import io.vavr.collection.List;
import io.vavr.collection.Seq;
import io.vavr.control.Option;
import io.vavr.control.Try;
import lombok.val;
import org.springframework.data.util.Lazy;

import java.net.URL;
import java.util.UUID;

public class ValueExample {
    public static void main(String[] args) {

        // Option
        val result1 = Option.of(null)
                .map(Object::toString)
                .map(String::toLowerCase)
                .getOrElse(() -> "option default");

        System.out.println(result1); // option default


        // Try
        val result2 = Try.of(() -> new URL("BLAAH//hHttp://braintelligence.pl"))
                .map(URL::getHost)
                .getOrElse(() -> "google.pl");

        System.out.println(result2); // google.pl


        // Lazy (is memoized and its referentially transparent)
        val result3 = Lazy.of(UUID.randomUUID())
                .map(Object::toString)
                .map(String::toUpperCase);

        System.out.println(result3.get());

    }
}

class AnotherTryExample {
    public static void main(String[] args) {
        divide(1, 0)
                .onFailure(e -> System.out.println("Not a number"))
                .onSuccess(System.out::println);
    }

    static Try<Integer> divide(Integer dividend, Integer divisor) {
        return Try.of(() -> dividend / divisor);
    }
}


