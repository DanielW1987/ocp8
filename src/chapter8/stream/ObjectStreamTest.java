package chapter8.stream;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ObjectStreamTest{

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