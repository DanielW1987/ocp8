package chapter7;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServicePool {

    private static int counter = 0;

    public static void main(String... args) throws Exception{

        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);

        try{
            service.scheduleWithFixedDelay(() -> System.out.println(counter++), 0, 1, TimeUnit.SECONDS);
            service.schedule(() -> System.out.println("Hello World!"), 3, TimeUnit.SECONDS);
            Future<Integer> result = service.schedule(() -> {System.out.println("-" + 10 + "-"); return 10;}, 10, TimeUnit.SECONDS);
        }
        finally {
            Thread.sleep(10000);
            service.shutdown();
        }
    }
}