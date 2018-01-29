package chapter7;

import javax.swing.*;
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class LoggingInQueue{

    // private static final BlockingQueue<String> messages = new LinkedBlockingQueue<String>();
    private static final BlockingQueue<String> messages = new ArrayBlockingQueue<String>(5);

    private static class MessageOutputter extends Thread {

        @Override public void run() {
            while ( true ) {
                try {
                    Thread.sleep(3000);
                    long startTime = System.currentTimeMillis();
                    System.out.printf("%s (Wartete %d ms)%n",
                            //messages.poll(),
                            messages.poll(1000, TimeUnit.MILLISECONDS),
                            System.currentTimeMillis() - startTime);
                }
                catch (InterruptedException e) {
                    System.out.println("Catched");
                }
            }
        }
    }

    private static class UserMessageProducer extends Thread {

        @Override public void run() {
            for( int i = 0; ; i++ ) {
                messages.add("msg " + i + " " + JOptionPane.showInputDialog("Meldung eingeben"));
            }
        }
    }

    private static class DiskspaceMessageProducer extends Thread {

        @Override public void run() {
            for( int i = 0; ; i++ ) {
                String dir = System.getProperty( "user.dir" );
                messages.add( "spc " + i + " " + new File( dir ).getFreeSpace() );
                try { TimeUnit.SECONDS.sleep( 1 ); }
                catch ( InterruptedException e ) { }
            }
        }
    }

    public static void main( String[] args ) {
        new MessageOutputter().start();
        new UserMessageProducer().start();
        new DiskspaceMessageProducer().start();
    }
}