import java.io.File;
import java.util.HashMap;

public class App {
    private static final String PROJECT_PATH = new File("").getAbsolutePath();
    public static final String NEW_GAME_CHAR = "#";
    public static final String DELETED_GAME_STRING = "(X)";
    public static final byte[] DELETED_GAME_HEADER = new byte[]{(byte) 0xFF, (byte) 0x00};
    public static final byte[] GAME_HEADER = new byte[]{(byte) 0xFF, (byte) 0x01};
    private final File IMPORT_FILE = new File("import.txt");
    private HashMap<Integer, Game> games;

    public App() {
        games = FileHandler.importGames(IMPORT_FILE);
        FileHandler.exportGames(new File(PROJECT_PATH, "games"), games.values());
        ZIP.exportGames(new File(PROJECT_PATH, "games"));
    }
}
