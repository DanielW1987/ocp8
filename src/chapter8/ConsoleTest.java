package chapter8;

import java.io.*;

public class ConsoleTest {

    public static void main(String... args){

        Console console = System.console();

        if( console != null ){

            console.format("Hallo %s, du bist %d Jahre alt.", "Daniel", 29);
            console.writer().println();
            console.printf("Hallo %s", "Welt");
            console.writer().println();

            System.out.println("Please input something here:");
            String input = console.readLine();
            console.writer().println("Your input was: " + input);

            String input2 = console.readLine( "Bitte gib einen %s hier ein: ", "Text" );

            // Eingabe über BufferedReader
            //BufferedReader reader = new BufferedReader( console.reader() );
            //System.out.print( "Eingabe via BufferedReader: " );
            //String input3 = reader.readLine();

            // Passworteingabe
            char[] password = console.readPassword( "Password: " );
            for( int index = 0; index < password.length; index++ ){
                System.out.print(password[index]);
            }
        }
        else{
            System.out.println("console is null");
        }
    }
}