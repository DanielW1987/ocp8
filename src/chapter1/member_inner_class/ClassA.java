package chapter1.member_inner_class;

//import chapter1.member_inner_class.ClassA.ClassB;

/**
 *
 * @author Daniel
 */
public class ClassA {

    int i;

    /***************************************************************************
     * Member inner class
     *************************************************************************/
    public class ClassB{
        int j;
        // static int k;        // dürfen keine statischen Felder besiten
        final static int k = 1; // es denn sie sind final

        // private static void doSomething(){} // dürfen keine statischen Methoden besitzen

        // Zugriff auf Variablen der umhüllenden Klasse möglich
        private int getIFromA(){
            return i;
        }
    }
    /**************************************************************************/

    /***************************************************************************
     * Member inner interface (kann auch private sein, jedoch nicht die Methoden
     **************************************************************************/
    private interface inner{

        // In inner interfaces kann nicht auf die Instanzvariablen der umhüllenden Klasse zugegriffen werden
        // public default int inner(){ return i; }; => DOES NOT COMPILE

        public abstract void innerMethod();
    }
    /**************************************************************************/

    // Instanzmethode von ClassA
    public void make(){

        // Instanziierung in Instanzmethoden einfach möglich
        ClassB b = new ClassB();
    }

    // Main method
    public static void main( String... args ){

        ClassA a = new ClassA();
        a.i      = 5;

        // Instanziierung in statischer Methode funktioniert nur mit einer
        // Instanz der umhüllenden Klasse
        ClassB b = a.new ClassB();

        System.out.println( b.getIFromA() );
    }
}

class ClassC{

    void doSomething(){

        ClassA a = new ClassA();

        // Objekttyp muss in dieser Form angegeben werden
        ClassA.ClassB b = a.new ClassB();

        // Für diese Schreibweise ist ein expliziter Import erforderlich.
        // ClassB b2 = a.new ClassB();

        //System.out.println( b.getIFromA() ); => DOES NOT COMPILE, private access

    }

}