package chapter1.member_inner_class;

/**
 *
 * @author Daniel
 */
public class ClassD {

    private int i = 30;

    class ClassE{

        private int i = 20;

        class ClassF{

            private int i = 10;

            public void print(){

                System.out.println("i of class f: " + i);
                System.out.println("i of class f: " + this.i);
                System.out.println("i of class f: " + ClassF.this.i);
                System.out.println("i of class f: " + ClassE.ClassF.this.i);
                System.out.println("i of class f: " + ClassD.ClassE.ClassF.this.i);

                System.out.println("i of class e: " + ClassE.this.i);
                System.out.println("i of class e: " + ClassD.ClassE.this.i);
                // Geht nicht, da i keine statische Variable ist
                // System.out.println("i of class e: " + ClassE.i);

                System.out.println("i of class d: " + ClassD.this.i);

            }
        } // end of ClassF
    } // end of ClassE

    public static void main(String... args){

        ClassD d                = new ClassD();
        ClassD.ClassE e         = new ClassD().new ClassE();  // Alternativ: ClassE e = ...
        ClassE.ClassF f         = e.new ClassF();

        // Alternativ ginge auch
        ClassD.ClassE.ClassF f2 = e.new ClassF();

        f.print();

    }

} // end of ClassD
