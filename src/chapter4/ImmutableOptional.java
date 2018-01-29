package chapter4;

import java.util.Optional;

public class ImmutableOptional {

    public static void main(String... args){

        Optional<String> a = Optional.of("Test A");
        a.of("Doesn’t work!");
        Optional<String> b = a.of("Test B");

        System.out.println(a.get()); // Test A
        System.out.println(b.get()); // Test B

    }
}
