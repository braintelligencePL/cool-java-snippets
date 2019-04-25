package pl.braintelligence.from_java_8_to_java_11;

import java.util.List;
import java.util.function.Predicate;

interface _000_Java9_MoreAboutInterfaces {}

interface Film {
    String watch(String str); // implicit functional interface for lambda
    default String previewDefault(String str) { return str; } // can be overriden
    static String previewStatic(String str) { return str; }  // cannot be overriden
    private String adultOnly() { return ""; } // private method from Java 9
}

class FilmImpl implements Film {

    @Override
    public String watch(String str) { // Only watch() is needed to implement!
        previewFilm();
        return "Rick and Morty";
    }

    private void previewFilm() {
        // static method - film preview/trailer
        Film.previewStatic("Rick and Morty");

        // default method - film preview/trailer
        FilmImpl film = new FilmImpl();
        film.previewDefault("Rick and Morty");

        Film film1 = title -> "123";
        film1.watch("123");
    }
}
