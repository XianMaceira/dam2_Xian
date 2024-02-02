package ej203;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultaTareas {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:tareas.sqlite";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM tareas;");

            rs = stmt.executeQuery("SELECT * FROM tareas WHERE fecha_creacion > '2022-01-02';");

            rs = stmt.executeQuery("SELECT * FROM tareas WHERE estado = 'PENDIENTE';");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
