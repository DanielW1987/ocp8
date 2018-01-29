package chapter9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.List;

public class FilesTest {

    public static void main(String... args) throws IOException{

        Path path1 = Paths.get( "C:\\Users\\Daniel\\IdeaProjects\\ocp8\\src\\chapter9\\files\\foto.jpeg" );

        // exists()
        if(Files.exists(path1) ){
            System.out.println("path1 exists!");
        }
        else{
            System.out.println("path1 doesn't exist!");
        }

        // isSameFile()
        Path sameFile1 = Paths.get( "C:\\Temp\\A\\B2" );
        Path sameFile2 = Paths.get( "C:\\Temp\\A\\..\\A\\B2" );
        System.out.println(Files.isSameFile(sameFile1, sameFile2));

        // createDirectory() und createDirectories()
        Path dir1 = Paths.get( "src/chapter9/files/A" );
        Files.deleteIfExists( Paths.get( "src/chapter9/files/A" ) );
        Files.createDirectory(dir1); // wirft FileAlreadyExistException wenn Path bereits existiert

        Path dir2 = Paths.get( "src/chapter9/files/B2/C/D/E" );
        Files.deleteIfExists( Paths.get( "src/chapter9/files/B2/C/D/E/foto-backup.jpeg" ) );
        Files.deleteIfExists( Paths.get( "src/chapter9/files/B2/C/D/E" ) );
        Files.createDirectories(dir2); // wirft FileAlreadyExistException wenn Path bereits existiert

        // copy()
        Files.copy(path1, dir2.resolve("foto-backup.jpeg"));

        // move()
        Path move1 = Paths.get( "C:\\Users\\Daniel\\IdeaProjects\\ocp8\\src\\chapter9\\files\\MOVE\\A\\test.txt" );
        Path move2 = Paths.get( "C:\\Users\\Daniel\\IdeaProjects\\ocp8\\src\\chapter9\\files\\MOVE\\B2\\text-move.txt" );

        if( Files.exists(move1) ){
            Files.move( move1, move2 );
        }
        else{
            Files.move( move2, move1 );
        }

        // newBufferedReader(), new BufferedWriter
        Path source = Paths.get( "C:\\Users\\Daniel\\IdeaProjects\\ocp8\\src\\chapter9\\files\\Buffered\\A\\test.txt" );
        Path target = Paths.get( "C:\\Users\\Daniel\\IdeaProjects\\ocp8\\src\\chapter9\\files\\Buffered\\B2\\test-backup.txt" );

        try(BufferedReader reader = Files.newBufferedReader( source, Charset.defaultCharset() );
            BufferedWriter writer = Files.newBufferedWriter( target, Charset.defaultCharset() ) ){

            String line;
            while( (line = reader.readLine()) != null ){
                System.out.println(line);
                writer.write( line );
            }

        }

        // readAllLines
        List<String> lines = Files.readAllLines(source);
        for( String s : lines ){
            System.out.println("Line: " + s);
        }

        // isDirectory(), isRegularFile(), isSymbolicLink()
        Path directory     = Paths.get( "C:\\Users\\Daniel\\IdeaProjects\\ocp8\\src\\chapter9\\files\\FileAttributes" );
        Path file          = Paths.get( "C:\\Users\\Daniel\\IdeaProjects\\ocp8\\src\\chapter9\\files\\FileAttributes\\ab.txt" );
        Path sLink         = Paths.get( "C:\\Users\\Daniel\\IdeaProjects\\ocp8\\src\\chapter9\\files\\FileAttributes\\OCP" );
        Path fileNotExists = Paths.get( "C:/Temp/abc.txt" );

        if( Files.isDirectory(directory) ){
            System.out.println( directory + " is a directory." );
        }

        if( Files.isRegularFile(file) ){
            System.out.println( file + " is a regular file." );
        }

        if( Files.isSymbolicLink( sLink ) ){
            System.out.println( sLink + " is a symbolic Link." );
        }

        if( Files.isRegularFile( fileNotExists ) ){
            System.out.println( "should not happen." );
        }
        else{
            System.out.println("File not exists");
        }

        // getLastModifiedTime(), setLastModifiedTime()
        Path fileA = Paths.get( "C:\\Users\\Daniel\\IdeaProjects\\ocp8\\src\\chapter9\\files\\FileAttributes\\fileA.txt" );
        Path dirA  = Paths.get( "C:\\Users\\Daniel\\IdeaProjects\\ocp8\\src\\chapter9\\files\\FileAttributes\\A" );

        System.out.println( "lastModifiedTime of fileA: " + Files.getLastModifiedTime(fileA));
        System.out.println( "lastModifiedTime of directory A: " + Files.getLastModifiedTime( dirA ) );

        Files.setLastModifiedTime( fileA, FileTime.fromMillis( System.currentTimeMillis() ) );
        Files.setLastModifiedTime( dirA, FileTime.fromMillis( System.currentTimeMillis() ) );

        System.out.println( "lastModifiedTime of fileA: " + Files.getLastModifiedTime(fileA));
        System.out.println( "lastModifiedTime of directory A: " + Files.getLastModifiedTime( dirA ) );

        // getOwner(), setOwner()
        System.out.println( Files.getOwner(dirA) );

    }
}
