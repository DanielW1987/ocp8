package chapter8;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Relativize {

    public static void main(String... args){

        Path p1 = Paths.get("c:\\personal\\.\\photos\\..\\readme.txt");
        Path p2 = Paths.get("c:\\personal\\index.html");
        System.out.println("relativize: " + p1.relativize(p2));
        System.out.println("normalize: " + p1.normalize());

    }
}
