package chapter3.generics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LowerBoundedWildcards {

    public static void main(String... args){

        List<String> strings = new ArrayList<>();
        List<Object> objects = new ArrayList<>();
        addSound( strings );
        addSound( objects );

        List<? super IOException> exceptions = new ArrayList<>();
        // exceptions.add( new Exception() ); // Kompiliert nicht, da nur IOException oder deren Kinklassen hinzugefügt werden können
        exceptions.add( new IOException() ); // Kompiliert, da IOException die LowerBound ist
        exceptions.add( new FileNotFoundException()); // Kompiliert, da FileNotFoundException eine Kindklasse von IOException ist
    }

    public static void addSound( List<? super String> list){
        list.add( "tweet" );        // String oder etwaige Kindklasse (String ist jedoch final) ist safe
        // list.add( new Object() );   // Hinzufügen eines Objects kompiliert nicht
    }
}
