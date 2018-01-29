package chapter6;

public class SupressedExceptionTest {

    public static void main(String... args){

        try{
            throw new IllegalStateException("Turkeys ran off!");
        }
        finally{
            // überdeckt die IllegalArgumentException
            throw new RuntimeException("and we couldn't find them");
        }

    }
}