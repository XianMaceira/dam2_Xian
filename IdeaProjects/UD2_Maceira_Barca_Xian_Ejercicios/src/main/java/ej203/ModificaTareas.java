package ej203;

import java.sql.*;
public class ModificaTareas {
    public static void main(String[] args) {
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tareas", "root", "abc123.")) {

            modificarDescripcionTarea(c, 1, "Nueva Descripción");

            modificarEstadoTarea(c, 2, "EN_PROCESO");

            eliminarTarea(c, 3);

            eliminarTareasCompletadas(c);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void modificarDescripcionTarea(Connection connection, int idTarea, String nuevaDescripcion) throws SQLException {
        String sql = "UPDATE tareas SET descripcion = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nuevaDescripcion);
            preparedStatement.setInt(2, idTarea);
            preparedStatement.executeUpdate();
        }
    }

    private static void modificarEstadoTarea(Connection connection, int idTarea, String nuevoEstado) throws SQLException {
        String sql = "UPDATE tareas SET estado = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nuevoEstado);
            preparedStatement.setInt(2, idTarea);
            preparedStatement.executeUpdate();
        }
    }

    private static void eliminarTarea(Connection connection, int idTarea) throws SQLException {
        String sql = "DELETE FROM tareas WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, idTarea);
            preparedStatement.executeUpdate();
        }
    }

    private static void eliminarTareasCompletadas(Connection connection) throws SQLException {
        String sql = "DELETE FROM tareas WHERE estado = 'COMPLETADA'";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        }
    }
}