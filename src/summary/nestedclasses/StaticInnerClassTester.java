package summary.nestedclasses;

/**
 *
 * @author Daniel
 */
public class StaticInnerClassTester {

    public static void main(String args[]) {

        AnotherClass.StaticNested.displayS();

        // Kompiliert nur mit: import chapter1.static_inner_class.Outer.StaticNested;
        // alternativ: import static chapter1.static_inner_class.Outer.StaticNested;
        AnotherClass.StaticNested.displayS();

        // Outer.StaticNested.displayOtherThings(); => DOES NOT COMPILE

        AnotherClass.StaticNested os  = new AnotherClass.StaticNested();
        // Outer.StaticNested os2 = Outer.new StaticNested(); => DOES NOT COMPILE

        os.displayS();
        os.displayOtherThings();

    }
}

class AnotherClass {

    String s = "outer s";
    private static String t = "outer t";

    static class StaticNested {

        static String s = "nested s";

        static void displayS(){

            System.out.println(s); // nested s
            System.out.println(t); // outer t
            System.out.println(new Outer().s); // outer s

        }

        void displayOtherThings(){
            System.out.println("Display other things...");
        }
    }

    public void executeStaticNested(){

        StaticNested.displayS();
        System.out.println(StaticNested.s); // <= Member der statischen Klasse
        // StaticNested.displayOtherThins(); => DOES NOT COMPILE

    }
}