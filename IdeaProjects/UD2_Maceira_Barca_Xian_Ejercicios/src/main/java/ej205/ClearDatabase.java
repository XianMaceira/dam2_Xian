package ej205;

import java.sql.SQLException;
import java.sql.Statement;

public class ClearDatabase {
    private DatabaseConnection databaseConnection;

    public ClearDatabase(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void clearData() {
        try (Statement statement = databaseConnection.getConnection().createStatement()) {
            statement.executeUpdate("DELETE FROM libros");
            statement.executeUpdate("DELETE FROM autores");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
