package pl.braintelligence.from_java_8_to_java_11;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class _Java9_001_NewHttpClient {

    @Test
    void http() throws IOException, InterruptedException {
        // given:
        var googleURI = URI.create("https://google.pl");

        // and:
        var httpClient = HttpClient.newBuilder()
//                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();

        // and:
        var httpRequest = HttpRequest.newBuilder()
                .uri(googleURI)
                .GET()
                .build();

        // when:
        var httpResponse = httpClient.send(
                httpRequest,
                HttpResponse.BodyHandlers.ofString()
        );

        // then:
        assertThat(httpResponse.statusCode())
                .isBetween(200, 299);
    }
}

