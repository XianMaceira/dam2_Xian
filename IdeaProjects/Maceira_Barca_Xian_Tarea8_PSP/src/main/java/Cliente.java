import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        final int PORT = 12345;

        try {
            for (int i = 1; i <= 5; i++) {
                Socket socket = new Socket("localhost", PORT);

                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                String clientIP = socket.getLocalAddress().getHostAddress();

                writer.println(clientIP);

                String serverResponse = reader.readLine();
                System.out.println("Respuesta del servidor: " + serverResponse);

                socket.close();

                if (i == 5) {
                    socket = new Socket("localhost", PORT);
                    writer = new PrintWriter(socket.getOutputStream(), true);
                    writer.println("Exit");
                    socket.close();
                }

                Thread.sleep(1000);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
