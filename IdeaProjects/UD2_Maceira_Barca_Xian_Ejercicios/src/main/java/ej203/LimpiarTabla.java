package ej203;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LimpiarTabla {
    public static void main(String[] args) {
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tareas", "root", "abc123.")) {

            limpiarTablaTareas(c);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void limpiarTablaTareas(Connection connection) throws SQLException {
        String sql = "DELETE FROM tareas";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        }
    }
}
