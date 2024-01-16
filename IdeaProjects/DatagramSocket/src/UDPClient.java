import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) {
        try {
            // Crea un DatagramSocket para el cliente
            DatagramSocket clientSocket = new DatagramSocket();

            // Se toman los valores de la dirección del servidor y el puerto.
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 8080;

            // Mensaje par enviar:
            String message = "Muy buenas, Servidor UDP!";

            // Se convierte el mensaje a bytes:
            byte[] sendData = message.getBytes();

            // Create a DatagramPacket para enviar los datos:
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);

            // Enviar el paquete al servidor:
            clientSocket.send(sendPacket);

            System.out.println("Mensaje enviado al servidor: " + message);

            // Creamos un DatagramPacket para recibir los datos
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            // Recibir datos:
            clientSocket.receive(receivePacket);

            // Convertir los datos recibidos a un String:
            String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Respuesta del servidor: " + serverResponse);

            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
