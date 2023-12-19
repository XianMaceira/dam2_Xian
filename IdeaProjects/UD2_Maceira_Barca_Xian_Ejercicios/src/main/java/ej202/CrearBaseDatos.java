package ej202;

import java.sql.*;
import java.util.Scanner;

public class CrearBaseDatos {
    public static void main(String[] args) {
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "abc123.")) {
            Statement stmt = c.createStatement();

            // Verificar si la base de datos ya existe
            ResultSet rs = stmt.executeQuery("SHOW DATABASES LIKE 'libros'");
            if (rs.next()) {
                System.out.println("¿Deseas eliminar la base de Datos y crearla de nuevo? 1. Sí   2. No");
                Scanner sc = new Scanner(System.in);
                int res = sc.nextInt();
                if (res == 1) {
                    // Eliminar la base de datos existente
                    stmt.executeUpdate("DROP DATABASE libros");

                    // Crear la base de datos nuevamente
                    stmt.executeUpdate("CREATE DATABASE libros");
                } else {
                    System.out.println("Base de datos no eliminada.");
                }
            } else {
                // La base de datos no existe, crearla
                stmt.executeUpdate("CREATE DATABASE libros");
            }

            // Cerrar la conexión
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
