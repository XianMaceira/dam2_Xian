package ej208;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    //cargarDesdeJSON();
                    break;
                case 2:
                  //  agregarCancion();
                    break;
                case 3:
                 //   agregarUsuario();
                    break;
                case 4:
                  //  crearListaReproduccion();
                    break;
                case 5:
                  //  agregarCancionALista();
                    break;
                case 6:
                  //  eliminarListaReproduccion();
                    break;
                case 7:
                  //  mostrarInformacion();
                    break;
                case 8:
                   // exportarAXML();
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor ingrese una opción válida.");
            }

        } while (opcion != 9);

        scanner.close();
    }

    static void mostrarMenu() {
        System.out.println("--- Menú ---");
        System.out.println("1. Cargar canciones y usuarios desde un fichero JSON");
        System.out.println("2. Agregar nueva canción");
        System.out.println("3. Agregar nuevo usuario");
        System.out.println("4. Crear lista de reproducción");
        System.out.println("5. Agregar canción a lista de reproducción");
        System.out.println("6. Eliminar lista de reproducción");
        System.out.println("7. Mostrar información de canciones, usuarios y listas de reproducción");
        System.out.println("8. Exportar datos a un fichero XML");
        System.out.println("9. Salir");
        System.out.print("Seleccione una opción: ");
    }
}

