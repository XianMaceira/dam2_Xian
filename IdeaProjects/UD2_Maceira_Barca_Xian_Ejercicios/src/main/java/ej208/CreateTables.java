package ej208;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {
    static void createTables(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS songs (" +
                    "id INTEGER PRIMARY KEY," +
                    "title VARCHAR," +
                    "artist VARCHAR," +
                    "duration INTEGER," +
                    "year INTEGER)");

            statement.execute("CREATE TABLE IF NOT EXISTS users(" +
                    "id INTEGER PRIMARY KEY," +
                    "username VARCHAR UNIQUE," +
                    "name VARCHAR," +
                    "mail VARCHAR)");

            statement.execute("CREATE TABLE IF NOT EXISTS playlists (" +
                    "id INTEGER PRIMARY KEY," +
                    "playlist_name VARCHAR," +
                    "user_id INTEGER REFERENCES users(id))");

            statement.execute("CREATE TABLE IF NOT EXISTS songs_playlists (" +
                    "id INTEGER PRIMARY KEY," +
                    "song_id INTEGER REFERENCES songs(id)," +
                    "playlist_id INTEGER REFERENCES playlists(id))");
        }
    }
}
