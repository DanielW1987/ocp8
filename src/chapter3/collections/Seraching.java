package chapter3.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Seraching {

    public  static void main( String... args ){

        List<String> names = Arrays.asList( "Fluffy", "Hoppy" );

        // Absteigende Sortierung
        Comparator<String> c = Comparator.reverseOrder();

        // Ergebnis ist -1. Die Methode binarySearch braucht eine aufsteigende sortierte Collection,
        // um korrekte Ergebnisse zurückzuliefern
        int index = Collections.binarySearch( names, "Hoppy", c );
        System.out.println( index );

        // Natural Ordering
        Comparator<String> c1 = Comparator.naturalOrder();

        // Ergebnis ist korrekterweise 1
        int index1 = Collections.binarySearch( names, "Hoppy", c1 );
        System.out.println( index1 );

    }
}