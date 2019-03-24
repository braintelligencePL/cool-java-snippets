package pl.braintelligence.functional_java.vavr.matching_pattern;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import io.vavr.collection.HashMap;
import io.vavr.control.Try;
import lombok.val;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.vavr.API.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MatchingPatternExamples {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089);

    private HttpClient httpClient = HttpClient.newBuilder().build();

    private HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:8089/hello"))
            .GET()
            .build();

    @Test
    public void shouldHandleStatusCodeInAClassicalWay() {
        // given: stubbed server status code response
        stubHttpCodeAsResponseFromSomeExternalServer(HttpStatus.I_AM_A_TEAPOT);

        // and: http request performed
        val response = performRequestForStatusCode();

        // then: response code resolved to some comment
        val commentOnStatusCode = matchStatusCodeInClassicalWay(response.statusCode());

        assertThat(commentOnStatusCode)
                .isEqualTo("wtf?");
    }

    @Test
    public void shouldHandleStatusCodeInAVavrWay() {
        // given: stubbed server status code response
        stubHttpCodeAsResponseFromSomeExternalServer(HttpStatus.I_AM_A_TEAPOT);

        // and: http request performed
        val response = performRequestForStatusCode();

        // when: response code resolved to some comment
        val commentOnStatusCode = matchStatusCodeWithVavr(response.statusCode());

        // then: check that comment on status code was returned
        assertThat(commentOnStatusCode)
                .isEqualTo("wtf?");
    }

    private String matchStatusCodeInClassicalWay(int httpStatus) {

        if (httpStatus == HttpStatus.OK.value()) {
            return "all fine";
        } else if (httpStatus == HttpStatus.NOT_FOUND.value()) {
            return "nothing here";
        } else if (httpStatus == HttpStatus.I_AM_A_TEAPOT.value()) {
            return "wtf?";
        }
        return "DEFAULT";
    }

    private String matchStatusCodeWithVavr(int httpStatus) {
        return Match(httpStatus).of(
                Case($(HttpStatus.OK.value()), "all fine"),
                Case($(HttpStatus.NOT_FOUND.value()), "nothing here"),
                Case($(HttpStatus.I_AM_A_TEAPOT.value()), "wtf?"),
                Case($(), "DEFAULT")
        );
    }

    private HttpResponse performRequestForStatusCode() {
        return Try.of(() ->
                httpClient.send(request, HttpResponse.BodyHandlers.ofString())
        ).get();

    }

    private void stubHttpCodeAsResponseFromSomeExternalServer(HttpStatus httpStatus) {
        stubFor(get(urlEqualTo("/hello"))
                .willReturn(aResponse()
                        .withStatus(httpStatus.value())
                ));
    }
}
