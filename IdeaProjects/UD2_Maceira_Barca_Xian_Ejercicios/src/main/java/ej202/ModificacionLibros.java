package ej202;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModificacionLibros {
    public static void main(String[] args) {
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/libros", "root", "abc123.")) {

            modificarTituloLibro(c, 1, "Nuevo Título");

            modificarAutorLibro(c, 2, "Nuevo Autor");

            modificarAnioPublicacionLibro(c, 3, 2025);

            eliminarLibro(c, 4);

            eliminarLibrosAnterioresA(c, 2010);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void modificarTituloLibro(Connection connection, int idLibro, String nuevoTitulo) throws SQLException {
        String sql = "UPDATE libros SET titulo = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nuevoTitulo);
            preparedStatement.setInt(2, idLibro);
            preparedStatement.executeUpdate();
        }
    }

    private static void modificarAutorLibro(Connection connection, int idLibro, String nuevoAutor) throws SQLException {
        String sql = "UPDATE libros SET autor = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nuevoAutor);
            preparedStatement.setInt(2, idLibro);
            preparedStatement.executeUpdate();
        }
    }

    private static void modificarAnioPublicacionLibro(Connection connection, int idLibro, int nuevoAnio) throws SQLException {
        String sql = "UPDATE libros SET fecha_publicacion = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, nuevoAnio);
            preparedStatement.setInt(2, idLibro);
            preparedStatement.executeUpdate();
        }
    }

    private static void eliminarLibro(Connection connection, int idLibro) throws SQLException {
        String sql = "DELETE FROM libros WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, idLibro);
            preparedStatement.executeUpdate();
        }
    }

    private static void eliminarLibrosAnterioresA(Connection connection, int fecha) throws SQLException {
        String sql = "DELETE FROM libros WHERE fecha_publicacion < ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, fecha);
            preparedStatement.executeUpdate();
        }
    }
}
