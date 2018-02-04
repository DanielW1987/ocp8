package chapter5.localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest {

    public static void main( String... args ){

        ResourceBundle rb_de = ResourceBundle.getBundle("chapter5.localization.OCP", Locale.GERMAN);
        ResourceBundle rb_en = ResourceBundle.getBundle("chapter5.localization.OCP", Locale.ENGLISH);
        ResourceBundle rb_fr = ResourceBundle.getBundle("chapter5.localization.OCP", Locale.FRENCH);
        ResourceBundle rb_zh = ResourceBundle.getBundle("chapter5.localization.OCP", Locale.CHINESE);

        System.out.println(rb_de.getString("hello"));
        System.out.println(rb_en.getString("hello"));
        System.out.println(rb_fr.getString("hello"));
        System.out.println(rb_zh.getString("hello"));

    }
}