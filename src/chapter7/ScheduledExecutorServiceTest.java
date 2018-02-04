package chapter7;

import java.time.LocalDateTime;
import java.util.concurrent.*;

public class ScheduledExecutorServiceTest {

    private static int counter = 0;

    public static void main(String... args) throws Exception{

        countdown();
        test();
    }

    private static void countdown() throws Exception{

        ScheduledExecutorService service   = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService countdown = Executors.newSingleThreadScheduledExecutor();

        try{
            countdown.scheduleWithFixedDelay(() -> System.out.println(counter++), 0, 1, TimeUnit.SECONDS);
            service.schedule(() -> System.out.println("Hello World!"), 3, TimeUnit.SECONDS);
            Future<Integer> result = service.schedule(() -> {System.out.println(10); return 10;}, 10, TimeUnit.SECONDS);

            //service.scheduleAtFixedRate(()-> System.out.println("Hello Daniel!"), 0, 2, TimeUnit.SECONDS);
            //service.scheduleWithFixedDelay(()-> System.out.println("Hallo Waginator!"), 3, 2, TimeUnit.SECONDS);
        }
        finally {
            service.shutdown();
        }

        service.awaitTermination(15, TimeUnit.SECONDS);
        if( service.isTerminated() ){
            countdown.shutdownNow();
        }

    }

    private static void test() throws Exception{

        // The period is shorter than the execution of the task
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate( () -> doSomeLongWork(), 0, 1, TimeUnit.SECONDS );

    }

    private static void doSomeLongWork(){
        try{
            Thread.sleep(2000);
            System.out.println(LocalDateTime.now());
        }
        catch(Exception e){
            // snh
        }
    }
}