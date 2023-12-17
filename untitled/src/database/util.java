package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class util {
    public static Connection getConnection() {
        Connection c = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // Register SQL Server Driver
            String url = "jdbc:sqlserver://WINDOWS-11\\SQLEXPRESS:1433;databaseName=StudentManagement";
            String username = "sa";
            String password = "123456789";

            c = DriverManager.getConnection(url,username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return c;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null && !c.isClosed()) {
                c.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printInfo(Connection c) {
        if(c!=null) {
            try {
                System.out.println((c.getMetaData().toString()));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}