package chapter5;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatTest {

    public static void main( String... args ){

        int amount = 1_500_999;
        double price = 9.99;
        float percentage = 0.89F;

        NumberFormat general        = NumberFormat.getInstance();
        NumberFormat numbers        = NumberFormat.getNumberInstance();
        NumberFormat moneyDE        = NumberFormat.getCurrencyInstance();
        NumberFormat moneyEN        = NumberFormat.getCurrencyInstance( Locale.US );
        NumberFormat percentages    = NumberFormat.getPercentInstance();
        NumberFormat integer        = NumberFormat.getIntegerInstance();

        System.out.println( "General" );
        System.out.println( general.format( amount ) );
        System.out.println( general.format( price ) );

        System.out.println( "Numbers" );
        System.out.println( numbers.format( amount ) );
        System.out.println( numbers.format( price ) );

        System.out.println( "Money" );
        System.out.println( moneyDE.format( amount ) );
        System.out.println( moneyDE.format( price ) );
        System.out.println( moneyEN.format( price ) );

        System.out.println( "Percentages" );
        System.out.println( percentages.format( percentage ) );
        System.out.println( percentages.format( price ) );

        System.out.println( "Integer" );
        System.out.println( integer.format( percentage ) );
        System.out.println( integer.format( price ) );

        String priceStringDE = "9,99 €";
        String priceStringEN = "$9.99";

        try{
            Number parsedPrice = moneyDE.parse(priceStringDE);
            System.out.println(parsedPrice);

            double parsedPriceInDouble = (Double) moneyEN.parse(priceStringEN);
            System.out.println(parsedPriceInDouble);
        }
        catch( ParseException pe ){
            System.out.println(pe.getStackTrace());
        }


    }
}
