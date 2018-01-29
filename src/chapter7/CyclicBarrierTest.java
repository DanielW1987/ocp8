package chapter7;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {

    private void removeAnimals(){
        System.out.println("Removing animals...");
    }

    private void cleanPen(){
        System.out.println("Cleaning pen...");
    }

    private void addAnimals(){
        System.out.println("Adding animals...");
    }

    void performTasks(CyclicBarrier c1, CyclicBarrier c2){
        try{
            removeAnimals();
            c1.await();
            cleanPen();
            c2.await();
            addAnimals();
        }catch( InterruptedException | BrokenBarrierException e){
            // handle
        }
    }

    public static void main(String... args){
        ExecutorService threadPool = null;
        try{
            CyclicBarrierTest cyclicBarrierTest = new CyclicBarrierTest();
            threadPool = Executors.newFixedThreadPool(4);

            CyclicBarrier c1 = new CyclicBarrier(4);
            CyclicBarrier c2 = new CyclicBarrier(4, () -> System.out.println("Cleaning complete..."));

            for(int i = 1; i <= 4; i++){
                threadPool.submit(()->cyclicBarrierTest.performTasks(c1, c2));
            }
        }
        finally {
            if(threadPool != null){
                threadPool.shutdown();
            }
        }
    }
}
