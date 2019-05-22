package pl.braintelligence.reactive.Reactor

import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import reactor.core.publisher.Flux
import java.lang.invoke.MethodHandles
import java.time.Duration
import java.util.concurrent.TimeUnit

class Part002_MergeExample {

    @Test
    fun `Should merge different flux streams`() {
        // given:
        val slow = Flux.interval(Duration.ofMillis(200))
                .map { "$it <- slow" }

        val fast = Flux.interval(Duration.ofMillis(100))
                .map { "$it <- fast" }

        // when:
        val subject = Flux.merge(slow, fast)

        // then:
        subject.subscribe { logger.info(it) }
        TimeUnit.SECONDS.sleep(2)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass())
    }
}
