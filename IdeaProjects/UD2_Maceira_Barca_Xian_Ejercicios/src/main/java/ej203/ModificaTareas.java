package ej203;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ModificaTareas {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:tareas.sqlite";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            String modificarDescripcion = "UPDATE tareas SET descripcion = 'Nueva descripción' WHERE id = 1;";
            stmt.execute(modificarDescripcion);

            String modificarEstado = "UPDATE tareas SET estado = 'EN_PROCESO' WHERE id = 2;";
            stmt.execute(modificarEstado);

            String eliminarTarea = "DELETE FROM tareas WHERE id = 3;";
            stmt.execute(eliminarTarea);

            String eliminarCompletadas = "DELETE FROM tareas WHERE estado = 'COMPLETADA';";
            stmt.execute(eliminarCompletadas);

            System.out.println("Modificaciones realizadas exitosamente.");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
