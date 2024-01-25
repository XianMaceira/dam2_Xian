package ej202;

import java.sql.*;

public class ConsultaLibros {
    public static void main(String[] args) {
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/libros", "root", "abc123.")) {

            Statement stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM libros");
            System.out.println("Mostrar todos los libros");
            mostrarResultados(rs);
            System.out.println();

            ResultSet rs2 = stmt.executeQuery("SELECT * FROM libros WHERE autor = 'George Orwell'");
            System.out.println("Obtener los libros de un autor o autora determinada (George Orwell) .");
            mostrarResultados(rs2);
            System.out.println();

            ResultSet rs3 = stmt.executeQuery("SELECT * FROM libros WHERE fecha_publicacion < 1970");
            System.out.println("Obtener los libros posteriores a un año determinado");
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
            String titulo = resultSet.getString("titulo");
            String autor = resultSet.getString("autor");
            int fecha_publicacion = resultSet.getInt("fecha_publicacion");

            System.out.println("ID: " + id + ", Título: " + titulo + ", Autor: " + autor + ", Año de publicación: " + fecha_publicacion);
        }
    }
}

