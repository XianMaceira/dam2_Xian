import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        final int puerto = 12345;

        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor esperando conexiones en el puerto " + puerto);

            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("Cliente conectado desde la IP: " + clientSocket.getInetAddress());

                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                    String clienteIP = in.readLine();
                    System.out.println("IP recibida del cliente: " + clienteIP);

                    if (clienteIP.equals(clientSocket.getInetAddress().getHostAddress())) {
                        out.println("Respuesta del servidor: IP correcta");
                    } else {
                        out.println("Respuesta del servidor: IP incorrecta");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
