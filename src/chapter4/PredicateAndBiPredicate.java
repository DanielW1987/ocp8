/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateAndBiPredicate {
 
    public static void main( String... args ){
        
        // Predicate
        Predicate<String> p1 = String::isEmpty;
        Predicate<String> p2 = t -> t.isEmpty();
        
        System.out.println( p1.test( "a" ) );
        System.out.println( p1.test( "" ) );
        
        // BiPredicate
        BiPredicate<String, String> p3 = String::startsWith;
        BiPredicate<String, String> p4 = (t, u) -> t.startsWith(u);
        
        System.out.println( p3.test( "chicken", "chick" ) );
        System.out.println( p4.test( "chi", "c" ) );
        
        // Werte aus einer Liste entfernen, wenn der Value weniger als 3 Zeichen hat
        List<String> list = new ArrayList<>();
        list.add( "12" );
        list.add( "123" );
        list.add( "1234" );
        list.add( "1" );
        list.add( "123" );
           
        list.forEach(System.out::println);
        System.out.println("------------");
        list.removeIf( t -> t.length() < 3 );
        list.forEach(System.out::println);
    }
    
}
