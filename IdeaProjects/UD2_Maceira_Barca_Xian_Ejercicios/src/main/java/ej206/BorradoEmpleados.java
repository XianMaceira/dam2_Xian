package ej206;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BorradoEmpleados {
    private static final String DB_URL = "jdbc:mysql://localhost/empleados";
    private static final String USER = "root";
    private static final String PASSWORD = "abc123.";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el número del empleado que deseas borrar:");
        int numEmpleado = scanner.nextInt();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String query = "DELETE FROM emp WHERE numemp = ?";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setInt(1, numEmpleado);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Empleado con número " + numEmpleado + " fue borrado exitosamente.");
                } else {
                    System.out.println("No se encontró ningún empleado con el número " + numEmpleado + ".");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al intentar borrar el empleado: " + e.getMessage());
        }
    }
}

