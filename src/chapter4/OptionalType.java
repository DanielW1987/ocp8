/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter4;

import java.util.Optional;

public class OptionalType {
    
    public static void main( String... args ){
     
        System.out.println( average(100,90) ); // Optional[95.0]
        System.out.println( average() );       // Optional.empty
        
        Optional<Double> o = average( 50, 10, 30 );
        System.out.println( o.get() );
        
        Optional<Double> o2 = average();
        // System.out.println( o2.get() ); // NoSuchElementException
        // Daher besser
        if( o2.isPresent() ){
            System.out.println( o2.get() );
        }
    }   
    
    
    public static Optional<Double> average( int... scores ){
            
        if( scores.length == 0 ){
            return Optional.empty();
        }
        else{
            
            int sum = 0;
            for( int score : scores){
                sum += score;
            }
            
            return Optional.of( (double)( sum / scores.length ) );
        }
        
        
    }
}