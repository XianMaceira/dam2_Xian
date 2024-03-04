package Tarea_opcional_3;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
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
            //Thread.sleep(100);
            String htmlContent = readHtmlFromFile("C:\\Users\\dam2_alu10\\Documents\\DAM-2\\Procesos\\Proyectos Java\\Procesos\\src\\Web.html");
            //System.out.println(htmlContent);

            String response = "HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n" + htmlContent;
            //dkfsdlnsdlfnsdlfns lskdnfsldknfsldkfnsldfns
            outputStream.write(response.getBytes());

        in.close(); out.close();
        clientSocket.close();
        serverSocket.close();
    } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readHtmlFromFile(String filepath){

        StringBuilder content = new StringBuilder();

        try(BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            String line;
            while ((line = reader.readLine()) != null){
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}