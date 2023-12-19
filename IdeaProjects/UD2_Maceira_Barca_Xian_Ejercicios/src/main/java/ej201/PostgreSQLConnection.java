package ej201;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLConnection {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/";
        String user = "postgres";
        String password = "abc123.";
        return DriverManager.getConnection(url, user, password);
    }
}
