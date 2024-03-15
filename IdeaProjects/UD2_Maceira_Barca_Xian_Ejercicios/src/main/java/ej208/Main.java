package ej208;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import static ej208.CreateTables.createTables;
import static ej208.loadFromJSON.loadFromJSON;
import static ej208.addToDatabase.*;


public class Main {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:gestionMusica.db")) {
            createTables(connection);

            Scanner scanner = new Scanner(System.in);
            int option;
            do {
                showMenu();
                System.out.print("Selecciona una opción: ");
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        loadFromJSON();
                        break;
                    case 2:
                        addUser();
                        break;
                    case 3:
                        addSong();
                        break;
                    case 4:
                        createPlaylist();
                        break;
                    case 5:
                        addSongToPlaylist();
                        break;
                    case 6:
                        deletePlaylist();
                        break;
                    case 7:
                        showInfo();
                        break;
                    case 8:
                        exportToXML();
                        break;
                    case 9:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } while (option != 9);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    static void showMenu() {
        System.out.println("--- Menú ---");
        System.out.println("1. Cargar canciones y usuarios desde un fichero JSON");
        System.out.println("2. Agregar nuevo usuario");
        System.out.println("3. Agregar nueva cancion");
        System.out.println("4. Crear lista de reproducción");
        System.out.println("5. Agregar canción a lista de reproducción");
        System.out.println("6. Eliminar lista de reproducción");
        System.out.println("7. Mostrar información de canciones, usuarios y listas de reproducción");
        System.out.println("8. Exportar datos a un fichero XML");
        System.out.println("9. Salir");
        System.out.print("Seleccione una opción: ");
    }
}

