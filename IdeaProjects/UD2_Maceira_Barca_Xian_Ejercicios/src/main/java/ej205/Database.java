package ej205;

import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private DatabaseConnection databaseConnection;

    public Database(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void createDatabase(boolean deleteExisting) {
        try (Statement statement = databaseConnection.getConnection().createStatement()) {
            if (deleteExisting) {
                statement.executeUpdate("DROP DATABASE IF EXISTS biblioteca");
            }
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS biblioteca");
            statement.executeUpdate("USE biblioteca");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
