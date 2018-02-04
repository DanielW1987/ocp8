package chapter3.collections;

import java.util.Arrays;
import java.util.List;

public class Collection8 {

    public static void main( String... args ){

        List<String> names = Arrays.asList( "Daniel", "Wagner", "Max", "Mustermann" );
        names.replaceAll(s -> s.replace("a", "") );
        System.out.println(names);

    }
}