/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter4;

import java.util.function.Supplier;
import java.time.*;

public class SupplierInterface {
    
    public static void main( String... args ){
        
        // Erzeugen von LocalDate-Objekten
        Supplier<LocalDate> s1 = LocalDate::now;
        Supplier<LocalDate> s2 = () -> LocalDate.now();
        
        System.out.println( s1.get() );
        
        // Erzeugen von StringBuilder-Objekten 
        Supplier<StringBuilder> s3 = StringBuilder::new;
        Supplier<StringBuilder> s4 = () -> new StringBuilder();
    
        s3.get().append( "hallo" );
    }
    
}
