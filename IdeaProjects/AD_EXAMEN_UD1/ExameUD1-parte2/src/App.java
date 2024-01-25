import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static final String PROJECT_PATH = new File("").getAbsolutePath();
    public static final byte[] DELETED_GAME_HEADER = new byte[]{(byte) 0xFF, (byte) 0x00};
    public static final byte[] GAME_HEADER = new byte[]{(byte) 0xFF, (byte) 0x01};
    public static final String GAME_EXTENSION = ".game";
    public static final String EXPORTED_GAMES_FILE = "export.games";
    private static final File GAMES_DIR = new File(PROJECT_PATH, "games");
    private HashMap<Integer, Game> games;

    public App() {
        // APARTADO 1
        games = FileHandler.importGames(GAMES_DIR);
    }

    // APARTADO 2 Y 3
    public void printGames(boolean deleted) {
        if (games.size() == 0) {
            System.out.println("Non hay xogos para mostrar");
            return;
        }
        for (Game g : games.values()) {
            if (g.isDeleted() == deleted) {
                System.out.println(g.print());
            }
        }
    }

    // APARTADO 4
    public void addGame(Scanner sc) {
        int id;
        String title;
        String publisher;
        int year;
        System.out.println("ENGADIR XOGO");
        System.out.print("ID: ");
        id = sc.nextInt();
        sc.nextLine();
        System.out.print("Title: ");
        title = sc.nextLine();
        System.out.print("Publisher: ");
        publisher = sc.nextLine();
        System.out.print("Year: ");
        year = sc.nextInt();
        sc.nextLine();
        Game game = new Game(id, title, publisher, year);
        games.put(id, game);
        System.out.println("XOGO ENGADIDO");
        FileHandler.exportGame(GAMES_DIR, game);
    }

    // APARTADO 5
    public void removeGame(int id) {
        if (games.get(id) == null) {
            System.out.println("Non existe un xogo con ese ID");
        } else {
            Game game = games.get(id);
            game.setDeleted(true);
            FileHandler.exportGame(GAMES_DIR, game);
            System.out.println("Xogo eliminado correctamente");
        }
    }

    // APARTADO 6
    public void exportGames() {
        ArrayList<Game> games = new ArrayList<>();
        for (Game g : this.games.values()) {
            if (!g.isDeleted()) {
                games.add(g);
            }
        }
        FileHandler.exportGames(GAMES_DIR, games);
        System.out.println("Exportáronse os xogos");
    }
}
