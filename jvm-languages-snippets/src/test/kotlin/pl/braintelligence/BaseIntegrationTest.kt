package pl.braintelligence

import com.github.tomakehurst.wiremock.junit.WireMockRule
import org.junit.Rule
import java.net.http.HttpClient

open class BaseIntegrationTest {

    private val port = 8089

    @Rule
    @JvmField
    val wireMockRule = WireMockRule(port)

    val httpClient = HttpClient.newBuilder().build()

    fun localUrl(url: String) = "http://localhost:$port".plus(url)

}
