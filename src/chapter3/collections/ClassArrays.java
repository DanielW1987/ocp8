package chapter3.collections;

import java.util.Arrays;
import java.util.List;

public class ClassArrays {

    public static void main( String[] args ){

        String[] arr      = { "gerbil", "mouse" };
        List<String> list = Arrays.asList( arr );

        // Änderungen in der Liste führen auch zu Änderungen im Array (umgedreht gilt das gleiche)
        list.set( 1, "test" );
        System.out.println( Arrays.toString( arr ) );
        System.out.println( list );

        arr[0] = "new";
        System.out.println( Arrays.toString( arr ) );
        System.out.println( list );

        // Methoden, die die Größe der Liste beeinflussen, führen zur UnsupportedOperationExcpetion
        list.add( "add" );
        list.remove(0);

    }
}