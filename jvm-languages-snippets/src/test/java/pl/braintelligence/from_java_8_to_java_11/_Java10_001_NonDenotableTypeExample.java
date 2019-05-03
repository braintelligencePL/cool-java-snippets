package pl.braintelligence.from_java_8_to_java_11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class _Java10_001_NonDenotableTypeExample {

    @Test
    @DisplayName("non denotable types ( types that cannot be inferred to known type) ")
    void creatingInnerClass() {
        // given:
        var map = new HashMap<>() { // anonymous class
            int someVar;
        };

        // and: Object$1 extends Object
        var subject = new Object() {
        };

//        subject = new Object();
    }

    @Test
    void nonDenotableType() {

        // given: POJO can be assigned to a variable and can hold some context
        var person = new Object() {

            class Name {
                String firstName;
                String lastName;

                Name(String firstName, String lastName) {
                    super();
                    this.firstName = firstName;
                    this.lastName = lastName;
                }
            }
        };

        // when: maybe useful when objects are dynamically created? Some temporary context?
        var strangeStructure = person.new Name("Rick", "qwerty");

        // then:
        assertThat(strangeStructure.firstName)
                .isEqualTo("Rick");

    }


}
