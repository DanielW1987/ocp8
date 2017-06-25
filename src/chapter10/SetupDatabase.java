package chapter10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SetupDatabase {

    public static void main(String[] args) throws Exception {
        //String url = "jdbc:derby:zoo;create=true";
        String url = "jdbc:mysql://localhost:3306/zoo";
        try (Connection conn = DriverManager.getConnection(url, "root", "");
             Statement stmt = conn.createStatement()) {

            // Tabellen löschen, falls sie bereits existieren
            stmt.executeUpdate("DROP TABLE animal");
            stmt.executeUpdate("DROP TABLE species");

            // Tabelle 'species' erzeugen
            stmt.executeUpdate("CREATE TABLE species ("
                    + "id INTEGER PRIMARY KEY, "
                    + "name VARCHAR(255), "
                    + "num_acres DECIMAL)");

            // Tabelle 'animal' erzeugen
            stmt.executeUpdate("CREATE TABLE animal ("
                    + "id INTEGER PRIMARY KEY, "
                    + "species_id integer REFERENCES species (id), "
                    + "name VARCHAR(255), "
                    + "date_born TIMESTAMP)");

            // Datensätze einfügen
            stmt.executeUpdate("INSERT INTO species VALUES (1, 'African Elephant', 7.5)");
            stmt.executeUpdate("INSERT INTO species VALUES (2, 'Zebra', 1.2)");
            stmt.executeUpdate("INSERT INTO animal VALUES (1, 1, 'Elsa', '2001-05-06 02:15:00')");
            stmt.executeUpdate("INSERT INTO animal VALUES (2, 2, 'Zelda', '2002-08-15 09:12:00')");
            stmt.executeUpdate("INSERT INTO animal VALUES (3, 1, 'Ester', '2002-09-09 10:36:00')");
            stmt.executeUpdate("INSERT INTO animal VALUES (4, 1, 'Eddie', '2010-06-08 01:24:00')");
            stmt.executeUpdate("INSERT INTO animal VALUES (5, 2, 'Zoe', '2005-11-12 03:44:00')");

            // Beispiel aus Buch S. 521: INSERT, UPDATE, DELETE
            int affectedRows = stmt.executeUpdate( "INSERT INTO species VALUES( 10, 'Deer', 3 )" );
            System.out.println( "INSERT: " + affectedRows + " rows are affected..." );
            affectedRows = stmt.executeUpdate( "UPDATE species SET name = '' WHERE name = 'None'" );
            System.out.println( "UPDATE: " + affectedRows + " rows are affected..." );
            affectedRows = stmt.executeUpdate( "DELETE FROM species WHERE id = 10" );
            System.out.println( "DELETE: " + affectedRows + " rows are affected..." );

            // Beispiel aus Buch S. 521: SELECT
            //ResultSet rs = stmt.executeQuery( "SELECT * FROM species" );
            ResultSet rs = stmt.executeQuery( "DELETE FROM species WHERE id = 10" );

            // execute()
            boolean isResultSet = stmt.execute( "SELECT * FROM species" );
            if(isResultSet){
                ResultSet rs1 = stmt.getResultSet();
                System.out.println("statement has a result set...");

                // Rückgabe ist -1, wenn SQL-Abfrage ein ResultSet zurückgibt
                int result = stmt.getUpdateCount();
                System.out.println( result + " rows affected..." );
            }
            else{
                int result = stmt.getUpdateCount();
                System.out.println( result + " rows affected..." );

                // Statement gibt ein leeres ResultSet zurück, wenn bspw. ein UPDATE ausgeführt wurde
                ResultSet rs1 = stmt.getResultSet();
                System.out.println("statement has a result set...");
            }

        }
    }

}
