import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        int opcion = 0;
        Scanner sc = new Scanner(System.in);



        while (opcion != 6) {
            System.out.println();
            System.out.println("MENÚ");
            System.out.println();
            System.out.println("Mostrar xogos");
            System.out.println("Mostrar eliminados");
            System.out.println("Engadir xogo");
            System.out.println("Exportar xogo");
            System.out.println("Saír");

            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    app.showNonDeletedGames();
                    break;
                case 2:
                    app.showDeletedGames();
                    break;
                case 3:
                    app.addGame(sc);
                    break;
                case 4:
                    System.out.println("Introduce la id del juego que quieres eliminar");
                    int id = sc.nextInt();
                    app.deleteGame(id);
                    break;
                case 5:
                    app.exportGames();
                    break;
                case 6:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Esa opción no es válida");
            }


        }
    }
}