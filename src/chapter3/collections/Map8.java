package chapter3.collections;

import java.util.*;

public class Map8 {

    public static void main( String... args ){

        /*
         * putIfAbsent
         * Fügt einen neuen KeyValue der Map hinzu. Der Value wird nicht hinzugefügt, wenn bereits
         * ein non-null Value in der Map existiert.
         * besteht. put() hingegen fügt den neuen Value immer hinzu und ersetzt ggf. einen bestehenden non-null Key.
         */
        Map<String, String> favorites = new HashMap<>();
        favorites.put( "Daniel", "Hühnchen" );
        favorites.put( "Tanja", "Schokolade" );
        favorites.put( "Michael", null );

        favorites.putIfAbsent( "Daniel", "Schwein" ); // Wird nicht hinzugefügt, da bereits ein non-null Value vorhanden
        favorites.putIfAbsent( "Michael", "Bratwurst" ); // Wird hinzugefügt, da Value null ist

        System.out.println(favorites);

        /*
         * merge
         * Beispiel 1
         */
        Map<String, List<String>> haustiere = new HashMap<>();
        List<String> dwg = new ArrayList<>();
        dwg.add("Hund");
        haustiere.put( "Daniel", dwg );

        List<String> dwg2 = new ArrayList<>();
        dwg2.add("Katze");
        dwg2.add("Hamster");

        // Daniel die neuen Haustiere hinzufügen
        haustiere.merge("Daniel", dwg2, (a, b) -> { a.addAll(b); return a; } );

        System.out.println(haustiere);

        /*
         * merge
         * Beispiel 2
         */
        Map<String, Long> prices = new HashMap<>();
        prices.put( "Fernseher", 150000L );
        prices.put( "Ultra HD Player", 75000L );

        prices.merge("Fernseher", 50000L, Long::sum );
        System.out.println(prices);

        /*
         * merge
         * Beispiel 3
         */
        prices.merge( "Ultra HD BluRay", 3000L, (oldValue, newValue) -> {
            // Dieser Teil wird nicht ausgeführt, da Key noch nicht in der Map vorhanden
            System.out.println( "old value: " + oldValue );
            System.out.println( "new value: " + newValue );
            return null;
        } );
        System.out.println(prices);

        /*
         * merge
         * Beispiel 4
         */
        Map<String, Integer> fruitPrices = new LinkedHashMap<>();

        fruitPrices.merge("fruits", 3, Integer::sum);
        fruitPrices.merge("fruits", 5, Integer::sum);
        System.out.println("Prices map: " + fruitPrices);

        // null removes mapping for the key:
        fruitPrices.merge("fruits", 7, (oldVal, newVal) -> {
            System.out.println("Old val:"+oldVal+","+ "new val:"+newVal);
            return null;
        });
        System.out.println("Prices map: " + fruitPrices);

        fruitPrices.put("Bread", null);
        System.out.println("Prices map: " + fruitPrices);
        // No need to handle initial null value:
        fruitPrices.merge("Bread", 42, Integer::sum);
        System.out.println("Prices map: " + fruitPrices);



    }
}
