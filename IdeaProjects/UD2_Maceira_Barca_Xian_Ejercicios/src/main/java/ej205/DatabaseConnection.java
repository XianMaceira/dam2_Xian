package ej205;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static void main(String[] args) throws SQLException {
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "abc123.");
    }
}
