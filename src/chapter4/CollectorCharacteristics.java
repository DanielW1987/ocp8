package chapter4;

import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectorCharacteristics {

    public static void main(String... args){

        Set<Collector.Characteristics> characteristics = Collectors.toSet().characteristics();
        System.out.println(characteristics); // [UNORDERED, IDENTITY_FINISH]

        characteristics = Collectors.toConcurrentMap(null, null).characteristics();
        System.out.println(characteristics); // [CONCURRENT, UNORDERED, IDENTITY_FINISH]

        characteristics = Collectors.groupingByConcurrent(null).characteristics();
        System.out.println(characteristics); // [CONCURRENT, UNORDERED, IDENTITY_FINISH]

    }
}