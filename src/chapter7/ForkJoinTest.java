package chapter7;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * Es sollen 10 Tiere gewogen werden.
 * Angenommen 1 Thread benötigt eine Minute zum Wiegen von drei Tieren und die 10 Tiere sollen innerhalb von 1 Minute
 * gewogen sein, ist offensichtlich, dass 1 Thread alleine diese Aufgabe nicht übernehmen kann. Die Aufgabe des Wiegens
 * wird daher rekursiv in Einzelaufgaben zerlegt und von Worker-Threads bearbeitet. Die Anzahl der Einzelaufgaben ist
 * weit größer als die Anzahl der verwendeten Threads.
 */
public class ForkJoinTest {

    public static void main(String... args) throws Exception{

        Double[] weights = new Double[10];
        MyRecursiveAction action = new MyRecursiveAction(0, weights.length, weights);
        ForkJoinPool myForkJoinPool = new ForkJoinPool();
        myForkJoinPool.invoke(action); // blockiert so lange bis das Ergebnis vorliegt

        System.out.println(Arrays.asList(weights).stream().mapToDouble(e -> e).sum());

        RecursiveTask<Double> task = new MyRecursiveTask(0, weights.length, weights);
        ForkJoinTask<Double> result = myForkJoinPool.submit(task);
        System.out.println("Gewicht in Summe: " + result.get());

    }
}

class MyRecursiveAction extends RecursiveAction{

    private int start;
    private int end;
    private Double[] weights;

    public MyRecursiveAction(int start, int end, Double[] weights) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }

    @Override
    protected void compute() {
        if( (end - start) <= 3 ){
            for(int index = start; index < end; index++){
                weights[index] = (double) new Random().nextInt(100);
                System.out.println("Animal weighted: " + index);
            }
        }
        else{
            int middle = start + (end - start) / 2;
            invokeAll(new MyRecursiveAction(start, middle, weights)
                    , new MyRecursiveAction(middle, end, weights));
        }
    }
}

class MyRecursiveTask extends RecursiveTask<Double> {

    private int start;
    private int end;
    private Double[] weights;

    public MyRecursiveTask(int start, int end, Double[] weights) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }

    @Override
    protected Double compute() {
        double sum = 0;
        if( (end - start) <= 3 ){
            for(int index = start; index < end; index++){
                weights[index] = (double) new Random().nextInt(100);
                System.out.println("Animal weighted: " + index);
                sum += weights[index];
            }
        }
        else{
            int middle = start + (end - start) / 2;
            RecursiveTask<Double> forkedTask = new MyRecursiveTask(start, middle, weights);
            forkedTask.fork();
            return new MyRecursiveTask(middle, end, weights).compute() + forkedTask.join();
        }

        return sum;
    }
}