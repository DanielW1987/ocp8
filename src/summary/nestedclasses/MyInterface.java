package summary.nestedclasses;

public interface MyInterface {

    int VERSION = 1;
    int OTHER = 2;
}

class MyClass implements MyInterface{

    int OTHER = 3;

    public static void main(String... args){

        MyClass a = new MyClass();
        System.out.println( MyInterface.VERSION );   // 1
        System.out.println(a.VERSION);               // 1
        System.out.println(a.OTHER);                 // 3
        System.out.println(((MyInterface)a).OTHER);  // 2
    }

}
