import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class JSON {
    public static void exportAllGamesJSON (App app, Collection<Game> games, File outPutFile) {
        int totalGames = games.size();
        int delGames = 0;
        for (Game game : games) {
            if (game.isDeleted()) {
                delGames++;
            }
        }

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("total", totalGames);
        jsonObject.addProperty("deleted", delGames);

        JsonArray jsonArray = new JsonArray();
        for (Game game : games) {
            jsonArray.add(game.getTitle());
        }
        jsonObject.add("games", jsonArray);
    }
}
