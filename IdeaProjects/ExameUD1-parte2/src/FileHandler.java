import java.io.*;
import java.util.*;


public class FileHandler {

    public static HashMap<Integer, Game> importGames (File dir) {
        HashMap<Integer, Game> gameFiles = new LinkedHashMap<>();

        int total = 0;
        int cargados = 0;
        int descartados;

        for (File file : dir.listFiles()) {
            total++;
            if (check(file, App.GAME_EXTENSION)) {
                cargados++;
                Game newgame = readAllGames(file);
                System.out.println(newgame);
                gameFiles.put(newgame.getId(), newgame);
            }
        }
        descartados = total - cargados;
        System.out.println("Xogos cargados: "+cargados);
        System.out.println("Xogos descartados: "+descartados);


        return gameFiles;
    }



    public static Game readAllGames (File file) {
        boolean del;

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))){
            byte[] readbyte = bis.readNBytes(App.GAME_HEADER.length);

            if (Arrays.compare(readbyte, App.GAME_HEADER) == 0) {
                del = false;

            }else if (Arrays.compare(readbyte, App.DELETED_GAME_HEADER)==1) {
                del = true;
            }else {
                return null;
            }



            ObjectInputStream ois = new ObjectInputStream(bis);
            return (Game) ois.readObject();


        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


   /* private boolean checkHeader(File file) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))){

            byte[] readBytes = bis.readNBytes(App.GAME_HEADER.length);

            if (readBytes == App.GAME_HEADER) {

            }

            *//*if (result==0) {
                return true;
            } else {
                return false;
            }*//*

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }*/

    public static void exportGames(File file, Collection<Game> games) {
        File binGame = new File(file, "export" + App.GAME_EXTENSION);

        if (binGame.exists()) {
            binGame.delete(); // Si ya se exporto, se borra para poder volver a exportar
        }

        for (Game game : games) {
            File dirGame = new File(file, String.valueOf(game.getId()));
            dirGame.mkdir();

            try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {

                if (!game.isDeleted()) {
                    binGame.createNewFile();
                    bos.write(App.GAME_HEADER);

                    ObjectOutputStream oos = new ObjectOutputStream(bos);
                    oos.writeObject(game);
                    oos.close();
                }


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static boolean check (File file, String name) {
        return file.getName().endsWith(name);
    }

    public static void changeGameHeader (File file, Game game, boolean del) {

    }



}
