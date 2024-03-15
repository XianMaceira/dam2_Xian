package apartado4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection dbConnection = new DatabaseConnection("mysql", "localhost:3306/verbenas", "root", "abc123.");

        Database database = new Database(dbConnection);
        database.createDatabase();

        try (Connection cn = dbConnection.getConnection()){

            Scanner scanner = new Scanner(System.in);
            int option;
            do {
                showMenu();
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        Scanner sc = new Scanner(System.in);
                        System.out.println("Introduce os datos da verbena: ");
                        String lugar = sc.nextLine();
                        System.out.print("Data (DD/MM/YYYY): ");
                        String data = sc.nextLine();
                        System.out.print("Orquesta: ");
                        String orquesta = sc.nextLine();
                        añadirVerbena(cn, lugar, data, orquesta);
                        break;
                    case 2:
                        verVerbenas(cn);
                        break;
                    case 3:
                        System.out.print("Introduce o ID da verbena a actualizar: ");
                        int verbenaActualizar = scanner.nextInt();
                        actualizarVerbena(cn,verbenaActualizar);
                        break;
                    case 4:
                        // TODO
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
        dbConnection.closeConnection();

    }

    private static void actualizarVerbena(Connection cn, int verbenaActualizar) {
        String query = "UPDATE verbena SET lugar = ?, data = ?, orquesta = ? WHERE id = ?";

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce os datos da verbena: ");
        String lugar = sc.nextLine();
        System.out.print("Data (DD/MM/YYYY): ");
        String data = sc.nextLine();
        System.out.print("Orquesta: ");
        String orquesta = sc.nextLine();


        try(PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setString(1, lugar);
            ps.setString(2, data);
            ps.setString(3, orquesta);
            ps.setInt(4, verbenaActualizar);

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

    private static void verVerbenas(Connection cn) {
        String query = "SELECT * FROM verbenasy";
        try (PreparedStatement ps = cn.prepareStatement(query)){
            ResultSet rs = ps.executeQuery();

            System.out.println("Lista de verbenas");
            while (rs.next()) {
                int verbenaId = rs.getInt("id");
                String lugar= rs.getString("lugar");
                String data= rs.getString("data");
                String orquesta= rs.getString("orquesta");

                System.out.println("("+verbenaId+") "+data+" - "+lugar+" - "+orquesta);
                System.out.println();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void añadirVerbena(Connection cn, String lugar, String data, String orquesta) {
        String query = "INSERT INTO verbenas (lugar, data, orquesta) VALUES (?, ?, ?)";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setString(1, lugar);
            ps.setString(2, data);
            ps.setString(3, orquesta);
            ps.executeUpdate();
            System.out.println("Verbena engadida correctamente");
            System.out.println();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private static void showMenu() {
        System.out.println("1. Engadir verbena");
        System.out.println("2. Ver verbenas");
        System.out.println("3. Actualizar informacion dunha verbena");
        System.out.println("4. Eliminar verbena");
        System.out.println("5. Salir");

        System.out.print("introduce a opción a seleccionar: ");
        System.out.println();
    }
}
