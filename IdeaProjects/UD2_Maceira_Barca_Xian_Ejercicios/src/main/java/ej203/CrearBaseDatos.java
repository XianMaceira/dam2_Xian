package ej203;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class CrearBaseDatos {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:tareas.sqlite";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Conexión establecida a la base de datos.");

                Statement stmt = conn.createStatement();
                if (yaExisteLaBaseDeDatos(stmt)) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("La base de datos ya existe. ¿Desea borrarla y crear una nueva? (s/n): ");
                    String respuesta = scanner.nextLine().toLowerCase();

                    if (respuesta.equals("s")) {
                        borrarBaseDeDatos(stmt);
                        System.out.println("Base de datos existente borrada.");
                        crearBaseDeDatos(stmt);
                    } else {
                        System.out.println("Operación cancelada. La base de datos no ha sido modificada.");
                    }
                } else {
                    crearBaseDeDatos(stmt);
                    System.out.println("Base de datos creada exitosamente.");
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private static boolean yaExisteLaBaseDeDatos(Statement stmt) throws SQLException {
        String sql = "SELECT name FROM sqlite_master WHERE type='table' AND name='tareas';";
        return stmt.executeQuery(sql).next();
    }

    private static void borrarBaseDeDatos(Statement stmt) throws SQLException {
        String sql = "DROP TABLE IF EXISTS tareas;";
        stmt.execute(sql);
    }

    private static void crearBaseDeDatos(Statement stmt) throws SQLException {
        String sql = "CREATE TABLE tareas (\n"
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + "descripcion TEXT NOT NULL,\n"
                + "fecha_creacion TEXT NOT NULL,\n"
                + "estado TEXT NOT NULL\n"
                + ");";
        stmt.execute(sql);
    }
}
