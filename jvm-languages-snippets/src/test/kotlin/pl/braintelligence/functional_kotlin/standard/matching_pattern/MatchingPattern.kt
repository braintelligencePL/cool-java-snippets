package pl.braintelligence.functional_kotlin.standard.matching_pattern

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.Test
import org.springframework.http.HttpStatus
import pl.braintelligence.base.BaseIntegrationTest
import pl.braintelligence.base.BaseStubs
import java.net.URI
import java.net.http.HttpRequest
import java.net.http.HttpResponse


class MatchingPattern : BaseIntegrationTest(), BaseStubs {

    @Test
    fun `Matching pattern using when()`() {
        // given: stubbed HttpStatus response
        stubGivenHttpStatusCode(HttpStatus.I_AM_A_TEAPOT)

        // and: request prepared
        val request = HttpRequest.newBuilder()
                .uri(URI.create(localUrl("/hello")))
                .GET()
                .build()

        // when: request performed
        val response = httpClient.send(request, HttpResponse.BodyHandlers.ofString())

        // then: httpStatus is changed to comment
        val httpStatus = HttpStatus.valueOf(response.statusCode())
        assertThat(createCommentOnStatusCode(httpStatus))
                .isEqualTo("wtf?")
    }

    private fun createCommentOnStatusCode(statusCode: HttpStatus) = when (statusCode) {
        HttpStatus.OK -> "all fine"
        HttpStatus.NOT_FOUND -> "nothing here"
        HttpStatus.I_AM_A_TEAPOT -> "wtf?"
        else -> "DEFAULT"
    }
}
