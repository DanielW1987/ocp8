package chapter3;

import java.util.ArrayList;
import java.util.List;

public class UpperBoundedWildcards {

    static class Sparrow extends Bird{}
    static class Bird{}

    public static void main( String... args ){

        List<? extends Bird> birds = new ArrayList<Bird>();

        // Kompiliert nicht, weil die Liste theoretisch mit Bird typisiert sein könnte.
        //birds.add( new Sparrow() );

        // Kompiliert nicht, weil die Liste theoretisch mit Sparrow typisiert sein könnte.
        //birds.add( new Bird() );

    }

}
