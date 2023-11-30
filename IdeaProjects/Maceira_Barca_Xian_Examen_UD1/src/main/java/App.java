import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class App {

    private static final String PPATH = new File("").getAbsolutePath();

    public static char createNewGame = '#';
    public static String deletedGame = "(X)";

    public static final byte[] delGameHeader = new byte[] {(byte)0xFF, (byte)0x01};

    public static final byte[] NONdelGameHeader = new byte[] {(byte)0xFF, (byte)0x00};
    private List<Game> games;
    public App() {



        games = FileHandler.importAllGames(new File("import.txt"));
    /*    for (Game game : games) {
            System.out.println(game.getId());
            System.out.println(game.getPublisher());
            System.out.println(game.getTitle());
            System.out.println(game.getYear());
        }*/
        FileHandler.exportAllGames(new File(PPATH, "games"), games);
        XML.exportGamesToXML(this, new File(PPATH+"\\result", ".xml"), games);
        JSON.exportAllGamesJSON(this, games, new File(PPATH+"\\result", "json"));

    }


}
