import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(8080);
            byte[] receiveData = new byte[1];
            System.out.println("Servidor UDP a la escucha. Esperando a por datos...");

            while (true) {

                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                serverSocket.receive(receivePacket);

                char receivedChar = (char) receivePacket.getData()[0];
                System.out.println("Recibido del cliente: " + receivedChar);

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                String confirmationMessage = "OK";
                byte[] confirmationData = confirmationMessage.getBytes();

                DatagramPacket confirmationPacket = new DatagramPacket(confirmationData, confirmationData.length, clientAddress, clientPort);

                serverSocket.send(confirmationPacket);

                System.out.println("Confirmación enviada al cliente.");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
