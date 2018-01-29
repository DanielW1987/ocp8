package chapter1.access_modifier.p1;

public class B1 extends A{

    public void process(A a){
        a.i = a.i*2; // in same package it is possible
    }

    public static void main(String[] args){
        A a = new B1();
        B1 b = new B1();
        b.process(a);
        System.out.println( a.getI() );
    }
}