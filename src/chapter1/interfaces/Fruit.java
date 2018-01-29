package chapter1.interfaces;

interface Eatable{

    int types = 10;
}

class Food implements Eatable {

    public static int types = 20;
}

public class Fruit extends Food implements Eatable{  //LINE1

    public static void main(String[] args) {
        // types = 30; // Reference is ambiguous
        // System.out.println(types); // Reference is ambiguous
    }
}