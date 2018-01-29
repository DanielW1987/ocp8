package chapter9;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;

public class PathTest {

    public static void main(String... args) throws URISyntaxException, IOException{

        // Path-Objekte erzeugen
        Path path1 = Paths.get( "src/chapter9/files/foto.png" );
        Path path2 = Paths.get( "C:\\Users\\Daniel\\IdeaProjects\\ocp8\\src\\chapter9\\files\\foto.png" );
        Path path3 = Paths.get( "src", "chapter9", "files", "foto.png" );
        Path path4 = Paths.get( "C:", "Users", "Daniel", "IdeaProjects", "ocp8", "src", "chapter9", "files", "foto.png" );
        Path path5 = Paths.get( new URI( "file:///C:/Users/Daniel/IdeaProjects/ocp8/src/chapter9/files/foto.png" ) );
        Path path6 = FileSystems.getDefault().getPath("src/chapter9/files/foto.png");
        Path path7 = FileSystems.getDefault().getPath("C:\\Users\\Daniel\\IdeaProjects\\ocp8\\src\\chapter9\\files\\foto.png");

        // Path-Objekte konvertieren
        URI uri1    = path1.toUri();
        File file1  = path1.toFile();
        Path path8  = file1.toPath();

        // toString(), getNameCount(), getName(int)
        System.out.println( path1.toString() );
        for( int index = 0; index < path2.getNameCount(); index++ ){
            System.out.println( "Path segment: " + path2.getName(index) );
        }

        // getFileName(), getParent(), getRoot()
        Path path9  = FileSystems.getDefault().getPath( "C:/Temp/" );
        Path path10 = path9.getFileName();
        System.out.println("Filename of a directory: " + path10);
        System.out.println("Filename of a file: " + path1.getFileName() );

        Path currentPath = path2;
        while( (currentPath = currentPath.getParent()) != null ){
            System.out.println("traverse path2: " + currentPath);
        }

        System.out.println("Root of a relative path: " + path2.getRoot() );
        System.out.println("Root of an absolute path: " + path1.getRoot() );

        // isAbsolute(), toAbsolutePath
        System.out.println( "path1 isAbsolute(): " + path1.isAbsolute() );
        System.out.println( "path2 isAbsolute(): " + path2.isAbsolute() );

        Path path11 = path1.toAbsolutePath(); // relativer path1 wird zu einem absoluten Path konvertiert
        Path path12 = path2.toAbsolutePath(); // path2 ist bereits absolut, es wird eine Kopie zurückgegeben
        System.out.println("path11: " + path11);
        System.out.println("path12: " + path12);

        Path notExistingPath = Paths.get( "Users\\ocp8\\src\\chapter9\\files\\foto.png" );
        System.out.println("toAbsolutePath on not existing relative path: " + notExistingPath.toAbsolutePath());

        // subpath
        Path path13 = path2.subpath(1,4);
        System.out.println("Subpath 1 to 4 for path2: " + path13);

        // Path Symbols
        Path path14 = Paths.get( "text.txt" );
        System.out.println(path14.toAbsolutePath().toString());

        // relativize()
        Path relativePath1 = Paths.get( "Temp/a/b/c.txt" );
        Path relativePath2 = Paths.get( "Temp/b/c/d.txt" );
        System.out.println("relativePath1 relative to relativePath2: " + relativePath1.relativize(relativePath2));
        System.out.println("relativePath1 relative to relativePath2: " + relativePath2.relativize(relativePath1));

        Path relativePath3 = Paths.get( "../../TempA/a/b/c.txt" );
        Path relativePath4 = Paths.get( "TempB/b/c/d.txt" );
        System.out.println("relativePath4 relative to relativePath3: " + relativePath4.relativize(relativePath3));
        System.out.println("relativePath3 relative to relativePath4: " + relativePath3.relativize(relativePath4));

        // resolve() mit 2 absoluten Path-Objekten
        Path resolvePath1 = Paths.get( "C:/Temp/A" );
        Path resolvePath2 = Paths.get( "C:/Temp/B2" );
        System.out.println( "resolve mit 2 absoluten Path-Objekten: " + resolvePath1.resolve(resolvePath2) ); // Rückgabe ist Kopie des Parameters

        // resolve() mit 2 relativen Path-Objekten
        Path resolvePath3 = Paths.get( "Temp/A" );
        Path resolvePath4 = Paths.get( "Temp/B2" );
        System.out.println( "resolve mit 2 relativen Path-Objekten: " + resolvePath3.resolve(resolvePath4) ); // Rückgabe ist die Verkettung beider Objekte zu Temp\A\Temp\B2

        // resolve() mit relativen Path als Basis und absoluten Path als Parameter
        Path resolvePath5 = Paths.get( "Temp/A" );
        Path resolvePath6 = Paths.get( "C:/Temp/B2" );
        System.out.println( "resolve mit relativen Path als Basis und absoluten Path als Parameter: " + resolvePath5.resolve(resolvePath6) ); // Rückgabe ist Kopie des Parameters

        // resolve() mit absoluten Path als Basis und relativen Path als Parameter
        Path resolvePath7 = Paths.get( "C:/Temp/A" );
        Path resolvePath8 = Paths.get( "Temp/B2" );
        System.out.println( "resolve mit absoluten Path als Basis und relativen Path als Parameter: " + resolvePath7.resolve(resolvePath8) ); // Rückgabe ist die Verkettung beider Objekte zu C:\Temp\A\Temp\B2

        // normalize()
        Path path15   = Paths.get( "E:\\data" );
        Path path16   = Paths.get( "E:\\user\\home" );
        Path relative = path15.relativize(path16);
        System.out.println("relative path: " + relative);
        System.out.println("resolved path: " + path15.resolve(relative)); // E:\\data\\..\\user\\home
        System.out.println("normalized path: " + path15.resolve(relative).normalize()); // E:\\user\\home

        // toAbsolutePath() vs. toRealPath()
        Path symbolicLinkPath = Paths.get( "C:\\Users\\Daniel\\IdeaProjects\\ocp8\\src\\chapter9\\test" );
        System.out.println( "toAbsolutePath on a symbolic Link: " + symbolicLinkPath.toAbsolutePath() );

        // Exception zur Laufzeit
        // System.out.println( "toRealPath on a symbolic Link: " + symbolicLinkPath.toRealPath());
        //System.out.println( "toRealPath on a symbolic Link with NOFOLLOW_LINKS: " + symbolicLinkPath.toRealPath(LinkOption.NOFOLLOW_LINKS));


    }
}
