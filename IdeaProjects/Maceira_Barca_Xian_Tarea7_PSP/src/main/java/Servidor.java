import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("Servidor de calculadora iniciado. Esperando conexiones...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado desde " + clientSocket.getInetAddress().getHostAddress());

                InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream();

                byte[] buffer = new byte[1024];
                int bytesRead = inputStream.read(buffer);
                String clientMessage = new String(buffer, 0, bytesRead);
                System.out.println("Mensaje del cliente: " + clientMessage);

                String serverResponse = processCalculationRequest(clientMessage);

                outputStream.write(serverResponse.getBytes());

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String processCalculationRequest(String request) {

        String[] tokens = request.split(",");
        int num1 = Integer.parseInt(tokens[0].trim());
        int num2 = Integer.parseInt(tokens[1].trim());
        String operator = tokens[2].trim();

        int result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                return "Operador no válido";
        }

        return String.valueOf(result);
    }
}
