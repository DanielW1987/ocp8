package chapter1;

enum Y{ // only 1 public top level declaration per file is allowed
    Y1, Y2, Y3;

    static int i = 1;
    final static int j = 1;
    private Y(){
        // int a = i; // it's not allowed to access non-final static fields
        int b = j;
    }

    public void doSomething(){}
}

public class EnumTest {

    public enum X{X1, X2, X3}

    public EnumTest(){

        System.out.println(X.X1 + " "+Y.Y1);

    }

    public static void main(String... args){
        new EnumTest();
    }
}
