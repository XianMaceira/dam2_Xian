package ej203;

import java.sql.*;

public class CompletaTareas {
    public static void main(String[] args) {
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/libros", "root", "abc123.")) {



            insertarTarea(c, "Tarea1", "01/01/2024", "PENDIENTE");
            insertarTarea(c, "Tarea2", "02/01/2024", "PENDIENTE");
            insertarTarea(c, "Tarea3", "06/11/2022", "EN_PROCESO");
            insertarTarea(c, "Tarea4", "01/01/2019", "COMPLETADA");
            insertarTarea(c, "Tarea5", "01/01/2018", "PENDIENTE");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void insertarTarea(Connection connection, String descripcion, String fecha_creacion, String estado) throws SQLException {
        String sql = "INSERT INTO libros (descripcion, fecha_creacion, estado) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, descripcion);
            preparedStatement.setString(2, fecha_creacion);
            preparedStatement.setString(3, estado);
            preparedStatement.executeUpdate();
        }
    }
}
