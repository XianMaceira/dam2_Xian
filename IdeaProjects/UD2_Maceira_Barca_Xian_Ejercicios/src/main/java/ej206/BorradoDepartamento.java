package ej206;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BorradoDepartamento {
    private static final String DB_URL = "jdbc:mysql://localhost/empleados";
    private static final String USER = "root";
    private static final String PASSWORD = "abc123.";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el número del departamento que deseas borrar:");
        int numDepartamento = scanner.nextInt();
        String deleteEmpleadosQuery = "DELETE FROM emp WHERE numdep = ?";
        String deleteDepartamentoQuery = "DELETE FROM depto WHERE numdep = ?";


        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {

            try (PreparedStatement deleteEmpleadosStatement = conn.prepareStatement(deleteEmpleadosQuery);
                 PreparedStatement deleteDepartamentoStatement = conn.prepareStatement(deleteDepartamentoQuery)) {

                deleteEmpleadosStatement.setInt(1, numDepartamento);
                deleteDepartamentoStatement.setInt(1, numDepartamento);

                int empDeleted = deleteEmpleadosStatement.executeUpdate();
                int deptoDeleted = deleteDepartamentoStatement.executeUpdate();

                if (empDeleted > 0 || deptoDeleted > 0) {
                    System.out.println("Borrado satisfactorio");
                } else {
                    System.err.println("No se encontro el departamento");
                }
            }


        } catch (SQLException e) {
            System.err.println("Error al intentar borrar el departamento: " + e.getMessage());
        }
    }


}
