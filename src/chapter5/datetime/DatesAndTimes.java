package chapter5.datetime;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DatesAndTimes {

    public static void main( String... args ) {

        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(ZonedDateTime.now());

        // Method chaining
        LocalDateTime dateTime = LocalDateTime.now()
                                              .plusYears(1)
                                              .plusMonths(5)
                                              .plusHours(12);

        System.out.println(dateTime);

        // Mögliche TimeZones ermitteln
        ZoneId.getAvailableZoneIds().stream()
                                    .filter( zone -> zone.contains( "US" ) )
                                    .sorted()
                                    .forEach(System.out::println);

        // Period testen
        LocalDate start = LocalDate.now();
        LocalDate end   = LocalDate.now()
                                   .plusYears(1);
        Period period   = Period.of( 0,2,4 );
        periodTest(start, end, period);

        // String-Repräsentation von Period
        System.out.println( "ofMonths(3): " + Period.ofMonths(3) ); //P3M
        System.out.println( "of(0, 20, 47): " + Period.of(0, 20, 47) ); //P20M47D
        System.out.println( "ofWeeks(3): " + Period.ofWeeks(3) ); //P21D

        // Duration
        LocalDate localDate         = LocalDate.now();
        LocalTime localTime         = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        Duration duration           = Duration.ofHours(5);

        System.out.println("Heute + 5h: " + localTime.plus(duration));
        System.out.println("Heute + 5h: " + localDateTime.plus(duration));
        System.out.println(Duration.ofSeconds(61));
        // System.out.println(localDate.plus(duration)); // UnsupportedTemporalException

        LocalTime now = LocalTime.now();
        Duration threeDays = Duration.ofDays(3);
        System.out.println("Jetzt +3Tage: " + now.plus(threeDays));
        // System.out.println("Jetzt +3Tage: " + localDate.plus(threeDays)); //UnsupportedTemporalException

        // ChronoUnit for Differences
        LocalTime one  = LocalTime.of( 5,00 );
        LocalTime two  = LocalTime.of( 6,59 );
        LocalDate date = LocalDate.now();
        System.out.println(ChronoUnit.HOURS.between(one, two)); // Ergebnis ist 1, Minuten werden abgeschnitten
        System.out.println(ChronoUnit.MINUTES.between(one, two)); // 119
        // System.out.println(ChronoUnit.MINUTES.between(one, date)); // DateTimeException

    }


    static void periodTest( LocalDate start, LocalDate end, Period period ){

        LocalDate upTo = start;
        while( upTo.isBefore(end) ){

            System.out.println( "Hello World" );
            upTo = upTo.plus(period);

        }
    }
}