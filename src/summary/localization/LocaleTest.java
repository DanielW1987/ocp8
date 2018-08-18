package summary.localization;

import java.util.Locale;

public class LocaleTest {

    public static void main( String... args ){

        // Default-Locale
        Locale locale = Locale.getDefault();
        System.out.println(locale); // de_DE

        // Local Constants
        locale = Locale.GERMAN;
        System.out.println(locale); // de

        locale = Locale.GERMANY;
        System.out.println(locale); // de_DE

        // Konstruktor
        locale = new Locale("de");
        System.out.println(locale); // de

        locale = new Locale("de", "DE");
        System.out.println(locale); // de_DE
        locale = new Locale("de", "de");
        System.out.println(locale);  // de_DE

        // Java erlaubt es, ungültige Locales zu erzeugen
        locale = new Locale("xx", "xx");
        System.out.println(locale);  // xx_XX

        // Builder
        locale = new Locale.Builder()
                           .setLanguage("de")
                           .setRegion("DE")
                           .build();

        // Factory Method
        locale = Locale.forLanguageTag("de");
        System.out.println(locale); // de

        locale = Locale.forLanguageTag("de_DE");
        System.out.println("Empty: " + locale); // de
    }
}
