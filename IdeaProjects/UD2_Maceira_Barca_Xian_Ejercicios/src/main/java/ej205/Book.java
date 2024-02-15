package ej205;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Book {
    private DatabaseConnection databaseConnection;

    public Book(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void getAllBooks() {
        try (Statement statement = databaseConnection.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT libros.titulo, autores.nombre, autores.apellidos, libros.anio_publicacion FROM libros JOIN autores ON libros.autor_id = autores.id")) {

            while (resultSet.next()) {
                System.out.println("Título: " + resultSet.getString("titulo") +
                        ", Autor: " + resultSet.getString("nombre") + " " + resultSet.getString("apellidos") +
                        ", Año de publicación: " + resultSet.getInt("anio_publicacion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getBooksByAuthor(String authorName, String authorLastName) {
        try (Statement statement = databaseConnection.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT libros.titulo, autores.nombre, autores.apellidos, libros.anio_publicacion " +
                     "FROM libros JOIN autores ON libros.autor_id = autores.id " +
                     "WHERE autores.nombre = '" + authorName + "' AND autores.apellidos = '" + authorLastName + "'")) {

            while (resultSet.next()) {
                System.out.println("Título: " + resultSet.getString("titulo") +
                        ", Autor: " + resultSet.getString("nombre") + " " + resultSet.getString("apellidos") +
                        ", Año de publicación: " + resultSet.getInt("anio_publicacion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
