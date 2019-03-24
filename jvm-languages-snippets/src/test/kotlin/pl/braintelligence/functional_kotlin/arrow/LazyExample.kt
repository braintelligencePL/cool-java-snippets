package pl.braintelligence.functional_kotlin.arrow

import arrow.core.Eval
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*

class LazyExample {

    @Test
    internal fun lazyExample() {
        // given:
        val result = Eval.later { UUID.randomUUID() }
                .value.toString().toUpperCase()

        // when:
        val firstCallUUID = result  // 52EA7812
        val secondCallUUID = result // 52EA7812


        // then:
        assertThat(firstCallUUID)
                .isEqualTo(secondCallUUID)
    }
}
