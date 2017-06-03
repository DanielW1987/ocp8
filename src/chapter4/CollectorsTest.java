package chapter4;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsTest {

    public static void main( String... args ){

        /*
         * Beispiel 1 - joining() / joining(CharSequence delimiter)
         * Verknüpft Elemente eines Streams zu einem String
         */
        Stream<String> stringStream = Stream.of("lions", "tigers", "bears");
        String result               = stringStream.collect(Collectors.joining(", "));
        System.out.println(result);

        /*
         * Beispiel 2 - averagingInt / averagingDouble / averagingLong
         * Berechnet Durchschnittswerte auf Basis eines int, double oder long
         * Der Rückgabetyp ist immer Double
         */
        Stream<String> stringStream2  = Stream.of("lions", "tigers", "bears");
        Double result2                = stringStream2.collect(Collectors.averagingInt(String::length));
        System.out.println(result2);

        /*
         * Beispiel 3 - toSet
         * Überführt einen Stream ein (Hash)Set
         */
        Stream<String> stringStream3  = Stream.of("lions", "tigers", "bears");
        Set<String> result3           = stringStream3.collect(Collectors.toSet());
        System.out.println(result3);
        System.out.println(result3.getClass()); // HashSet

        /*
         * Beispiel 4 - toList
         * Überführt einen Stream eine (Array)List
         */
        Stream<String> stringStream4  = Stream.of("lions", "tigers", "bears");
        List<String> result4          = stringStream4.collect(Collectors.toList());
        System.out.println(result4);
        System.out.println(result4.getClass()); // ArrayList

        /*
         * Beispiel 5 - toCollection
         * Überführt einen Stream eine festgelegte Collection
         */
        Stream<String> stringStream5  = Stream.of("lions", "tigers", "bears");
        TreeSet<String> result5       = stringStream5.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(result5);
        System.out.println(result5.getClass()); // TreeSet


        /*
         * Beispiel 6 - toMap
         * Das Beispiel zeigt eine einfache Überführung in eine Map durch Spezifizierung des Keys und des Values
         */
        Stream<String> stringStream6  = Stream.of("lions", "tigers", "bears");
        Map<String, Integer> result6  = stringStream6.collect(Collectors.toMap(s -> s, String::length));
        System.out.println(result6);
        System.out.println(result6.getClass()); // HashMap

        /*
         * Beispiel 7 - toMap
         * Das Beispiel zeigt eien Überführung in eine Map, wobei ein Key mehrere Values hat
         */
        Stream<String> stringStream7  = Stream.of("lions", "tigers", "bears");

        // IllegalStateException, da nicht spezifiziert wurde, was bei einem doppelten Key gemacht werden soll
        // Map<Integer, String> result7  = stringStream7.collect(Collectors.toMap(String::length, s -> s));

        // Verknüpfung der Values bei doppeltem Key
        Map<Integer, String> result7 = stringStream7.collect(Collectors.toMap(  String::length
                                                                              , s -> s
                                                                              , (v1, v2) -> v1 + ", " + v2) );
        System.out.println(result7);
        System.out.println(result7.getClass()); // HashMap

        /*
         * Beispiel 8 - toMap
         * Das Beispiel zeigt wie ein Value bei doppeltem Key einer List hinzugefügt wird
         */
        Stream<String> stringStream8       = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> result8 = stringStream8.collect(Collectors.toMap(  String::length
                                                                                    , v -> createList(v)
                                                                                    , (v1, v2) -> combineList(v1, v2) ) );
        System.out.println(result8);
        System.out.println(result8.getClass());

        /*
         * Beispiel 9 - toMap
         * Das Beispiel zeigt wie eine Map eines konkreten Typs erzeugt werden kann
         */
        Stream<String> stringStream9       = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> result9 = stringStream9.collect(Collectors.toMap(  String::length
                                                                                    , v -> createList(v)
                                                                                    , (v1, v2) -> combineList(v1, v2)
                                                                                    , TreeMap::new ) );
        System.out.println(result9);
        System.out.println(result9.getClass());


        /*
         * Beispel 10 - groupingBy
         * Das Beispiel zeigt, dass Beispiel 8 sehr viel einfacher umzusetzen ist.
         * Allgemein: Elemente eines Streams werden anhand eines Merkmals (z.B. der Länge eines Strings) gruppiert
         */
        Stream<String> stringStream10       = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> result10 = stringStream10.collect(Collectors.groupingBy( String::length ) );
        System.out.println(result10);

        /*
         * Beispel 11 - groupingBy
         * Standardmäßig gibt groupingBy eine Liste als Value zurück. Für den Typ des Values kann aber auch ein Set
         * gewählt werden (sog. Downstream Collector).
         */
        Stream<String> stringStream11       = Stream.of("lions", "tigers", "bears");
        Map<Integer, Set<String>> result11 = stringStream11.collect(Collectors.groupingBy( String::length, Collectors.toSet() ) );
        System.out.println(result11);

        /*
         * Beispel 12 - groupingBy
         * Auch der Typ der Map kann verändert werden
         */
        Stream<String> stringStream12          = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, Set<String>> result12 = stringStream12.collect(Collectors.groupingBy( String::length, TreeMap::new, Collectors.toSet() ) );
        System.out.println(result12);

        /*
         * Beispel 13 - counting
         * Anzahl der Elemente als Value, die zu einer Gruppe gehören
         */
        Stream<String> stringStream13  = Stream.of("lions", "tigers", "bears");
        Map<Integer, Long> result13    = stringStream13.collect(Collectors.groupingBy( String::length, Collectors.counting() ) );
        System.out.println(result13);

        /*
         * Beispiel 14 - partitioningBy
         * Das Partitionieren ist eine besondere Form des Gruppierens. Es gibt nur zwei Mögliche Gruppen - true und false
         * Die Partitionierung wird via eines Predicate vorgenommen. Das Ergebnis ist also eine Map mit den Keys true
         * und false. Die Keys existieren immer, auch wenn es keinen Value geben sollte
         */
        Stream<String> stringStream14      = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> result14 = stringStream14.collect(Collectors.partitioningBy( s -> s.length() <= 5 ) );
        System.out.println(result14);

        /*
         * Beispiel 15 - partitioningBy
         * Statt einer List kann als Value auch ein Set verwendet werden. Map als Rückgabe kann hingegen nicht veränder
         * werden (was auch wenig sinnvoll wäre, da die Map in jedem Fall nur 2 Key besitzt).
         */
        Stream<String> stringStream15       = Stream.of("lions", "tigers", "bears");
        Map<Boolean, Set<String>> result15 = stringStream15.collect(Collectors.partitioningBy( s -> s.length() <= 5, Collectors.toSet() ) );
        System.out.println(result15);

        /*
         * Kompiliert nicht
         * Beispiel 16 - mapping
         * Funktioniert in Kombination mit groupingBy.
         * Z. B. werden Elemente in einem Stream wieder in Gruppen aufgeteilt. Beim Value soll aber ein Mapping auf einen
         * anderen Datentypen durchgeführt werden. Folgendes Beispiel zeigt, wie Strings ihrer Länge nach gruppiert werden
         * und der Value auf den kleinsten Buchstaben der mgl. Values gemappt wird.
         */
        // Stream<String> stringStream16              = Stream.of("lions", "tigers", "bears");
        // Map<Integer, Optional<Character>> result16 = stringStream16.collect( Collectors.groupingBy(   s -> s.length()
        //                                                                                            , Collectors.mapping( s -> s.charAt(0), Collectors.minBy(Comparator.naturalOrder()) ) ) );
        // System.out.println(result16);

        /*
         * Kompiliert nicht
         * Beispiel 17 - mapping
         * Kürzere Variante von Beispiel 16, wenn Collectors über einen static import importiert wurde
         */
        // Stream<String> stringStream17              = Stream.of("lions", "tigers", "bears");
        // Map<Integer, Optional<Character>> result17 = stringStream17.collect( Collectors.groupingBy(   s -> s.length()
        //                                                                                             , mapping( s -> s.charAt(0), minBy(Comparator.naturalOrder()) ) ) );
        // System.out.println(result17);
    }



    private static <T> List<T> createList(T... element){
        return Arrays.asList( element );
    }

    private static <T> List<T> combineList( List<T> list1, List<T> list2){
        List<T> returnList = new ArrayList<>();
        returnList.addAll(list1);
        returnList.addAll(list2);
        return returnList;
    }

}
