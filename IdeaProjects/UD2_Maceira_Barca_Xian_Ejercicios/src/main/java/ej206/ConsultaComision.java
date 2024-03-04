package ej206;

import java.sql.*;
import java.util.Scanner;

public class ConsultaComision {
    private static final String DB_URL = "jdbc:mysql://localhost/empleados";
    private static final String USER = "root";
    private static final String PASSWORD = "abc123.";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el valor de la comisión para la consulta:");
        double comision = scanner.nextDouble();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String query = "SELECT nomemp FROM emp WHERE comision = ?";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setDouble(1, comision);
                ResultSet resultSet = statement.executeQuery();
                System.out.println("Empleados con comisión de " + comision + ":");
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("nomemp"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar comisiones: " + e.getMessage());
        }
    }
}
