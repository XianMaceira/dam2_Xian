import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        Scanner sc = new Scanner(System.in);
        int option = -1;
        while (option != 6) {
            printMenu();
            option = sc.nextInt();

            switch (option) {
                case 1:
                    app.printGames(false);
                    break;
                case 2:
                    app.printGames(true);
                    break;
                case 3:
                    app.addGame(sc);
                    break;
                case 4:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    app.removeGame(id);
                    break;
                case 5:
                    System.out.println("Exportando..");
                    app.exportGames();
                    break;
                case 6:
                    System.out.println("Saliendo..");
                    break;
                default:
                    System.out.println("Selección no válida: " + option);
            }
        }
    }

    private static void printMenu() {
        System.out.println("MENÚ");
        System.out.println("1. Mostrar xogos");
        System.out.println("2. Mostrar xogos eliminados");
        System.out.println("3. Engadir xogo");
        System.out.println("4. Eliminar xogo");
        System.out.println("5. Exportar xogos");
        System.out.println("6. Saír");
        System.out.print("Selección: ");
    }
}