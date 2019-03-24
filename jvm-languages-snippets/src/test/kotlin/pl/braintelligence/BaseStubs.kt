package pl.braintelligence

import com.github.tomakehurst.wiremock.client.WireMock.*
import org.springframework.http.HttpStatus

interface BaseStubs {

    fun stubGivenHttpStatusCode(httpStatus: HttpStatus) {
        givenThat(get(urlEqualTo("/hello"))
                .willReturn(aResponse()
                        .withStatus(httpStatus.value())
                ))
    }
}
