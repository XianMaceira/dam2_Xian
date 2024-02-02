package ej203;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LimpiarTabla {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:tareas.sqlite";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            String limpiarTabla = "DELETE FROM tareas;";
            stmt.execute(limpiarTabla);

            System.out.println("Registros de la tabla tareas eliminados exitosamente.");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
