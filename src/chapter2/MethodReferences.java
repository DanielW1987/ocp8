package chapter2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

class Person implements Comparable<Person>{

    private int age;
    private String name;

    public Person( int age, String name ){

        this.age   = age;
        this.name  = name;

    }

    public int getAge(){
        return this.age;
    }
    public String getName(){
        return this.name;
    }

    public String toString(){
        return this.name + " (" + this.age + ")";
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }
}

// Testklasse
public class MethodReferences {

    public static void main( String... args ){

        Person p1 = new Person( 29, "Wagner" );
        Person p2 = new Person( 25, "Mustermann" );
        Person p3 = new Person( 18, "Zander" );
        Person p4 = new Person( 30, "Brecht" );
        List<Person> persons = Arrays.asList(p1, p2, p3, p4);

        // Implementierung eines Comparators via Lambda
        Collections.sort( persons, (a, b) -> PersonUtils.compare(a, b) );
        System.out.println( "Sortierung via Lambda: " + persons );

        /*
         * Referenz zu einer statischen Methode
         * Der Lambda-Ausdruck ist nur eine Delegation an die Methode
         * compare der Klasse PersonUtils. Aus diesem Grund kann die
         * Syntax mit einer Methodenreferenz weiter verkürzt werden.
         */
        Collections.sort( persons, PersonUtils::compare );
        System.out.println( "Sortierung via static method reference: " + persons );

        /*
         * Referenz zu einer Instanzmethode
         */
        PersonComparatorProvider comparatorProvider = new PersonComparatorProvider();
        Collections.sort( persons, comparatorProvider::compareByAgeDesc );
        System.out.println( "Sortierung via instance method reference: " + persons );

        /*
         * Referenz zu einer Instanzmethode eines beliebigen Objekts eines bestimmten Typs
         */
        Collections.sort(persons, Person::compareTo);
        System.out.println( "Sortierung via Instanzmethode eines beliebigen Objekts eines bestimmten Typs: " + persons );

        /*
         * Konstruktor-Referenz
         */
        Supplier<String> lambda     = () -> new String();
        Supplier<String> methodRef  = String::new;


    }

}

class PersonUtils{

    public static int compare( Person p1, Person p2 ) {
        return p1.getName().compareTo( p2.getName() );
    }
}

class PersonComparatorProvider{

    public int compareByAgeDesc( Person p1, Person p2 ){
        return p2.getAge() - p1.getAge();
    }

    public int compareByAgeAsc( Person p1, Person p2 ){
        return p1.getAge() - p2.getAge();
    }
}
