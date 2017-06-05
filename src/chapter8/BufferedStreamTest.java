package chapter8;

import java.io.*;
import java.time.Duration;
import java.time.Instant;

public class BufferedStreamTest {

    public static void main(String... args) throws IOException{

        File dir         = new File( "src/chapter8/files" );
        //File source      = new File( "src/chapter8/FileStreamTest.java" );
        File source      = new File( "D:\\00-BRENNEN & KOPIEREN\\Musik\\[2010] Die Feuer sind entfacht\\01 - Intro.mp3" );
        //File destination = new File( dir,"test.txt" );
        File destination = new File( dir,"test.mp3" );

        dir.mkdirs();
        destination.createNewFile();

        /*
         * Die Perfermance eines FileInputStream kann verbessert weden, wenn der read()-Methode eine byte-Array übergeben wird.
         */
        try( InputStream in   = new FileInputStream( source );
             OutputStream out = new FileOutputStream( destination ) ){

            Instant start = Instant.now();
            int lengthRead;
            byte[] buffer = new byte[1024];
            while( (lengthRead = in.read( buffer )) != -1 ){
                out.write( buffer, 0, lengthRead );
                //out.flush();
            }

            Instant end      = Instant.now();
            Duration between = Duration.between(start, end);
            System.out.println("Duration without buffered classes and byte[] as buffer size: " + between);
        }

        /*
         * byte[] mit Buffered Klasse
         */
        try( InputStream in   = new BufferedInputStream( new FileInputStream( source ) );
             OutputStream out = new BufferedOutputStream( new FileOutputStream( destination ) ) ){

            Instant start = Instant.now();
            int lengthRead;
            byte[] buffer = new byte[1024];
            while( (lengthRead = in.read( buffer )) != -1 ){
                out.write( buffer, 0, lengthRead );
                //out.flush();
            }

            Instant end      = Instant.now();
            Duration between = Duration.between(start, end);
            System.out.println("Duration with buffered classes and byte[] as buffer size: " + between);
        }
    }
}