package ej206;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BorrardoDepartamento {
    private static final String DB_URL = "jdbc:mysql://localhost/empleados";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el número del departamento que deseas borrar:");
        int numDepartamento = scanner.nextInt();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String query = "DELETE FROM emp WHERE numdep = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, numDepartamento);
            statement.executeUpdate();

            query = "DELETE FROM depto WHERE numdep = ?";
            statement = conn.prepareStatement(query);
            statement.setInt(1, numDepartamento);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Departamento con número " + numDepartamento + " y sus empleados asociados fueron borrados exitosamente.");
            } else {
                System.out.println("No se encontró ningún departamento con el número " + numDepartamento + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

