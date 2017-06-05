package chapter8;

import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class ObjectStreamTest {

    public static void main( String... args ) throws FileNotFoundException, IOException, ClassNotFoundException{

        // Personen erstellen
        Address dwgAddress = new Address( "Dolgenseestr."
                                        , "57"
                                        , "10319"
                                        , "Berlin"
                                        , "Deutschland");

        Contact dwgPrivateContact = new Contact( "030/12378946"
                                                ,"01520456314"
                                                ,"dwg@qwertz.de");

        Person dwg = new Person(   "Daniel"
                                 , "Wagner"
                                 , LocalDate.of( 1987, 7, 8 )
                                 , dwgAddress
                                 , dwgPrivateContact
                                 , null );

        Person nda = new Person(  "Nils"
                                 ,"Dammenhayn"
                                 , LocalDate.of( 1989, 7, 14 )
                                 ,null
                                 ,null
                                 ,null);

        List<Person> persons = new ArrayList<>();
        persons.add(dwg);
        persons.add(nda);
        persons.add(null);

        File file = new File( "src/chapter8/files/persons.dat" );

        savePersons( persons, file );
        List<Person> loadedPersons = loadPersons( file );

        System.out.println( "persons before saving" );
        persons.stream().forEach( System.out::println );

        System.out.println( "persons after loading" );
        loadedPersons.stream().forEach( System.out::println );

    }

    private static void savePersons( List<Person> persons, File file ) throws FileNotFoundException, IOException{

        try( ObjectOutputStream out = new ObjectOutputStream( new BufferedOutputStream( new FileOutputStream(file))) ){

            for( Person p : persons ){
                out.writeObject( p );
            }
        }
    }

    private static List<Person> loadPersons( File file ) throws FileNotFoundException, IOException, ClassNotFoundException{

        List<Person> persons = new ArrayList<>();

        try( ObjectInputStream in = new ObjectInputStream( new BufferedInputStream( new FileInputStream( file ) ) ) ){

            while( true ){

                Object o = in.readObject();

                // instanceof is false if o is null
                if( o instanceof Person ){
                    persons.add( (Person) o );
                }
            }
        }
        catch( EOFException eofe ){
            // reach end of file
        }

        return persons;
    }
}

class Person implements Serializable{

    private static final long serialVersionUID = 2L;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private Address address;
    private Contact privateContact;
    private Contact businessContact;
    private int age;

    public Person(String firstName, String lastName, LocalDate birthday, Address address, Contact privateContact, Contact businessContact) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.address = address;
        this.privateContact = privateContact;
        this.businessContact = businessContact;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Address getAddress() {
        return address;
    }

    public Contact getPrivateContact() {
        return privateContact;
    }

    public Contact getBusinessContact() {
        return businessContact;
    }

    public int getAge() {
        return Period.between( birthday, LocalDate.now() ).getYears();
    }

    @Override
    public String toString(){
        return firstName + " " + lastName + " (Alter: " + getAge() + ")\n" + address + "\n" + privateContact + "\n" + businessContact + "\n";
    }
}

class Address implements Serializable{

    private static final long serialVersionUID = 1L;
    private String street;
    private String streetNo;
    private String zipCode;
    private String city;

    // nicht serialisieren
    private transient String country;

    public Address(String street, String streetNo, String zipCode, String city, String country) {
        this.street = street;
        this.streetNo = streetNo;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString(){
        return street + " " + streetNo + "\n" + zipCode +" " + city + "\n" + country;
    }
}

class Contact implements Serializable{

    private static final long serialVersionUID = 1L;
    private String phone;
    private String mobile;
    private String mailAddress;

    public Contact(String phone, String mobile, String mailAddress) {
        this.phone = phone;
        this.mobile = mobile;
        this.mailAddress = mailAddress;
    }

    public String getPhone() {
        return phone;
    }

    public String getMobile() {
        return mobile;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    @Override
    public String toString(){
        return "Phone: " + phone + "\n" + "Mobile: " + mobile + "\n" + "E-Mail" + mailAddress;
    }
}