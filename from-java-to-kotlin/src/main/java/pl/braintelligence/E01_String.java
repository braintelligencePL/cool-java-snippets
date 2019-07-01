package pl.braintelligence;

public class E01_String {
    public static void main(String[] args) {
        final int a = 5;
        final int b = 7;

        System.out.println(
                getStringNormalConcat(a, b)
        );

        System.out.println(
                getStringFasterPerformanceConcat(a, b)
        );

        System.out.println(
                getMultilineText()
        );

    }

    private static String getStringNormalConcat(int a, int b) {
        return "sum of " + a + " and " + b + " is " + a + b;
    }

    private static String getStringFasterPerformanceConcat(int a, int b) {
        return "sum of "
                .concat(String.valueOf(a))
                .concat(" and ")
                .concat(String.valueOf(b))
                .concat(" is ")
                .concat(String.valueOf(a + b));
    }

    private static String getMultilineText() {
        return "First Line\n" +
                "Second Line\n" +
                "Third Line";
    }
}
