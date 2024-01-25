import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class JSON {
    public static void exportGames(File outputFile, Collection<Game> games, int totalGames, int deletedGames) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("total", totalGames);
        jsonObject.addProperty("deleted", deletedGames);

        JsonArray gamesJsonArray = new JsonArray();
        for (Game g : games) {
            gamesJsonArray.add(g.getTitle());
        }
        jsonObject.add("games", gamesJsonArray);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(String.valueOf(jsonObject));
            System.out.println("Exportado a JSON");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
