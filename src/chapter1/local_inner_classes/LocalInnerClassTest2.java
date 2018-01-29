package chapter1.local_inner_classes;

public class LocalInnerClassTest2 {

    public void test(){

        // Access modifier not allowed for local inner classes
        // public class Inner{}

        // static not allowed for local inner classes
        // static class Inner{}

        class Inner{

            private int i = 1;
            // private static int j  = 2; // static member not allowed, also static inner classes

            // static methods not allowed
            // public static void print(){}

            // member classes are allowed, but should package-private
            class ClassA{}

        }
    }
}
