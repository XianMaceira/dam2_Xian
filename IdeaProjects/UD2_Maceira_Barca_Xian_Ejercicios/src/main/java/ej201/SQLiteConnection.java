package ej201;

import java.sql.*;

public class SQLiteConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:app.db";
        return DriverManager.getConnection(url);
    }
}