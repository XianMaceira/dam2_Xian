import java.io.*;
import java.util.*;

public class FileHandler {

    public static List<Game> importAllGames(File file) {
        ArrayList<Game> gameArrayList;
        String currLine;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            gameArrayList = new ArrayList<>();

            while ((currLine = br.readLine()) != null) {
                if (currLine.charAt(0) == App.createNewGame) {
                    Game game = new Game();
                    game.setId(Integer.parseInt(br.readLine()));
                    game.setTitle(br.readLine());
                    game.setPublisher(br.readLine());
                    game.setYear(Integer.parseInt(br.readLine()));
                    if (currLine.contains(App.deletedGame)) {
                        game.setDeleted(true);
                    } else {
                        game.setDeleted(false);
                    }
                }
                HashMap<Integer, Game> gamesHM = new LinkedHashMap<>();
                for (Game game : gameArrayList) {
                    gamesHM.put(game.getId(), game);
                }

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return gameArrayList;
    }


    public static void exportAllGames (File file, Collection<Game> games) {

        if (!file.exists()) {
            file.mkdir();
        } else {
            file.delete();
            file.mkdir();
        }

        for (Game game : games) {
            File gameFile = new File(String.valueOf(game.getId()));
            gameFile.mkdir();
            File gameFileTxt = new File(gameFile, ".txt");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(gameFileTxt))){

                gameFileTxt.createNewFile();

                bw.write(game.getId());
                bw.newLine();
                bw.write(game.getTitle());
                bw.newLine();
                bw.write(game.getPublisher());
                bw.newLine();
                bw.write(game.getYear());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            File gameFileBinary = new File(gameFile, ".game");
            try {
                FileOutputStream binaryWritter = new FileOutputStream(gameFileBinary);

                if (game.isDeleted()) {
                    binaryWritter.write(App.delGameHeader);
                } else {
                    binaryWritter.write(App.NONdelGameHeader);
                }



            } catch (IOException e) {
                System.out.println("No se puede crear el archivo.");
            }



        }

    }




}
