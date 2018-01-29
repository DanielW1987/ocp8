package chapter5.localization;

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

        // Factory Method
        locale = Locale.forLanguageTag("de");
        System.out.println(locale); // de
    }
}
