package ej205;

import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private DatabaseConnection databaseConnection;

    public Database(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void createDatabase() {
        try (Statement statement = databaseConnection.getConnection().createStatement()) {
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS biblioteca");
            statement.executeUpdate("USE biblioteca");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
