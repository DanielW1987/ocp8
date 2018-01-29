package chapter7;

public class _1_CreateThreads {

    static final int MAX_ITERATION = 10_000;

    public static void main(String... args){

        Runnable r1 = () -> {
            for(int i = 0; i <= MAX_ITERATION; i++){
                System.out.println("r1: " + i);
            }
        };

        Runnable r2 = () -> {
            for(int i = 0; i <= MAX_ITERATION; i++){
                System.out.println("r2: " + i);
            }
        };

        // Via Runnable
        new Thread(r1).start();
        new Thread(r2).start();

        // Via Inheritence from Thread
        new MyThreadA("T1").start();
        new MyThreadA("T2").start();

    }
}

class MyThreadA extends Thread{

    public MyThreadA(String name){
        super(name);
    }

    @Override
    public void run() {
        for(int i = 0; i <= _1_CreateThreads.MAX_ITERATION; i++){
            System.out.println(getName() + ": " + i);
        }
    }

}