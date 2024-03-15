package apartado3;

import java.sql.*;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        try (Connection cn = DriverManager.getConnection("jdbc:sqlite:todo.db")){
            createTables(cn);

            Scanner scanner = new Scanner(System.in);
            int option;
            do {
                showMenu();
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        Scanner sc = new Scanner(System.in);
                        System.out.print("Introduce a descripción tarefa: ");
                        String tarea = sc.nextLine();
                        añadirTarea(cn, tarea);
                        break;
                    case 2:
                        verTareas(cn);
                        break;
                    case 3:
                        System.out.println("Introduce a tarefa para marcar como completada: ");
                        int taskCompleted = scanner.nextInt();
                        marcarComoCompletada(cn, taskCompleted);
                        break;
                    case 4:
                        System.out.println("Introduce a tarefa á cal desexas modificarlle a prioridade: ");
                        int taskModified = scanner.nextInt();
                        System.out.println("Introduce a prioridade que lle queres asignar: ");
                        int taskPriority = scanner.nextInt();
                        cambiarPrioridad(cn, taskModified, taskPriority);
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } while (option != 5);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static void createTables(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS tasks (" +
                    "id INTEGER AUTO_INCREMENT PRIMARY KEY," +
                    "taskDescription VARCHAR(50) NOT NULL," +
                    "completed INTEGER DEFAULT 0," +
                    "priority INTEGER NOT NULL)");
        }
    }

    private static void showMenu() {
        System.out.println("1. Engadir tarefa");
        System.out.println("2. Ver tarefas");
        System.out.println("3. Marcar tarefa como completada");
        System.out.println("4. Cambiar a prioridade dunha tarefa");
        System.out.println("5. Salir");

        System.out.print("introduce a opción a seleccionar: ");
        System.out.println();
    }

    private static void añadirTarea(Connection con, String tarea) {

        String query = "INSERT INTO tasks (taskDescription, priority) VALUES (?, ?)";
        int prioridad = setPrioridad(con);
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, tarea);
            ps.setInt(2, prioridad);
            ps.executeUpdate();
            System.out.println("Tarefa engadida correctamente");
            System.out.println();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static int setPrioridad(Connection con) {
        String query = "SELECT MAX(priority) as priority FROM tasks";
        int prioridad;
        try (PreparedStatement ps = con.prepareStatement(query)){
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                prioridad = rs.getInt("priority")+1;
                if (prioridad==0) {
                    prioridad = 1;
                }
                return prioridad;
            }else {
                return 1;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static void verTareas(Connection cn) {
        String query = "SELECT id, taskDescription FROM tasks ORDER BY priority";
        try (PreparedStatement ps = cn.prepareStatement(query)){
            ResultSet rs = ps.executeQuery();


            System.out.println("Lista de tarefas");
            while (rs.next()) {
                int taskId = rs.getInt("id");
                String description = rs.getString("taskDescription");

                System.out.println(taskId + ". " + description);
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void marcarComoCompletada(Connection cn, int task) {
        String query = "UPDATE tasks SET compledted = 1 WHERE id = ?";

        try(PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setInt(1, task);

            int tareasCompletadas = ps.executeUpdate();

            if (tareasCompletadas > 0) {
                System.out.println("Tarefa marcada como completada.");
            } else {
                System.err.println("Tarefa non atopada");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    private static void cambiarPrioridad(Connection cn, int taskModified, int taskPriority) {
        String query = "UPDATE tasks SET priority = ? WHERE id = ?";

        try(PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setInt(1, taskPriority);
            ps.setInt(2, taskModified);

            int tareasModificadas = ps.executeUpdate();

            if (tareasModificadas > 0) {
                System.out.println("Tarefa modificada con Exito.");
            } else {
                System.err.println("Tarefa non atopada");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }




}
