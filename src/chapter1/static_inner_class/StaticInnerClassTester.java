package chapter1.static_inner_class;

import static chapter1.static_inner_class.Outer.StaticNested;

/**
 *
 * @author Daniel
 */
public class StaticInnerClassTester {

    public static void main(String args[]) {

        Outer.StaticNested.displayS();

        // Kompiliert nur mit: import chapter1.static_inner_class.Outer.StaticNested;
        // alternativ: import static chapter1.static_inner_class.Outer.StaticNested;
        StaticNested.displayS();

        // Outer.StaticNested.displayOtherThings(); => DOES NOT COMPILE

        Outer.StaticNested os  = new Outer.StaticNested();
        // Outer.StaticNested os2 = Outer.new StaticNested(); => DOES NOT COMPILE

        os.displayS();
        os.displayOtherThings();

    }
}

class Outer {

    String s = "outer s";
    private static String t = "outer t";

    static class StaticNested {

        static String s = "nested s";

        static void displayS(){

            System.out.println(s);
            System.out.println(t);
            System.out.println(new Outer().s);

        }

        void displayOtherThings(){
            System.out.println("Display other things...");
        }
    }

    public void executeStaticNested(){

        StaticNested.displayS();
        // StaticNested.displayOtherThins(); => DOES NOT COMPILE

    }

}