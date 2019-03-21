package pl.braintelligence.functional_kotlin

import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.junit.WireMockRule
import org.junit.Rule
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus

class MatchingPattern {

    @Rule
    private val wireMockRule = WireMockRule(8089)

    @Test
    internal fun shouldHandleStatusCodeInAProperWay() {
        stubHttpStatusCodeResponseFromSomeServer(HttpStatus.I_AM_A_TEAPOT)



    }

    private fun stubHttpStatusCodeResponseFromSomeServer(httpStatus: HttpStatus) {
        stubFor(get(urlEqualTo("/hello"))
                .willReturn(aResponse()
                        .withStatus(httpStatus.value())
                ))
    }
}
