package chapter9;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TraverseDirectories {

    public static void main( String... args ){

        Path basis = Paths.get( "D:/" );

        try{
            Files.walk( basis )
                 .filter( path -> Files.isRegularFile( path ) )
                 .filter( path -> path.toString().endsWith( ".mkv" ) )
                 .forEach( System.out::println );
        }
        catch( UncheckedIOException ade){
            System.out.println("Access denied!");
        }
        catch( IOException ioe ){
            System.out.println("Handle IOException");
        }

    }
}
