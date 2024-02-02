package ej203;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CompletaTareas {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:tareas.sqlite";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            String[] tareas = {
                    "INSERT INTO tareas (descripcion, fecha_creacion, estado) VALUES ('Tarea 1', '2022-01-01', 'PENDIENTE');",
                    "INSERT INTO tareas (descripcion, fecha_creacion, estado) VALUES ('Tarea 2', '2022-01-02', 'EN_PROCESO');",
                    "INSERT INTO tareas (descripcion, fecha_creacion, estado) VALUES ('Tarea 3', '2022-01-03', 'COMPLETADA');",
                    "INSERT INTO tareas (descripcion, fecha_creacion, estado) VALUES ('Tarea 4', '2022-01-04', 'PENDIENTE');",
                    "INSERT INTO tareas (descripcion, fecha_creacion, estado) VALUES ('Tarea 5', '2022-01-05', 'EN_PROCESO');"
            };

            for (String tarea : tareas) {
                stmt.execute(tarea);
            }

            System.out.println("Tareas de ejemplo insertadas exitosamente.");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}

