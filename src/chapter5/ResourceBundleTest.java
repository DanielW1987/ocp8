package chapter5;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest {

    public static void main( String... args ){

        ResourceBundle rb_de = ResourceBundle.getBundle("chapter5.OCP", Locale.GERMAN);
        ResourceBundle rb_en = ResourceBundle.getBundle("chapter5.OCP", Locale.ENGLISH);
        ResourceBundle rb_fr = ResourceBundle.getBundle("chapter5.OCP", Locale.FRENCH);

        System.out.println(rb_de.getString("hello"));
        System.out.println(rb_en.getString("hello"));
        System.out.println(rb_fr.getString("hello"));

    }
}