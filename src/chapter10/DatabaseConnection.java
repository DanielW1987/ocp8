package chapter10;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    public static void main(String... args) throws FileNotFoundException, IOException{

        Connection con1 = connectViaDriverManager();
        System.out.println(con1);
        Connection con2 = connectViaDataSource();
        System.out.println(con2);

    }

    public static Connection connectViaDriverManager(){

        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/zoo", "root", "")){
            return con;
        }
        catch(SQLException e){
            System.err.println(e);
            return null;
        }
    }

    public static Connection connectViaDataSource() throws FileNotFoundException, IOException{

        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("src/chapter10/files/db.properties");
        props.load(fis);

        MysqlDataSource mySQLDataSource = new MysqlDataSource();
        mySQLDataSource.setPassword(props.getProperty("MY_SQL_PASSWORD"));
        mySQLDataSource.setUser(props.getProperty("MY_SQL_USERNAME"));
        mySQLDataSource.setDatabaseName(props.getProperty("MY_SQL_DBNAME"));
        mySQLDataSource.setServerName(props.getProperty("MY_SQL_SERVERNAME"));
        try {
            return mySQLDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}