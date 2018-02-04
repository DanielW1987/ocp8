package chapter3.collections;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueTest {

    public static void main(String... args){

        Queue myQueue = new ArrayDeque();

        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
        myQueue.add(5);

        System.out.println(myQueue.peek());
        System.out.println(myQueue.peek()); // Entnimmt immer das erste Element, Rückgabe ist 2 Mal '1'

    }
}