/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter4;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionAndBiFunction {
  
    public static void main( String... args ){
        
        Function<String, Integer> f1 = String::length;
        Function<String, Integer> f2 = x -> x.length();
        
        System.out.println( f1.apply( "Daniel" ) );
        
        BiFunction<String, String, String> bf1 = String::concat;
        BiFunction<String, String, String> bf2 = (t, u) -> t.concat(u);
        
        System.out.println( bf2.apply("Hallo ", "Welt") );
        
    }
}