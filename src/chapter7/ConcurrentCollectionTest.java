package chapter7;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentCollectionTest {

    public static void main(String... args){

        List<Integer> myInts = Arrays.asList(1, 2, 3);

        List<Integer> concurrentList = new CopyOnWriteArrayList<>( myInts );
        Set<Integer>  concurrentSet  = new ConcurrentSkipListSet<>();
        concurrentSet.addAll( myInts );

        // Schleife wird in jedem Fall nur 3 Mal durchlaufen
        for(Integer item : concurrentList){
            int rnd = new Random().nextInt(100);
            System.out.println("Add " + rnd + " to CopyOnWriteArrayList!");
            concurrentList.add(rnd);
        }

        Iterator<Integer> iterator = concurrentList.iterator();
        while (iterator.hasNext()){
            int rnd = new Random().nextInt(100);
            System.out.println("Add " + rnd + " to CopyOnWriteArrayList!");
            concurrentList.add(rnd);
            iterator.next();
        }

        // Die Anzahl der Schleifendurchläufe ist unbestimmt
        for(Integer item : concurrentSet){
            int rnd = new Random().nextInt(100);
            System.out.println("Add " + rnd + " to ConcurrentSkipListSet!");
            concurrentSet.add(rnd);
        }

        System.out.println(concurrentSet);

        iterator = concurrentSet.iterator();
        while(iterator.hasNext()){
            int rnd = new Random().nextInt(100);
            System.out.println("Add " + rnd + " to ConcurrentSkipListSet!");
            concurrentSet.add(rnd);
            iterator.next();
        }



    }
}
