package chapter9;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TraverseDirectories {

    public static void main( String... args ){

        Path basis = Paths.get( "D:/00-BRENNEN & KOPIEREN" );

        try{
            long count = Files.walk( basis )
                              .filter( Files::isRegularFile )
                              .filter( path -> path.toString().endsWith( ".mp3" ) )
                              .count();

            System.out.println(count);
        }
        catch( UncheckedIOException ade){
            System.out.println("Access denied!");
            System.err.println(ade.getLocalizedMessage());
        }
        catch( IOException ioe ){
            System.out.println("Handle IOException");
        }

    }
}
