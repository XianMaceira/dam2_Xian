package ej205;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private Connection connection;

    public DatabaseConnection(String engine, String url, String user, String password) {
        try {
            if (engine.equalsIgnoreCase("mysql")) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String mysqlUrl = "jdbc:mysql://" + url;
                this.connection = DriverManager.getConnection(mysqlUrl, user, password);
            } else if (engine.equalsIgnoreCase("sqlite")) {
                Class.forName("org.sqlite.JDBC");
                String sqliteUrl = "jdbc:sqlite:" + url;
                this.connection = DriverManager.getConnection(sqliteUrl);
            } else {
                throw new IllegalArgumentException("Engine not supported: " + engine);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
