package chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

    public static void main( String...args ){
        testReduce();
    }

    static void createStreams(){

        /*
         * Finite Streams / Endliche Streams
         */

        // Statische Erzeuger-Methoden
        Stream<String> emptyStream = Stream.empty();
        Stream<String> singleElemente = Stream.of( "a" );
        Stream<String> multipleElemente = Stream.of( "A", "B", "C" );

        // Sream aus einer Liste
        List<String> strings = Arrays.asList( "A", "B", "C" );
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

    static void testReduce(){

        Person p1 = new Person( 100_00 );
        Person p2 = new Person( 500_00 );
        Person p3 = new Person( 750_00 );
        List<Person> personList = Arrays.asList( p1, p2, p3 );

        // Variante 1: T reduce( T identity, BinaryOperator<T> accumulator )
        // Summierung des Vermögens
        long sum = personList.stream()
                             .map( person -> person.getVermoegen() )
                             .reduce( 0L, Long::sum );

        System.out.println( sum );


        /*
         * Variante 2: Optional<T> reduce( BinaryOperator<T> accumulator )
         * Höchste Vermögen ausgeben
         */
        long max = personList.stream()
                             .map( person -> person.getVermoegen() )
                             .reduce( Math::max )
                             .get();

        System.out.println(max);

        /*
         * Variante 3: <U> U reduce( U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner);
         * Das map() ist in diesem Fall nicht notwendig, da der Rückgabetyp vom identity (U) vorgegeben wird.
         */
        long sumParallel = personList.stream()
                                     //.parallel()
                                     .reduce( 0L, (sumVermoegen, p) -> Long.sum(sumVermoegen, p.getVermoegen() ), Long::sum );

        System.out.println(sumParallel);

    }
}


class Person{

    long vermoegen;

    public Person( long vermoegen ) {
        this.vermoegen = vermoegen;
    }

    public long getVermoegen(){
        return this.vermoegen;
    }
}