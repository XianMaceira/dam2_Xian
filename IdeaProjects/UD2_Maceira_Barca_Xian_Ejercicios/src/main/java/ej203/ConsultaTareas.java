package ej203;

import java.sql.*;

public class ConsultaTareas {
    public static void main(String[] args) {
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tareas", "root", "abc123.")) {

            Statement stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM tareas");
            System.out.println("Mostrar todas las tareas");
            mostrarResultados(rs);
            System.out.println();

            ResultSet rs2 = stmt.executeQuery("SELECT * FROM tareas WHERE fecha_creacion > '2024-01-01'");
            System.out.println("Obtener las tareas creadas después de una fecha determinada (por ejemplo, después de 2024-01-01)");
            mostrarResultados(rs2);
            System.out.println();

            ResultSet rs3 = stmt.executeQuery("SELECT * FROM tareas WHERE estado = 'PENDIENTE'");
            System.out.println("Obtener las tareas con un estado determinado (por ejemplo, PENDIENTE)");
            mostrarResultados(rs3);
            System.out.println();

            rs.close();
            rs2.close();
            rs3.close();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void mostrarResultados(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String descripcion = resultSet.getString("descripcion");
            Date fechaCreacion = resultSet.getDate("fecha_creacion");
            String estado = resultSet.getString("estado");

            System.out.println("ID: " + id + ", Descripción: " + descripcion + ", Fecha de Creación: " + fechaCreacion + ", Estado: " + estado);
        }
    }
}