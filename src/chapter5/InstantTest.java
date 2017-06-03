package chapter5;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class InstantTest {

    public static void main( String... args ){

        LocalDate date = LocalDate.of( 2017, 10, 29 );
        LocalTime time = LocalTime.of( 2,30,0 );
        ZoneId zoneId  = ZoneId.of("Europe/Berlin");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(date, time, zoneId);

        System.out.println(zonedDateTime);  // 2017-10-29T02:30+02:00[Europe/Berlin]

        zonedDateTime = zonedDateTime.plusHours(1);

        System.out.println(zonedDateTime); // 2017-10-29T02:30+02:00[Europe/Berlin]


        /*
         * Am Tage des Vorstellens der Uhr existiert die Zeit zwischen 02:00 Uhr und 02:59 Uhr nicht.
         * Wird diese Uhrzeit explizit erzeugt, dann rollt Java automatisch um 1 Stunde vor.
         */
        date = LocalDate.of( 2017, 3, 26 );
        time = LocalTime.of( 2,30,0 );
        zonedDateTime = ZonedDateTime.of(date, time, zoneId);

        System.out.println(zonedDateTime); // 2017-03-26T03:30+02:00[Europe/Berlin]

    }
}
