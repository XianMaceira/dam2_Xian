import java.io.*;
import java.net.*;

public class ClientSocketExample {
    public static void main(String[] args) {

        final String serverAddress = "192.168.2.111";
        final int serverPort = 8080;

        try {

            Socket clientSocket = new Socket(serverAddress, serverPort);

            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter out = new PrintWriter(outputStream, true);

            out.println("Hola Servidor!!");

            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

            String serverResponse = in.readLine();
            System.out.println("Servidor dice: " + serverResponse);

            out.close();
            in.close();
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
