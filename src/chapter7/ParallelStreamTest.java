package chapter7;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ParallelStreamTest {

    public static void main(String... args){

        List<Integer> data      = new ArrayList<>();
        ParallelStreamTest test = new ParallelStreamTest();

        for(int i = 0; i < 1000; i++){
            data.add(i);
        }

        ZonedDateTime startSequentially = ZonedDateTime.now();
        test.processDataSequentially(data);
        ZonedDateTime endSequentially = ZonedDateTime.now();
        long secondsSequentially = ChronoUnit.SECONDS.between(startSequentially, endSequentially);
        System.out.println("Duration sequentially: " + secondsSequentially + " sec.");

        ZonedDateTime startParallel = ZonedDateTime.now();
        test.processDataParallel(data);
        ZonedDateTime endParallel = ZonedDateTime.now();
        long secondsParallel = startParallel.until(endParallel, ChronoUnit.SECONDS);
        System.out.println("Duration parallel: " + secondsParallel + " sec.");

    }

    long processDataSequentially(List<Integer> data){
        return data.stream().map(e -> processRecord(e)).count();
    }

    long processDataParallel(List<Integer> data){
        return data.parallelStream().map(e -> processRecord(e)).count();
    }

    int processRecord(int input){
        try{
            Thread.sleep(10);
        }
        catch(InterruptedException ie){
            System.out.println(ie);
        }

        return input + 1;
    }
}