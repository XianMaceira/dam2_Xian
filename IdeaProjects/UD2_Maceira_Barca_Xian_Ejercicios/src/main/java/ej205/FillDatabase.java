package ej205;

import java.sql.SQLException;
import java.sql.Statement;

public class FillDatabase {
    private DatabaseConnection databaseConnection;

    public FillDatabase(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void fillData() {
        try (Statement statement = databaseConnection.getConnection().createStatement()) {
            // Insertar autores
            statement.executeUpdate("INSERT INTO autores (nombre, apellidos) VALUES ('Autor1', 'Apellido1')");
            statement.executeUpdate("INSERT INTO autores (nombre, apellidos) VALUES ('Autor2', 'Apellido2')");
            statement.executeUpdate("INSERT INTO autores (nombre, apellidos) VALUES ('Autor3', 'Apellido3')");
            statement.executeUpdate("INSERT INTO autores (nombre, apellidos) VALUES ('Autor4', 'Apellido4')");
            statement.executeUpdate("INSERT INTO autores (nombre, apellidos) VALUES ('Autor5', 'Apellido5')");

            // Insertar libros
            statement.executeUpdate("INSERT INTO libros (titulo, autor_id, anio_publicacion) VALUES ('Libro1', 1, 2000)");
            statement.executeUpdate("INSERT INTO libros (titulo, autor_id, anio_publicacion) VALUES ('Libro2', 1, 2001)");
            statement.executeUpdate("INSERT INTO libros (titulo, autor_id, anio_publicacion) VALUES ('Libro3', 2, 2002)");
            statement.executeUpdate("INSERT INTO libros (titulo, autor_id, anio_publicacion) VALUES ('Libro4', 2, 2003)");
            statement.executeUpdate("INSERT INTO libros (titulo, autor_id, anio_publicacion) VALUES ('Libro5', 3, 2004)");
            statement.executeUpdate("INSERT INTO libros (titulo, autor_id, anio_publicacion) VALUES ('Libro6', 3, 2005)");
            statement.executeUpdate("INSERT INTO libros (titulo, autor_id, anio_publicacion) VALUES ('Libro7', 4, 2006)");
            statement.executeUpdate("INSERT INTO libros (titulo, autor_id, anio_publicacion) VALUES ('Libro8', 4, 2007)");
            statement.executeUpdate("INSERT INTO libros (titulo, autor_id, anio_publicacion) VALUES ('Libro9', 5, 2008)");
            statement.executeUpdate("INSERT INTO libros (titulo, autor_id, anio_publicacion) VALUES ('Libro10', 5, 2009)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
