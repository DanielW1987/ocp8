package chapter8.stream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BufferedReaderTest {

    public static void main( String... args ) throws IOException{

        File dir         = new File("src/chapter8/files");
        File source      = new File( "src/chapter8/FileStreamTest.java" );
        File destination = new File( dir,"test.txt" );

        destination.createNewFile();

        try( BufferedReader in  = new BufferedReader( new FileReader( source ) );
             BufferedWriter out = new BufferedWriter( new FileWriter( destination ) ) ){

            List<String> data = new ArrayList<>();
            String line;
            while( (line = in.readLine()) != null ){
                data.add(line);
            }

            for( String s : data ){
                out.write(s);
                out.newLine();
            }
        }
    }
}
