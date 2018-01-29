package chapter10;

import java.sql.*;

public class ReadingResultSets {

    public static void main(String... args) throws Exception{

        // Forward-only ResultSet
        Connection con = DatabaseConnection.connectViaDataSource();
        Statement stmt = con.createStatement();
        ResultSet rs   = stmt.executeQuery("SELECT * FROM animal");

        System.out.println("Forward-only ResultSet");
        while(rs.next()){
            int id = rs.getInt(1);
            int species_id = rs.getInt("species_id");
            String name = rs.getString(3);
            Date dateBorn = rs.getDate("date_born");
            Time timeBorn = rs.getTime("date_born");
            Timestamp timestamp = rs.getTimestamp("date_born");

            System.out.println(dateBorn.toLocalDate());
            System.out.println(timeBorn.toLocalTime());
            System.out.println(timestamp.toLocalDateTime());

            System.out.println(id + " " + species_id + " " + name + " " + dateBorn);
        }

        // Scrollable ResultSet
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs2 = stmt.executeQuery("Select * FROM species");

        System.out.println("Scrollable ResultSet");
        while(rs2.next()){
            int id      = (Integer) rs2.getObject("id");
            String name = rs2.getString(2);
            System.out.println(id + " " + name);
        }

        System.out.println("absolute(0): " + rs2.absolute(0));
        System.out.println("absolute(3): " + rs2.absolute(3));
        System.out.println("absolute(4): " + rs2.absolute(4));
        System.out.println("absolute(-1): " + rs2.absolute(-1));
        System.out.println("absolute(-2): " + rs2.absolute(-2));
        System.out.println("absolute(-3): " + rs2.absolute(-3));
        System.out.println("absolute(-4): " + rs2.absolute(-4));

    }
}
