package pl.braintelligence.functional_kotlin.arrow

import arrow.core.Try
import arrow.core.getOrElse
import arrow.core.orElse
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import pl.braintelligence.base.BaseIntegrationTest
import pl.braintelligence.base.BaseStubs
import java.net.URL

data class Article(val name: String, val content: String)

open class TryExample : BaseIntegrationTest(), BaseStubs {

    @Test
    fun `create new URL or return default URL`() {
        // given: invalid URL
        val result = Try { URL("BLAAH//hHttp://braintelligence.pl") }
                .map { it.host }
                .getOrElse { "google.pl" }

        assertThat(result)
                .isEqualTo("google.pl")
    }

    @Test
    fun `search for the articles`() {
        val result = fetchArticlesFromFacebook()
                .orElse { fetchArticlesFromGoogle() }
                .getOrElse { emptyList() }
                .filterNot { it.name.contains("123") }
                .map { it.name }

        assertThat(result)
                .isEqualTo(listOf("firstname"))
    }

    private fun fetchArticlesFromFacebook() = Try {
        throw NoSuchElementException()
    }

    private fun fetchArticlesFromGoogle() = Try {
        listOf(
                Article("firstname", "content"),
                Article("123", "content")
        )
    }
}
