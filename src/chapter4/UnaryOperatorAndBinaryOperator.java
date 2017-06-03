/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter4;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorAndBinaryOperator {
    
    public static void main( String... args ){
        
        UnaryOperator<String> uo1 = String::toUpperCase;
        UnaryOperator<String> uo2 = t -> t.toUpperCase();
        
        System.out.println( uo1.apply( "Hallo Welt" ) );
        
        
        BinaryOperator<String> bo = String::concat;
        System.out.println( bo.apply("Hallo ", "Welt") );
        
    }
    
}
