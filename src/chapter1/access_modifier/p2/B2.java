package chapter1.access_modifier.p2;

import chapter1.access_modifier.p1.A;

public class B2 extends A {

    public void process(A a){
        // a.i = a.i*2;    // Does not compile, on class A can direct it's member directly
        // it will work if the parameter is of type B2
    }

    public static void main(String[] args){
        A a = new B2();
        B2 b = new B2();
        b.process(a);
        System.out.println( a.getI() );
    }
}
