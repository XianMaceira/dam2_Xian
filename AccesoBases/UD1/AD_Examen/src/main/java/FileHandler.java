import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class FileHandler {
    // APARTADO 1
    public static HashMap<Integer, Game> importGames(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            ArrayList<Game> games = new ArrayList<>();
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.contains(App.NEW_GAME_CHAR)) {
                    Game game = new Game();
                    game.setDeleted(linea.contains(App.DELETED_GAME_STRING));
                    game.setId(Integer.parseInt(reader.readLine()));
                    game.setTitle(reader.readLine());
                    game.setPublisher(reader.readLine());
                    game.setYear(Integer.parseInt(reader.readLine()));
                    games.add(game);
                    System.out.println("~~~ JUEGO CARGADO ~~~");
                    System.out.println(game);
                }
            }
            HashMap<Integer, Game> gamesHashMap = new LinkedHashMap<>();
            for (Game g : games) {
                gamesHashMap.put(g.getId(), g);
            }
            // DESCOMENTAR PARA BORRAR EL FICHERO DESPUES DE LEERLO
            //file.deleteOnExit();
            return gamesHashMap;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // APARTADO 2
    public static void exportGames(File dir, Collection<Game> games) {
        if (dir.isFile()) {
            return;
        }

        if (dir.exists()) {
            deleteFolder(Path.of(dir.getPath()));
        }
        dir.mkdir();

        System.out.println("\nSe están exportando los juegos...");
        for (Game g : games) {
            File dirGame = new File(dir, String.valueOf(g.getId()));
            dirGame.mkdir();
            File txtGame = new File(dirGame, g.getId() + ".txt");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(txtGame))) {
                txtGame.createNewFile();
                writer.write(g.exportTxt());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            File binGame = new File(dirGame, g.getId() + ".game");
            FileOutputStream fos;
            ObjectOutputStream ois;
            try {
                fos = new FileOutputStream(binGame, true);
                if (g.isDeleted()) {
                    fos.write(App.DELETED_GAME_HEADER);
                } else {
                    fos.write(App.GAME_HEADER);
                }

                ois = new ObjectOutputStream(fos);
                ois.writeObject(g);

                ois.close();
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        int totalGames = games.size();
        int deletedGames = 0;
        for (Game g : games) {
            if (g.isDeleted()) {
                deletedGames++;
            }
        }
        // APARTADO 3
        File xmlFile = new File(dir, "result.xml");
        XML.exportGames(xmlFile, games, totalGames, deletedGames);

        // APARTADO 4
        File jsonFile = new File(dir, "result.json");
        JSON.exportGames(jsonFile, games, totalGames, deletedGames);
    }

    private static void deleteFolder(Path folderPath) {
        try {
            Files
                    .walk(folderPath)
                    .sorted(Comparator.reverseOrder())
                    .forEach(path -> {
                        try {
                            Files.delete(path);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            System.err.println("No se ha podido eliminar: " + folderPath);
            e.printStackTrace();
        }
    }
}

























