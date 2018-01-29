package chapter5.datetime;

import java.time.*;

public class DaylightSaving {

    public static void main( String... args ){

        // Zeitumstellung in Zone Europe/Berlin im Oktober von 3 Uhr auf 2 Uhr (Die Zeit von 2 bis 3 Uhr läuft 2 Mal)
        LocalDate date = LocalDate.of( 2017, 10, 29 );
        LocalTime time = LocalTime.of( 1,30,0 );
        ZoneId zoneEuropeBerlin  = ZoneId.of("Europe/Berlin");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(date, time, zoneEuropeBerlin);

        System.out.println("Zeitumstellung Europe/Berlin");
        System.out.println(zonedDateTime);  // 2017-10-29T01:30+02:00[Europe/Berlin]
        zonedDateTime = zonedDateTime.plusHours(1);
        System.out.println(zonedDateTime); // 2017-10-29T02:30+02:00[Europe/Berlin]
        zonedDateTime = zonedDateTime.plusHours(1);
        System.out.println(zonedDateTime); // 2017-10-29T02:30+01:00[Europe/Berlin]

        // Zeitumstellung in Zone US/Eastern im November von 2 Uhr auf 1 Uhr (Die Zeit von 1 bis 2 Uhr läuft 2 Mal)
        date = LocalDate.of( 2016, 11, 6 );
        time = LocalTime.of( 0,30,0 );
        ZoneId zoneUSEastern  = ZoneId.of("US/Eastern");
        zonedDateTime = ZonedDateTime.of(date, time, zoneUSEastern);

        System.out.println("Zeitumstellung US/Eastern");
        System.out.println(zonedDateTime);  // 2016-11-06T00:30-04:00[US/Eastern]
        zonedDateTime = zonedDateTime.plusHours(1);
        System.out.println(zonedDateTime); // 2016-11-06T01:30-04:00[US/Eastern]
        zonedDateTime = zonedDateTime.plusHours(1);
        System.out.println(zonedDateTime); // 2016-11-06T01:30-05:00[US/Eastern]

        /*
         * Am Tage des Vorstellens der Uhr existiert die Zeit zwischen 02:00 Uhr und 02:59 Uhr nicht.
         * Wird diese Uhrzeit explizit erzeugt, dann rollt Java automatisch um 1 Stunde vor.
         */
        date = LocalDate.of( 2017, 3, 26 );
        time = LocalTime.of( 2,30,0 );
        zonedDateTime = ZonedDateTime.of(date, time, zoneEuropeBerlin);

        System.out.println("Zeitvorstellung Europe/Berlin");
        System.out.println(zonedDateTime); // 2017-03-26T03:30+02:00[Europe/Berlin]

        /*
         * Daylight Saving und Period / Duration
         * Duration basiert auf Stunden.
         * Period basiert auf Tage.
         */
        // 1 Tag vor Zeitumstellung
        date = LocalDate.of( 2017, 10, 28 );
        time = LocalTime.of( 18,0,0 );
        zonedDateTime = ZonedDateTime.of(date, time, zoneEuropeBerlin);

        Period periodDuration = Period.ofDays(1);
        Duration timeDuration = Duration.ofDays(1);

        System.out.println("Daylight Saving - Period vs. Duration");
        System.out.println("plus Period: " + zonedDateTime.plus(periodDuration));
        System.out.println("plus Duration: " + zonedDateTime.plus(timeDuration));

    }
}