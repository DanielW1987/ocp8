package chapter5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTimeFormatterTest {

    public static void main( String... args ){

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();

        System.out.println( date.format( DateTimeFormatter.ISO_LOCAL_DATE ) );          // 2017-04-17
        System.out.println( time.format( DateTimeFormatter.ISO_LOCAL_TIME ) );          // 14:52:14.6
        System.out.println( dateTime.format( DateTimeFormatter.ISO_LOCAL_DATE_TIME ) ); // 2017-04-17T14:52:14.6

        DateTimeFormatter shortDate = DateTimeFormatter.ofLocalizedDate( FormatStyle.SHORT );

        System.out.println( dateTime.format( shortDate ) );
        System.out.println( shortDate.format( date ) );

        DateTimeFormatter custom = DateTimeFormatter.ofPattern( "dd. MMMM yyyy, hh:mm:ss" );
        System.out.println( custom.format( dateTime ) );

    }
}
