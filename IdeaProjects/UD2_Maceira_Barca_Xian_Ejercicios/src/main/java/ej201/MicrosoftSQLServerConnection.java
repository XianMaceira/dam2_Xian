package ej201;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MicrosoftSQLServerConnection {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlserver://localhost:1433";
        String user = "SA";
        String password = "Abc123.Abc123.";
        return DriverManager.getConnection(url, user, password);
    }
}
