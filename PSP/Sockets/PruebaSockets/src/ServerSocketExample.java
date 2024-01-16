import java.io.*;
import java.net.*;

public class ServerSocketExample {
    public static void main(String[] args) {

        final int portNumber = 8080;

        try {

            ServerSocket serverSocket = new ServerSocket(portNumber);

            System.out.println("Servidor conectado, esperando a por clientes");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Cliente Conectado: " + clientSocket);

            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter out = new PrintWriter(outputStream, true);

            String clientMessage = in.readLine();
            System.out.println("Cliente dice: " + clientMessage);

            out.println("Muy Buenas cliente, he recibito tu mensaje.");

            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}