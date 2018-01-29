package chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class GenericStream {

    public static void main( String...args ){
        createStreams();
        testCount();
    }

    static void createStreams(){

        /*
         * Finite Streams / Endliche Streams
         */

        // Statische Erzeuger-Methoden
        Stream<String> emptyStream = Stream.empty();
        Stream<String> singleElemente = Stream.of( "a" );
        Stream<String> multipleElemente = Stream.of( "A", "B2", "C" );

        // Sream aus einer Liste
        List<String> strings = Arrays.asList( "A", "B2", "C" );
        Stream<String> fromList1 = strings.stream();
        Stream<String> fromList2 = strings.parallelStream(); // erst sinnvoll bei vielen Elemente im Stream (Overhead)

        /*
         * Infinite Streams / Unendliche Streams
         */
        Stream<Double> random1 = Stream.generate( Math::random );
        Stream<Double> random2 = Stream.generate( () -> 1d );
        Stream<Integer> oddNumbers = Stream.iterate( 1,n -> n+2 );

    }

    static void testCount(){

        // Count auf einem infinite Stream
        Stream<Integer> oddNumbers = Stream.iterate( 1,n -> n+2 );
        long count                 = oddNumbers.count();

    }
}