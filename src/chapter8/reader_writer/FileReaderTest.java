package chapter8.reader_writer;

import java.io.*;

public class FileReaderTest {

    public static void main( String... args ) throws IOException {

        StringBuilder sb = new StringBuilder();
        File dir         = new File("src/chapter8/files");
        File source      = new File( "src/chapter8/reader_writer/FileStreamTest.java" );
        File destination = new File( dir,"test.txt" );

        // FileInputStream vs. FileReader - Die Rückgabe ist in beiden Fällen ein int, der in ein char gecastet werden muss
        try( InputStream in = new FileInputStream( source ) ){

            int input;
            while( (input = in.read()) != -1 ){
                System.out.print(input);
            }
        }
        System.out.println();

        try( Reader in = new FileReader( source ) ){

            int input;
            while( (input = in.read()) != -1 ){
                System.out.print(input);
                sb.append((char)input);
            }

        }

        // FileWriter
        try( Writer out = new FileWriter(destination) ){

            out.write( sb.toString() );

        }
    }
}
