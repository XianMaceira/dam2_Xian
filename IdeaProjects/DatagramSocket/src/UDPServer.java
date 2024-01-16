import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) {
        try {
            // Crear un DatagramSocket para escuchar en un determinado puerto:
            DatagramSocket serverSocket = new DatagramSocket(8080);

            // crear un byte arrray para almacenar los datos:
            byte[] receiveData = new byte[1024];

            System.out.println("Servidor UDP a la escucha. Esperando a por datos...");

            while (true) {
                // Crear un DatagramPacket para recibir el paquete
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                // Recibir el paquete del cliente
                serverSocket.receive(receivePacket);

                // Extraer los datos del paquete:
                String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("recibido del cliente: " + receivedMessage);

                // La dirección del cliente y el puerto:
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                // Se puede enviar una respuesta al cliente
                String responseMessage = "Hola, cliente UDP !";
                byte[] responseData = responseMessage.getBytes();

                // Creamos un DatagramPacket para respoder al cliente
                DatagramPacket sendPacket = new DatagramPacket(responseData, responseData.length, clientAddress, clientPort);

                // enviamos la respuesta al cliente
                serverSocket.send(sendPacket);

                System.out.println("respuesta al cliente: " + responseMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
