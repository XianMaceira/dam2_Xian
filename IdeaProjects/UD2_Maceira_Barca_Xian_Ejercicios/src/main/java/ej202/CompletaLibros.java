package ej202;

import java.sql.*;

public class CompletaLibros {
    public static void main(String[] args) {
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/libros", "root", "abc123.")) {



            insertarLibro(c, "Título1", "Autor1", 2000);
            insertarLibro(c, "Título2", "Autor2", 2005);
            insertarLibro(c, "Título3", "Autor3", 2010);
            insertarLibro(c, "Título4", "Autor4", 2015);
            insertarLibro(c, "Título5", "Autor5", 2020);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void insertarLibro(Connection connection, String titulo, String autor, int fechaPublicacion) throws SQLException {
        String sql = "INSERT INTO libros (titulo, autor, fecha_publicacion) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, titulo);
            preparedStatement.setString(2, autor);
            preparedStatement.setInt(3, fechaPublicacion);
            preparedStatement.executeUpdate();
        }
    }
}
