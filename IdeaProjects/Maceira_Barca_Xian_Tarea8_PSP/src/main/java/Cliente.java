import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        final String servidorIP = "127.0.0.1";
        final int puerto = 12345;

        try {
            for (int i = 1; i <= 5; i++) {
                try (Socket socket = new Socket(servidorIP, puerto)) {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                    // Enviar la IP al servidor
                    out.println(InetAddress.getLocalHost().getHostAddress());

                    // Leer la respuesta del servidor
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    System.out.println("Respuesta del servidor: " + in.readLine());

                    if (i == 5) {
                        // Enviar "Exit" al servidor en la quinta conexión
                        out.println("Exit");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
