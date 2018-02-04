package summary.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class MarkTest {

    public static void main(String[] args) throws Exception {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("c:/temp/marktest.txt")))){

            // reads and prints BufferedReader
            System.out.println((char)br.read()); // A
            System.out.println((char)br.read()); // B
            System.out.println((char)br.read()); // C
            br.mark(1); // Mark position 'D'
            System.out.println((char)br.read()); // D
            br.skip(2);                       // E and F are skipped
            System.out.println((char)br.read()); // G
            System.out.println((char)br.read()); // H
            br.reset();
            System.out.println((char)br.read()); // D
            System.out.println((char)br.read()); // E
            System.out.println((char)br.read()); // F
            br.reset();
            System.out.println((char)br.read()); // D
            System.out.println((char)br.read()); // E
            System.out.println((char)br.read()); // F

        }
    }
}