package ej205;

import java.sql.SQLException;
import java.sql.Statement;

public class TableCreation {
    private DatabaseConnection databaseConnection;

    public TableCreation(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void createTables() {
        try (Statement statement = databaseConnection.getConnection().createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS autores (id INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(255), apellidos VARCHAR(255))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS libros (id INT AUTO_INCREMENT PRIMARY KEY, titulo VARCHAR(255), autor_id INT, anio_publicacion INT, FOREIGN KEY (autor_id) REFERENCES autores(id))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
