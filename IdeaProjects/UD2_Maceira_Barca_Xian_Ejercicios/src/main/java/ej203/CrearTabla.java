package ej203;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTabla {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/libros", "root", "abc123.")) {
            Statement statement = connection.createStatement();
            String createTableQuery = "CREATE TABLE IF NOT EXISTS tareas (id INT AUTO_INCREMENT PRIMARY KEY, descripcion VARCHAR(255), fecha_creacion DATETIME, estado ENUM('PENDIENTE', 'EN_PROCESO', 'COMPLETADA'))";
            statement.executeUpdate(createTableQuery);
            System.out.println("Tabla 'tareas' creada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
