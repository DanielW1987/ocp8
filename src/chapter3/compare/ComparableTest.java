package chapter3.compare;

import java.util.*;

public class ComparableTest {

    public static void main( String... args ){

        List<Rabbit> rabbits = Arrays.asList( new Rabbit("Hops" ), new Rabbit( "Hoppy" ) );
        List<Duck> ducks     = Arrays.asList( new Duck( "donald" ), new Duck( "dagobert" ));

        /*
         * Die Methode sort erwartet als Parameter einen Comparable,
         * daher kann eine auf Rabbit typisierte Collection nicht hinzugefügt werden.
        */
        //Collections.sort( rabbits );
        Collections.sort(ducks);

        /*
         * Bei Tree-Collections sind die Typen der add-Methode generisch und dabei wird noch nicht zur
         * Compilezeit geprüft, ob der Typ Comparable ist. Ist der Typ nicht Comparable, gibt es eine
         * ClassCastException zur Laufzeit.
         */
        Set<Rabbit> rabbits1 = new TreeSet<>();
        //rabbits1.add( new Rabbit("A") ); // ClassCastException at Runtime

        // Wird dem TreeSet bei der Initialisierung ein Comparator übergeben, gibt es keine Exception
        Comparator<Rabbit> c = Comparator.comparing(a ->a.getName());
        rabbits1 = new TreeSet<>( c );
        rabbits1.add( new Rabbit("A") );

    }
}

class Duck implements Comparable<Duck>{

    private String name;

    public Duck( String name ){
        this.name = name;
    }

    @Override
    public int compareTo(Duck o) {
        return this.name.compareTo(o.name);
    }
}

class Rabbit{
    private String name;

    public Rabbit( String name ){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}