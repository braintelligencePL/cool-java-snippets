package pl.braintelligence;

public class E04_DefaultArguments {
    public static void main(String[] args) {

        hello("world");

    }

    public static void hello(String name) {
        if (name == null) {
            name = "World";
        }

        System.out.print("Hello, " + name + "!");
    }
}
