package chapter3;

import java.util.List;

public class UnboundedWildcards {

    public static void main( String... args ){

    }

    // Iteration durch eine Liste egal welchen Typs
    public void iterateList(List<?> list){
        list.forEach(System.out::println);
    }

    public void addElement( List<?> list ){
        // Der mit ? typisierten Liste können keine konkreten Objekte hinzugefügt werden
        // list.add( "test" );
    }
}
