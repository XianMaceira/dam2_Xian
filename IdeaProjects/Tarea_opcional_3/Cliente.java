package Tarea_opcional_3;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URI;

public class Cliente {
    public static void main(String[] args) {
        try {
            String host = "127.0.0.7"; // Cambia esto por la dirección del servidor web que deseas visitar
            int port = 8080; // Puerto HTTP estándar

            // Construir la petición HTTP
            String request = "GET / HTTP/1.1\r\n" +
                    "Host: " + host + "\r\n" +
                    "Connection: close\r\n\r\n";

            // Crear el socket y establecer la conexión
            Socket socket = new Socket(host, port);

            // Obtener flujos de entrada y salida del socket
            OutputStream outputStream = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Enviar la petición HTTP al servidor
            outputStream.write(request.getBytes());
            outputStream.flush();

            // Leer la respuesta del servidor
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line).append("\n");
            }

            // Mostrar la respuesta en la consola
            System.out.println("Respuesta del servidor:\n" + response.toString());

            // Abrir el navegador predeterminado con la URL
            openInBrowser("http://" + host);

            // Cerrar las conexiones
            outputStream.close();
            reader.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void openInBrowser(String url) {
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
