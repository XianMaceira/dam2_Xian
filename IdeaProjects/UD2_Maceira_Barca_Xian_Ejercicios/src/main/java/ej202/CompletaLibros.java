package ej202;

import java.sql.*;

public class CompletaLibros {
    public static void main(String[] args) {
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/libros", "root", "abc123.")) {



            insertarLibro(c, "Cien años de soledad", "Gabriel García Márquez", 1967);
            insertarLibro(c, "1984", "George Orwell", 1949);
            insertarLibro(c, "El cuento de la criada", "Margaret Atwood ", 1985);
            insertarLibro(c, "El señor de los anillos", "J.R.R. Tolkien", 1954);
            insertarLibro(c, "Matar a un ruiseñor", "Harper Lee", 1960);

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
