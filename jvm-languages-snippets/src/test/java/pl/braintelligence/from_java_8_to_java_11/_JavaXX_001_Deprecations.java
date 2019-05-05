package pl.braintelligence.from_java_8_to_java_11;

import io.vavr.control.Try;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.script.ScriptEngineManager;

public class _JavaXX_001_Deprecations {

    @Test
    @DisplayName("Removals from Java 10")
    void java10_removals() {

        /**
         *
         *  java.security.acl >> java.security
         *  java.security.{Certificate, Identity, IdentityScope, Singer}
         *
         */
    }

    @Test
    @DisplayName("Removals from Java 10")
    void java11_removals() {

        /**
         * ThreadPoolExecutor
         * Nashorn JS engine
         */

        var scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");

        Try.of(() ->
                scriptEngine.eval("print('hello from JS world!')")
        );

    }

}
