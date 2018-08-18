package summary.exception;

public class AssertionTest {

    public static void main(String... args){
        m1();
    }

    static void m1(){

        try{
            assert true;
        }catch(Exception e){
            // it is allowed to catch Exception, because statement can throw RuntimeException - Compiler doesn't know
            // that assert true; will throw no RuntimeException
            // It's not allowed to catch any other Checked Exception if there is no chance for them to occur
        }
    }
}
