import java.io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class FileHandler {
    // APARTADO 1
    public static HashMap<Integer, Game> importGames(File gamesDir) {
        HashMap<Integer, Game> games = new LinkedHashMap<>();
        int loaded = 0;
        int notLoaded = 0;
        for (File f : gamesDir.listFiles()) {
            if (accept(f, App.GAME_EXTENSION)) {
                Game newGame = readGame(f);
                if (newGame != null) {
                    games.put(newGame.getId(), newGame);
                    loaded++;
                } else {
                    notLoaded++;
                }
            }
        }

        System.out.println("Xogos cargados: " + loaded);
        System.out.println("Xogos descartados: " + notLoaded);
        return games;
    }

    // APARTADO 1
    private static Game readGame(File gameFile) {
        try (BufferedInputStream bif = new BufferedInputStream(new FileInputStream(gameFile))) {
            byte[] readBytes = bif.readNBytes(App.GAME_HEADER.length);
            boolean deletedGame;
            if (Arrays.compare(readBytes, App.GAME_HEADER) == 0) {
                deletedGame = false;
            } else if (Arrays.compare(readBytes, App.DELETED_GAME_HEADER) == 0) {
                deletedGame = true;
            } else {
                return null;
            }
            ObjectInputStream ois = new ObjectInputStream(bif);
            Game game = (Game) ois.readObject();
            game.setDeleted(deletedGame);
            ois.close();
            return game;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // APARTADO 1: Comprobar extensión del fichero
    public static boolean accept(File dir, String name) {
        return dir.getName().endsWith(name);
    }

    // APARTADO 4 Y 5
    public static void exportGame(File gamesDir, Game game) {
        File newGameBin = new File(gamesDir, game.getId() + App.GAME_EXTENSION);
        if (newGameBin.exists()) {
            newGameBin.delete();
        }
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newGameBin, true))) {
            newGameBin.createNewFile();
            if (game.isDeleted()) {
                bos.write(App.DELETED_GAME_HEADER);
            } else {
                bos.write(App.GAME_HEADER);
            }
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(game);
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // APARTADO 6
    public static void exportGames(File parent, ArrayList<Game> games) {
        File gamesBin = new File(parent, App.EXPORTED_GAMES_FILE);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(gamesBin))) {
            oos.writeObject(games);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
