import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 8080;

            String message = "abcdefghij";

            byte[] sendData = message.getBytes();

            for (byte b : sendData) {
                DatagramPacket sendPacket = new DatagramPacket(new byte[]{b}, 1, serverAddress, serverPort);

                clientSocket.send(sendPacket);

                System.out.println("Enviado al servidor: " + (char) b);

                byte[] receiveData = new byte[2];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                clientSocket.receive(receivePacket);

                String confirmation = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Confirmación del servidor: " + confirmation);

                Thread.sleep(1000);
            }

            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
