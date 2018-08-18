package chapter6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class MultiCatch {

    public static void main(String... args){

        // Schlecht

        try{
            Path path       = Paths.get("test.txt");
            String text     = new String( Files.readAllBytes( path ) );
            LocalDate date  = LocalDate.parse(text);
        }
        catch( DateTimeParseException dtpe ) {
            dtpe = new DateTimeParseException("Message", "", 0);
            dtpe.printStackTrace();
            throw new RuntimeException(dtpe);
        }
        catch( IOException ioe ){
            ioe = new IOException();
            ioe.printStackTrace();
            throw new RuntimeException( ioe );
        }

        // Gut
        try{
            Path path       = Paths.get("test.txt");
            String text     = new String( Files.readAllBytes( path ) );
            LocalDate date  = LocalDate.parse(text);
        }
        catch( DateTimeParseException | IOException  e ) {
            // e = new RuntimeException(); // DOES NOT COMPILE
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
