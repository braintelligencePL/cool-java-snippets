package pl.braintelligence.functional.vavr.value;

import io.vavr.collection.List;
import io.vavr.control.Try;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.braintelligence.functional_kotlin.arrow.Article;

import java.net.URL;
import java.util.NoSuchElementException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class TryExample {

    @Test
    void tryExample_createURL() {
        // given: some invalid url
        val result = Try.of(() -> new URL("BLAAH//hHttp://braintelligence.pl"))
                .map(URL::getHost)
                .getOrElse(() -> "google.pl");

        // expect: default url
        assertThat(result)
                .isEqualTo("google.pl");
    }

    @Test
    @DisplayName("Should fail when divided by zero")
    void tryExample_division() {
        // when: divided by zero
        Throwable thrown = catchThrowable(() ->
                divide(1, 0)
                        .onFailure(ex -> System.out.println("Not a number"))
                        .onSuccess(System.out::println)
                        .get()
        );

        // then: throws ArithmeticException
        assertThat(thrown)
                .isInstanceOf(ArithmeticException.class);
    }

    @Test
    void tryExample_searchForArticles() {
        // when:
        val result = fetchArticlesFromFacebook()
                .orElse(this::fetchArticlesFromGoogle)
                .getOrElse(List::empty)
                .filter(name -> !name.getName().contains("123"))
                .map(Article::getName);

        // expect: correctly fetched article
        assertThat(result)
                .isEqualTo(List.of("firstname"));
    }

    private Try<List<Article>> fetchArticlesFromGoogle() {
        return Try.of(() -> List.of(
                new Article("123", "content"),
                new Article("firstname", "content"))
        );
    }

    private Try<List<Article>> fetchArticlesFromFacebook() {
        return Try.of(() -> {
            throw new NoSuchElementException();
        });
    }

    private Try<Integer> divide(Integer dividend, Integer divisor) {
        return Try.of(() -> dividend / divisor);
    }
}

