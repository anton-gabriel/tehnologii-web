package database;

import java.sql.*;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;
    private String url = "jdbc:postgresql://localhost:5432/ticketing";
    private String username = "postgres";
    private String password = "123456";

    private DatabaseConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }

        return instance;
    }
}
