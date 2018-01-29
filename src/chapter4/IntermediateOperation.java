package chapter4;

import java.util.Arrays;
import java.util.List;

public class IntermediateOperation {

    public static void main(String... args){

        List<Movie> movies = Arrays.asList( new Movie("Terminator", 'R')
                                            , new Movie("Titanic", 'U')
                                            , new Movie("Predestination", 'U'));

        movies.stream()
                .filter(f -> f.getRating() == 'R')
                .peek(System.out::println);

    }
}

class Movie{

    private String title;
    private char rating;

    public Movie(String title, char rating){
        this.title  = title;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public char getRating() {
        return rating;
    }

    public void setRating(char rating) {
        this.rating = rating;
    }
}