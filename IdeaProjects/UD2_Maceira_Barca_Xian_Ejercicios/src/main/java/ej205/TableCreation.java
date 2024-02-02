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
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS autores (id INT PRIMARY KEY, nombre VARCHAR(255), apellidos VARCHAR(255))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS libros (id INT PRIMARY KEY, titulo VARCHAR(255), anio_publicacion INT, autor_id INT, FOREIGN KEY (autor_id) REFERENCES autores(id))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
