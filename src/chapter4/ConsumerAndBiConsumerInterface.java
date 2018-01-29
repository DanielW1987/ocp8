/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerAndBiConsumerInterface {
    
    public static void main( String... args ){
        
        // Werte zu einer List/Map hinzufügen per Consumer
        List<String> list = new ArrayList<>();
        Consumer<String> c1 = list::add;
        
        Map<String, String> map = new HashMap<>();
        BiConsumer<String, String> b1 = map::put;
        
        c1.accept("Hallo");
        c1.accept("Welt");
        b1.accept("Hallo", "Welt");
        b1.accept("Daniel", "Wagner");
        
        // Alle Werte einer Liste via Consumer ausgeben
        List<Integer> ints = Arrays.asList(1,2,3,4,5,6,7,8,9);  
        ints.forEach( System.out::println );
        
        // Werte einer Map ausgeben
        BiConsumer<String, String> b2 = (k, v) -> System.out.println( k + "->" + v );
        BiConsumer<String, String> b3 = b2.andThen( (k, v) -> System.out.println( v + "<-" + k ) );
        map.forEach( b3 );
    }
    
}
