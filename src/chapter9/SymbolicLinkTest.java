package chapter9;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SymbolicLinkTest {

    public static void main(String[] args) throws Exception {
        Path existingFilePath = Paths.get("C:\\Temp\\test.txt");
        Path symLinkPath = Paths.get("C:\\test1_link.txt");
        Files.createSymbolicLink(symLinkPath, existingFilePath);
        if( Files.isSymbolicLink(symLinkPath) ){
            System.out.println(symLinkPath + " is a symbolic link.");
        }
    }
}
