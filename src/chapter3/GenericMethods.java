package chapter3;

public class GenericMethods {

    public static void main( String args ){

        // Aufruf der Methode
        String a = GenericMethods.<String>getT( "Hallo" );

        // Der generische Typ muss beim Aufruf nicht vorangestellt sein
        GenericMethods.doNothing("Hallo");
        String b = GenericMethods.getT( "Hallo" );
    }

    public static <T> T getT( T t ){
        return t;
    }

    public static <T> void doNothing( T t ){
        System.out.println("do nothing");
    }

    // Bei nicht-statischen Methoden muss es ebenfalls gemacht werden
    public <T> T getOtherT( T t ){
        return t;
    }

    // Kompiliert nicht
    // public static void compile( T t ){}

}
