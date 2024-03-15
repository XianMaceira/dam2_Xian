package ej208;



import java.io.FileReader;
import com.fasterxml.jackson.core.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class loadFromJSON {
    static void loadFromJSON() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:gestionMusica.db");
             FileReader fileReader = new FileReader("208.json");
             JsonParser jsonParser = new JsonFactory().createParser(fileReader)) {

            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();
                if ("canciones".equals(fieldName)) {
                    jsonParser.nextToken();
                    while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                        String title = null;
                        String artist = null;
                        int duration = 0;
                        int year = 0;

                        while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                            String field = jsonParser.getCurrentName();
                            jsonParser.nextToken();

                            switch (field) {
                                case "title":
                                    title = jsonParser.getText();
                                    break;
                                case "artist":
                                    artist = jsonParser.getText();
                                    break;
                                case "year":
                                    year = jsonParser.getIntValue();
                                    break;
                                case "duration":
                                    duration = jsonParser.getIntValue();
                                    break;
                            }
                        }

                        try (PreparedStatement ps = connection.prepareStatement(
                                "INSERT INTO songs (title, artist, duration, year) VALUES (?, ?, ?, ?)")) {
                            ps.setString(1, title);
                            ps.setString(2, artist);
                            ps.setInt(3, duration);
                            ps.setInt(4, year);
                            ps.executeUpdate();
                        }
                    }
                } else if ("users".equals(fieldName)) {
                    jsonParser.nextToken();
                    while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                        String username = null;
                        String name = null;
                        String mail = null;

                        while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                            String field = jsonParser.getCurrentName();
                            jsonParser.nextToken();

                            switch (field) {
                                case "username":
                                    username = jsonParser.getText();
                                    break;
                                case "name":
                                    name = jsonParser.getText();
                                    break;
                                case "mail":
                                    mail = jsonParser.getText();
                                    break;
                            }
                        }

                        try (PreparedStatement preparedStatement = connection.prepareStatement(
                                "INSERT INTO users (username, name, mail) VALUES (?, ?, ?)")) {
                            preparedStatement.setString(1, username);
                            preparedStatement.setString(2, name);
                            preparedStatement.setString(3, mail);
                            preparedStatement.executeUpdate();
                        }
                    }
                }
            }

            System.out.println("JSON cargado y almacenado.");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
