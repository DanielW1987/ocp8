package chapter8.serializable;

import java.io.Serializable;

public class SerializableTest2 {
}


class A{

    protected String stringA;
    protected int intA;

    public A(){
        System.out.println("Default-Constructor class A");
    }

    public A(String a){
        System.out.println("Constructor class A");
    }

}

class B extends A{

    protected String stringB;
    protected String intB;

    public B(){
        System.out.println("Default-Constructor class B");
    }

    public B(String a){
        System.out.println("Constructor class B");
    }

}

class C extends B implements Serializable{

    private String stringC;
    private int intC;

    public C(String a) {
        System.out.println("Constructor C");
    }
}