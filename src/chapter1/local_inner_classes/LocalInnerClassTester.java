package chapter1.local_inner_classes;

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

        // local inner class muss vor erstmaliger Instanziierung implementiert sein
        class LocalInner {

            int i = 41;
            String s = "inner s";

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