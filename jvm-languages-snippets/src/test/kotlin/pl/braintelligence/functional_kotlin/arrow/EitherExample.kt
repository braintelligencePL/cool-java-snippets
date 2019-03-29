package pl.braintelligence.functional_kotlin.arrow

import arrow.core.Either
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import pl.braintelligence.BaseIntegrationTest
import pl.braintelligence.BaseStubs

open class EitherExample : BaseIntegrationTest(), BaseStubs {

    @Test
    fun `Parse a string with regex`() {
        val result = eitherParse("12a3")
                .map { it + 3 }
                .mapLeft { it.message }


        assertThat(result)
                .isEqualTo(126)
    }

    fun eitherParse(str: String) = when (isNumber(str)) {
        true -> Either.Right(str.toInt())
        false -> Either.Left(NumberFormatException("$str is not a valid integer."))
    }


    fun classyParse(str: String): Int = when (isNumber(str)) {
        true -> str.toInt()
        false -> throw NumberFormatException("$str is not a valid integer.")
    }

    private fun isNumber(str: String) = str.matches(Regex("-?[0-9]+"))

}

