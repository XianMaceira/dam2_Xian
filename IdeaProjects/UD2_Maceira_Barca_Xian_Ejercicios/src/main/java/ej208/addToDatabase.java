package ej208;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;
import java.util.Scanner;

public class addToDatabase {

    static void createPlaylist() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:gestionMusica.db")) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Nombre de la playlist: ");
            String playlist = scanner.nextLine();
            System.out.print("ID del usuario que va a crear la lista: ");
            int user_id = scanner.nextInt();

            if (userExists(user_id, connection)) {
                try (PreparedStatement ps = connection.prepareStatement(
                        "INSERT INTO playlists (playlist_name, user_id) VALUES (?, ?)")) {
                    ps.setString(1, playlist);
                    ps.setInt(2, user_id);
                    ps.executeUpdate();
                    System.out.println("Lista de reproducción creada.");
                }
            } else {
                System.err.println("El usuario con ID " + user_id + " no existe.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void deletePlaylist() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:gestionMusica.db")) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("ID de la lista de reproducción a eliminar: ");
            int id_playlist = scanner.nextInt();

            if (playlistExists(id_playlist, connection)) {
                try (PreparedStatement psSong = connection.prepareStatement(
                        "DELETE FROM songs_playlists WHERE playlist_id = ?")) {
                    psSong.setInt(1, id_playlist);
                    psSong.executeUpdate();

                    try (PreparedStatement psList = connection.prepareStatement(
                            "DELETE FROM playlists WHERE id = ?")) {
                        psList.setInt(1, id_playlist);
                        psList.executeUpdate();
                        System.out.println("Lista de reproducción eliminada con éxito.");
                    }
                }
            } else {
                System.err.println("La lista de reproducción con ID " + id_playlist + " no existe.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void addSongToPlaylist() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:gestionMusica.db")) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("ID de la playlist: ");
            int playlist_id = scanner.nextInt();

            if (playlistExists(playlist_id, connection)) {
                System.out.print("ID de la canción: ");
                int song_id = scanner.nextInt();

                if (songExists(song_id, connection)) {
                    try (PreparedStatement ps = connection.prepareStatement(
                            "INSERT INTO songs_playlists (song_id, playlist_id) VALUES (?, ?)")) {
                        ps.setInt(1, song_id);
                        ps.setInt(2, playlist_id);
                        ps.executeUpdate();
                        System.out.println("Canción agregada a la playlist.");
                    }
                } else {
                    System.err.println("La canción con ID " + song_id + " no existe.");
                }
            } else {
                System.err.println("La playlist con ID " + playlist_id + " no existe.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void addSong() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:gestionMusica.db")) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Introduce los datos de la canción que vas a introducir: ");
            System.out.println("----------------");
            System.out.println();
            System.out.print("Título: ");
            String title = scanner.nextLine();
            System.out.print("Artista: ");
            String artist = scanner.nextLine();
            System.out.print("Duración(segundos): ");
            int duration = scanner.nextInt();
            System.out.print("Año de lanzamiento: ");
            int year = scanner.nextInt();

            try (PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO songs (title, artist, duration, year) VALUES (?, ?, ?, ?)")) {
                ps.setString(1, title);
                ps.setString(2, artist);
                ps.setInt(3, duration);
                ps.setInt(4, year);
                ps.executeUpdate();
                System.out.println("Canción agregada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void addUser() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:gestionMusica.db")) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Introduce los datos del usuario que vas a introducir: ");
            System.out.println("----------------");
            System.out.println();
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Nombre real: ");
            String name = scanner.nextLine();
            System.out.print("Correo electrónico: ");
            String mail = scanner.nextLine();

            try (PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO users (username, name, mail) VALUES (?, ?, ?)")) {
                ps.setString(1, username);
                ps.setString(2, name);
                ps.setString(3, mail);
                ps.executeUpdate();
                System.out.println("Usuario agregado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void write(XMLStreamWriter xmlStreamWriter, String elementName, String elementValue) throws XMLStreamException {
        xmlStreamWriter.writeStartElement(elementName);
        xmlStreamWriter.writeCharacters(elementValue);
        xmlStreamWriter.writeEndElement();
    }

    private static void exportSongsToXML(Connection connection) throws SQLException, XMLStreamException, IOException {
        try (PreparedStatement ps = connection.prepareStatement(
                "SELECT * FROM songs");
             ResultSet rs = ps.executeQuery();
             OutputStream outputStream = new FileOutputStream("songs.xml")) {

            XMLStreamWriter xmlStreamWriter = XMLOutputFactory.newInstance().createXMLStreamWriter(outputStream);
            xmlStreamWriter.writeStartDocument();
            xmlStreamWriter.writeStartElement("songs");

            while (rs.next()) {
                xmlStreamWriter.writeStartElement("song");
                xmlStreamWriter.writeAttribute("id", String.valueOf(rs.getInt("id")));
                write(xmlStreamWriter, "title", rs.getString("title"));
                write(xmlStreamWriter, "artist", rs.getString("artist"));
                write(xmlStreamWriter, "duration", String.valueOf(rs.getInt("duration")));
                write(xmlStreamWriter, "year", String.valueOf(rs.getInt("year")));
                xmlStreamWriter.writeEndElement();
            }

            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();
            xmlStreamWriter.close();
        }
    }

    private static void exportPlaylistsToXML(Connection connection) throws SQLException, XMLStreamException, IOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM playlists");
             ResultSet resultSet = preparedStatement.executeQuery();
             OutputStream outputStream = new FileOutputStream("playlists.xml")) {

            XMLStreamWriter xmlStreamWriter = XMLOutputFactory.newInstance().createXMLStreamWriter(outputStream);
            xmlStreamWriter.writeStartDocument();
            xmlStreamWriter.writeStartElement("palylists");

            while (resultSet.next()) {
                xmlStreamWriter.writeStartElement("playlist");
                xmlStreamWriter.writeAttribute("id", String.valueOf(resultSet.getInt("id")));
                write(xmlStreamWriter, "playlist_name", resultSet.getString("nombre_lista"));
                write(xmlStreamWriter, "user_id", String.valueOf(resultSet.getInt("id_usuario")));
                xmlStreamWriter.writeEndElement();
            }

            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();
            xmlStreamWriter.close();
        }
    }

    private static void exportarUsuariosAXML(Connection connection) throws SQLException, XMLStreamException, IOException {
        try (PreparedStatement ps = connection.prepareStatement(
                "SELECT * FROM users");
             ResultSet rs = ps.executeQuery();
             OutputStream outputStream = new FileOutputStream("users.xml")) {

            XMLStreamWriter xmlStreamWriter = XMLOutputFactory.newInstance().createXMLStreamWriter(outputStream);
            xmlStreamWriter.writeStartDocument();
            xmlStreamWriter.writeStartElement("users");

            while (rs.next()) {
                xmlStreamWriter.writeStartElement("user");
                xmlStreamWriter.writeAttribute("id", String.valueOf(rs.getInt("id")));
                write(xmlStreamWriter, "username", rs.getString("username"));
                write(xmlStreamWriter, "name", rs.getString("name"));
                write(xmlStreamWriter, "mail", rs.getString("mail"));
                xmlStreamWriter.writeEndElement();
            }

            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();
            xmlStreamWriter.close();
        }
    }



    static void exportToXML() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:gestionMusica.db")) {
            exportSongsToXML(connection);
            exportarUsuariosAXML(connection);
            exportPlaylistsToXML(connection);

            System.out.println("Datos exportados a archivos XML.");

        } catch (SQLException | XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void showSongs(Connection connection) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(
                "SELECT * FROM songs")) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Título: " + rs.getString("title"));
                System.out.println("Artista: " + rs.getString("artist"));
                System.out.println("Duración: " + rs.getInt("duration"));
                System.out.println("Año de lanzamiento: " + rs.getInt("year"));
                System.out.println();
            }
        }
    }

    private static void showUsers(Connection connection) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM users")) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nombre de usuario: " + rs.getString("username"));
                System.out.println("Nombre real: " + rs.getString("name"));
                System.out.println("Correo electrónico: " + rs.getString("mail"));
                System.out.println("----------------------");
            }
        }
    }

    private static void showPlaylists(Connection connection) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(
                "SELECT * FROM listas_reproduccion")) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nombre de la playlist: " + rs.getString("playlist_name"));
                System.out.println("ID del usuario: " + rs.getInt("user_id"));
                System.out.println("----------------------");
            }
        }
    }

    static void showInfo() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:gestionMusica.db")) {
            System.out.println("Usuarios");
            System.out.println("-------------");
            System.out.println();
            showUsers(connection);

            System.out.println("Canciones");
            System.out.println("-------------");
            System.out.println();
            showSongs(connection);

            System.out.println("Playlists");
            System.out.println("-------------");
            System.out.println();
            showPlaylists(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean songExists(int song_id, Connection connection) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT 1 FROM songs WHERE id = ?")) {
            preparedStatement.setInt(1, song_id);
            return preparedStatement.executeQuery().next();
        }
    }

    private static boolean userExists(int user_id, Connection connection) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT 1 FROM users WHERE id = ?")) {
            preparedStatement.setInt(1, user_id);
            return preparedStatement.executeQuery().next();
        }
    }

    private static boolean playlistExists(int playlist_id, Connection connection) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT 1 FROM playlists WHERE id = ?")) {
            preparedStatement.setInt(1, playlist_id);
            return preparedStatement.executeQuery().next();
        }
    }


}
