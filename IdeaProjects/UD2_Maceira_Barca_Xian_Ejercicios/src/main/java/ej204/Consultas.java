package ej204;

import java.sql.*;

public class Consultas {
    public static void main(String[] args) {
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/empleados", "root", "abc123.")) {

            Statement stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM empleados");
            System.out.println("1).Mostrar todas las empleados");
            System.out.println();

            rs.close();

            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}