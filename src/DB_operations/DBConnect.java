package DB_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DBConnect {
    private static String username = "sqlUser";
    private static String password = "Passw0rd!";
    private static final String protocol = "jdbc";
    private static final String vendor = ":mySQL:";
    private static final String location = "//localhost:3306/";
    private static final String databaseName = "client_schedule";
    private static final String url = protocol + vendor + location + databaseName + "?connectionTimeZone = SERVER";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    protected static Connection connection;

    public static void openConn() throws SQLException {
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Successful");
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}

