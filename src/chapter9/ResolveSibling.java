package chapter9;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolveSibling {

    public static void main(String... args){

        // path2 wird gegenüber des Parents von path1 aufgelöst
        Path path1 = Paths.get("dir1/dir2/foo");
        Path path2 = Paths.get("bar");

        System.out.println(path1.resolveSibling(path2)); // dir1/dir2/bar

        // other wird zurückgegeben, wenn other absolut ist oder der aufrufende Path keinen Parent hat
        Path noParent = Paths.get("foo");
        Path absoluteOther = Paths.get("/foo/bar");

        System.out.println(path1.resolveSibling(absoluteOther)); // /foo/bar
        System.out.println(noParent.resolveSibling(path2)); // bar

        // Ist other empty, wird der Parent des aufrufenden Path zurückgegeben
        Path emptyOther = Paths.get("");

        System.out.println(path1.resolveSibling(emptyOther)); // dir1/dir2

    }
}
