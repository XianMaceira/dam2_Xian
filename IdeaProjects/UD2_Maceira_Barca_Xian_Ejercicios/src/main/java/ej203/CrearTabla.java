package ej203;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTabla {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:tareas.sqlite";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS tareas (\n"
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + "descripcion TEXT NOT NULL,\n"
                    + "fecha_creacion TEXT NOT NULL,\n"
                    + "estado TEXT NOT NULL\n"
                    + ");";

            stmt.execute(sql);

            System.out.println("Tabla tareas creada exitosamente.");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}

