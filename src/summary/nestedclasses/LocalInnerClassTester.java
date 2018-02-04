package summary.nestedclasses;

public class LocalInnerClassTester {
    public static void main(String args[]) {
        Outer outer = new Outer();
        outer.displayST();

        // Kompiliert nicht, da die Klasse nur innerhalb der Methode verwendet werden kann
        // Outer.LocalInner inner = new Outer().new LocalInner();

    }
}

class Outer {

    String s = "outer s";

    void displayST() {

        String t = "method t";  // effectively final (seit Java 8)
        System.out.println(s + ", " + t);

        // t = "test"; // würde effectively final zerstören

        // Kompiliert nicht, da LocalInner noch nicht gefunden werden kann
        // LocalInner li = new LocalInner();

        // Access modifier not allowed for local inner classes
        // public class LocalInner{}

        // static not allowed for local inner classes
        // static class Inner{}

        // local inner class muss vor erstmaliger Instanziierung implementiert sein
        class LocalInner {

            int i = 41;
            String s = "inner s";
            // private static int j  = 2; // static member not allowed, also static inner classes
            public static final int k = 1; // but static final is okay

            // static methods not allowed
            // public static void print(){}

            // member classes are allowed, but should package-private
            class ClassA{}

            void displayMessage() {

                System.out.println(s); // inner s
                System.out.println(Outer.this.s); // outer s
                System.out.println(t);
                System.out.println(i);

            }
        }

        // erste Instanziierung der Klasse
        LocalInner li = new LocalInner();
        li.displayMessage();
    }
}