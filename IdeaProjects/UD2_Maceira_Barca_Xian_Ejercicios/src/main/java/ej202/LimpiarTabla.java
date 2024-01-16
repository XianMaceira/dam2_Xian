package ej202;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LimpiarTabla {
    public static void main(String[] args) {
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tu_base_de_datos", "root", "abc123.")) {

            limpiarTablaLibros(c);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void limpiarTablaLibros(Connection connection) throws SQLException {
        String sql = "DELETE FROM libros";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        }
    }
}

