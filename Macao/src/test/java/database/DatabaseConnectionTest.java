package database;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {

    @Test
    void getConnection() throws SQLException {
        assert DatabaseConnection.getInstance().getConnection() != null;
    }

    @Test
    void getInstance() throws SQLException {
        assert DatabaseConnection.getInstance() != null;
    }
}