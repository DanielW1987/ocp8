package summary.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReduceTest {

    public static void main(String... args){

        List<Integer> numbers = Arrays.asList(3,5,6);

        // Optional<T> reduce(BinaryOperator<T> accumulator)
        int result1 = numbers.stream().reduce((a, b) -> a*b ).get();
        System.out.println(result1);

        // T reduce(T identity, BinaryOperator<T> accumulator)
        int result2 = numbers.stream()
                            .reduce(1, (a,b) -> a * b);

        System.out.println(result2);

        testReduce();

    }

    static void testReduce(){

        List<Person> personList = Collections.synchronizedList(new ArrayList<>());
        for(int i = 0; i < 1_000; i++){
            personList.add(new Person( 1000 + ( i * i )));
        }

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
                .map( Person::getVermoegen )
                .reduce( Math::max )
                .get();

        System.out.println(max);

        /*
         * Variante 3: <U> U reduce( U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner);
         * Das map() ist in diesem Fall nicht notwendig, da der Rückgabetyp vom identity (U) vorgegeben wird.
         */
        long sumParallel = personList.stream()
                .parallel()
                .reduce( 0L, (sumVermoegen, p) -> sumVermoegen + p.getVermoegen(), Long::sum );

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