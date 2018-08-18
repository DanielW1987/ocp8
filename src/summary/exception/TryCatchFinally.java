package summary.exception;

public class TryCatchFinally {

    public static void main(String... args){

        TryCatchFinally test = new TryCatchFinally();

        System.out.println( test.returnObjectType() );
        System.out.println( test.returnPrimitiveType() );

    }

    public Person returnObjectType(){
        Person person = new Person("Daniel", "Wagner", "Berlin");
        try{
            Integer a = Integer.parseInt("123");
        }
        catch(NumberFormatException nfe){
            return person;
        }
        finally{
            return person.setLastName("Waginator");
        }
    }

    public int returnPrimitiveType(){
        int i = 1;
        try{
            Integer a = Integer.parseInt("123");
        }
        catch(NumberFormatException nfe){
            return ++i;
        }
        finally{
            i++;
            return ++i;
        }
    }

}

class Person{

    private String firstName;
    private String lastName;
    private String city;

    public Person(String firstName, String lastName, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Person setCity(String city) {
        this.city = city;
        return this;
    }

    public String toString(){
        return firstName + " " + lastName + ", " + city;
    }
}
