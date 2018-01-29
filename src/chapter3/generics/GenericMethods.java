package chapter3.generics;

import java.util.HashMap;
import java.util.Map;

public class GenericMethods {

    public static void main( String args ){

        // Aufruf der Methode
        String a = GenericMethods.<String>getT( "Hallo" );

        // Der generische Typ muss beim Aufruf nicht vorangestellt sein
        GenericMethods.doNothing("Hallo");
        String b = GenericMethods.getT( "Hallo" );
    }

    public static <T> T getT( T t ){
        return t;
    }

    public static <T> void doNothing( T t ){
        System.out.println("do nothing");
    }

    // Bei nicht-statischen Methoden muss es ebenfalls gemacht werden, wenn T nicht über die Klassendeklaration aufgelöst werden kann
    public <T> T getOtherT( T t ){
        return t;
    }

    // Kompiliert nicht
    // public static void compile( T t ){}

}

class MyClass<T>{

    T value;
    private Map<?, String> myMap = new HashMap<String, String>();

    public MyClass(){
        // myMap.put(new Object(), ""); // myMap ist de facto immutable.
    }

    public T getValue(){
        return value;
    }

    // compiler can't infer E
    public <E> E getE(E e){
        return e;
    }

    // compiler can't infer T (no instance of class needed for static methods)
    public static <T> T getValue(T value){
        return value;
    }
}