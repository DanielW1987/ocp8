package chapter7;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class BlockingDequeTest {

    public static void main(String... args){

        try{
            BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>();

            blockingDeque.offer(91);
            blockingDeque.offerFirst(5, 2, TimeUnit.MINUTES);
            blockingDeque.offerLast(47, 100, TimeUnit.MICROSECONDS);
            blockingDeque.offer(3, 4, TimeUnit.SECONDS);

            // Queue: 5, 91, 47, 3

            System.out.println(blockingDeque.poll());
            System.out.println(blockingDeque.poll(950, TimeUnit.MILLISECONDS));
            System.out.println(blockingDeque.pollFirst(100, TimeUnit.NANOSECONDS));
            System.out.println(blockingDeque.pollLast(1, TimeUnit.SECONDS));

            // Ausgabe: 5, 91, 47, 3
        }
        catch(InterruptedException e) {
            // handle
        }
    }

}
