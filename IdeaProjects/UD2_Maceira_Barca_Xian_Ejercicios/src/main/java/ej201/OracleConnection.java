package ej201;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "system";
        String password = "abc123.";
        return DriverManager.getConnection(url, user, password);
    }
}
