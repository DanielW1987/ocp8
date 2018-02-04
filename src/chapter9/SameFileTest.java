package chapter9;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class SameFileTest {

    public static void main(String... args) throws IOException{

        Path myPath1 = FileSystems.getDefault().getPath("C:", "Temp", ".", "Dir");
        Path myPath2 = FileSystems.getDefault().getPath("C:", "Temp", "Dir");
        System.out.println(myPath1);
        System.out.println(myPath2);
        System.out.println(Files.isSameFile(myPath1, myPath2));

    }
}
