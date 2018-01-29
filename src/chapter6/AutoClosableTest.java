package chapter6;

public class AutoClosableTest {

    public static void main(String... args){

        // Cage1
        try(Cage1 cage1 = new Cage1()){
            System.out.println("Cage 1");
        }

        // Cage 2
        try(Cage2 cage2 = new Cage2()){
            System.out.println("Cage 2");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Catch error in cage2");
        }

    }

}

class Cage1 implements AutoCloseable{

    @Override
    public void close(){
        System.out.println("Close cage 1");
    }

}

class Cage2 implements AutoCloseable{

    @Override
    public void close() throws Exception {
        System.out.println("Close cage 2");
        throw new Exception("Error");
    }

}