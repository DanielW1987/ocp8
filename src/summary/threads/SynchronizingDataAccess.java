package summary.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizingDataAccess {

    private int sheepCount = 0;
    private AtomicInteger atomicSheepCount = new AtomicInteger(0);

    private void countAndPrint(){
        System.out.print(++sheepCount + " ");
    }

    private void countAndPrintAtomically(){
        System.out.print(atomicSheepCount.incrementAndGet() + " ");
    }

    private void countAndPrintSynchronizeBlock(){
        synchronized(this){
            System.out.print(++sheepCount + " ");
        }
    }

    private synchronized void countAndPrintSynchronizeMethod(){
        System.out.print(++sheepCount + " ");
    }

    public static void main( String... args ) throws Exception{

        SynchronizingDataAccess manager            = new SynchronizingDataAccess();
        ExecutorService pool                       = Executors.newFixedThreadPool(2);

        // unsortiert und Inkonsistenzen möglich
        for(int index = 0; index < 20; index++){
            pool.submit( () -> manager.countAndPrint());
        }

        Thread.sleep(1000);
        System.out.println();

        // unsortiert, aber keine Inkonsistenzen möglich
        for(int index = 0; index < 20; index++){
            pool.submit( () -> manager.countAndPrintAtomically());
        }

        Thread.sleep(1000);
        manager.sheepCount = 0;
        System.out.println();

        // sortiert und keine Inkonsistenzen
        for(int index = 0; index < 20; index++){
            pool.submit( () -> manager.countAndPrintSynchronizeBlock());
        }

        Thread.sleep(1000);
        manager.sheepCount = 0;
        System.out.println();

        // sortiert und keine Inkonsistenzen
        for(int index = 0; index < 20; index++){
            pool.submit( () -> manager.countAndPrintSynchronizeMethod());
        }

        Thread.sleep(1000);
        pool.shutdown();
    }
}
