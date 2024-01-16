package ej202;

import java.sql.*;


public class CrearTabla {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/libros", "root", "abc123.")) {
            Statement statement = connection.createStatement();
            String createTableQuery = "CREATE TABLE IF NOT EXISTS libros (id INT AUTO_INCREMENT PRIMARY KEY, titulo VARCHAR(255), autor VARCHAR(255), fecha_publicacion YEAR)";
            statement.executeUpdate(createTableQuery);
            System.out.println("Tabla 'libros' creada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
