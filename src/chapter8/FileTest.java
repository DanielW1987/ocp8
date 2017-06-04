package chapter8;

import java.io.File;
import java.io.IOException;

public class FileTest {

    public static void main(String... args) throws IOException{

        // construct file objects
        File file = new File( "C:/Temp/test.txt" );
        File dir  = new File( "C:/Temp/Dir" );
        File dirs = new File( "C:/Temp/A/B/C/D" );
        File dirA = new File( "C:/Temp/a" );

        // create file
        file.createNewFile();

        // create directory
        dir.mkdir();

        // create directories
        dirs.mkdirs();

        // check if the file and directories exists
        System.out.println( "exists test.txt? " + file.exists() );
        System.out.println( "exists Dir? " + dir.exists() );
        System.out.println( "exists A/B/C/D? " + dirs.exists() );

        // print name and absolute path
        System.out.println( "Name of File: " + file.getName() );
        System.out.println( "Absolute Path of Dir: " + dir.getAbsolutePath() );
        System.out.println( "Canonical Path of Dir: " + dir.getCanonicalPath() );

        // file size
        if( file.isFile() ){
            System.out.println("file size: " + file.length());
            System.out.println("file last modifies: " + file.lastModified());
        }

        // list files
        if( dirA.isDirectory() ){
            for( String e : dirA.list() ){
                System.out.println( "directory under 'A' with list(): " + e );
            }

            for( File e : dirA.listFiles() ){
                System.out.println( "directory under 'A' with listFiles(): " + e );
            }

            System.out.println("dirA last modified: " + dirA.lastModified());
        }

        System.out.println( dirA.delete() ); // Kann nicht gelöscht werden, da Unterordner existieren
        System.out.println( file.delete() ); // Kann gelöscht werden (auch wenn Datei geöffnet)
        System.out.println( dirs.delete() );

    }
}