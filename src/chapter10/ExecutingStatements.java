package chapter10;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExecutingStatements {

    public static void main(String... args) throws Exception{

        Connection con = DatabaseConnection.connectViaDataSource();
        Statement stmt = con.createStatement();

        // Beispiel aus Buch S. 521: INSERT, UPDATE, DELETE
        int affectedRows = stmt.executeUpdate( "INSERT INTO species VALUES( 10, 'Deer', 3 )" );
        System.out.println( "INSERT: " + affectedRows + " rows are affected..." );
        affectedRows = stmt.executeUpdate( "UPDATE species SET name = '' WHERE name = 'None'" );
        System.out.println( "UPDATE: " + affectedRows + " rows are affected..." );
        affectedRows = stmt.executeUpdate( "DELETE FROM species WHERE id = 10" );
        System.out.println( "DELETE: " + affectedRows + " rows are affected..." );

        // Beispiel aus Buch S. 521: SELECT
        ResultSet rs = stmt.executeQuery( "SELECT * FROM species" );

        // will throw java.sql.SQLException: Can not issue data manipulation statements with executeQuery().
        // ResultSet rs = stmt.executeQuery( "DELETE FROM species WHERE id = 10" );

        // execute()
        // boolean isResultSet = stmt.execute( "SELECT * FROM species" );
        boolean isResultSet = stmt.execute( "DELETE FROM species WHERE id = 10" );
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
        }
    }
}
