package service;


import java.sql.*;

public class JDBCConnection {

    static Connection conn;

    public JDBCConnection() {

    }

    public static Connection connectToDatabase() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException exc) {
            throw new RuntimeException(exc);
        }
        String url1 = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
        String password = "";

        try {
            conn = DriverManager.getConnection(url1, user, password);
            if (conn != null) {
                System.out.println("Connected to the database");
                return conn;
            }
        } catch (SQLException exc) {
            throw new RuntimeException(exc);
        }
        return null;
    }

}