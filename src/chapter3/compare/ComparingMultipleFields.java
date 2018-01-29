package chapter3.compare;

import java.util.Comparator;

public class ComparingMultipleFields implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        Comparator<Person> c = Comparator.comparing( p -> p.getName() );
        c.thenComparingInt( p -> p.getAge() );
        return c.compare( o1, o2 );
    }
}

class Person{

    private String name;
    private int age;

    public Person( String name, int age ){

        this.name = name;
        this.age  = age;

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
