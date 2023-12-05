import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class App {

    private static final String PROJECT_PATH = new File("").getAbsolutePath();

    public static final byte[] GAME_HEADER = new byte[]{(byte) 0xFF, (byte) 0x01};

    public static final String GAME_EXTENSION = ".game";
    public static final byte[] DELETED_GAME_HEADER = new byte[]{(byte) 0xFF, (byte) 0x00};
    private HashMap<Integer, Game> games;

    public App() {
        games = FileHandler.importGames(new File(PROJECT_PATH));
    }

    public void showNonDeletedGames() {
//        games.put(333, new Game(333, "GTA V", "Rockstar", 2012, false));

        if (games.size() == 0) {
            System.out.println("Non hai xogos para mostrar.");
            return;
        }
        for (Game game : games.values()) {
            if (!game.isDeleted()) {
                System.out.println("[" + game.getId() + "] " + game.getTitle() + " (" + game.getYear() + ") - " + game.getPublisher());
            }
        }
    }

    public void showDeletedGames() {
        if (games.size() == 0) {
            System.out.println("Non hai xogos para mostrar.");
            return;
        }
        for (Game game : games.values()) {
            if (game.isDeleted()) {
                System.out.println("[" + game.getId() + "] " + game.getTitle() + " (" + game.getYear() + ") - " + game.getPublisher());
            }
        }
    }

    public void addGame(Scanner scanner) {
        int id;
        String title;
        String publisher;
        int year;

        System.out.println("Añadir juego");
        System.out.print("Id: ");
        id = scanner.nextInt();


        System.out.print("Titulo: ");
        title = scanner.nextLine();


        System.out.print("Distribuidora: ");
        publisher = scanner.nextLine();


        System.out.print("Año: ");
        year = scanner.nextInt();

        Game game = new Game(id, title, publisher, year);

    }

    public void deleteGame(int gameId) {
        if (!games.keySet().equals(gameId)) {
            System.out.println("Non existe un xogo con ese ID");
        } else {
            games.remove(gameId);

        }
    }

    public void exportGames() {
        FileHandler.exportGames(new File(PROJECT_PATH), games.values());
    }

}
