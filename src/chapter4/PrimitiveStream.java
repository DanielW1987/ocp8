package chapter4;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveStream {

    /*
     * Üblicherweise verwendet man einen Stream über einen Typen T, um Auswertungen über Elemente dieses Typs zu machen.
     * Eine Entsprechung für ints ist im folgenden Listing zu sehen. Dabei wird der Stream verwendet, um die Summe der
     * Ganzzahlen aus dem angegebenen, halboffenen Interval zu bestimmen, die eine gewisse Eigenschaft erfüllen.
     */
    int evenSum(int fromInclusive, int toExclusive) {

        return IntStream.range(fromInclusive, toExclusive)
                .filter(i -> i % 2 == 0)
                .sum();

    }

    /*
     * Andererseits lassen sich zählende for-Schleifen auch verwenden, um mittels Index über die Elemente eines Arrays
     * zu iterieren. Analog dazu kann man ein IntStream verwenden, um aus einem Array einen Stream zu erzeugen.
     */
    <T> Stream<T> makeStream(T[] array) {

        return IntStream.range(0, array.length)
                .mapToObj(i -> array[i]);

    }

    /*
     * In den beiden vorherigen Beispielen wurde jeweils die Methode IntStream::range verwendet, um einen Stream
     * sequentiell aufsteigender ints zu erzeugen. Für DoubleStream gibt es dazu keine Entsprechung. Doch mit Hilfe
     * von IntStream lässt sich einfach eine dazu konstruieren, wie im folgenden Listing zu sehen.
     */
    DoubleStream range(int from, int to, double scale){

        return IntStream.range(from, to)
                .mapToDouble(i -> i * scale);

    }

    /*
     * Erzeugung eines DoubleStream auf Basis eines float[] via IntStream.
     * Der Trick besteht also wiederum darin, den IntStream zur Indizierung zu verwenden. In gewisser Weise handelt es
     * sich hierbei um ein wiederkehrendes Muster – sowie die Zählschleife ein Muster der allgemeinen Schleife.
     */
    DoubleStream makeStream2(float[] array) {

        return IntStream.range(0, array.length)
                .mapToDouble(i -> array[i]);

    }

}
