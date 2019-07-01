package pl.braintelligence;

import java.util.List;
import java.util.stream.Collectors;

public class E03_InstanceOf {
    public static void main(String[] args) {

        // Instance of - String
        String str = "abc";

        if (str instanceof String) {
            final String result = ((String) str).substring(1);
            System.out.println(result); // bc
        }

        // Instance of - List
        var list = List.of("1", "2", 3, 4);

        var result = list.stream()
                .filter(String.class::isInstance)
                .collect(Collectors.toList()); // 1, 2

        System.out.println(result);
    }
}
