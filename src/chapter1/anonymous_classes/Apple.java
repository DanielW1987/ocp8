package chapter1.anonymous_classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Apple {

    public static void main( String... args ){

        // Komplett neue Implementierung durch Anonyme Klasse
        Machine m1 = new Machine(){
            @Override
            public void start(){
                System.out.println("do something other");
            }
        };

        m1.start();

        // Anonyme Klasse bei Verwendung eines Interfaces (hier ist alternativ auch ein Lambda-Ausdruck möglich)
        Plant p = new Plant(){

            @Override
            public void grow() {
                System.out.println("Plant growing");
            }
        };

        p.grow();

        // Anonyme Klasse wird als Methodenparameter übergeben
        ArrayList<String> list = new ArrayList<>();
        Collections.sort( list, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

    }

}

abstract class Machine{

    public abstract void start();

}

interface Plant{
    public void grow();
}