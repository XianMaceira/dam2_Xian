package ej205;

import java.sql.SQLException;
import java.sql.Statement;

public class FillDatabase {
    private DatabaseConnection databaseConnection;

    public FillDatabase(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void insertData() {
        try (Statement statement = databaseConnection.getConnection().createStatement()) {
            // Insertar datos de ejemplo aquí
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

