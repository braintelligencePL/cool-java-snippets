package pl.braintelligence;

import java.util.Optional;

public class E02_NoNullSafety {
    public static void main(String[] args) {

        String name = null;

        if (name != null) {
            System.out.println(name.length());
        }

        var optional = Optional.ofNullable(name);

        optional.ifPresentOrElse(
                item -> System.out.println(item),
                item -> ""
        );

    }
}
