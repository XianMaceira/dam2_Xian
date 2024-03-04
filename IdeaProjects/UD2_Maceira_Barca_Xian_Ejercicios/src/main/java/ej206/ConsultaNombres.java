package ej206;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ConsultaNombres {
    private static final String DB_URL = "jdbc:mysql://localhost/empleados";
    private static final String USER = "root";
    private static final String PASSWORD = "abc123.";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la letra inicial para la consulta de nombres:");
        String letraInicial = scanner.nextLine();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String query = "SELECT nomemp FROM emp WHERE nomemp LIKE ?";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setString(1, letraInicial + "%");
                ResultSet resultSet = statement.executeQuery();
                System.out.println("Empleados cuyos nombres comienzan con '" + letraInicial + "':");
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("nomemp"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar nombres: " + e.getMessage());
        }
    }
}


