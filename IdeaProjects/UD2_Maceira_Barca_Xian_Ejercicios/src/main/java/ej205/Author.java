package ej205;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Author {
    private DatabaseConnection databaseConnection;

    public Author(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void getAllAuthors() {
        try (Statement statement = databaseConnection.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM autores")) {

            while (resultSet.next()) {
                System.out.println("Nombre: " + resultSet.getString("nombre") +
                        ", Apellidos: " + resultSet.getString("apellidos"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAuthorsWithBookCount() {
        try (Statement statement = databaseConnection.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT autores.id, autores.nombre, autores.apellidos, COUNT(libros.id) AS cantidad_libros " +
                     "FROM autores LEFT JOIN libros ON autores.id = libros.autor_id " +
                     "GROUP BY autores.id, autores.nombre, autores.apellidos")) {

            while (resultSet.next()) {
                System.out.println("Nombre: " + resultSet.getString("nombre") +
                        ", Apellidos: " + resultSet.getString("apellidos") +
                        ", Cantidad de libros: " + resultSet.getInt("cantidad_libros"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
