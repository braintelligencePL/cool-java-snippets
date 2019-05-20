package pl.braintelligence.from_java_8_to_java_11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class _Java10_000_var {

    @Test
    void cannotInferType() {
//        var x = "";
//        var nothing = null;
//        var lambda = () -> System.out.println("nope");
//        var method = this::someMethod;
    }

    @Test
    @DisplayName("Lambdas must have an explicit target type")
    void canInferType() {
        var arr1 = new ArrayList<>(); // <Object>
        var arr2 = new ArrayList<String>(); // <String>
    }

    @Test
    @DisplayName("inferring types example")
    void canInferTypeMap() {
        // given:
        var map = new HashMap<>(); // <Object, Object>

        // when:
        map.put("key", "value");

        // then: Object != String
        String key = (String) map.get("key");
    }

    @Test
    @DisplayName("var is reserved type firstname NOT a keyword")
    void varIsTypeName() {
        // when:
        var var = "123";

        // then:
        assertThat(var)
                .isEqualTo("123");
    }

    @Test
    void whatVarAllowed() {
        // given: Object$1 extends Object
        var subject = new Object() {
            int count = 0;
        };

        // when: maybe useful for testing?
        subject.count++;

        // then:
        assertThat(subject.count)
                .isEqualTo(1);
    }
}
